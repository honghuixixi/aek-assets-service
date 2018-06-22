package com.aek.ebey.assets.service.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aek.common.core.base.BaseServiceImpl;
import com.aek.ebey.assets.mapper.CodeInfoMapper;
import com.aek.ebey.assets.model.CodeInfo;
import com.aek.ebey.assets.service.CodeInfoService;

/**
 * 基本代码表 服务实现类
 */
@Service
@Transactional
public class CodeInfoServiceImpl extends BaseServiceImpl<CodeInfoMapper, CodeInfo> implements CodeInfoService {
	@Autowired
	private CodeInfoMapper codeInfoMapper;

	/**
	 * 根据key获取基础数据
	 * 
	 * @param key
	 * @return
	 */
	@Cacheable(value="Assets", key="'Assets:CodeInfoList:'+#p0")
	public List<CodeInfo> getCodeList(String type) {
		return codeInfoMapper.getCodeList(type);
	}

	/**
	 * 根据基础数据类型缓存列表的value:text
	 * @param type
	 * @return value:text
	 */
	@Cacheable(value="Assets", key="'Assets:CodeInfoMap:'+#p0")
	public Map<String, String> getCodeInfoMap(String type) {
		Map<String, String> map = new HashMap<String, String>();
		List<CodeInfo> codeList = codeInfoMapper.getCodeList(type);
		if(codeList!=null&&!codeList.isEmpty()){
			codeList.forEach(e->{
				map.put(e.getCodeValue(), e.getCodeText());
			});
		}
		return map;
	}

	@Override
	@Cacheable(value="Assets", key="'Assets:CodeInfo:'+#p0")
	public CodeInfo selectById(Serializable id) {
		return super.selectById(id);
	}

	@Cacheable(value="Assets", key="'Assets:CodeInfo:'+#p0+':'+#p1")
	public CodeInfo selectByTypeValue(String type, String value) {
		List<CodeInfo> codeList = getCodeList(type);
		if(codeList!=null&&!codeList.isEmpty()){
			for (CodeInfo info : codeList) {
				if(info.getCodeValue().equals(value)){
					return info;
				}
			}
		}
		return null;
	}

	/**
	 * 根据父id查询所有的数据集合
	 */
	@Override
	@Cacheable(value="Assets", key="'Assets:CodeInfoChild:'+#p0")
	public List<CodeInfo> getChildCodeInfo(int parentCodeId) {
		return codeInfoMapper.getChildCodeList(parentCodeId);
	}

}
