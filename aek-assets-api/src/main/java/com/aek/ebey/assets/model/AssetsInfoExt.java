package com.aek.ebey.assets.model;

import java.util.Date;

import com.aek.common.core.base.BaseModel;
import com.aek.ebey.assets.core.util.NoComparedField;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 资产信息表扩展表
 * </p>
 *
 * @author aek
 * @since 2017-04-13
 */
@TableName("ass_assets_info_ext")
public class AssetsInfoExt extends BaseModel {

    private static final long serialVersionUID = 1L;

    /**
     * 资产ID
     */
    @TableField(value = "assets_id")
    @NoComparedField
    private Long assetsId;

    /**
     * 设备编号
     */
    @TableField(value = "assets_num")
    private String assetsNum;

    /**
     * 设备品牌
     */
    @TableField(value = "assets_brand")
    private String assetsBrand;

    /**
     * 产地
     */
    @TableField(value = "prod_place")
    private String prodPlace;

    /**
     * 出厂编号
     */
    @TableField(value = "factory_num")
    private String factoryNum;

    /**
     * 院内编码
     */
    @TableField(value = "serial_num")
    private String serialNum;

    /**
     * 管理级别
     */
    @TableField(value = "manage_level")
    private Integer manageLevel;

    /**
     * 计量类别
     */
    @TableField(value = "measure_type")
    private Integer measureType;

    /**
     * 是否免税设备0否1是
     */
    @TableField(value = "free_tax")
    @NoComparedField
    private Integer freeTax;

    /**
     * 商检标识1启用0不启用
     */
    @TableField(value = "commodity_flag")
    @NoComparedField
    private Integer commodityFlag;

    /**
     * 质检标识1启用0不启用
     */
    @TableField(value = "quality_flag")
    @NoComparedField
    private Integer qualityFlag;

    /**
     * 是否启用PM管理标识1启用0不启用
     */
    @TableField(value = "pm_flag")
    @NoComparedField
    private Integer pmFlag;

    /**
     * 是否已经在PM计划中1=在PM计划中,0=不在PM计划中
     */
    @TableField(value = "pm_plan_flag")
    @NoComparedField
    private Integer pmPlanFlag;

    /**
     * 启用日期
     */
    @TableField(value = "start_use_date")
    private Date startUseDate;

    /**
     * 保修日期
     */
    @TableField(value = "warranty_date")
    private Date warrantyDate;

    /**
     * 折旧方法1不计提折旧2平均年限法3年限总和法4双倍余额递减法
     */
    @TableField(value = "dep_type")
    @NoComparedField
    private Integer depType;

    /**
     * 0默认；1不需要再计算折旧计提
     */
    @TableField(value = "dep_status")
    @NoComparedField
    private Integer depStatus;

    /**
     * 厂家ID
     */
    @TableField(value = "factory_id")
    @NoComparedField
    private Integer factoryId;

    /**
     * 厂家名称
     */
    @TableField(value = "factory_name")
    @NoComparedField
    private String factoryName;

    /**
     * 注册证ID
     */
    @TableField(value = "reg_id")
    private Long regId;

    /**
     * 注册证名称
     */
    @TableField(value = "reg_name")
    private String regName;

    /**
     * 注册证号
     */
    @TableField(value = "reg_no")
    private String regNo;

    /**
     * 所在地点
     */
    @TableField(value = "assets_location")
    @NoComparedField
    private String assetsLocation;

    /**
     * 领用人ID
     */
    @TableField(value = "reception_id")
    @NoComparedField
    private Integer receptionId;

    /**
     * 领用时间
     */
    @TableField(value = "reception_date")
    @NoComparedField
    private Date receptionDate;

    /**
     * 采购时间
     */
    @TableField(value = "purchase_date")
    private Date purchaseDate;

    /**
     * 采购方式:1=国际招标、2=政府采购、3=院内采购、4=分散采购、5=自行采购、6=其他 2017/11/21
     */
    @ApiModelProperty(value = "采购方式:1=国际招标、2=政府采购、3=院内采购、4=分散采购、5=自行采购、6=其他")
    @TableField(value = "purchase_way")
    private Integer purchaseWay;
    /**
     * 招标形式:1=公开招标、2=邀请招标、3=竞争性谈判、4=单一来源采购、5=询价采购、6=其他 2017/11/21
     */
    @ApiModelProperty(value = "招标形式:1=公开招标、2=邀请招标、3=竞争性谈判、4=单一来源采购、5=询价采购、6=其他")
    @TableField(value = "tender_form")
    private Integer tenderForm;
    /**
     * 单项预算 2017/11/21
     */
    @ApiModelProperty(value = "单项预算")
    @TableField(value = "single_budget")
    private Long singleBudget;

    /**
     * 单项预算 2017/11/21
     */
    @ApiModelProperty(value = "单项预算")
    @TableField(exist = false)
    @NoComparedField
    private String singleBudgetStr;
    /**
     * 中标时间 2017/11/21
     */
    @ApiModelProperty(value = "中标时间")
    @TableField(value = "win_tender_date")
    private Date winTenderDate;
    /**
     * 立项依据 2017/11/21
     */
    @ApiModelProperty(value = "立项依据")
    @TableField(value = "approve_project_accord")
    private String approveProjectAccord;

