package com.aek.ebey.assets.core;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aek.common.core.serurity.WebSecurityUtils;
import com.aek.common.core.serurity.model.AuthUser;
import com.aek.ebey.assets.core.util.CommonUtils;
import com.aek.ebey.assets.core.util.ReflectUtils;
import com.aek.ebey.assets.model.AssAssetsLog;
import com.aek.ebey.assets.model.AssAssetsLogDetail;
import com.aek.ebey.assets.model.AssetsFundSources;
import com.aek.ebey.assets.model.AssetsInfo;
import com.aek.ebey.assets.model.AssetsInfoExt;
import com.aek.ebey.assets.model.Contract;
import com.aek.ebey.assets.model.bo.AttachmentsBO;
import com.aek.ebey.assets.service.AssAssetsLogService;
import com.alibaba.fastjson.JSON;

/**
 * 资产修改日志线程类
 * 
 * @author HongHui
 * @date 2017年12月26日
 */
public class AssetsLogDetailThread implements Runnable {

	private static Logger logger = LoggerFactory.getLogger(AssetsLogDetailThread.class);

	/**
	 * 日志修改日志实体类
	 */
	private AssAssetsLog assAssetsLog;
	/**
	 * 修改日志业务实现类
	 */
	private AssAssetsLogService assAssetsLogService;

	/**
	 * 操作描述 新增/编辑
	 */
	private String operateDesc;

	/**
	 * AssetsInfo
	 */
	private AssetsInfo oldAssetsInfo;
	private AssetsInfo newAssetsInfo;
	private Class<AssetsInfo> assetsInfoClazz;
	private Integer assetsInfoLogDetailType;

	/**
	 * AssetsInfoExt
	 */
	private AssetsInfoExt oldAssetsInfoExt;
	private AssetsInfoExt newAssetsInfoExt;
	private Class<AssetsInfoExt> assetsInfoExtClazz;
	private Integer assetsInfoExtLogDetailType;

	/**
	 * 招标附件
	 */
	private List<AttachmentsBO> oldInviteAttachmentList;
	private List<AttachmentsBO> newInviteAttachmentList;
	private Integer inviteAttachmentLogDetailType;
	private String inviteAttachmentLogDetailTypeDesc;

	/**
	 * 验收附件
	 */
	private List<AttachmentsBO> oldCheckAttachmentList;
	private List<AttachmentsBO> newCheckAttachmentList;
	private Integer checkAttachmentLogDetailType;
	private String checkAttachmentLogDetailTypeDesc;

	/**
	 * 资金来源
	 */
	private List<AssetsFundSources> oldAssetsFundSources;
	private List<AssetsFundSources> newAssetsFundSources;
	private Integer assetsFundSourcesLogDetailType;

	/**
	 * 发票号
	 */
	private String oldInvoiceNo;
	private String newInvoiceNo;
	private Integer invoiceNoLogDetailType;

	/**
	 * 合同
	 */
	private Contract oldContract;
	private Contract newContract;
	private Class<Contract> contractClazz;
	private Integer contractLogDetailType;

	/**
	 * 合同附件
	 */
	private List<AttachmentsBO> oldContractAttachmentList;
	private List<AttachmentsBO> newContractAttachmentList;
	private Integer contractAttachmentLogDetailType;
	private String contractAttachmentLogDetailTypeDesc;

	/**
	 * 当前登录人与token
	 */
	private AuthUser currentUser;
	private String currentToken;

