package com.aek.ebey.assets.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("档案详情")
public class AssetArchiveDetailVo {

	private Long id;
	@ApiModelProperty(value="机构ID")
	private Long tenantId;
	@ApiModelProperty(value="设备ID")
	private Long assetsId;
	@ApiModelProperty(value="档案名称")
	private String archiveName;
	@ApiModelProperty(value="档案编号")
	private String archiveNum;
	@ApiModelProperty(value="保管期限(1=永久，2=长期(16~50年)，3=短期(15年以下))")
	private String limitStorageTimeStr;
	@ApiModelProperty(value="保密级别(1=公开级,2=内部级,3=秘密级,4=机密级,5=绝密级)")
	private String secretLevelStr;
	@ApiModelProperty(value="立卷人")
	private String filingUserName;
	@ApiModelProperty(value="立卷时间")
	private String filingTimeStr;
	@ApiModelProperty(value="检查人")
	private String checkUserName;
	@ApiModelProperty(value="检查日期")
	private String checkTimeStr;
	@ApiModelProperty(value="起止日期")
	private String startEndDateStr;
	@ApiModelProperty(value="立卷单位")
	private String filingDepartment;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getTenantId() {
		return tenantId;
	}
	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}
	public Long getAssetsId() {
		return assetsId;
	}
	public void setAssetsId(Long assetsId) {
		this.assetsId = assetsId;
	}
	public String getArchiveName() {
		return archiveName;
	}
	public void setArchiveName(String archiveName) {
		this.archiveName = archiveName;
	}
	public String getArchiveNum() {
		return archiveNum;
	}
	public void setArchiveNum(String archiveNum) {
		this.archiveNum = archiveNum;
	}
	public String getLimitStorageTimeStr() {
		return limitStorageTimeStr;
	}
	public void setLimitStorageTimeStr(String limitStorageTimeStr) {
		this.limitStorageTimeStr = limitStorageTimeStr;
	}
	public String getSecretLevelStr() {
		return secretLevelStr;
	}
	public void setSecretLevelStr(String secretLevelStr) {
		this.secretLevelStr = secretLevelStr;
	}
	public String getFilingUserName() {
		return filingUserName;
	}
	public void setFilingUserName(String filingUserName) {
		this.filingUserName = filingUserName;
	}
	public String getFilingTimeStr() {
		return filingTimeStr;
	}
	public void setFilingTimeStr(String filingTimeStr) {
		this.filingTimeStr = filingTimeStr;
	}
	public String getCheckUserName() {
		return checkUserName;
	}
	public void setCheckUserName(String checkUserName) {
		this.checkUserName = checkUserName;
	}
	public String getCheckTimeStr() {
		return checkTimeStr;
	}
	public void setCheckTimeStr(String checkTimeStr) {
		this.checkTimeStr = checkTimeStr;
	}
	
	public String getStartEndDateStr() {
		return startEndDateStr;
	}
	public void setStartEndDateStr(String startEndDateStr) {
		this.startEndDateStr = startEndDateStr;
	}
	public String getFilingDepartment() {
		return filingDepartment;
	}
	public void setFilingDepartment(String filingDepartment) {
		this.filingDepartment = filingDepartment;
	}

	
	
	
}
