package com.aek.ebey.assets.mapper;

import org.apache.ibatis.annotations.Param;

import com.aek.common.core.base.BaseMapper;
import com.aek.ebey.assets.model.AssetsTagTenant;

/**
 * 资产标签与机构关系表
 *	
 * @author HongHui
 * @date   2017年12月26日
 */
public interface AssetsTagTenantMapper extends BaseMapper<AssetsTagTenant> {

	/**
	 * 根据tenantId获取资产标签机构关系
	 * @param tenantId
	 * @return
	 */
	public AssetsTagTenant getAssetsTagTenantByTenantId(@Param("tenantId") Long tenantId);
}