	public AssetsLogDetailThread(AuthUser currentUser,String currentToken,AssAssetsLog assAssetsLog, AssAssetsLogService assAssetsLogService, String operateDesc,
			AssetsInfo oldAssetsInfo, AssetsInfo newAssetsInfo, Class<AssetsInfo> assetsInfoClazz,
			Integer assetsInfoLogDetailType, AssetsInfoExt oldAssetsInfoExt, AssetsInfoExt newAssetsInfoExt,
			Class<AssetsInfoExt> assetsInfoExtClazz, Integer assetsInfoExtLogDetailType,
			List<AttachmentsBO> oldInviteAttachmentList, List<AttachmentsBO> newInviteAttachmentList,
			Integer inviteAttachmentLogDetailType, String inviteAttachmentLogDetailTypeDesc,
			List<AttachmentsBO> oldCheckAttachmentList, List<AttachmentsBO> newCheckAttachmentList,
			Integer checkAttachmentLogDetailType, String checkAttachmentLogDetailTypeDesc,
			List<AssetsFundSources> oldAssetsFundSources, List<AssetsFundSources> newAssetsFundSources,
			Integer assetsFundSourcesLogDetailType, String oldInvoiceNo, String newInvoiceNo,
			Integer invoiceNoLogDetailType, Contract oldContract, Contract newContract, Class<Contract> contractClazz,
			Integer contractLogDetailType, List<AttachmentsBO> oldContractAttachmentList,
			List<AttachmentsBO> newContractAttachmentList, Integer contractAttachmentLogDetailType,
			String contractAttachmentLogDetailTypeDesc) {
		super();
		this.currentUser=currentUser;
		this.currentToken=currentToken;
		this.assAssetsLog = assAssetsLog;
		this.assAssetsLogService = assAssetsLogService;
		this.operateDesc = operateDesc;
		this.oldAssetsInfo = oldAssetsInfo;
		this.newAssetsInfo = newAssetsInfo;
		this.assetsInfoClazz = assetsInfoClazz;
		this.assetsInfoLogDetailType = assetsInfoLogDetailType;
		this.oldAssetsInfoExt = oldAssetsInfoExt;
		this.newAssetsInfoExt = newAssetsInfoExt;
		this.assetsInfoExtClazz = assetsInfoExtClazz;
		this.assetsInfoExtLogDetailType = assetsInfoExtLogDetailType;
		this.oldInviteAttachmentList = oldInviteAttachmentList;
		this.newInviteAttachmentList = newInviteAttachmentList;
		this.inviteAttachmentLogDetailType = inviteAttachmentLogDetailType;
		this.inviteAttachmentLogDetailTypeDesc = inviteAttachmentLogDetailTypeDesc;
		this.oldCheckAttachmentList = oldCheckAttachmentList;
		this.newCheckAttachmentList = newCheckAttachmentList;
		this.checkAttachmentLogDetailType = checkAttachmentLogDetailType;
		this.checkAttachmentLogDetailTypeDesc = checkAttachmentLogDetailTypeDesc;
		this.oldAssetsFundSources = oldAssetsFundSources;
		this.newAssetsFundSources = newAssetsFundSources;
		this.assetsFundSourcesLogDetailType = assetsFundSourcesLogDetailType;
		this.oldInvoiceNo = oldInvoiceNo;
		this.newInvoiceNo = newInvoiceNo;
		this.invoiceNoLogDetailType = invoiceNoLogDetailType;
		this.oldContract = oldContract;
		this.newContract = newContract;
		this.contractClazz = contractClazz;
		this.contractLogDetailType = contractLogDetailType;
		this.oldContractAttachmentList = oldContractAttachmentList;
		this.newContractAttachmentList = newContractAttachmentList;
		this.contractAttachmentLogDetailType = contractAttachmentLogDetailType;
		this.contractAttachmentLogDetailTypeDesc = contractAttachmentLogDetailTypeDesc;
	}

