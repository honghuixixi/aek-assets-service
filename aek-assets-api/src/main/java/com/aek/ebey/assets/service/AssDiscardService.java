package com.aek.ebey.assets.service;

import com.aek.common.core.base.BaseService;
import com.aek.ebey.assets.core.util.LiuHuiPage;
import com.aek.ebey.assets.model.AssDiscard;
import com.aek.ebey.assets.model.query.AssetsDisApplyQuery;
import com.aek.ebey.assets.model.query.AssetsDisQuery;
import com.aek.ebey.assets.model.request.AssDiscardAddRequest;
import com.aek.ebey.assets.model.request.AssetsDisApplyResponse;
import com.aek.ebey.assets.model.request.AssetsDisResponse;
import com.aek.ebey.assets.model.request.CancelDiscardRequest;
import com.aek.ebey.assets.model.request.DiscardDetail;
import com.aek.ebey.assets.model.request.DiscardReportDetail;
import com.aek.ebey.assets.model.request.VerifyRequest;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author aek
 * @since 2017-12-14
 */
public interface AssDiscardService extends BaseService<AssDiscard> {

	void save(AssDiscardAddRequest request);

	DiscardDetail getAllById(Long id);

	LiuHuiPage<AssetsDisResponse> search(AssetsDisQuery query);

	void update_verify(VerifyRequest request);

	void update_cancel(CancelDiscardRequest request);

	LiuHuiPage<AssetsDisApplyResponse> searchApply(AssetsDisApplyQuery query);

	DiscardReportDetail getReportById(Long id);
	
	Integer statsWaitAudit(Long tenantId);
	
}
