package com.aek.ebey.assets.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aek.common.core.base.BaseServiceImpl;
import com.aek.ebey.assets.mapper.GoodsInfoMapper;
import com.aek.ebey.assets.model.AssetsInfo;
import com.aek.ebey.assets.model.GoodsInfo;
import com.aek.ebey.assets.service.GoodsInfoService;

/**
 * <p>
 * 物资基础数据表。 服务实现类
 * </p>
 *
 * @author aek
 * @since 2017-04-13
 */
@Service
@Transactional
public class GoodsInfoServiceImpl extends BaseServiceImpl<GoodsInfoMapper, GoodsInfo> implements GoodsInfoService {

	@Override
	public List<AssetsInfo> getPMGoods(String keywords) {
		if (StringUtils.isNotEmpty(keywords)) {
			keywords = keywords.trim();
		}
		return new ArrayList<AssetsInfo>();
	}
}
