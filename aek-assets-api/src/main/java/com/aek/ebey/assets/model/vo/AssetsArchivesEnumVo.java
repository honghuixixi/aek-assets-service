package com.aek.ebey.assets.model.vo;

import java.util.List;
import java.util.Map;

public class AssetsArchivesEnumVo {

	private List<Map<String, Object>> secrecyLevel;
	private List<Map<String, Object>> retentionPeriod;
	
	public List<Map<String, Object>> getSecrecyLevel() {
		return secrecyLevel;
	}
	public void setSecrecyLevel(List<Map<String, Object>> secrecyLevel) {
		this.secrecyLevel = secrecyLevel;
	}
	public List<Map<String, Object>> getRetentionPeriod() {
		return retentionPeriod;
	}
	public void setRetentionPeriod(List<Map<String, Object>> retentionPeriod) {
		this.retentionPeriod = retentionPeriod;
	}
	
	
}
