package com.aek.ebey.assets.model.query;

import com.aek.ebey.assets.model.Assets;
import com.aek.ebey.assets.model.AssetsInfo;
import com.baomidou.mybatisplus.plugins.Page;

import io.swagger.annotations.ApiModel;

/**
 * 
 * <一句话功能简述>资产分页检索实体
 * <功能详细描述>
 * 
 * @author  Shuangwf
 * @version  1.0, 2017年4月17日
 */
@ApiModel
public class AssertQuery extends AssetsInfo
{
    
    private static final long serialVersionUID = -7071900227364509388L;
    
    private Page<Assets> page;
    
    /**
     * 检索关键字
     */
    private String keyword;
    
    /**
     * 状态[99:查询可维修的设备（正常使用的，排除维修中的设备）]
     */
    private Integer status;
    
    /**
     * 科室
     */
    private Integer deptId;
    
    /**
     * 排序
     */
    private Integer sort;
    
    /**
     * 机构id
     */
    private Long tenantId;
    
    /**
     * 数据范围
     */
    private Integer dataScope;
    
    public String getKeyword()
    {
        return keyword;
    }
    
    public void setKeyword(String keyword)
    {
        this.keyword = keyword;
    }
    
    public Page<Assets> getPage()
    {
        return page;
    }
    
    public void setPage(Page<Assets> page)
    {
        this.page = page;
    }
    
    public static long getSerialversionuid()
    {
        return serialVersionUID;
    }
    
    @Override
    public Integer getStatus()
    {
        return status;
    }
    
    @Override
    public void setStatus(Integer status)
    {
        this.status = status;
    }
    
    @Override
    public Integer getDeptId()
    {
        return deptId;
    }
    
    @Override
    public void setDeptId(Integer deptId)
    {
        this.deptId = deptId;
    }
    
    public Integer getSort()
    {
        return sort;
    }
    
    public void setSort(Integer sort)
    {
        this.sort = sort;
    }

	public Long getTenantId() {
		return tenantId;
	}

	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}

	public Integer getDataScope() {
		return dataScope;
	}

	public void setDataScope(Integer dataScope) {
		this.dataScope = dataScope;
	}
	
}
