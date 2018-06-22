package com.aek.ebey.assets.service.impl;

import com.aek.ebey.assets.mapper.AssArchiveFolderAttachmentMapper;
import com.aek.ebey.assets.model.AssArchiveFolderAttachment;
import com.aek.ebey.assets.service.AssArchiveFolderAttachmentService;
import com.aek.common.core.base.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 资产档案文件夹附件表 服务实现类
 * </p>
 *
 * @author cyl
 * @since 2018-04-27
 */
@Service
@Transactional
public class AssArchiveFolderAttachmentServiceImpl extends BaseServiceImpl<AssArchiveFolderAttachmentMapper,AssArchiveFolderAttachment> implements AssArchiveFolderAttachmentService {
	
}
