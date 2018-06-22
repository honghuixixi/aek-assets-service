package com.aek.ebey.assets.service;

import java.util.List;
import java.util.Map;

import com.aek.common.core.base.BaseService;
import com.aek.ebey.assets.model.AssetsInfoExt;

/**
 * <p>
 * 资产信息表扩展表 服务类
 * </p>
 *
 * @author aek
 * @since 2017-04-13
 */
public interface AssetsInfoExtService extends BaseService<AssetsInfoExt> {

	void updateFactoryName(Map<String, Object> params);
    
	/**
	 * 根据资产ids集合更新pm_plan_flag状态为在计划中
	 * @param assetsIds
	 */
	void updateAssetsPmPlanStatusByIds(List<Long> assetsIds);
}
