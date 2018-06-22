package com.aek.ebey.assets.web.request;

import java.sql.Date;

import org.hibernate.validator.constraints.NotEmpty;

import com.baomidou.mybatisplus.annotations.TableField;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 预台账返回实体
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  Shuangwf
 * @version  1.0, 2017年4月14日
 */
@ApiModel(value = "AssetsInfo", description = "预台账列表信息")
public class AssetsInfoReponse
{
    @ApiModelProperty(value = "台账id")
    @NotEmpty
    private Long id;
    
    /*……………………………………………………………………【预台账】………………………………………………………*/
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
    
    @ApiModelProperty(value = "使用科室")
    @NotEmpty
    private String deptName;
    
    @ApiModelProperty(value = "创建人")
    @NotEmpty
    private String createByName;
    
    @ApiModelProperty(value = "创建时间")
    @NotEmpty
    private Date createTime;
    
    @ApiModelProperty(value = "验收状态 0暂存 1:未审核 2:通过 3:不通过")
    @NotEmpty
    private Integer verfyStatus;
    
    /**
	 * 原来状态：1在库、2在用、3计量中、4维修中、5停用中、6已报废、7已报损
	 * 更改状态：1=在库、2=在用、3=预登、4=待报损、5=报损、6=退货
	 */
    //@ApiModelProperty(value = "1未启用、2正常运行、3计量中、4维修中、5停用中、6已报废、7已报损")
    @ApiModelProperty(value = "1=在库、2=在用、3=预登、4=待报损、5=报损、6=退货")
    private Integer status;
    
    /**
     * 维修状态 1正常，2维修中
     */
    @ApiModelProperty(value = "维修状态 :1正常，2维修中")
    private Integer repairStatus;
    
    /**
     * 维修状态名称
     */
    private String repairStatusName; 
  
	/**
     * 台账图片
     */
    private String assetsImg;
    
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
    
    public String getCreateByName()
    {
        return createByName;
    }

    public void setCreateByName(String createByName)
    {
        this.createByName = createByName;
    }

    public Date getCreateTime()
    {
        return createTime;
    }
    
    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }
    
    public String getDeptName()
    {
        return deptName;
    }
    
    public void setDeptName(String deptName)
    {
        this.deptName = deptName;
    }
    
    public Integer getVerfyStatus()
    {
        return verfyStatus;
    }
    
    public void setVerfyStatus(Integer verfyStatus)
    {
        this.verfyStatus = verfyStatus;
    }
    
    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

	public String getAssetsImg() {
		return assetsImg;
	}

	public void setAssetsImg(String assetsImg) {
		this.assetsImg = assetsImg;
	}
	
	  
    public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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
    
}