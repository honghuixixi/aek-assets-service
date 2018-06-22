package com.aek.ebey.assets.web.request;

import java.sql.Date;

import org.hibernate.validator.constraints.NotEmpty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 预台账请求实体
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  Shuangwf
 * @version  1.0, 2017年4月14日
 */
@ApiModel(value = "AssetsInfoEdit", description = "预台账编辑信息")
public class AssetsInfoEditRequest
{
    
    @ApiModelProperty(value = "台账图片")
    @NotEmpty
    private String assetsImg;
    
    @ApiModelProperty(value = "验收人ID")
    @NotEmpty
    private Long verfyBy;
    
    @ApiModelProperty(value = "台账id")
    @NotEmpty
    private Long assetsId;
    
    @ApiModelProperty(value = "设备规格")
    @NotEmpty
    private String assetsSpec;
    
    @ApiModelProperty(value = "品牌")
    @NotEmpty
    private String assetsBrand;
    
    @ApiModelProperty(value = "注册证号")
    @NotEmpty
    private String regNo;
    
    @ApiModelProperty(value = "院内编码")
    @NotEmpty
    private String serialNum;
    
    @ApiModelProperty(value = "管理级别")
    @NotEmpty
    private int manageLevel;
    
    @ApiModelProperty(value = "是否免税")
    @NotEmpty
    private int freeTax;
    
    @ApiModelProperty(value = "PM标志")
    @NotEmpty
    private int pmFlag;
    
    @ApiModelProperty(value = "产地")
    @NotEmpty
    private String prodPlace;
    
    @ApiModelProperty(value = "单位(计数单位)") //表pm_assets_info
    @NotEmpty
    private Integer unitId;
    
    @ApiModelProperty(value = "出厂编号")
    @NotEmpty
    private String factoryNum;
    
    @ApiModelProperty(value = "核算类别ID") //表pm_assets_info
    @NotEmpty
    private Integer assetsClassId;
    
    @ApiModelProperty(value = "计量类别")
    @NotEmpty
    private int measureType;
    
    @ApiModelProperty(value = "商检设备")
    @NotEmpty
    private int commodityFlag;
    
    @ApiModelProperty(value = "质检设备")
    @NotEmpty
    private int qualityFlag;
    
    /*使用信息*/
    @ApiModelProperty(value = "申购科室")
    @NotEmpty
    private Integer applyDeptId;
    
    @ApiModelProperty(value = "使用科室")
    @NotEmpty
    private Integer deptId;
    
    @ApiModelProperty(value = "管理科室")
    @NotEmpty
    private Integer manageDeptId;
    
    @ApiModelProperty(value = "仓库类型")
    @NotEmpty
    private Integer whId;
    
    @ApiModelProperty(value = "启用日期")
    @NotEmpty
    private Date startUseDate;
    
    @ApiModelProperty(value = "用途")
    @NotEmpty
    private String purpose;
    
    @ApiModelProperty(value = "保修日期")
    @NotEmpty
    private Date warrantyDate;
    
    @ApiModelProperty(value = "折旧方法")
    @NotEmpty
    private int depType;
    
    /*采购基本信息*/
    @ApiModelProperty(value = "设备来源")
    @NotEmpty
    private Integer purchaseTypeId;
    
    @ApiModelProperty(value = "购入日期")
    @NotEmpty
    private Date purchaseDate;
    
    @ApiModelProperty(value = "供应商")
    @NotEmpty
    private String splName;
    
    @ApiModelProperty(value = "设备单价")
    @NotEmpty
    private String price;
    
    @ApiModelProperty(value = "经费来源")
    @NotEmpty
    private Integer fundSourcesId;
    
    @ApiModelProperty(value = "经费来源经费")
    @NotEmpty
    private String fundSourceMoneys;
    
    @ApiModelProperty(value = "到货时间")
    @NotEmpty
    private Date arrivalDate;
    
    /*合同信息*/
    @ApiModelProperty(value = "合同编号")
    @NotEmpty
    private String contractNo;
    
    @ApiModelProperty(value = "合同名称")
    @NotEmpty
    private String contractName;
    
    @ApiModelProperty(value = "供应商名称")
    @NotEmpty
    private String supplierName;
    
    @ApiModelProperty(value = "签订日期")
    @NotEmpty
    private Date startDate;
    
