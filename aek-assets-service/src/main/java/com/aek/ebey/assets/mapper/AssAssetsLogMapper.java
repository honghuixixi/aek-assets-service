package com.aek.ebey.assets.mapper;

import com.aek.ebey.assets.model.AssAssetsLog;
import com.aek.ebey.assets.model.AssetsLog;
import com.aek.ebey.assets.model.AssetsLogDetail;
import com.aek.ebey.assets.model.query.AssAssetsLogQuery;
import com.baomidou.mybatisplus.plugins.Page;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.aek.common.core.base.BaseMapper;

/**
 * <p>
 * Mapper接口
 * </p>
 *
 * @author cyl
 * @since 2017-12-25
 */
public interface AssAssetsLogMapper extends BaseMapper<AssAssetsLog> {

	List<AssetsLog> getLogPage(@Param("page")Page<AssetsLog> page,@Param("q")AssAssetsLogQuery query);
	
	AssetsLogDetail getLogDetail(@Param("id")Long id);
}