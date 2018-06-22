package com.aek.ebey.assets.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.aek.common.core.base.BaseMapper;
import com.aek.common.core.base.session.SessionUser;
import com.aek.ebey.assets.model.AssetsInfo;
import com.aek.ebey.assets.model.GoodsInfo;

/**
 * <p>
  * 物资基础数据表。 Mapper 接口
 * </p>
 *
 * @author aek
 * @since 2017-04-13
 */
public interface GoodsInfoMapper extends BaseMapper<GoodsInfo>
{
    
    /**
     * 获取医院基础物资列表
     * @param keywords
     * @return
     */
    public List<AssetsInfo> getPMGoods(@Param("user") SessionUser sessionUser, @Param("keywords") String keywords);
    
}