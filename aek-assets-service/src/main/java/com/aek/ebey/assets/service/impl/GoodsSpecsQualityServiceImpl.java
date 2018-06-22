package com.aek.ebey.assets.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aek.common.core.base.BaseServiceImpl;
import com.aek.ebey.assets.mapper.GoodsSpecsQualityMapper;
import com.aek.ebey.assets.model.GoodsSpecsQuality;
import com.aek.ebey.assets.service.GoodsSpecsQualityService;

/**
 * <p>
 * 字典质量管理信息表 服务实现类
 * </p>
 *
 * @author aek
 * @since 2017-04-13
 */
@Service
@Transactional
public class GoodsSpecsQualityServiceImpl extends BaseServiceImpl<GoodsSpecsQualityMapper, GoodsSpecsQuality> implements GoodsSpecsQualityService {
	
}
