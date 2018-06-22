package com.aek.ebey.assets.mapper;

import com.aek.ebey.assets.model.AssAssetsCertificate;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.aek.common.core.base.BaseMapper;
import com.aek.common.core.serurity.model.AuthUser;

/**
 * <p>
 * Mapper接口
 * </p>
 *
 * @author aek
 * @since 2017-11-22
 */
public interface AssAssetsCertificateMapper extends BaseMapper<AssAssetsCertificate> {
	
	/**
	 * 根据资产id和用户获取资产所有资格证
	 * @param assetsId
	 * @param authUser
	 * @return
	 */
	List<AssAssetsCertificate> getCertificate(@Param("assetsId")Long assetsId,@Param("user") AuthUser authUser);
	
	/**
	 * 根据资产id、用户、类型获取资产资格证
	 * @param assetsId
	 * @param authUser
	 * @param certificateType
	 * @return
	 */
	AssAssetsCertificate getCertificateByType(@Param("assetsId")Long assetsId,@Param("user") AuthUser authUser,@Param("certificateType")Integer certificateType);
	
	/**
	 * 根据资产name、用户获取资产资格证
	 * @param name
	 * @param assetsId
	 * @param authUser
	 * @return
	 */
	AssAssetsCertificate getCertificateByName(@Param("name")String name,@Param("assetsId")Long assetsId,@Param("user") AuthUser authUser);
	
	
	
	AssAssetsCertificate getCertificateByNameId(@Param("name")String name,@Param("assetsId")Long assetsId,@Param("user") AuthUser authUser,@Param("idFlag") Long idFlag);
	
	/**
	 * 证件删除
	 * @param assetsId
	 * @param authUser
	 */
	void del(@Param("user") AuthUser authUser,@Param("assetsId")Long assetsId);
	
}