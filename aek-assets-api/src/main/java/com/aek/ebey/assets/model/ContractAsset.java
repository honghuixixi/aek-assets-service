package com.aek.ebey.assets.model;

import com.aek.common.core.base.BaseModel;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * <p>
 * 设备合同关联
 * </p>
 *
 * @author aek
 * @since 2017-04-13
 */
@TableName("ass_contract_asset")
public class ContractAsset extends BaseModel
{
    
    private static final long serialVersionUID = 1L;
    
    /**
     * 主键
     */
    private Long id;
    
    /**
     * 合同id
     */
    @TableField(value = "contract_id")
    private Long contractId;
    
    /**
     * 
     */
    @TableField(value = "sys_id")
    private Integer sysId;
    
    /**
     * 
     */
    @TableField(value = "area_id")
    private Integer areaId;
    
    /**
     * 设备ID
     */
    @TableField(value = "assets_id")
    private Long assetsId;
    
    /**
     * 作废标记
     */
    @TableField(value = "del_flag")
    private Boolean delFlag;
    
    @Override
    public Long getId()
    {
        return id;
    }
    
    @Override
    public void setId(Long id)
    {
        this.id = id;
    }
    
    public Long getContractId()
    {
        return contractId;
    }
    
    public void setContractId(Long contractId)
    {
        this.contractId = contractId;
    }
    
    public Integer getSysId()
    {
        return sysId;
    }
    
    public void setSysId(Integer sysId)
    {
        this.sysId = sysId;
    }
    
    public Integer getAreaId()
    {
        return areaId;
    }
    
    public void setAreaId(Integer areaId)
    {
        this.areaId = areaId;
    }
    
    public Long getAssetsId()
    {
        return assetsId;
    }
    
    public void setAssetsId(Long assetsId)
    {
        this.assetsId = assetsId;
    }

    public Boolean getDelFlag()
    {
        return delFlag;
    }

    public void setDelFlag(Boolean delFlag)
    {
        this.delFlag = delFlag;
    }
    
}
