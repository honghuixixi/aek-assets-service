package com.aek.ebey.assets.service;

import com.aek.common.core.base.BaseService;
import com.aek.ebey.assets.model.AssSerialNumber;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author aek
 * @since 2017-07-06
 */
public interface AssSerialNumberService extends BaseService<AssSerialNumber> {

	AssSerialNumber findOne(Long tenantId, int module);
	int insertOrUpdate(Long tenantId, int module, Long num);
}
