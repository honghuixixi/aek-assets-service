package com.aek.ebey.assets.service;

import com.aek.ebey.assets.model.AssArchiveContractInfo;
import com.aek.ebey.assets.model.AssArchiveContractInfoAttachment;
import com.aek.ebey.assets.model.vo.ArchiveContractInfoVo;

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
public interface AssArchiveContractInfoService extends BaseService<AssArchiveContractInfo> {
	
	ArchiveContractInfoVo getContract(Long archiveId,Long assetsId);
	
	void editContract(AssArchiveContractInfo contract,String invoiceNo,List<AssArchiveContractInfoAttachment> attachments);
}
