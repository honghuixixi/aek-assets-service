package com.aek.ebey.assets.model;

import java.util.Date;
import java.util.List;


import com.aek.common.core.base.BaseModel;
import com.aek.ebey.assets.model.bo.AttachmentsBO;
import com.baomidou.mybatisplus.annotations.TableField;

import io.swagger.annotations.ApiModelProperty;

/**
 * 资产信息
 */
public class Assets extends BaseModel {
    private static final long serialVersionUID = 1L;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 修改人ID
     */
    private Long updateBy;

    /**
     * 修改人名称
     */
    private String updateByName;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 合同ID
     */
    @ApiModelProperty(value = "合同ID")
    private Long contractId;

    /**
     *
     */
    @TableField(value = "sys_id")
    private Integer contractSysId;

    /**
     *
     */
    @TableField(value = "area_id")
    private Integer contractAreaId;

    /**
     * 合同创建人ID
     */
    private Long contractCreateBy;

    /**
     * 合同类型ID
     */
    @TableField(value = "contract_type_id")
    private Integer contractTypeId;

    /**
     * 合同类型文字说明
     */
    @TableField(value = "contract_type_text")
    private String contractTypeText;

    /**
     * 内部合同编号
     */
    @TableField(value = "inner_contract_no")
    private String innerContractNo;

    /**
     * 合同编号
     */
    @TableField(value = "contract_no")
    private String contractNo;

    /**
     * 合同名称
     */
    @TableField(value = "contract_name")
    private String contractName;

    /**
     * 合同价格
     */
    @TableField(value = "contract_price")
    private Long contractPrice;

    /**
     * 合同价格
     */
    @TableField(exist = false)
    private String contractPriceStr;

    /**
     * 合同开始时间
     */
    @TableField(value = "start_date")
    private Date startDate;

    /**
     * 合同结束时间
     */
    @TableField(value = "end_date")
    private Date endDate;

    /**
     * 台账添加人ID
     */
    @TableField(value = "create_by")
    private Long createBy;

    /**
     * 台账创建人
     */
    private String createByName;

    /**
     * 图片文件id列表，以逗号隔开
     */
    @TableField(value = "file_list")
    private String fileList;

    /**
     * 供应商ID
     */
    @TableField(value = "supplier_id")
    private Long supplierId;

    /**
     * 供应商单位名称
     */
    @TableField(value = "supplier_name")
    private String supplierName;

    /**
     * 保修时长
     */
    @TableField(value = "maintain_duration")
    private Integer maintainDuration;

    /**
     * 延保时长
     */
    @TableField(value = "extend_maintain_duration")
    private Integer extendMaintainDuration;

    /**
     * 合同违约金
     */
    private Long forfeit;

    /**
     * 验收时间
     */
    @TableField(value = "acceptance_date")
    private Date cceptanceDate;

    /**
     * 乙方联系人
     */
    @TableField(value = "contract_contact_name")
    private String contractContactName;

    /**
     * 乙方联系电话
     */
    @TableField(value = "contract_contact_phone")
    private String contractContactPhone;

    /**
     * 档案编号
     */
    @TableField(value = "archives_code")
    private String archivesCode;

    /**
     * 档案管理员
     */
    @TableField(value = "archives_manager")
    private String archivesManager;

    /**
     * 合同内容
     */
    @TableField(value = "contract_content")
    private String contractContent;

    /**
     * 资产表ID
     */
    private Long sourcesId;

    /**
     * 资产ID
     */
    @TableField(value = "assets_id")
    private Long assetsId;

    /**
     * 经费来源ID
     */
    private Integer fundSourcesId;

    /**
     * 经费来源名称
     */
    private String fundSourcesName;

    /**
     * 经费比例
     */
    @TableField(value = "fund_percent")
    private String fundPercent;

    private String fundSourceMoneys;

