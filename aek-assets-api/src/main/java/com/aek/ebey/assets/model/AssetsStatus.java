package com.aek.ebey.assets.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  zhousixiong
 * @version  1.0, 2017年4月21日
 */
@ApiModel(value = "pmAssetsStatus", description = "资产台账状态数量查询实体")
public class AssetsStatus
{
    //状态：1、2、3、4、5、6、7
    @ApiModelProperty(value = "未启用")
    private int statusNotEnabled;
    
    @ApiModelProperty(value = "正常运行")
    private int statusEnabled;
    
    @ApiModelProperty(value = "计量中")
    private int statusInMetering;
    
    @ApiModelProperty(value = "维修中")
    private int statusRepair;
    
    @ApiModelProperty(value = "停用中")
    private int statusDisable;
    
    @ApiModelProperty(value = "已报废")
    private int statusScrapped;
    
    @ApiModelProperty(value = "已报损")
    private int statusReportedLoss;
    
    @ApiModelProperty(value = "总状态")
    private int statusAll;

    public int getStatusNotEnabled()
    {
        return statusNotEnabled;
    }

    public void setStatusNotEnabled(int statusNotEnabled)
    {
        this.statusNotEnabled = statusNotEnabled;
    }

    public int getStatusEnabled()
    {
        return statusEnabled;
    }

    public void setStatusEnabled(int statusEnabled)
    {
        this.statusEnabled = statusEnabled;
    }

    public int getStatusInMetering()
    {
        return statusInMetering;
    }

    public void setStatusInMetering(int statusInMetering)
    {
        this.statusInMetering = statusInMetering;
    }

    public int getStatusRepair()
    {
        return statusRepair;
    }

    public void setStatusRepair(int statusRepair)
    {
        this.statusRepair = statusRepair;
    }

    public int getStatusDisable()
    {
        return statusDisable;
    }

    public void setStatusDisable(int statusDisable)
    {
        this.statusDisable = statusDisable;
    }

    public int getStatusScrapped()
    {
        return statusScrapped;
    }

    public void setStatusScrapped(int statusScrapped)
    {
        this.statusScrapped = statusScrapped;
    }

    public int getStatusReportedLoss()
    {
        return statusReportedLoss;
    }

    public void setStatusReportedLoss(int statusReportedLoss)
    {
        this.statusReportedLoss = statusReportedLoss;
    }

    public int getStatusAll()
    {
        return statusAll;
    }

    public void setStatusAll(int statusAll)
    {
        this.statusAll = statusAll;
    }
}
