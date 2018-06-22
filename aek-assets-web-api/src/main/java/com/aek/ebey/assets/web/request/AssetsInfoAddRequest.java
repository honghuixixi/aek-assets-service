package com.aek.ebey.assets.web.request;

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
@ApiModel(value = "AssetsInfoAdd", description = "预台账新增信息")
public class AssetsInfoAddRequest
{
    @ApiModelProperty(value = "设备名称")
    @NotEmpty
    private String assetsName;
    
    @ApiModelProperty(value = "生产商")
    @NotEmpty
    private String factoryName;//在表pm_assets_info_ext
    
    @ApiModelProperty(value = "机构")
    @NotEmpty
    private Integer tenantId;
    
    public String getAssetsName()
    {
        return assetsName;
    }
    
    public void setAssetsName(String assetsName)
    {
        this.assetsName = assetsName;
    }
    
    public String getFactoryName()
    {
        return factoryName;
    }
    
    public void setFactoryName(String factoryName)
    {
        this.factoryName = factoryName;
    }

	public Integer getTenantId() {
		return tenantId;
	}

	public void setTenantId(Integer tenantId) {
		this.tenantId = tenantId;
	}
    
}
