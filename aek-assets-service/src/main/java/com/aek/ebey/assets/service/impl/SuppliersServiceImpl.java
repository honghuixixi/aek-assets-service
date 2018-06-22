package com.aek.ebey.assets.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aek.common.core.base.BaseServiceImpl;
import com.aek.ebey.assets.mapper.SuppliersMapper;
import com.aek.ebey.assets.model.Suppliers;
import com.aek.ebey.assets.service.SuppliersService;

/**
 * <p>
 * 供应商信息表。 服务实现类
 * </p>
 *
 * @author aek
 * @since 2017-04-13
 */
@Service
@Transactional
public class SuppliersServiceImpl extends BaseServiceImpl<SuppliersMapper, Suppliers> implements SuppliersService {
	
}
