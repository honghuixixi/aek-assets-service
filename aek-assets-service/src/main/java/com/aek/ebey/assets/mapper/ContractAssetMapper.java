package com.aek.ebey.assets.mapper;

import org.apache.ibatis.annotations.Param;

import com.aek.common.core.base.BaseMapper;
import com.aek.ebey.assets.model.ContractAsset;

/**
 * <p>
  * 设备合同关联 Mapper 接口
 * </p>
 *
 * @author aek
 * @since 2017-04-13
 */
public interface ContractAssetMapper extends BaseMapper<ContractAsset> {

	/**
	 * 获取资产合同
	 * @param assetsId
	 * @return
	 */
	ContractAsset getContractAssetByAssetsId(@Param("assetsId")Long assetsId);
}