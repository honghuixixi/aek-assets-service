package com.aek.ebey.assets.model.vo;


import java.util.Date;


import io.swagger.annotations.ApiModelProperty;

public class AssetBasicInfoVo {

    //basic info
    @ApiModelProperty(value = "设备名称")
    private String assetsName;
    @ApiModelProperty(value = "设备编号")
    private String assetsNum;
    @ApiModelProperty(value = "生产商")
    private String factoryName;
    @ApiModelProperty(value = "状态名称")
    public String statusName;
    @ApiModelProperty(value = "台账图片")
    private String assetsImg;
    @ApiModelProperty(value = "创建人姓名")
    private String createByName;
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    @ApiModelProperty(value = "0=入库新增,1=批量导入,2=验收录入,3=清查录入")
    private String assetsSourceName;
    @ApiModelProperty(value = "院内编码")
    private String serialNum;
    @ApiModelProperty(value = "设备规格")
    private String assetsSpec;
    @ApiModelProperty(value = "注册证号")
    private String regNo;
    @ApiModelProperty(value = "出厂编号")
    private String factoryNum;
    @ApiModelProperty(value = "三级分类代码")
    private String threeLevelCode;
    @ApiModelProperty(value = "品牌")
    private String assetsBrand;
    @ApiModelProperty(value = "产地")
    private String prodPlace;
    @ApiModelProperty(value = "注册证名称")
    private String regName;
    @ApiModelProperty(value = "单位")
    private String unitName;
    @ApiModelProperty(value = "账簿类型")
    private String assetsTypeName;
    @ApiModelProperty(value = "核算类别")
    private String assetsClassName;
    @ApiModelProperty(value = "管理级别名")
    private String manageLevelName;
    @ApiModelProperty(value = "计量类别")
    private String measureTypeName;
    @ApiModelProperty(value = "计量设备1：是，0：否")
    private Integer measureFlag;
    @ApiModelProperty(value = "巡检标识1启用0不启用")
    private Integer pollingFlag;
    @ApiModelProperty(value = "设备来源")
    private String purchaseTypeName;
    @ApiModelProperty(value = "是否国产（1，国产 2，进口）")
    private Integer madeIn;
    @ApiModelProperty(value = "购入日期")
    private Date purchaseDate;
    @ApiModelProperty(value = "供货单位")
    private String splName;
    @ApiModelProperty(value = "设备单价")
    private String priceStr;
    @ApiModelProperty(value = "风险程度分析")
    private String riskLevel;

    //use info
    @ApiModelProperty(value = "所在部门")
    private String deptName;
    @ApiModelProperty(value = "管理部门")
    private String manageDeptName;
    @ApiModelProperty(value = "启用日期")
    private Date startUseDate;
    @ApiModelProperty(value = "保修日期")
    private Date warrantyDate;
    @ApiModelProperty(value = "用途")
    private String purposeName;

    //depreciation info
    @ApiModelProperty(value = "折旧年限")
    private String oldYear;
    @ApiModelProperty(value = "设备原值(系统无折旧业务,暂且与设备单价保持一致)")
    private String originalValue;

    public Integer getMeasureFlag() {
        return measureFlag;
    }

    public void setMeasureFlag(Integer measureFlag) {
        this.measureFlag = measureFlag;
    }

    public String getAssetsName() {
        return assetsName;
    }

    public void setAssetsName(String assetsName) {
        this.assetsName = assetsName;
    }

    public String getAssetsNum() {
        return assetsNum;
    }

    public void setAssetsNum(String assetsNum) {
        this.assetsNum = assetsNum;
    }

    public String getFactoryName() {
        return factoryName;
    }

    public void setFactoryName(String factoryName) {
        this.factoryName = factoryName;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getAssetsImg() {
        return assetsImg;
    }

    public void setAssetsImg(String assetsImg) {
        this.assetsImg = assetsImg;
    }

    public String getCreateByName() {
        return createByName;
    }

    public void setCreateByName(String createByName) {
        this.createByName = createByName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getAssetsSourceName() {
        return assetsSourceName;
    }

    public void setAssetsSourceName(String assetsSourceName) {
        this.assetsSourceName = assetsSourceName;
    }

    public String getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(String serialNum) {
        this.serialNum = serialNum;
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

    public String getThreeLevelCode() {
        return threeLevelCode;
    }

    public void setThreeLevelCode(String threeLevelCode) {
        this.threeLevelCode = threeLevelCode;
    }

    public String getAssetsBrand() {
        return assetsBrand;
    }

    public void setAssetsBrand(String assetsBrand) {
        this.assetsBrand = assetsBrand;
    }

    public String getProdPlace() {
        return prodPlace;
    }

    public void setProdPlace(String prodPlace) {
        this.prodPlace = prodPlace;
    }

    public String getRegName() {
        return regName;
    }

    public void setRegName(String regName) {
        this.regName = regName;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getAssetsTypeName() {
        return assetsTypeName;
    }

    public void setAssetsTypeName(String assetsTypeName) {
        this.assetsTypeName = assetsTypeName;
    }

    public String getAssetsClassName() {
        return assetsClassName;
    }

    public void setAssetsClassName(String assetsClassName) {
        this.assetsClassName = assetsClassName;
    }

    public String getManageLevelName() {
        return manageLevelName;
    }

    public void setManageLevelName(String manageLevelName) {
        this.manageLevelName = manageLevelName;
    }

    public String getMeasureTypeName() {
        return measureTypeName;
    }

    public void setMeasureTypeName(String measureTypeName) {
        this.measureTypeName = measureTypeName;
    }

    public Integer getPollingFlag() {
        return pollingFlag;
    }

    public void setPollingFlag(Integer pollingFlag) {
        this.pollingFlag = pollingFlag;
    }

    public String getPurchaseTypeName() {
        return purchaseTypeName;
    }

    public void setPurchaseTypeName(String purchaseTypeName) {
        this.purchaseTypeName = purchaseTypeName;
    }

    public Integer getMadeIn() {
        return madeIn;
    }

    public void setMadeIn(Integer madeIn) {
        this.madeIn = madeIn;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getSplName() {
        return splName;
    }

    public void setSplName(String splName) {
        this.splName = splName;
    }

    public String getPriceStr() {
        return priceStr;
    }

    public void setPriceStr(String priceStr) {
        this.priceStr = priceStr;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getManageDeptName() {
        return manageDeptName;
    }

    public void setManageDeptName(String manageDeptName) {
        this.manageDeptName = manageDeptName;
    }

    public Date getStartUseDate() {
        return startUseDate;
    }

    public void setStartUseDate(Date startUseDate) {
        this.startUseDate = startUseDate;
    }

    public Date getWarrantyDate() {
        return warrantyDate;
    }

    public void setWarrantyDate(Date warrantyDate) {
        this.warrantyDate = warrantyDate;
    }

    public String getPurposeName() {
        return purposeName;
    }

    public void setPurposeName(String purposeName) {
        this.purposeName = purposeName;
    }

    public String getOldYear() {
        return oldYear;
    }

    public void setOldYear(String oldYear) {
        this.oldYear = oldYear;
    }

    public String getOriginalValue() {
        return originalValue;
    }

    public void setOriginalValue(String originalValue) {
        this.originalValue = originalValue;
    }

    public String getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel;
    }
}
