package com.aek.ebey.assets.model.bo;

import java.util.List;

public class ApplyInfo {

	private String director;
	private String deptName;
	private String illustration;
	private String suggestion;
	private List<AssetBo> assetList;
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getIllustration() {
		return illustration;
	}
	public void setIllustration(String illustration) {
		this.illustration = illustration;
	}
	public List<AssetBo> getAssetList() {
		return assetList;
	}
	public void setAssetList(List<AssetBo> assetList) {
		this.assetList = assetList;
	}
	public String getSuggestion() {
		return suggestion;
	}
	public void setSuggestion(String suggestion) {
		this.suggestion = suggestion;
	}
	
	
	
	
}
