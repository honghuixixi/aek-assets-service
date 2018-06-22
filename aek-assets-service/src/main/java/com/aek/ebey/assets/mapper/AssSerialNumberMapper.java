package com.aek.ebey.assets.mapper;

import org.apache.ibatis.annotations.Param;

import com.aek.common.core.base.BaseMapper;
import com.aek.ebey.assets.model.AssSerialNumber;

/**
 * <p>
 * Mapper接口
 * </p>
 *
 * @author aek
 * @since 2017-07-06
 */
public interface AssSerialNumberMapper extends BaseMapper<AssSerialNumber> {

	AssSerialNumber findOne(@Param("tenantId")Long tenantId, @Param("module")int module);

	int updateSn(AssSerialNumber entity);

}