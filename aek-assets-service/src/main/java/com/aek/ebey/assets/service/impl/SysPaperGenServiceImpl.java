package com.aek.ebey.assets.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aek.common.core.base.BaseServiceImpl;
import com.aek.ebey.assets.mapper.SysPaperGenMapper;
import com.aek.ebey.assets.model.SysPaperGen;
import com.aek.ebey.assets.service.SysPaperGenService;

/**
 * <p>
 * 单号生成 服务实现类
 * </p>
 *
 * @author aek
 * @since 2017-04-13
 */
@Service
@Transactional
public class SysPaperGenServiceImpl extends BaseServiceImpl<SysPaperGenMapper, SysPaperGen> implements SysPaperGenService {
	
}
