package com.aek.ebey.assets.web.request;

import java.util.Date;
import java.util.List;

import com.aek.ebey.assets.model.AssArchivePurchaseInfoAttachment;
import com.aek.ebey.assets.model.AssArchivePurchaseInfoFundSources;
import com.baomidou.mybatisplus.annotations.TableField;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("采购信息请求")
public class AssArchivePurchaseInfoRequest {

	private Long id;
	@ApiModelProperty("档案ID")
	private Long archiveId;
	@ApiModelProperty("设备ID")
	private Long assetsId;
	@ApiModelProperty("购置类别:1=新增、2=添置、3=报废更新")
	private Integer purchaseType;
	@ApiModelProperty("申购日期")
	private Date applyDate;
	@ApiModelProperty("申购科室ID")
	private Integer applyDeptId;
	@ApiModelProperty("论证日期")
	private Date proveDate;
	@ApiModelProperty("预到时间")
	private Date previewArriveDate;
	@ApiModelProperty("申购理由")
	private String applyReason;
	@ApiModelProperty("验收人员")
	private String acceptor;
	@ApiModelProperty("验收部门")
	private String acceptorDeptName;
	@ApiModelProperty(" 验收时间")
	private Date acceptorTime;
	@ApiModelProperty("采购方式:1=国际招标、2=政府采购、3=院内采购、4=分散采购、5=自行采购、6=其他")
	private Integer purchaseMode;
	@ApiModelProperty("招标形式:1=公开招标、2=邀请招标、3=竞争性谈判、4=单一来源采购、5=询价采购、6=其他")
	private Integer tenderForm;
	@ApiModelProperty("单项预算")
	private Double singleBudget;
	@ApiModelProperty("中标时间")
	private Date tenderDate;
	@ApiModelProperty("立项依据")
	private String buildItemBasis;
	@ApiModelProperty("到货时间")
	private Date arrivalTime;
	@ApiModelProperty("资金来源")
	List<AssArchivePurchaseInfoFundSources> listFundSources;
	@ApiModelProperty("验收附件")
	List<AssArchivePurchaseInfoAttachment> acceptAttachments;
	@ApiModelProperty("招标附件")
	List<AssArchivePurchaseInfoAttachment> bidAttachments;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getArchiveId() {
		return archiveId;
	}
	public void setArchiveId(Long archiveId) {
		this.archiveId = archiveId;
	}
	public Long getAssetsId() {
		return assetsId;
	}
	public void setAssetsId(Long assetsId) {
		this.assetsId = assetsId;
	}
	public Integer getPurchaseType() {
		return purchaseType;
	}
	public void setPurchaseType(Integer purchaseType) {
		this.purchaseType = purchaseType;
	}
	public Date getApplyDate() {
		return applyDate;
	}
	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}
	public Integer getApplyDeptId() {
		return applyDeptId;
	}
	public void setApplyDeptId(Integer applyDeptId) {
		this.applyDeptId = applyDeptId;
	}
	public Date getProveDate() {
		return proveDate;
	}
	public void setProveDate(Date proveDate) {
		this.proveDate = proveDate;
	}
	public Date getPreviewArriveDate() {
		return previewArriveDate;
	}
	public void setPreviewArriveDate(Date previewArriveDate) {
		this.previewArriveDate = previewArriveDate;
	}
	public String getApplyReason() {
		return applyReason;
	}
	public void setApplyReason(String applyReason) {
		this.applyReason = applyReason;
	}
	public String getAcceptor() {
		return acceptor;
	}
	public void setAcceptor(String acceptor) {
		this.acceptor = acceptor;
	}
	public String getAcceptorDeptName() {
		return acceptorDeptName;
	}
	public void setAcceptorDeptName(String acceptorDeptName) {
		this.acceptorDeptName = acceptorDeptName;
	}
	public Date getAcceptorTime() {
		return acceptorTime;
	}
	public void setAcceptorTime(Date acceptorTime) {
		this.acceptorTime = acceptorTime;
	}
	public Integer getPurchaseMode() {
		return purchaseMode;
	}
	public void setPurchaseMode(Integer purchaseMode) {
		this.purchaseMode = purchaseMode;
	}
	public Integer getTenderForm() {
		return tenderForm;
	}
	public void setTenderForm(Integer tenderForm) {
		this.tenderForm = tenderForm;
	}
	public Double getSingleBudget() {
		return singleBudget;
	}
	public void setSingleBudget(Double singleBudget) {
		this.singleBudget = singleBudget;
	}
	public Date getTenderDate() {
		return tenderDate;
	}
	public void setTenderDate(Date tenderDate) {
		this.tenderDate = tenderDate;
	}
	public String getBuildItemBasis() {
		return buildItemBasis;
	}
	public void setBuildItemBasis(String buildItemBasis) {
		this.buildItemBasis = buildItemBasis;
	}
	public Date getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(Date arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	
	public List<AssArchivePurchaseInfoFundSources> getListFundSources() {
		return listFundSources;
	}
	public void setListFundSources(List<AssArchivePurchaseInfoFundSources> listFundSources) {
		this.listFundSources = listFundSources;
	}
	public List<AssArchivePurchaseInfoAttachment> getAcceptAttachments() {
		return acceptAttachments;
	}
	public void setAcceptAttachments(List<AssArchivePurchaseInfoAttachment> acceptAttachments) {
		this.acceptAttachments = acceptAttachments;
	}
	public List<AssArchivePurchaseInfoAttachment> getBidAttachments() {
		return bidAttachments;
	}
	public void setBidAttachments(List<AssArchivePurchaseInfoAttachment> bidAttachments) {
		this.bidAttachments = bidAttachments;
	}
	
	
}
