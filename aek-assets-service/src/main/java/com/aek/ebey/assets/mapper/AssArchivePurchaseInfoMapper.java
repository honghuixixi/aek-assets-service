package com.aek.ebey.assets.mapper;

import com.aek.ebey.assets.model.AssArchivePurchaseInfo;
import com.aek.ebey.assets.model.vo.AssArchivePurchaseInfoVo;

import org.apache.ibatis.annotations.Param;

import com.aek.common.core.base.BaseMapper;

/**
 * <p>
 * Mapper接口
 * </p>
 *
 * @author cyl
 * @since 2018-04-28
 */
public interface AssArchivePurchaseInfoMapper extends BaseMapper<AssArchivePurchaseInfo> {

	void updatePurchase(@Param("purchase")AssArchivePurchaseInfo purchase);
	
	AssArchivePurchaseInfoVo getPurchase(@Param("archiveId")Long archiveId,@Param("assetsId") Long assetsId);
}