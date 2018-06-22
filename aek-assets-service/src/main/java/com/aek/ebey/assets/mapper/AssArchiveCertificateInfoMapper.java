package com.aek.ebey.assets.mapper;

import com.aek.ebey.assets.model.AssArchiveCertificateInfo;

import org.apache.ibatis.annotations.Param;

import com.aek.common.core.base.BaseMapper;

/**
 * <p>
 * Mapper接口
 * </p>
 *
 * @author cyl
 * @since 2018-04-26
 */
public interface AssArchiveCertificateInfoMapper extends BaseMapper<AssArchiveCertificateInfo> {
	
	int updateCertificate(@Param("c")AssArchiveCertificateInfo certificate);

}