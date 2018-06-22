package com.aek.ebey.assets.mapper;

import com.aek.ebey.assets.model.AssetsFundSources;

import java.util.List;
import java.util.Map;

import com.aek.common.core.base.BaseMapper;

/**
 * <p>
  * 资产资金来源表 Mapper 接口
 * </p>
 *
 * @author aek
 * @since 2017-04-13
 */
public interface AssetsFundSourcesMapper extends BaseMapper<AssetsFundSources> {

	List<Map<String,Object>> findByAssetsId(Long id);

	void batchInsert(List<AssetsFundSources> fundSourceList);

	void updateAssetsFundSources(AssetsFundSources assetsFundSources);
}