package com.aek.ebey.assets.web.request;

import java.sql.Date;

import org.hibernate.validator.constraints.NotEmpty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * 台账列表查询返回实体
 * <功能详细描述>
 * 
 * @author  zhousixiong
 * @version  1.0, 2017年4月24日
 */
@ApiModel(value = "AssetsLedgerInfo", description = "台账列表信息")
public class AssetsLedgerInfoReponse
{
    @ApiModelProperty(value = "台账ID")
    @NotEmpty
    private Long id;
    /**
	 * 台账图片
	 */
	@ApiModelProperty(value = "台账图片")
	private String assetsImg;
    
    @ApiModelProperty(value = "启用时间")
    @NotEmpty
    private Date startUseDate;
    
    @ApiModelProperty(value = "出产编号")
    @NotEmpty
    private String factoryNum;
    
    @ApiModelProperty(value = "设备品牌")
    @NotEmpty
    private String assetsBrand;
    
    @ApiModelProperty(value = "设备名称")
    @NotEmpty
    private String assetsName;
    
    @ApiModelProperty(value = "设备编号")
    @NotEmpty
    private String assetsNum;
    
    @ApiModelProperty(value = "生产商")
    @NotEmpty
    private String factoryName;
    
    @ApiModelProperty(value = "设备规格")
    @NotEmpty
    private String assetsSpec;
    
    @ApiModelProperty(value = "供应商")
    @NotEmpty
    private String splName;
    
    @ApiModelProperty(value = "来源 0：入库新增，1：批量导入")
    @NotEmpty
    private String assetsSourceName;
    
    //@ApiModelProperty(value = "状态：1未启用、2正常运行、3计量中、4维修中、5停用中、6已报废、7已报损")
    @ApiModelProperty(value = "状态：1=在库、2=在用、3=预登、4=待报损、5=报损、6=退货")
    @NotEmpty
    private String statusName;
    
    @ApiModelProperty(value = "维修状态：1=正常、2=维修中")
    @NotEmpty
    private String repairStatusName;
    
    @ApiModelProperty(value = "使用科室")
    @NotEmpty
    private String deptName;
    
    @ApiModelProperty(value = "使用科室ID")
    @NotEmpty
    private String deptId;
    
    @ApiModelProperty(value = "报废时间")
    @NotEmpty
    private Date scrapDate;
    
    @ApiModelProperty(value = "保修日期")
    private Date warrantyDate;
    
    @ApiModelProperty(value = "院内编码")
    private String serialNum;
    
    @ApiModelProperty(value = "计数单位名称")
    private String unitName;
    
    public String getAssetsName()
    {
        return assetsName;
    }

    public void setAssetsName(String assetsName)
    {
        this.assetsName = assetsName;
    }

    public String getAssetsNum()
    {
        return assetsNum;
    }

    public void setAssetsNum(String assetsNum)
    {
        this.assetsNum = assetsNum;
    }

    public String getFactoryName()
    {
        return factoryName;
    }

    public void setFactoryName(String factoryName)
    {
        this.factoryName = factoryName;
    }

    public String getAssetsSpec()
    {
        return assetsSpec;
    }

    public void setAssetsSpec(String assetsSpec)
    {
        this.assetsSpec = assetsSpec;
    }

    public String getSplName()
    {
        return splName;
    }

    public void setSplName(String splName)
    {
        this.splName = splName;
    }

    public String getAssetsSourceName()
    {
        return assetsSourceName;
    }

    public void setAssetsSourceName(String assetsSourceName)
    {
        this.assetsSourceName = assetsSourceName;
    }

    public String getStatusName()
    {
        return statusName;
    }

    public void setStatusName(String statusName)
    {
        this.statusName = statusName;
    }

    public String getDeptName()
    {
        return deptName;
    }

    public void setDeptName(String deptName)
    {
        this.deptName = deptName;
    }

    public Date getStartUseDate()
    {
        return startUseDate;
    }

    public void setStartUseDate(Date startUseDate)
    {
        this.startUseDate = startUseDate;
    }

    public String getFactoryNum()
    {
        return factoryNum;
    }

    public void setFactoryNum(String factoryNum)
    {
        this.factoryNum = factoryNum;
    }

    public String getAssetsBrand()
    {
        return assetsBrand;
    }

    public void setAssetsBrand(String assetsBrand)
    {
        this.assetsBrand = assetsBrand;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

	public Date getScrapDate() {
		return scrapDate;
	}

	public void setScrapDate(Date scrapDate) {
		this.scrapDate = scrapDate;
	}

	public Date getWarrantyDate() {
		return warrantyDate;
	}

	public void setWarrantyDate(Date warrantyDate) {
		this.warrantyDate = warrantyDate;
	}

	public String getAssetsImg() {
		return assetsImg;
	}

	public void setAssetsImg(String assetsImg) {
		this.assetsImg = assetsImg;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getRepairStatusName() {
		return repairStatusName;
	}

	public void setRepairStatusName(String repairStatusName) {
		this.repairStatusName = repairStatusName;
	}
	
	public String getSerialNum() {
		return serialNum;
	}

	public void setSerialNum(String serialNum) {
		this.serialNum = serialNum;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
    
}