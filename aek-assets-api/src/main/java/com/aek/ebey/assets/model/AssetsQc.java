package com.aek.ebey.assets.model;

/**
 * 巡检设备实体类
 *	
 * @author HongHui
 * @date   2017年11月9日
 */
public class AssetsQc {
	
	/**
	 * 设备id
	 */
	private Long assetsId;
	/**
	 * 设备名称
	 */
	private String assetsName;

	/**
	 * 设备所在科室id
	 */
	private Long assetsDeptId;
	/**
	 * 设备所在科室名称
	 */
	private String assetsDeptName;
	/**
	 * 设备型号
	 */
	private String assetsSpec;
	/**
	 * 设备编号
	 */
	private String assetsNum;

	/**
	 * 设备状态（1，台帐 2，预台帐）
	 */
	private Integer assetsStatus;
	
	/**
	 * 设备图片
	 */
	private String imgUrl;

	public Long getAssetsId() {
		return assetsId;
	}

	public void setAssetsId(Long assetsId) {
		this.assetsId = assetsId;
	}

	public String getAssetsName() {
		return assetsName;
	}

	public void setAssetsName(String assetsName) {
		this.assetsName = assetsName;
	}

	public Long getAssetsDeptId() {
		return assetsDeptId;
	}

	public void setAssetsDeptId(Long assetsDeptId) {
		this.assetsDeptId = assetsDeptId;
	}

	public String getAssetsDeptName() {
		return assetsDeptName;
	}

	public void setAssetsDeptName(String assetsDeptName) {
		this.assetsDeptName = assetsDeptName;
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

	public Integer getAssetsStatus() {
		return assetsStatus;
	}

	public void setAssetsStatus(Integer assetsStatus) {
		this.assetsStatus = assetsStatus;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	
}
