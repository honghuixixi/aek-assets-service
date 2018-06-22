package com.aek.ebey.assets.service.impl;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.aek.common.core.BeanMapper;
import com.aek.common.core.Result;
import com.aek.common.core.base.BaseServiceImpl;
import com.aek.common.core.exception.BusinessException;
import com.aek.common.core.exception.ExceptionFactory;
import com.aek.common.core.serurity.WebSecurityUtils;
import com.aek.common.core.serurity.model.AuthUser;
import com.aek.common.core.util.DataUtil;
import com.aek.common.core.util.DateUtil;
import com.aek.common.core.util.RemindDateUtils;
import com.aek.ebey.assets.constant.SysConstant;
import com.aek.ebey.assets.core.AssetsLogDetailThread;
import com.aek.ebey.assets.core.util.CommonUtils;
import com.aek.ebey.assets.core.util.ReflectUtils;
import com.aek.ebey.assets.custom.AssetsDistributionData;
import com.aek.ebey.assets.enums.AssetsExportFieldEnum;
import com.aek.ebey.assets.enums.AssetsLogDetailTypeEnum;
import com.aek.ebey.assets.enums.AssetsLogModuleTypeEnum;
import com.aek.ebey.assets.enums.AssetsLogOperateTypeEnum;
import com.aek.ebey.assets.enums.AssetsRepairStatusEnum;
import com.aek.ebey.assets.enums.AssetsStatusEnum;
import com.aek.ebey.assets.enums.RoleDataScope;
import com.aek.ebey.assets.mapper.AssAssetsAnnexMapper;
import com.aek.ebey.assets.mapper.AssAssetsCertificateMapper;
import com.aek.ebey.assets.mapper.AssAssetsInfoOperateMapper;
import com.aek.ebey.assets.mapper.AssAssetsLogMapper;
import com.aek.ebey.assets.mapper.AssDistributionCapitalRangeMapper;
import com.aek.ebey.assets.mapper.AssSerialNumberMapper;
import com.aek.ebey.assets.mapper.AssetsFundSourcesMapper;
import com.aek.ebey.assets.mapper.AssetsInfoExtMapper;
import com.aek.ebey.assets.mapper.AssetsInfoMapper;
import com.aek.ebey.assets.mapper.AssetsInvoiceMapper;
import com.aek.ebey.assets.mapper.ContractAssetMapper;
import com.aek.ebey.assets.mapper.ContractMapper;
import com.aek.ebey.assets.model.AssAssetsAnnex;
import com.aek.ebey.assets.model.AssAssetsCertificate;
import com.aek.ebey.assets.model.AssAssetsInfoOperate;
import com.aek.ebey.assets.model.AssAssetsLog;
import com.aek.ebey.assets.model.AssAssetsLogDetail;
import com.aek.ebey.assets.model.AssDistributionCapitalRange;
import com.aek.ebey.assets.model.AssSerialNumber;
import com.aek.ebey.assets.model.Assets;
import com.aek.ebey.assets.model.AssetsCount;
import com.aek.ebey.assets.model.AssetsFundSources;
import com.aek.ebey.assets.model.AssetsInfo;
import com.aek.ebey.assets.model.AssetsInfoExt;
import com.aek.ebey.assets.model.AssetsInvoice;
import com.aek.ebey.assets.model.AssetsNumAndMoney;
import com.aek.ebey.assets.model.AssetsPm;
import com.aek.ebey.assets.model.AssetsQc;
import com.aek.ebey.assets.model.AssetsSource;
import com.aek.ebey.assets.model.AssetsVerfyStatus;
import com.aek.ebey.assets.model.CodeInfo;
import com.aek.ebey.assets.model.Contract;
import com.aek.ebey.assets.model.ContractAsset;
import com.aek.ebey.assets.model.DeptNameAndUserName;
import com.aek.ebey.assets.model.Feilds;
import com.aek.ebey.assets.model.MtAssets;
import com.aek.ebey.assets.model.bo.AttachmentsBO;
import com.aek.ebey.assets.model.query.AssertQuery;
import com.aek.ebey.assets.model.query.AssertReportQuery;
import com.aek.ebey.assets.model.query.AssetsCurveQuery;
import com.aek.ebey.assets.model.query.LedgerPaging;
import com.aek.ebey.assets.model.query.MtAssertQuery;
import com.aek.ebey.assets.model.query.PmAssertPaging;
import com.aek.ebey.assets.model.request.AssetsCurveRequest;
import com.aek.ebey.assets.model.request.AssetsInfoRequest;
import com.aek.ebey.assets.model.request.EditAssetsInfoRequest;
import com.aek.ebey.assets.model.request.PreAssetsInfoRequest;
import com.aek.ebey.assets.model.request.TenantAssets;
import com.aek.ebey.assets.model.vo.AssetArchiveVo;
import com.aek.ebey.assets.model.vo.AssetsCurveVo;
import com.aek.ebey.assets.model.vo.AssetsScanVO;
import com.aek.ebey.assets.model.vo.AssetsStats2Vo;
import com.aek.ebey.assets.model.vo.AssetsStatsVo;
import com.aek.ebey.assets.model.vo.MdAssetsVO;
import com.aek.ebey.assets.service.AssAssetsLogDetailService;
import com.aek.ebey.assets.service.AssAssetsLogService;
import com.aek.ebey.assets.service.AssSerialNumberService;
import com.aek.ebey.assets.service.AssetsInfoService;
import com.aek.ebey.assets.service.CodeInfoService;
import com.aek.ebey.assets.service.feign.QcClientService;
import com.aek.ebey.assets.service.feign.UserClientService;
import com.aek.ebey.assets.service.feign.vo.MsAssets;
import com.aek.ebey.assets.service.utils.OrderUtils;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.google.common.collect.Lists;

/**
 * 台账业务实现类
 */
@Service
@Transactional
public class AssetsInfoServiceImpl extends BaseServiceImpl<AssetsInfoMapper, AssetsInfo> implements AssetsInfoService {

	private static final Logger LOGGER = LoggerFactory.getLogger(AssetsInfoServiceImpl.class);
	// 扩展信息
	@Autowired
	private AssetsInfoMapper assetsInfoMapper;
	// 预台账扩展信息
	@Autowired
	private AssetsInfoExtMapper assetsInfoExtMapper;
	// 合同
	@Autowired
	private ContractMapper contractMapper;
	// 合同台账中间表
	@Autowired
	private ContractAssetMapper contractAssetMapper;
	// 发票
	@Autowired
	private AssetsInvoiceMapper assetsInvoiceMapper;
	// 资金来源
	@Autowired
	private AssetsFundSourcesMapper assetsFundSourcesMapper;
	@Autowired
	private UserClientService userClientService;
	@Autowired
	private AssSerialNumberMapper assSerialNumberMapper;
	@Autowired
	private RedisTemplate<String, String> redisTemplate;
	@Autowired
	private CodeInfoService codeInfoService;
	@Autowired
	private AssSerialNumberService assSerialNumberService;

	@Autowired
	private AssAssetsInfoOperateMapper assAssetsInfoOperateMapper;
	
	@Autowired
	private AssAssetsAnnexMapper assAssetsAnnexMapper;
	
	@Autowired
	private AssAssetsCertificateMapper assAssetsCertificateMapper;
	
	@Autowired
	private AssAssetsLogService assAssetsLogService;
	@Autowired
	private AssAssetsLogDetailService assAssetsLogDetailService;
	@Autowired
	private AssAssetsLogMapper assAssetsLogMapper;
	@Autowired
	private AssDistributionCapitalRangeMapper assDistributionCapitalRangeMapper; 
	
	@Autowired
	private QcClientService qcClientService;
	
	/**
	 * 预台账分页查询
	 */
	@Override
	public Page<Assets> getAssetsPage(Page<Assets> page, AssertQuery query) {
		AuthUser authUser = WebSecurityUtils.getCurrentUser();
		if(StringUtils.isNotBlank(query.getKeyword())){
			query.setKeyword(query.getKeyword().replaceAll("%", "\\\\%").replaceAll("_", "\\\\_"));
		}
		
		//处理选择部门搜索情况下，过滤数据范围
		Integer qDeptId = query.getDeptId();
		Integer dataScope = authUser.getDataScope();
		List<Long> queryDeptIds = authUser.getDeptIds();
		List<Long> definedDeptIds = authUser.getDefinedDeptIds();
		if(null != qDeptId && null != dataScope){
			Long queryDeptId = Long.parseLong(qDeptId.toString()); 
			if(null != queryDeptIds && dataScope.equals(RoleDataScope.DEPT_ALL.getNumber()) && !queryDeptIds.contains(queryDeptId)){
				return page;
			}
			//当前用户本部门
			Long authUserDeptId = authUser.getDeptId();
			if(dataScope.equals(RoleDataScope.DEPT.getNumber()) && !queryDeptId.equals(authUserDeptId)){
				return page;
			}
			if(null != definedDeptIds && dataScope.equals(RoleDataScope.DEPT_DEFINED.getNumber()) && !definedDeptIds.contains(queryDeptId)){
				return page;
			}
		}
		
		List<Assets> list = this.assetsInfoMapper.getAssetsPage(page, query, authUser);
		if (list == null) {// 如果数据库没有数据，直接返回空
			return page;
		}
		StringBuffer createByIds = new StringBuffer("");// 创建人Ids
		StringBuffer deptIds = new StringBuffer("");// 部门Ids
		for (Assets assets : list) {
			/* 查询创建人名称 */
			Long createBy = assets.getCreateBy();// 获取创建人ID
			if (createBy != null) {
				createByIds.append(createBy + ",");// 拼接创建人ids
			}

			/* 查询部门名称 */
			Integer deptId = assets.getDeptId();// 获取部门ID
			if (deptId != null) {
				deptIds.append(deptId + ",");// 拼接部门Ids
			}
			/*获取维修状态名称*/
			assets.setRepairStatusName(SysConstant.REPAIR_STATUS_NAME_MAP.get(assets.getRepairStatus()));
		}
		Map<String, String> userNameMap = findUserNameToMap(createByIds.toString());// 查询创建人集合姓名并将结果存入map
		Map<String, String> deptNameMap = findDeptNameToMap(deptIds.toString());// 查询部门名称并存入map
		/* 将对应的名称放入assets */
		for (Assets assets : list) {
			if (userNameMap != null) {// 如果查到创建人名称则赋值
				assets.setCreateByName(userNameMap.get("" + assets.getCreateBy()));
			}
			if (deptNameMap != null) {// 如果查到部门名称则赋值
				assets.setDeptName(deptNameMap.get("" + assets.getDeptId()));
			}
		}
		page.setRecords(list);
		return page;
	}

	/**
	 * 预台账验收 <验收预台账信息> <通过与不通过，修改验收信息>
	 * 
	 * @param id
	 *            台账ID
	 * @param verifyDate
	 *            验收日期
	 * @param verifyRemark
	 *            验收说明
	 * @param verifyStatus
	 *            状态(1：未审核 2:通过 3:不通过)
	 */
	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
	public void verify(Long id, Long verifyDate, String verifyRemark, String verifyStatus) {
		if (verifyDate == null) {
			throw new BusinessException("检查日期未填写");
		}
		if (DataUtil.isEmpty(verifyStatus)) {
			throw new BusinessException("请选择是否通过验收");
		}
		if (Integer.valueOf(verifyStatus) < SysConstant.VERFY_STATUS_1
				|| Integer.valueOf(verifyStatus) > SysConstant.VERFY_STATUS_3) {
			throw new BusinessException("验收状态错误");
		}
		AuthUser authUser = WebSecurityUtils.getCurrentUser();
		if(authUser==null){
			throw new BusinessException("用户信息获取失败");
		}
		AssAssetsInfoOperate entity = new AssAssetsInfoOperate();
		entity.setAssetsId(id);
		entity.setOperateTime(new Date());
		entity.setOperateBy(authUser.getId());
		if (String.valueOf(SysConstant.VERFY_STATUS_3).equals(verifyStatus)) {
			entity.setOperateStatus(SysConstant.OPERATE_3);
		}
		if (String.valueOf(SysConstant.VERFY_STATUS_2).equals(verifyStatus)) {
			entity.setOperateStatus(SysConstant.OPERATE_4);
		}
		entity.setOperateDate(new Date(verifyDate));
		entity.setOperateRemark(verifyRemark);
		assAssetsInfoOperateMapper.insert(entity);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("verfyBy", authUser.getId());
		map.put("id", id);
		map.put("verifyDate", new Date(verifyDate));
		map.put("verifyRemark", verifyRemark);
		map.put("verifyStatus", verifyStatus);
		map.put("verifyOperateTime", new Date());
		assetsInfoMapper.updateVerify(map);
	}

	/**
	 * 根据Id查询预台账各种名称 以及详细信息
	 */
	@Override
	public Assets getAssetsDetail(Long id) {
		AuthUser authUser = WebSecurityUtils.getCurrentUser();
		Assets assets = assetsInfoMapper.getAssetsDetail(id, authUser);	
		if (null == assets) {
			return null;
		}
		
		AssAssetsAnnex annexTender = assAssetsAnnexMapper.getAnnex(id, 1, authUser);//招标附件
		AssAssetsAnnex annexAcceptance = assAssetsAnnexMapper.getAnnex(id, 2, authUser);//验收附件
		AssAssetsAnnex annexContract = assAssetsAnnexMapper.getContractAnnex(id, 3, assets.getContractId(), authUser);//合同附件

		List<AttachmentsBO> tenerList = Lists.newArrayList();
		if(annexTender != null){		
			tenerList = JSON.parseArray(annexTender.getAnnexUrl(), AttachmentsBO.class);
			if(tenerList != null && tenerList.size() >0){
				assets.setTenderAnnexList(tenerList);
			}
		}
		assets.setTenderAnnexList(tenerList);
		
		List<AttachmentsBO> acceptanceList = Lists.newArrayList();
		if(annexAcceptance !=null){		
			acceptanceList = JSON.parseArray(annexAcceptance.getAnnexUrl(), AttachmentsBO.class);
			if(acceptanceList != null && acceptanceList.size() >0){
				assets.setAcceptanceAnnexList(acceptanceList);
			}
		}
		assets.setAcceptanceAnnexList(acceptanceList);
		
		List<AttachmentsBO> contractList = Lists.newArrayList();
		if(annexContract !=null){
			contractList = JSON.parseArray(annexContract.getAnnexUrl(), AttachmentsBO.class);
			if(contractList != null && contractList.size() >0){
				assets.setContractAnnexList(contractList);
			}
		}
		assets.setContractAnnexList(contractList);
		
		List<AssAssetsCertificate> certificates = Lists.newArrayList();
		certificates = assAssetsCertificateMapper.getCertificate(id, authUser);//资产证件
		if(certificates !=null && certificates.size() > 0){
			assets.setListCertificate(certificates);
		}else {			
			AssAssetsCertificate certificate1 = new AssAssetsCertificate();
			certificate1.setCertificateType(1);
			certificate1.setName("医疗器械生产企业许可证");
			certificates.add(certificate1);
			AssAssetsCertificate certificate2 = new AssAssetsCertificate();
			certificate2.setCertificateType(2);
			certificate2.setName("医疗器械注册证");
			certificates.add(certificate2);
			AssAssetsCertificate certificate3 = new AssAssetsCertificate();
			certificate3.setCertificateType(3);
			certificate3.setName("医疗器械经营企业许可证");
			certificates.add(certificate3);
			AssAssetsCertificate certificate4 = new AssAssetsCertificate();
			certificate4.setCertificateType(4);
			certificate4.setName("产品合格证");
			certificates.add(certificate4);
			assets.setListCertificate(certificates);
		}
		
		// 价格转换 ，除以100
		if (DataUtil.isNotEmpty(assets.getContractPrice())) {
			assets.setContractPriceStr(CommonUtils.fromX2Y(assets.getContractPrice()));
		}

		if (DataUtil.isNotEmpty(assets.getPrice())) {
			assets.setPriceD(CommonUtils.fromX2YD(assets.getPrice()));
			assets.setPriceStr(CommonUtils.fromX2Y(assets.getPrice()));
		}
		
		if (DataUtil.isNotEmpty(assets.getSingleBudget())) {
			assets.setSingleBudgetStr(CommonUtils.fromX2Y(assets.getSingleBudget()));
		}
		// 资金来源比例对象设置成json返回
		List<Map<String, Object>> list = assetsFundSourcesMapper.findByAssetsId(id);
		return findNamesByIds(assets, id, list);// 将方法提炼放置下方
	}

