package com.aek.ebey.assets.model.vo;

import java.util.Date;
import java.util.List;

import com.aek.ebey.assets.model.AssArchiveContractInfoAttachment;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("档案合同信息输出")
public class ArchiveContractInfoVo {

	private Long id;
	@ApiModelProperty("合同编号")
	private String contractNum;
	@ApiModelProperty("合同名称")
	private String contractName;
	@ApiModelProperty("签订日期")
	private Date signDate;
	@ApiModelProperty("合同金额")
	private Double contractPrice;
	@ApiModelProperty("合同金额输出")
	private String contractPriceStr;
	@ApiModelProperty("合同截止时间")
	private Date endDate;
	@ApiModelProperty("发票号")
	private String invoiceNo;
	@ApiModelProperty("乙方联系人")
	private String partybContactPerson;
	@ApiModelProperty("乙方联系电话")
	private String partybContactPhone;
	@ApiModelProperty("档案编号")
	private String contractArchiveNum;
	@ApiModelProperty("档案管理员")
	private String contractArchiveAdministrator;
	@ApiModelProperty("合同内容")
	private String contractContent;
	@ApiModelProperty("合同附件")
	private List<AssArchiveContractInfoAttachment> attachments;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getContractNum() {
		return contractNum;
	}
	public void setContractNum(String contractNum) {
		this.contractNum = contractNum;
	}
	public String getContractName() {
		return contractName;
	}
	public void setContractName(String contractName) {
		this.contractName = contractName;
	}
	public Date getSignDate() {
		return signDate;
	}
	public void setSignDate(Date signDate) {
		this.signDate = signDate;
	}
	public Double getContractPrice() {
		return contractPrice;
	}
	public void setContractPrice(Double contractPrice) {
		this.contractPrice = contractPrice;
	}
	public String getContractPriceStr() {
		return contractPriceStr;
	}
	public void setContractPriceStr(String contractPriceStr) {
		this.contractPriceStr = contractPriceStr;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getInvoiceNo() {
		return invoiceNo;
	}
	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}
	public String getPartybContactPerson() {
		return partybContactPerson;
	}
	public void setPartybContactPerson(String partybContactPerson) {
		this.partybContactPerson = partybContactPerson;
	}
	public String getPartybContactPhone() {
		return partybContactPhone;
	}
	public void setPartybContactPhone(String partybContactPhone) {
		this.partybContactPhone = partybContactPhone;
	}
	public String getContractArchiveNum() {
		return contractArchiveNum;
	}
	public void setContractArchiveNum(String contractArchiveNum) {
		this.contractArchiveNum = contractArchiveNum;
	}
	public String getContractArchiveAdministrator() {
		return contractArchiveAdministrator;
	}
	public void setContractArchiveAdministrator(String contractArchiveAdministrator) {
		this.contractArchiveAdministrator = contractArchiveAdministrator;
	}
	public String getContractContent() {
		return contractContent;
	}
	public void setContractContent(String contractContent) {
		this.contractContent = contractContent;
	}
	public List<AssArchiveContractInfoAttachment> getAttachments() {
		return attachments;
	}
	public void setAttachments(List<AssArchiveContractInfoAttachment> attachments) {
		this.attachments = attachments;
	}
	
	
}