    @ApiModelProperty(value = "合同金额") //合同价格
    @NotEmpty
    private String contractPrice;
    
    @ApiModelProperty(value = "合同截止日期")
    @NotEmpty
    private Date endDate;
    
    @ApiModelProperty(value = "乙方联系人")
    @NotEmpty
    private String contractContactName;
    
    @ApiModelProperty(value = "乙方联系电话")
    @NotEmpty
    private String contractContactPhone;
    
    @ApiModelProperty(value = "档案编号")
    @NotEmpty
    private String archivesCode;
    
    @ApiModelProperty(value = "档案管理员")
    @NotEmpty
    private String archivesManager;
    
    @ApiModelProperty(value = "合同内容")
    @NotEmpty
    private String contractContent;
    
    /*发票信息*/
    @ApiModelProperty(value = "发票号 多个逗号分隔")
    @NotEmpty
    private String invoiceNos;
    
    public Long getAssetsId()
    {
        return assetsId;
    }
    
    public void setAssetsId(Long assetsId)
    {
        this.assetsId = assetsId;
    }
    
    public String getAssetsSpec()
    {
        return assetsSpec;
    }
    
    public void setAssetsSpec(String assetsSpec)
    {
        this.assetsSpec = assetsSpec;
    }
    
    public String getAssetsBrand()
    {
        return assetsBrand;
    }
    
    public void setAssetsBrand(String assetsBrand)
    {
        this.assetsBrand = assetsBrand;
    }
    
    public String getRegNo()
    {
        return regNo;
    }
    
    public void setRegNo(String regNo)
    {
        this.regNo = regNo;
    }
    
    public String getSerialNum()
    {
        return serialNum;
    }
    
    public void setSerialNum(String serialNum)
    {
        this.serialNum = serialNum;
    }
    
    public int getManageLevel()
    {
        return manageLevel;
    }
    
    public void setManageLevel(int manageLevel)
    {
        this.manageLevel = manageLevel;
    }
    
    public int getFreeTax()
    {
        return freeTax;
    }
    
    public void setFreeTax(int freeTax)
    {
        this.freeTax = freeTax;
    }
    
    public int getPmFlag()
    {
        return pmFlag;
    }
    
    public void setPmFlag(int pmFlag)
    {
        this.pmFlag = pmFlag;
    }
    
    public String getProdPlace()
    {
        return prodPlace;
    }
    
    public void setProdPlace(String prodPlace)
    {
        this.prodPlace = prodPlace;
    }
    
    public Integer getUnitId()
    {
        return unitId;
    }
    
    public void setUnitId(Integer unitId)
    {
        this.unitId = unitId;
    }
    
    public String getFactoryNum()
    {
        return factoryNum;
    }
    
    public void setFactoryNum(String factoryNum)
    {
        this.factoryNum = factoryNum;
    }
    
    public Integer getAssetsClassId()
    {
        return assetsClassId;
    }
    
    public void setAssetsClassId(Integer assetsClassId)
    {
        this.assetsClassId = assetsClassId;
    }
    
    public int getMeasureType()
    {
        return measureType;
    }
    
    public void setMeasureType(int measureType)
    {
        this.measureType = measureType;
    }
    
    public int getCommodityFlag()
    {
        return commodityFlag;
    }
    
    public void setCommodityFlag(int commodityFlag)
    {
        this.commodityFlag = commodityFlag;
    }
    
    public int getQualityFlag()
    {
        return qualityFlag;
    }
    
    public void setQualityFlag(int qualityFlag)
    {
        this.qualityFlag = qualityFlag;
    }
    
    public Integer getApplyDeptId()
    {
        return applyDeptId;
    }
    
    public void setApplyDeptId(Integer applyDeptId)
    {
        this.applyDeptId = applyDeptId;
    }
    
    public Integer getDeptId()
    {
        return deptId;
    }
    
    public void setDeptId(Integer deptId)
    {
        this.deptId = deptId;
    }
    
    public Integer getManageDeptId()
    {
        return manageDeptId;
    }
    
    public void setManageDeptId(Integer manageDeptId)
    {
        this.manageDeptId = manageDeptId;
    }
    
    public Integer getWhId()
    {
        return whId;
    }
    
    public void setWhId(Integer whId)
    {
        this.whId = whId;
    }
    
    public Date getStartUseDate()
    {
        return startUseDate;
    }
    
