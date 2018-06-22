package com.aek.ebey.assets.service.impl;

import com.aek.ebey.assets.constant.SysConstant;
import com.aek.ebey.assets.mapper.AssAssetsTransferDetailMapper;
import com.aek.ebey.assets.mapper.AssAssetsTransferMapper;
import com.aek.ebey.assets.mapper.AssetsInfoExtMapper;
import com.aek.ebey.assets.mapper.AssetsInfoMapper;
import com.aek.ebey.assets.model.AssAssetsTransfer;
import com.aek.ebey.assets.model.AssAssetsTransferDetail;
import com.aek.ebey.assets.model.AssetsInfo;
import com.aek.ebey.assets.model.AssetsInfoExt;
import com.aek.ebey.assets.model.DeptNameAndUserName;
import com.aek.ebey.assets.model.TransferPage;
import com.aek.ebey.assets.model.bo.ApplyInfo;
import com.aek.ebey.assets.model.bo.AssetBo;
import com.aek.ebey.assets.model.bo.BillInfo;
import com.aek.ebey.assets.model.bo.OperateXX;
import com.aek.ebey.assets.model.query.TransferQuery;
import com.aek.ebey.assets.model.request.AssAssetsTransferAuditRequest;
import com.aek.ebey.assets.model.request.AssAssetsTransferRequest;
import com.aek.ebey.assets.model.vo.AssetTransferPageVo;
import com.aek.ebey.assets.model.vo.TransferPrintVo;
import com.aek.ebey.assets.model.vo.TransferVo;
import com.aek.ebey.assets.service.AssAssetsTransferDetailService;
import com.aek.ebey.assets.service.AssAssetsTransferService;
import com.aek.ebey.assets.service.AssetsInfoService;
import com.aek.ebey.assets.service.CodeInfoService;
import com.aek.ebey.assets.service.feign.RepairClientService;
import com.aek.ebey.assets.service.feign.UserClientService;
import com.baomidou.mybatisplus.plugins.Page;
import com.google.common.collect.Lists;
import com.aek.common.core.BeanMapper;
import com.aek.common.core.Result;
import com.aek.common.core.base.BaseServiceImpl;
import com.aek.common.core.exception.ExceptionFactory;
import com.aek.common.core.serurity.WebSecurityUtils;
import com.aek.common.core.serurity.model.AuthUser;
import com.aek.common.core.util.DateUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 资产转科表 服务实现类
 * </p>
 *
 * @author aek
 * @since 2017-12-11
 */
@Service
@Transactional
public class AssAssetsTransferServiceImpl extends BaseServiceImpl<AssAssetsTransferMapper,AssAssetsTransfer> implements AssAssetsTransferService {