    /**
     * 经费来源文字说明
     */
    @TableField(value = "fund_sources_text")
    private String fundSourcesText;

    /**
     * 资产ID
     */
    private Long id;

    /**
     * 系统ID
     */
    @TableField(value = "sys_id")
    private Integer sysId;

    /**
     * 区域ID
     */
    @TableField(value = "area_id")
    private Integer areaId;

    /**
     * 资产名称
     */
    @TableField(value = "assets_name")
    private String assetsName;

    /**
     * 设备编号
     */
    @TableField(value = "assets_num")
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
     * 更改状态：1在库、2在用、3预登、4待报损、5报损、6退货
     */
    private Integer status;

    /**
     * 状态名称
     */
    public String statusName;

    /**
     * 维修状态 1正常，2维修中
     */
    @TableField(value = "repair_status")
    private Integer repairStatus;

    /**
     * 维修状态名称
     */
    private String repairStatusName;

    /**
     * 审核状态
     */
    @TableField(value = "verfy_status")
    private Integer verfyStatus;

    /**
     * 审核状态名
     */
    private String verfyStatusName;

    /**
     * 单价
     */
    private Long price;

    /**
     * Double单价
     */
    @TableField(exist = false)
    private Double priceD;

    /**
     * 单价
     */
    private String priceStr;

    /**
     * 折旧年限
     */
    private String oldYear;


    /**
     * 折旧残值
     */
    private String lessPrice;

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
     * 账簿类型名称
     */
    private String assetsTypeName;

    /**
     * 核算类别ID
     */
    @TableField(value = "assets_class_id")
    private Integer assetsClassId;

    /**
     * 核算类别名称
     */
    private String assetsClassName;

    /**
     * 计数单位
     */
    @TableField(value = "unit_id")
    private Integer unitId;

    /**
     * 计数单位名称
     */
    private String unitName;

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
     * 仓库名称
     */
    private String whName;

    /**
     * 使用科室ID
     */
    @TableField(value = "dept_id")
    private Integer deptId;

    /**
     * 使用科室名称
     */
    private String deptName;

    /**
     * 申购科室ID
     */
    @TableField(value = "apply_dept_id")
    private Integer applyDeptId;

    /**
     * 购置类别
     * 2017/11/21
     */
    @TableField(value = "apply_type")
    private Integer applyType;

    /**
     * 申购日期
     * 2017/11/21
     */
    @TableField(value = "apply_date")
    private Date applyDate;

    /**
     * 论证日期
     * 2017/11/21
     */
    @TableField(value = "proof_date")
    private Date proofDate;

    /**
     * 预到日期
     * 2017/11/21
     */
    @TableField(value = "expect_date")
    private Date expectDate;

    /**
     * 申购理由
     * 2017/11/21
     */
    @TableField(value = "apply_reason")
    private String applyReason;

    /**
     * 申购科室名称
     */
    private String applyDeptName;

    /**
     * 采购方式:1=国际招标、2=政府采购、3=院内采购、4=分散采购、5=自行采购、6=其他
     * 2017/11/21
     */
    @TableField(value = "purchase_way")
    private Integer purchaseWay;

    /**
     * 招标形式:1=公开招标、2=邀请招标、3=竞争性谈判、4=单一来源采购、5=询价采购、6=其他
     * 2017/11/21
     */
    @TableField(value = "tender_form")
    private Integer tenderForm;

    /**
     * 单项预算
     * 2017/11/21
     */
    @TableField(value = "single_budget")
    private Long singleBudget;

    /**
     * 单项预算
     * 2017/11/21
     */
    private String singleBudgetStr;

    /**
     * 中标时间
     * 2017/11/21
     */
    @TableField(value = "win_tender_date")
    private Date winTenderDate;

    /**
     * 立项依据
     * 2017/11/21
     */
    @TableField(value = "approve_project_accord")
    private String approveProjectAccord;

