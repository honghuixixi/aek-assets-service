package com.aek.ebey.assets.service.impl;

import com.aek.ebey.assets.mapper.AssArchiveContractInfoAttachmentMapper;
import com.aek.ebey.assets.model.AssArchiveContractInfoAttachment;
import com.aek.ebey.assets.service.AssArchiveContractInfoAttachmentService;
import com.aek.common.core.base.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 资产档案合同信息附件表 服务实现类
 * </p>
 *
 * @author cyl
 * @since 2018-04-27
 */
@Service
@Transactional
public class AssArchiveContractInfoAttachmentServiceImpl extends BaseServiceImpl<AssArchiveContractInfoAttachmentMapper,AssArchiveContractInfoAttachment> implements AssArchiveContractInfoAttachmentService {
	
}
