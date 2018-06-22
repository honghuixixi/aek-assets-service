package com.aek.ebey.assets.model.request;

import java.util.List;

public class DiscardApplyInfo {
	
	/**
	 * 报损类型
	 */
	private String type;
	
	/**
	 * 说明
	 */
	private String illustration;
	
	/**
	 * 审核意见
	 */
	private String suggestion;
	

	/**
	 * 设备明细
	 */
	private List<AssetsDisInfo> assetList;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getIllustration() {
		return illustration;
	}

	public void setIllustration(String illustration) {
		this.illustration = illustration;
	}

	public List<AssetsDisInfo> getAssetList() {
		return assetList;
	}

	public void setAssetList(List<AssetsDisInfo> assetList) {
		this.assetList = assetList;
	}

	public String getSuggestion() {
		return suggestion;
	}

	public void setSuggestion(String suggestion) {
		this.suggestion = suggestion;
	}
	
	
}