	@Override
	public void run() {
		logger.info(">>>>>>>>>保存资产修改日志任务执行<<<<<<<<<<<");
		List<AssAssetsLogDetail> logDetailList = new ArrayList<AssAssetsLogDetail>();
		//处理AssetsInfo修改日志
		List<AssAssetsLogDetail> assetsInfoLogDetailList =  ReflectUtils.compareTwoClazzToLogDetail(oldAssetsInfo, newAssetsInfo, assetsInfoClazz, assetsInfoLogDetailType);
		logDetailList.addAll(assetsInfoLogDetailList);
		//处理AssetsInfoExt修改日志
		List<AssAssetsLogDetail> assetsExtToLogDetailList = ReflectUtils.compareTwoClazzToLogDetail(oldAssetsInfoExt, newAssetsInfoExt, assetsInfoExtClazz, assetsInfoExtLogDetailType);
		logDetailList.addAll(assetsExtToLogDetailList);
		//处理招标附件修改日志
		List<AssAssetsLogDetail> inviceAttachmentLogDetailList = CommonUtils.compareTwoListToLogDetail(oldInviteAttachmentList, newInviteAttachmentList,inviteAttachmentLogDetailType,inviteAttachmentLogDetailTypeDesc);
		logDetailList.addAll(inviceAttachmentLogDetailList);
		//处理验收附件修改日志
		List<AssAssetsLogDetail> checkAttachmentLogDetailList = CommonUtils.compareTwoListToLogDetail(oldCheckAttachmentList, newCheckAttachmentList,checkAttachmentLogDetailType,checkAttachmentLogDetailTypeDesc);
		logDetailList.addAll(checkAttachmentLogDetailList);
		//处理台账资金来源记入日志	
		Map<String, List<AssetsFundSources>> resultMap = CommonUtils.compareSup(oldAssetsFundSources.size()==0?new ArrayList<>():oldAssetsFundSources, newAssetsFundSources.size()==0?new ArrayList<>():newAssetsFundSources);
		List<AssetsFundSources> addList = resultMap.get("add");
		List<AssetsFundSources> reduceList = resultMap.get("reduce");
		if(addList.size()!=0 || reduceList.size() !=0){				
			AssAssetsLogDetail fundSourcesLog = new AssAssetsLogDetail();
			fundSourcesLog.setTableName("ass_assets_fund_sources");
			fundSourcesLog.setField("fund_sources(user-defined)");
			fundSourcesLog.setFieldName("资金来源");
			fundSourcesLog.setPropertyName("fund_sources(user-defined)");			
			String oldDesc="";
			String newDesc="";
			if(oldAssetsFundSources !=null && oldAssetsFundSources.size()>0){	
				for (AssetsFundSources old : oldAssetsFundSources) {
					Long oldFundSourceMoney = old.getFundSourceMoney();
					oldDesc=oldDesc+old.getFundSourcesText()+"额度（"+(oldFundSourceMoney != null?CommonUtils.fromX2Y(oldFundSourceMoney):"无")+"）";
				}
			}		
			if(newAssetsFundSources !=null && newAssetsFundSources.size()>0){		
				for (AssetsFundSources past : newAssetsFundSources) {
					String newfundSourceMoney = past.getFundSourceMoneyStr();
					newDesc=newDesc+past.getFundSourcesText()+"额度（"+(newfundSourceMoney != null?CommonUtils.fromX2Y(Long.parseLong(newfundSourceMoney)*100):"无")+"）";
				}
			}
			if(oldAssetsFundSources !=null && oldAssetsFundSources.size()==2)oldDesc="混合—"+oldDesc;
			if(newAssetsFundSources !=null && newAssetsFundSources.size()==2)newDesc="混合—"+newDesc;		
			fundSourcesLog.setOldValue(oldDesc);
			fundSourcesLog.setNewValue(newDesc);
			fundSourcesLog.setCreateTime(new Date());
			fundSourcesLog.setType(assetsFundSourcesLogDetailType);
			//加入日志细节接收集合
			logDetailList.add(fundSourcesLog);
		}
		//处理发票号记入日志
		boolean flag = ReflectUtils.compareTwo(oldInvoiceNo, newInvoiceNo);
		if(!flag){
			AssAssetsLogDetail invoiceLog = new AssAssetsLogDetail();
			invoiceLog.setTableName("ass_assets_invoice");
			invoiceLog.setField("invoice_no");
			invoiceLog.setFieldName("发票号");
			invoiceLog.setPropertyName("invoiceNo");
			if(oldInvoiceNo != null && newInvoiceNo != null){
				if(!oldInvoiceNo.equals(newInvoiceNo)){
					invoiceLog.setOldValue(oldInvoiceNo);
					invoiceLog.setNewValue(newInvoiceNo);
				}
			}else {
				if(oldInvoiceNo != null){
					invoiceLog.setOldValue(oldInvoiceNo);
					invoiceLog.setNewValue("无");
				}
				if(newInvoiceNo != null){
					invoiceLog.setNewValue(newInvoiceNo);
				}
			}		
			invoiceLog.setCreateTime(new Date());
			invoiceLog.setType(invoiceNoLogDetailType);
			//加入日志细节接收集合
			logDetailList.add(invoiceLog);	
		}
		//处理合同修改日志
		List<AssAssetsLogDetail> contractToLogDetailList = ReflectUtils.compareTwoClazzToLogDetail(oldContract, newContract, contractClazz, contractLogDetailType);
		logDetailList.addAll(contractToLogDetailList);
		//处理合同附件修改日志
		List<AssAssetsLogDetail> contractAttachmentLogDetailList = CommonUtils.compareTwoListToLogDetail(oldContractAttachmentList, newContractAttachmentList,contractAttachmentLogDetailType,contractAttachmentLogDetailTypeDesc);
		logDetailList.addAll(contractAttachmentLogDetailList);
		//保存日志信息
		//利用事务保存
		assAssetsLogService.saveAssAssetsLog(currentUser,currentToken,assAssetsLog, logDetailList, operateDesc);
	}

	public AssAssetsLog getAssAssetsLog() {
		return assAssetsLog;
	}

