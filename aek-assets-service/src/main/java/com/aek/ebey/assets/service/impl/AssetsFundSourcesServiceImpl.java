package com.aek.ebey.assets.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aek.common.core.base.BaseServiceImpl;
import com.aek.ebey.assets.mapper.AssetsFundSourcesMapper;
import com.aek.ebey.assets.model.AssetsFundSources;
import com.aek.ebey.assets.service.AssetsFundSourcesService;

/**
 * <p>
 * 资产资金来源表 服务实现类
 * </p>
 *
 * @author aek
 * @since 2017-04-13
 */
@Service
@Transactional
public class AssetsFundSourcesServiceImpl extends BaseServiceImpl<AssetsFundSourcesMapper, AssetsFundSources> implements AssetsFundSourcesService {
	
}
