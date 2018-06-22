package com.aek.ebey.assets.web.report;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import com.aek.common.core.BeanMapper;
import com.aek.common.core.Result;
import com.aek.common.core.exception.ExceptionFactory;
import com.aek.common.core.serurity.model.AuthUser;
import com.aek.ebey.assets.constant.SysConstant;
import com.aek.ebey.assets.core.util.SpringContextUtil;
import com.aek.ebey.assets.model.AssetsFundSources;
import com.aek.ebey.assets.model.AssetsInfo;
import com.aek.ebey.assets.model.AssetsInfoExt;
import com.aek.ebey.assets.model.CodeInfo;
import com.aek.ebey.assets.service.AssetsInfoService;
import com.aek.ebey.assets.service.CodeInfoService;
import com.aek.ebey.assets.service.feign.UserClientService;
import com.aek.ebey.assets.service.feign.vo.DeptVo;
import com.aek.ebey.assets.service.utils.AuthUserUtil;
import com.alibaba.fastjson.JSON;

public class AssetsImportTask implements Callable<Map<String, Object>> {

	private static Logger logger = LoggerFactory.getLogger(AssetsImportTask.class);

	private Sheet sheet;
	private int startIndex;
	private int endIndex;
	private Map<Integer,Field> columnType;
	private String uploadId;
	private String token;
	private AuthUser authUser;
	private RedisTemplate<String, String> redisTemplate;
	private AssetsInfoService assetsInfoService;
	private UserClientService userClientService;
	private CodeInfoService codeInfoService;

	public AssetsImportTask(Sheet sheet, int startIndex, int endIndex, Map<Integer, Field> columnType, String uploadId, String token, AuthUser authUser) {
		super();
		this.sheet = sheet;
		this.startIndex = startIndex;
		this.endIndex = endIndex;
		this.columnType = columnType;
		this.uploadId = uploadId;
		this.token = token;
		this.authUser = authUser;
		this.redisTemplate = SpringContextUtil.getBean(StringRedisTemplate.class);
		this.assetsInfoService = SpringContextUtil.getBean(AssetsInfoService.class);
		this.userClientService = SpringContextUtil.getBean(UserClientService.class);
		this.codeInfoService = SpringContextUtil.getBean(CodeInfoService.class);
	}

	private void importExcel(Map<String, Object> retMap){
		Map<Integer, Integer> accountBookMap = new HashMap<Integer, Integer>();
		Map<String, Long> deptMap = new HashMap<String, Long>();
		Map<String, String> fundSourceMap = this.codeInfoService.getCodeInfoMap(SysConstant.FUND_SOURCES);
		List<AssetsExcelVo> voList = new ArrayList<>();
		List<AssetsExcelVo> errorList = new ArrayList<>();
		int count = 0;
		//是否有错误数据
		List<AssetsExcelVo> errList = new ArrayList<>();
		int cellSize = columnType.size();// 列数
		BigDecimal perAdd = new BigDecimal(30).divide(new BigDecimal(endIndex-startIndex+1), 5, RoundingMode.DOWN);//进度90%
		for (int rowIndex = startIndex; rowIndex <= endIndex; rowIndex++) {// 遍历行
			logger.debug("rowIndex="+rowIndex);
			Row row = sheet.getRow(rowIndex);
			if (row == null) {// 略过空行
				continue;
			}
			AssetsExcelVo assetsExcelVo = new AssetsExcelVo();
			StringBuilder errorMsg = new StringBuilder();
			int msgIndex=1;
			boolean blank=true;
			for (int colIndex = 0; colIndex < cellSize; colIndex++) {
				Cell cell = row.getCell(colIndex);
				try {
					if(cell != null&&StringUtils.isNotBlank(cell.getStringCellValue())){
						blank=false;
					}
				} catch (Exception e1) {
					blank=false;
				}
				Object value = null;
				Field field = columnType.get(colIndex);
				String message = null;
				try {
					if (cell != null) {
						value = ExcelUtil.getCellValue(cell, field);
					}
					message = AssetsImportUtil.setFieldValue(field, assetsExcelVo, value);
					if(field.getName().equals("deptName")&&StringUtils.isNotBlank(assetsExcelVo.getDeptName())){
						this.setDeptName(deptMap, assetsExcelVo);
						if(assetsExcelVo.getDeptId()==null){
							message="所在部门（必填）:"+assetsExcelVo.getDeptName()+"不存在.";
						}
						/*if(assetsExcelVo.getDeptId()!=null&&!AuthUserUtil.hasPower(assetsExcelVo.getDeptId(),authUser)){
							message="所在部门（必填）:你不能新建该"+assetsExcelVo.getDeptName()+"的数据.";
						}*/
					}
				} catch (Exception e) {
					String exMsg = "row=" + rowIndex + ", col=" + colIndex + ", field=" + field.getName() + ", val=" + value;
					logger.error(exMsg, e);
					message = "请检查数据格式是否正确.";
				}
				if (StringUtils.isNotBlank(message)) {// invalid column
					errorMsg.append(msgIndex).append(".").append(message).append("\n");
					msgIndex++;
					List<Integer> errorCols = assetsExcelVo.getErrorCols();
					if(errorCols==null){
						errorCols = new ArrayList<Integer>();
					}
					errorCols.add(colIndex);
					assetsExcelVo.setErrorCols(errorCols);
				}
			}
			if (!blank) {
				if (StringUtils.isNotBlank(errorMsg.toString())) {
					assetsExcelVo.setMessage(errorMsg.toString());
					errorList.add(assetsExcelVo);
					errList.add(assetsExcelVo);
				} else {
					voList.add(assetsExcelVo);
					errList.add(assetsExcelVo);
					count++;
					/*if(count>=1000&&errorList.size()==0){
						addAssets(accountBookMap, fundSourceMap, voList);
						voList.clear();
					}*/
				}
			}
			String uploadResultJson = this.redisTemplate.opsForValue().get(SysConstant.CacheKey.ASSETS_IMPORT_PREFIX + uploadId);
			UploadResult uploadResult = JSON.parseObject(uploadResultJson, UploadResult.class);
			if(uploadResult==null){
				uploadResult=new UploadResult();
			}
			BigDecimal bd = new BigDecimal(uploadResult.getProgress()).add(perAdd).setScale(5, RoundingMode.DOWN);
			uploadResult.setProgress(bd.toString());
			this.redisTemplate.opsForValue().set(SysConstant.CacheKey.ASSETS_IMPORT_PREFIX + uploadId, JSON.toJSONString(uploadResult));
		}
		retMap.put("0", errorList);
		retMap.put("1", count);
		retMap.put("2", errList);
		if (!voList.isEmpty()&&errorList.size()==0) {
			UploadResult uploadResult = new UploadResult();
			uploadResult.setProgress("93");
			this.redisTemplate.opsForValue().set(SysConstant.CacheKey.ASSETS_IMPORT_PREFIX + uploadId, JSON.toJSONString(uploadResult));
			addAssets(accountBookMap, fundSourceMap, voList);
			uploadResult.setProgress("95");
			this.redisTemplate.opsForValue().set(SysConstant.CacheKey.ASSETS_IMPORT_PREFIX + uploadId, JSON.toJSONString(uploadResult));
			voList.clear();
		}
	}

