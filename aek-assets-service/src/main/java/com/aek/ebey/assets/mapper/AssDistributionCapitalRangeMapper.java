package com.aek.ebey.assets.mapper;

import com.aek.ebey.assets.model.AssDistributionCapitalRange;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.aek.common.core.base.BaseMapper;

/**
 * <p>
 * Mapper接口
 * </p>
 *
 * @author cyl
 * @since 2018-04-18
 */
public interface AssDistributionCapitalRangeMapper extends BaseMapper<AssDistributionCapitalRange> {

	/**
	 * 按机构id查询资产资金分布统计范围
	 * @param tenantId
	 * @return
	 */
	List<AssDistributionCapitalRange> selectByTenantId(@Param("tenantId")Long tenantId);
	
	/**
	 * 查询默认资产资金分布统计范围
	 * @return
	 */
	List<AssDistributionCapitalRange> selectDefault();
}