    /**
     * 招标附件list
     * 2017/11/21
     */
    @TableField(exist = false)
    private List<AttachmentsBO> tenderAnnexList;

    /**
     * 验收附件list
     * 2017/11/21
     */
    @TableField(exist = false)
    private List<AttachmentsBO> acceptanceAnnexList;

    /**
     * 合同附件list
     * 2017/11/21
     */
    @TableField(exist = false)
    private List<AttachmentsBO> contractAnnexList;

    /**
     * 资产证件
     */
    @ApiModelProperty(value = "资产证件")
    private List<AssAssetsCertificate> listCertificate;

    /**
     * 科室ID
     */
    @TableField(value = "manage_dept_id")
    private Integer manageDeptId;

    /**
     * 管理科室名称
     */
    private String manageDeptName;

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
     * 验收人员
     * 2017/11/21
     */
    @TableField(value = "acceptance_person_name")
    private String acceptancePersonName;

    /**
     * 验收部门名称
     * 2017/11/21
     */
    @TableField(value = "acceptance_dept_name")
    private String acceptanceDeptName;

    /**
     * 台账图片
     */
    private String assetsImg;

    /**
     * 来源
     */
    public Integer assetsSource;

    /**
     * 来源名称
     */
    public String assetsSourceName;

    /**
     *
     */
    private Long extId;

    /**
     * 资产ID
     */
    @TableField(value = "assets_id")
    private Long extAssetsId;

    /**
     * 设备编号
     */
    @TableField(value = "assets_num")
    private String extAssetsNum;

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
     * 管理级别ID
     */
    @TableField(value = "manage_level")
    private Integer manageLevel;

    /**
     * 管理级别
     */
    private String manageLevelName;

    /**
     * 计量类别ID
     */
    @TableField(value = "measure_type")
    private Integer measureType;

    /**
     * 计量类别
     */
    private String measureTypeName;

    /**
     * 是否免税设备0否1是
     */
    @TableField(value = "free_tax")
    private Integer freeTax;

    /**
     * 商检标识1启用0不启用
     */
    @TableField(value = "commodity_flag")
    private Integer commodityFlag;

    /**
     * 质检标识1启用0不启用
     */
    @TableField(value = "quality_flag")
    private Integer qualityFlag;

    /**
     * 是否启用PM管理标识1启用0不启用
     */
    @TableField(value = "pm_flag")
    private Integer pmFlag;

    /**
     * 三级分类代码
     */
    @TableField(value = "three_level_code")
    private String threeLevelCode;

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
    private Integer depType;

    /**
     * 折旧方法名
     */
    private String depTypeName;

    /**
     * 0默认；1不需要再计算折旧计提
     */
    @TableField(value = "dep_status")
    private Integer depStatus;

    /**
     * 厂家ID
     */
    @TableField(value = "factory_id")
    private Integer factoryId;

    /**
     * 厂家名称
     */
    @TableField(value = "factory_name")
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
    private String assetsLocation;

    /**
     * 领用人ID
     */
    @TableField(value = "reception_id")
    private Integer receptionId;

    /**
     * 领用时间
     */
    @TableField(value = "reception_date")
    private Date receptionDate;

    /**
     * 采购时间
     */
    @TableField(value = "purchase_date")
    private Date purchaseDate;

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
     * 设备来源名称
     */
    private String purchaseTypeName;

    /**
     * 出借费用（分/天）
     */
    @TableField(value = "lend_fee")
    private Long lendFee;

    /**
     * 国资编号
     */
    @TableField(value = "sasac_num")
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
    private Integer tryFlag;

    /**
     * 保修标识1启用0不启用
     */
    @TableField(value = "warranty_flag")
    private Integer warrantyFlag;

    /**
     * 维修标识1启用0不启用
     */
    @TableField(value = "repair_flag")
    private Integer repairFlag;

    /**
     * 是否计量，1：是，0：否
     */
    @TableField(value = "measure_flag")
    private Integer measureFlag;

