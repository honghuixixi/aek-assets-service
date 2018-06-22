package com.aek.ebey.assets.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aek.common.core.base.BaseServiceImpl;
import com.aek.ebey.assets.mapper.ContractMapper;
import com.aek.ebey.assets.model.Contract;
import com.aek.ebey.assets.service.ContractService;

/**
 * <p>
 * 设备合同信息 服务实现类
 * </p>
 *
 * @author aek
 * @since 2017-04-13
 */
@Service
@Transactional
public class ContractServiceImpl extends BaseServiceImpl<ContractMapper, Contract> implements ContractService {
	
}
