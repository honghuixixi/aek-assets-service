package com.aek.ebey.assets.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aek.common.core.base.BaseServiceImpl;
import com.aek.ebey.assets.mapper.AssetsInvoiceMapper;
import com.aek.ebey.assets.model.AssetsInvoice;
import com.aek.ebey.assets.service.AssetsInvoiceService;

/**
 * <p>
 * 资产发票表 服务实现类
 * </p>
 *
 * @author aek
 * @since 2017-04-13
 */
@Service
@Transactional
public class AssetsInvoiceServiceImpl extends BaseServiceImpl<AssetsInvoiceMapper, AssetsInvoice> implements AssetsInvoiceService {
	
}
