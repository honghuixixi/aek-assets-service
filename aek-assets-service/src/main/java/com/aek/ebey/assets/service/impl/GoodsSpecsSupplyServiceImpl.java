package com.aek.ebey.assets.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aek.common.core.base.BaseServiceImpl;
import com.aek.ebey.assets.mapper.GoodsSpecsSupplyMapper;
import com.aek.ebey.assets.model.GoodsSpecsSupply;
import com.aek.ebey.assets.service.GoodsSpecsSupplyService;

/**
 * <p>
 * 字典供货信息表 服务实现类
 * </p>
 *
 * @author aek
 * @since 2017-04-13
 */
@Service
@Transactional
public class GoodsSpecsSupplyServiceImpl extends BaseServiceImpl<GoodsSpecsSupplyMapper, GoodsSpecsSupply> implements GoodsSpecsSupplyService {
	
}
