package com.aek.ebey.assets.service;

import java.util.List;

import com.aek.common.core.base.BaseService;
import com.aek.ebey.assets.model.AssAssetsDiscard;
import com.aek.ebey.assets.model.request.AssetsDisResponse;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author aek
 * @since 2017-12-14
 */
public interface AssAssetsDiscardService extends BaseService<AssAssetsDiscard> {

	List<AssAssetsDiscard> selectByAssDiscardId(Long id);

	List<AssetsDisResponse> selectByAssId(Long assDiscardId);
	
}
