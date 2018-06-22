package com.aek.ebey.assets.mapper;

import com.aek.ebey.assets.model.AssAssetsAnnex;

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
public interface AssAssetsAnnexMapper extends BaseMapper<AssAssetsAnnex> {

	AssAssetsAnnex getAnnex(@Param("assetsId")Long assetsId,@Param("annexType")Integer annexType,
			 @Param("user") AuthUser authUser);
	
	AssAssetsAnnex getContractAnnex(@Param("assetsId")Long assetsId,@Param("annexType")Integer annexType,
			@Param("contractId")Long contractId,@Param("user") AuthUser authUser);
}