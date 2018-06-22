package com.aek.ebey.assets.model.query;

import io.swagger.annotations.ApiModel;

/**
 * 
 * 台账列表分页查询实体
 * <功能详细描述>
 * 
 * @author  zhousixiong
 * @version  1.0, 2017年4月24日
 */
@ApiModel
public class LedgerPaging extends AssertQuery
{
    private static final long serialVersionUID = 1L;
    
    private Integer dataScope;

	public Integer getDataScope() {
		return dataScope;
	}

	public void setDataScope(Integer dataScope) {
		this.dataScope = dataScope;
	}
    
}