    /**
     * 到货时间
     */
    @TableField(value = "arrival_date")
    private Date arrivalDate;

    /**
     * 设备来源ID
     */
    @TableField(value = "purchase_type_id")
    private Integer purchaseTypeId;

    /**
     * 出借费用（分/天）
     */
    @TableField(value = "lend_fee")
    @NoComparedField
    private Long lendFee;

    /**
     * 国资编号
     */
    @TableField(value = "sasac_num")
    @NoComparedField
    private String sasacNum;

    /**
     * 巡检标识1启用0不启用
     */
    @TableField(value = "polling_flag")
    private Integer pollingFlag;

    /**
     * 是否试用0是1否
     */
    @TableField(value = "try_flag")
    @NoComparedField
    private Integer tryFlag;

    /**
     * 保修标识1启用0不启用
     */
    @TableField(value = "warranty_flag")
    @NoComparedField
    private Integer warrantyFlag;

    /**
     * 维修标识1启用0不启用
     */
    @TableField(value = "repair_flag")
    @NoComparedField
    private Integer repairFlag;

    /**
     * 是否计量，1：是，0：否
     */
    @TableField(value = "measure_flag")
    @NoComparedField
    private Integer measureFlag;

    /**
     * 是否强检，1：是，0：否
     */
    @TableField(value = "force_flag")
    @NoComparedField
    private Integer forceFlag;

    /**
     * 是否启用保养， 0：不启用保养计划、1：启用保养计划
     */
    @TableField(value = "am_flag")
    @NoComparedField
    private Integer amFlag;

    /**
     * 是否赠送，1：赠送，0：非赠送
     */
    @TableField(value = "present_flag")
    @NoComparedField
    private Boolean presentFlag;

    /**
     * 保修厂商
     */
    @TableField(value = "warranty_id")
    @NoComparedField
    private Integer warrantyId;

    /**
     * 法定报废日期
     */
    @TableField(value = "statutory_scrap_date")
    @NoComparedField
    private Date statutoryScrapDate;

    /**
     * 报废时间
     */
    @TableField(value = "scrap_date")
    @NoComparedField
    private Date scrapDate;

    /**
     * 验收时间
     */
    @TableField(value = "verify_operate_time")
    @NoComparedField
    private Date verifyOperateTime;


    /**
     * 已计提金额
     */
    @TableField(value = "dep_amount")
    @NoComparedField
    private Long depAmount;

    /**
     * 预计净残值率
     */
    @TableField(value = "surplus_value")
    @NoComparedField
    private Integer surplusValue;

    /**
     * 备注
     */
    @TableField(value = "remark")
    @NoComparedField
    private String remark;

    /**
     * 用途
     */
    @TableField(value = "purpose")
    private Integer purpose;

    /**
     * 验收人ID
     */
    @TableField(value = "verfy_by")
    @NoComparedField
    private Long verfyBy;

    /**
     * 审核状态 ：0=暂存 、1=待验收 、2=验收通过 、3=验收未通过
     */
    @TableField(value = "verfy_status")
    @NoComparedField
    private int verfyStatus;
    /**
     * 验收编号
     */
    @TableField(value = "verfy_num")
    @NoComparedField
    private String verfyNum;

    public Long getAssetsId() {
        return assetsId;
    }

    public void setAssetsId(Long assetsId) {
        this.assetsId = assetsId;
    }

    public String getAssetsNum() {
        return assetsNum;
    }