	@Autowired
	private AssAssetsTransferMapper assAssetsTransferMapper;
	@Autowired
	private AssetsInfoService assetsInfoService;
	@Autowired
	private UserClientService userClientService;
	@Autowired
	private CodeInfoService codeInfoService;
	@Autowired
	private AssAssetsTransferService assAssetsTransferService;
	@Autowired
	private AssetsInfoMapper assetsInfoMapper;
	@Autowired
	private AssetsInfoExtMapper assetsInfoExtMapper;
	@Autowired
	private AssAssetsTransferDetailService assAssetsTransferDetailService;
	@Autowired
	private AssAssetsTransferDetailMapper assAssetsTransferDetailMapper;
	@Autowired
	private RepairClientService repairClientService;
	
	
	@Override
	@Transactional
	public void addTransfer(AssAssetsTransferRequest req) {
		AssAssetsTransfer assetsTransfer = BeanMapper.map(req, AssAssetsTransfer.class);
		if(assetsTransfer != null){
			Date now = new Date();
			AuthUser currentUser = WebSecurityUtils.getCurrentUser();
			assetsTransfer.setApplyerName(currentUser.getRealName());
			assetsTransfer.setTenantId(currentUser.getTenantId());
			assetsTransfer.setTenantName(currentUser.getTenantName());
			assetsTransfer.setApplyerId(currentUser.getId());
			assetsTransfer.setCreatTime(now);
			assetsTransfer.setDeptManageName(req.getDirector());
			assetsTransfer.setStatus(SysConstant.TRANSFER_DOC_STATUS_2);
			assetsTransfer.setToDeptId(req.getDept());
			assetsTransfer.setApplyDesc(req.getIllustration());
			//选中设备
			List<Long> assetsIds = req.getIds();
			//校验资产是否在转科审核中
			if(assetsIds !=null && assetsIds.size() > 0 ){
				List<AssetsInfo> checkIsTransfer = assetsInfoMapper.checkIsTransfer(assetsIds,SysConstant.TRANSFER_STATUS_1);
				if(checkIsTransfer !=null&&checkIsTransfer.size() > 0){
					throw ExceptionFactory.create("C_005");
				}
			}			
			List<AssetsInfo> list = Lists.newArrayList();
			StringBuilder sb = new StringBuilder();
			Long deptIdFrom=null;
			for (Long id : assetsIds) {
				AssetsInfo assetsInfo = new AssetsInfo();
				assetsInfo.setId(id);
				assetsInfo.setTransferStatus(SysConstant.TRANSFER_STATUS_1);
				list.add(assetsInfo);	
				AssetsInfo asset = assetsInfoService.selectById(id);
				if(asset != null){
					sb.append(asset.getAssetsName()+",");
					if(asset.getDeptId()!=null){
						deptIdFrom=Long.valueOf(asset.getDeptId());
					}
				}		
			}
			//批量更新设备转科状态
			assetsInfoService.updateBatchById(list);
			//转科单号
			String transferNum = generateTransferNum(currentUser.getTenantId());
			if (transferNum == null) {
				throw ExceptionFactory.create("A_004");
			}
			assetsTransfer.setTransferNum(transferNum);
			assetsTransfer.setAssetsNames(sb.toString().substring(0,sb.length()-1));
			assetsTransfer.setFromDeptId(deptIdFrom);
			assetsTransfer.setToDeptName(findDeptNameToMap(String.valueOf(req.getDept())).get(""+req.getDept()));
			assAssetsTransferMapper.insert(assetsTransfer);
			//冗余转科单资产明细
			List<AssAssetsTransferDetail> transferDetailList = Lists.newArrayList();
			for (Long id : assetsIds) {
				AssetsInfo assetInfo = assetsInfoService.selectById(id);			
				AssetsInfoExt assetInfoExt = assetsInfoExtMapper.getAssetByAssetId(id);
				AssAssetsTransferDetail transferDetail = new AssAssetsTransferDetail();
				if(assetInfo !=null){
					transferDetail.setTransferId(assetsTransfer.getId());
					transferDetail.setAssetsId(assetInfo.getId());
					transferDetail.setAssetsNum(assetInfo.getAssetsNum());
					transferDetail.setAssetsSpec(assetInfo.getAssetsSpec());
					transferDetail.setAssetsImgUrl(assetInfo.getAssetsImg());
					transferDetail.setSerialNum(assetInfoExt.getSerialNum());
					if(assetInfo.getDeptId()!=null){
						transferDetail.setDeptId(Long.valueOf(assetInfo.getDeptId()));
					}				
					String unitName = codeInfoService.getCodeInfoMap(SysConstant.UNIT).get(String.valueOf(assetInfo.getUnitId()));
					transferDetail.setUnitId(assetInfo.getUnitId());
					transferDetail.setUnitName(unitName);
					Map<String, String> deptNameMap = null;
					String deptId=null;
					if ((deptId=String.valueOf(assetInfo.getDeptId())) != null) {
						deptNameMap = findDeptNameToMap(deptId);
					}
					//所在部门
					if (deptNameMap != null) {
						transferDetail.setDeptName(deptNameMap.get(""+ assetInfo.getDeptId()));
					}
					transferDetail.setAssetsName(assetInfo.getAssetsName());
					transferDetail.setOperate(SysConstant.TRANSFER_DOC_ASSET_STATUS_1);
				}
				if(assetInfoExt !=null){
					transferDetail.setFactoryName(assetInfoExt.getFactoryName());
				}
				transferDetailList.add(transferDetail);			
			}
			assAssetsTransferDetailService.insertBatch(transferDetailList);
		}else {
			throw ExceptionFactory.create("A_003");
		}
			
	}
	