	private void addAssets(Map<Integer, Integer> accountBookMap, Map<String, String> fundSourceMap,List<AssetsExcelVo> voList) {
		List<AssetsInfo> assetInfos = new ArrayList<>();
		List<AssetsInfoExt> assetExts = new ArrayList<>();
		for (AssetsExcelVo ass : voList) {
			AssetsInfo info = BeanMapper.map(ass, AssetsInfo.class);
			AssetsInfoExt ext = BeanMapper.map(ass, AssetsInfoExt.class);
			List<AssetsFundSources> fundList = new ArrayList<>();
			if (ass.getFundSourcesId()!=null) {
				AssetsFundSources fundSource = new AssetsFundSources();
				fundSource.setFundSourcesId(ass.getFundSourcesId());
				fundSource.setFundSourceMoney(ass.getPrice());
				fundSource.setFundSourcesText(fundSourceMap.get(ass.getFundSourcesId().toString()));
				fundList.add(fundSource);
			}
			info.setFundList(fundList);
			this.setAccountBook(accountBookMap, info);
			assetInfos.add(info);
			assetExts.add(ext);
		}
		assetsInfoService.addAssetsByImport(assetInfos, assetExts, uploadId, token, authUser);
	}

	private void setDeptName(Map<String, Long> deptMap, AssetsExcelVo info) {
		String deptName = info.getDeptName();
		Long deptId = null;
		if (deptMap.containsKey(deptName)) {
			deptId = deptMap.get(deptName);
		} else {
			deptId = getDeptIdByName(authUser.getTenantId(), token, deptName);
		}
		if (deptId != null) {
			info.setDeptId(deptId.intValue());
		}
		deptMap.put(deptName, deptId);
	}

	private void setAccountBook(Map<Integer, Integer> accountBookMap, AssetsInfo info) {
		//核算类别取账簿类型
		if(info.getAssetsTypeId()==null&&info.getAssetsClassId()!=null){
			if (!accountBookMap.containsKey(info.getAssetsClassId().intValue())) {
				CodeInfo codeInfo = this.codeInfoService.selectByTypeValue(SysConstant.ACCOUNT_CATEGORY, String.valueOf(info.getAssetsClassId()));
				if (codeInfo != null) {
					CodeInfo codeInfo2 = this.codeInfoService.selectById(codeInfo.getParentCodeId());
					if (codeInfo2 != null) {
						info.setAssetsTypeId(Integer.valueOf(codeInfo2.getCodeValue()));
					}
				}
				accountBookMap.put(info.getAssetsClassId(), info.getAssetsTypeId());
			}else{
				info.setAssetsTypeId(accountBookMap.get(info.getAssetsClassId().intValue()));
			}
		}
	}

	private Long getDeptIdByName(Long tenantId, String token, String deptName) {
		Long deptId = null;
		Result<List<DeptVo>> result = userClientService.findDeptNameById(tenantId, token, deptName);
		if (result != null && "200".equals(result.getCode())) {
			List<DeptVo> data = result.getData();
			if (data != null && data.size() > 0 && data.get(0) != null) {
				deptId = data.get(0).getId();
			}
		}
		return deptId;
	}

	@Override
	public Map<String, Object> call() throws Exception {
		Map<String, Object> retMap = new HashMap<String, Object>();
		importExcel(retMap);
		return retMap;
	}
}
