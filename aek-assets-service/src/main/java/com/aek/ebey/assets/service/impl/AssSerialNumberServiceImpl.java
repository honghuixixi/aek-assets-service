package com.aek.ebey.assets.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aek.common.core.base.BaseServiceImpl;
import com.aek.ebey.assets.mapper.AssSerialNumberMapper;
import com.aek.ebey.assets.model.AssSerialNumber;
import com.aek.ebey.assets.service.AssSerialNumberService;

/**
 * <p>
 * 流水号表 服务实现类
 * </p>
 *
 * @author aek
 * @since 2017-07-06
 */
@Service
@Transactional
public class AssSerialNumberServiceImpl extends BaseServiceImpl<AssSerialNumberMapper, AssSerialNumber> implements AssSerialNumberService {

	 @Autowired
	    private AssSerialNumberMapper assSerialNumberMapper;
	    
	@Override
	public AssSerialNumber findOne(Long tenantId, int module) {
		return assSerialNumberMapper.findOne(tenantId, module);
	}

	@Override
	@Transactional
	public int insertOrUpdate(Long tenantId, int module, Long num) {
		AssSerialNumber entity = new AssSerialNumber();
		entity.setSn(num);
		entity.setModule(module);
		entity.setTenantId(tenantId);
		int n = assSerialNumberMapper.updateSn(entity);
		if (n < 1) {
			n = assSerialNumberMapper.insert(entity);
		}
		return n;
	}

	
}
