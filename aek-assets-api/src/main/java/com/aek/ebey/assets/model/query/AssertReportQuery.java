package com.aek.ebey.assets.model.query;

import com.aek.ebey.assets.model.AssetsInfo;

import io.swagger.annotations.ApiModel;

/**
 * 资产导出查询实体
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  Shuangwf
 * @version  1.0, 2017年4月24日
 */
@ApiModel
public class AssertReportQuery extends AssetsInfo
{
    /**
     * 检索关键字
     */
    private String keyword;
    
    /**
     * 状态
     */
    private Integer status;
    
    /**
     *来源 
     */
    private Integer assetsSource;
    
    /**
     * 科室
     */
    private Integer deptId;
    
    /**
     * 排序
     */
    private Integer sort;
    
    /**
     * 查询列
     */
    private String colum;
    
    /**
     * 导出哪些数据
     */
    private Integer data;
    
    /**
     * 导出选中的资产ID
     */
    private Integer[] ids;
    
    public String getKeyword()
    {
        return keyword;
    }
    
    public void setKeyword(String keyword)
    {
        this.keyword = keyword;
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
    
    public String getColum()
    {
        return colum;
    }
    
    public void setColum(String colum)
    {
        this.colum = colum;
    }
    
    public Integer getData()
    {
        return data;
    }
    
    public void setData(Integer data)
    {
        this.data = data;
    }

    public Integer getAssetsSource()
    {
        return assetsSource;
    }

    public void setAssetsSource(Integer assetsSource)
    {
        this.assetsSource = assetsSource;
    }

	public Integer[] getIds() {
		return ids;
	}

	public void setIds(Integer[] ids) {
		this.ids = ids;
	}

}
