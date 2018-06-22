package com.aek.ebey.assets.web.request;

import java.util.Date;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class AssArchiveRequest {

	@ApiModelProperty(value="档案ID")
	private Long id;
	@ApiModelProperty(value="设备ID")
	private Long assetsId;
	@ApiModelProperty(value="档案名称")
	private String archiveName;
	@ApiModelProperty(value="保管期限(1=永久，2=长期(16~50年)，3=短期(15年以下)")
	private Integer limitStorageTime;
	@ApiModelProperty(value="保密级别(1=公开级,2=内部级,3=秘密级,4=机密级,5=绝密级)")
	private Integer secretLevel;
	@ApiModelProperty(value="立卷人")
	private String filingUserName;
	@ApiModelProperty(value="立卷时间")
	private Date filingTime;
	@ApiModelProperty(value="检查人")
	private String checkUserName;
	@ApiModelProperty(value="检查日期")
	private Date checkTime;
	@ApiModelProperty(value="起止开始时间")
	private Date startTime;
	@ApiModelProperty(value="起止结束时间")
	private Date endTime;
	@ApiModelProperty(value="立卷单位")
	private String filingDepartment;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public Integer getLimitStorageTime() {
		return limitStorageTime;
	}
	public void setLimitStorageTime(Integer limitStorageTime) {
		this.limitStorageTime = limitStorageTime;
	}
	public Integer getSecretLevel() {
		return secretLevel;
	}
	public void setSecretLevel(Integer secretLevel) {
		this.secretLevel = secretLevel;
	}
	public String getFilingUserName() {
		return filingUserName;
	}
	public void setFilingUserName(String filingUserName) {
		this.filingUserName = filingUserName;
	}
	public Date getFilingTime() {
		return filingTime;
	}
	public void setFilingTime(Date filingTime) {
		this.filingTime = filingTime;
	}
	public String getCheckUserName() {
		return checkUserName;
	}
	public void setCheckUserName(String checkUserName) {
		this.checkUserName = checkUserName;
	}
	public Date getCheckTime() {
		return checkTime;
	}
	public void setCheckTime(Date checkTime) {
		this.checkTime = checkTime;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public String getFilingDepartment() {
		return filingDepartment;
	}
	public void setFilingDepartment(String filingDepartment) {
		this.filingDepartment = filingDepartment;
	}

	
	
}