	@Transactional
	public String generateTransferNum(Long tenantId){
		if (tenantId==null) {
			throw ExceptionFactory.create("O_006");
		}
		Long sn = assetsInfoService.getSerialNumber(tenantId, 2, 1, true);
		return formatSn(tenantId, sn);
	}
	
	private String formatSn(Long tenantId, Long sn) {
		StringBuilder sb = new StringBuilder();
		sb.append("ZK");
		String date = DateUtil.format(new Date(), DateUtil.DATE_PATTERN.YYYYMMDD);
		sb.append(date).append(String.format("%04d", sn));
		return sb.toString();
	}

	@Override
	public TransferVo getTransfer(Long transferId,Integer status) {//status备用
		AssAssetsTransfer transfer = assAssetsTransferMapper.selectById(transferId);
		if(transfer == null){
			return null;
		}
		//单据状态(备用)
		SysConstant.TRANSFER_DOC_STATUS_MAP.get(transfer.getStatus());
				
		List<AssetBo> mapList = Lists.newArrayList();
		List<AssAssetsTransferDetail> transferDetails = assAssetsTransferDetailMapper.getTransferDetail(transfer.getId());
		if(transferDetails !=null && transferDetails.size() >0){
			//mapList = BeanMapper.mapList(transferDetails, AssetBo.class);
			for (AssAssetsTransferDetail transferDetail : transferDetails) {
				AssetBo assetBo = new AssetBo();
				assetBo.setAssetsSpec(transferDetail.getAssetsSpec());
				assetBo.setAssetsId(transferDetail.getAssetsId());
				assetBo.setAssetsNum(transferDetail.getAssetsNum());
				assetBo.setSerialNum(transferDetail.getSerialNum());;
				assetBo.setAssetsName(transferDetail.getAssetsName());
				assetBo.setStatus(transferDetail.getOperate());
				assetBo.setFactoryName(transferDetail.getFactoryName());
				assetBo.setDeptName(transferDetail.getDeptName());
				if(transferDetail.getUnitName() != null){
					assetBo.setAssetsUnit(transferDetail.getUnitName());  
				}
				mapList.add(assetBo);
			}		
		}
		
		TransferVo transferVo = new TransferVo();
		BillInfo billInfo = new BillInfo();
		ApplyInfo applyInfo = new ApplyInfo();
		List<OperateXX> list = Lists.newArrayList();
		if(transfer.getStatus() == SysConstant.TRANSFER_DOC_STATUS_1){
			OperateXX operateXX1 = new OperateXX();
			OperateXX operateXX2 = new OperateXX();
			operateXX1.setName(transfer.getAuditerName());
			operateXX1.setOperate("审核通过");
			operateXX1.setTime(transfer.getAuditTime());
			operateXX2.setName(transfer.getApplyerName());
			operateXX2.setOperate("提交转科申请");
			operateXX2.setTime(transfer.getCreatTime());
			list.add(operateXX1);
			list.add(operateXX2);
		}
		if(transfer.getStatus() == SysConstant.TRANSFER_DOC_STATUS_3){
			OperateXX operateXX1 = new OperateXX();
			OperateXX operateXX2 = new OperateXX();
			operateXX1.setName(transfer.getAuditerName());
			operateXX1.setOperate("审核未通过");
			operateXX1.setTime(transfer.getAuditTime());
			operateXX2.setName(transfer.getApplyerName());
			operateXX2.setOperate("提交转科申请");
			operateXX2.setTime(transfer.getCreatTime());
			list.add(operateXX1);
			list.add(operateXX2);
		}
		if(transfer.getStatus() == SysConstant.TRANSFER_DOC_STATUS_2){
			OperateXX operateXX = new OperateXX();
			operateXX.setName(transfer.getApplyerName());
			operateXX.setOperate("提交转科申请");
			operateXX.setTime(transfer.getCreatTime());
			list.add(operateXX);
		}
		
		
		
		billInfo.setNum(transfer.getTransferNum());
		billInfo.setId(transferId);
		if(transfer.getStatus() == SysConstant.TRANSFER_DOC_STATUS_2){
			billInfo.setStatus("待审核");
		}
		if(transfer.getStatus() == SysConstant.TRANSFER_DOC_STATUS_1){
			billInfo.setStatus("审核通过");
		}
		if(transfer.getStatus() == SysConstant.TRANSFER_DOC_STATUS_3){
			billInfo.setStatus("审核未通过");
		}
		billInfo.setResults(list);
		
		applyInfo.setDirector(transfer.getDeptManageName());
		applyInfo.setSuggestion(transfer.getAuditOpinion());
		applyInfo.setIllustration(transfer.getApplyDesc());
		Map<String, String> findDeptNameToMap = findDeptNameToMap(String.valueOf(transfer.getToDeptId()));
		applyInfo.setDeptName(findDeptNameToMap.get(""+transfer.getToDeptId()));
		applyInfo.setAssetList(mapList);
		
		transferVo.setBillInfo(billInfo);
		transferVo.setApplyInfo(applyInfo);
		transferVo.setId(transfer.getId());
				
		return transferVo;
	}
		  
