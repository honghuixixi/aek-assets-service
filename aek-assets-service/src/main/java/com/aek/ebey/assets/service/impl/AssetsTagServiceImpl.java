package com.aek.ebey.assets.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aek.ebey.assets.mapper.AssetsTagMapper;
import com.aek.ebey.assets.mapper.AssetsTagTenantMapper;
import com.aek.ebey.assets.model.AssetsTag;
import com.aek.ebey.assets.model.AssetsTagTenant;
import com.aek.ebey.assets.service.AssetsTagService;

/**
 * 资产标签业务实现类
 *	
 * @author HongHui
 * @date   2017年12月26日
 */
@Service
@Transactional
public class AssetsTagServiceImpl implements AssetsTagService {

	@Autowired
	private AssetsTagMapper assetsTagMapper;
	@Autowired
	private AssetsTagTenantMapper assetsTagTenantMapper;
	
	@Override
	public AssetsTag getCurrentAssetsTag(Long tenantId) {
		AssetsTagTenant assetsTagTenant = assetsTagTenantMapper.getAssetsTagTenantByTenantId(tenantId);
		if(null == assetsTagTenant){
			return assetsTagMapper.getCommonAssetsTag();
		}
		return assetsTagMapper.selectById(assetsTagTenant.getTagId());
	}

}
