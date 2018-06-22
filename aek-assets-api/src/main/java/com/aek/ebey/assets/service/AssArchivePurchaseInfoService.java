package com.aek.ebey.assets.service;

import com.aek.ebey.assets.model.AssArchivePurchaseInfo;
import com.aek.ebey.assets.model.AssArchivePurchaseInfoAttachment;
import com.aek.ebey.assets.model.AssArchivePurchaseInfoFundSources;
import com.aek.ebey.assets.model.vo.AssArchivePurchaseInfoVo;

import java.util.List;

import com.aek.common.core.base.BaseService;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author cyl
 * @since 2018-04-28
 */
public interface AssArchivePurchaseInfoService extends BaseService<AssArchivePurchaseInfo> {
	
	void editPurchase(AssArchivePurchaseInfo purchase,
			List<AssArchivePurchaseInfoAttachment> acceptAttachments,
			List<AssArchivePurchaseInfoAttachment> bidAttachments,
			List<AssArchivePurchaseInfoFundSources> listFundSources);
	
	AssArchivePurchaseInfoVo getPurchase(Long archiveId,Long assetsId);
}