	//查找部门名称
	private Map<String, String> findDeptNameToMap(String ids) {
		Map<String, String> map = new HashMap<>();
		if (ids != null && !ids.equals("")){//获取部门名称，存入map
			Result<List<DeptNameAndUserName>> deptName = userClientService.findByDeptIds(ids, WebSecurityUtils.getCurrentToken());
			if (deptName != null && deptName.getData() != null && deptName.getData().size() != 0) {
				for (DeptNameAndUserName dname : deptName.getData()) {
					map.put("" + dname.getId(), dname.getName());// dname.getName());//id为KEY，名称为value
				}
			}
		}
		return map;
	}

	@Override
	@Transactional
	public void cancleAsset(Long id,Long assetId) {
		AssAssetsTransferDetail transferDetail = assAssetsTransferDetailMapper.getTransferDetailByAssetsId(id, assetId);
		if(transferDetail != null){
			transferDetail.setOperate(SysConstant.TRANSFER_DOC_ASSET_STATUS_2);
			assAssetsTransferDetailMapper.updateById(transferDetail);		
			//更新台账设备状态
			AssetsInfo assetsInfo = new AssetsInfo();
			assetsInfo.setId(assetId);
			assetsInfo.setTransferStatus(SysConstant.TRANSFER_STATUS_2);
			assetsInfoService.updateById(assetsInfo);
		}
		
	}
	
	//字符串转集合
	public List<Long> asList(String ids){
		List<Long> list = Lists.newArrayList();
		String[] idss = ids.split(",");
		for (String item : idss) {
			Long itemL = Long.valueOf(item);
			list.add(itemL);
		}	
		return list;	
	}

