package com.aek.ebey.assets.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.aek.common.core.base.BaseMapper;
import com.aek.ebey.assets.model.AssetsInfoExt;

/**
 * <p>
 * 资产信息表扩展表 Mapper 接口
 * </p>
 *
 * @author aek
 * @since 2017-04-13
 */
public interface AssetsInfoExtMapper extends BaseMapper<AssetsInfoExt> {

	public void updateByAssetsId(AssetsInfoExt PmAssetsInfoExt);

	public AssetsInfoExt selectByAssetsId(Long assetsID);

	public Map<String, Object> findFactoryNum(String factoryNum);// 查看出产编号是否已经存在

	public int findNum(String factoryNum);// 查看出产编号是否已经存在

	public void updateAssetsInfoExtByAssetsInfoId(AssetsInfoExt assetsInfoExt);

	public void updateFactoryName(Map<String, Object> map);

	public void batchInsert(List<AssetsInfoExt> assInfoExts);
	
	public AssetsInfoExt getAssetByAssetId(@Param("assetId")Long assetId);

	public void updateAssetsPmPlanStatusByIds(@Param("assetsIds") List<Long> assetsIds);
	
	/**
	 * 批量更新设备MtPlanFlag
	 * @param assetIds
	 * @param flag
	 */
	public void changeMtPlanFlagBatch(@Param("assetIds")List<Long> assetIds,@Param("flag")Integer flag);

}