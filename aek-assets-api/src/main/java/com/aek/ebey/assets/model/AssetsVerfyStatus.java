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
@ApiModel(value = "pmAssetsVerfyStatus", description = "预台状态数量查询实体")
public class AssetsVerfyStatus
{
    
    @ApiModelProperty(value = "审核状态 暂存")
    private int verfyStatusStage;
    
    @ApiModelProperty(value = "审核状态 未审核 ")
    private int verfyStatusUnaudited;
    
    @ApiModelProperty(value = "审核状态 通过")
    private int verfyStatusPass;
    
    @ApiModelProperty(value = "审核状态 不通过")
    private int verfyStatusUnPass;
    
    @ApiModelProperty(value = "审核状态 所有")
    private int verfyStatusAll;
    
    public int getVerfyStatusAll()
    {
        return verfyStatusAll;
    }
    
    public void setVerfyStatusAll(int verfyStatusAll)
    {
        this.verfyStatusAll = verfyStatusAll;
    }
    
    public int getVerfyStatusStage()
    {
        return verfyStatusStage;
    }
    
    public void setVerfyStatusStage(int verfyStatusStage)
    {
        this.verfyStatusStage = verfyStatusStage;
    }
    
    public int getVerfyStatusUnaudited()
    {
        return verfyStatusUnaudited;
    }
    
    public void setVerfyStatusUnaudited(int verfyStatusUnaudited)
    {
        this.verfyStatusUnaudited = verfyStatusUnaudited;
    }
    
    public int getVerfyStatusPass()
    {
        return verfyStatusPass;
    }
    
    public void setVerfyStatusPass(int verfyStatusPass)
    {
        this.verfyStatusPass = verfyStatusPass;
    }
    
    public int getVerfyStatusUnPass()
    {
        return verfyStatusUnPass;
    }
    
    public void setVerfyStatusUnPass(int verfyStatusUnPass)
    {
        this.verfyStatusUnPass = verfyStatusUnPass;
    }
    
}
