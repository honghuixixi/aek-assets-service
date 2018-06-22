package com.aek.ebey.assets.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aek.common.core.base.BaseServiceImpl;
import com.aek.ebey.assets.mapper.ContractFileMapper;
import com.aek.ebey.assets.model.ContractFile;
import com.aek.ebey.assets.service.ContractFileService;

/**
 * <p>
 * 合同文件附件关系 服务实现类
 * </p>
 *
 * @author aek
 * @since 2017-04-13
 */
@Service
@Transactional
public class ContractFileServiceImpl extends BaseServiceImpl<ContractFileMapper, ContractFile> implements ContractFileService {
	
}