	public void setAssAssetsLog(AssAssetsLog assAssetsLog) {
		this.assAssetsLog = assAssetsLog;
	}

	public AssAssetsLogService getAssAssetsLogService() {
		return assAssetsLogService;
	}

	public void setAssAssetsLogService(AssAssetsLogService assAssetsLogService) {
		this.assAssetsLogService = assAssetsLogService;
	}

	public String getOperateDesc() {
		return operateDesc;
	}

	public void setOperateDesc(String operateDesc) {
		this.operateDesc = operateDesc;
	}

	public AssetsInfo getOldAssetsInfo() {
		return oldAssetsInfo;
	}

	public void setOldAssetsInfo(AssetsInfo oldAssetsInfo) {
		this.oldAssetsInfo = oldAssetsInfo;
	}

	public AssetsInfo getNewAssetsInfo() {
		return newAssetsInfo;
	}

	public void setNewAssetsInfo(AssetsInfo newAssetsInfo) {
		this.newAssetsInfo = newAssetsInfo;
	}

	public Class<AssetsInfo> getAssetsInfoClazz() {
		return assetsInfoClazz;
	}

	public void setAssetsInfoClazz(Class<AssetsInfo> assetsInfoClazz) {
		this.assetsInfoClazz = assetsInfoClazz;
	}

	public Integer getAssetsInfoLogDetailType() {
		return assetsInfoLogDetailType;
	}

	public void setAssetsInfoLogDetailType(Integer assetsInfoLogDetailType) {
		this.assetsInfoLogDetailType = assetsInfoLogDetailType;
	}

	public AssetsInfoExt getOldAssetsInfoExt() {
		return oldAssetsInfoExt;
	}

	public void setOldAssetsInfoExt(AssetsInfoExt oldAssetsInfoExt) {
		this.oldAssetsInfoExt = oldAssetsInfoExt;
	}

	public AssetsInfoExt getNewAssetsInfoExt() {
		return newAssetsInfoExt;
	}

	public void setNewAssetsInfoExt(AssetsInfoExt newAssetsInfoExt) {
		this.newAssetsInfoExt = newAssetsInfoExt;
	}

	public Class<AssetsInfoExt> getAssetsInfoExtClazz() {
		return assetsInfoExtClazz;
	}

	public void setAssetsInfoExtClazz(Class<AssetsInfoExt> assetsInfoExtClazz) {
		this.assetsInfoExtClazz = assetsInfoExtClazz;
	}

	public Integer getAssetsInfoExtLogDetailType() {
		return assetsInfoExtLogDetailType;
	}

	public void setAssetsInfoExtLogDetailType(Integer assetsInfoExtLogDetailType) {
		this.assetsInfoExtLogDetailType = assetsInfoExtLogDetailType;
	}

	public List<AttachmentsBO> getOldInviteAttachmentList() {
		return oldInviteAttachmentList;
	}

	public void setOldInviteAttachmentList(List<AttachmentsBO> oldInviteAttachmentList) {
		this.oldInviteAttachmentList = oldInviteAttachmentList;
	}

	public List<AttachmentsBO> getNewInviteAttachmentList() {
		return newInviteAttachmentList;
	}

	public void setNewInviteAttachmentList(List<AttachmentsBO> newInviteAttachmentList) {
		this.newInviteAttachmentList = newInviteAttachmentList;
	}

	public Integer getInviteAttachmentLogDetailType() {
		return inviteAttachmentLogDetailType;
	}

	public void setInviteAttachmentLogDetailType(Integer inviteAttachmentLogDetailType) {
		this.inviteAttachmentLogDetailType = inviteAttachmentLogDetailType;
	}

	public String getInviteAttachmentLogDetailTypeDesc() {
		return inviteAttachmentLogDetailTypeDesc;
	}

	public void setInviteAttachmentLogDetailTypeDesc(String inviteAttachmentLogDetailTypeDesc) {
		this.inviteAttachmentLogDetailTypeDesc = inviteAttachmentLogDetailTypeDesc;
	}

	public List<AttachmentsBO> getOldCheckAttachmentList() {
		return oldCheckAttachmentList;
	}

	public void setOldCheckAttachmentList(List<AttachmentsBO> oldCheckAttachmentList) {
		this.oldCheckAttachmentList = oldCheckAttachmentList;
	}

	public List<AttachmentsBO> getNewCheckAttachmentList() {
		return newCheckAttachmentList;
	}