	@SuppressWarnings("unused")
	@Override
	public void auditTransfer(AssAssetsTransferAuditRequest req) {
		if(req == null){
			return;
		}
		Long id=req.getId();
		if(id != null){
			AssAssetsTransfer transferById = assAssetsTransferMapper.selectById(id);
			if(transferById != null){
				if(transferById.getStatus() != SysConstant.TRANSFER_DOC_STATUS_2){
					throw ExceptionFactory.create("C_009");
				}
			}
			List<AssAssetsTransferDetail> transferDetails = assAssetsTransferDetailMapper.getTransferDetail(id);
			if(transferDetails != null && transferDetails.size() > 0){
				List<AssetsInfo> list = Lists.newArrayList();
				for (AssAssetsTransferDetail transferDetail : transferDetails) {
						AssetsInfo assetsInfo = new AssetsInfo();
						assetsInfo.setId(transferDetail.getAssetsId());
						assetsInfo.setTransferStatus(SysConstant.TRANSFER_STATUS_2);
						list.add(assetsInfo);
				}
				//更新资产台账设备状态
				if(list != null && list.size() >0){
					assetsInfoService.updateBatchById(list);
				}
			}
			//转科通过，更新台账状态
			if(req.getStatus() == SysConstant.TRANSFER_DOC_STATUS_1){
				AssAssetsTransfer transfer = assAssetsTransferMapper.selectById(req.getId());
				if(transfer != null){
					List<AssetsInfo> passList = Lists.newArrayList();
					for (AssAssetsTransferDetail transferDetail : transferDetails) {
						if(transferDetail.getOperate() != SysConstant.TRANSFER_DOC_ASSET_STATUS_2){
							AssetsInfo assetsInfo = new AssetsInfo();
							assetsInfo.setId(transferDetail.getAssetsId());
							assetsInfo.setDeptId(transfer.getToDeptId().intValue());
							passList.add(assetsInfo);
						}
					}
					assetsInfoService.updateBatchById(passList);
				}						
			}
			AuthUser currentUser = WebSecurityUtils.getCurrentUser();
			String token = WebSecurityUtils.getCurrentToken();
			//获取设备所在科室
			String deptName = assAssetsTransferDetailMapper.getDeptNameByTransferId(id);
			
			AssAssetsTransfer transfer = new AssAssetsTransfer();
			transfer.setId(id);
			transfer.setAuditerId(currentUser.getId());
			transfer.setAuditerName(currentUser.getRealName());
			transfer.setAuditOpinion(req.getSuggestion());
			transfer.setAuditRemark(req.getRemarks());
			if(req.getStatus() == 0){
				transfer.setStatus(SysConstant.TRANSFER_DOC_STATUS_3);
				//审批未通过发送消息
				repairClientService.sendMsg("转科审核未通过，查看详情", id, deptName, transferById.getApplyerId(), 7,token);
			}
			if(req.getStatus() == 1){
				transfer.setStatus(SysConstant.TRANSFER_DOC_STATUS_1);
				//审批通过发送消息
				repairClientService.sendMsg("转科审核通过，查看详情", id, deptName, transferById.getApplyerId(), 7,token);
			}
			Date now = new Date();
			transfer.setAuditTime(now);
			assAssetsTransferMapper.updateById(transfer);		
		}	
	}

	@Override
	public TransferPrintVo getTransferPrint(Long id) {
		AssAssetsTransfer transfer = assAssetsTransferMapper.selectById(id);
		if(transfer==null){
			return null;
		}
		//转科单详情
		TransferPrintVo transferPrintVo = new TransferPrintVo();
		transferPrintVo.setNum(transfer.getTransferNum());		
		transferPrintVo.setName(transfer.getTenantName());
		transferPrintVo.setId(transfer.getId());
		Map<String, String> findDeptNameToMap = findDeptNameToMap(String.valueOf(transfer.getToDeptId()));
		transferPrintVo.setDeptName(findDeptNameToMap.get(""+transfer.getToDeptId()));
		transferPrintVo.setDirector(transfer.getDeptManageName());
		transferPrintVo.setStatus(SysConstant.TRANSFER_DOC_STATUS_MAP.get(transfer.getStatus()));
		transferPrintVo.setApplyName(transfer.getApplyerName());
		transferPrintVo.setApplyDate(transfer.getCreatTime());
		transferPrintVo.setExamineDate(transfer.getAuditTime());
		transferPrintVo.setExamineName(transfer.getAuditerName());
		transferPrintVo.setRemarks(transfer.getAuditRemark());
		transferPrintVo.setIllustration(transfer.getApplyDesc());
		transferPrintVo.setSuggestion(transfer.getAuditOpinion());
		//转科单明细
		List<AssetBo> assetList= Lists.newArrayList();
		List<AssAssetsTransferDetail> transferDetails = assAssetsTransferDetailMapper.getTransferDetail(id);
		if(transferDetails != null && transferDetails.size() >0){
			for (AssAssetsTransferDetail transferDetail : transferDetails) {
				AssetBo assetBo = new AssetBo();
				assetBo.setAssetsSpec(transferDetail.getAssetsSpec());
				assetBo.setAssetsId(transferDetail.getAssetsId());
				assetBo.setAssetsNum(transferDetail.getAssetsNum());
				assetBo.setSerialNum(transferDetail.getSerialNum());
				assetBo.setAssetsName(transferDetail.getAssetsName());
				assetBo.setStatus(transferDetail.getOperate());
				assetBo.setFactoryName(transferDetail.getFactoryName());
				if(transferDetail.getUnitName() != null){
					assetBo.setAssetsUnit(transferDetail.getUnitName());  
				}
				assetBo.setDeptName(transferDetail.getDeptName());
				assetList.add(assetBo);
			}
		}
		transferPrintVo.setAssetList(assetList);
		
		return transferPrintVo;
	}

