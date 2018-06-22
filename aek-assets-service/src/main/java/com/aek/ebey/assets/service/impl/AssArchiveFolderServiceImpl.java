package com.aek.ebey.assets.service.impl;

import com.aek.ebey.assets.mapper.AssArchiveFolderAttachmentMapper;
import com.aek.ebey.assets.mapper.AssArchiveFolderMapper;
import com.aek.ebey.assets.model.AssArchiveFolder;
import com.aek.ebey.assets.model.AssArchiveFolderAttachment;
import com.aek.ebey.assets.model.vo.ArchiveFolderDetailVo;
import com.aek.ebey.assets.service.AssArchiveFolderAttachmentService;
import com.aek.ebey.assets.service.AssArchiveFolderService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.aek.common.core.BeanMapper;
import com.aek.common.core.base.BaseServiceImpl;
import com.aek.common.core.exception.ExceptionFactory;
import com.aek.common.core.serurity.WebSecurityUtils;
import com.aek.common.core.serurity.model.AuthUser;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 资产档案文件夹表 服务实现类
 * </p>
 *
 * @author cyl
 * @since 2018-04-27
 */
@Service
@Transactional
public class AssArchiveFolderServiceImpl extends BaseServiceImpl<AssArchiveFolderMapper,AssArchiveFolder> implements AssArchiveFolderService {

	@Autowired
	private AssArchiveFolderMapper assArchiveFolderMapper;
	@Autowired
	private AssArchiveFolderAttachmentService assArchiveFolderAttachmentService;
	@Autowired
	private AssArchiveFolderAttachmentMapper assArchiveFolderAttachmentMapper;
	
	@Override
	public List<AssArchiveFolder> getFolder(Long archiveId, Long assetsId) {
		List<AssArchiveFolder> folder = assArchiveFolderMapper.getFolder(archiveId, assetsId);
		return folder;
	}

	@Override
	public void addFolder(AssArchiveFolder folder, List<AssArchiveFolderAttachment> attachments) {
		Wrapper<AssArchiveFolder> wrapper = new EntityWrapper<AssArchiveFolder>();
		wrapper.eq("archive_id", folder.getArchiveId()).eq("assets_id", folder.getAssetsId()).eq("folder_name", folder.getFolderName());
		int n = assArchiveFolderMapper.selectCount(wrapper);
		if(n>0)throw ExceptionFactory.create("AR_004");
		
		AuthUser currentUser = WebSecurityUtils.getCurrentUser();
		Long currentUserId = currentUser.getId();
		Date now = new Date();
		folder.setCreateBy(currentUserId);
		folder.setCreateTime(now);
		folder.setUpdateBy(currentUserId);
		folder.setUpdateTime(now);
		folder.setFileNum(attachments.size());
		assArchiveFolderMapper.insert(folder);
		
		if(attachments!=null&&attachments.size()>0){
			for (AssArchiveFolderAttachment at : attachments) {
				at.setCreateTime(now);
				at.setFolderId(folder.getId());
			}
			assArchiveFolderAttachmentService.insertBatch(attachments);
		}
	}

	@Override
	public void editFolder(AssArchiveFolder folder, List<AssArchiveFolderAttachment> attachments) {
		Long id = folder.getId();
		AssArchiveFolder folderDb = assArchiveFolderMapper.selectById(id);
		if(folderDb==null)throw ExceptionFactory.create("AR_005");
		String folderName = folderDb.getFolderName();
		if(!folderName.equals(folder.getFolderName())){
			Wrapper<AssArchiveFolder> wrapper = new EntityWrapper<AssArchiveFolder>();
			wrapper.eq("archive_id", folder.getArchiveId()).eq("assets_id", folder.getAssetsId()).eq("folder_name", folder.getFolderName());
			int n = assArchiveFolderMapper.selectCount(wrapper);
			if(n>0)throw ExceptionFactory.create("AR_004");
		}
		AuthUser currentUser = WebSecurityUtils.getCurrentUser();
		Long currentUserId = currentUser.getId();
		Date now = new Date();
		folder.setUpdateBy(currentUserId);
		folder.setUpdateTime(now);
		folder.setFileNum(attachments.size());
		assArchiveFolderMapper.updateById(folder);
		
		//update table "ass_archive_folder_attachment"
		Wrapper<AssArchiveFolderAttachment> wrapper2 = new EntityWrapper<AssArchiveFolderAttachment>();
		wrapper2.eq("folder_id", folder.getId());
		assArchiveFolderAttachmentMapper.delete(wrapper2);
		if(attachments!=null&&attachments.size()>0){
			for (AssArchiveFolderAttachment at : attachments) {
				at.setCreateTime(now);
				at.setFolderId(folder.getId());
			}
			assArchiveFolderAttachmentService.insertBatch(attachments);
		}
	}
	
	@Override
	public void deleteFolder(Long id) {
		AssArchiveFolder folderDb = assArchiveFolderMapper.selectById(id);
		if(folderDb==null)throw ExceptionFactory.create("AR_012");
		int n = assArchiveFolderMapper.deleteById(id);
		if(n>0){
			Wrapper<AssArchiveFolderAttachment> wrapper = new EntityWrapper<AssArchiveFolderAttachment>();
			wrapper.eq("folder_id", id);
			assArchiveFolderAttachmentMapper.delete(wrapper);
		}
		
	}

	@Override
	public ArchiveFolderDetailVo getFolderDetail(Long id) {
		AssArchiveFolder folderDb = assArchiveFolderMapper.selectById(id);
		if(folderDb==null)return null;
		ArchiveFolderDetailVo folderDetailVo = BeanMapper.map(folderDb, ArchiveFolderDetailVo.class);
		Wrapper<AssArchiveFolderAttachment> wrapper = new EntityWrapper<AssArchiveFolderAttachment>();
		wrapper.eq("folder_id", id);
		List<AssArchiveFolderAttachment> attachments = assArchiveFolderAttachmentMapper.selectList(wrapper);
		folderDetailVo.setAttachment(attachments);
		return folderDetailVo;
	}

	
	
}
