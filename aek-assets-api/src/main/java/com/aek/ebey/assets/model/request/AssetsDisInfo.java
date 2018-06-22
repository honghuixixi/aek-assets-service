package com.aek.ebey.assets.model.request;

import java.util.Date;
public class AssetsDisInfo  {

	/**
	 * 资产ID
	 */
	private Long assetsId;
	
	/**
	 * 设备规格型号
	 */
	private String assetsSpec;
	
	/**
	 * 设备编号
	 */
	private String assetsNum;
	
	/**
	 * 院内编码
	 */
	private String serialNum;

	/**
	 * 资产名称
	 */
	private String assetsName;
	
	/**
	 * 启用日期
	 * 2017/11/21
	 */
	private Date startUseDate;
	/**
	 * 设备状态：
	0：已撤销
	1：撤销报损
	2：null
	 */
	private Integer status;

	
	/**
	 * 生产商
	 */
	private String factoryName;
	
	/**
	 * 单位
	 */
	private String assetsUnit;
	/**
	 * 所在部门名称
	 */
	private String deptName;
	public Long getAssetsId() {
		return assetsId;
	}
	public void setAssetsId(Long assetsId) {
		this.assetsId = assetsId;
	}
	public String getAssetsSpec() {
		return assetsSpec;
	}
	public void setAssetsSpec(String assetsSpec) {
		this.assetsSpec = assetsSpec;
	}
	public String getAssetsNum() {
		return assetsNum;
	}
	public void setAssetsNum(String assetsNum) {
		this.assetsNum = assetsNum;
	}
	public String getSerialNum() {
		return serialNum;
	}
	public void setSerialNum(String serialNum) {
		this.serialNum = serialNum;
	}
	public String getAssetsName() {
		return assetsName;
	}
	public void setAssetsName(String assetsName) {
		this.assetsName = assetsName;
	}
	public Date getStartUseDate() {
		return startUseDate;
	}
	public void setStartUseDate(Date startUseDate) {
		this.startUseDate = startUseDate;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getFactoryName() {
		return factoryName;
	}
	public void setFactoryName(String factoryName) {
		this.factoryName = factoryName;
	}
	public String getAssetsUnit() {
		return assetsUnit;
	}
	public void setAssetsUnit(String assetsUnit) {
		this.assetsUnit = assetsUnit;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	
}