	/**
	 * 预台账确认
	 * 
	 * @param id
	 */
	@Override
	@Transactional
	public void addConfirm(Long id) {
		String verfyNum = RandomUtils.nextLong() + "";
		AssetsInfoExt ext = new AssetsInfoExt();
		// 生产预台账验收编号
		ext.setVerfyNum(verfyNum);
		ext.setVerfyStatus(SysConstant.VERFY_STATUS_1);
		ext.setAssetsId(id);
		assetsInfoMapper.addConfirm(ext);

	}

	/**
	 * 预台账状态数量查询
	 * 
	 * @return
	 */
	@Override
	public AssetsVerfyStatus getStatusNum(Long tenantId) {
		// AuthUser authUser = WebSecurityUtils.getCurrentUser();
		// 查询各种状态数量
		List<Map<String, Object>> list = assetsInfoMapper.getStatusNum(tenantId);
		AssetsVerfyStatus pmAssetsVerfyStatus = new AssetsVerfyStatus();
		int statusNumAll = 0;
		for (Map<String, Object> map : list) {
			int verfyStatus = (int) map.get("verfyStatus");
			Long num = (Long) map.get("statusNum");
			int statusNum = num.intValue();
			statusNumAll += statusNum;
			if (SysConstant.VERFY_STATUS_0 == verfyStatus)
				pmAssetsVerfyStatus.setVerfyStatusStage(statusNum);
			if (SysConstant.VERFY_STATUS_1 == verfyStatus)
				pmAssetsVerfyStatus.setVerfyStatusUnaudited(statusNum);
			if (SysConstant.VERFY_STATUS_2 == verfyStatus)
				pmAssetsVerfyStatus.setVerfyStatusPass(statusNum);
			if (SysConstant.VERFY_STATUS_3 == verfyStatus)
				pmAssetsVerfyStatus.setVerfyStatusUnPass(statusNum);
		}
		pmAssetsVerfyStatus.setVerfyStatusAll(statusNumAll);
		return pmAssetsVerfyStatus;
	}

	/**
	 * 删除预台账
	 * 
	 * @param id
	 */
	@Override
	@Transactional
	public void delAssets(Long id) {
		// 只有暂存状态、验收不通过才可以删除
		AssetsInfoExt pmAssetsInfoExtOld = assetsInfoExtMapper.selectByAssetsId(id);
		if (SysConstant.VERFY_STATUS_0 != pmAssetsInfoExtOld.getVerfyStatus()
				&& SysConstant.VERFY_STATUS_3 != pmAssetsInfoExtOld.getVerfyStatus())
			throw new BusinessException("当前状态不可删除");

		AssetsInfo info = new AssetsInfo();
		info.setDelFlag(true);
		info.setId(id);
		assetsInfoMapper.updateById(info);

	}

	/**
	 * 
	 * @return 返回资产台账每个状态的数量
	 */
	@Override
	public List<Map<String, Object>> getAssetsStatusNum(Long tenantId) {
		// AuthUser authUser = WebSecurityUtils.getCurrentUser();
		List<Map<String, Object>> list = assetsInfoMapper.getAssetsStatusNum(tenantId);
		for (Map<String, Object> map : list) {
			switch ((String) map.get("status")) {
			case "全部状态":
				map.put("statusNum", 0);
				break;
			case "在库":
				map.put("statusNum", 1);
				break;
			case "在用":
				map.put("statusNum", 2);
				break;
			case "维修中":
				map.put("statusNum", 4);
				break;
			case "已报废":
				map.put("statusNum", 6);
				break;
			}
		}
		return list;
	}

	/**
	 * 
	 * @return 返回资产台账每种生成方式下的数量
	 */
	@Override
	public AssetsSource getAssetsSourceNum(Long tenandId) {
		// AuthUser authUser = WebSecurityUtils.getCurrentUser();
		AssetsSource pas = new AssetsSource();
		List<Map<String, Object>> list = assetsInfoMapper.getAssetsSourceNum(tenandId);
		if (list == null) {
			return null;
		}
		int sourceAll = 0;// 全部来源
		for (Map<String, Object> map : list) {
			if (map.get("assetesSourceNum") != null) {
				long num = (long) map.get("assetesSourceNum");
				int SourceNum = (int) num;
				if (map.get("assetsSource") != null && (int) map.get("assetsSource") == 1) {// true即为1,1表示批量导入
					pas.setAssetsImport(SourceNum);
					sourceAll += SourceNum;
				} else {
					pas.setAssetsAddWarehouse(SourceNum);
					sourceAll += SourceNum;
				}
			}
		}
		pas.setAssetsSourceAll(sourceAll);
		return pas;
	}
	
	@Override
	public Page<Assets> getTransferPage(LedgerPaging query) {
		AuthUser authUser = WebSecurityUtils.getCurrentUser();
		Page<Assets> page = query.getPage();
		if(StringUtils.isNotBlank(query.getKeyword())){
			query.setKeyword(query.getKeyword().replaceAll("%", "\\\\%").replaceAll("_", "\\\\_"));
		}
		Integer deptId = query.getDeptId();
		if(deptId == null){
			query.setDeptId(authUser.getDeptId().intValue());
		}
		List<Assets> transferPages = assetsInfoMapper.getTransferPage(page, query, authUser);
		if (transferPages == null) {
			return page;
		}
		
		Set<Integer> deptIdSet = new HashSet<Integer>();
		for (Assets transferPage : transferPages) {
			/* 获取状态名称 */
			transferPage.setStatusName(SysConstant.STATUS_NAME_MAP.get(transferPage.getStatus()));
			/* 获取所属科室id,拼接为ids */
			if (transferPage.getDeptId() != null) {
				deptIdSet.add(transferPage.getDeptId());
			}
			//获取单位名称
			Map<String, String> unitMap = codeInfoService.getCodeInfoMap(SysConstant.UNIT);
			String value= unitMap.get(String.valueOf(transferPage.getUnitId()));
			if(StringUtils.isNotBlank(value)){
				transferPage.setUnitName(value);
			}
		}
		/* 获取科室名称 */
		if (CollectionUtils.isNotEmpty(deptIdSet)) {
			Map<String, String> deptNameMap = findDeptNameToMap(StringUtils.join(deptIdSet, ','));// 查询部门名称并存入map
			/* 将对应的名称放入assets */
			for (Assets transferPage : transferPages) {
				if (deptNameMap != null) {// 如果查到部门名称则赋值
					transferPage.setDeptName(deptNameMap.get("" + transferPage.getDeptId()));
				}
			}
		}
		page.setRecords(transferPages);
		return page;
	}

	/**
	 * 台账列表分页查询
	 */
	@Override
	public Page<Assets> getLedgerPage(Page<Assets> page, LedgerPaging query) {
		AuthUser authUser = WebSecurityUtils.getCurrentUser();
		if(StringUtils.isNotBlank(query.getKeyword())){
			query.setKeyword(query.getKeyword().replaceAll("%", "\\\\%").replaceAll("_", "\\\\_"));
		}
		//处理选择部门搜索情况下，过滤数据范围
		Integer deptId = query.getDeptId();
		Integer dataScope = authUser.getDataScope();
		List<Long> deptIds = authUser.getDeptIds();
		List<Long> definedDeptIds = authUser.getDefinedDeptIds();
		if(null != deptId && null != dataScope){
			Long queryDeptId = Long.parseLong(deptId.toString());
			if(null != deptIds && dataScope.equals(RoleDataScope.DEPT_ALL.getNumber()) && !deptIds.contains(queryDeptId)){
				return page;
			}
			//当前用户本部门
			Long authUserDeptId = authUser.getDeptId();
			if(dataScope.equals(RoleDataScope.DEPT.getNumber()) && !queryDeptId.equals(authUserDeptId)){
				return page;
			}
			if(null != definedDeptIds && dataScope.equals(RoleDataScope.DEPT_DEFINED.getNumber()) && !definedDeptIds.contains(queryDeptId)){
				return page;
			}
		}
		
		List<Assets> list = this.assetsInfoMapper.getLedgerPage(page, query, authUser);
		if (list == null) {
			return page;
		}
		Set<Integer> deptIdSet = new HashSet<Integer>();
		for (Assets a : list) {
			/* 获取来源名称 */
			if (a.getAssetsSource() != null ) {
				a.setAssetsSourceName(SysConstant.AssetsSource.getText(a.getAssetsSource()));
			}
			/* 获取状态名称 */
			a.setStatusName(SysConstant.STATUS_NAME_MAP.get(a.getStatus()));

			/* 获取所属科室id,拼接为ids */
			if (a.getDeptId() != null) {
				deptIdSet.add(a.getDeptId());
			}
			
			/*获取维修状态名称*/
			a.setRepairStatusName(SysConstant.REPAIR_STATUS_NAME_MAP.get(a.getRepairStatus()));		
		}
		/* 获取科室名称 */
		if (CollectionUtils.isNotEmpty(deptIdSet)) {
			Map<String, String> deptNameMap = findDeptNameToMap(StringUtils.join(deptIdSet, ','));// 查询部门名称并存入map
			/* 将对应的名称放入assets */
			for (Assets assets : list) {
				if (deptNameMap != null) {// 如果查到部门名称则赋值
					assets.setDeptName(deptNameMap.get("" + assets.getDeptId()));
				}
			}
		}
		page.setRecords(list);
		return page;
	}