    /**
     * 是否强检，1：是，0：否
     */
    @TableField(value = "force_flag")
    private Integer forceFlag;

    /**
     * 是否启用保养， 0：不启用保养计划、1：启用保养计划
     */
    @TableField(value = "am_flag")
    private Integer amFlag;

    /**
     * 是否赠送，1：赠送，0：非赠送
     */
    @TableField(value = "present_flag")
    private Boolean presentFlag;

    /**
     * 保修厂商
     */
    @TableField(value = "warranty_id")
    private Integer warrantyId;

    /**
     * 法定报废日期
     */
    @TableField(value = "statutory_scrap_date")
    private Date statutoryScrapDate;

    /**
     * 报废时间
     */
    @TableField(value = "scrap_date")
    private Date extScrapDate;

    /**
     * 已计提金额
     */
    @TableField(value = "dep_amount")
    private Long depAmount;

    /**
     * 预计净残值率
     */
    @TableField(value = "surplus_value")
    private Integer surplusValue;

    /**
     * 备注
     */
    private String remark;

    /**
     * 用途ID
     */
    private Integer purpose;

    /**
     * 用途
     */
    private String purposeName;

    /**
     * 验收说明
     */
    private String verifyRemark;

    /**
     * 验收时间
     */
    private Date verifyDate;

    /**
     * 验收人Id
     */
    private Long verfyBy;

    /**
     * 验收人
     */
    private String verfyByName;

    /**
     * 验收编号
     */
    @TableField(value = "verfy_num")
    private String verfyNum;

    /*.........资产发票表...........>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
    /**
     *
     */
    private Long invoiceId;

    /**
     * 资产ID
     */
    @TableField(value = "assets_id")
    private Long invoiceAssetsId;

    /**
     * 台账下所有发票号
     */
    @ApiModelProperty(value = "台账下所有发票号")
    private String invoiceNos;

    /**
     * 发票号
     */
    @ApiModelProperty(value = "发票号")
    private String invoiceNo;

    /**
     * 发票金额
     */
    @ApiModelProperty(value = "发票金额")
    private Long invoiceMoney;

    /**
     * 发票日期
     */
    @ApiModelProperty(value = "发票日期")
    private Date invoiceDate;

    /**
     * 台账类型 1-台账，2-预台账
     */
    @ApiModelProperty(value = "台账类型 1-台账，2-预台账")
    private Integer assetsStatus;

    /**
     * 资产资金来源
     */
    @ApiModelProperty(value = "资产资金来源")
    private List<AssetsFundSources> listFundSources;

    /**
     * 发票号
     */
    @ApiModelProperty(value = "发票号")
    private List<AssetsInvoice> listInvoice;

    /**
     * 验收时间
     */
    @ApiModelProperty(value = "验收时间")
    private Date verifyOperateTime;

    /**
     * 是否国产/进口(1=国产,2=进口)
     */
    @ApiModelProperty(value = "是否国产/进口(1=国产,2=进口)")
    private Integer madeIn;

    /**
     * 风险程度分析
     */
    @ApiModelProperty(value = "风险程度分析")
    private String riskLevel;

    public List<AssetsInvoice> getListInvoice() {
        return listInvoice;
    }

    public void setListInvoice(List<AssetsInvoice> listInvoice) {
        this.listInvoice = listInvoice;
    }


