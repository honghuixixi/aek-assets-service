package com.aek.ebey.assets.model.query;

import java.sql.Date;
import java.util.List;

public class AssetsCurveQuery {

	private Long tenantId;
	private Integer status;
	private Date startDate;
	private Date endDate;
	
	private List<Long> tenantIds;
	
	public Long getTenantId() {
		return tenantId;
	}
	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public List<Long> getTenantIds() {
		return tenantIds;
	}
	public void setTenantIds(List<Long> tenantIds) {
		this.tenantIds = tenantIds;
	}
	
}
