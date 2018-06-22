package com.aek.ebey.assets.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aek.common.core.base.BaseServiceImpl;
import com.aek.ebey.assets.mapper.CodeTypeMapper;
import com.aek.ebey.assets.model.CodeType;
import com.aek.ebey.assets.service.CodeTypeService;

/**
 * <p>
 * 基本代码类别表 服务实现类
 * </p>
 *
 * @author aek
 * @since 2017-04-13
 */
@Service
@Transactional
public class CodeTypeServiceImpl extends BaseServiceImpl<CodeTypeMapper, CodeType> implements CodeTypeService {
	
}
