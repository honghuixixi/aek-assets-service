package com.aek.ebey.assets.model.request;

import java.util.Date;
public class AssetsDisResponse  {

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
	 * 设备图片
	 */
	private String assetsImg;
	
	/**
	 * 供应商
	 */
	private String splName;
	
	/**
	 * 生产商
	 */
	private String factoryName;
	
	/**
	 * 单位
	 */
	private Long unitId;
	
	
	/**
	 * 单位
	 */
	private String unitName;
	
	/**
	 * 启用日期
	 * 2017/11/21
	 */
	private Date startUseDate;
	
	
	/**
	 * 所在部门名称
	 */
	private Long deptId;
	 
	/**
	 * 所在部门名称
	 */
	private String deptName;

	
	/**
	 * 设备状态：
	0：已撤销
	1：撤销报损
	2：null
	 */
	private Integer status1;
	
	/**
	 * 设备状态：
	0：已撤销
	1：撤销报损
	2：null
	 */
	private String status;


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


	public String getAssetsImg() {
		return assetsImg;
	}


	public void setAssetsImg(String assetsImg) {
		this.assetsImg = assetsImg;
	}


	public String getSplName() {
		return splName;
	}


	public void setSplName(String splName) {
		this.splName = splName;
	}


	public String getFactoryName() {
		return factoryName;
	}


	public void setFactoryName(String factoryName) {
		this.factoryName = factoryName;
	}


	public String getUnitName() {
		return unitName;
	}


	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}


	public Date getStartUseDate() {
		return startUseDate;
	}


	public void setStartUseDate(Date startUseDate) {
		this.startUseDate = startUseDate;
	}


	public String getDeptName() {
		return deptName;
	}


	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public Long getUnitId() {
		return unitId;
	}


	public void setUnitId(Long unitId) {
		this.unitId = unitId;
	}


	public Long getDeptId() {
		return deptId;
	}


	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}


	public Integer getStatus1() {
		return status1;
	}


	public void setStatus1(Integer status1) {
		this.status1 = status1;
	}

	
}
