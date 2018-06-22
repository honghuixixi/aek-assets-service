package com.aek.ebey.assets.service;

import com.aek.ebey.assets.model.AssArchiveCertificateInfo;

import java.util.List;

import com.aek.common.core.base.BaseService;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author cyl
 * @since 2018-04-26
 */
public interface AssArchiveCertificateInfoService extends BaseService<AssArchiveCertificateInfo> {
	
	/**
	 * 获取证件信息
	 * @param archiveId
	 * @param assetsId
	 * @return
	 */
	List<AssArchiveCertificateInfo> getCertificateInfo(Long archiveId,Long assetsId);
	
	void insertOrUpdateCertificateInfo(AssArchiveCertificateInfo certificate);
	
	void delete(Long id);
}
