package com.aek.ebey.assets.service.impl;

import com.aek.ebey.assets.mapper.AssArchiveContractInfoInvoiceMapper;
import com.aek.ebey.assets.model.AssArchiveContractInfoInvoice;
import com.aek.ebey.assets.service.AssArchiveContractInfoInvoiceService;
import com.aek.common.core.base.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 资产档案合同信息发票表 服务实现类
 * </p>
 *
 * @author cyl
 * @since 2018-04-27
 */
@Service
@Transactional
public class AssArchiveContractInfoInvoiceServiceImpl extends BaseServiceImpl<AssArchiveContractInfoInvoiceMapper,AssArchiveContractInfoInvoice> implements AssArchiveContractInfoInvoiceService {
	
}
