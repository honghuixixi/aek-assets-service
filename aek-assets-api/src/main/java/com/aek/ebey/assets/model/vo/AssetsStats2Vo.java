package com.aek.ebey.assets.model.vo;

import java.io.Serializable;
import java.util.Date;

public class AssetsStats2Vo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long tenantId;
	private Date countTime;
	private String countMonth;
	private Long assetsTotalNum = 0l;
	private Double assetsTotalCapital = 0d;
	public Long getTenantId() {
		return tenantId;
	}
	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}
	public Date getCountTime() {
		return countTime;
	}
	public void setCountTime(Date countTime) {
		this.countTime = countTime;
	}
	
	public String getCountMonth() {
		return countMonth;
	}
	public void setCountMonth(String countMonth) {
		this.countMonth = countMonth;
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
	
	
	

}
