package com.aek.ebey.assets.model.request;

import java.util.Date;
import java.util.List;

public class DiscardReportDetail {


	/**
	 * 报损单id
	 */
	private Long id;
	
	/**
	 * 报损单号
	 */
	private String num;
	
	/**
	 * 机构名称
	 */
	private String name;
	
	/**
	 * 报损类型
	 */
	private String type;
	/**
	 * 审核结果
	 */
	private String status;
	/**
	 * 申请人
	 */
	private String applyName;
	/**
	 * 提交日期
	 */
	private Date applyDate;
	
	/**
	 * 审核日期
	 */
	private Date examineDate;
	
	/**
	 * 审核人
	 */
	private String examineName;
	/**
	 * 审核备注
	 */
	private String remarks;
	/**
	 * 说明
	 */
	private String illustration;
	/**
	 * 审核意见
	 */
	private String suggestion;
	/**
	 * 设备明细
	 */
	private List<AssetsDisInfo> assetList;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getApplyName() {
		return applyName;
	}
	public void setApplyName(String applyName) {
		this.applyName = applyName;
	}
	public Date getApplyDate() {
		return applyDate;
	}
	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}
	public Date getExamineDate() {
		return examineDate;
	}
	public void setExamineDate(Date examineDate) {
		this.examineDate = examineDate;
	}
	public String getExamineName() {
		return examineName;
	}
	public void setExamineName(String examineName) {
		this.examineName = examineName;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getIllustration() {
		return illustration;
	}
	public void setIllustration(String illustration) {
		this.illustration = illustration;
	}
	public String getSuggestion() {
		return suggestion;
	}
	public void setSuggestion(String suggestion) {
		this.suggestion = suggestion;
	}
	public List<AssetsDisInfo> getAssetList() {
		return assetList;
	}
	public void setAssetList(List<AssetsDisInfo> assetList) {
		this.assetList = assetList;
	}

}
