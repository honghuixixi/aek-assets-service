package com.aek.ebey.assets.service.impl;

import com.aek.ebey.assets.constant.ArchiveConstant;
import com.aek.ebey.assets.constant.SysConstant;
import com.aek.ebey.assets.core.util.ArchiveUtil;
import com.aek.ebey.assets.core.util.CommonUtils;
import com.aek.ebey.assets.mapper.AssArchiveMapper;
import com.aek.ebey.assets.model.AssArchive;
import com.aek.ebey.assets.model.CodeInfo;
import com.aek.ebey.assets.model.DeptNameAndUserName;
import com.aek.ebey.assets.model.bo.ArchiveAssetBo;
import com.aek.ebey.assets.model.query.ArchiveDiscardQuery;
import com.aek.ebey.assets.model.query.ArchivePageQuery;
import com.aek.ebey.assets.model.query.ArchiveTransferQuery;
import com.aek.ebey.assets.model.query.NewArchiveQuery;
import com.aek.ebey.assets.model.vo.ArchiveDiscardVo;
import com.aek.ebey.assets.model.vo.ArchivePageVo;
import com.aek.ebey.assets.model.vo.ArchiveTransferVo;
import com.aek.ebey.assets.model.vo.AssetArchiveDetailVo;
import com.aek.ebey.assets.model.vo.AssetArchiveVo;
import com.aek.ebey.assets.model.vo.AssetBasicInfoVo;
import com.aek.ebey.assets.model.vo.PreEditArchiveVo;
import com.aek.ebey.assets.service.AssArchiveService;
import com.aek.ebey.assets.service.CodeInfoService;
import com.aek.ebey.assets.service.feign.UserClientService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.aek.common.core.BeanMapper;
import com.aek.common.core.Result;
import com.aek.common.core.base.BaseServiceImpl;
import com.aek.common.core.exception.ExceptionFactory;
import com.aek.common.core.serurity.WebSecurityUtils;
import com.aek.common.core.serurity.model.AuthUser;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 设备档案表 服务实现类
 * </p>
 *
 * @author cyl
 * @since 2018-04-25
 */
@Service
@Transactional
public class AssArchiveServiceImpl extends BaseServiceImpl<AssArchiveMapper,AssArchive> implements AssArchiveService {

	@Autowired
	private AssArchiveMapper assArchiveMapper;
	
	@Autowired
	private UserClientService userClientService;
	
	@Autowired
	private CodeInfoService codeInfoService;
	
	@Override
	public Page<AssetArchiveVo> getNewArchiveAssetsList(NewArchiveQuery query) {
		Page<AssetArchiveVo> page = query.getPage();
		AuthUser currentUser = WebSecurityUtils.getCurrentUser();
		String keyword = StringUtils.trimToNull(query.getKeyword());
		if(keyword !=null){
			if (keyword.startsWith("%") || keyword.startsWith("[") || keyword.startsWith("[]") || keyword.startsWith("_")) {
				query.setKeyword('\\'+keyword);
			}
		}
		List<AssetArchiveVo> list = assArchiveMapper.getNewArchiveAssetsList(page,currentUser, query);
		if(list!=null&&list.size()>0){
			Set<Long> deptIds = new HashSet<Long>();
			for (AssetArchiveVo li : list) {
				if (li.getDeptId() != null) {
					deptIds.add(li.getDeptId());
				}
			}
			StringBuffer assetsDeptIdsStr = new StringBuffer("");
			for (Long deptId : deptIds) {
				assetsDeptIdsStr.append(deptId + ",");
			}
			if (assetsDeptIdsStr != null && !assetsDeptIdsStr.equals("")) {
				Map<String, String> deptNameMap = findDeptNameToMap(assetsDeptIdsStr.toString());
				for (AssetArchiveVo li : list) {
					if (deptNameMap != null) {
						li.setDeptName(deptNameMap.get("" + li.getDeptId()));
					}
				}
			}
		}
		page.setRecords(list);
		return page;
	}
	
	/**
	 * 查找部门名称
	 */
	public Map<String, String> findDeptNameToMap(String ids) {
		Map<String, String> map = new HashMap<>();
		if (ids != null && !ids.equals(""))// 获取部门名称，存入map
		{
			Result<List<DeptNameAndUserName>> deptName = userClientService.findByDeptIds(ids, WebSecurityUtils.getCurrentToken());
			if (deptName != null && deptName.getData() != null && deptName.getData().size() != 0) {
				for (DeptNameAndUserName dname : deptName.getData()) {
					map.put("" + dname.getId(), dname.getName());// dname.getName());//id为KEY，名称为
					// value
				}
			}
		}
		return map;
	}

	@Override
	public void addArchive(AssArchive archive) {
		AuthUser currentUser = WebSecurityUtils.getCurrentUser();
		Long tenantId = currentUser.getTenantId();
		archive.setArchiveNum(ArchiveUtil.ArchiveNo());
		Date now = new Date();
		archive.setCreateTime(now);
		archive.setTenantId(tenantId);
		archive.setUpdateTime(now);
		//档案名称验重
		Wrapper<AssArchive> wrapper = new EntityWrapper<AssArchive>();
		wrapper.eq("tenant_id", tenantId)
				.eq("archive_name", archive.getArchiveName());
		int n = assArchiveMapper.selectCount(wrapper);
		if(n>0)throw ExceptionFactory.create("AR_010");
		assArchiveMapper.insert(archive);
	}

