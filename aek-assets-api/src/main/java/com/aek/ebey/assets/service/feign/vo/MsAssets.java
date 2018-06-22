package com.aek.ebey.assets.service.feign.vo;

/**
 * <p>
 * 计量设备信息表
 * </p>
 *
 * @author Honghui
 * @since 2018-04-25
 */
public class MsAssets{

	/**
	 * 机构ID
	 */
	private Long tenantId;
	/**
	 * 设备id
	 */
	private Long assetsId;
	/**
	 * 资产图片
	 */
	private String imgUrl;
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
	 * 设备编号
	 */
	private String assetsNum;
    
	/**
	 * 设备型号
	 */
	private String assetsSpec;
	/**
	 * 生产商ID
	 */
	private Integer factoryId;
	/**
	 * 生产商
	 */
	private String factoryName;
	
	/**
     * 出厂编号
     */
    private String factoryNum;
    /**
     * 院内编码
     */
    private String serialNum;
	/**
	 * 供应商ID
	 */
	private Integer splId;
	/**
	 * 供货单位名称
	 */
	private String splName;
    /**
	 * 状态：1=在库、2=在用、3=预登、4=待报损、5=报损、6=退货'
	 */
	private Integer assetsStatus;
	/**
	 * 作废标记，0：启用，1：删除
	 */
	private Boolean delFlag;
	
	public Long getTenantId() {
		return tenantId;
	}
	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}
	public Long getAssetsId() {
		return assetsId;
	}
	public void setAssetsId(Long assetsId) {
		this.assetsId = assetsId;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
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
	public String getAssetsNum() {
		return assetsNum;
	}
	public void setAssetsNum(String assetsNum) {
		this.assetsNum = assetsNum;
	}
	public String getAssetsSpec() {
		return assetsSpec;
	}
	public void setAssetsSpec(String assetsSpec) {
		this.assetsSpec = assetsSpec;
	}
	public Integer getFactoryId() {
		return factoryId;
	}
	public void setFactoryId(Integer factoryId) {
		this.factoryId = factoryId;
	}
	public String getFactoryName() {
		return factoryName;
	}
	public void setFactoryName(String factoryName) {
		this.factoryName = factoryName;
	}
	public Integer getSplId() {
		return splId;
	}
	public void setSplId(Integer splId) {
		this.splId = splId;
	}
	public String getSplName() {
		return splName;
	}
	public void setSplName(String splName) {
		this.splName = splName;
	}
	public Integer getAssetsStatus() {
		return assetsStatus;
	}
	public void setAssetsStatus(Integer assetsStatus) {
		this.assetsStatus = assetsStatus;
	}
	public Boolean getDelFlag() {
		return delFlag;
	}
	public void setDelFlag(Boolean delFlag) {
		this.delFlag = delFlag;
	}
	public String getFactoryNum() {
        return factoryNum;
    }
    public void setFactoryNum(String factoryNum) {
        this.factoryNum = factoryNum;
    }
    public String getSerialNum() {
        return serialNum;
    }
    public void setSerialNum(String serialNum) {
        this.serialNum = serialNum;
    }
    @Override
    public String toString() {
        return "MsAssets [tenantId=" + tenantId + ", assetsId=" + assetsId + ", imgUrl=" + imgUrl
                        + ", assetsName=" + assetsName + ", assetsDeptId=" + assetsDeptId
                        + ", assetsDeptName=" + assetsDeptName + ", assetsNum=" + assetsNum
                        + ", assetsSpec=" + assetsSpec + ", factoryId=" + factoryId
                        + ", factoryName=" + factoryName + ", factoryNum=" + factoryNum
                        + ", serialNum=" + serialNum + ", splId=" + splId + ", splName=" + splName
                        + ", assetsStatus=" + assetsStatus + ", delFlag=" + delFlag + "]";
    }
}
