package com.aek.ebey.assets.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aek.common.core.base.BaseServiceImpl;
import com.aek.ebey.assets.mapper.GoodsClassMapper;
import com.aek.ebey.assets.model.GoodsClass;
import com.aek.ebey.assets.service.GoodsClassService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author aek
 * @since 2017-04-13
 */
@Service
@Transactional
public class GoodsClassServiceImpl extends BaseServiceImpl<GoodsClassMapper, GoodsClass> implements GoodsClassService {
	
}