	@Override
	public void editArchive(AssArchive archive) {
		AssArchive archiveDb = assArchiveMapper.selectById(archive.getId());
		if(archiveDb==null)throw ExceptionFactory.create("AR_011");
		String archiveNameDb = archiveDb.getArchiveName();
		String archiveName = archive.getArchiveName();
		if(!archiveNameDb.equals(archiveName)){
			AuthUser currentUser = WebSecurityUtils.getCurrentUser();
			Long tenantId = currentUser.getTenantId();
			//档案名称验重
			Wrapper<AssArchive> wrapper = new EntityWrapper<AssArchive>();
			wrapper.eq("tenant_id", tenantId)
					.eq("archive_name", archiveName);
			int n = assArchiveMapper.selectCount(wrapper);
			if(n>0)throw ExceptionFactory.create("AR_010");
		}	
		archive.setUpdateTime(new Date());
		assArchiveMapper.updateById(archive);
	}

	@Override
	public Page<ArchivePageVo> getArchivePage(ArchivePageQuery query) {
		AuthUser currentUser = WebSecurityUtils.getCurrentUser();
		Page<ArchivePageVo> page = query.getPage();
		String keyword = StringUtils.trimToNull(query.getKeyword());
		if(keyword !=null){
			if (keyword.startsWith("%") || keyword.startsWith("[") || keyword.startsWith("[]") || keyword.startsWith("_")) {
				query.setKeyword('\\'+keyword);
			}
		}
		List<ArchivePageVo> list = assArchiveMapper.getArchivePage(page,currentUser, query);
		page.setRecords(list);
		return page;
	}

	@Override
	public AssetArchiveDetailVo getArchiveDetail(Long id) {
		AssArchive archiveDb = assArchiveMapper.selectById(id);
		if(archiveDb==null){
			throw ExceptionFactory.create("AR_002");
		}
		AssetArchiveDetailVo archiveDetail = BeanMapper.map(archiveDb, AssetArchiveDetailVo.class);
		String checkTime = ArchiveUtil.ArchiveDateUtil(archiveDb.getCheckTime());
		String filingTime = ArchiveUtil.ArchiveDateUtil(archiveDb.getFilingTime());
		String startTime = ArchiveUtil.ArchiveDateUtil(archiveDb.getStartTime());
		String endTime = ArchiveUtil.ArchiveDateUtil(archiveDb.getEndTime());
		archiveDetail.setCheckTimeStr(checkTime);
		archiveDetail.setFilingTimeStr(filingTime);
		archiveDetail.setStartEndDateStr(startTime+"至"+endTime);
		archiveDetail.setLimitStorageTimeStr(ArchiveConstant.LIMIT_STORAGE_TIME_MAP.get(archiveDb.getLimitStorageTime()));
		archiveDetail.setSecretLevelStr(ArchiveConstant.SECRET_LEVEL_MAP.get(archiveDb.getSecretLevel()));
		return archiveDetail;
	}

	@Override
	public AssetBasicInfoVo getAssetBasicInfo(Long assetId) {
		AuthUser currentUser = WebSecurityUtils.getCurrentUser();
		ArchiveAssetBo assetDb = assArchiveMapper.getAssetBasicInfo(assetId, currentUser);
		if (assetDb==null)return null;
		AssetBasicInfoVo assetVo = BeanMapper.map(assetDb, AssetBasicInfoVo.class);
		
		assetVo.setStatusName(SysConstant.STATUS_NAME_MAP.get(assetDb.getStatus()));
		
		Map<String, String> userNameMap = findUserNameToMap(String.valueOf(assetDb.getCreateBy()));
		assetVo.setCreateByName(userNameMap.get("" + assetDb.getCreateBy()));
		
		
		
		StringBuffer assetsDeptIdsStr = new StringBuffer("");
		assetsDeptIdsStr.append(assetDb.getDeptId() + ",").append(assetDb.getManageDeptId());
		if (assetsDeptIdsStr != null && !assetsDeptIdsStr.equals("")) {
			Map<String, String> deptNameMap = findDeptNameToMap(assetsDeptIdsStr.toString());
			assetVo.setDeptName(deptNameMap.get(assetDb.getDeptId()+""));
			assetVo.setManageDeptName(deptNameMap.get(assetDb.getManageDeptId()+""));
		}
		
		assetVo.setAssetsSourceName(SysConstant.AssetsSource.getText(assetDb.getAssetsSource()));
		assetVo.setUnitName(codeInfoService.getCodeInfoMap(SysConstant.UNIT).get(String.valueOf(assetDb.getUnitId())));
		assetVo.setPurposeName(codeInfoService.getCodeInfoMap(SysConstant.PURPOSE).get(String.valueOf(assetDb.getPurpose())));
		assetVo.setAssetsTypeName(codeInfoService.getCodeInfoMap(SysConstant.ACCOUNT_BOOK).get(String.valueOf(assetDb.getAssetsTypeId())));
		assetVo.setManageLevelName(codeInfoService.getCodeInfoMap(SysConstant.MANAGE_LEVEL).get(String.valueOf(assetDb.getManageLevel())));
		assetVo.setPurchaseTypeName(codeInfoService.getCodeInfoMap(SysConstant.PURCHASE_TYPE).get(String.valueOf(assetDb.getPurchaseTypeId())));
		assetVo.setAssetsClassName(codeInfoService.getCodeInfoMap(SysConstant.ACCOUNT_CATEGORY).get(String.valueOf(assetDb.getAssetsClassId())));
		
		if(assetDb.getAssetsClassId()!=null){
			List<CodeInfo> li=codeInfoService.getCodeList(SysConstant.ACCOUNT_CATEGORY);
			if(li.size()>0){
				for(CodeInfo codeInfo :li){
					if(assetDb.getAssetsClassId().equals(Integer.parseInt(codeInfo.getCodeValue()))){
						assetVo.setOldYear(codeInfo.getCodeDesc());
						break;
					}
				}
			}
		}
		assetVo.setPriceStr(CommonUtils.fromX2Y(assetDb.getPrice()));
		//设备原值(系统无折旧业务,暂且与设备单价保持一致)
		assetVo.setOriginalValue(assetVo.getPriceStr());
		return assetVo;
	}
	
