package com.aek.ebey.assets.service;

import com.aek.ebey.assets.model.AssAssetsTransfer;
import com.aek.ebey.assets.model.TransferPage;
import com.aek.ebey.assets.model.query.TransferQuery;
import com.aek.ebey.assets.model.request.AssAssetsTransferAuditRequest;
import com.aek.ebey.assets.model.request.AssAssetsTransferRequest;
import com.aek.ebey.assets.model.vo.TransferPrintVo;
import com.aek.ebey.assets.model.vo.TransferVo;
import com.baomidou.mybatisplus.plugins.Page;
import com.aek.common.core.base.BaseService;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author aek
 * @since 2017-12-11
 */
public interface AssAssetsTransferService extends BaseService<AssAssetsTransfer> {
	
	public void addTransfer(AssAssetsTransferRequest req);
	
	public TransferVo getTransfer(Long id,Integer status);
	
	public void cancleAsset(Long id,Long assetId);
	
	public void auditTransfer(AssAssetsTransferAuditRequest req);
	
	public TransferPrintVo getTransferPrint(Long id);
	
	public Page<TransferPage> getTransferPage(TransferQuery query);
	
	public Integer statsWaitAudit(Long tenantId);
}
