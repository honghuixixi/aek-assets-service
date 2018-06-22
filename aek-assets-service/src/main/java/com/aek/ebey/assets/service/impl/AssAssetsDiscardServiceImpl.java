package com.aek.ebey.assets.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aek.common.core.base.BaseServiceImpl;
import com.aek.ebey.assets.mapper.AssAssetsDiscardMapper;
import com.aek.ebey.assets.model.AssAssetsDiscard;
import com.aek.ebey.assets.model.request.AssetsDisResponse;
import com.aek.ebey.assets.service.AssAssetsDiscardService;

/**
 * <p>
 * 报损设备 服务实现类
 * </p>
 *
 * @author aek
 * @since 2017-12-14
 */
@Service
@Transactional
public class AssAssetsDiscardServiceImpl extends BaseServiceImpl<AssAssetsDiscardMapper, AssAssetsDiscard> implements AssAssetsDiscardService {

	
	@Autowired
	private AssAssetsDiscardMapper assAssetsDiscardMapper;
	
	@Override
	public List<AssAssetsDiscard> selectByAssDiscardId(Long id) {
		return assAssetsDiscardMapper.selectByAssDiscardId(id);
	}

	@Override
	public List<AssetsDisResponse> selectByAssId(Long assDiscardId) {
		
		return assAssetsDiscardMapper.selectByAssId(assDiscardId);
	}
	
}
