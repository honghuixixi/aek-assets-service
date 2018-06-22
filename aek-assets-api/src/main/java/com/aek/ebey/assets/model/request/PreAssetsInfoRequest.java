package com.aek.ebey.assets.model.request;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class PreAssetsInfoRequest {

	/**
	 * 使用科室ID
	 */
	@ApiModelProperty(value = "使用科室ID")
	private Integer deptId;
	
	/**
     * 状态：1未启用、2正常运行、3计量中、4维修中、5停用中、6已报废、7已报损
     * 状态：状态：1=在库、2=在用、3=预登、4=待报损、5=报损、6=退货
     */
	//@ApiModelProperty(value = "状态：1未启用、2正常运行、3计量中、4维修中、5停用中、6已报废、7已报损")
	@ApiModelProperty(value = "状态：状态：1=在库、2=在用、3=预登、4=待报损、5=报损、6=退货")
    private Integer status;
	
	 /**
     * 设备类型（1，台帐  2，预台帐）
     */
    @ApiModelProperty(value = "设备类型（1，台帐  2，预台帐）")
    private Integer assetsStatus;
    
    /**
     * 设备类型（1，台帐  2，预台帐）
     */
    @ApiModelProperty(value = "来源，0：入库新增，1：批量导入 2:验收录入3：清查录入")
    private Integer assetsSource;

	/**
	 * 资产名称
	 */
	@ApiModelProperty(value = "资产名称")
	private String assetsName;

	/**
	 * 厂家名称
	 */
	@ApiModelProperty(value = "厂家名称")
	private String factoryName;

	/**
	 * 设备规格型号
	 */
	@ApiModelProperty(value = "设备规格型号")
	private String assetsSpec;

	/**
	 * 注册证号
	 */
	@ApiModelProperty(value = "注册证号")
	private String regNo;

	/**
	 * 出厂编号
	 */
	@ApiModelProperty(value = "出厂编号")
	private String factoryNum;

	/**
	 * 核算类别ID
	 */
	@ApiModelProperty(value = "核算类别ID")
	private Integer assetsClassId;
	/**
	 * 管理级别
	 */
	@ApiModelProperty(value = "管理级别")
	private Integer manageLevel;

	/**
	 * 供货单位名称
	 */
	@ApiModelProperty(value = "供货单位名称")
	private String splName;

	/**
	 * 经费来源ID
	 */
	@ApiModelProperty(value = "经费来源ID")
	private Integer fundSourcesId;
	/**
	 * 三级分类代码
	 */
	@ApiModelProperty(value = "三级分类代码")
	private String threeLevelCode;
	
	/**
     * 启用日期
     */
	@ApiModelProperty(value = "启用日期")
    private Date startUseDate;
	
	/**
	 * 院内编码
	 */
	@ApiModelProperty(value = "院内编码")
	private String serialNum;
	
	
	public Integer getDeptId() {
		return deptId;
	}
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	public String getAssetsName() {
		return assetsName;
	}
	public void setAssetsName(String assetsName) {
		this.assetsName = assetsName;
	}
	public String getFactoryName() {
		return factoryName;
	}
	public void setFactoryName(String factoryName) {
		this.factoryName = factoryName;
	}
	public String getAssetsSpec() {
		return assetsSpec;
	}
	public void setAssetsSpec(String assetsSpec) {
		this.assetsSpec = assetsSpec;
	}
	public String getRegNo() {
		return regNo;
	}
	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}
	public String getFactoryNum() {
		return factoryNum;
	}
	public void setFactoryNum(String factoryNum) {
		this.factoryNum = factoryNum;
	}
	public Integer getAssetsClassId() {
		return assetsClassId;
	}
	public void setAssetsClassId(Integer assetsClassId) {
		this.assetsClassId = assetsClassId;
	}
	public Integer getManageLevel() {
		return manageLevel;
	}
	public void setManageLevel(Integer manageLevel) {
		this.manageLevel = manageLevel;
	}
	public String getSplName() {
		return splName;
	}
	public void setSplName(String splName) {
		this.splName = splName;
	}
	public Integer getFundSourcesId() {
		return fundSourcesId;
	}
	public void setFundSourcesId(Integer fundSourcesId) {
		this.fundSourcesId = fundSourcesId;
	}
	public String getThreeLevelCode() {
		return threeLevelCode;
	}
	public void setThreeLevelCode(String threeLevelCode) {
		this.threeLevelCode = threeLevelCode;
	}
	public Date getStartUseDate() {
		return startUseDate;
	}
	public void setStartUseDate(Date startUseDate) {
		this.startUseDate = startUseDate;
	}
	
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	public Integer getAssetsStatus() {
		return assetsStatus;
	}
	public void setAssetsStatus(Integer assetsStatus) {
		this.assetsStatus = assetsStatus;
	}
	
	public Integer getAssetsSource() {
		return assetsSource;
	}
	public void setAssetsSource(Integer assetsSource) {
		this.assetsSource = assetsSource;
	}
	
	public String getSerialNum() {
		return serialNum;
	}
	public void setSerialNum(String serialNum) {
		this.serialNum = serialNum;
	}
	
	@Override
	public String toString() {
		return "AssetsInfoRequest [deptId=" + deptId + ", status=" + status + ", assetsStatus=" + assetsStatus
				+ ", assetsSource=" + assetsSource + ", assetsName=" + assetsName + ", factoryName=" + factoryName
				+ ", assetsSpec=" + assetsSpec + ", regNo=" + regNo + ", factoryNum=" + factoryNum + ", assetsClassId="
				+ assetsClassId + ", manageLevel=" + manageLevel + ", splName=" + splName + ", fundSourcesId="
				+ fundSourcesId + ", threeLevelCode=" + threeLevelCode + ", startUseDate=" + startUseDate
				+ ", serialNum=" + serialNum + "]";
	}
	
}