    public void setStartUseDate(Date startUseDate)
    {
        this.startUseDate = startUseDate;
    }
    
    public String getPurpose()
    {
        return purpose;
    }
    
    public void setPurpose(String purpose)
    {
        this.purpose = purpose;
    }
    
    public Date getWarrantyDate()
    {
        return warrantyDate;
    }
    
    public void setWarrantyDate(Date warrantyDate)
    {
        this.warrantyDate = warrantyDate;
    }
    
    public int getDepType()
    {
        return depType;
    }
    
    public void setDepType(int depType)
    {
        this.depType = depType;
    }
    
    public Integer getPurchaseTypeId()
    {
        return purchaseTypeId;
    }
    
    public void setPurchaseTypeId(Integer purchaseTypeId)
    {
        this.purchaseTypeId = purchaseTypeId;
    }
    
    public Date getPurchaseDate()
    {
        return purchaseDate;
    }
    
    public void setPurchaseDate(Date purchaseDate)
    {
        this.purchaseDate = purchaseDate;
    }
    
    public String getSplName()
    {
        return splName;
    }
    
    public void setSplName(String splName)
    {
        this.splName = splName;
    }
    
    public Date getArrivalDate()
    {
        return arrivalDate;
    }
    
    public void setArrivalDate(Date arrivalDate)
    {
        this.arrivalDate = arrivalDate;
    }
    
    public String getContractNo()
    {
        return contractNo;
    }
    
    public void setContractNo(String contractNo)
    {
        this.contractNo = contractNo;
    }
    
    public String getContractName()
    {
        return contractName;
    }
    
    public void setContractName(String contractName)
    {
        this.contractName = contractName;
    }
    
    public String getSupplierName()
    {
        return supplierName;
    }
    
    public void setSupplierName(String supplierName)
    {
        this.supplierName = supplierName;
    }
    
    public Date getStartDate()
    {
        return startDate;
    }
    
    public void setStartDate(Date startDate)
    {
        this.startDate = startDate;
    }
    
    public Date getEndDate()
    {
        return endDate;
    }
    
    public void setEndDate(Date endDate)
    {
        this.endDate = endDate;
    }
    
    public String getContractContactName()
    {
        return contractContactName;
    }
    
    public void setContractContactName(String contractContactName)
    {
        this.contractContactName = contractContactName;
    }
    
    public String getContractContactPhone()
    {
        return contractContactPhone;
    }
    
    public void setContractContactPhone(String contractContactPhone)
    {
        this.contractContactPhone = contractContactPhone;
    }
    
    public String getArchivesCode()
    {
        return archivesCode;
    }
    
    public void setArchivesCode(String archivesCode)
    {
        this.archivesCode = archivesCode;
    }
    
    public String getArchivesManager()
    {
        return archivesManager;
    }
    
    public void setArchivesManager(String archivesManager)
    {
        this.archivesManager = archivesManager;
    }
    
    public String getContractContent()
    {
        return contractContent;
    }
    
    public void setContractContent(String contractContent)
    {
        this.contractContent = contractContent;
    }
    
    public Integer getFundSourcesId()
    {
        return fundSourcesId;
    }
    
    public void setFundSourcesId(Integer fundSourcesId)
    {
        this.fundSourcesId = fundSourcesId;
    }
    
    public String getFundSourceMoneys()
    {
        return fundSourceMoneys;
    }
    
    public void setFundSourceMoneys(String fundSourceMoneys)
    {
        this.fundSourceMoneys = fundSourceMoneys;
    }
    
    public String getInvoiceNos()
    {
        return invoiceNos;
    }
    
    public void setInvoiceNos(String invoiceNos)
    {
        this.invoiceNos = invoiceNos;
    }
    
    public String getAssetsImg()
    {
        return assetsImg;
    }
    
    public void setAssetsImg(String assetsImg)
    {
        this.assetsImg = assetsImg;
    }
    
    public Long getVerfyBy()
    {
        return verfyBy;
    }
    
    public void setVerfyBy(Long verfyBy)
    {
        this.verfyBy = verfyBy;
    }
    
    public String getPrice()
    {
        return price;
    }
    
    public void setPrice(String price)
    {
        this.price = price;
    }
    
    public String getContractPrice()
    {
        return contractPrice;
    }
    
    public void setContractPrice(String contractPrice)
    {
        this.contractPrice = contractPrice;
    }
    
}
