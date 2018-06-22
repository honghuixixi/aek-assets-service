package com.aek.ebey.assets.service;

import com.aek.ebey.assets.model.AssArchiveFolder;
import com.aek.ebey.assets.model.AssArchiveFolderAttachment;
import com.aek.ebey.assets.model.vo.ArchiveFolderDetailVo;

import java.util.List;

import com.aek.common.core.base.BaseService;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author cyl
 * @since 2018-04-27
 */
public interface AssArchiveFolderService extends BaseService<AssArchiveFolder> {
	
	/**
	 * 获取档案文件管理列表
	 * @param archiveId
	 * @param assetsId
	 * @return
	 */
	List<AssArchiveFolder> getFolder(Long archiveId,Long assetsId);
	
	void addFolder(AssArchiveFolder folder,List<AssArchiveFolderAttachment> attachments);
	
	void editFolder(AssArchiveFolder folder,List<AssArchiveFolderAttachment> attachments);
	
	void deleteFolder(Long id);
	
	ArchiveFolderDetailVo getFolderDetail(Long id);
}
