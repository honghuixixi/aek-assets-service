package com.aek.ebey.assets.model.vo;

import java.util.Date;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class PreEditArchiveVo {

	@ApiModelProperty("设备ID")
	private Long assetId;
	@ApiModelProperty("设备名称")
	private String assetsName;
	@ApiModelProperty("设备编码")
	private String assetsNum;
	@ApiModelProperty("设备出厂编号")
	private String factoryNum;
	@ApiModelProperty("设备所在部门id")
	private Long deptId;
	@ApiModelProperty("设备所在部门")
	private String deptName;
	@ApiModelProperty("档案id")
	private Long id;
	@ApiModelProperty("机构ID")
	private Long tenantId;
	@ApiModelProperty("档案名称")
	private String archiveName;
	@ApiModelProperty("档案编号")
	private String archiveNum;
	@ApiModelProperty("保管期限(1=永久，2=长期(16~50年)，3=短期(15年以下))")
	private Integer limitStorageTime;
	@ApiModelProperty("保密级别(1=公开级,2=内部级,3=秘密级,4=机密级,5=绝密级)")
	private Integer secretLevel;
	@ApiModelProperty("立卷人")
	private String filingUserName;
	@ApiModelProperty("立卷时间")
	private Date filingTime;
	@ApiModelProperty("检查人")
	private String checkUserName;
	@ApiModelProperty("检查日期")
	private Date checkTime;
	@ApiModelProperty("起止开始时间")
	private Date startTime;
	@ApiModelProperty("起止结束时间")
	private Date endTime;
	@ApiModelProperty("立卷单位")
	private String filingDepartment;
	public Long getAssetId() {
		return assetId;
	}
	public void setAssetId(Long assetId) {
		this.assetId = assetId;
	}
	public String getAssetsName() {
		return assetsName;
	}
	public void setAssetsName(String assetsName) {
		this.assetsName = assetsName;
	}
	public String getAssetsNum() {
		return assetsNum;
	}
	public void setAssetsNum(String assetsNum) {
		this.assetsNum = assetsNum;
	}
	public String getFactoryNum() {
		return factoryNum;
	}
	public void setFactoryNum(String factoryNum) {
		this.factoryNum = factoryNum;
	}
	
	public Long getDeptId() {
		return deptId;
	}
	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
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
