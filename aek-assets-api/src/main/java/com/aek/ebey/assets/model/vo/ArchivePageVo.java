package com.aek.ebey.assets.model.vo;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("档案列表查询分页实体类")

public class ArchivePageVo {
	@ApiModelProperty(value="档案id")
	private Long id;
	@ApiModelProperty(value="档案编号")
	private String archiveNum;
	@ApiModelProperty(value="档案名称")
	private String archiveName;
	@ApiModelProperty(value="设备编号")
	private String assetsNum;
	@ApiModelProperty(value="设备名称")
	private String assetsName;
	@ApiModelProperty(value="出厂编号")
	private String factoryNum;
	@ApiModelProperty(value="立卷日期")
	private Date filingTime;
	@ApiModelProperty(value="立卷人")
	private String filingUserName;
	@ApiModelProperty(value="密级")
	private String secretLevelStr;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getArchiveNum() {
		return archiveNum;
	}
	public void setArchiveNum(String archiveNum) {
		this.archiveNum = archiveNum;
	}
	public String getArchiveName() {
		return archiveName;
	}
	public void setArchiveName(String archiveName) {
		this.archiveName = archiveName;
	}
	public String getAssetsNum() {
		return assetsNum;
	}
	public void setAssetsNum(String assetsNum) {
		this.assetsNum = assetsNum;
	}
	public String getAssetsName() {
		return assetsName;
	}
	public void setAssetsName(String assetsName) {
		this.assetsName = assetsName;
	}
	public String getFactoryNum() {
		return factoryNum;
	}
	public void setFactoryNum(String factoryNum) {
		this.factoryNum = factoryNum;
	}
	public Date getFilingTime() {
		return filingTime;
	}
	public void setFilingTime(Date filingTime) {
		this.filingTime = filingTime;
	}
	public String getFilingUserName() {
		return filingUserName;
	}
	public void setFilingUserName(String filingUserName) {
		this.filingUserName = filingUserName;
	}
	public String getSecretLevelStr() {
		return secretLevelStr;
	}
	public void setSecretLevelStr(String secretLevelStr) {
		this.secretLevelStr = secretLevelStr;
	}
	
	
}
