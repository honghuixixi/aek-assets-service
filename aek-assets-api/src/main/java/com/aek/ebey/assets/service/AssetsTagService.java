package com.aek.ebey.assets.service;

import com.aek.ebey.assets.model.AssetsTag;

/**
 * 资产标签接口
 *	
 * @author HongHui
 * @date   2017年12月26日
 */
public interface AssetsTagService {

	/**
	 * 根据机构ID获取打印标签内容
	 * @param tenantId
	 * @return
	 */
	public AssetsTag getCurrentAssetsTag(Long tenantId);
	
}
