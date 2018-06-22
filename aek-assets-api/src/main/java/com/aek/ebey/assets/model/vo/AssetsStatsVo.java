package com.aek.ebey.assets.model.vo;

import java.util.Date;

public class AssetsStatsVo {
	
	/**
	 * 机构ID
	 */
	private Long tenantId;
	/**
	 * 统计日期（年月日）
	 */
	private Date countDate;
	/**
	 * 资产设备总数
	 */
	private Long assetsTotalNum = 0l;
	/**
	 * 资产设备总额
	 */
	private Double assetsTotalCapital = 0d;
	/**
	 * 年度新增设备总数
	 */
	private Long assetsTotalNewNumYear = 0l;
	/**
	 * 资产年度报损总数
	 */
	private Long assetsTotalDiscardNumYear = 0l;
	/**
	 * 年度新增设备总额
	 */
	private Double assetsTotalNewCapitalYear = 0d;
	/**
	 * 年度设备报损总额
	 */
	private Double assetsTotalDiscardCapitalYear = 0d;
	/**
	 * 维修中设备百分比
	 */
	private Double assetsRepairPercent = 0d;
	/**
	 * 正常设备百分比
	 */
	private Double assetsUnrepairPercent = 100d;
	/**
	 * 资产分布比例JSON数据集合（比例项ID，比例项描述，分布比例，排序）
	 */
	private String assetsDistributionData;
	/**
	 * 统计时间
	 */
	private Date countTime;
	/**
	 * 资产维修数目
	 */
	private Long assetsRepairAssetsNum;
	/**
	 * 资产未维修数目
	 */
	private Long assetsUnrepairAssetsNum;
	
	public Long getTenantId() {
		return tenantId;
	}
	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}
	public Date getCountDate() {
		return countDate;
	}
	public void setCountDate(Date countDate) {
		this.countDate = countDate;
	}
	public Long getAssetsTotalNum() {
		return assetsTotalNum;
	}
	public void setAssetsTotalNum(Long assetsTotalNum) {
		this.assetsTotalNum = assetsTotalNum;
	}
	public Double getAssetsTotalCapital() {
		return assetsTotalCapital;
	}
	public void setAssetsTotalCapital(Double assetsTotalCapital) {
		this.assetsTotalCapital = assetsTotalCapital;
	}
	public Long getAssetsTotalNewNumYear() {
		return assetsTotalNewNumYear;
	}
	public void setAssetsTotalNewNumYear(Long assetsTotalNewNumYear) {
		this.assetsTotalNewNumYear = assetsTotalNewNumYear;
	}
	public Long getAssetsTotalDiscardNumYear() {
		return assetsTotalDiscardNumYear;
	}
	public void setAssetsTotalDiscardNumYear(Long assetsTotalDiscardNumYear) {
		this.assetsTotalDiscardNumYear = assetsTotalDiscardNumYear;
	}
	public Double getAssetsTotalNewCapitalYear() {
		return assetsTotalNewCapitalYear;
	}
	public void setAssetsTotalNewCapitalYear(Double assetsTotalNewCapitalYear) {
		this.assetsTotalNewCapitalYear = assetsTotalNewCapitalYear;
	}
	public Double getAssetsTotalDiscardCapitalYear() {
		return assetsTotalDiscardCapitalYear;
	}
	public void setAssetsTotalDiscardCapitalYear(Double assetsTotalDiscardCapitalYear) {
		this.assetsTotalDiscardCapitalYear = assetsTotalDiscardCapitalYear;
	}
	public Double getAssetsRepairPercent() {
		return assetsRepairPercent;
	}
	public void setAssetsRepairPercent(Double assetsRepairPercent) {
		this.assetsRepairPercent = assetsRepairPercent;
	}
	public Double getAssetsUnrepairPercent() {
		return assetsUnrepairPercent;
	}
	public void setAssetsUnrepairPercent(Double assetsUnrepairPercent) {
		this.assetsUnrepairPercent = assetsUnrepairPercent;
	}
	public String getAssetsDistributionData() {
		return assetsDistributionData;
	}
	public void setAssetsDistributionData(String assetsDistributionData) {
		this.assetsDistributionData = assetsDistributionData;
	}
	public Date getCountTime() {
		return countTime;
	}
	public void setCountTime(Date countTime) {
		this.countTime = countTime;
	}
	public Long getAssetsRepairAssetsNum() {
		return assetsRepairAssetsNum;
	}
	public void setAssetsRepairAssetsNum(Long assetsRepairAssetsNum) {
		this.assetsRepairAssetsNum = assetsRepairAssetsNum;
	}
	public Long getAssetsUnrepairAssetsNum() {
		return assetsUnrepairAssetsNum;
	}
	public void setAssetsUnrepairAssetsNum(Long assetsUnrepairAssetsNum) {
		this.assetsUnrepairAssetsNum = assetsUnrepairAssetsNum;
	}
	
	
}
