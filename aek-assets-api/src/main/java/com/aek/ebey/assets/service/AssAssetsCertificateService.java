package com.aek.ebey.assets.service;

import com.aek.ebey.assets.model.AssAssetsCertificate;

import java.util.List;

import com.aek.common.core.base.BaseService;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author aek
 * @since 2017-11-22
 */
public interface AssAssetsCertificateService extends BaseService<AssAssetsCertificate> {
	/**
	 * 编辑资产资格证
	 * @param assAssetsCertificate
	 */
	void edit(List<AssAssetsCertificate> list);
	
	/**
	 * 新增自定义资产资格证
	 * @param assAssetsCertificate
	 */
	void add(AssAssetsCertificate assAssetsCertificate);
	
	/**
	 * 根据id删除资产资格证
	 * @param id
	 */
	void delet(Long id);
	
	void check(String name,Long assetsId,Long idFlag);
}
