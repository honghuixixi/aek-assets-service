package com.aek.ebey.assets.service.impl;

import com.aek.ebey.assets.core.util.CommonUtils;
import com.aek.ebey.assets.mapper.AssArchiveContractInfoAttachmentMapper;
import com.aek.ebey.assets.mapper.AssArchiveContractInfoInvoiceMapper;
import com.aek.ebey.assets.mapper.AssArchiveContractInfoMapper;
import com.aek.ebey.assets.model.AssArchiveContractInfo;
import com.aek.ebey.assets.model.AssArchiveContractInfoAttachment;
import com.aek.ebey.assets.model.AssArchiveContractInfoInvoice;
import com.aek.ebey.assets.model.vo.ArchiveContractInfoVo;
import com.aek.ebey.assets.service.AssArchiveContractInfoAttachmentService;
import com.aek.ebey.assets.service.AssArchiveContractInfoInvoiceService;
import com.aek.ebey.assets.service.AssArchiveContractInfoService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.google.common.collect.Lists;
import com.aek.common.core.base.BaseServiceImpl;
import com.aek.common.core.exception.ExceptionFactory;
import com.aek.common.core.serurity.WebSecurityUtils;
import com.aek.common.core.serurity.model.AuthUser;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 资产档案合同信息表 服务实现类
 * </p>
 *
 * @author cyl
 * @since 2018-04-27
 */
@Service
@Transactional
public class AssArchiveContractInfoServiceImpl extends BaseServiceImpl<AssArchiveContractInfoMapper,AssArchiveContractInfo> implements AssArchiveContractInfoService {

	@Autowired
	private AssArchiveContractInfoMapper assArchiveContractInfoMapper;
	@Autowired
	private AssArchiveContractInfoAttachmentMapper assArchiveContractInfoAttachmentMapper;
	@Autowired
	private AssArchiveContractInfoAttachmentService assArchiveContractInfoAttachmentService;
	@Autowired
	private AssArchiveContractInfoInvoiceMapper assArchiveContractInfoInvoiceMapper;
	@Autowired
	private AssArchiveContractInfoInvoiceService assArchiveContractInfoInvoiceService;
	
	@Override
	public ArchiveContractInfoVo getContract(Long archiveId, Long assetsId) {
		ArchiveContractInfoVo contract = assArchiveContractInfoMapper.getContract(archiveId, assetsId);
		if(contract==null)return null;
		contract.setContractPriceStr(CommonUtils.format(contract.getContractPrice()));
		Wrapper<AssArchiveContractInfoAttachment> wrapper = new EntityWrapper<AssArchiveContractInfoAttachment>();
		wrapper.eq("contract_id", contract.getId());
		List<AssArchiveContractInfoAttachment> attachments = assArchiveContractInfoAttachmentMapper.selectList(wrapper);
		contract.setAttachments(attachments);
		return contract;
	}

	@Override
	public void editContract(AssArchiveContractInfo contract, String invoiceNo,
			List<AssArchiveContractInfoAttachment> attachments) {
		Long id = contract.getId();
		AuthUser currentUser = WebSecurityUtils.getCurrentUser();
		Long currentUserId = currentUser.getId();
		Date now = new Date();
		contract.setUpdateBy(currentUserId);
		contract.setUpdateTime(now);
		contract.setContractPrice(CommonUtils.setScale2X(contract.getContractPrice()));
		if(id!=null&&!"".equals(id)){
			AssArchiveContractInfo contractDb = assArchiveContractInfoMapper.selectById(id);
			if(contractDb==null)throw ExceptionFactory.create("AR_006");	
			assArchiveContractInfoMapper.updateContract(contract);
			//更新合同发票表
			Wrapper<AssArchiveContractInfoInvoice> wrapper = new EntityWrapper<AssArchiveContractInfoInvoice>();
			wrapper.eq("contract_id", id);
			assArchiveContractInfoInvoiceMapper.delete(wrapper);
			if(invoiceNo!=null&&!"".equals(invoiceNo)){				
				String[] invoiceNos = invoiceNo.split(";");
				if(invoiceNos.length>0){
					List<AssArchiveContractInfoInvoice> list = Lists.newArrayList();
					for (String i : invoiceNos) {
						AssArchiveContractInfoInvoice invoice = new AssArchiveContractInfoInvoice(id,i);
						list.add(invoice);
					}
					assArchiveContractInfoInvoiceService.insertBatch(list);
				}
			}
			//更新合同信息附件表
			Wrapper<AssArchiveContractInfoAttachment> wrapper1 = new EntityWrapper<AssArchiveContractInfoAttachment>();
			wrapper1.eq("contract_id", id);
			assArchiveContractInfoAttachmentMapper.delete(wrapper1);
			if(attachments!=null&&attachments.size()>0){			
				for (AssArchiveContractInfoAttachment at : attachments) {
					at.setContractId(id);
					at.setCreateTime(now);
				}
				assArchiveContractInfoAttachmentService.insertBatch(attachments);
			}
		}else{
			contract.setCreateBy(currentUserId);
			contract.setCreateTime(now);
			assArchiveContractInfoMapper.insert(contract);
			if(invoiceNo!=null&&!"".equals(invoiceNo)){
				String[] invoiceNos = invoiceNo.split(";");
				//invoiceNo
				if(invoiceNos.length>0){
					List<AssArchiveContractInfoInvoice> list = Lists.newArrayList();
					for (String i : invoiceNos) {
						AssArchiveContractInfoInvoice invoice = new AssArchiveContractInfoInvoice(contract.getId(),i);
						list.add(invoice);
					}
					assArchiveContractInfoInvoiceService.insertBatch(list);
				}
			}
			//attachments
			if(attachments!=null&&attachments.size()>0){
				for (AssArchiveContractInfoAttachment at : attachments) {
					at.setContractId(contract.getId());
					at.setCreateTime(now);
				}
				assArchiveContractInfoAttachmentService.insertBatch(attachments);
			}
		}
		
	}
	
}
