package com.aek.ebey.assets.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.aek.common.core.base.BaseModel;
import com.aek.ebey.assets.core.util.NoComparedField;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 资产信息表
 * </p>
 *
 * @author aek
 * @since 2017-04-13
 */
@TableName("ass_assets_info")
public class AssetsInfo extends BaseModel {

    private static final long serialVersionUID = 1L;

    /**
     * 资产ID
     */
    @NoComparedField
    private Long id;

    /**
     * 系统ID
     */
    @TableField(value = "sys_id")
    @NoComparedField
    private Long sysId;

    /**
     * 区域ID
     */
    @TableField(value = "area_id")
    @NoComparedField
    private Integer areaId;

    /**
     * 资产名称
     */
    @TableField(value = "assets_name")
    @NoComparedField
    private String assetsName;

    /**
     * 设备编号
     */
    @TableField(value = "assets_num")
    @NoComparedField
    private String assetsNum;

    /**
     * 主设备ID
     */
    @TableField(value = "parent_id")
    private Long parentId;

    /**
     * 规格ID
     */
    @TableField(value = "spec_id")
    private Integer specId;

    /**
     * 设备规格型号
     */
    @TableField(value = "assets_spec")
    private String assetsSpec;

    /**
     * 分类ID
     */
    @TableField(value = "class_id")
    @NoComparedField
    private Integer classId;

    /**
     * 物资ID
     */
    @TableField(value = "goods_id")
    private Long goodsId;

    /**
     * 使用人ID
     */
    @TableField(value = "use_by")
    private Integer useBy;

    /**
     * 原来状态：1在库、2在用、3计量中、4维修中、5停用中、6已报废、7已报损
     * 更改状态：1=在库、2=在用、3=预登、4=待报损、5=报损、6=退货
     */
    @TableField(value = "status")
    private Integer status;

    /**
     * 维修状态： 1=正常，2=维修中
     */
    @TableField(value = "repair_status")
    @NoComparedField
    private Integer repairStatus;

    /**
     * 设备类型（1，台帐 2，预台帐）
     */
    @TableField(value = "assets_status")
    @NoComparedField
    @ApiModelProperty(value = "设备类型(1，台帐 2，预台帐)")
    private Integer assetsStatus;

    /**
     * 单价
     */
    @TableField(value = "price")
    private Long price;

    /**
     * 供货单位ID
     */
    @TableField(value = "spl_id")
    private Integer splId;

    /**
     * 供货单位名称
     */
    @TableField(value = "spl_name")
    private String splName;

    /**
     * 账簿类型ID
     */
    @TableField(value = "assets_type_id")
    private Integer assetsTypeId;

    /**
     * 核算类别ID
     */
    @TableField(value = "assets_class_id")
    private Integer assetsClassId;

    /**
     * 计数单位
     */
    @TableField(value = "unit_id")
    private Integer unitId;

    /**
     * 经费来源ID
     */
    @TableField(value = "fund_sources_id")
    @NoComparedField
    private Integer fundSourcesId;

    /**
     * 入库单号
     */
    @TableField(value = "putin_num")
    private String putinNum;

    /**
     * 仓库ID
     */
    @TableField(value = "wh_id")
    private Integer whId;

    /**
     * 使用科室ID
     */
    @TableField(value = "dept_id")
    private Integer deptId;

    @TableField(exist = false)
    private String deptName;

    /**
     * 申购科室ID
     */
    @TableField(value = "apply_dept_id")
    private Integer applyDeptId;

