package com.aek.ebey.assets.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aek.common.core.base.BaseServiceImpl;
import com.aek.ebey.assets.mapper.FiscalPeriodsMapper;
import com.aek.ebey.assets.model.FiscalPeriods;
import com.aek.ebey.assets.service.FiscalPeriodsService;

/**
 * <p>
 * 会计日历表 服务实现类
 * </p>
 *
 * @author aek
 * @since 2017-04-13
 */
@Service
@Transactional
public class FiscalPeriodsServiceImpl extends BaseServiceImpl<FiscalPeriodsMapper, FiscalPeriods> implements FiscalPeriodsService {
	
}
