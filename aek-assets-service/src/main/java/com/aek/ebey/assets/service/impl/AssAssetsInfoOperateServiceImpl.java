package com.aek.ebey.assets.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aek.common.core.base.BaseServiceImpl;
import com.aek.ebey.assets.mapper.AssAssetsInfoOperateMapper;
import com.aek.ebey.assets.model.AssAssetsInfoOperate;
import com.aek.ebey.assets.service.AssAssetsInfoOperateService;

/**
 * <p>
 * 预台帐操作记录 服务实现类
 * </p>
 *
 * @author aek
 * @since 2017-08-23
 */
@Service
@Transactional
public class AssAssetsInfoOperateServiceImpl extends BaseServiceImpl<AssAssetsInfoOperateMapper,AssAssetsInfoOperate> implements AssAssetsInfoOperateService {

	
}
