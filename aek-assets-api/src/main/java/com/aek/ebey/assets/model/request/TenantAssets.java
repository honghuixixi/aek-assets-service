package com.aek.ebey.assets.model.request;

import java.io.Serializable;

public class TenantAssets implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 租户id
	 */
	private Long tenantId;
	
	/**
	 * 台帐总数
	 */
	private String assetsTotal;

	public Long getTenantId() {
		return tenantId;
	}

	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}

	public String getAssetsTotal() {
		return assetsTotal;
	}

	public void setAssetsTotal(String assetsTotal) {
		this.assetsTotal = assetsTotal;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	

}