    public void setAssetsNum(String assetsNum) {
        this.assetsNum = assetsNum;
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

    public Integer getFreeTax() {
        return freeTax;
    }

    public void setFreeTax(Integer freeTax) {
        this.freeTax = freeTax;
    }

    public Integer getCommodityFlag() {
        return commodityFlag;
    }

    public void setCommodityFlag(Integer commodityFlag) {
        this.commodityFlag = commodityFlag;
    }

    public Integer getQualityFlag() {
        return qualityFlag;
    }

    public void setQualityFlag(Integer qualityFlag) {
        this.qualityFlag = qualityFlag;
    }

    public Integer getPmFlag() {
        return pmFlag;
    }

    public void setPmFlag(Integer pmFlag) {
        this.pmFlag = pmFlag;
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

    public Integer getDepType() {
        return depType;
    }

    public void setDepType(Integer depType) {
        this.depType = depType;
    }

    public Integer getDepStatus() {
        return depStatus;
    }

    public void setDepStatus(Integer depStatus) {
        this.depStatus = depStatus;
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

    public Long getRegId() {
        return regId;
    }

    public void setRegId(Long regId) {
        this.regId = regId;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public String getAssetsLocation() {
        return assetsLocation;
    }

    public void setAssetsLocation(String assetsLocation) {
        this.assetsLocation = assetsLocation;
    }

    public Integer getReceptionId() {
        return receptionId;
    }

    public void setReceptionId(Integer receptionId) {
        this.receptionId = receptionId;
    }

    public Date getReceptionDate() {
        return receptionDate;
    }

    public void setReceptionDate(Date receptionDate) {
        this.receptionDate = receptionDate;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public Integer getPurchaseTypeId() {
        return purchaseTypeId;
    }

    public void setPurchaseTypeId(Integer purchaseTypeId) {
        this.purchaseTypeId = purchaseTypeId;
    }

    public Long getLendFee() {
        return lendFee;
    }

    public void setLendFee(Long lendFee) {
        this.lendFee = lendFee;
    }

    public String getSasacNum() {
        return sasacNum;
    }

    public void setSasacNum(String sasacNum) {
        this.sasacNum = sasacNum;
    }

    public Integer getPollingFlag() {
        return pollingFlag;
    }

    public void setPollingFlag(Integer pollingFlag) {
        this.pollingFlag = pollingFlag;
    }

    public Integer getTryFlag() {
        return tryFlag;
    }

    public void setTryFlag(Integer tryFlag) {
        this.tryFlag = tryFlag;
    }

    public Integer getWarrantyFlag() {
        return warrantyFlag;
    }

    public void setWarrantyFlag(Integer warrantyFlag) {
        this.warrantyFlag = warrantyFlag;
    }

    public Integer getRepairFlag() {
        return repairFlag;
    }

    public void setRepairFlag(Integer repairFlag) {
        this.repairFlag = repairFlag;
    }

    public Integer getMeasureFlag() {
        return measureFlag;
    }

    public void setMeasureFlag(Integer measureFlag) {
        this.measureFlag = measureFlag;
    }

    public Integer getForceFlag() {
        return forceFlag;
    }

    public void setForceFlag(Integer forceFlag) {
        this.forceFlag = forceFlag;
    }

    public Integer getAmFlag() {
        return amFlag;
    }

    public void setAmFlag(Integer amFlag) {
        this.amFlag = amFlag;
    }

    public void setPresentFlag(Boolean presentFlag) {
        this.presentFlag = presentFlag;
    }

    public Integer getWarrantyId() {
        return warrantyId;
    }

    public void setWarrantyId(Integer warrantyId) {
        this.warrantyId = warrantyId;
    }

    public Date getStatutoryScrapDate() {
        return statutoryScrapDate;
    }

    public void setStatutoryScrapDate(Date statutoryScrapDate) {
        this.statutoryScrapDate = statutoryScrapDate;
    }

    public Date getScrapDate() {
        return scrapDate;
    }

    public void setScrapDate(Date scrapDate) {
        this.scrapDate = scrapDate;
    }

    public Long getDepAmount() {
        return depAmount;
    }

    public void setDepAmount(Long depAmount) {
        this.depAmount = depAmount;
    }

    public Integer getSurplusValue() {
        return surplusValue;
    }

    public void setSurplusValue(Integer surplusValue) {
        this.surplusValue = surplusValue;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getPurpose() {
        return purpose;
    }

    public void setPurpose(Integer purpose) {
        this.purpose = purpose;
    }

    public Long getVerfyBy() {
        return verfyBy;
    }

    public void setVerfyBy(Long verfyBy) {
        this.verfyBy = verfyBy;
    }

    public int getVerfyStatus() {
        return verfyStatus;
    }

    public void setVerfyStatus(int verfyStatus) {
        this.verfyStatus = verfyStatus;
    }

    public String getVerfyNum() {
        return verfyNum;
    }

    public void setVerfyNum(String verfyNum) {
        this.verfyNum = verfyNum;
    }

    public String getRegName() {
        return regName;
    }

    public void setRegName(String regName) {
        this.regName = regName;
    }

    public Date getVerifyOperateTime() {
        return verifyOperateTime;
    }

    public void setVerifyOperateTime(Date verifyOperateTime) {
        this.verifyOperateTime = verifyOperateTime;
    }

    public Integer getPurchaseWay() {
        return purchaseWay;
    }

    public void setPurchaseWay(Integer purchaseWay) {
        this.purchaseWay = purchaseWay;
    }

    public Integer getTenderForm() {
        return tenderForm;
    }

    public void setTenderForm(Integer tenderForm) {
        this.tenderForm = tenderForm;
    }

    public Long getSingleBudget() {
        return singleBudget;
    }

    public void setSingleBudget(Long singleBudget) {
        this.singleBudget = singleBudget;
    }

    public Date getWinTenderDate() {
        return winTenderDate;
    }

    public void setWinTenderDate(Date winTenderDate) {
        this.winTenderDate = winTenderDate;
    }

    public String getApproveProjectAccord() {
        return approveProjectAccord;
    }

    public void setApproveProjectAccord(String approveProjectAccord) {
        this.approveProjectAccord = approveProjectAccord;
    }

    public Boolean getPresentFlag() {
        return presentFlag;
    }

    public String getSingleBudgetStr() {
        return singleBudgetStr;
    }

    public void setSingleBudgetStr(String singleBudgetStr) {
        this.singleBudgetStr = singleBudgetStr;
    }

    public Integer getPmPlanFlag() {
        return pmPlanFlag;
    }

    public void setPmPlanFlag(Integer pmPlanFlag) {
        this.pmPlanFlag = pmPlanFlag;
    }

}