	public void setNewCheckAttachmentList(List<AttachmentsBO> newCheckAttachmentList) {
		this.newCheckAttachmentList = newCheckAttachmentList;
	}

	public Integer getCheckAttachmentLogDetailType() {
		return checkAttachmentLogDetailType;
	}

	public void setCheckAttachmentLogDetailType(Integer checkAttachmentLogDetailType) {
		this.checkAttachmentLogDetailType = checkAttachmentLogDetailType;
	}

	public String getCheckAttachmentLogDetailTypeDesc() {
		return checkAttachmentLogDetailTypeDesc;
	}

	public void setCheckAttachmentLogDetailTypeDesc(String checkAttachmentLogDetailTypeDesc) {
		this.checkAttachmentLogDetailTypeDesc = checkAttachmentLogDetailTypeDesc;
	}

	public List<AssetsFundSources> getOldAssetsFundSources() {
		return oldAssetsFundSources;
	}

	public void setOldAssetsFundSources(List<AssetsFundSources> oldAssetsFundSources) {
		this.oldAssetsFundSources = oldAssetsFundSources;
	}

	public List<AssetsFundSources> getNewAssetsFundSources() {
		return newAssetsFundSources;
	}

	public void setNewAssetsFundSources(List<AssetsFundSources> newAssetsFundSources) {
		this.newAssetsFundSources = newAssetsFundSources;
	}

	public Integer getAssetsFundSourcesLogDetailType() {
		return assetsFundSourcesLogDetailType;
	}

	public void setAssetsFundSourcesLogDetailType(Integer assetsFundSourcesLogDetailType) {
		this.assetsFundSourcesLogDetailType = assetsFundSourcesLogDetailType;
	}

	public String getOldInvoiceNo() {
		return oldInvoiceNo;
	}

	public void setOldInvoiceNo(String oldInvoiceNo) {
		this.oldInvoiceNo = oldInvoiceNo;
	}

	public String getNewInvoiceNo() {
		return newInvoiceNo;
	}

	public void setNewInvoiceNo(String newInvoiceNo) {
		this.newInvoiceNo = newInvoiceNo;
	}

	public Integer getInvoiceNoLogDetailType() {
		return invoiceNoLogDetailType;
	}

	public void setInvoiceNoLogDetailType(Integer invoiceNoLogDetailType) {
		this.invoiceNoLogDetailType = invoiceNoLogDetailType;
	}

	public Contract getOldContract() {
		return oldContract;
	}

	public void setOldContract(Contract oldContract) {
		this.oldContract = oldContract;
	}

	public Contract getNewContract() {
		return newContract;
	}

	public void setNewContract(Contract newContract) {
		this.newContract = newContract;
	}

	public Class<Contract> getContractClazz() {
		return contractClazz;
	}

	public void setContractClazz(Class<Contract> contractClazz) {
		this.contractClazz = contractClazz;
	}

	public Integer getContractLogDetailType() {
		return contractLogDetailType;
	}

	public void setContractLogDetailType(Integer contractLogDetailType) {
		this.contractLogDetailType = contractLogDetailType;
	}

	public List<AttachmentsBO> getOldContractAttachmentList() {
		return oldContractAttachmentList;
	}

	public void setOldContractAttachmentList(List<AttachmentsBO> oldContractAttachmentList) {
		this.oldContractAttachmentList = oldContractAttachmentList;
	}

	public List<AttachmentsBO> getNewContractAttachmentList() {
		return newContractAttachmentList;
	}

	public void setNewContractAttachmentList(List<AttachmentsBO> newContractAttachmentList) {
		this.newContractAttachmentList = newContractAttachmentList;
	}

	public Integer getContractAttachmentLogDetailType() {
		return contractAttachmentLogDetailType;
	}

	public void setContractAttachmentLogDetailType(Integer contractAttachmentLogDetailType) {
		this.contractAttachmentLogDetailType = contractAttachmentLogDetailType;
	}

	public String getContractAttachmentLogDetailTypeDesc() {
		return contractAttachmentLogDetailTypeDesc;
	}

	public void setContractAttachmentLogDetailTypeDesc(String contractAttachmentLogDetailTypeDesc) {
		this.contractAttachmentLogDetailTypeDesc = contractAttachmentLogDetailTypeDesc;
	}

	public AuthUser getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(AuthUser currentUser) {
		this.currentUser = currentUser;
	}

	public String getCurrentToken() {
		return currentToken;
	}

	public void setCurrentToken(String currentToken) {
		this.currentToken = currentToken;
	}
	
}