    /**
     * 购置类别:1=新增、2=添置、3=报废更新
     * 2017/11/21
     */
    @ApiModelProperty(value = "购置类别:1=新增、2=添置、3=报废更新")
    @TableField(value = "apply_type")
    private Integer applyType;
    /**
     * 申购日期
     * 2017/11/21
     */
    @ApiModelProperty(value = "申购日期")
    @TableField(value = "apply_date")
    private Date applyDate;
    /**
     * 论证日期
     * 2017/11/21
     */
    @ApiModelProperty(value = "论证日期")
    @TableField(value = "proof_date")
    private Date proofDate;
    /**
     * 预到日期
     * 2017/11/21
     */
    @ApiModelProperty(value = "预到日期")
    @TableField(value = "expect_date")
    private Date expectDate;
    /**
     * 申购理由
     * 2017/11/21
     */
    @ApiModelProperty(value = "申购理由")
    @TableField(value = "apply_reason")
    private String applyReason;
    /**
     * 验收人员
     * 2017/11/21
     */
    @ApiModelProperty(value = "验收人员")
    @TableField(value = "acceptance_person_name")
    private String acceptancePersonName;
    /**
     * 验收部门
     * 2017/11/21
     */
    @ApiModelProperty(value = "验收部门")
    @TableField(value = "acceptance_dept_name")
    private String acceptanceDeptName;

    /**
     * 管理科室ID
     */
    @TableField(value = "manage_dept_id")
    private Integer manageDeptId;

    /**
     * 入库时间
     */
    @TableField(value = "putin_date")
    private Date putinDate;

    /**
     * 报废时间
     */
    @TableField(value = "scrap_date")
    private Date scrapDate;

    /**
     * 验收时间
     */
    @TableField(value = "acceptance_date")
    private Date acceptanceDate;

    /**
     * 台账图片
     */
    @NoComparedField
    @TableField(value = "assets_img")
    private String assetsImg;

    /**
     * 来源，0：入库新增，1：批量导入，2：验收录入,3：清查录入
     */
    @TableField(value = "assets_source")
    @NoComparedField
    private Integer assetsSource;

    /**
     * 删除标记0=未删除，1=已删除
     */
    @TableField(value = "del_flag")
    @NoComparedField
    private Boolean delFlag;

    /**
     * 更新人ID
     */
    @TableField(value = "update_by")
    @NoComparedField
    private Long updateBy;

    /**
     * 更新时间
     */
    @TableField(value = "update_time")
    @NoComparedField
    private Date updateTime;

    /**
     * 创建人ID
     */
    @TableField(value = "create_by")
    @NoComparedField
    private Long createBy;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    @NoComparedField
    private Date createTime;

    /**
     * 三级分类代码
     */
    @TableField(value = "three_level_code")
    private String threeLevelCode;

    /**
     * 维修单ID
     */
    @TableField(value = "repair_id")
    @NoComparedField
    private Long repairId;

    /**
     * 是否国产(1=国产,2=进口)
     */
    @TableField(value = "made_in")
    private Integer madeIn;

    /**
     * 转科状态1=申请中、2=未申请
     */
    @TableField(value = "transfer_status")
    @NoComparedField
    private Integer transferStatus;

    /**
     * 风险程度分析
     */
    @TableField(value = "risk_level")
    private String riskLevel;

    /**
     * 单价
     */
    @TableField(exist = false)
    @NoComparedField
    private String priceStr;

    @TableField(exist = false)
    private List<AssetsFundSources> fundList = new ArrayList<>();

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Long getSysId() {
        return sysId;
    }

