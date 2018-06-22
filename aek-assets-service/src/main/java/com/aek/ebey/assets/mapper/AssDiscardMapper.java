package com.aek.ebey.assets.mapper;

import com.aek.ebey.assets.model.AssDiscard;
import com.aek.ebey.assets.model.query.AssetsDisApplyQuery;
import com.aek.ebey.assets.model.query.AssetsDisQuery;
import com.aek.ebey.assets.model.request.AssetsDisApplyResponse;
import com.aek.ebey.assets.model.request.AssetsDisResponse;
import com.baomidou.mybatisplus.plugins.Page;

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
 * @since 2017-12-14
 */
public interface AssDiscardMapper extends BaseMapper<AssDiscard> {

	List<AssetsDisResponse> search(Page<AssetsDisResponse> pageAssets, @Param("q") AssetsDisQuery query, @Param("user") AuthUser authUser);

	List<AssDiscard> searchApply(Page<AssetsDisApplyResponse> pageAssetsDisApply,@Param("q") AssetsDisApplyQuery query, @Param("user")AuthUser authUser);

	/**
	 * 根据本机构id统计未审核报损单数目
	 * @param tenantId
	 * @return
	 */
	Integer statsWaitAudit(@Param("tenantId")Long tenantId);
	
	String getDeptNameByDiscardId(@Param("discardId")Long discardId);
}