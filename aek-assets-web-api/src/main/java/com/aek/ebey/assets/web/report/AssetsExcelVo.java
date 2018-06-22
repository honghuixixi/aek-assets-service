package com.aek.ebey.assets.web.report;

import java.util.Date;
import java.util.List;

import com.aek.ebey.assets.constant.SysConstant;

/**
 * 资产Excel导入类
 */
public class AssetsExcelVo {

    @ExcelColumn(value = 0, title = "设备名称（必填）", maxLength = 40, required = true)
    private String assetsName;

    @ExcelColumn(value = 1, title = "生产商（必填）", maxLength = 40, required = true)
    private String factoryName;

    @ExcelColumn(value = 2, title = "规格型号", maxLength = 40)
    private String assetsSpec;

    @ExcelColumn(value = 3, title = "注册证号", maxLength = 40, comment = "1.请按国家食品药品监督管理总局规定的格式输入，示例：国食药监械（准） 字2017第1210055号")
    private String regNo;

    @ExcelColumn(value = 4, maxLength = 40, title = "出厂编号（SN）")
    private String factoryNum;

    @ExcelColumn(value = 5, title = "三级分类代码", regex = "^68[0-9]{4}", msg = "必须是以68开头的6位数字.")
    private String threeLevelCode;

    @ExcelColumn(value = 6, title = "核算类别", relField = "assetsClassId", baseDataType = SysConstant.ACCOUNT_CATEGORY)
    private String assetsClassIdText;
    private Integer assetsClassId;

    @ExcelColumn(value = 7, title = "管理级别", relField = "manageLevel", baseDataType = "MANAGE_LEVEL")
    private String manageLevelText;
    private Integer manageLevel;

    @ExcelColumn(value = 8, title = "风险程度分析", maxLength = 40, relFieldType = String.class)
    private String riskLevel;

    @ExcelColumn(value = 9, title = "启用日期", relField = "startUseDate", relFieldType = Date.class)
    private String startUseDateStr;
    private Date startUseDate;

    @ExcelColumn(value = 10, title = "供应商", maxLength = 40)
    private String splName;

    @ExcelColumn(value = 11, title = "资金来源", relField = "fundSourcesId", baseDataType = "FUND_SOURCES")
    private String fundSourcesText;
    private Integer fundSourcesId;

    @ExcelColumn(value = 12, title = "品牌", maxLength = 40)
    private String assetsBrand;

    @ExcelColumn(value = 13, title = "设备注册证名称", maxLength = 40)
    private String regName;

    @ExcelColumn(value = 14, title = "计量类别", relField = "measureType", baseDataType = "MEASURE_TYPE")
    private String measureTypeText;
    private Integer measureType;

    @ExcelColumn(value = 15, title = "所在部门（必填）", required = true, maxLength = 40)
    private String deptName;
    private Integer deptId;

    @ExcelColumn(value = 16, title = "设备来源", relField = "purchaseTypeId", baseDataType = "PURCHASE_TYPE")
    private String purchaseTypeText;
    private Integer purchaseTypeId;

    @ExcelColumn(value = 17, title = "设备单价", relField = "price", relFieldType = Long.class, format = "money")
    private String priceStr;
    private Long price;

    @ExcelColumn(value = 18, title = "院内资产编码", maxLength = 40, relFieldType = String.class)
    private String serialNum;

    /**
     * 错误信息
     */
    private String message;
    /**
     * 错误的列索引
     */
    private List<Integer> errorCols;

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

    public String getSplName() {
        return splName;
    }

    public void setSplName(String splName) {
        this.splName = splName;
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

    public String getAssetsBrand() {
        return assetsBrand;
    }

    public void setAssetsBrand(String assetsBrand) {
        this.assetsBrand = assetsBrand;
    }

    public String getRegName() {
        return regName;
    }

    public void setRegName(String regName) {
        this.regName = regName;
    }

    public Integer getManageLevel() {
        return manageLevel;
    }

    public void setManageLevel(Integer manageLevel) {
        this.manageLevel = manageLevel;
    }

    public Integer getMeasureType() {
        return measureType;
    }

    public void setMeasureType(Integer measureType) {
        this.measureType = measureType;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getStartUseDateStr() {
        return startUseDateStr;
    }

    public void setStartUseDateStr(String startUseDateStr) {
        this.startUseDateStr = startUseDateStr;
    }

    public Date getStartUseDate() {
        return startUseDate;
    }

    public void setStartUseDate(Date startUseDate) {
        this.startUseDate = startUseDate;
    }

    public Integer getPurchaseTypeId() {
        return purchaseTypeId;
    }

    public void setPurchaseTypeId(Integer purchaseTypeId) {
        this.purchaseTypeId = purchaseTypeId;
    }

    public String getThreeLevelCode() {
        return threeLevelCode;
    }

    public void setThreeLevelCode(String threeLevelCode) {
        this.threeLevelCode = threeLevelCode;
    }

    public Integer getAssetsClassId() {
        return assetsClassId;
    }

    public void setAssetsClassId(Integer assetsClassId) {
        this.assetsClassId = assetsClassId;
    }

    public String getPriceStr() {
        return priceStr;
    }

    public void setPriceStr(String priceStr) {
        this.priceStr = priceStr;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Integer getFundSourcesId() {
        return fundSourcesId;
    }

    public void setFundSourcesId(Integer fundSourcesId) {
        this.fundSourcesId = fundSourcesId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Integer> getErrorCols() {
        return errorCols;
    }

    public void setErrorCols(List<Integer> errorCols) {
        this.errorCols = errorCols;
    }

    public String getAssetsClassIdText() {
        return assetsClassIdText;
    }

    public void setAssetsClassIdText(String assetsClassIdText) {
        this.assetsClassIdText = assetsClassIdText;
    }

    public String getManageLevelText() {
        return manageLevelText;
    }

    public void setManageLevelText(String manageLevelText) {
        this.manageLevelText = manageLevelText;
    }

    public String getFundSourcesText() {
        return fundSourcesText;
    }

    public void setFundSourcesText(String fundSourcesText) {
        this.fundSourcesText = fundSourcesText;
    }

    public String getMeasureTypeText() {
        return measureTypeText;
    }

    public void setMeasureTypeText(String measureTypeText) {
        this.measureTypeText = measureTypeText;
    }

    public String getPurchaseTypeText() {
        return purchaseTypeText;
    }

    public void setPurchaseTypeText(String purchaseTypeText) {
        this.purchaseTypeText = purchaseTypeText;
    }

    public String getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(String serialNum) {
        this.serialNum = serialNum;
    }

    public String getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel;
    }
}
