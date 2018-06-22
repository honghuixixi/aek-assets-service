package com.aek.ebey.assets.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aek.common.core.base.BaseServiceImpl;
import com.aek.ebey.assets.mapper.GoodsRegMapper;
import com.aek.ebey.assets.model.GoodsReg;
import com.aek.ebey.assets.service.GoodsRegService;

/**
 * <p>
 * 供应商医疗器械登记证信息表。 服务实现类
 * </p>
 *
 * @author aek
 * @since 2017-04-13
 */
@Service
@Transactional
public class GoodsRegServiceImpl extends BaseServiceImpl<GoodsRegMapper, GoodsReg> implements GoodsRegService {
	
}
