package com.aek.ebey.assets.service.impl;

import com.aek.ebey.assets.constant.ArchiveConstant;
import com.aek.ebey.assets.core.util.CommonUtils;
import com.aek.ebey.assets.mapper.AssArchivePurchaseInfoMapper;
import com.aek.ebey.assets.model.AssArchivePurchaseInfo;
import com.aek.ebey.assets.model.AssArchivePurchaseInfoAttachment;
import com.aek.ebey.assets.model.AssArchivePurchaseInfoFundSources;
import com.aek.ebey.assets.model.DeptNameAndUserName;
import com.aek.ebey.assets.model.vo.AssArchivePurchaseInfoVo;
import com.aek.ebey.assets.service.AssArchivePurchaseInfoAttachmentService;
import com.aek.ebey.assets.service.AssArchivePurchaseInfoFundSourcesService;
import com.aek.ebey.assets.service.AssArchivePurchaseInfoService;
import com.aek.ebey.assets.service.feign.UserClientService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.aek.common.core.Result;
import com.aek.common.core.base.BaseServiceImpl;
import com.aek.common.core.exception.ExceptionFactory;
import com.aek.common.core.serurity.WebSecurityUtils;
import com.aek.common.core.serurity.model.AuthUser;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 资产档案采购信息表 服务实现类
 * </p>
 *
 * @author cyl
 * @since 2018-04-28
 */
@Service
@Transactional
public class AssArchivePurchaseInfoServiceImpl extends BaseServiceImpl<AssArchivePurchaseInfoMapper,AssArchivePurchaseInfo> implements AssArchivePurchaseInfoService {

	@Autowired
	private AssArchivePurchaseInfoMapper assArchivePurchaseInfoMapper;
	@Autowired
	private AssArchivePurchaseInfoAttachmentService assArchivePurchaseInfoAttachmentService;
	@Autowired
	private AssArchivePurchaseInfoFundSourcesService assArchivePurchaseInfoFundSourcesService;
	@Autowired
	private UserClientService userClientService;
	
	
	@Override
	public void editPurchase(AssArchivePurchaseInfo purchase, List<AssArchivePurchaseInfoAttachment> acceptAttachments,
			List<AssArchivePurchaseInfoAttachment> bidAttachments,
			List<AssArchivePurchaseInfoFundSources> listFundSources) {
		Long id = purchase.getId();
		AuthUser currentUser = WebSecurityUtils.getCurrentUser();
		Long currentUserId = currentUser.getId();
		Date now = new Date();
		purchase.setUpdateBy(currentUserId);	
		purchase.setUpdateTime(now);	
		if(id!=null){
			AssArchivePurchaseInfo purchaseDb = assArchivePurchaseInfoMapper.selectById(id);
			if(purchaseDb==null)throw ExceptionFactory.create("AR_007");
			assArchivePurchaseInfoMapper.updatePurchase(purchase);
			//验收附件
			Wrapper<AssArchivePurchaseInfoAttachment> wrapper = new EntityWrapper<AssArchivePurchaseInfoAttachment>();
			wrapper.eq("purchase_id", id).eq("type", 2);
			assArchivePurchaseInfoAttachmentService.delete(wrapper);			
			if(acceptAttachments!=null&&acceptAttachments.size()>0){
				for (AssArchivePurchaseInfoAttachment at : acceptAttachments) {
					at.setPurchaseId(id);
					at.setType(2);
					at.setCreateTime(now);
				}
				assArchivePurchaseInfoAttachmentService.insertBatch(acceptAttachments);
			}
			//招标附件
			Wrapper<AssArchivePurchaseInfoAttachment> wrapper2 = new EntityWrapper<AssArchivePurchaseInfoAttachment>();
			wrapper2.eq("purchase_id", id).eq("type", 1);
			assArchivePurchaseInfoAttachmentService.delete(wrapper2);
			if(bidAttachments!=null&&bidAttachments.size()>0){
				for (AssArchivePurchaseInfoAttachment bt : bidAttachments) {
					bt.setPurchaseId(id);
					bt.setType(1);
					bt.setCreateTime(now);
				}
				assArchivePurchaseInfoAttachmentService.insertBatch(bidAttachments);
			}
			//采购资金来源
			Wrapper<AssArchivePurchaseInfoFundSources> wrapper3 = new EntityWrapper<AssArchivePurchaseInfoFundSources>();
			wrapper3.eq("purchase_id", id);
			assArchivePurchaseInfoFundSourcesService.delete(wrapper3);
			if(listFundSources!=null&&listFundSources.size()>0){
				for (AssArchivePurchaseInfoFundSources lfs : listFundSources) {
					lfs.setMoney(CommonUtils.setScale2X(lfs.getMoney()));
					lfs.setPurchaseId(id);
					lfs.setName(ArchiveConstant.FUND_SOURCES_MAP.get(lfs.getType()));
					if(lfs.getType()!=null&&lfs.getType()!=4)lfs.setSubName(lfs.getName());
					if(lfs.getSubType()!=null&&lfs.getSubType()==1)lfs.setSubName("财政资金");
					if(lfs.getSubType()!=null&&lfs.getSubType()==2)lfs.setSubName("自筹资金");
					lfs.setCreateTime(now);
				}
				assArchivePurchaseInfoFundSourcesService.insertBatch(listFundSources);
			}
		}else {
			purchase.setCreateBy(currentUserId);
			purchase.setCreateTime(now);
			assArchivePurchaseInfoMapper.insert(purchase);
			if(acceptAttachments!=null&&acceptAttachments.size()>0){
				for (AssArchivePurchaseInfoAttachment at : acceptAttachments) {
					at.setPurchaseId(purchase.getId());
					at.setType(2);
					at.setCreateTime(now);
				}
				assArchivePurchaseInfoAttachmentService.insertBatch(acceptAttachments);
			}
			//招标附件
			if(bidAttachments!=null&&bidAttachments.size()>0){
				for (AssArchivePurchaseInfoAttachment bt : bidAttachments) {
					bt.setPurchaseId(purchase.getId());
					bt.setType(1);
					bt.setCreateTime(now);
				}
				assArchivePurchaseInfoAttachmentService.insertBatch(bidAttachments);
			}
			//采购资金来源
			if(listFundSources!=null&&listFundSources.size()>0){
				for (AssArchivePurchaseInfoFundSources lfs : listFundSources) {
					lfs.setPurchaseId(purchase.getId());
					lfs.setMoney(CommonUtils.setScale2X(lfs.getMoney()));
					lfs.setName(ArchiveConstant.FUND_SOURCES_MAP.get(lfs.getType()));
					if(lfs.getSubType()!=null&&lfs.getSubType()==1)lfs.setSubName("财政资金");
					if(lfs.getSubType()!=null&&lfs.getSubType()==2)lfs.setSubName("自筹资金");
					lfs.setCreateTime(now);
				}
				assArchivePurchaseInfoFundSourcesService.insertBatch(listFundSources);
			}
		}
		
	}


