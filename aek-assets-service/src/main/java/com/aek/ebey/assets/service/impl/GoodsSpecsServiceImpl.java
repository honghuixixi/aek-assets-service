package com.aek.ebey.assets.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aek.common.core.base.BaseServiceImpl;
import com.aek.ebey.assets.mapper.GoodsSpecsMapper;
import com.aek.ebey.assets.model.GoodsSpecs;
import com.aek.ebey.assets.service.GoodsSpecsService;

/**
 * <p>
 * 物资规格表。 服务实现类
 * </p>
 *
 * @author aek
 * @since 2017-04-13
 */
@Service
@Transactional
public class GoodsSpecsServiceImpl extends BaseServiceImpl<GoodsSpecsMapper, GoodsSpecs> implements GoodsSpecsService {
	
}