	/**
	 * 查找用户姓名
	 */
	private Map<String, String> findUserNameToMap(String ids) {
		Map<String, String> map = new HashMap<>();
		if (ids != null && !ids.equals("")) // 加个非空判断，防止数据库数据为null的时候报错
		{
			Result<List<DeptNameAndUserName>> createByName = userClientService.findByIds(ids.toString(), WebSecurityUtils.getCurrentToken());// 通过接口查询创建人
			if (createByName != null && createByName.getData() != null && createByName.getData().size() != 0) {
				for (DeptNameAndUserName uname : createByName.getData()) {
					map.put("" + uname.getId(), uname.getRealName());// 将查询到的数据保存至map里面
				}
			}
		}
		return map;
	}

	@Override
	public Page<ArchiveTransferVo> getArchiveTransferPage(ArchiveTransferQuery query) {		
		Long assetId = query.getAssetId();
		if(assetId==null)return null;
		Page<ArchiveTransferVo> page = query.getPage();
		String keyword = StringUtils.trimToNull(query.getKeyword());
		if(keyword !=null){
			if (keyword.startsWith("%") || keyword.startsWith("[") || keyword.startsWith("[]") || keyword.startsWith("_")) {
				query.setKeyword('\\'+keyword);
			}
		}
		AuthUser currentUser = WebSecurityUtils.getCurrentUser();
		List<ArchiveTransferVo> archiveTransferPage = assArchiveMapper.getArchiveTransferPage(page,query,currentUser);
		if(archiveTransferPage!=null&&archiveTransferPage.size()>0){
			for (ArchiveTransferVo archiveTransfer : archiveTransferPage) {
				String deptName = assArchiveMapper.getTransferDetail(archiveTransfer.getId(),assetId);
				archiveTransfer.setDeptName(deptName);
			}
		}
		page.setRecords(archiveTransferPage);
		return page;
	}

	@Override
	public Page<ArchiveDiscardVo> getArchiveDiscardPage(ArchiveDiscardQuery query) {
		Long assetId = query.getAssetId();
		if(assetId==null)return null;
		
		Page<ArchiveDiscardVo> page = query.getPage();
		AuthUser currentUser = WebSecurityUtils.getCurrentUser();
		List<ArchiveDiscardVo> archiveDiscardPage = assArchiveMapper.getArchiveDiscardPage(currentUser, query);
		if(archiveDiscardPage!=null&&archiveDiscardPage.size()>0){
			for (ArchiveDiscardVo archiveDiscard : archiveDiscardPage) {
				String deptName = assArchiveMapper.getDiscardDetail(archiveDiscard.getId(), assetId);
				archiveDiscard.setDeptName(deptName);
				archiveDiscard.setTypeStr(ArchiveConstant.DISCARD_TYPE_MAP.get(archiveDiscard.getType()));
			}
		}
		page.setRecords(archiveDiscardPage);
		return page;
	}

	@Override
	public PreEditArchiveVo preEditArchive(Long id) {
		AssArchive assArchiveDb = assArchiveMapper.selectById(id);
		if(assArchiveDb==null)return null;
		PreEditArchiveVo preEditArchive = assArchiveMapper.preEditArchive(id);
		Long deptId = preEditArchive.getDeptId();
		if(deptId!=null){
			Map<String, String> findDeptNameToMap = findDeptNameToMap(String.valueOf(preEditArchive.getDeptId()));
			preEditArchive.setDeptName(findDeptNameToMap.get(deptId+""));
		}	
		return preEditArchive;
	}
}
