package com.aek.ebey.assets.model.request;

import java.util.Date;
import java.util.List;

import com.aek.ebey.assets.model.AssetsFundSources;
import com.aek.ebey.assets.model.AssetsInvoice;
import com.aek.ebey.assets.model.bo.AttachmentsBO;
import com.baomidou.mybatisplus.annotations.TableField;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class EditAssetsInfoRequest {

    /**
     * 编辑的标签类别（1=设备信息，2=采购信息，3=合同信息，4=证件管理）
     */
    @ApiModelProperty(value = "编辑的标签类别（1=设备信息，2=采购信息，3=合同信息，4=证件管理）")
    private Integer moduleType;

    /**
     * 台帐id
     */
    @ApiModelProperty(value = "台账id")
    private Long assetsId;
    /**
     * 台帐名称
     */
    @ApiModelProperty(value = "台帐名称")
    private String assetsName;
    private Double priceD;
    /**
     * 厂家名称
     */
    @ApiModelProperty(value = "厂家名称")
    private String factoryName;
    /**
     * 台帐编码
     */
    @ApiModelProperty(value = "台帐编码")
    private String assetsNum;
    /**
     * 台帐来源
     */
    @ApiModelProperty(value = "台帐来源")
    private Integer assetsSource;
    /**
     * 设备类型
     */
    @ApiModelProperty(value = "设备类型")
    private Integer assetsStatus;

    /**
     * 旧发票号
     */
    @ApiModelProperty(value = "旧发票号")
    private String invoiceNo;

    /**
     * 新发票号
     */
    @ApiModelProperty(value = "新发票号")
    private String invoiceNos;

    /*************************************设备信息*******************************************/
    /**
     * 院内编码
     */
    @ApiModelProperty(value = "院内编码")
    private String serialNum;
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
     * 三级分类代码
     */
    @ApiModelProperty(value = "三级分类代码")
    private String threeLevelCode;

    /**
     * 设备品牌
     */
    @ApiModelProperty(value = "设备品牌")
    private String assetsBrand;

    /**
     * 产地
     */
    @ApiModelProperty(value = "产地")
    private String prodPlace;
    /**
     * 注册证名称
     */
    @ApiModelProperty(value = "注册证名称")
    private String regName;
    /**
     * 计数单位
     */
    @ApiModelProperty(value = "计数单位")
    private Integer unitId;
    /**
     * 账簿类型ID
     */
    @ApiModelProperty(value = "账簿类型ID")
    private Integer assetsTypeId;
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
     * 计量类别
     */
    @ApiModelProperty(value = "计量类别")
    private Integer measureType;
    /**
     * 计量设备
     */
    @ApiModelProperty(value = "计量设备(0=非计量设备，1=计量设备)")
    private Integer measureFlag;
    /**
     * 设备来源ID
     */
    @ApiModelProperty(value = "设备来源ID")
    private Integer purchaseTypeId;
    /**
     * 是否国产（1，国产 2，进口）
     */
    @ApiModelProperty(value = "是否国产（1，国产 2，进口）")
    private Integer madeIn;
    /**
     * 采购时间
     */
    @ApiModelProperty(value = "采购时间")
    private Date purchaseDate;
    /**
     * 使用科室ID
     */
    @ApiModelProperty(value = "使用科室ID")
    private Integer deptId;
    /**
     * 管理科室ID
     */
    @ApiModelProperty(value = "管理科室ID")
    private Integer manageDeptId;
    /**
     * 启用日期
     */
    @ApiModelProperty(value = "启用日期")
    private Date startUseDate;
    /**
     * 保修日期
     */
    @ApiModelProperty(value = "保修日期")
    private Date warrantyDate;
    /**
     * 用途
     */
    @ApiModelProperty(value = "用途")
    private Integer purpose;
    /**
     * 单价（日志不捕捉）
     */
    private Long price;

    /**
     * 风险程度分析
     */
    @ApiModelProperty(value = "风险程度分析")
    private String riskLevel;

    /****************************设备信息end***************************************/


    /*****************************采购信息********************************************/
    /**
     * 购置类别:1=新增、2=添置、3=报废更新
     * 2017/11/21
     */
    @ApiModelProperty(value = "购置类别:1=新增、2=添置、3=报废更新")
    private Integer applyType;
    /**
     * 申购日期
     * 2017/11/21
     */
    @ApiModelProperty(value = "申购日期")
    private Date applyDate;
    /**
     * 申购科室ID
     */
    @ApiModelProperty(value = "申购科室ID")
    private Integer applyDeptId;
    /**
     * 论证日期
     * 2017/11/21
     */
    @ApiModelProperty(value = "论证日期")
    private Date proofDate;
    /**
     * 经费来源ID
     */
    @ApiModelProperty(value = "经费来源ID")
    private Integer fundSourcesId;

    /**
     * 预到日期
     * 2017/11/21
     */
    @ApiModelProperty(value = "预到日期")
    private Date expectDate;
    /**********用于日志管理**********/
    /**
     * 资金来源
     */
    @ApiModelProperty(value = "资金来源")
    private String fundSourceMoneys;
    /**
     * 资金来源名称
     */
    @ApiModelProperty(value = "资金来源名称")
    private String fundSourcesName;
    /**********end**********/
    /**
     * 申购理由
     * 2017/11/21
     */
    @ApiModelProperty(value = "申购理由")
    private String applyReason;
    /**
     * 采购方式:1=国际招标、2=政府采购、3=院内采购、4=分散采购、5=自行采购、6=其他
     * 2017/11/21
     */
    @ApiModelProperty(value = "采购方式:1=国际招标、2=政府采购、3=院内采购、4=分散采购、5=自行采购、6=其他")
    private Integer purchaseWay;
    /**
     * 招标形式:1=公开招标、2=邀请招标、3=竞争性谈判、4=单一来源采购、5=询价采购、6=其他
     * 2017/11/21
     */
    @ApiModelProperty(value = "招标形式:1=公开招标、2=邀请招标、3=竞争性谈判、4=单一来源采购、5=询价采购、6=其他")
    private Integer tenderForm;
    /**
     * 单项预算
     * 2017/11/21
     */
    @ApiModelProperty(value = "单项预算")
    private Long singleBudget;
    /**
     * 中标时间
     * 2017/11/21
     */
    @ApiModelProperty(value = "中标时间")
    private Date winTenderDate;
    /**
     * 立项依据
     * 2017/11/21
     */
    @ApiModelProperty(value = "立项依据")
    private String approveProjectAccord;
    /**
     * 验收人员
     * 2017/11/21
     */
    @ApiModelProperty(value = "验收人员")
    private String acceptancePersonName;
    /**
     * 验收部门
     * 2017/11/21
     */
    @ApiModelProperty(value = "验收部门")
    private String acceptanceDeptName;
    /**
     * 验收日期
     * 2017/11/21
     */
    @ApiModelProperty(value = "验收日期")
    private Date acceptanceDate;
    /**
     * 到货时间
     */
    @ApiModelProperty(value = "到货时间")
    private Date arrivalDate;
    /*****************************采购信息end********************************************/

    /*****************************合同信息********************************************/
    /**
     * 合同编号
     */
    @ApiModelProperty(value = "合同编号")
    private String contractNo;
    /**
     * 合同名称
     */
    @ApiModelProperty(value = "合同名称")
    private String contractName;
    /**
     * 供货单位名称
     */
    @ApiModelProperty(value = "供货单位名称")
    private String splName;
    /**
     * 签订日期
     */
    @ApiModelProperty(value = "签订日期")
    private Date startDate;
    /**
     * 合同价格
     */
    @ApiModelProperty(value = "合同价格")
    private Long contractPrice;
    /**
     * 单价
     */
    @ApiModelProperty(value = "单价")
    private String priceStr;
    /**
     * 合同截至日期
     * 2017/11/21
     */
    @ApiModelProperty(value = "合同截至日期")
    private Date endDate;
    /**
     * 发票号
     */
    @ApiModelProperty(value = "发票号")
    private List<AssetsInvoice> listInvoice;
    /**
     * 乙方联系人
     * 2017/11/21
     */
    @ApiModelProperty(value = "乙方联系人")
    private String contractContactName;
    /**
     * 乙方联系电话
     * 2017/11/21
     */
    @ApiModelProperty(value = "乙方联系电话")
    private String contractContactPhone;
    /**
     * 档案管理员
     * 2017/11/21
     */
    @ApiModelProperty(value = "档案管理员")
    private String archivesManager;
    /**
     * 档案编号
     */
    @ApiModelProperty(value = "档案编号")
    private String archivesCode;
    /**
     * 合同内容
     * 2017/11/21
     */
    @ApiModelProperty(value = "合同内容")
    private String contractContent;
    /*********************************合同信息end********************************************/


    /**
     * 原来状态：1在库、2在用、3计量中、4维修中、5停用中、6已报废、7已报损
     * 更改状态：1=在库、2=在用、3=预登、4=待报损、5=报损、6=退货
     */
    @ApiModelProperty(value = "状态：1=在库、2=在用、3=预登、4=待报损、5=报损、6=退货")
    private Integer status;
    /**
     * 巡检标识1启用0不启用
     * 2018.1.15
     */
    @TableField(value = "polling_flag")
    private Integer pollingFlag;
    /**
     * 单项预算
     * 2017/11/21
     */
    @ApiModelProperty(value = "单项预算")
    private String singleBudgetStr;

    /**
     * 折旧年限
     */
    @ApiModelProperty(value = "折旧年限")
    private String assetsClassVal;


    /**
     * 折旧残值
     */
    //private String leavePrice;

    /**
     * 资产资金来源
     */
    @ApiModelProperty(value = "资产资金来源")
    private List<AssetsFundSources> listFundSources;


    /**
     * 供应商单位名称
     */
    @ApiModelProperty(value = "供应商单位名称")
    private String supplierName;

    /**
     * 合同ID
     */
    @ApiModelProperty(value = "合同ID")
    private Long contractId;

    /**
     * 台账图片
     */
    @ApiModelProperty(value = "台账图片")
    private String assetsImg;

    /**
     * 合同价格
     */
    private String contractPriceStr;

    /**
     * 接收招标附件集合
     * 2017/11/21
     */
    @ApiModelProperty(value = "接收招标附件集合")
    private List<AttachmentsBO> tenderAnnexList;
    /**
     * 接收验收附件集合
     * 2017/11/21
     */
    @ApiModelProperty(value = "接收验收附件集合")
    private List<AttachmentsBO> acceptanceAnnexList;
    /**
     * 接收合同附件集合
     * 2017/11/21
     */
    @ApiModelProperty(value = "接收合同附件集合")
    private List<AttachmentsBO> contractAnnexList;

    public Integer getModuleType() {
        return moduleType;
    }

    public void setModuleType(Integer moduleType) {
        this.moduleType = moduleType;
    }

    public Long getAssetsId() {
        return assetsId;
    }

    public void setAssetsId(Long assetsId) {
        this.assetsId = assetsId;
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

    public Integer getUnitId() {
        return unitId;
    }

    public void setUnitId(Integer unitId) {
        this.unitId = unitId;
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

    public Integer getApplyDeptId() {
        return applyDeptId;
    }

    public void setApplyDeptId(Integer applyDeptId) {
        this.applyDeptId = applyDeptId;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public Integer getManageDeptId() {
        return manageDeptId;
    }

    public void setManageDeptId(Integer manageDeptId) {
        this.manageDeptId = manageDeptId;
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

    public Integer getPurpose() {
        return purpose;
    }

    public void setPurpose(Integer purpose) {
        this.purpose = purpose;
    }

    public String getAssetsClassVal() {
        return assetsClassVal;
    }

    public void setAssetsClassVal(String assetsClassVal) {
        this.assetsClassVal = assetsClassVal;
    }

/*	public String getLeavePrice() {
		return leavePrice;
	}

	public void setLeavePrice(String leavePrice) {
		this.leavePrice = leavePrice;
	}
*/

    public String getAssetsImg() {
        return assetsImg;
    }

    public void setAssetsImg(String assetsImg) {
        this.assetsImg = assetsImg;
    }

    public Integer getPurchaseTypeId() {
        return purchaseTypeId;
    }

    public void setPurchaseTypeId(Integer purchaseTypeId) {
        this.purchaseTypeId = purchaseTypeId;
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

    public Integer getFundSourcesId() {
        return fundSourcesId;
    }

    public void setFundSourcesId(Integer fundSourcesId) {
        this.fundSourcesId = fundSourcesId;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public List<AssetsFundSources> getListFundSources() {
        return listFundSources;
    }

    public void setListFundSources(List<AssetsFundSources> listFundSources) {
        this.listFundSources = listFundSources;
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

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Long getContractPrice() {
        return contractPrice;
    }

    public void setContractPrice(Long contractPrice) {
        this.contractPrice = contractPrice;
    }

    public String getArchivesCode() {
        return archivesCode;
    }

    public void setArchivesCode(String archivesCode) {
        this.archivesCode = archivesCode;
    }

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

    public String getContractPriceStr() {
        return contractPriceStr;
    }

    public void setContractPriceStr(String contractPriceStr) {
        this.contractPriceStr = contractPriceStr;
    }

    public Integer getMadeIn() {
        return madeIn;
    }

    public void setMadeIn(Integer madeIn) {
        this.madeIn = madeIn;
    }

    public String getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(String serialNum) {
        this.serialNum = serialNum;
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

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
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

    public String getSingleBudgetStr() {
        return singleBudgetStr;
    }

    public void setSingleBudgetStr(String singleBudgetStr) {
        this.singleBudgetStr = singleBudgetStr;
    }

    public Date getAcceptanceDate() {
        return acceptanceDate;
    }

    public void setAcceptanceDate(Date acceptanceDate) {
        this.acceptanceDate = acceptanceDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getPollingFlag() {
        return pollingFlag;
    }

    public void setPollingFlag(Integer pollingFlag) {
        this.pollingFlag = pollingFlag;
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

    public Integer getAssetsSource() {
        return assetsSource;
    }

    public void setAssetsSource(Integer assetsSource) {
        this.assetsSource = assetsSource;
    }

    public Integer getAssetsStatus() {
        return assetsStatus;
    }

    public void setAssetsStatus(Integer assetsStatus) {
        this.assetsStatus = assetsStatus;
    }

    public String getFactoryName() {
        return factoryName;
    }

    public void setFactoryName(String factoryName) {
        this.factoryName = factoryName;
    }

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public String getInvoiceNos() {
        return invoiceNos;
    }

    public void setInvoiceNos(String invoiceNos) {
        this.invoiceNos = invoiceNos;
    }

    public String getFundSourceMoneys() {
        return fundSourceMoneys;
    }

    public void setFundSourceMoneys(String fundSourceMoneys) {
        this.fundSourceMoneys = fundSourceMoneys;
    }

    public String getFundSourcesName() {
        return fundSourcesName;
    }

    public void setFundSourcesName(String fundSourcesName) {
        this.fundSourcesName = fundSourcesName;

    }

    public Integer getMeasureFlag() {
        return measureFlag;
    }

    public void setMeasureFlag(Integer measureFlag) {
        this.measureFlag = measureFlag;
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
