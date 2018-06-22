package com.aek.ebey.assets.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import com.aek.common.core.base.BaseMapper;
import com.aek.ebey.assets.model.CodeInfo;

/**
 * <p>
  * 基本代码表 Mapper 接口
 * </p>
 *
 * @author aek
 * @since 2017-04-13
 */
public interface CodeInfoMapper extends BaseMapper<CodeInfo>
{
    
    List<CodeInfo> getCodeList(@Param("key") String key);
    
    @MapKey("id")
    Map<Long, Map<String, String>> findByIds(String ids);
    
    List<CodeInfo> getChildCodeList(@Param("parentCodeId") int parentCodeId);
    
    Long findIdByName(String name);
    
}