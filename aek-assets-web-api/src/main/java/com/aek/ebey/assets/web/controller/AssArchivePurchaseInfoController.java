package com.aek.ebey.assets.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aek.common.core.BeanMapper;
import com.aek.common.core.Result;
import com.aek.common.core.base.BaseController;
import com.aek.ebey.assets.model.AssArchiveContractInfo;
import com.aek.ebey.assets.model.AssArchiveContractInfoAttachment;
import com.aek.ebey.assets.model.AssArchivePurchaseInfo;
import com.aek.ebey.assets.model.AssArchivePurchaseInfoAttachment;
import com.aek.ebey.assets.model.AssArchivePurchaseInfoFundSources;
import com.aek.ebey.assets.model.vo.AssArchivePurchaseInfoVo;
import com.aek.ebey.assets.service.AssArchivePurchaseInfoService;
import com.aek.ebey.assets.web.request.ArchiveContractInfoRequest;
import com.aek.ebey.assets.web.request.AssArchivePurchaseInfoRequest;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

/**
 * <p>
 * 资产档案采购信息表  前端控制器
 * </p>
 *
 * @author cyl
 * @since 2018-04-28
 */
@RestController
@RequestMapping("/assets/assArchivePurchaseInfo")
public class AssArchivePurchaseInfoController extends BaseController {
	
	@Autowired
	private AssArchivePurchaseInfoService assArchivePurchaseInfoService;
	
	@PreAuthorize("hasAuthority('ARCHIVE_RECORD_VIEW')")
	@ApiOperation(value = "编辑档案管理采购信息", httpMethod = "POST")
	@ApiResponse(code = 0, message = "OK", response = Result.class)
	@RequestMapping(value = "/editPurchase", method = RequestMethod.POST)
	public Result<Object> editPurchase(@RequestBody AssArchivePurchaseInfoRequest request) {
		AssArchivePurchaseInfo purchase = BeanMapper.map(request, AssArchivePurchaseInfo.class);
		List<AssArchivePurchaseInfoAttachment> acceptAttachments = request.getAcceptAttachments();
		List<AssArchivePurchaseInfoAttachment> bidAttachments = request.getBidAttachments();
		List<AssArchivePurchaseInfoFundSources> listFundSources = request.getListFundSources();
		assArchivePurchaseInfoService.editPurchase(purchase,acceptAttachments,bidAttachments,listFundSources);
		return response();
	}
	
	@PreAuthorize("hasAuthority('ARCHIVE_RECORD_VIEW')")
	@ApiOperation(value = "获取档案管理采购信息", httpMethod = "GET")
	@ApiResponse(code = 0, message = "OK", response = Result.class)
	@RequestMapping(value = "/getPurchase", method = RequestMethod.GET)
	public Result<AssArchivePurchaseInfoVo> getPurchase(@RequestParam("archiveId")Long archiveId,
			@RequestParam("assetsId")Long assetsId) {
		return response(assArchivePurchaseInfoService.getPurchase(archiveId,assetsId));
	}
}