    public void setSysId(Long sysId) {
        this.sysId = sysId;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
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

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Integer getSpecId() {
        return specId;
    }

    public void setSpecId(Integer specId) {
        this.specId = specId;
    }

    public String getAssetsSpec() {
        return assetsSpec;
    }

    public void setAssetsSpec(String assetsSpec) {
        this.assetsSpec = assetsSpec;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getUseBy() {
        return useBy;
    }

    public void setUseBy(Integer useBy) {
        this.useBy = useBy;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getPriceStr() {
        return priceStr;
    }

    public void setPriceStr(String priceStr) {
        this.priceStr = priceStr;
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

    public Integer getAssetsTypeId() {
        return assetsTypeId;
    }

    public void setAssetsTypeId(Integer assetsTypeId) {
        this.assetsTypeId = assetsTypeId;
    }

    public Integer getAssetsClassId() {
        return assetsClassId;
    }

    public void setAssetsClassId(Integer assetsClassId) {
        this.assetsClassId = assetsClassId;
    }

    public Integer getUnitId() {
        return unitId;
    }

    public void setUnitId(Integer unitId) {
        this.unitId = unitId;
    }

    public String getPutinNum() {
        return putinNum;
    }

    public void setPutinNum(String putinNum) {
        this.putinNum = putinNum;
    }

    public Integer getWhId() {
        return whId;
    }

    public void setWhId(Integer whId) {
        this.whId = whId;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public Integer getApplyDeptId() {
        return applyDeptId;
    }

    public void setApplyDeptId(Integer applyDeptId) {
        this.applyDeptId = applyDeptId;
    }

    public Integer getManageDeptId() {
        return manageDeptId;
    }

    public void setManageDeptId(Integer manageDeptId) {
        this.manageDeptId = manageDeptId;
    }

    public Date getPutinDate() {
        return putinDate;
    }

    public void setPutinDate(Date putinDate) {
        this.putinDate = putinDate;
    }

    public Date getScrapDate() {
        return scrapDate;
    }

    public void setScrapDate(Date scrapDate) {
        this.scrapDate = scrapDate;
    }

    public Date getAcceptanceDate() {
        return acceptanceDate;
    }

    public void setAcceptanceDate(Date acceptanceDate) {
        this.acceptanceDate = acceptanceDate;
    }

    public String getAssetsImg() {
        return assetsImg;
    }

    public void setAssetsImg(String assetsImg) {
        this.assetsImg = assetsImg;
    }

    public Integer getAssetsSource() {
        return assetsSource;
    }

    public void setAssetsSource(Integer assetsSource) {
        this.assetsSource = assetsSource;
    }

    public Boolean getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Boolean delFlag) {
        this.delFlag = delFlag;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
    }

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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

    public Long getRepairId() {
        return repairId;
    }

    public void setRepairId(Long repairId) {
        this.repairId = repairId;
    }

    public Integer getAssetsStatus() {
        return assetsStatus;
    }

    public void setAssetsStatus(Integer assetsStatus) {
        this.assetsStatus = assetsStatus;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public List<AssetsFundSources> getFundList() {
        return fundList;
    }

    public void setFundList(List<AssetsFundSources> fundList) {
        this.fundList = fundList;
    }

    public Integer getMadeIn() {
        return madeIn;
    }

    public void setMadeIn(Integer madeIn) {
        this.madeIn = madeIn;
    }

    public Integer getRepairStatus() {
        return repairStatus;
    }

    public void setRepairStatus(Integer repairStatus) {
        this.repairStatus = repairStatus;
    }

    public Integer getApplyType() {
        return applyType;
    }

    public void setApplyType(Integer applyType) {
        this.applyType = applyType;
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    public Date getProofDate() {
        return proofDate;
    }

    public void setProofDate(Date proofDate) {
        this.proofDate = proofDate;
    }

    public Date getExpectDate() {
        return expectDate;
    }

    public void setExpectDate(Date expectDate) {
        this.expectDate = expectDate;
    }

    public String getApplyReason() {
        return applyReason;
    }

    public void setApplyReason(String applyReason) {
        this.applyReason = applyReason;
    }

    public String getAcceptancePersonName() {
        return acceptancePersonName;
    }

    public void setAcceptancePersonName(String acceptancePersonName) {
        this.acceptancePersonName = acceptancePersonName;
    }

    public String getAcceptanceDeptName() {
        return acceptanceDeptName;
    }

    public void setAcceptanceDeptName(String acceptanceDeptName) {
        this.acceptanceDeptName = acceptanceDeptName;
    }

    public Integer getTransferStatus() {
        return transferStatus;
    }

    public void setTransferStatus(Integer transferStatus) {
        this.transferStatus = transferStatus;
    }

    public String getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel;
    }
}
