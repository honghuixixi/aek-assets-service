package com.aek.ebey.assets.web.controller;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.jeecgframework.poi.excel.ExcelExportUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.params.ExcelExportEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.aek.common.core.BeanMapper;
import com.aek.common.core.Result;
import com.aek.common.core.base.BaseController;
import com.aek.common.core.exception.ExceptionFactory;
import com.aek.common.core.serurity.JwtTokenUtil;
import com.aek.common.core.serurity.WebSecurityUtils;
import com.aek.common.core.serurity.model.AuthUser;
import com.aek.common.core.serurity.model.TokenInfo;
import com.aek.common.core.support.HttpCode;
import com.aek.common.core.util.DataUtil;
import com.aek.common.core.util.DateUtil;
import com.aek.common.core.util.DateUtil.DATE_PATTERN;
import com.aek.ebey.assets.constant.SysConstant;
import com.aek.ebey.assets.core.easypoi.style.ExcelExportStatisticStyler;
import com.aek.ebey.assets.core.jackson.annotation.AllowProperty;
import com.aek.ebey.assets.core.jackson.annotation.IgnoreProperties;
import com.aek.ebey.assets.core.util.CommonUtils;
import com.aek.ebey.assets.enums.AssetsStatusEnum;
import com.aek.ebey.assets.model.Assets;
import com.aek.ebey.assets.model.AssetsCount;
import com.aek.ebey.assets.model.AssetsInfo;
import com.aek.ebey.assets.model.AssetsInfoExt;
import com.aek.ebey.assets.model.AssetsNumAndMoney;
import com.aek.ebey.assets.model.AssetsPm;
import com.aek.ebey.assets.model.AssetsSource;
import com.aek.ebey.assets.model.AssetsTag;
import com.aek.ebey.assets.model.Contract;
import com.aek.ebey.assets.model.DeptNameAndUserName;
import com.aek.ebey.assets.model.Feilds;
import com.aek.ebey.assets.model.query.AssertReportQuery;
import com.aek.ebey.assets.model.query.LedgerPaging;
import com.aek.ebey.assets.model.query.PmAssertPaging;
import com.aek.ebey.assets.model.request.AssetsCurveRequest;
import com.aek.ebey.assets.model.request.AssetsInfoRequest;
import com.aek.ebey.assets.model.request.AssetsTagBatchResponse;
import com.aek.ebey.assets.model.request.AssetsTagResponse;
import com.aek.ebey.assets.model.request.EditAssetsInfoRequest;
import com.aek.ebey.assets.model.request.TenantAssets;
import com.aek.ebey.assets.model.vo.AssetsCurveVo;
import com.aek.ebey.assets.model.vo.AssetsScanVO;
import com.aek.ebey.assets.model.vo.AssetsStats2Vo;
import com.aek.ebey.assets.model.vo.AssetsStatsVo;
import com.aek.ebey.assets.service.AssetsInfoExtService;
import com.aek.ebey.assets.service.AssetsInfoService;
import com.aek.ebey.assets.service.AssetsTagService;
import com.aek.ebey.assets.service.feign.UserClientService;
import com.aek.ebey.assets.service.feign.vo.TenantVo;
import com.aek.ebey.assets.web.report.AssetsExcelVo;
import com.aek.ebey.assets.web.report.AssetsImportThread;
import com.aek.ebey.assets.web.report.ExcelUtil;
import com.aek.ebey.assets.web.report.UploadResult;
import com.aek.ebey.assets.web.request.AssetsInfoDetailReponse;
import com.aek.ebey.assets.web.request.AssetsLedgerInfoReponse;
import com.aek.ebey.assets.web.request.AssetsPmInfoResponse;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.plugins.Page;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;

/**
 * 
 * 台账控制器
 */
@RestController
@Api(value = "AssetsInfoController", description = "台账")
@RequestMapping("/assets/assetsInfo")
public class AssetsInfoController extends BaseController {

	@Autowired
	private AssetsInfoService assetsInfoService;
	@Autowired
	private AssetsInfoExtService assetsInfoExtService;
	@Autowired
	private AssetsTagService assetsTagService;
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	@Autowired
	private RedisTemplate<String, String> redisTemplate;
	@Autowired
	private UserClientService userClientService;

	/**
	 * 更新设备名称
	 */
	@ApiOperation(value = "更新设备名称{ 'assetssId': 1,'assetsName': 1}")
	@ApiResponse(code = 0, message = "OK", response = Result.class)
	@RequestMapping(value = "/updateAssetsName", method = RequestMethod.POST)
	public Result<Object> updateAssetsName(@RequestBody Map<String,Object> params) {
		logger.debug(JSON.toJSONString(params));
		assetsInfoService.updateAssetsName(params);
		return response();
	}

