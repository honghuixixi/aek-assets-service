package com.aek.ebey.assets.service;

import java.util.List;

import com.aek.common.core.base.BaseService;
import com.aek.ebey.assets.model.AssetsInfo;
import com.aek.ebey.assets.model.GoodsInfo;

/**
 * <p>
 * 物资基础数据表。 服务类
 * </p>
 *
 * @author aek
 * @since 2017-04-13
 */
public interface GoodsInfoService extends BaseService<GoodsInfo>
{
    
    /**
     * 获取医院基础物资信息
     * @param keywords
     * @return
     */
    List<AssetsInfo> getPMGoods(String keywords);
    
}