    public Long getContractId() {
        return contractId;
    }

    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }

    public Integer getContractSysId() {
        return contractSysId;
    }

    public void setContractSysId(Integer contractSysId) {
        this.contractSysId = contractSysId;
    }

    public Integer getContractAreaId() {
        return contractAreaId;
    }

    public void setContractAreaId(Integer contractAreaId) {
        this.contractAreaId = contractAreaId;
    }

    public Integer getContractTypeId() {
        return contractTypeId;
    }

    public void setContractTypeId(Integer contractTypeId) {
        this.contractTypeId = contractTypeId;
    }

    public String getContractTypeText() {
        return contractTypeText;
    }

    public void setContractTypeText(String contractTypeText) {
        this.contractTypeText = contractTypeText;
    }

    public String getInnerContractNo() {
        return innerContractNo;
    }

    public void setInnerContractNo(String innerContractNo) {
        this.innerContractNo = innerContractNo;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public String getFileList() {
        return fileList;
    }

    public void setFileList(String fileList) {
        this.fileList = fileList;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public Integer getMaintainDuration() {
        return maintainDuration;
    }

    public void setMaintainDuration(Integer maintainDuration) {
        this.maintainDuration = maintainDuration;
    }

    public Integer getExtendMaintainDuration() {
        return extendMaintainDuration;
    }

    public void setExtendMaintainDuration(Integer extendMaintainDuration) {
        this.extendMaintainDuration = extendMaintainDuration;
    }

    public Long getForfeit() {
        return forfeit;
    }

    public void setForfeit(Long forfeit) {
        this.forfeit = forfeit;
    }

    public Date getCceptanceDate() {
        return cceptanceDate;
    }

    public void setCceptanceDate(Date cceptanceDate) {
        this.cceptanceDate = cceptanceDate;
    }

    public String getContractContactName() {
        return contractContactName;
    }

    public void setContractContactName(String contractContactName) {
        this.contractContactName = contractContactName;
    }

    public String getContractContactPhone() {
        return contractContactPhone;
    }

    public void setContractContactPhone(String contractContactPhone) {
        this.contractContactPhone = contractContactPhone;
    }

    public String getArchivesCode() {
        return archivesCode;
    }

    public void setArchivesCode(String archivesCode) {
        this.archivesCode = archivesCode;
    }

    public String getArchivesManager() {
        return archivesManager;
    }

    public void setArchivesManager(String archivesManager) {
        this.archivesManager = archivesManager;
    }

    public String getContractContent() {
        return contractContent;
    }

    public void setContractContent(String contractContent) {
        this.contractContent = contractContent;
    }

    public Long getSourcesId() {
        return sourcesId;
    }

    public void setSourcesId(Long sourcesId) {
        this.sourcesId = sourcesId;
    }

    public Long getAssetsId() {
        return assetsId;
    }

    public void setAssetsId(Long assetsId) {
        this.assetsId = assetsId;
    }

    public Integer getFundSourcesId() {
        return fundSourcesId;
    }

    public void setFundSourcesId(Integer fundSourcesId) {
        this.fundSourcesId = fundSourcesId;
    }

    public String getFundPercent() {
        return fundPercent;
    }

    public void setFundPercent(String fundPercent) {
        this.fundPercent = fundPercent;
    }

    public String getFundSourcesText() {
        return fundSourcesText;
    }

    public void setFundSourcesText(String fundSourcesText) {
        this.fundSourcesText = fundSourcesText;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSysId() {
        return sysId;
    }

    public void setSysId(Integer sysId) {
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


    public Long getContractPrice() {
        return contractPrice;
    }

    public void setContractPrice(Long contractPrice) {
        this.contractPrice = contractPrice;
    }

    public String getContractPriceStr() {
        return contractPriceStr;
    }

    public void setContractPriceStr(String contractPriceStr) {
        this.contractPriceStr = contractPriceStr;
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

    public Long getExtId() {
        return extId;
    }

    public void setExtId(Long extId) {
        this.extId = extId;
    }

    public Long getExtAssetsId() {
        return extAssetsId;
    }

    public void setExtAssetsId(Long extAssetsId) {
        this.extAssetsId = extAssetsId;
    }

    public String getExtAssetsNum() {
        return extAssetsNum;
    }

    public void setExtAssetsNum(String extAssetsNum) {
        this.extAssetsNum = extAssetsNum;
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

    public Boolean getPresentFlag() {
        return presentFlag;
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

    public Date getExtScrapDate() {
        return extScrapDate;
    }

    public void setExtScrapDate(Date extScrapDate) {
        this.extScrapDate = extScrapDate;
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

    public String getVerifyRemark() {
        return verifyRemark;
    }

    public void setVerifyRemark(String verifyRemark) {
        this.verifyRemark = verifyRemark;
    }

    public Date getVerifyDate() {
        return verifyDate;
    }

    public void setVerifyDate(Date verifyDate) {
        this.verifyDate = verifyDate;
    }

    public Long getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Long invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Long getInvoiceAssetsId() {
        return invoiceAssetsId;
    }

    public void setInvoiceAssetsId(Long invoiceAssetsId) {
        this.invoiceAssetsId = invoiceAssetsId;
    }

    public String getInvoiceNos() {
        return invoiceNos;
    }

    public void setInvoiceNos(String invoiceNos) {
        this.invoiceNos = invoiceNos;
    }

    public Long getInvoiceMoney() {
        return invoiceMoney;
    }

    public void setInvoiceMoney(Long invoiceMoney) {
        this.invoiceMoney = invoiceMoney;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public String getFundSourceMoneys() {
        return fundSourceMoneys;
    }

    public void setFundSourceMoneys(String fundSourceMoneys) {
        this.fundSourceMoneys = fundSourceMoneys;
    }

    public String getAssetsImg() {
        return assetsImg;
    }

    public void setAssetsImg(String assetsImg) {
        this.assetsImg = assetsImg;
    }

    public Long getVerfyBy() {
        return verfyBy;
    }

    public void setVerfyBy(Long verfyBy) {
        this.verfyBy = verfyBy;
    }

    public String getVerfyByName() {
        return verfyByName;
    }

    public void setVerfyByName(String verfyByName) {
        this.verfyByName = verfyByName;
    }

    public Integer getAssetsSource() {
        return assetsSource;
    }

    public void setAssetsSource(Integer assetsSource) {
        this.assetsSource = assetsSource;
    }

    public String getAssetsSourceName() {
        return assetsSourceName;
    }

    public void setAssetsSourceName(String assetsSourceName) {
        this.assetsSourceName = assetsSourceName;
    }

    public Integer getVerfyStatus() {
        return verfyStatus;
    }

    public void setVerfyStatus(Integer verfyStatus) {
        this.verfyStatus = verfyStatus;
    }

    public Long getContractCreateBy() {
        return contractCreateBy;
    }

    public void setContractCreateBy(Long contractCreateBy) {
        this.contractCreateBy = contractCreateBy;
    }

    public String getCreateByName() {
        return createByName;
    }

    public void setCreateByName(String createByName) {
        this.createByName = createByName;
    }

    public String getVerfyNum() {
        return verfyNum;
    }

    public void setVerfyNum(String verfyNum) {
        this.verfyNum = verfyNum;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public String getDepTypeName() {
        return depTypeName;
    }

    public void setDepTypeName(String depTypeName) {
        this.depTypeName = depTypeName;
    }

    public String getPurposeName() {
        return purposeName;
    }

    public void setPurposeName(String purposeName) {
        this.purposeName = purposeName;
    }

    public String getMeasureTypeName() {
        return measureTypeName;
    }

    public void setMeasureTypeName(String measureTypeName) {
        this.measureTypeName = measureTypeName;
    }

    public String getFundSourcesName() {
        return fundSourcesName;
    }

    public void setFundSourcesName(String fundSourcesName) {
        this.fundSourcesName = fundSourcesName;
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

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getWhName() {
        return whName;
    }

    public void setWhName(String whName) {
        this.whName = whName;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getApplyDeptName() {
        return applyDeptName;
    }

    public void setApplyDeptName(String applyDeptName) {
        this.applyDeptName = applyDeptName;
    }

    public String getManageDeptName() {
        return manageDeptName;
    }

    public void setManageDeptName(String manageDeptName) {
        this.manageDeptName = manageDeptName;
    }

    public String getPurchaseTypeName() {
        return purchaseTypeName;
    }

    public void setPurchaseTypeName(String purchaseTypeName) {
        this.purchaseTypeName = purchaseTypeName;
    }

    public String getManageLevelName() {
        return manageLevelName;
    }

    public void setManageLevelName(String manageLevelName) {
        this.manageLevelName = manageLevelName;
    }

    public String getVerfyStatusName() {
        return verfyStatusName;
    }

    public void setVerfyStatusName(String verfyStatusName) {
        this.verfyStatusName = verfyStatusName;
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

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getRegName() {
        return regName;
    }

    public void setRegName(String regName) {
        this.regName = regName;
    }

    public String getUpdateByName() {
        return updateByName;
    }

    public void setUpdateByName(String updateByName) {
        this.updateByName = updateByName;
    }

    public String getLessPrice() {
        return lessPrice;
    }

    public void setLessPrice(String lessPrice) {
        this.lessPrice = lessPrice;
    }

    public String getOldYear() {
        return oldYear;
    }

    public void setOldYear(String oldYear) {
        this.oldYear = oldYear;
    }

    public String getThreeLevelCode() {
        return threeLevelCode;
    }

    public void setThreeLevelCode(String threeLevelCode) {
        this.threeLevelCode = threeLevelCode;
    }

    public List<AssetsFundSources> getListFundSources() {
        return listFundSources;
    }

    public void setListFundSources(List<AssetsFundSources> listFundSources) {
        this.listFundSources = listFundSources;
    }

    public Date getVerifyOperateTime() {
        return verifyOperateTime;
    }

    public void setVerifyOperateTime(Date verifyOperateTime) {
        this.verifyOperateTime = verifyOperateTime;
    }

    public Integer getAssetsStatus() {
        return assetsStatus;
    }

    public void setAssetsStatus(Integer assetsStatus) {
        this.assetsStatus = assetsStatus;
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

    public String getRepairStatusName() {
        return repairStatusName;
    }

    public void setRepairStatusName(String repairStatusName) {
        this.repairStatusName = repairStatusName;
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

    public String getApplyReason() {
        return applyReason;
    }

    public void setApplyReason(String applyReason) {
        this.applyReason = applyReason;
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


    public List<AttachmentsBO> getTenderAnnexList() {
        return tenderAnnexList;
    }

    public void setTenderAnnexList(List<AttachmentsBO> tenderAnnexList) {
        this.tenderAnnexList = tenderAnnexList;
    }

    public List<AttachmentsBO> getAcceptanceAnnexList() {
        return acceptanceAnnexList;
    }

    public void setAcceptanceAnnexList(List<AttachmentsBO> acceptanceAnnexList) {
        this.acceptanceAnnexList = acceptanceAnnexList;
    }

    public List<AttachmentsBO> getContractAnnexList() {
        return contractAnnexList;
    }

    public void setContractAnnexList(List<AttachmentsBO> contractAnnexList) {
        this.contractAnnexList = contractAnnexList;
    }

    public List<AssAssetsCertificate> getListCertificate() {
        return listCertificate;
    }

    public void setListCertificate(List<AssAssetsCertificate> listCertificate) {
        this.listCertificate = listCertificate;
    }

    public Date getExpectDate() {
        return expectDate;
    }

    public void setExpectDate(Date expectDate) {
        this.expectDate = expectDate;
    }

    public String getSingleBudgetStr() {
        return singleBudgetStr;
    }

    public void setSingleBudgetStr(String singleBudgetStr) {
        this.singleBudgetStr = singleBudgetStr;
    }

    public Double getPriceD() {
        return priceD;
    }

    public void setPriceD(Double priceD) {
        this.priceD = priceD;
    }

    public String getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel;
    }
}
