package com.aek.ebey.assets.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.aek.common.core.base.BaseMapper;
import com.aek.ebey.assets.model.AssAssetsDiscard;
import com.aek.ebey.assets.model.request.AssetsDisResponse;

/**
 * <p>
 * Mapper接口
 * </p>
 *
 * @author aek
 * @since 2017-12-14
 */
public interface AssAssetsDiscardMapper extends BaseMapper<AssAssetsDiscard> {

	List<AssAssetsDiscard> selectByAssDiscardId(@Param("id")Long id);

	List<AssetsDisResponse> selectByAssId(@Param("id")Long assDiscardId);

}