	@Override
	public AssArchivePurchaseInfoVo getPurchase(Long archiveId, Long assetsId) {
		AssArchivePurchaseInfoVo purchase = assArchivePurchaseInfoMapper.getPurchase(archiveId,assetsId);
		if(purchase==null)return purchase;
		Integer applyDeptId = purchase.getApplyDeptId();
		Double singleBudget = purchase.getSingleBudget();
		if(singleBudget!=null){
			purchase.setSingleBudgetStr(CommonUtils.format(singleBudget));
		}		
		if(applyDeptId!=null){
			Result<List<DeptNameAndUserName>> deptName = userClientService.findByDeptIds(String.valueOf(applyDeptId), WebSecurityUtils.getCurrentToken());
			if (deptName != null && deptName.getData() != null && deptName.getData().size() != 0) {
				String applyDeptName = deptName.getData().get(0).getName();
				purchase.setApplyDeptName(applyDeptName);
			}
			
		}
		Integer purchaseType = purchase.getPurchaseType();
		Integer purchaseMode = purchase.getPurchaseMode();
		Integer tenderForm = purchase.getTenderForm();
		if(purchaseType!=null){
			purchase.setPurchaseTypeStr(ArchiveConstant.PURCHASE_TYPE_MAP.get(purchaseType));
		}
		if(purchaseMode!=null){
			purchase.setPurchaseModeStr(ArchiveConstant.PURCHASE_MODE_MAP.get(purchaseMode));
		}
		if(tenderForm!=null){
			purchase.setTenderFormStr(ArchiveConstant.TENDER_FORM_MAP.get(tenderForm));
		}
		//附件
		Wrapper<AssArchivePurchaseInfoAttachment> wrapper1 = new EntityWrapper<AssArchivePurchaseInfoAttachment>();
		wrapper1.eq("purchase_id", purchase.getId()).eq("type", 1);
		List<AssArchivePurchaseInfoAttachment> bidAttachments = assArchivePurchaseInfoAttachmentService.selectList(wrapper1);
		purchase.setBidAttachments(bidAttachments);
		Wrapper<AssArchivePurchaseInfoAttachment> wrapper2 = new EntityWrapper<AssArchivePurchaseInfoAttachment>();
		wrapper2.eq("purchase_id", purchase.getId()).eq("type", 2);
		List<AssArchivePurchaseInfoAttachment> acceptAttachments = assArchivePurchaseInfoAttachmentService.selectList(wrapper2);
		purchase.setAcceptAttachments(acceptAttachments);
		//资金来源
		Wrapper<AssArchivePurchaseInfoFundSources> wrapper3 = new EntityWrapper<AssArchivePurchaseInfoFundSources>();
		wrapper3.eq("purchase_id", purchase.getId());
		List<AssArchivePurchaseInfoFundSources> listFundSources = assArchivePurchaseInfoFundSourcesService.selectList(wrapper3);
		if(listFundSources!=null&&listFundSources.size()>0){
			for (AssArchivePurchaseInfoFundSources lfs : listFundSources) {
				lfs.setMoneyStr(CommonUtils.format(lfs.getMoney()));
			}
		}
		purchase.setListFundSources(listFundSources);
		return purchase;
	}

	
	
}
