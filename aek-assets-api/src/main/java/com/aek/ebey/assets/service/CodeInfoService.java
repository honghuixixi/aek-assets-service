package com.aek.ebey.assets.service;

import java.util.List;
import java.util.Map;

import com.aek.common.core.base.BaseService;
import com.aek.ebey.assets.model.CodeInfo;

/**
 * <p>
 * 基本代码表 服务类
 * </p>
 *
 * @author aek
 * @since 2017-04-13
 */
public interface CodeInfoService extends BaseService<CodeInfo> {
	/**
	 * 根据type查询基础数据
	 */
	public List<CodeInfo> getCodeList(String type);

	/**
	 * 根据基础数据类型缓存列表的value:text
	 * @param type
	 * @return value:text
	 */
	Map<String, String> getCodeInfoMap(String type);

	/**
	 * 根据类型和值查出某一条基础数据
	 * @param type
	 * @param value
	 * @return
	 */
	CodeInfo selectByTypeValue(String type, String value);

	/**
	 * 查询子列表
	 */
	public List<CodeInfo> getChildCodeInfo(int parentCodeId);
}