	/**
	 *
	 * @param params
	 * @return 更新设备生产商
	 */
	@ApiOperation(value = "更新设备生产商{ 'assetssId': 1,'factoryName': 1}")
	@ApiResponse(code = 0, message = "OK", response = Result.class)
	@RequestMapping(value = "/updateFactoryName", method = RequestMethod.POST)
	public Result<Object> updateFactoryName(@RequestBody Map<String,Object> params) {
		logger.debug(JSON.toJSONString(params));
		assetsInfoExtService.updateFactoryName(params);
		return response();
	}
	/**
	 * 
	 * @param params
	 * @return 批量更新设备状态
	 */
	@ApiOperation(value = "批量更新设备状态{ 'assetssIds': [3,10],'status': 1}")
	@ApiResponse(code = 0, message = "OK", response = Result.class)
	@RequestMapping(value = "/updateBatchAssetsStatus", method = RequestMethod.POST)
	public Result<Object> updateBatchAssetsStatus(@RequestBody Map<String,Object> params) {
		logger.debug(JSON.toJSONString(params));
		assetsInfoService.updateBatchAssetsStatus(params);
		return response();
	}
	/**
	 * 
	 * @return 批量设置部门
	 */
	@ApiOperation(value = "批量设置设备部门{ 'assetssIds': [3,10],'deptId': 1,'applyDeptId': 1,'manageDeptId': 1}")
	@ApiResponse(code = 0, message = "OK", response = Result.class)
	@RequestMapping(value = "/updateBatchAssetsDepartment", method = RequestMethod.POST)
	public Result<Object> updateBatchAssetsDepartment(@RequestBody Map<String,Object> params) {
		logger.debug(JSON.toJSONString(params));
		assetsInfoService.updateBatchAssetsDepartment(params);
		return response();
	}

	/**
	 * @return 根据ID查询设备状态
	 */
	@ApiOperation(value = "根据ID查询设备状态", httpMethod = "POST")
	@ApiResponse(code = 0, message = "OK", response = Result.class)
	@RequestMapping(value = "/getAssetsInfoById/{id}", method = RequestMethod.GET)
	public Result<Integer> getAssetsInfoById(@PathVariable Long id) {
		AssetsInfo assetsInfo = assetsInfoService.selectById(id);
		if (assetsInfo != null) {
			return response(assetsInfo.getStatus());
		} else {
			throw ExceptionFactory.create("A_006");
		}
	}

	/**
	 * 
	 * @return 根据tenantid统计资产数跟维修数
	 */
	@PreAuthorize("hasAuthority('ASS_ASSETS_NEW')")
	@ApiOperation(value = "新建台帐")
	@ApiResponse(code = 0, message = "OK", response = Result.class)
	@RequestMapping(value = "/addAssets", method = RequestMethod.POST)
	public Result<Object> addAssets(@RequestBody AssetsInfoRequest data) {
		logger.debug(JSON.toJSONString(data));
		if(data.getDeptId()==null){
			throw ExceptionFactory.create("A_015");
		}
		assetsInfoService.addAssetsInfo(data);
		return response();
	}

	/**
	 * 编辑台账
	 */
	@PreAuthorize("hasAuthority('ASS_ASSETS_EDIT')")
	@ApiOperation(value = "台账编辑", httpMethod = "POST")
	@ApiResponse(code = 0, message = "OK", response = Result.class)
	@RequestMapping(value = "/editAssets", method = RequestMethod.POST)
	public Result<Object> editAssets(@RequestBody EditAssetsInfoRequest request) {
		logger.debug(JSON.toJSONString(request));
		AssetsInfo assetsInfo = BeanMapper.map(request, AssetsInfo.class);
		assetsInfo.setId(request.getAssetsId());
		assetsInfo.setPrice(CommonUtils.fromY2X(request.getPriceD()));
		AssetsInfoExt assetsInfoExt = BeanMapper.map(request, AssetsInfoExt.class);
		assetsInfoExt.setSingleBudget(CommonUtils.fromY2X(assetsInfoExt.getSingleBudgetStr()));
		Contract contract = BeanMapper.map(request, Contract.class);
		contract.setContractPrice(CommonUtils.fromY2X(contract.getContractPriceStr()));
		assetsInfoService.editAssets(assetsInfo, assetsInfoExt,request,contract,null);
		return response();
	}
	
	/**
	 * 根据tenantid统计资产数跟维修数
	 */
	@ApiOperation(value = "根据tenantid统计资产数跟维修数")
	@ApiResponse(code = 0, message = "OK", response = Result.class)
	@RequestMapping(value = "/getAssetsCount", method = RequestMethod.GET)
	public Result<List<AssetsCount>> getAssetsCount(@RequestParam(required = false,name="tenantId") Long tenantid) {
		logger.debug(tenantid);
		List<AssetsCount> assetsCount = assetsInfoService.getAssetsCount(tenantid);
		return response(assetsCount);
	}

	/**
	 * 
	 * 根据tenantid统计资产数跟资产金额
	 */
	@ApiOperation(value = "根据tenantid统计资产数跟资产金额")
	@ApiResponse(code = 0, message = "OK", response = Result.class)
	@RequestMapping(value = "/getAssetsNumAndMoney", method = RequestMethod.GET)
	public Result<AssetsNumAndMoney> getAssetsNumAndMoney(@RequestParam(required = false,name="tenantId") Long tenantid) {
		AssetsNumAndMoney assetsNumAndMoney = assetsInfoService.getAssetsNumAndMoney(tenantid);
		if(assetsNumAndMoney!=null){
			assetsNumAndMoney.setSumPrice(CommonUtils.fromX2Y(Long.parseLong(assetsNumAndMoney.getSumPrice())));
		}
		return response(assetsNumAndMoney);
	}

