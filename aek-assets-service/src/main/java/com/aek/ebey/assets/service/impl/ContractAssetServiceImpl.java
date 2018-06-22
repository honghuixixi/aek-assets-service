package com.aek.ebey.assets.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aek.common.core.base.BaseServiceImpl;
import com.aek.ebey.assets.mapper.ContractAssetMapper;
import com.aek.ebey.assets.model.ContractAsset;
import com.aek.ebey.assets.service.ContractAssetService;

/**
 * <p>
 * 设备合同关联 服务实现类
 * </p>
 *
 * @author aek
 * @since 2017-04-13
 */
@Service
@Transactional
public class ContractAssetServiceImpl extends BaseServiceImpl<ContractAssetMapper, ContractAsset> implements ContractAssetService {
	
}
