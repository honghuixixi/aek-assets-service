package com.aek.ebey.assets.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  zhousixiong
 * @version  1.0, 2017年4月22日
 */
@ApiModel(value = "pmAssetsSource", description = "资产台账来源数量")
public class AssetsSource
{
    @ApiModelProperty(value = "入库新增")
    private int assetsAddWarehouse;
    
    @ApiModelProperty(value = "批量导入")
    private int assetsImport;

    @ApiModelProperty(value = "全部来源")
    private int assetsSourceAll;
    
    public int getAssetsAddWarehouse()
    {
        return assetsAddWarehouse;
    }

    public void setAssetsAddWarehouse(int assetsAddWarehouse)
    {
        this.assetsAddWarehouse = assetsAddWarehouse;
    }

    public int getAssetsImport()
    {
        return assetsImport;
    }

    public void setAssetsImport(int assetsImport)
    {
        this.assetsImport = assetsImport;
    }

    public int getAssetsSourceAll()
    {
        return assetsSourceAll;
    }

    public void setAssetsSourceAll(int assetsSourceAll)
    {
        this.assetsSourceAll = assetsSourceAll;
    }
    
    
}