	/**
	 * 台账导出查询
	 */
	@Override
	public List<Map<String, Object>> getReportAssetsList(AssertReportQuery query) {
		if (query.getColum().contains("invoice_no"))
			query.setColum((query.getColum().replace("invoice_no",
					"(select group_concat(invoice_no)  from ass_assets_invoice   where assets_id= i.id) invoice_no")));
		if (query.getColum().contains("e.purchase_date"))
			query.setColum((query.getColum().replace("e.purchase_date",
					"DATE_FORMAT(e.purchase_date,'%Y-%m-%d') purchase_date")));

		if (query.getColum().contains("e.arrival_date"))
			query.setColum((query.getColum().replace("e.arrival_date",
					"DATE_FORMAT(e.arrival_date,'%Y-%m-%d') arrival_date")));

		if (query.getColum().contains("c.start_date"))
			query.setColum((query.getColum().replace("c.start_date",
					"DATE_FORMAT(c.start_date,'%Y-%m-%d') start_date")));
		
		
		//2017/11/20
		if (query.getColum().contains("i.apply_date"))
			query.setColum((query.getColum().replace("i.apply_date",
					"DATE_FORMAT(i.apply_date,'%Y-%m-%d') apply_date")));
		if (query.getColum().contains("i.proof_date"))
			query.setColum((query.getColum().replace("i.proof_date",
					"DATE_FORMAT(i.proof_date,'%Y-%m-%d') proof_date")));
		if (query.getColum().contains("i.expect_date"))
			query.setColum((query.getColum().replace("i.expect_date",
					"DATE_FORMAT(i.expect_date,'%Y-%m-%d') expect_date")));
		if (query.getColum().contains("e.win_tender_date"))
			query.setColum((query.getColum().replace("e.win_tender_date",
					"DATE_FORMAT(e.win_tender_date,'%Y-%m-%d') win_tender_date")));
		if (query.getColum().contains("c.create_time"))
			query.setColum((query.getColum().replace("c.create_time",
					"DATE_FORMAT(c.create_time,'%Y-%m-%d') create_time")));
		if (query.getColum().contains("c.end_date"))
			query.setColum((query.getColum().replace("c.end_date",
					"DATE_FORMAT(c.end_date,'%Y-%m-%d') end_date")));
		//2017/11/20 end
		

		if (query.getColum().contains("i.price1"))
			query.setColum((query.getColum().replace("i.price1",
					"i.price price1")));
		if (query.getColum().contains("i.price2"))
			query.setColum((query.getColum().replace("i.price2",
					"i.price price2")));

		if (query.getColum().contains("zjnx"))
			query.setColum((query.getColum().replace("zjnx",
					"i.assets_class_id  zjnx")));

		// 免税设备
		query.setColum((query.getColum().replace("e.free_tax",
				"(case e.free_tax when 0 then \"否\" when 1 then \"是\" end) as free_tax")));
		// 商检设备
		query.setColum((query.getColum().replace("e.commodity_flag",
				"(case e.commodity_flag when 0 then \"否\" when 1 then \"是\" end) as commodity_flag")));

		// pm标志
		query.setColum((query.getColum().replace("e.pm_flag",
				"(case e.pm_flag when 0 then \"否\" when 1 then \"是\" end) as pm_flag")));
		
		// 巡检标识
		query.setColum((query.getColum().replace("e.polling_flag",
				"(case e.polling_flag when 0 then \"否\" when 1 then \"是\" end) as polling_flag")));

		// 质检设备
		query.setColum((query.getColum().replace("e.quality_flag",
				"(case e.quality_flag when 0 then \"否\" when 1 then \"是\" end) as quality_flag")));

		// 折旧方法
		query.setColum((query.getColum().replace("e.dep_type",
				"(case e.dep_type when 0 then \"平均年限法\" when 1 then \"是\" end) as dep_type")));
		
		// 国产/进口
		query.setColum((query.getColum().replace("i.made_in",
				"(case i.made_in when 1 then \"国产\" when 2 then \"进口\" end) as made_in")));
		
		//计量设备
		query.setColum((query.getColum().replace("e.measure_flag",
				"(case e.measure_flag when 1 then \"是\" when 2 then \"否\" end) as measure_flag")));

		List<Map<String, Object>> assetsMap = assetsInfoMapper.getReportAssetsList(query);
		HashOperations<String, Object, Object>  hash= redisTemplate.opsForHash();
		Map<String, String> unitMap = codeInfoService.getCodeInfoMap(SysConstant.UNIT);
		Map<String, String> accountMap = codeInfoService.getCodeInfoMap(SysConstant.ACCOUNT_CATEGORY);
		Map<String, String> purposetMap = codeInfoService.getCodeInfoMap(SysConstant.PURPOSE);
		Map<String, String> measureMap=codeInfoService.getCodeInfoMap(SysConstant.MEASURE_TYPE);
		Map<String, String> depteMap=codeInfoService.getCodeInfoMap(SysConstant.DEP_TYPE);
		Map<String, String> bookMap=codeInfoService.getCodeInfoMap(SysConstant.ACCOUNT_BOOK);
		Map<String, String> levelMap=codeInfoService.getCodeInfoMap(SysConstant.MANAGE_LEVEL);
		Map<String, String> typeMap=codeInfoService.getCodeInfoMap(SysConstant.PURCHASE_TYPE);
		Map<String, String> sourcesMap=codeInfoService.getCodeInfoMap(SysConstant.FUND_SOURCES);
		List<CodeInfo>  li=codeInfoService.getCodeList(SysConstant.ACCOUNT_CATEGORY);
		
		Map<String, String> codeInfoMap=new HashMap<String, String>();
		if(assetsMap!=null&&assetsMap.size()>0){
			if(li.size()>0){
				for(CodeInfo codeInfo :li){
					codeInfoMap.put(codeInfo.getCodeValue(), codeInfo.getCodeDesc());
				}
			}
		}
		for(Map<String, Object> map:assetsMap){
			for (Map.Entry<String, Object> entry : map.entrySet()) {  
				if(entry.getKey().equals("unit_id")){
					if(String.valueOf(entry.getValue())!=null){
						String unit= (String) hash.get(SysConstant.UNIT, String.valueOf(entry.getValue()));
						if(unit!=null){
							map.put(entry.getKey(), unit);
						}else{
							String value= unitMap.get(String.valueOf(entry.getValue()));
							if(value!=null){
								hash.put(SysConstant.UNIT, String.valueOf(entry.getValue()),value);
								map.put(entry.getKey(), value);
							}

						}
					}
				}
				if(entry.getKey().equals("assets_class_id")){
					if(String.valueOf(entry.getValue())!=null){
						String unit= (String) hash.get(SysConstant.ACCOUNT_CATEGORY, String.valueOf(entry.getValue()));
						if(unit!=null){
							map.put(entry.getKey(), unit);
						}else{
							String value= accountMap.get(String.valueOf(entry.getValue()));
							if(value!=null){
								hash.put(SysConstant.ACCOUNT_CATEGORY, String.valueOf(entry.getValue()),value);
								map.put(entry.getKey(), value);
							}

						}
					}
				}
				if(entry.getKey().equals("purpose")){
					if(String.valueOf(entry.getValue())!=null){
						String unit= (String) hash.get(SysConstant.PURPOSE, String.valueOf(entry.getValue()));
						if(unit!=null){
							map.put(entry.getKey(), unit);
						}else{
							String value= purposetMap.get(String.valueOf(entry.getValue()));
							if(value!=null){
								hash.put(SysConstant.PURPOSE, String.valueOf(entry.getValue()),value);
								map.put(entry.getKey(), value);
							}

						}
					}
				}
				if(entry.getKey().equals("measure_type")){
					if(String.valueOf(entry.getValue())!=null){
						String unit= (String) hash.get(SysConstant.MEASURE_TYPE, String.valueOf(entry.getValue()));
						if(unit!=null){
							map.put(entry.getKey(), unit);
						}else{
							String value= measureMap.get(String.valueOf(entry.getValue()));
							if(value!=null){
								hash.put(SysConstant.MEASURE_TYPE, String.valueOf(entry.getValue()),value);
								map.put(entry.getKey(), value);
							}

						}
					}
				}
				if(entry.getKey().equals("dep_type")){
					if(String.valueOf(entry.getValue())!=null){
						String unit= (String) hash.get(SysConstant.DEP_TYPE, String.valueOf(entry.getValue()));
						if(unit!=null){
							map.put(entry.getKey(), unit);
						}else{
							String value= depteMap.get(String.valueOf(entry.getValue()));
							if(value!=null){
								hash.put(SysConstant.DEP_TYPE, String.valueOf(entry.getValue()),value);
								map.put(entry.getKey(), value);
							}

						}
					}
				}
				if(entry.getKey().equals("assets_type_id")){
					if(String.valueOf(entry.getValue())!=null){
						String unit= (String) hash.get(SysConstant.ACCOUNT_BOOK, String.valueOf(entry.getValue()));
						if(unit!=null){
							map.put(entry.getKey(), unit);
						}else{
							String value= bookMap.get(String.valueOf(entry.getValue()));
							if(value!=null){
								hash.put(SysConstant.ACCOUNT_BOOK, String.valueOf(entry.getValue()),value);
								map.put(entry.getKey(), value);
							}

						}
					}
				}
				if(entry.getKey().equals("manage_level")){
					if(String.valueOf(entry.getValue())!=null){
						String unit= (String) hash.get(SysConstant.MANAGE_LEVEL, String.valueOf(entry.getValue()));
						if(unit!=null){
							map.put(entry.getKey(), unit);
						}else{
							String value= levelMap.get(String.valueOf(entry.getValue()));
							if(value!=null){
								hash.put(SysConstant.MANAGE_LEVEL, String.valueOf(entry.getValue()),value);
								map.put(entry.getKey(), value);
							}

						}
					}
				}
				if(entry.getKey().equals("purchase_type_id")){
					if(String.valueOf(entry.getValue())!=null){
						String unit= (String) hash.get(SysConstant.PURCHASE_TYPE, String.valueOf(entry.getValue()));
						if(unit!=null){
							map.put(entry.getKey(), unit);
						}else{
							String value= typeMap.get(String.valueOf(entry.getValue()));
							if(value!=null){
								hash.put(SysConstant.PURCHASE_TYPE, String.valueOf(entry.getValue()),value);
								map.put(entry.getKey(), value);
							}

						}
					}
				}
				if(entry.getKey().equals("fund_sources_id")){
					if(String.valueOf(entry.getValue())!=null){
						String unit= (String) hash.get(SysConstant.FUND_SOURCES, String.valueOf(entry.getValue()));
						if(unit!=null){
							map.put(entry.getKey(), unit);
						}else{
							String value= sourcesMap.get(String.valueOf(entry.getValue()));
							if(value!=null){
								hash.put(SysConstant.FUND_SOURCES, String.valueOf(entry.getValue()),value);
								map.put(entry.getKey(), value);
							}

						}
					}
				}
				if(entry.getKey().equals("zjnx")){
					map.put("zjnx", codeInfoMap.get(String.valueOf(entry.getValue())));

				}
				if(entry.getKey().equals("price1")){
					if(entry.getValue()!=null){
						map.put(entry.getKey(), CommonUtils.fromX2Y(Long.parseLong(String.valueOf(entry.getValue()))));
					}

				}
				if(entry.getKey().equals("price2")){
					if(entry.getValue()!=null){
						map.put(entry.getKey(), CommonUtils.fromX2Y(Long.parseLong(String.valueOf(entry.getValue()))));
					}

				}
				if(entry.getKey().equals("single_budget")){
					if(entry.getValue()!=null){
						map.put(entry.getKey(), CommonUtils.fromX2Y(Long.parseLong(String.valueOf(entry.getValue()))));
					}

				}
				if(entry.getKey().equals("fund_source_money")){
					if(entry.getValue()!=null){
						map.put(entry.getKey(), CommonUtils.fromX2Y(Long.parseLong(String.valueOf(entry.getValue()))));
					}
				}
				if(entry.getKey().equals("invoice_money")){
					if(entry.getValue()!=null){
						map.put(entry.getKey(), CommonUtils.fromX2Y(Long.parseLong(String.valueOf(entry.getValue()))));
					}
				}
				if(entry.getKey().equals("contract_price")){
					if(entry.getValue()!=null){
						map.put(entry.getKey(), CommonUtils.fromX2Y(Long.parseLong(String.valueOf(entry.getValue()))));
					}
				}	  
				if(entry.getKey().equals("dept_id")&&entry.getValue()!=null){
					if (entry.getValue() != null && !entry.getValue().equals("")) {
						String depname = (String) hash.get("DEPTID", String.valueOf(entry.getValue()));
						if (depname != null) {
							map.put(entry.getKey(), depname);
						} else {
							Map<String, String> deptNameMap = findDeptNameToMap(entry.getValue().toString());
							if (deptNameMap != null) {
								hash.put("DEPTID", String.valueOf(entry.getValue()), deptNameMap.get(String.valueOf(entry.getValue())));
								map.put(entry.getKey(), deptNameMap.get(String.valueOf(entry.getValue())));
							}

						}
					}
				}
				if(entry.getKey().equals("manage_dept_id")&&entry.getValue()!=null){
					if (entry.getValue() != null && !entry.getValue().equals("")) {
						String depname = (String) hash.get("MANAGEDEPTID", String.valueOf(entry.getValue()));
						if (depname != null) {
							map.put(entry.getKey(), depname);
						} else {
							Map<String, String> deptNameMap = findDeptNameToMap(entry.getValue().toString());
							if (deptNameMap != null) {
								hash.put("MANAGEDEPTID", String.valueOf(entry.getValue()), deptNameMap.get(String.valueOf(entry.getValue())));
								map.put(entry.getKey(), deptNameMap.get(String.valueOf(entry.getValue())));
							}

						}
					}
				}
				if(entry.getKey().equals("apply_dept_id")&&entry.getValue()!=null){
					if (entry.getValue() != null && !entry.getValue().equals("")) {
						String depname = (String) hash.get("APPLYEDEPTID", String.valueOf(entry.getValue()));
						if (depname != null) {
							map.put(entry.getKey(), depname);
						} else {
							Map<String, String> deptNameMap = findDeptNameToMap(entry.getValue().toString());
							if (deptNameMap != null) {
								hash.put("APPLYEDEPTID", String.valueOf(entry.getValue()), deptNameMap.get(String.valueOf(entry.getValue())));
								map.put(entry.getKey(), deptNameMap.get(String.valueOf(entry.getValue())));
							}

						}
					}
				}
				
				
				//2017/11/20
				//采购方式
				if(entry.getKey().equals("purchase_way") && entry.getValue()!=null){
			          if (entry.getValue() != null && StringUtils.isNotEmpty(String.valueOf(entry.getValue()))) {
			            Integer purchaseWay = Integer.valueOf(String.valueOf(entry.getValue()));
			            switch (purchaseWay.intValue()) {
						case 1:
							map.put(entry.getKey(),"国际招标");
							break;
						case 2:
							map.put(entry.getKey(),"政府采购");
							break;
						case 3:
							map.put(entry.getKey(),"院内采购");
							break;
						case 4:
							map.put(entry.getKey(),"分散采购");
							break;
						case 5:
							map.put(entry.getKey(),"自行采购");
							break;
						case 6:
							map.put(entry.getKey(),"其他");
							break;
						default:
							break;
						}		            
			          }
			        }
				
				//招标形式
				if(entry.getKey().equals("tender_form") && entry.getValue()!=null){
			          if (entry.getValue() != null && StringUtils.isNotEmpty(String.valueOf(entry.getValue()))) {
			            Integer purchaseWay = Integer.valueOf(String.valueOf(entry.getValue()));
			            switch (purchaseWay.intValue()) {
						case 1:
							map.put(entry.getKey(),"公开招标");
							break;
						case 2:
							map.put(entry.getKey(),"邀请招标");
							break;
						case 3:
							map.put(entry.getKey(),"竞争性谈判");
							break;
						case 4:
							map.put(entry.getKey(),"单一来源采购");
							break;
						case 5:
							map.put(entry.getKey(),"询价采购");
							break;
						case 6:
							map.put(entry.getKey(),"其他");
							break;
						default:
							break;
						}		            
			          }
			        }
				
				//购置类别
				if(entry.getKey().equals("apply_type") && entry.getValue()!=null){
			          if (entry.getValue() != null && StringUtils.isNotEmpty(String.valueOf(entry.getValue()))) {
			            Integer purchaseWay = Integer.valueOf(String.valueOf(entry.getValue()));
			            switch (purchaseWay.intValue()) {
						case 1:
							map.put(entry.getKey(),"新增");
							break;
						case 2:
							map.put(entry.getKey(),"添置");
							break;
						case 3:
							map.put(entry.getKey(),"报废更新");
							break;
						default:
							break;
						}		            
			          }
			        }
				
				//2017//11/20
				
				
				

			}  
		}

		return assetsMap;
	}

	/**
	 * 导入台账
	 */
	@Override
	@Transactional
	public void addAssetsByImport(List<AssetsInfo> assetInfos, List<AssetsInfoExt> assetExts, String uploadId, String token, AuthUser authUser) {
		LOGGER.debug("enter import."+assetInfos.size());
		List<AssetsInfo> infos = new ArrayList<AssetsInfo>();
		List<AssetsInfoExt> exts = new ArrayList<AssetsInfoExt>();
		Date nowDate = DateUtil.getNowDate();
		Long maxSn = this.getSerialNumber(authUser.getTenantId(), 1, assetInfos.size(), false);
		for (int i = 0; i < assetInfos.size(); i++) {
			Long sn = maxSn-(assetInfos.size()-i-1);
			LOGGER.debug("index=" + i +", sn=" + sn);
			AssetsInfo info = assetInfos.get(i);
			AssetsInfoExt ext = assetExts.get(i);
			String assetsNum = this.formatSn(authUser.getTenantId(), sn);
			info.setAssetsNum(assetsNum);
			//info.setStatus(1);
			//资产台账导入时默认设备状态为在用
			info.setStatus(AssetsStatusEnum.IN_USE.getNumber());
			//资产台账导入时默认维修状态为正常
			info.setRepairStatus(AssetsRepairStatusEnum.NORMAL.getNumber());
			info.setDelFlag(false);
			info.setAssetsSource(SysConstant.AssetsSource.BATCH_IMPORT.getVal());
			info.setAssetsStatus(1);
			info.setSysId(authUser.getTenantId());
			info.setCreateBy(authUser.getId());
			info.setCreateTime(nowDate);
			infos.add(info);
			ext.setPollingFlag(SysConstant.POLLING_FLAG_1);
			ext.setAssetsNum(assetsNum);
			ext.setMeasureFlag(0);
			exts.add(ext);
		}
		this.importAssets(infos, exts);
	}

	/**
	 * 根据id取对应的名称
	 */
	private Assets findNamesByIds(Assets assets, Long id, List<Map<String, Object>> list) {

		if (list != null && assets != null) {
			/* 状态名称 */
			if (assets.getVerfyStatus() != null) {
				assets.setVerfyStatusName(SysConstant.VERFY_STATUS_MAP.get(assets.getVerfyStatus()));
			}
			/* 查询创建人和最后修改人名称 */
			Long createBy = assets.getCreateBy();
			Long updateBy = assets.getUpdateBy();
			Long verfyBy = assets.getVerfyBy();
			if (createBy != null || updateBy != null || verfyBy != null) {
				String ids = updateBy + "," + createBy + "," + verfyBy;
				Map<String, String> userNameMap = findUserNameToMap(ids);// 查找并已经将信息放入map
				if (userNameMap != null) {
					assets.setCreateByName(userNameMap.get("" + createBy));
					assets.setUpdateByName(userNameMap.get("" + updateBy));
					assets.setVerfyByName(userNameMap.get("" + verfyBy));
				}
			}
			assets.setAssetsSourceName(SysConstant.AssetsSource.getText(assets.getAssetsSource()));
			/* 查询科室名称 */
			StringBuffer deptIds = new StringBuffer("");
			Integer applyDeptId = assets.getApplyDeptId();// 申购科室
			Integer deptId = assets.getDeptId();// 使用科室
			Integer manageDeptId = assets.getManageDeptId();// 管理科室
			if (applyDeptId != null) {
				deptIds.append(applyDeptId);
				deptIds.append(",");
			}
			if (deptId != null) {
				deptIds.append(deptId);
				deptIds.append(",");
			}
			if (manageDeptId != null) {
				deptIds.append(manageDeptId);
			}
			if (deptIds != null && !deptIds.equals("")) {
				Map<String, String> deptNameMap = findDeptNameToMap(deptIds.toString());
				if (deptNameMap != null) {
					assets.setDeptName(deptNameMap.get("" + deptId));// 使用部门
					assets.setApplyDeptName(deptNameMap.get("" + applyDeptId));// 申购部门
					assets.setManageDeptName(deptNameMap.get("" + manageDeptId));// 管理部门
				}
			}
			assets.setUnitName(codeInfoService.getCodeInfoMap(SysConstant.UNIT).get(String.valueOf(assets.getUnitId())));
			assets.setPurposeName(codeInfoService.getCodeInfoMap(SysConstant.PURPOSE).get(String.valueOf(assets.getPurpose())));
			assets.setMeasureTypeName(codeInfoService.getCodeInfoMap(SysConstant.MEASURE_TYPE).get(String.valueOf(assets.getMeasureType())));
			assets.setDepTypeName(codeInfoService.getCodeInfoMap(SysConstant.DEP_TYPE).get(String.valueOf(assets.getDepType())));
			assets.setAssetsTypeName(codeInfoService.getCodeInfoMap(SysConstant.ACCOUNT_BOOK).get(String.valueOf(assets.getAssetsTypeId())));
			assets.setManageLevelName(codeInfoService.getCodeInfoMap(SysConstant.MANAGE_LEVEL).get(String.valueOf(assets.getManageLevel())));
			assets.setPurchaseTypeName(codeInfoService.getCodeInfoMap(SysConstant.PURCHASE_TYPE).get(String.valueOf(assets.getPurchaseTypeId())));
			assets.setFundSourcesName(codeInfoService.getCodeInfoMap(SysConstant.FUND_SOURCES).get(String.valueOf(assets.getFundSourcesId())));
			assets.setAssetsClassName(codeInfoService.getCodeInfoMap(SysConstant.ACCOUNT_CATEGORY).get(String.valueOf(assets.getAssetsClassId())));
			assets.setAssetsSourceName(SysConstant.AssetsSource.getText(assets.getAssetsSource()));
			if(assets!=null){
				if(assets.getPrice()!=null&&assets.getPrice()!=null&&assets.getDepAmount()!=null){
					try {
						assets.setLessPrice((assets.getPrice()-assets.getDepAmount())+"");
					} catch (NumberFormatException e) {
						LOGGER.info(e.toString());
					}
				}
				if(assets.getAssetsClassId()!=null){
					List<CodeInfo> li=codeInfoService.getCodeList(SysConstant.ACCOUNT_CATEGORY);
					if(li.size()>0){
						for(CodeInfo codeInfo :li){
							if(assets.getAssetsClassId().equals(Integer.parseInt(codeInfo.getCodeValue()))){
								assets.setOldYear(codeInfo.getCodeDesc());
								break;
							}
						}
					}
				}
			}
			Wrapper<AssetsFundSources> wrapper=new EntityWrapper<AssetsFundSources>();
			wrapper.eq("assets_id", id);
			List<AssetsFundSources>  listAssetsFundSources=assetsFundSourcesMapper.selectList(wrapper);
			if(listAssetsFundSources!=null&&listAssetsFundSources.size()>0){
				for(AssetsFundSources assetsFundSources:listAssetsFundSources){
					assetsFundSources.setFundSourceMoneyStr(CommonUtils.fromX2Y(assetsFundSources.getFundSourceMoney()));
				}
			}
			assets.setListFundSources(listAssetsFundSources);

			Wrapper<AssetsInvoice> wrapper2=new EntityWrapper<AssetsInvoice>();
			wrapper2.eq("assets_id", id);
			List<AssetsInvoice>  listAssetsInvoice=assetsInvoiceMapper.selectList(wrapper2);
			assets.setListInvoice(listAssetsInvoice);

			Wrapper<ContractAsset> wrapper3=new EntityWrapper<ContractAsset>();
			wrapper3.eq("assets_id", id);
			List<ContractAsset> listcontractAsset=contractAssetMapper.selectList(wrapper3);
			if(listcontractAsset!=null&&listcontractAsset.size()>0){
				assets.setContractId(listcontractAsset.get(0).getId());
			}
			assets.setStatusName(SysConstant.STATUS_NAME_MAP.get(assets.getStatus()));
			assets.setRepairStatusName(SysConstant.REPAIR_STATUS_NAME_MAP.get(assets.getRepairStatus()));
		}
		return assets;
	}

