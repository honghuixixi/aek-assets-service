package com.aek.ebey.assets.model.query;

import com.aek.ebey.assets.model.Assets;
import com.aek.ebey.assets.model.AssetsPm;
import com.baomidou.mybatisplus.plugins.Page;

import io.swagger.annotations.ApiModel;

/**
 * PM资产列表分页查询实体
 */
@ApiModel
public class PmAssertPaging{
    
    private Page<AssetsPm> page;
    
    /**
     * 检索关键字
     */
    private String keyword;
    
    /**
     * 科室ID
     */
    private Long departmentId;

	public Page<AssetsPm> getPage() {
		return page;
	}

	public void setPage(Page<AssetsPm> page) {
		this.page = page;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}
    
}
