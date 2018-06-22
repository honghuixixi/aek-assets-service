package com.aek.ebey.assets.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 扫码获取资产信息
 *	
 * @author HongHui
 * @date   2018年5月16日
 */
@ApiModel("扫码获取资产信息")
public class AssetsScanVO {
    
    @ApiModelProperty("资产ID")
    private Long id;
    @ApiModelProperty("资产名称")
    private String assetsName;
    @ApiModelProperty("资产编码")
    private String assetsNum;
    @ApiModelProperty("资产类型 1-台账，2-预台账")
    private Integer assetsStatus;
    @ApiModelProperty("资产维修状态 1正常，2维修中")
    private Integer repairStatus;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
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
    public Integer getAssetsStatus() {
        return assetsStatus;
    }
    public void setAssetsStatus(Integer assetsStatus) {
        this.assetsStatus = assetsStatus;
    }
    public Integer getRepairStatus() {
        return repairStatus;
    }
    public void setRepairStatus(Integer repairStatus) {
        this.repairStatus = repairStatus;
    }
    
}
