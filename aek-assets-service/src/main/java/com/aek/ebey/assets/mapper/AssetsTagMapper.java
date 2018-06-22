package com.aek.ebey.assets.mapper;

import com.aek.common.core.base.BaseMapper;
import com.aek.ebey.assets.model.AssetsTag;

/**
 * 资产标签Mapper 
 *	
 * @author HongHui
 * @date   2017年12月26日
 */
public interface AssetsTagMapper extends BaseMapper<AssetsTag> {

	/**
	 * 获取标准的资产标签数据
	 * @return
	 */
	public AssetsTag getCommonAssetsTag();
}