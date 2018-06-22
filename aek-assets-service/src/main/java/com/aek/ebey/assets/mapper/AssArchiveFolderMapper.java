package com.aek.ebey.assets.mapper;

import com.aek.ebey.assets.model.AssArchiveFolder;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.aek.common.core.base.BaseMapper;

/**
 * <p>
 * Mapper接口
 * </p>
 *
 * @author cyl
 * @since 2018-04-27
 */
public interface AssArchiveFolderMapper extends BaseMapper<AssArchiveFolder> {

	/**
	 * 获取档案文件管理列表
	 * @param archiveId
	 * @param assetsId
	 * @return
	 */
	List<AssArchiveFolder> getFolder(@Param("archiveId")Long archiveId, @Param("assetsId")Long assetsId);
}