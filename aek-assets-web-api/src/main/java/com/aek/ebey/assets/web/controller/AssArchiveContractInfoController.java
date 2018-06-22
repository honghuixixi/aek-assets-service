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
import com.aek.ebey.assets.model.vo.ArchiveContractInfoVo;
import com.aek.ebey.assets.service.AssArchiveContractInfoService;
import com.aek.ebey.assets.web.request.ArchiveContractInfoRequest;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

/**
 * <p>
 * 资产档案合同信息表  前端控制器
 * </p>
 *
 * @author cyl
 * @since 2018-04-27
 */
@RestController
@RequestMapping("/assets/assArchiveContractInfo")
public class AssArchiveContractInfoController extends BaseController {
	
	@Autowired
	private AssArchiveContractInfoService assArchiveContractInfoService;
	
	@PreAuthorize("hasAuthority('ARCHIVE_RECORD_VIEW')")
	@ApiOperation(value = "获取档案管理合同信息", httpMethod = "GET")
	@ApiResponse(code = 0, message = "OK", response = Result.class)
	@RequestMapping(value = "/getContract", method = RequestMethod.GET)
	public Result<ArchiveContractInfoVo> getContract(@RequestParam("archiveId") Long archiveId,
			@RequestParam("assetsId") Long assetsId) {
		return response(assArchiveContractInfoService.getContract(archiveId,assetsId));
	}
	
	@PreAuthorize("hasAuthority('ARCHIVE_RECORD_VIEW')")
	@ApiOperation(value = "编辑档案管理合同信息", httpMethod = "POST")
	@ApiResponse(code = 0, message = "OK", response = Result.class)
	@RequestMapping(value = "/editContract", method = RequestMethod.POST)
	public Result<Object> editContract(@RequestBody ArchiveContractInfoRequest request) {
		AssArchiveContractInfo contract = BeanMapper.map(request, AssArchiveContractInfo.class);
		String invoiceNo = request.getInvoiceNo();
		List<AssArchiveContractInfoAttachment> attachments = request.getAttachments();
		assArchiveContractInfoService.editContract(contract,invoiceNo,attachments);
		return response();
	}
}