	@Override
	public Page<TransferPage> getTransferPage(TransferQuery query) {
		AuthUser currentUser = WebSecurityUtils.getCurrentUser();
		Page<TransferPage> page = query.getPage();
		if(StringUtils.isNotBlank(query.getKeyword())){
			query.setKeyword(query.getKeyword().replaceAll("%", "\\\\%").replaceAll("_", "\\\\_"));
		}
		List<TransferPage> transferPages = assAssetsTransferMapper.getTransferPage(page,query,currentUser);
		//转科单明细
		if(transferPages != null && transferPages.size() > 0){
			for (TransferPage transferPage : transferPages) {
				List<AssetTransferPageVo> list = Lists.newArrayList();
				transferPage.setStatus(SysConstant.TRANSFER_DOC_STATUS_MAP.get(transferPage.getStatusInt()));			
				List<AssAssetsTransferDetail> transferDetails = assAssetsTransferDetailMapper.getTransferDetail(transferPage.getId());
				if(transferDetails != null && transferDetails.size() > 0){
					for (AssAssetsTransferDetail transferDetail : transferDetails) {
						AssetTransferPageVo assetTransferPageVo = new AssetTransferPageVo();
						assetTransferPageVo.setAssetsSpec(transferDetail.getAssetsSpec());
						assetTransferPageVo.setAssetsId(transferDetail.getAssetsId());
						assetTransferPageVo.setAssetsNum(transferDetail.getAssetsNum());
						assetTransferPageVo.setSerialNum(transferDetail.getSerialNum());
						assetTransferPageVo.setAssetsName(transferDetail.getAssetsName());
						assetTransferPageVo.setFactoryName(transferDetail.getFactoryName());
						assetTransferPageVo.setDeptFrom(transferDetail.getDeptName());
						//设备明细状态
						if(transferPage.getStatusInt() != SysConstant.TRANSFER_DOC_STATUS_2){
							if(transferDetail.getOperate() == SysConstant.TRANSFER_DOC_ASSET_STATUS_2){
								assetTransferPageVo.setStatus(SysConstant.TRANSFER_DOC_ASSET_STATUS_MAP.get(transferDetail.getOperate()));
							}else {
								assetTransferPageVo.setStatus("—");
							}
						}else {
							assetTransferPageVo.setStatus(SysConstant.TRANSFER_DOC_ASSET_STATUS_MAP.get(transferDetail.getOperate()));
						}
						assetTransferPageVo.setDeptTo(transferPage.getToDeptName());
						assetTransferPageVo.setAssetsImg(transferDetail.getAssetsImgUrl());
						list.add(assetTransferPageVo);
					}
				}
				transferPage.setList(list);
			}		
		}		
		page.setRecords(transferPages);
		return page;
	}

	@Override
	public Integer statsWaitAudit(Long tenantId) {	
		return assAssetsTransferMapper.statsWaitAudit(tenantId);
	}
	
}