	/**
	 * 
	 * @param deptIds 部门ID数组
	 * @return 返回是否存在台账信息
	 */
	@Override
	public Boolean deviceQuery(Long[] deptIds) {
		if (deptIds == null || (null != deptIds && deptIds.length == 0)) {
			return false;
		}
		Integer num = assetsInfoMapper.deviceQuery(deptIds);
		if (num > 0)
			return true;
		return false;

	}

	/**
	 * 只提供给前端导出所需要的字段
	 * 
	 * @return
	 */
	@Override
	public List<Feilds> fieldDisplay() {
		List<Feilds> list = new ArrayList<>();
	    AssetsExportFieldEnum[] values = AssetsExportFieldEnum.values();
	    for (AssetsExportFieldEnum assetsExportFieldEnum : values) {
	      Feilds filed = new Feilds(assetsExportFieldEnum.getFieldDesc(),assetsExportFieldEnum.getFieldName(),assetsExportFieldEnum.getSelected(),assetsExportFieldEnum.getIndex());
	      list.add(filed);
	    }
	    return list;
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

	/**
	 * 导入台账
	 */
	private void importAssets(List<AssetsInfo> infos, List<AssetsInfoExt> exts) {
		List<AssetsInfo> assInfos = new ArrayList<AssetsInfo>();
		List<AssetsInfoExt> assInfoExts = new ArrayList<AssetsInfoExt>();
		List<AssetsFundSources> fundList = new ArrayList<AssetsFundSources>();
		int batchSize = 100;
		for (int i = 0; i < exts.size(); i++) {
			AssetsInfo info = infos.get(i);
			assInfos.add(info);
			AssetsInfoExt ext = exts.get(i);
			assInfoExts.add(ext);
			ext.setAssetsId(info.getId());
			int index = i+1;
			if ((index % batchSize) == 0||index >= exts.size()) {
				assetsInfoMapper.batchInsert(assInfos);
				for (int j = 0; j < assInfos.size(); j++) {
					Long id = assInfos.get(j).getId();
					assInfoExts.get(j).setAssetsId(id);
					List<AssetsFundSources> fl = assInfos.get(j).getFundList();
					if(CollectionUtils.isNotEmpty(fl)){
						fl.stream().forEach(e->{
							e.setAssetsId(id);
						});
					}
					fundList.addAll(fl);
				}
				assInfos.clear();
				if (CollectionUtils.isNotEmpty(assInfoExts)) {
					assetsInfoExtMapper.batchInsert(assInfoExts);
					assInfoExts.clear();
				}
				if (CollectionUtils.isNotEmpty(fundList)) {
					assetsFundSourcesMapper.batchInsert(fundList);
					fundList.clear();
				}
			}
		}
	}

	@Override
	public List<AssetsCurveVo> queryAssetsCurve1(AssetsCurveRequest req) {
		Calendar cal = Calendar.getInstance();
		AssetsCurveQuery query = new AssetsCurveQuery();
		query.setStatus(req.getStatus());
		if (StringUtils.isBlank(req.getDateLabel())) {
			if (req.getEndDate().after(cal.getTime())) {
				req.setEndDate(cal.getTime());
			}
			query.setStartDate(new java.sql.Date(req.getStartDate().getTime()));
			cal.setTime(req.getEndDate());
			cal.add(Calendar.DATE, 1);
			query.setEndDate(new java.sql.Date(cal.getTimeInMillis()));
		} else {
			if (req.getDateLabel().equals("0")) {// preMonth
				cal.set(Calendar.DATE, 1);
				query.setEndDate(new java.sql.Date(cal.getTimeInMillis()));
				cal.add(Calendar.MONTH, -1);
				query.setStartDate(new java.sql.Date(cal.getTimeInMillis()));
			} else if (req.getDateLabel().equals("1")) {// curMonth
				cal.add(Calendar.DATE, 1);
				query.setEndDate(new java.sql.Date(cal.getTimeInMillis()));
				cal.set(Calendar.DATE, 1);
				query.setStartDate(new java.sql.Date(cal.getTimeInMillis()));
			} else if (req.getDateLabel().equals("2")) {// curQuarter
				cal.add(Calendar.DATE, 1);
				query.setEndDate(new java.sql.Date(cal.getTimeInMillis()));
				int month = 0;
				if (cal.get(Calendar.MONTH) <= Calendar.MARCH) {
					month = Calendar.JANUARY;
				} else if (cal.get(Calendar.MONTH) <= Calendar.JUNE) {
					month = Calendar.APRIL;
				} else if (cal.get(Calendar.MONTH) <= Calendar.SEPTEMBER) {
					month = Calendar.JULY;
				} else if (cal.get(Calendar.MONTH) <= Calendar.DECEMBER) {
					month = Calendar.OCTOBER;
				}
				cal.set(Calendar.MONTH, month);
				cal.set(Calendar.DATE, 1);
				query.setStartDate(new java.sql.Date(cal.getTimeInMillis()));
			} else if (req.getDateLabel().equals("3")) {// curYear
				cal.add(Calendar.DATE, 1);
				query.setEndDate(new java.sql.Date(cal.getTimeInMillis()));
				cal.set(Calendar.MONTH, Calendar.JANUARY);
				cal.set(Calendar.DATE, 1);
				query.setStartDate(new java.sql.Date(cal.getTimeInMillis()));
			}
		}
		Map<Integer, AssetsCurveVo> dateMap = new HashMap<>();
		AuthUser authUser = WebSecurityUtils.getCurrentUser();
		List<Long> tenantIds = null;
		if (authUser.getTenantType() == 0) {// aek
			//查询所有的医疗机构
			Result<List<Long>> result = this.userClientService.findAllHplTenant(WebSecurityUtils.getCurrentToken());
			if (result != null&&"200".equals(result.getCode())) {
				tenantIds = result.getData();
			}
			if(tenantIds==null||tenantIds.isEmpty()){
				List<AssetsCurveVo> vos = new ArrayList<AssetsCurveVo>();
				fillData(query, dateMap, new AssetsCurveVo(), vos );
				return vos;
			}
			query.setTenantIds(tenantIds);
		} else if (authUser.getTenantType() == 2) {// 监管机构
			String token = WebSecurityUtils.getCurrentToken();
			Result<List<Long>> result = this.userClientService.findTenantidsById(authUser.getTenantId(), token);
			LOGGER.debug(JSON.toJSONString(result));
			if (result != null&&"200".equals(result.getCode())) {
				tenantIds = result.getData();
			}
			if(tenantIds==null||tenantIds.isEmpty()){
				List<AssetsCurveVo> vos = new ArrayList<AssetsCurveVo>();
				fillData(query, dateMap, new AssetsCurveVo(), vos );
				return vos;
			}
			query.setTenantIds(tenantIds);
		} else {
			query.setTenantId(authUser.getTenantId());
		}
		AssetsCurveVo prev = this.assetsInfoMapper.queryAssetsHis(query);
		if(prev==null){
			prev = new AssetsCurveVo();
		}
		List<AssetsCurveVo> vos = this.assetsInfoMapper.queryAssetsCurve(query);
		if(vos==null){
			vos = new ArrayList<>();
		}
		for (AssetsCurveVo vo : vos) {
			dateMap.put(Integer.valueOf(DateUtil.format(vo.getDate(), DateUtil.DATE_PATTERN.YYYYMMDD)), vo);
		}
		fillData(query, dateMap, prev, vos);
		return vos;
	}


	private void fillData(AssetsCurveQuery query, Map<Integer, AssetsCurveVo> dateMap, AssetsCurveVo prev,
			List<AssetsCurveVo> vos) {
		Calendar c = null;
		int start=Integer.valueOf(DateUtil.format(query.getStartDate(), DateUtil.DATE_PATTERN.YYYYMMDD));
		int end=Integer.valueOf(DateUtil.format(query.getEndDate(), DateUtil.DATE_PATTERN.YYYYMMDD));
		while(start<end){
			AssetsCurveVo vo = null;
			if(c==null){
				c = Calendar.getInstance();
				c.setTime(query.getStartDate());
			}
			if(!dateMap.keySet().contains(start)){
				vo = new AssetsCurveVo();
				vo.setDate(c.getTime());
				vo.setCount(prev.getCount());
				vo.setPrice(prev.getPrice());
				vos.add(vo);
			}else{
				vo = dateMap.get(start);
				vo.setCount(vo.getCount()+prev.getCount());
				vo.setPrice(vo.getPrice()+prev.getPrice());
			}
			c.add(Calendar.DATE, 1);
			start=Integer.valueOf(DateUtil.format(c.getTime(), DateUtil.DATE_PATTERN.YYYYMMDD));
			vo.setPriceStr(CommonUtils.fromX2Y(vo.getPrice()));
			prev = vo;
		}
		Collections.sort(vos, new Comparator<AssetsCurveVo>() {
			@Override
			public int compare(AssetsCurveVo o1, AssetsCurveVo o2) {
				return o1.getDate().compareTo(o2.getDate());
			}
		});
	}

	@Override
	public List<AssetsCount> getAssetsCount(Long tenantid) {
		Set<Long> set = new HashSet<Long>();
		AuthUser authUser = WebSecurityUtils.getCurrentUser();
		if (authUser.getTenantType() == 0) {// aek
			set=null;
		} else if (authUser.getTenantType() == 2) {// 监管机构
			Result<List<Long>> result = userClientService.findTenantidsById(tenantid, WebSecurityUtils.getCurrentToken());
			if (result != null && result.getCode().equals("200")) {
				if(result.getData().size()>0){
					set.addAll(result.getData());
				}else{
					throw ExceptionFactory.create("A_009");
				}
			} else {
				throw ExceptionFactory.create("A_009");
			}
		} else {
			set.add(tenantid);
		}
		return assetsInfoMapper.getAssetsCount(set);


		//return assetsInfoMapper.getAssetsCount(tenantid);
	}

	@Override
	public AssetsNumAndMoney getAssetsNumAndMoney(Long tenantid) {
		Set<Long> set = new HashSet<Long>();
		AuthUser authUser = WebSecurityUtils.getCurrentUser();
		Result<List<Long>> result = null;
		if (authUser.getTenantType() == 0) {// aek
			// 获取所有医疗机构
			result = userClientService.findAllHplTenant(WebSecurityUtils.getCurrentToken());
		} else if (authUser.getTenantType() == 2) {
			// 获取监管机构下所有的医疗机构
			result = userClientService.findTenantidsById(tenantid, WebSecurityUtils.getCurrentToken());
		} else {
			set.add(tenantid);
		}
		if (result != null && result.getCode().equals("200")) {
			if(result.getData().size()>0){
				set.addAll(result.getData());
			}else{
				throw ExceptionFactory.create("A_009");
			}
		} else {
			throw ExceptionFactory.create("A_009");
		}
		return assetsInfoMapper.getAssetsNumAndMoney(set);
	}

	@Transactional
	public String generateAssetsNum(Long tenantId) {
		if (tenantId==null) {
			throw ExceptionFactory.create("O_006");
		}
		Long sn = getSerialNumber(tenantId, 1, 1, true);
		return formatSn(tenantId, sn);

	}

	private String formatSn(Long tenantId, Long sn) {
		StringBuilder sb = new StringBuilder();
		sb.append("H");
		if(tenantId.toString().length()>6){
			sb.append(tenantId);
		}else{
			String tenantCodeMask = "000000";
			String tenant=tenantCodeMask.substring(0, tenantCodeMask.length()-tenantId.toString().length());
			sb.append(tenant).append(tenantId);
		}
		String date = DateUtil.format(new Date(), DateUtil.DATE_PATTERN.YYYYMMDD);
		sb.append(date).append(String.format("%06d", sn));
		return sb.toString();
	}

	@Override
	@Transactional
	public Long getSerialNumber(Long tenantId, int module, int count, boolean updateDB) {
		if (tenantId==null) {
			throw ExceptionFactory.create("O_006");
		}
		Long num = null;
		String key = "Assets:SerialNum:" + module + ":" + tenantId;
		ValueOperations<String, String> valueOper = redisTemplate.opsForValue();
		if (valueOper.get(key) == null) {// not in cache
			AssSerialNumber entity = assSerialNumberMapper.findOne(tenantId, module);
			if (entity == null) {
				num = valueOper.increment(key, count);
				if (updateDB) {
					entity = new AssSerialNumber();
					entity.setSn(num);
					entity.setModule(module);
					entity.setTenantId(tenantId);
					assSerialNumberMapper.insert(entity);
				}
			} else {
				num = entity.getSn() + count;
				valueOper.increment(key, num);
				if (updateDB) {
					entity.setSn(num);
					entity.setModule(module);
					entity.setTenantId(tenantId);
					assSerialNumberMapper.updateSn(entity);
				}
			}
		} else {// in cache
			num = valueOper.increment(key, count);
			if (updateDB) {
				assSerialNumberService.insertOrUpdate(tenantId, module, num);
			}
		}
		return num;
	}

	@Override
    @Transactional
    public void editPreAssets(AssetsInfo info, AssetsInfoExt assetsInfoExt,EditAssetsInfoRequest request,Contract contract,String submit) {
        //资产处于待报损、报损、退货，状态不予编辑
        Long id = info.getId();
        AssetsInfo assetByid = assetsInfoMapper.selectById(id);
        Integer assetsStatus = assetByid.getAssetsStatus();
        if(assetByid != null && assetsStatus.intValue()==1){
            if(info.getStatus().intValue() != assetByid.getStatus().intValue()){
                if(assetByid.getStatus()==SysConstant.STATUS_NAME_4 || assetByid.getStatus()==SysConstant.STATUS_NAME_5 || assetByid.getStatus()==SysConstant.STATUS_NAME_6){
                    throw ExceptionFactory.create("C_010");
                }
            }       
        }
            
        AuthUser authUser = WebSecurityUtils.getCurrentUser();
        if (info != null) {
            // 台账主表信息
            info.setUpdateBy(Long.valueOf(authUser.getId()));
            info.setUpdateTime(DateUtil.getNowDate());
            if(request!=null&&request.getListFundSources()!=null){
                if(request.getListFundSources().size()>=2){
                    //混合
                    info.setFundSourcesId(4);
                }if(request.getListFundSources().size()==1){
                    info.setFundSourcesId(request.getListFundSources().get(0).getFundSourcesId());
                }
            }
            assetsInfoMapper.updateAssetsInfoById(info);
        }
        if (assetsInfoExt != null) {
            // 台账扩展信息
            Wrapper<AssetsInfoExt> wrapper = new EntityWrapper<AssetsInfoExt>();
            wrapper.eq("assets_id", assetsInfoExt.getAssetsId());
            List<AssetsInfoExt> list = assetsInfoExtMapper.selectList(wrapper);
            if (list.size() > 0) {
                AssetsInfoExt assetsInfoExt2 = list.get(0);
                assetsInfoExt.setId(assetsInfoExt2.getId());
                if (submit != null) {
                    if (assetsInfoExt2.getVerfyStatus() != SysConstant.VERFY_STATUS_0) {
                        throw ExceptionFactory.create("A_010");
                    }
                    AssAssetsInfoOperate entity=new AssAssetsInfoOperate();
                    entity.setAssetsId(assetsInfoExt.getAssetsId());
                    entity.setOperateTime(new Date());
                    entity.setOperateBy(authUser.getId());
                    entity.setOperateStatus(SysConstant.OPERATE_2);
                    assAssetsInfoOperateMapper.insert(entity);
                    assetsInfoExt.setVerfyStatus(SysConstant.VERFY_STATUS_1);
                }
            }
            assetsInfoExt.setAssetsId(assetsInfoExt.getAssetsId());
            assetsInfoExtMapper.updateById(assetsInfoExt);
            
            AssetsInfoExt editAssetsInfoExt = assetsInfoExtMapper.selectById(assetsInfoExt.getId());
            if(StringUtils.isBlank(assetsInfoExt.getApproveProjectAccord())){
                editAssetsInfoExt.setApproveProjectAccord(null);
            }
            if(StringUtils.isBlank(assetsInfoExt.getSingleBudgetStr())){
                editAssetsInfoExt.setSingleBudgetStr(null);
            }
            if(StringUtils.isBlank(assetsInfoExt.getSerialNum())){
                editAssetsInfoExt.setSerialNum(null);
            }
            if(StringUtils.isBlank(assetsInfoExt.getRegNo())){
                editAssetsInfoExt.setRegNo(null);
            }
            if(StringUtils.isBlank(assetsInfoExt.getRegName())){
                editAssetsInfoExt.setRegName(null);
            }
            if(StringUtils.isBlank(assetsInfoExt.getAssetsBrand())){
                editAssetsInfoExt.setAssetsBrand(null);
            }
            if(StringUtils.isBlank(assetsInfoExt.getFactoryNum())){
                editAssetsInfoExt.setFactoryNum(null);
            }
            assetsInfoExtMapper.updateAllColumnById(editAssetsInfoExt);
        }
        
        if (request != null) {
            
            //招标附件编辑
            List<AttachmentsBO> tenderAnnex = request.getTenderAnnexList();
            AssAssetsAnnex annexTender = assAssetsAnnexMapper.getAnnex(request.getAssetsId(),1, authUser);//查数据库招标附件
            AssAssetsAnnex annex1 = new AssAssetsAnnex();
            if(tenderAnnex != null && tenderAnnex.size()>0){                                
                if(annexTender != null){
                    annex1.setId(annexTender.getId());
                    annex1.setAnnexUrl(JSON.toJSONString(tenderAnnex));
                    assAssetsAnnexMapper.updateById(annex1);
                }else {
                    annex1.setAnnexUrl(JSON.toJSONString(tenderAnnex));
                    annex1.setAnnexType(1);//招标
                    annex1.setAssetsId(request.getAssetsId());
                    //annex1.setContractId(request.getContractId());
                    annex1.setSysId(authUser.getTenantId());
                    assAssetsAnnexMapper.insert(annex1);
                }       
            }else if ((tenderAnnex ==null || (tenderAnnex != null && tenderAnnex.size()==0))  && annexTender != null) {
                annex1.setId(annexTender.getId());
                assAssetsAnnexMapper.deleteById(annex1);
            }
            
            //验收附件编辑
            List<AttachmentsBO> acceptanceAnnex = request.getAcceptanceAnnexList();
            AssAssetsAnnex annexAcceptance = assAssetsAnnexMapper.getAnnex(request.getAssetsId(),2, authUser);//查数据库验收附件
            AssAssetsAnnex annex2 = new AssAssetsAnnex();
            if(acceptanceAnnex !=null && acceptanceAnnex.size()>0){
                if(annexAcceptance !=null){
                    annex2.setId(annexAcceptance.getId());
                    annex2.setAnnexUrl(JSON.toJSONString(acceptanceAnnex));
                    assAssetsAnnexMapper.updateById(annex2);
                }else {
                    annex2.setAnnexUrl(JSON.toJSONString(acceptanceAnnex));
                    annex2.setAnnexType(2);//验收
                    annex2.setAssetsId(request.getAssetsId());
                    annex2.setSysId(authUser.getTenantId());
                    assAssetsAnnexMapper.insert(annex2);
                }
            }else if ((acceptanceAnnex ==null || (acceptanceAnnex != null && acceptanceAnnex.size()==0)) && annexAcceptance != null) {
                annex2.setId(annexAcceptance.getId());
                assAssetsAnnexMapper.deleteById(annex2);
            }
            
            
            // 获得资产资金来源
            List<AssetsFundSources> listFundSources = request.getListFundSources();

            Wrapper<AssetsFundSources> wrapperFundSources=new EntityWrapper<AssetsFundSources>();
            wrapperFundSources.eq("assets_id", assetsInfoExt.getAssetsId());
            List<AssetsFundSources>  listSources=assetsFundSourcesMapper.selectList(wrapperFundSources);

            //查询所有的来源id
            List<Long> listids=new ArrayList<Long>();
            if(listSources!=null&&listSources.size()>0){
                for(AssetsFundSources assetsFundSources:listSources){
                    listids.add(assetsFundSources.getId());
                }
            }

            if (listFundSources != null && listFundSources.size() > 0) {
                for (AssetsFundSources assetsFundSources : listFundSources) {
                    assetsFundSources.setAssetsId(assetsInfoExt.getAssetsId());
                    assetsFundSources.setFundSourceMoney(CommonUtils.fromY2X(assetsFundSources.getFundSourceMoneyStr()));
                    if(assetsFundSources.getId()==null){
                        assetsFundSourcesMapper.insert(assetsFundSources);
                    }else{

                        if(listids.size()>0){
                            if(listids.contains(assetsFundSources.getId())){
                                assetsFundSourcesMapper.updateAssetsFundSources(assetsFundSources);
                                //删除更新的id
                                listids.remove(assetsFundSources.getId());
                            }   
                        }
                    }

                }


            }
            //判断资金来源剩余的id进行删除
            if(listids.size()>0){
                assetsFundSourcesMapper.deleteBatchIds(listids);
                /*for(Long id:listids){
                    assetsFundSourcesMapper.deleteById(id);
                }*/

            }
            // 获得资产发票表
            List<AssetsInvoice> listAssetsInvoice = request.getListInvoice();

            Wrapper<AssetsInvoice> wrapper=new EntityWrapper<AssetsInvoice>();
            wrapper.eq("assets_id", assetsInfoExt.getAssetsId());
            List<AssetsInvoice>  listInvoice=assetsInvoiceMapper.selectList(wrapper);
            //查询所有的来源id
            List<Long> list=new ArrayList<Long>();
            if(listInvoice!=null&&listInvoice.size()>0){
                for(AssetsInvoice assetsInvoice:listInvoice){
                    list.add(assetsInvoice.getId());
                }
            }

            if (listAssetsInvoice != null && listAssetsInvoice.size() > 0) {
                for (AssetsInvoice assetsInvoice : listAssetsInvoice) {
                    assetsInvoice.setAssetsId(assetsInfoExt.getAssetsId());
                    //assetsInvoice.setInvoiceMoney(assetsInvoice.getInvoiceMoney()*100);
                    if(assetsInvoice.getId()==null){
                        assetsInvoiceMapper.insert(assetsInvoice);
                    }else{
                        if(list.size()>0){
                            if(list.contains(assetsInvoice.getId())){
                                assetsInvoiceMapper.updateAssetsInvoice(assetsInvoice);
                                //删除更新的id
                                list.remove(assetsInvoice.getId());
                            }

                        }
                    }

                }

            }
            //判断资金来源剩余的id进行删除
            if(list.size()>0){
                assetsInvoiceMapper.deleteBatchIds(list);
                /*for(Long id:list){
                    assetsInvoiceMapper.deleteById(id);
                }*/

            }
            if (contract != null&&(request.getContractAnnexList() != null || contract.getContractName()!=null||contract.getContractNo()!=null||request.getContractId()!=null||contract.getContractPrice()!=null
                    ||contract.getArchivesCode()!=null||contract.getStartDate()!=null||contract.getSupplierName()!=null)) {
                ContractAsset entity=BeanMapper.map(request, ContractAsset.class);
                ContractAsset oldContractAssets =  contractAssetMapper.getContractAssetByAssetsId(info.getId());
                if(request.getContractId()==null && null == oldContractAssets){
                    contract.setCreateBy(authUser.getId());
                    contractMapper.insert(contract);
                    entity.setContractId(contract.getId());
                    contractAssetMapper.insert(entity);
                }else{
                    contract.setId(request.getContractId());
                    //contractMapper.updateById(contract);
                    contractMapper.updateContractAsset(contract);
                }
            }
                        
            //合同附件编辑
            List<AttachmentsBO> contractAnnex = request.getContractAnnexList();         
            AssAssetsAnnex annexContract = assAssetsAnnexMapper.getContractAnnex(request.getAssetsId(),3, request.getContractId(), authUser);//查数据库合同附件
            AssAssetsAnnex annex3 = new AssAssetsAnnex();
            if (contractAnnex !=null && contractAnnex.size() >0) {
                if (annexContract  != null) {
                    annex3.setId(annexContract.getId());
                    annex3.setAnnexUrl(JSON.toJSONString(contractAnnex));
                    assAssetsAnnexMapper.updateById(annex3);
                }else {
                    if(contract.getId() !=null){
                        annex3.setAnnexUrl(JSON.toJSONString(contractAnnex));
                        annex3.setAnnexType(3);//合同
                        annex3.setAssetsId(request.getAssetsId());
                        annex3.setContractId(contract.getId());//附件绑定合同id
                        annex3.setSysId(authUser.getTenantId());
                        assAssetsAnnexMapper.insert(annex3);
                    }               
                }
            }else if ((contractAnnex ==null || (contractAnnex != null && contractAnnex.size()==0)) && annexContract != null) {
                annex3.setId(annexContract.getId());
                assAssetsAnnexMapper.deleteById(annex3);
            }

        }       
    }
	
	@Transactional
	public void editAssets(AssetsInfo newAssetsInfo, AssetsInfoExt newAssetsInfoExt,EditAssetsInfoRequest request,Contract newContract,String submit) {
		AssetsInfo oldAssetsInfo = new AssetsInfo();
		AssetsInfoExt oldAssetsInfoExt = new AssetsInfoExt();
		List<AttachmentsBO> newInviteAttachmentList  = new ArrayList<AttachmentsBO>();
		List<AttachmentsBO> oldInviteAttachmentList  = new ArrayList<AttachmentsBO>();
		List<AttachmentsBO> newCheckAttachmentList = new ArrayList<AttachmentsBO>();
		List<AttachmentsBO> oldCheckAttachmentList = new ArrayList<AttachmentsBO>();
		List<AssetsFundSources> oldAssetsFundSources = new ArrayList<AssetsFundSources>();
		List<AssetsFundSources> newAssetsFundSources = new ArrayList<AssetsFundSources>();
		Contract oldContract = new Contract();
		String oldInvoiceNo = assetsInvoiceMapper.getInVoiceNum(newAssetsInfo.getId());//旧发票号
		if(StringUtils.isNotBlank(oldInvoiceNo)){
			if(request.getModuleType()!=1){
				String[] arry = oldInvoiceNo.split(",");
				oldInvoiceNo = String.join(";", arry);
			}
		}
		String newInvoiceNo = request.getInvoiceNos();//新发票号
		List<AttachmentsBO> newContractAttachmentList = new ArrayList<AttachmentsBO>();
		List<AttachmentsBO> oldContractAttachmentList = new ArrayList<AttachmentsBO>();
		
		//资产处于待报损、报损、退货，状态不予编辑
		Long id = newAssetsInfo.getId();
		AssetsInfo assetByid = assetsInfoMapper.selectById(id);
		Integer assetsStatus = assetByid.getAssetsStatus();
		if(assetByid != null && assetsStatus.intValue()==1){
			if(newAssetsInfo.getStatus().intValue() != assetByid.getStatus().intValue()){
				if(assetByid.getStatus()==SysConstant.STATUS_NAME_4 || assetByid.getStatus()==SysConstant.STATUS_NAME_5 || assetByid.getStatus()==SysConstant.STATUS_NAME_6){
					throw ExceptionFactory.create("C_010");
				}
			}		
		}
			
		AuthUser authUser = WebSecurityUtils.getCurrentUser();
		
		//======================================更新ass_assets_info资产主表信息===========================================
		if (newAssetsInfo != null) {
			// 台账主表信息
			newAssetsInfo.setUpdateBy(Long.valueOf(authUser.getId()));
			newAssetsInfo.setUpdateTime(DateUtil.getNowDate());
			if(request!=null&&request.getListFundSources()!=null){
				if(request.getListFundSources().size()>=2){
					//混合
					newAssetsInfo.setFundSourcesId(4);
				}if(request.getListFundSources().size()==1){
					newAssetsInfo.setFundSourcesId(request.getListFundSources().get(0).getFundSourcesId());
				}
			}
			oldAssetsInfo = assetsInfoMapper.selectById(newAssetsInfo.getId());
			assetsInfoMapper.updateAssetsInfoById(newAssetsInfo);
		}
		//===============================================================================================================
		
		//==================================更新ass_assets_info_ext资产从表信息===========================================
		if (newAssetsInfoExt != null) {
			oldAssetsInfoExt = assetsInfoExtMapper.getAssetByAssetId(newAssetsInfoExt.getAssetsId());
			// 台账扩展信息
			Wrapper<AssetsInfoExt> wrapper = new EntityWrapper<AssetsInfoExt>();
			wrapper.eq("assets_id", newAssetsInfoExt.getAssetsId());
			List<AssetsInfoExt> list = assetsInfoExtMapper.selectList(wrapper);
			if (list.size() > 0) {
				AssetsInfoExt assetsInfoExt2 = list.get(0);
				newAssetsInfoExt.setId(assetsInfoExt2.getId());
				if (submit != null) {
					if (assetsInfoExt2.getVerfyStatus() != SysConstant.VERFY_STATUS_0) {
						throw ExceptionFactory.create("A_010");
					}
					AssAssetsInfoOperate entity=new AssAssetsInfoOperate();
					entity.setAssetsId(newAssetsInfoExt.getAssetsId());
					entity.setOperateTime(new Date());
					entity.setOperateBy(authUser.getId());
					entity.setOperateStatus(SysConstant.OPERATE_2);
					assAssetsInfoOperateMapper.insert(entity);
					newAssetsInfoExt.setVerfyStatus(SysConstant.VERFY_STATUS_1);
				}
			}
			newAssetsInfoExt.setAssetsId(newAssetsInfoExt.getAssetsId());
			assetsInfoExtMapper.updateById(newAssetsInfoExt);
			
			AssetsInfoExt editAssetsInfoExt = assetsInfoExtMapper.selectById(newAssetsInfoExt.getId());
			if(StringUtils.isBlank(newAssetsInfoExt.getApproveProjectAccord())){
			    editAssetsInfoExt.setApproveProjectAccord(null);
			}
			if(StringUtils.isBlank(newAssetsInfoExt.getSingleBudgetStr())){
			    editAssetsInfoExt.setSingleBudgetStr(null);
			}
			if(StringUtils.isBlank(newAssetsInfoExt.getSerialNum())){
			    editAssetsInfoExt.setSerialNum(null);
			}
			if(StringUtils.isBlank(newAssetsInfoExt.getRegNo())){
			    editAssetsInfoExt.setRegNo(null);
			}
			if(StringUtils.isBlank(newAssetsInfoExt.getRegName())){
			    editAssetsInfoExt.setRegName(null);
			}
			if(StringUtils.isBlank(newAssetsInfoExt.getAssetsBrand())){
			    editAssetsInfoExt.setAssetsBrand(null);
			}
			if(StringUtils.isBlank(newAssetsInfoExt.getFactoryNum())){
			    editAssetsInfoExt.setFactoryNum(null);
			}
			assetsInfoExtMapper.updateAllColumnById(editAssetsInfoExt);
		}
		//===============================================================================================================
		
		//======================================同步计量资产信息到计量管理=================================================
		Integer measureFlag = newAssetsInfoExt.getMeasureFlag();
		AssetsInfo msAssetsInfo = assetsInfoMapper.selectById(newAssetsInfo.getId());
		if (null != newAssetsInfo && null != newAssetsInfoExt && null != measureFlag) {
		    MsAssets msAssets=new MsAssets();
            msAssets.setTenantId(msAssetsInfo.getSysId());
            msAssets.setAssetsId(msAssetsInfo.getId());
            msAssets.setImgUrl(msAssetsInfo.getAssetsImg());
            msAssets.setAssetsName(msAssetsInfo.getAssetsName());
            msAssets.setAssetsDeptId(Long.parseLong(msAssetsInfo.getDeptId()+""));
            Map<String, String> deptNameMap = findDeptNameToMap(msAssetsInfo.getDeptId().toString());
            msAssets.setAssetsDeptName(deptNameMap.get("" + msAssetsInfo.getDeptId()));
            msAssets.setAssetsNum(msAssetsInfo.getAssetsNum());
            msAssets.setAssetsSpec(msAssetsInfo.getAssetsSpec());
            msAssets.setFactoryId(newAssetsInfoExt.getFactoryId());
            msAssets.setFactoryName(newAssetsInfoExt.getFactoryName());
            msAssets.setFactoryNum(newAssetsInfoExt.getFactoryNum());
            msAssets.setSerialNum(newAssetsInfoExt.getSerialNum());
            msAssets.setSplId(msAssetsInfo.getSplId());
            msAssets.setSplName(msAssetsInfo.getSplName());
            msAssets.setAssetsStatus(msAssetsInfo.getStatus());
		    //同步更新或插入计量设备
		    if (measureFlag.intValue() == 1) {
                msAssets.setDelFlag(false);
                qcClientService.saveOrUpdate(msAssets);
		    } else if(measureFlag.intValue() == 0) {
		        //非计量设备,判断是否存在计量台账，若存在,则更新，并将del_flag=true;
		        Result<Boolean> msAssetsResult = qcClientService.isExistMsAssets(msAssetsInfo.getId(),WebSecurityUtils.getCurrentToken());
		        if (null != msAssetsResult && msAssetsResult.getData()) {
		            msAssets.setDelFlag(true);
		            qcClientService.saveOrUpdate(msAssets);
		        }
		    }
		}
		//===============================================================================================================
		
		//====================================更新资产附件/资金来源/发票信息===============================================
		if (request != null) {
			//招标附件编辑
			newInviteAttachmentList = request.getTenderAnnexList();
			AssAssetsAnnex annexTender = assAssetsAnnexMapper.getAnnex(request.getAssetsId(),1, authUser);//查数据库招标附件
			AssAssetsAnnex annex1 = new AssAssetsAnnex();
			if(newInviteAttachmentList != null && newInviteAttachmentList.size()>0){								
				if(annexTender != null){
					annex1.setId(annexTender.getId());
					annex1.setAnnexUrl(JSON.toJSONString(newInviteAttachmentList));
					assAssetsAnnexMapper.updateById(annex1);
				}else {
					annex1.setAnnexUrl(JSON.toJSONString(newInviteAttachmentList));
					annex1.setAnnexType(1);//招标
					annex1.setAssetsId(request.getAssetsId());
					//annex1.setContractId(request.getContractId());
					annex1.setSysId(authUser.getTenantId());
					assAssetsAnnexMapper.insert(annex1);
				}		
			}else if ((newInviteAttachmentList ==null || (newInviteAttachmentList != null && newInviteAttachmentList.size()==0))  && annexTender != null) {
				annex1.setId(annexTender.getId());
				assAssetsAnnexMapper.deleteById(annex1);
			}
			
			//处理招标附件修改日志
			oldInviteAttachmentList = annexTender==null?new ArrayList<>():JSON.parseArray(annexTender.getAnnexUrl(), AttachmentsBO.class);
			
			//验收附件编辑
			newCheckAttachmentList = request.getAcceptanceAnnexList();
			AssAssetsAnnex annexAcceptance = assAssetsAnnexMapper.getAnnex(request.getAssetsId(),2, authUser);//查数据库验收附件
			AssAssetsAnnex annex2 = new AssAssetsAnnex();
			if(newCheckAttachmentList !=null && newCheckAttachmentList.size()>0){
				if(annexAcceptance !=null){
					annex2.setId(annexAcceptance.getId());
					annex2.setAnnexUrl(JSON.toJSONString(newCheckAttachmentList));
					assAssetsAnnexMapper.updateById(annex2);
				}else {
					annex2.setAnnexUrl(JSON.toJSONString(newCheckAttachmentList));
					annex2.setAnnexType(2);//验收
					annex2.setAssetsId(request.getAssetsId());
					annex2.setSysId(authUser.getTenantId());
					assAssetsAnnexMapper.insert(annex2);
				}
			}else if ((newCheckAttachmentList ==null || (newCheckAttachmentList != null && newCheckAttachmentList.size()==0)) && annexAcceptance != null) {
				annex2.setId(annexAcceptance.getId());
				assAssetsAnnexMapper.deleteById(annex2);
			}
			oldCheckAttachmentList = annexAcceptance==null?new ArrayList<>():JSON.parseArray(annexAcceptance.getAnnexUrl(), AttachmentsBO.class);
					
			// 获得资产资金来源
			newAssetsFundSources = request.getListFundSources();

			Wrapper<AssetsFundSources> wrapperFundSources=new EntityWrapper<AssetsFundSources>();
			wrapperFundSources.eq("assets_id", newAssetsInfoExt.getAssetsId());
			oldAssetsFundSources=assetsFundSourcesMapper.selectList(wrapperFundSources);

			//查询所有的来源id
			List<Long> listids=new ArrayList<Long>();
			if(oldAssetsFundSources!=null&&oldAssetsFundSources.size()>0){
				for(AssetsFundSources assetsFundSources:oldAssetsFundSources){
					listids.add(assetsFundSources.getId());
				}
			}

			if (newAssetsFundSources != null && newAssetsFundSources.size() > 0) {
				for (AssetsFundSources assetsFundSources : newAssetsFundSources) {
					assetsFundSources.setAssetsId(newAssetsInfoExt.getAssetsId());
					assetsFundSources.setFundSourceMoney(CommonUtils.fromY2X(assetsFundSources.getFundSourceMoneyStr()));
					if(assetsFundSources.getId()==null){
						assetsFundSourcesMapper.insert(assetsFundSources);
					}else{

						if(listids.size()>0){
							if(listids.contains(assetsFundSources.getId())){
								assetsFundSourcesMapper.updateAssetsFundSources(assetsFundSources);
								//删除更新的id
								listids.remove(assetsFundSources.getId());
							}	
						}
					}

				}


			}
			//判断资金来源剩余的id进行删除
			if(listids.size()>0){
				assetsFundSourcesMapper.deleteBatchIds(listids);
			}
						
			// 获得资产发票表
			List<AssetsInvoice> listAssetsInvoice = request.getListInvoice();

			Wrapper<AssetsInvoice> wrapper=new EntityWrapper<AssetsInvoice>();
			wrapper.eq("assets_id", newAssetsInfoExt.getAssetsId());
			List<AssetsInvoice>  listInvoice=assetsInvoiceMapper.selectList(wrapper);
			//查询所有的来源id
			List<Long> list=new ArrayList<Long>();
			if(listInvoice!=null&&listInvoice.size()>0){
				for(AssetsInvoice assetsInvoice:listInvoice){
					list.add(assetsInvoice.getId());
				}
			}

			if (listAssetsInvoice != null && listAssetsInvoice.size() > 0) {
				for (AssetsInvoice assetsInvoice : listAssetsInvoice) {
					assetsInvoice.setAssetsId(newAssetsInfoExt.getAssetsId());
					//assetsInvoice.setInvoiceMoney(assetsInvoice.getInvoiceMoney()*100);
					if(assetsInvoice.getId()==null){
						assetsInvoiceMapper.insert(assetsInvoice);
					}else{
						if(list.size()>0){
							if(list.contains(assetsInvoice.getId())){
								assetsInvoiceMapper.updateAssetsInvoice(assetsInvoice);
								//删除更新的id
								list.remove(assetsInvoice.getId());
							}

						}
					}

				}

			}
			//判断资金来源剩余的id进行删除
			if(list.size()>0){
				assetsInvoiceMapper.deleteBatchIds(list);
			}
			
			if (newContract != null&&(request.getContractAnnexList() != null || newContract.getContractName()!=null||newContract.getContractNo()!=null||request.getContractId()!=null||newContract.getContractPrice()!=null
					||newContract.getArchivesCode()!=null||newContract.getStartDate()!=null||newContract.getSupplierName()!=null)) {
				ContractAsset entity=BeanMapper.map(request, ContractAsset.class);
				oldContract = contractMapper.selectById(request.getContractId());
				if(request.getContractId()==null && null == oldContract){
					newContract.setCreateBy(authUser.getId());
					contractMapper.insert(newContract);
					entity.setContractId(newContract.getId());
					contractAssetMapper.insert(entity);
				}else{
					newContract.setId(request.getContractId());
					contractMapper.updateContractAsset(newContract);
				}
			}
							
			//合同附件编辑
			newContractAttachmentList = request.getContractAnnexList();			
			AssAssetsAnnex annexContract = assAssetsAnnexMapper.getContractAnnex(request.getAssetsId(),3, request.getContractId(), authUser);//查数据库合同附件
			AssAssetsAnnex annex3 = new AssAssetsAnnex();
			if (newContractAttachmentList !=null && newContractAttachmentList.size() >0) {
				if (annexContract  != null) {
					annex3.setId(annexContract.getId());
					annex3.setAnnexUrl(JSON.toJSONString(newContractAttachmentList));
					assAssetsAnnexMapper.updateById(annex3);
				}else {
					if(newContract.getId() !=null){
						annex3.setAnnexUrl(JSON.toJSONString(newContractAttachmentList));
						annex3.setAnnexType(3);//合同
						annex3.setAssetsId(request.getAssetsId());
						annex3.setContractId(newContract.getId());//附件绑定合同id
						annex3.setSysId(authUser.getTenantId());
						assAssetsAnnexMapper.insert(annex3);
					}				
				}
			}else if ((newContractAttachmentList ==null || (newContractAttachmentList != null && newContractAttachmentList.size()==0)) && annexContract != null) {
				annex3.setId(annexContract.getId());
				assAssetsAnnexMapper.deleteById(annex3);
			}
			//处理合同附件修改日志
			oldContractAttachmentList = annexContract==null?new ArrayList<>():JSON.parseArray(annexContract.getAnnexUrl(), AttachmentsBO.class);
		}
		//===============================================================================================================
		
		//======================================记录资产信息编辑操作日志==================================================
		//日志主表信息
		AssAssetsLog assAssetsLog = new AssAssetsLog();
		assAssetsLog.setAssetsId(newAssetsInfo.getId());
		//编辑的标签类别（1=设备信息，2=采购信息，3=合同信息，4=证件管理）
		assAssetsLog.setModuleType(request.getModuleType());
		//编辑
		assAssetsLog.setOperateType(AssetsLogOperateTypeEnum.EDIT.getNumber());
		assAssetsLog.setOperateBy(authUser.getId());
		assAssetsLog.setOperateByName(authUser.getRealName());
		assAssetsLog.setOperateTime(new Date());
		//异步保存资产修改日志明细信息
		AuthUser currentUser = WebSecurityUtils.getCurrentUser();//主线程当前登录人信息传值子线程
		String currentToken = WebSecurityUtils.getCurrentToken();//主线程当前token传值子线程
		new Thread(new AssetsLogDetailThread(
				currentUser,currentToken,
				assAssetsLog,assAssetsLogService,AssetsLogOperateTypeEnum.EDIT.getDesc(),
				//AssetsInfo日志数据
				oldAssetsInfo,newAssetsInfo, AssetsInfo.class,AssetsLogDetailTypeEnum.FIELD_ADD_EDIT.getNumber(), 
				//AssetsInfoExt日志数据
				oldAssetsInfoExt,newAssetsInfoExt,AssetsInfoExt.class, AssetsLogDetailTypeEnum.FIELD_ADD_EDIT.getNumber(),
				//招标附件
				oldInviteAttachmentList, newInviteAttachmentList,AssetsLogDetailTypeEnum.INVITE_ATTACHMENT.getNumber(),AssetsLogDetailTypeEnum.INVITE_ATTACHMENT.getDesc(),
				//验收附件
				oldCheckAttachmentList,newCheckAttachmentList,AssetsLogDetailTypeEnum.CHECK_ATTACHMENT.getNumber(),AssetsLogDetailTypeEnum.CHECK_ATTACHMENT.getDesc(),
				//资金来源
				oldAssetsFundSources, newAssetsFundSources,AssetsLogDetailTypeEnum.FIELD_ADD_EDIT.getNumber(), 
				//发票号
				oldInvoiceNo, newInvoiceNo,AssetsLogDetailTypeEnum.FIELD_ADD_EDIT.getNumber(), 
				//合同日志数据
				oldContract, newContract, Contract.class,AssetsLogDetailTypeEnum.FIELD_ADD_EDIT.getNumber(), 
				//合同附件
				oldContractAttachmentList,newContractAttachmentList,AssetsLogDetailTypeEnum.CONTRACT_ATTACHMENT.getNumber(),AssetsLogDetailTypeEnum.CONTRACT_ATTACHMENT.getDesc()
			)
		).start();
		//===============================================================================================================
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public void updateBatchAssetsStatus(Map<String,Object> map) {
		List<Integer> arry =  (List<Integer>)map.get("assetssIds");
		Integer statusFront = (Integer)map.get("status");
		List<Integer> list = Lists.newArrayList();
		//移除所有资产状态处于待报损、报损、退货的资产,外加状态无变化的资产
		if(arry !=null && arry.size()>0){
			for (Integer item : arry) {
				Integer status = assetsInfoMapper.getStatus(item);
				if(status !=null && (status>3 || status==statusFront)){
					list.add(item);
				}		
			}
			arry.removeAll(list);
		}
			
		//记录批量更新资产状态日志
		String tableName = ReflectUtils.getClazzTableName(AssetsInfo.class);
		AuthUser currentUser = WebSecurityUtils.getCurrentUser();
		List<AssAssetsLogDetail> logDetailList = new ArrayList<AssAssetsLogDetail>();
		for (Integer item : arry) {
			long assetsId = item.longValue();
			AssetsInfo oldAssetsInfo = assetsInfoMapper.selectById(assetsId);
			if(null != oldAssetsInfo){
				//日志主表信息
				AssAssetsLog assAssetsLog = new AssAssetsLog();
				assAssetsLog.setAssetsId(assetsId);
				//编辑的标签类别（1=设备信息，2=采购信息，3=合同信息，4=证件管理）
				assAssetsLog.setModuleType(AssetsLogModuleTypeEnum.ASSETS_INFO.getNumber());
				//编辑
				assAssetsLog.setOperateType(AssetsLogOperateTypeEnum.EDIT.getNumber());
				assAssetsLog.setOperateBy(currentUser.getId());
				assAssetsLog.setOperateByName(currentUser.getRealName());
				assAssetsLog.setOperateTime(new Date());
				assAssetsLog.setRemark(currentUser.getRealName()+"编辑了:资产状态");
				assAssetsLogService.insert(assAssetsLog);
				AssAssetsLogDetail logDetail = new AssAssetsLogDetail();
				logDetail.setAssetsLogId(assAssetsLog.getId());
				logDetail.setCreateTime(new Date());
				logDetail.setTableName(tableName);
				logDetail.setField("status");
				logDetail.setFieldName("资产状态");
				logDetail.setPropertyName("status");
				logDetail.setType(AssetsLogModuleTypeEnum.ASSETS_INFO.getNumber());
				logDetail.setNewValue(SysConstant.STATUS_NAME_MAP.get(oldAssetsInfo.getStatus()));
				logDetail.setOldValue(SysConstant.STATUS_NAME_MAP.get(Integer.parseInt(map.get("status").toString())));
				logDetail.setRemark("将"+(logDetail.getOldValue()==null?"无":logDetail.getOldValue())+"修改为"+logDetail.getNewValue());
				logDetailList.add(logDetail);
			}
		}
		if (null != logDetailList && logDetailList.size() > 0) {
			assAssetsLogDetailService.insertBatch(logDetailList);
		}
		
		if(arry != null && arry.size() > 0 && arry.size() ==1){
			AssetsInfo asset = assetsInfoMapper.selectById(arry.get(0));
			if(asset !=null){
				Integer status=null;
				if((status=asset.getStatus()) !=null){
					switch (status) {
					case 4:	
						throw ExceptionFactory.create("C_006");
					case 5:
						throw ExceptionFactory.create("C_007");
					case 6:	
						throw ExceptionFactory.create("C_008");
					default:
						break;
					}
				}			
			}			
		}
		assetsInfoMapper.updateBatchAssetsStatus(map);
	}

	@Override
	@Transactional
	public void updateBatchAssetsDepartment(Map<String, Object> map) {
		assetsInfoMapper.updateBatchAssetsDepartment(map);

	}

	@Override
	@Transactional
	public void updateAssetsName(Map<String, Object> map) {
		Long assetsId = Long.valueOf(String.valueOf(map.get("assetssId")));
		String assetsName = (String)map.get("assetsName");
		AssetsInfo oldAssetsInfo = assetsInfoMapper.selectById(assetsId);
		assetsInfoMapper.updateAssetsName(map);
		
		//记录更新生产商修改日志
		AuthUser currentUser = WebSecurityUtils.getCurrentUser();
		String tableName = ReflectUtils.getClazzTableName(AssetsInfo.class);
		if(null != oldAssetsInfo && !oldAssetsInfo.getAssetsName().equals(assetsName)){
			//日志主表信息
			AssAssetsLog assAssetsLog = new AssAssetsLog();
			assAssetsLog.setAssetsId(assetsId);
			//编辑的标签类别（1=设备信息，2=采购信息，3=合同信息，4=证件管理）
			assAssetsLog.setModuleType(AssetsLogModuleTypeEnum.ASSETS_INFO.getNumber());
			//编辑
			assAssetsLog.setOperateType(AssetsLogOperateTypeEnum.EDIT.getNumber());
			assAssetsLog.setOperateBy(currentUser.getId());
			assAssetsLog.setOperateByName(currentUser.getRealName());
			assAssetsLog.setOperateTime(new Date());
			assAssetsLog.setRemark(currentUser.getRealName()+"编辑了:设备名称");
			assAssetsLogService.insert(assAssetsLog);
			AssAssetsLogDetail logDetail = new AssAssetsLogDetail();
			logDetail.setAssetsLogId(assAssetsLog.getId());
			logDetail.setCreateTime(new Date());
			logDetail.setTableName(tableName);
			logDetail.setField("assets_name");
			logDetail.setFieldName("设备名称");
			logDetail.setType(AssetsLogModuleTypeEnum.ASSETS_INFO.getNumber());
			logDetail.setPropertyName("assetsName");
			logDetail.setNewValue(map.get("assetsName").toString());
			logDetail.setOldValue(oldAssetsInfo.getAssetsName());
			logDetail.setRemark("将"+(logDetail.getOldValue()==null?"无":logDetail.getOldValue())+"修改为"+logDetail.getNewValue());
			assAssetsLogDetailService.insert(logDetail);
		}
	}

	@Override
	@Transactional
	public void addAssetsInfo(AssetsInfoRequest data) {
		AssetsInfo newAssetsInfo = BeanMapper.map(data, AssetsInfo.class);
		AssetsInfoExt newAssetsInfoExt = BeanMapper.map(data, AssetsInfoExt.class);
		if (newAssetsInfo != null) {
			AuthUser authUser = WebSecurityUtils.getCurrentUser();
			Long tenantId = null;
			if (authUser != null) {
				//放开数据范围权限控制
				/*if(!AuthUserUtil.hasPower(data.getDeptId(),authUser)){
					throw ExceptionFactory.create("A_017");
				}*/
				newAssetsInfo.setSysId(authUser.getTenantId());
				tenantId = authUser.getTenantId();
				newAssetsInfo.setCreateBy(authUser.getId());
			}
			String assets_num = generateAssetsNum(tenantId);
			if (assets_num == null) {
				throw ExceptionFactory.create("A_004");
			}
			newAssetsInfo.setAssetsNum(assets_num);
			newAssetsInfo.setCreateTime(new Date());
			if(null == newAssetsInfo.getStatus()&&newAssetsInfo.getAssetsStatus()==1){
				//新增台账/预台账默认状态为在用
				newAssetsInfo.setStatus(AssetsStatusEnum.IN_USE.getNumber());
			}
			//新增台账/预台账默认维修状态为正常
			newAssetsInfo.setRepairStatus(AssetsRepairStatusEnum.NORMAL.getNumber());
			assetsInfoMapper.insert(newAssetsInfo);
			newAssetsInfoExt.setAssetsId(newAssetsInfo.getId());
			newAssetsInfoExt.setAssetsNum(assets_num);
			newAssetsInfoExt.setPollingFlag(1);
			newAssetsInfoExt.setMeasureFlag(0);

			if (data.getAssetsStatus() == 1) {
				// 台帐直接通过审核状态为2
				newAssetsInfoExt.setVerfyStatus(SysConstant.VERFY_STATUS_2);
			} else {
				// 预台帐待审核状态为0
				AssAssetsInfoOperate entity=new AssAssetsInfoOperate();
				entity.setAssetsId(newAssetsInfo.getId());
				entity.setOperateTime(new Date());
				entity.setOperateBy(authUser.getId());
				entity.setOperateStatus(SysConstant.OPERATE_1);
				assAssetsInfoOperateMapper.insert(entity);
				newAssetsInfoExt.setVerfyNum(OrderUtils.getOrderNum());
				newAssetsInfoExt.setVerfyStatus(SysConstant.VERFY_STATUS_0);
			}
			assetsInfoExtMapper.insert(newAssetsInfoExt);
			
			//日志主表信息
			AssAssetsLog assAssetsLog = new AssAssetsLog();
			assAssetsLog.setAssetsId(newAssetsInfo.getId());
			//编辑的标签类别（1=设备信息，2=采购信息，3=合同信息，4=证件管理）
			assAssetsLog.setModuleType(AssetsLogModuleTypeEnum.ASSETS_INFO.getNumber());
			//编辑
			assAssetsLog.setOperateType(AssetsLogOperateTypeEnum.ADD.getNumber());
			assAssetsLog.setOperateBy(authUser.getId());
			assAssetsLog.setOperateByName(authUser.getRealName());
			assAssetsLog.setOperateTime(new Date());
			assAssetsLog.setRemark(authUser.getRealName()+"新增了："+newAssetsInfo.getAssetsName());
			
			//异步保存资产修改日志明细信息
			AuthUser currentUser = WebSecurityUtils.getCurrentUser();//主线程当前登录人信息传值子线程
			String currentToken = WebSecurityUtils.getCurrentToken();//主线程当前token传值子线程
			new Thread(new AssetsLogDetailThread(
					currentUser,currentToken,
					assAssetsLog,assAssetsLogService,AssetsLogOperateTypeEnum.ADD.getDesc(),
					//AssetsInfo日志数据
					new AssetsInfo(),newAssetsInfo, AssetsInfo.class,AssetsLogDetailTypeEnum.FIELD_ADD_EDIT.getNumber(), 
					//AssetsInfoExt日志数据
					new AssetsInfoExt(),newAssetsInfoExt,AssetsInfoExt.class, AssetsLogDetailTypeEnum.FIELD_ADD_EDIT.getNumber(),
					//招标附件
					new ArrayList<AttachmentsBO>(), new ArrayList<AttachmentsBO>(),AssetsLogDetailTypeEnum.INVITE_ATTACHMENT.getNumber(),AssetsLogDetailTypeEnum.INVITE_ATTACHMENT.getDesc(),
					//验收附件
					new ArrayList<AttachmentsBO>(),new ArrayList<AttachmentsBO>(),AssetsLogDetailTypeEnum.CHECK_ATTACHMENT.getNumber(),AssetsLogDetailTypeEnum.CHECK_ATTACHMENT.getDesc(),
					//资金来源
					new ArrayList<AssetsFundSources>(),new ArrayList<AssetsFundSources>(),AssetsLogDetailTypeEnum.FIELD_ADD_EDIT.getNumber(), 
					//发票号
					null, null,AssetsLogDetailTypeEnum.FIELD_ADD_EDIT.getNumber(), 
					//合同日志数据
					new Contract(), new Contract(), Contract.class,AssetsLogDetailTypeEnum.FIELD_ADD_EDIT.getNumber(), 
					//合同附件
					new ArrayList<AttachmentsBO>(),new ArrayList<AttachmentsBO>(),AssetsLogDetailTypeEnum.CONTRACT_ATTACHMENT.getNumber(),AssetsLogDetailTypeEnum.CONTRACT_ATTACHMENT.getDesc()
				)
			).start();
			
		} else {
			throw ExceptionFactory.create("A_003");
		}
	}
	
	@Override
	@Transactional
	public void addPreAssetsInfo(PreAssetsInfoRequest data) {
		AssetsInfo assetsInfo = BeanMapper.map(data, AssetsInfo.class);
		AssetsInfoExt assetsInfoExt = BeanMapper.map(data, AssetsInfoExt.class);
		if (assetsInfo != null) {
			AuthUser authUser = WebSecurityUtils.getCurrentUser();
			Long tenantId = null;
			if (authUser != null) {
				//放开数据范围权限控制
				/*if(!AuthUserUtil.hasPower(data.getDeptId(),authUser)){
					throw ExceptionFactory.create("A_017");
				}*/
				assetsInfo.setSysId(authUser.getTenantId());
				tenantId = authUser.getTenantId();
				assetsInfo.setCreateBy(authUser.getId());
			}
			String assets_num = generateAssetsNum(tenantId);
			if (assets_num == null) {
				throw ExceptionFactory.create("A_004");
			}
			assetsInfo.setAssetsNum(assets_num);
			assetsInfo.setCreateTime(new Date());
			if(null == assetsInfo.getStatus()&&assetsInfo.getAssetsStatus()==1){
				//新增台账/预台账默认状态为在用
				assetsInfo.setStatus(AssetsStatusEnum.IN_USE.getNumber());
			}
			//新增台账/预台账默认维修状态为正常
			assetsInfo.setRepairStatus(AssetsRepairStatusEnum.NORMAL.getNumber());
			assetsInfo.setAssetsSource(0);
			assetsInfoMapper.insert(assetsInfo);
			assetsInfoExt.setAssetsId(assetsInfo.getId());
			assetsInfoExt.setAssetsNum(assets_num);
			assetsInfoExt.setPollingFlag(1);
			if (data.getAssetsStatus() == 1) {
				// 台帐直接通过审核状态为2
				assetsInfoExt.setVerfyStatus(SysConstant.VERFY_STATUS_2);
			} else {
				// 预台帐待审核状态为0
				AssAssetsInfoOperate entity=new AssAssetsInfoOperate();
				entity.setAssetsId(assetsInfo.getId());
				entity.setOperateTime(new Date());
				entity.setOperateBy(authUser.getId());
				entity.setOperateStatus(SysConstant.OPERATE_1);
				assAssetsInfoOperateMapper.insert(entity);
				assetsInfoExt.setVerfyNum(OrderUtils.getOrderNum());
				assetsInfoExt.setVerfyStatus(SysConstant.VERFY_STATUS_0);
			}
			assetsInfoExtMapper.insert(assetsInfoExt);
		} else {
			throw ExceptionFactory.create("A_003");
		}
	}


	@Override
	public List<TenantAssets> getAssetsByTenantIds(Long[] ids) {

		return assetsInfoMapper.getAssetsByTenantIds(ids);
	}


	@Override
	public Page<?> getPageAssets(Page<Assets> page, LedgerPaging query) {
		AuthUser authUser = WebSecurityUtils.getCurrentUser();
		if(StringUtils.isNotBlank(query.getKeyword())){
			query.setKeyword(query.getKeyword().replaceAll("%", "\\\\%").replaceAll("_", "\\\\_"));
		}
		List<Assets> list =null;
		if(query!=null&&query.getStatus()!=null&&query.getStatus().intValue()==8){
			//验收通过预台账数据
			list = this.assetsInfoMapper.getPageAssets2(page, query, authUser);
		}else if(query!=null&&query.getStatus()==null){
			//资产台账/验收通过预台账数据
			list = this.assetsInfoMapper.getPageAssets(page, query, authUser);
		}else{
			//资产台账数据
			list = this.assetsInfoMapper.getPageAssets3(page, query, authUser);
		}
		
		if (list == null) {
			return null;
		}
		StringBuffer deptIds = new StringBuffer("");
		for (Assets a : list) {
			/* 获取来源名称 */
			if (a.getAssetsSource() != null ) {
				a.setAssetsSourceName(SysConstant.AssetsSource.getText(a.getAssetsSource()));
			}
			/* 获取状态名称 */
			if(a.getAssetsStatus()!=null&&a.getAssetsStatus().intValue()==2){
				a.setStatusName("验收通过");
			}else{
				a.setStatusName(SysConstant.STATUS_NAME_MAP.get(a.getStatus()));
			}
			/* 获取所属科室id,拼接为ids */
			if (a.getDeptId() != null) {
				deptIds.append(a.getDeptId() + ",");
			}
			/*获取维修状态名称*/
			a.setRepairStatusName(SysConstant.REPAIR_STATUS_NAME_MAP.get(a.getRepairStatus()));
		}
		/* 获取科室名称 */
		if (deptIds != null && !deptIds.equals("")) {
			Map<String, String> deptNameMap = findDeptNameToMap(deptIds.toString());// 查询部门名称并存入map
			/* 将对应的名称放入assets */
			for (Assets assets : list) {
				if (deptNameMap != null) {// 如果查到部门名称则赋值
					assets.setDeptName(deptNameMap.get("" + assets.getDeptId()));
				}
			}
		}
		page.setRecords(list);
		return page;
	}


	@Override
	public void getList(List<AssAssetsInfoOperate> list) {
		if (list != null && list.size() > 0) {
			StringBuilder sb = new StringBuilder();
			for (AssAssetsInfoOperate assAssetsInfoOperate : list) {
				if (assAssetsInfoOperate.getOperateBy() != null) {
					sb.append(assAssetsInfoOperate.getOperateBy()).append(",");
				}
			}
			Map<String, String> userNameMap = findUserNameToMap(sb.substring(0, sb.length() - 1));// 查找并已经将信息放入map
			if (userNameMap != null) {
				for (AssAssetsInfoOperate assAssetsInfoOperate : list) {
					if (assAssetsInfoOperate.getOperateBy() != null) {
						assAssetsInfoOperate.setOperateName(userNameMap.get("" + assAssetsInfoOperate.getOperateBy()));
					}
				}
			}
		}
	}

	@Override
	public int updateAfterSelect(AssetsInfo info) {
		return this.assetsInfoMapper.updateAfterSelect(info);
	}

	@Override
	public List<AssetsQc> getQcAssetsList(Long tenantId, Long[] deptIds) {
		AuthUser authUser = WebSecurityUtils.getCurrentUser();
		List<AssetsQc> list = assetsInfoMapper.getQcAssetsList(tenantId, deptIds, authUser);
		
		Set<Long> assetsDeptIds = new HashSet<Long>();
		for (AssetsQc assetsQc : list) {
			if (assetsQc.getAssetsDeptId() != null) {
				assetsDeptIds.add(assetsQc.getAssetsDeptId());
			}
		}
		StringBuffer assetsDeptIdsStr = new StringBuffer("");
		for (Long assetsDeptId : assetsDeptIds) {
			assetsDeptIdsStr.append(assetsDeptId + ",");
		}
		if (assetsDeptIdsStr != null && !assetsDeptIdsStr.equals("")) {
			Map<String, String> deptNameMap = findDeptNameToMap(assetsDeptIdsStr.toString());
			for (AssetsQc assetsQc : list) {
				if (deptNameMap != null) {
					assetsQc.setAssetsDeptName(deptNameMap.get("" + assetsQc.getAssetsDeptId()));
				}
			}
		}
		return list;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Page<AssetsQc> getQcAssetsPage(Page page, Long tenantId, Long[] deptIds) {
		AuthUser authUser = WebSecurityUtils.getCurrentUser();
		List<AssetsQc> list = assetsInfoMapper.getQcAssetsPage(page,tenantId, deptIds, authUser);
		
		Set<Long> assetsDeptIds = new HashSet<Long>();
		for (AssetsQc assetsQc : list) {
			if (assetsQc.getAssetsDeptId() != null) {
				assetsDeptIds.add(assetsQc.getAssetsDeptId());
			}
		}
		StringBuffer assetsDeptIdsStr = new StringBuffer("");
		for (Long assetsDeptId : assetsDeptIds) {
			assetsDeptIdsStr.append(assetsDeptId + ",");
		}
		if (assetsDeptIdsStr != null && !assetsDeptIdsStr.equals("")) {
			Map<String, String> deptNameMap = findDeptNameToMap(assetsDeptIdsStr.toString());
			for (AssetsQc assetsQc : list) {
				if (deptNameMap != null) {
					assetsQc.setAssetsDeptName(deptNameMap.get("" + assetsQc.getAssetsDeptId()));
				}
			}
		}
		page.setRecords(list);
		return page;
	}

	@Override
	public void updateBatchByIds(List<Long> listAssetsIds) {
		assetsInfoMapper.updateBatchByIds(listAssetsIds);
		
	}
	
	@Override
	public List<AssetsPm> getPmAssetsList(Long tenantId,Long departmentId,String keyword) {
		AuthUser authUser = WebSecurityUtils.getCurrentUser();
		List<AssetsPm> list = assetsInfoMapper.getPmAssetsList(tenantId,departmentId,keyword,authUser);
		
		Set<Long> assetsDeptIds = new HashSet<Long>();
		for (AssetsPm assetsPm : list) {
			if (assetsPm.getDepartmentId() != null) {
				assetsDeptIds.add(assetsPm.getDepartmentId());
			}
			switch(assetsPm.getEquipmentStatusType()){
				case 1:
					assetsPm.setEquipmentStatusText(AssetsStatusEnum.IN_STORE.getDesc());
					break;
				case 2:
					assetsPm.setEquipmentStatusText(AssetsStatusEnum.IN_USE.getDesc());
					break;
				case 3:
					assetsPm.setEquipmentStatusText(AssetsStatusEnum.PRE_REGISTRATION.getDesc());
					break;
				case 4:
					assetsPm.setEquipmentStatusText(AssetsStatusEnum.UN_REPORT_LOSS.getDesc());
					break;
				case 5:
					assetsPm.setEquipmentStatusText(AssetsStatusEnum.REPORT_LOSS.getDesc());
					break;
				case 6:
					assetsPm.setEquipmentStatusText(AssetsStatusEnum.REFUND.getDesc());
					break;
				case 8:
					assetsPm.setEquipmentStatusText(AssetsStatusEnum.VERIFY.getDesc());
					break;
				default:
					break;
			}
		}
		StringBuffer assetsDeptIdsStr = new StringBuffer("");
		for (Long assetsDeptId : assetsDeptIds) {
			assetsDeptIdsStr.append(assetsDeptId + ",");
		}
		if (assetsDeptIdsStr != null && !assetsDeptIdsStr.equals("")) {
			Map<String, String> deptNameMap = findDeptNameToMap(assetsDeptIdsStr.toString());
			for (AssetsPm assetsPm : list) {
				if (deptNameMap != null) {
					assetsPm.setDepartmentName(deptNameMap.get("" + assetsPm.getDepartmentId()));
				}
			}
		}
		return list;
	}

	@Override
	public Page<AssetsPm> getPmAssetsPage(Page<AssetsPm> page, PmAssertPaging query,Long tenantId) {
		AuthUser authUser = WebSecurityUtils.getCurrentUser();
		List<AssetsPm> list = assetsInfoMapper.getPmAssetsPage(page,tenantId,query.getDepartmentId(),query.getKeyword(),authUser);
		
		Set<Long> assetsDeptIds = new HashSet<Long>();
		for (AssetsPm assetsPm : list) {
			if (assetsPm.getDepartmentId() != null) {
				assetsDeptIds.add(assetsPm.getDepartmentId());
			}
			if(null != assetsPm.getEquipmentStatusType()){
				switch(assetsPm.getEquipmentStatusType()){
					case 1:
						assetsPm.setEquipmentStatusText(AssetsStatusEnum.IN_STORE.getDesc());
						break;
					case 2:
						assetsPm.setEquipmentStatusText(AssetsStatusEnum.IN_USE.getDesc());
						break;
					case 3:
						assetsPm.setEquipmentStatusText(AssetsStatusEnum.PRE_REGISTRATION.getDesc());
						break;
					case 4:
						assetsPm.setEquipmentStatusText(AssetsStatusEnum.UN_REPORT_LOSS.getDesc());
						break;
					case 5:
						assetsPm.setEquipmentStatusText(AssetsStatusEnum.REPORT_LOSS.getDesc());
						break;
					case 6:
						assetsPm.setEquipmentStatusText(AssetsStatusEnum.REFUND.getDesc());
						break;
					case 8:
						assetsPm.setEquipmentStatusText(AssetsStatusEnum.VERIFY.getDesc());
						break;
					default:
						break;
				}
			}
		}
		StringBuffer assetsDeptIdsStr = new StringBuffer("");
		for (Long assetsDeptId : assetsDeptIds) {
			assetsDeptIdsStr.append(assetsDeptId + ",");
		}
		if (assetsDeptIdsStr != null && !assetsDeptIdsStr.equals("")) {
			Map<String, String> deptNameMap = findDeptNameToMap(assetsDeptIdsStr.toString());
			for (AssetsPm assetsPm : list) {
				if (deptNameMap != null) {
					assetsPm.setDepartmentName(deptNameMap.get("" + assetsPm.getDepartmentId()));
				}
			}
		}
		
		page.setRecords(list);
		return page;
	}

	@Override
	public Map<String, Object> selectListSql(String sql) {
		List<Map<String, Object>> list =  assetsInfoMapper.selectListSql(sql);
		return (null != list && list.size() > 0) ? list.get(0) : null;
	}

	@Override
	public Page<MtAssets> getMtAssetsPage(MtAssertQuery query) {
		Page<MtAssets> page = query.getPage();
		AuthUser currentUser = WebSecurityUtils.getCurrentUser();
		String keyword = StringUtils.trimToNull(query.getKeyword());
		if(keyword !=null){
			if (keyword.startsWith("%") || keyword.startsWith("[") || keyword.startsWith("[]") || keyword.startsWith("_")) {
				query.setKeyword('\\'+keyword);
			}
		}
		List<MtAssets> mtAssets = assetsInfoMapper.getMtAssetsPage(page, query, currentUser);
		if(mtAssets!=null&&mtAssets.size()>0){
			Set<Long> deptIds = new HashSet<Long>();
			for (MtAssets mtAsset : mtAssets) {
				if (mtAsset.getDeptId() != null) {
					deptIds.add(mtAsset.getDeptId());
				}
			}
			StringBuffer assetsDeptIdsStr = new StringBuffer("");
			for (Long deptId : deptIds) {
				assetsDeptIdsStr.append(deptId + ",");
			}
			if (assetsDeptIdsStr != null && !assetsDeptIdsStr.equals("")) {
				Map<String, String> deptNameMap = findDeptNameToMap(assetsDeptIdsStr.toString());
				for (MtAssets mtAsset : mtAssets) {
					if (deptNameMap != null) {
						mtAsset.setDeptName(deptNameMap.get("" + mtAsset.getDeptId()));
					}
				}
			}
		}
		page.setRecords(mtAssets);	
		return page;
	}

	@Override
	public void changeMtPlanFlag(List<Long> assetIds, Integer flag) {
		assetsInfoExtMapper.changeMtPlanFlagBatch(assetIds, flag);
	}
	
	/**
	 * 获取资产统计概览数据
	 * @return
	 */
	@Override
	public List<AssetsStatsVo> getAssetsData() {
		//本天开始时间
		Calendar cal = Calendar.getInstance();
		Date currentTime = cal.getTime();	
		Date endTime = RemindDateUtils.getCurrentDayStartTime(currentTime);
		//前一天时间
		cal.add(Calendar.DATE, -1);
		Date preDayTime = cal.getTime();
	
	    List<AssetsStatsVo> assetsStatsVoList = assetsInfoMapper.statsAssetOverview(endTime);
	    for (AssetsStatsVo assetsStatsVo : assetsStatsVoList) {
	        //统计维修中占比
	        Long assetsRepairAssetsNum = assetsStatsVo.getAssetsRepairAssetsNum();
	        Long assetsUnRepairAssetsNum = assetsStatsVo.getAssetsUnrepairAssetsNum();
	        Long totalAssetsNum = assetsRepairAssetsNum + assetsUnRepairAssetsNum;
	        if(0 != totalAssetsNum) {
	            Double assetsRepairPercent = new BigDecimal(((float)assetsRepairAssetsNum*1.0/totalAssetsNum)*100).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
	            assetsStatsVo.setAssetsRepairPercent(assetsRepairPercent);
	            assetsStatsVo.setAssetsUnrepairPercent(new BigDecimal(100-assetsRepairPercent).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue());
	        }
	        assetsStatsVo.setCountDate(preDayTime);
	        assetsStatsVo.setCountTime(new Date());
	        //处理资产占比
	        List<AssDistributionCapitalRange> assDistributionCapitalRangeList = assDistributionCapitalRangeMapper.selectByTenantId(assetsStatsVo.getTenantId());
	        //未配置自定义资产占比分布
	        if (assDistributionCapitalRangeList == null || (null != assDistributionCapitalRangeList && assDistributionCapitalRangeList.size() == 0)) {
	            //获取系统默认资产占比分布
	            assDistributionCapitalRangeList = assDistributionCapitalRangeMapper.selectDefault();
	        }
	        List<AssetsDistributionData> assetsDistributionDataList = new ArrayList<AssetsDistributionData>();
	        for (AssDistributionCapitalRange assDistributionCapitalRange : assDistributionCapitalRangeList) {
	            AssetsDistributionData assetsDistributionData = new AssetsDistributionData();
	            Integer totalNum = assetsInfoMapper.statsDistributionCapitalRange(assDistributionCapitalRange.getSort(),endTime,assetsStatsVo.getTenantId(), assDistributionCapitalRange.getMinCapital()==null?null:assDistributionCapitalRange.getMinCapital()*10000*100, assDistributionCapitalRange.getMaxCapital()==null?null:assDistributionCapitalRange.getMaxCapital()*10000*100);
	            if ( 0 != assetsStatsVo.getAssetsTotalNum()) {
	                Double distributionProportion = new BigDecimal(((float)totalNum*1.0/assetsStatsVo.getAssetsTotalNum())*100).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
	                assetsDistributionData.setDistributionProportion(distributionProportion); 
	            }
	            assetsDistributionData.setDistributionRangeId(assDistributionCapitalRange.getId());
	            assetsDistributionData.setRemarks(assDistributionCapitalRange.getRemarks());
	            assetsDistributionData.setSort(assDistributionCapitalRange.getSort());
	            assetsDistributionDataList.add(assetsDistributionData);
	        }
	        assetsStatsVo.setAssetsDistributionData(JSON.toJSONString(assetsDistributionDataList));
        }
	    return assetsStatsVoList;
	}

	@Override
	public List<AssetsStats2Vo> addAssetsDataMonth() {
		//本天开始时间
		Calendar cal = Calendar.getInstance();
		Date currentTime = cal.getTime();	
		Date endTime = RemindDateUtils.getCurrentDayStartTime(currentTime);
		List<AssetsStats2Vo> list = assetsInfoMapper.statsAssetsStats2(endTime);	
		return list;
	}

    @Override
    public AssetsScanVO getAssetsInfoByScanResult(String scanResult, Long tenantId) {
        return assetsInfoMapper.getAssetsInfoByScanResult(scanResult, tenantId);
    }

	@Override
	public List<MdAssetsVO> getMdAssets(String assetsName) {
		if(assetsName == null || "".equals(assetsName)){
			return new ArrayList<MdAssetsVO>();
		}	
		if (assetsName.startsWith("%") || assetsName.startsWith("[") || assetsName.startsWith("[]") || assetsName.startsWith("_")) {
			assetsName='\\'+assetsName;
		}
		AuthUser currentUser = WebSecurityUtils.getCurrentUser();
		Long tenantId = currentUser.getTenantId();
		List<MdAssetsVO> mdAssets = assetsInfoMapper.getMdAssets(tenantId, assetsName);
		//移除质控单中暂存、待审核的设备
		String token = WebSecurityUtils.getCurrentToken();
		Result<List<Long>> re = qcClientService.getMdAssetsExist(token);
		if(re!=null&&"200".equals(re.getCode())){
			List<Long> ids = re.getData();
			mdAssets.removeAll(ids);
		}
		if(mdAssets != null && mdAssets.size() > 0){
			Set<Long> deptIds = new HashSet<Long>();
			for (MdAssetsVO ma : mdAssets) {
				if (ma.getDeptId() != null) {
					deptIds.add(ma.getDeptId());
				}
			}
			StringBuffer assetsDeptIdsStr = new StringBuffer("");
			for (Long deptId : deptIds) {
				assetsDeptIdsStr.append(deptId + ",");
			}
			if (assetsDeptIdsStr != null && !assetsDeptIdsStr.equals("")) {
				Map<String, String> deptNameMap = findDeptNameToMap(assetsDeptIdsStr.toString());
				for (MdAssetsVO ma : mdAssets) {
					if (deptNameMap != null) {
						ma.setDeptName(deptNameMap.get("" + ma.getDeptId()));
					}
				}
			}
		}
		return mdAssets;
	}
	
}