	/**
	 * 预台账详情查询 
	 */
	@PreAuthorize("hasAuthority('ASS_PREASSETS_DETAILED_VIEW')")
	@ApiOperation(value = "预台账详情查询", httpMethod = "GET")
	@ApiResponse(code = 0, message = "OK", response = Result.class)
	@RequestMapping(value = "/getAssetsDetail", method = RequestMethod.GET)
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "台账id", paramType = "query", required = true) })
	public Result<AssetsInfoDetailReponse> getAssetsDetail(Long id) {
		logger.debug(id);
		Assets assets = assetsInfoService.getAssetsDetail(id);
		if(assets==null){
			return response(null);
		}
		return response(BeanMapper.map(assets, AssetsInfoDetailReponse.class));
	}

	/**
	 * 资产台账的状态数量查询
	 */
	@PreAuthorize("isAuthenticated()")
	@ApiOperation(value = "资产台账的状态数量查询", httpMethod = "GET")
	@ApiResponse(code = 0, message = "OK", response = Result.class)
	@RequestMapping(value = "/getAssetsStatusNum", method = RequestMethod.GET)
	public Result<Object> getAssetsStatusNum() {
		String token = WebSecurityUtils.getCurrentToken();
		TokenInfo authInfo = jwtTokenUtil.getTokenInfo(token);
		List<Map<String, Object>> pm = assetsInfoService.getAssetsStatusNum(authInfo.getTenantId());
		return response(pm);
	}
	
	
	/**
	 * 获取资产台账的状态值及状态描述
	 */
	@PreAuthorize("isAuthenticated()")
	@ApiOperation(value = "获取资产台账的状态值及状态描述", httpMethod = "GET")
	@ApiResponse(code = 0, message = "OK", response = Result.class)
	@RequestMapping(value = "getAssetsStatusForSelect", method = RequestMethod.GET)
	public Result<Object> getAssetsStatusForSelect() {
		List<Map<String, Object>> pm = new ArrayList<Map<String,Object>>();
		Map<String,Object> inStore = new HashMap<String,Object>();
		inStore.put("status", AssetsStatusEnum.IN_STORE.getNumber());
		inStore.put("statusName", AssetsStatusEnum.IN_STORE.getDesc());
		Map<String,Object> inUse = new HashMap<String,Object>();
		inUse.put("status", AssetsStatusEnum.IN_USE.getNumber());
		inUse.put("statusName", AssetsStatusEnum.IN_USE.getDesc());
		Map<String,Object> pre = new HashMap<String,Object>();
		pre.put("status", AssetsStatusEnum.PRE_REGISTRATION.getNumber());
		pre.put("statusName", AssetsStatusEnum.PRE_REGISTRATION.getDesc());
		Map<String,Object> unReportLoss = new HashMap<String,Object>();
		unReportLoss.put("status", AssetsStatusEnum.UN_REPORT_LOSS.getNumber());
		unReportLoss.put("statusName", AssetsStatusEnum.UN_REPORT_LOSS.getDesc());
		Map<String,Object> reportLoss = new HashMap<String,Object>();
		reportLoss.put("status", AssetsStatusEnum.REPORT_LOSS.getNumber());
		reportLoss.put("statusName", AssetsStatusEnum.REPORT_LOSS.getDesc());
		Map<String,Object> refund = new HashMap<String,Object>();
		refund.put("status", AssetsStatusEnum.REFUND.getNumber());
		refund.put("statusName", AssetsStatusEnum.REFUND.getDesc());
		pm.add(inStore);
		pm.add(inUse);
		pm.add(pre);
		pm.add(unReportLoss);
		pm.add(reportLoss);
		pm.add(refund);
		return response(pm);
	}
	
	/**
	 * 获取资产台账的状态值及状态描述
	 */
	@PreAuthorize("isAuthenticated()")
	@ApiOperation(value = "获取资产台账的状态值及状态描述", httpMethod = "GET")
	@ApiResponse(code = 0, message = "OK", response = Result.class)
	@RequestMapping(value = "getAssetsStatus", method = RequestMethod.GET)
	public Result<Object> getAssetsStatus() {
		List<Map<String, Object>> pm = new ArrayList<Map<String,Object>>();
		Map<String,Object> inStore = new HashMap<String,Object>();
		inStore.put("status", AssetsStatusEnum.IN_STORE.getNumber());
		inStore.put("statusName", AssetsStatusEnum.IN_STORE.getDesc());
		Map<String,Object> inUse = new HashMap<String,Object>();
		inUse.put("status", AssetsStatusEnum.IN_USE.getNumber());
		inUse.put("statusName", AssetsStatusEnum.IN_USE.getDesc());
		Map<String,Object> pre = new HashMap<String,Object>();
		pre.put("status", AssetsStatusEnum.PRE_REGISTRATION.getNumber());
		pre.put("statusName", AssetsStatusEnum.PRE_REGISTRATION.getDesc());
//		Map<String,Object> unReportLoss = new HashMap<String,Object>();
//		unReportLoss.put("status", AssetsStatusEnum.UN_REPORT_LOSS.getNumber());
//		unReportLoss.put("statusName", AssetsStatusEnum.UN_REPORT_LOSS.getDesc());
//		Map<String,Object> reportLoss = new HashMap<String,Object>();
//		reportLoss.put("status", AssetsStatusEnum.REPORT_LOSS.getNumber());
//		reportLoss.put("statusName", AssetsStatusEnum.REPORT_LOSS.getDesc());
//		Map<String,Object> refund = new HashMap<String,Object>();
//		refund.put("status", AssetsStatusEnum.REFUND.getNumber());
//		refund.put("statusName", AssetsStatusEnum.REFUND.getDesc());
		pm.add(inStore);
		pm.add(inUse);
		pm.add(pre);
//		pm.add(unReportLoss);
//		pm.add(reportLoss);
//		pm.add(refund);
		return response(pm);
	}
	
	/**
	 * 获取资产台账和验收通过的预台账的状态值及状态描述
	 */
	@PreAuthorize("isAuthenticated()")
	@ApiOperation(value = "获取资产台账和验收通过的预台账的状态值及状态描述", httpMethod = "GET")
	@ApiResponse(code = 0, message = "OK", response = Result.class)
	@RequestMapping(value = "getAssetsVerifyStatus", method = RequestMethod.GET)
	public Result<Object> getAssetsAndVerifyPreAssetsStatus() {
		List<Map<String, Object>> pm = new ArrayList<Map<String,Object>>();
		Map<String,Object> preVerifyAssets = new HashMap<String,Object>();
		preVerifyAssets.put("status", AssetsStatusEnum.VERIFY.getNumber());
		preVerifyAssets.put("statusName", AssetsStatusEnum.VERIFY.getDesc());
		Map<String,Object> inStore = new HashMap<String,Object>();
		inStore.put("status", AssetsStatusEnum.IN_STORE.getNumber());
		inStore.put("statusName", AssetsStatusEnum.IN_STORE.getDesc());
		Map<String,Object> inUse = new HashMap<String,Object>();
		inUse.put("status", AssetsStatusEnum.IN_USE.getNumber());
		inUse.put("statusName", AssetsStatusEnum.IN_USE.getDesc());
		Map<String,Object> pre = new HashMap<String,Object>();
		pre.put("status", AssetsStatusEnum.PRE_REGISTRATION.getNumber());
		pre.put("statusName", AssetsStatusEnum.PRE_REGISTRATION.getDesc());
		Map<String,Object> unReportLoss = new HashMap<String,Object>();
		unReportLoss.put("status", AssetsStatusEnum.UN_REPORT_LOSS.getNumber());
		unReportLoss.put("statusName", AssetsStatusEnum.UN_REPORT_LOSS.getDesc());
		pm.add(preVerifyAssets);
		pm.add(inStore);
		pm.add(inUse);
		pm.add(pre);
		pm.add(unReportLoss);
		return response(pm);
	}

	/**
	 * 资产台账的生成方式数量查询
	 */
	@PreAuthorize("isAuthenticated()")
	@ApiOperation(value = "资产台账的生成方式数量查询【来源】", httpMethod = "GET")
	@ApiResponse(code = 0, message = "OK", response = Result.class)
	@RequestMapping(value = "getAssetsSourceNum", method = RequestMethod.GET)
	public Result<AssetsSource> getAssetsSourceNum() {
		String token = WebSecurityUtils.getCurrentToken();
		TokenInfo tokenInfo = jwtTokenUtil.getTokenInfo(token);
		// 资产台账的生成方式数量查询
		AssetsSource pm = assetsInfoService.getAssetsSourceNum(tokenInfo.getTenantId());
		if (pm == null) {
			return response(null);
		}
		return response(pm);
	}

	/**
	 * 台账列表查询
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PreAuthorize("hasAuthority('ASS_ASSETS_LIST_VIEW')")
	@RequestMapping(value = "/getLedgerPage", method = RequestMethod.GET)
	@ApiOperation(value = "台账列表查询", httpMethod = "GET", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiImplicitParams({ @ApiImplicitParam(name = "status", value = "状态：1=在库、2=在用、3=预登、4=待报损、5=报损、6=退货", paramType = "query"),
		@ApiImplicitParam(name = "deptId", value = "科室", paramType = "query"),
		@ApiImplicitParam(name = "assetsSource", value = "来源，0：入库新增，1：批量导入 2:验收录入 3:清查录入", paramType = "query"),
		@ApiImplicitParam(name = "page.current", value = "当前页", paramType = "query", required = true),
		@ApiImplicitParam(name = "page.size", value = "每页数量", paramType = "query", required = true),
		@ApiImplicitParam(name = "sort", value = "排序【1:默认排序  2：单价由高到低排序 3：单价由低到高排序", paramType = "query"),
		@ApiImplicitParam(name = "keyword", value = "关键字(设备名称/编号)", paramType = "query") })
	@ApiResponse(code = 0, message = "OK", response = Result.class)
	public Result<Object> getLedgerPage(@ApiParam(hidden = true) LedgerPaging query) {
		logger.debug(JSON.toJSONString(query));
		String token = WebSecurityUtils.getCurrentToken();
		TokenInfo tokenInfo = jwtTokenUtil.getTokenInfo(token);
		query.setTenantId(tokenInfo.getTenantId());
		Page page = this.assetsInfoService.getLedgerPage(query.getPage(), query);
		List<AssetsLedgerInfoReponse> list = BeanMapper.mapList(page.getRecords(), AssetsLedgerInfoReponse.class);
		page.setRecords(list);
		return response(page);
	}
	
	/**
	 * 新建转科单列表查询
	 */
	@PreAuthorize("hasAuthority('ASS_ASSETS_ZK_APPLY')")
	@ApiOperation(value = "新建转科单列表查询", httpMethod = "GET")
	@IgnoreProperties(allow = { @AllowProperty(pojo = Assets.class, name = { "assetsId","assetsName","assetsImg","assetsNum",
			"repairId","assetsSpec","splName","deptId","startUseDate","status","statusName","unitName","deptName","repairStatus","scrapDate","unitId","factoryName","serialNum" }) })
	@GetMapping(value = "/manageTreeTable")
	@ApiImplicitParams({ @ApiImplicitParam(name = "status", value = "状态：1=在库、2=在用、3=预登、4=待报损、5=报损、6=退货", paramType = "query"),
		@ApiImplicitParam(name = "deptId", value = "科室", paramType = "query"),
		@ApiImplicitParam(name = "page.current", value = "当前页", paramType = "query", required = true),
		@ApiImplicitParam(name = "page.size", value = "每页数量", paramType = "query", required = true),
		@ApiImplicitParam(name = "keyword", value = "关键字(设备名称/编号)", paramType = "query") })
	@RequestMapping(value = "/getTransferPage", method = RequestMethod.GET)
	@ApiResponse(code = 0, message = "OK", response = Result.class)
	public Result<Page<Assets>> getTransferPage(LedgerPaging query){
		Page<Assets> transferPage = assetsInfoService.getTransferPage(query);
		return response(transferPage);
	}
	
	// @PreAuthorize("hasAuthority('ASS_ASSETS_EXPORT')")
	@ApiOperation(value = "台账导出", httpMethod = "GET")
	@ApiImplicitParams({ @ApiImplicitParam(name = "data", value = "导出哪些数据 1:当前 2:全部  [默认当前]", paramType = "query"),
		@ApiImplicitParam(name = "colum", value = "导出字段 多字段逗号分隔", paramType = "query"),
		@ApiImplicitParam(name = "sort", value = "排序【1:默认排序  2：单价由高到低排序 3：单价由低到高排序】", paramType = "query"),
		@ApiImplicitParam(name = "status", value = "状态【1在库、2在用、4维修中、6已报废】", paramType = "query"),
		@ApiImplicitParam(name = "deptId", value = "科室", paramType = "query"),
		@ApiImplicitParam(name = "assetsSource", value = "来源", paramType = "query"),
		@ApiImplicitParam(name = "keyword", value = "关键字(设备名称/编号)", paramType = "query"),
		@ApiImplicitParam(name = "ids", value = "被选中资产id集合", paramType = "query") })
	@ApiResponse(code = 0, message = "OK", response = Result.class)
	@RequestMapping(value = "/exportAssert", method = RequestMethod.GET)
	public Result<Object> exportAssert(HttpServletRequest request, HttpServletResponse response, AssertReportQuery query)
			throws IOException {
		logger.debug(JSON.toJSONString(query));
		// 告诉浏览器用什么软件可以打开此文件
		// response.setHeader("content-Type", "application/vnd.ms-excel");
		response.setContentType("application/vnd.ms-excel;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		// 下载文件的默认名称
		String fileName = "资产台账list_" + DateUtil.format(new Date(), DATE_PATTERN.YYYYMMDDHHMMSS) + ".xls";
		String header = request.getHeader("User-Agent").toUpperCase();
        if (header.contains("MSIE") || header.contains("TRIDENT") || header.contains("EDGE")) {
            fileName = URLEncoder.encode(fileName, "UTF-8");
            //IE下载文件名空格变+号问题
            fileName = fileName.replace("+", "%20");
        } else {
            fileName = new String(fileName.getBytes(), "ISO8859-1");
        }
		response.setHeader("Content-disposition", "attachment; filename=\"" + fileName + "\"");
		List<ExcelExportEntity> entity = new ArrayList<ExcelExportEntity>();
		if (DataUtil.isNotEmpty(query.getColum())) {
			String[] colum = query.getColum().split(",");
			for (String s : colum) {
				String[] clms = s.split("\\.");
				if (clms.length > 1) {
					s = clms[1];
				} else {
					s = clms[0];
				}
				ExcelExportEntity excelentity = new ExcelExportEntity(SysConstant.REPORT_DATA_MAP.get(s), s);
				excelentity.setWidth(16);
				entity.add(excelentity);
			}
		}
		AuthUser authUser = WebSecurityUtils.getCurrentUser();
		query.setSysId(authUser.getTenantId());
		List<Map<String, Object>> mapList = assetsInfoService.getReportAssetsList(query);
		if (mapList == null || mapList.size() == 0) {
			return null;
		}
		ExportParams params = new ExportParams("1.第1、2行为固定结构，不可更改；第3～4行为示例，导入前请删除\n\t2.列标题不可修改，将鼠标移动到第2行单元格上，查看填写规则",
				"说明");

		params.setStyle(ExcelExportStatisticStyler.class);
		Workbook workbook = ExcelExportUtil.exportExcel(params, entity, mapList);
		workbook.write(response.getOutputStream());
		return response();
	}

	@PreAuthorize("isAuthenticated()")
	@ApiOperation(value = "台账导出字段", httpMethod = "GET")
	@RequestMapping(value = "/fieldDisplay", method = RequestMethod.GET)
	public Result<List<Feilds>> fieldDisplay() {
		return response(assetsInfoService.fieldDisplay());
	}

	@ApiOperation(value = "台账导入进度条", httpMethod = "GET")
	@GetMapping("/getProgressBar")
	public Result<Object> getProgressBar(@RequestParam("id") String uploadId){
		ValueOperations<String, String> opsForValue = redisTemplate.opsForValue();
		String uploadResultJson = opsForValue.get(SysConstant.CacheKey.ASSETS_IMPORT_PREFIX + uploadId);
		if(StringUtils.isNotBlank(uploadResultJson)){
			UploadResult uploadResult = JSON.parseObject(uploadResultJson, UploadResult.class);
			return response(uploadResult);
		}
		return response(new UploadResult());
	}

	// @PreAuthorize("hasAuthority('ASS_ASSETS_IMPORT')")
	@PreAuthorize("isAuthenticated()")
	@ApiOperation(value = "台账导入", httpMethod = "POST")
	@RequestMapping(value = "/import", method = RequestMethod.POST)
	public Result<Object> importExcel(@RequestParam("file") MultipartFile file, @RequestParam("id") String uploadId) throws Exception {
		logger.debug("importExcelId="+uploadId);
		Workbook book = null;
		try {
			book = WorkbookFactory.create(file.getInputStream());
		} catch (Exception e) {
			ExceptionFactory.create("A_014", "");
		}
		String token=WebSecurityUtils.getCurrentToken();
		AuthUser authUser=WebSecurityUtils.getCurrentUser();
		new Thread(new AssetsImportThread(book, uploadId, token, authUser)).start();
		return response();
	}

	@ApiOperation("台账曲线图")
	@PostMapping("/queryAssetsCurve")
	public Result<Object> queryAssetsCurve(@Valid @RequestBody AssetsCurveRequest req) {
		logger.debug(JSON.toJSONString(req));
		if (StringUtils.isBlank(req.getDateLabel())) {
			if (req.getStartDate() == null || req.getEndDate() == null) {
				return new Result<Object>(HttpCode.BAD_REQUEST.value().toString(), "开始时间和结束时间不能为空.");
			}
			if (req.getStartDate().after(req.getEndDate())) {
				return new Result<Object>(HttpCode.BAD_REQUEST.value().toString(), "开始时间不能晚于结束时间.");
			}
		}
		List<AssetsCurveVo> vos = this.assetsInfoService.queryAssetsCurve1(req);
		return response(vos);
	}

	@GetMapping("/getQRCode/{id}")
	@ApiOperation("获取设备二维码")
	public void getQRCode(@PathVariable Long id, HttpServletResponse response) throws Exception {
		int width = 140;
		int height = 140;
		String format = "png";
		Map<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>();
		hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
		hints.put(EncodeHintType.MARGIN, 1);
		BitMatrix bitMatrix = new MultiFormatWriter().encode(String.valueOf(id), BarcodeFormat.QR_CODE, width, height, hints);
		response.setContentType("image/png");
		MatrixToImageWriter.writeToStream(bitMatrix, format, response.getOutputStream());
	}

	@GetMapping("/getTemplate")
	@ApiOperation("下载资产导入模板")
	public void getTemplate(HttpServletRequest request,HttpServletResponse response) {
		try {
			HSSFWorkbook workbook = ExcelUtil.getImportTemplt(AssetsExcelVo.class);
			response.setContentType("multipart/form-data");
			String fileName = "资产台账导入模板.xls";
			String header = request.getHeader("User-Agent").toUpperCase();
	        if (header.contains("MSIE") || header.contains("TRIDENT") || header.contains("EDGE")) {
	            fileName = URLEncoder.encode(fileName, "UTF-8");
	            //IE下载文件名空格变+号问题
	            fileName = fileName.replace("+", "%20");
	        } else {
	            fileName = new String(fileName.getBytes(), "ISO8859-1");
	        }
			response.setHeader("Content-disposition", "attachment; filename=\"" + fileName + "\"");
			workbook.write(response.getOutputStream());
		} catch (Exception e) {
			logger.error("download temeplate error.", e);
			throw ExceptionFactory.create("A_008");
		}
	}

	@GetMapping("/getErrorData")
	@ApiOperation("下载批量导入失败Excel文件")
	public void getErrorData(@RequestParam("id") String uploadId, HttpServletResponse response) {
		try {
			AuthUser authUser=WebSecurityUtils.getCurrentUser();
			String errorData = redisTemplate.opsForValue().get("Assets:ErrorFile:"+authUser.getMobile()+":" + uploadId);
			List<AssetsExcelVo> voList = JSON.parseArray(errorData, AssetsExcelVo.class);
			HSSFWorkbook workbook = ExcelUtil.getWorkbook(AssetsExcelVo.class, voList.toArray(new AssetsExcelVo[] {}));
			response.setContentType("multipart/form-data");
			String fileName = "导入失败数据_"+DateUtil.format(new Date(), DateUtil.DATE_PATTERN.YYYYMMDDHHMMSS) + ".xls";
			response.setHeader("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes(), "iso8859-1"));
			workbook.write(response.getOutputStream());
		} catch (Exception e) {
			logger.error("download batch excel error.", e);
			throw ExceptionFactory.create("A_012");
		}
	}

	@GetMapping("/delErrorData")
	@ApiOperation("删除批量导入失败Excel文件")
	public Result<Object> delErrorData(@RequestParam("id") String uploadId) {
		try {
			AuthUser authUser=WebSecurityUtils.getCurrentUser();
			redisTemplate.opsForValue().set("Assets:ErrorFile:"+authUser.getMobile()+":" + uploadId, "", 1, TimeUnit.SECONDS);
		} catch (Exception e) {
			logger.error("delete batch excel error.", e);
		}
		return response(null);
	}

	@GetMapping("/getAssetsByTenantIds")
	@ApiOperation("根据TenantIds统计资产")
	public Result<List<TenantAssets>> getAssetsByTenantIds(@RequestParam("ids") Long[] ids) {
		logger.debug(JSON.toJSONString(ids));
		Assert.notNull(ids, ids+"请求参数为空");
		List<TenantAssets> list=assetsInfoService.getAssetsByTenantIds(ids);
		return response(list);
	}

	/**
	 * 台账列表查询（监管树）
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/getPageAssets", method = RequestMethod.GET)
	@ApiOperation(value = "台账列表查询（监管树）", httpMethod = "GET", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiImplicitParams({ @ApiImplicitParam(name = "status", value = "状态：1=在库、2=在用、3=预登、4=待报损、8 验收通过", paramType = "query"),
		@ApiImplicitParam(name = "deptId", value = "科室", paramType = "query"),
		@ApiImplicitParam(name = "tenantId", value = "机构id", paramType = "query"),
		@ApiImplicitParam(name = "assetsSource", value = "来源，0：入库新增，1：批量导入 2:新建", paramType = "query"),
		@ApiImplicitParam(name = "page.current", value = "当前页", paramType = "query", required = true),
		@ApiImplicitParam(name = "page.size", value = "每页数量", paramType = "query", required = true),
		@ApiImplicitParam(name = "sort", value = "排序【1:默认排序  2：单价由高到低排序 3：单价由低到高排序", paramType = "query"),
		@ApiImplicitParam(name = "keyword", value = "关键字(设备名称/编号)", paramType = "query") })
	@ApiResponse(code = 0, message = "OK", response = Result.class)
	public Result<Object> getPageAssets(@ApiParam(hidden = true) LedgerPaging query) {
		logger.debug(JSON.toJSONString(query));
		// 获取数据权限
		query.setDataScope(WebSecurityUtils.getCurrentUser().getDataScope());
		Page page = this.assetsInfoService.getPageAssets(query.getPage(), query);
		List<AssetsLedgerInfoReponse> list = BeanMapper.mapList(page.getRecords(), AssetsLedgerInfoReponse.class);
		page.setRecords(list);
		return response(page);
	}
	
	@PreAuthorize("isAuthenticated()")
	@ApiOperation(value = "根据机构ID、部门ID、关键字查询可加入PM计划设备列表", httpMethod = "GET")
	@GetMapping("/getPmAssetsList")
	@ApiImplicitParams({
		@ApiImplicitParam(name="departmentId",value="机构部门ID",paramType="query",required=false),
		@ApiImplicitParam(name="keyword",value="设备名称/设备编号",paramType="query",required=false)
	})
	public Result<List<AssetsPmInfoResponse>> getPmAssetsList(@RequestParam(value="departmentId", required=false)Long departmentId,@RequestParam(value="keyword", required=false)String keyword) {
		logger.debug(">>>>>根据机构ID、部门ID、关键字查询可加入PM计划设备列表<<<<<<");
		AuthUser authUser = WebSecurityUtils.getCurrentUser();
		logger.debug("查询参数：departmentId = " + departmentId);
		logger.debug("查询参数：keyword = " + keyword);
		logger.debug("当前机构：tenantId = " +  authUser.getTenantId());
		List<AssetsPm> assetsQcList = assetsInfoService.getPmAssetsList(authUser.getTenantId(),departmentId,keyword);
		List<AssetsPmInfoResponse> list = BeanMapper.mapList(assetsQcList, AssetsPmInfoResponse.class);
		return response(list);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PreAuthorize("isAuthenticated()")
	@ApiOperation(value = "根据机构ID、部门ID、关键字查询可加入PM计划设备分页列表", httpMethod = "GET")
	@GetMapping("/getPmAssetsPage")
	@ApiImplicitParams({
		@ApiImplicitParam(name="departmentId",value="机构部门ID",paramType="query",required=false),
		@ApiImplicitParam(name="keyword",value="设备名称/设备编号",paramType="query",required=false)
	})
	public Result<Page<AssetsPmInfoResponse>> getPmAssetsPage(@ApiParam(hidden = true) PmAssertPaging query) {
		logger.debug(">>>>>根据机构ID、部门ID、关键字查询可加入PM计划设备分页列表<<<<<<");
		AuthUser authUser = WebSecurityUtils.getCurrentUser();
		logger.debug("查询参数：departmentId = " + query.getDepartmentId());
		logger.debug("查询参数：keyword = " + query.getKeyword());
		logger.debug("当前机构：tenantId = " +  authUser.getTenantId());
		Page page = assetsInfoService.getPmAssetsPage(query.getPage(),query,authUser.getTenantId());
		List<AssetsPmInfoResponse> list = BeanMapper.mapList(page.getRecords(), AssetsPmInfoResponse.class);
		page.setRecords(list);
		return response(page);
	}
	
	@PreAuthorize("isAuthenticated()")
	@ApiOperation(value = "获取当前机构资产标签打印内容", httpMethod = "GET")
	@GetMapping("/getAssetsPrintTag/{assetsId}")
	public Result<AssetsTagResponse> getAssetsTag(@PathVariable(value = "assetsId", required = true) Long assetsId){
		logger.debug(">>>>>获取资产标签打印内容<<<<<<");
		AuthUser authUser = WebSecurityUtils.getCurrentUser();
		logger.debug("当前机构：tenantId = " +  authUser.getTenantId());
		AssetsTag assetsTag = assetsTagService.getCurrentAssetsTag(authUser.getTenantId());
		Map<String,Object> assetsData = assetsInfoService.selectListSql(assetsTag.getAssetsSql()+assetsId);
		// 给资产标签数据添加机构和资产部门信息
		getTenantAndDeptInfo4AssetsTagData(assetsTag,assetsData,assetsId);
		AssetsTagResponse assetsTagResponse = BeanMapper.map(assetsTag, AssetsTagResponse.class);
		assetsTagResponse.setAssetsData(assetsData);
		return response(assetsTagResponse);
	}
	
	@PreAuthorize("isAuthenticated()")
	@ApiOperation(value = "批量获取当前机构资产标签打印内容", httpMethod = "GET")
	@GetMapping("/getAssetsPrintTag")
	public Result<AssetsTagBatchResponse> getAssetsTagBatch(@RequestParam(value="assetsIds", required=true)Long[] assetsIds){
		logger.debug(">>>>>获取资产标签打印内容<<<<<<");
		AuthUser authUser = WebSecurityUtils.getCurrentUser();
		logger.debug("当前机构：tenantId = " +  authUser.getTenantId());
		AssetsTag assetsTag = assetsTagService.getCurrentAssetsTag(authUser.getTenantId());
		List<Map<String,Object>> assetsDataList = new ArrayList<Map<String,Object>>();
		for (Long assetsId : assetsIds) {
			Map<String,Object> assetsData = assetsInfoService.selectListSql(assetsTag.getAssetsSql()+assetsId);
			// 给资产标签数据添加机构和资产部门信息
			getTenantAndDeptInfo4AssetsTagData(assetsTag,assetsData,assetsId);
			assetsDataList.add(assetsData);
		}
		AssetsTagBatchResponse assetsTagResponse = BeanMapper.map(assetsTag, AssetsTagBatchResponse.class);
		assetsTagResponse.setAssetsDataList(assetsDataList);
		return response(assetsTagResponse);
	}

	/**
	 * 给资产标签数据添加机构与资产部门信息
	 * @param assetsTag
	 * @param assetsData
	 */
	public void getTenantAndDeptInfo4AssetsTagData(AssetsTag assetsTag,Map<String,Object> assetsData,Long assetsId) {
		if(null != assetsData && assetsData.containsKey("deptId") && null != assetsData.get("deptId")){
			Result<List<DeptNameAndUserName>> result = userClientService.findByDeptIds(assetsData.get("deptId").toString(),WebSecurityUtils.getCurrentToken());
			if(null != result){
				List<DeptNameAndUserName> list = result.getData();
				if(null != list){
					assetsData.put("deptName", list.get(0).getName());
					assetsData.remove("deptId");
				}
			}
		}
		if(null != assetsTag && assetsTag.getContent().contains("tenantName")){
			AssetsInfo assetsInfo = assetsInfoService.selectById(assetsId);
			Result<TenantVo> result = userClientService.findTenantById(assetsInfo.getSysId(), WebSecurityUtils.getCurrentToken());
			if(null != result && null != result.getData()){
				TenantVo tenantVo = result.getData();
				if(null == assetsData){
					assetsData = new HashMap<>();
				}
				assetsData.put("tenantName", tenantVo.getName());
			}
		}
	}

    @PreAuthorize("isAuthenticated()")
    @ApiOperation(value = "根据扫码内容获取资产信息", httpMethod = "GET")
    @ApiResponse(code = 0, message = "OK", response = Result.class)
    @RequestMapping(value = "/getAssetsByScanResult", method = RequestMethod.GET)
    @ApiImplicitParams({@ApiImplicitParam(name = "scanResult", value = "扫码内容(资产ID/院内编码)",paramType = "query", required = true)})
    public Result<AssetsScanVO> getAssetsByScanResult(String scanResult) {
        AuthUser authUser = WebSecurityUtils.getCurrentUser();
        AssetsScanVO assetsScanVO = assetsInfoService.getAssetsInfoByScanResult(scanResult, authUser.getTenantId());
        return response(assetsScanVO);
    }

}
