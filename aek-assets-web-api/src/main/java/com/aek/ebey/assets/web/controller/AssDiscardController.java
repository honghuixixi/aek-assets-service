package com.aek.ebey.assets.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aek.common.core.Result;
import com.aek.common.core.base.BaseController;
import com.aek.ebey.assets.core.util.LiuHuiPage;
import com.aek.ebey.assets.model.query.AssetsDisApplyQuery;
import com.aek.ebey.assets.model.query.AssetsDisQuery;
import com.aek.ebey.assets.model.request.AssDiscardAddRequest;
import com.aek.ebey.assets.model.request.AssetsDisApplyResponse;
import com.aek.ebey.assets.model.request.AssetsDisResponse;
import com.aek.ebey.assets.model.request.CancelDiscardRequest;
import com.aek.ebey.assets.model.request.DiscardDetail;
import com.aek.ebey.assets.model.request.DiscardReportDetail;
import com.aek.ebey.assets.model.request.VerifyRequest;
import com.aek.ebey.assets.service.AssDiscardService;
import com.alibaba.fastjson.JSON;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

/**
 * <p>
 * 设备报损单  前端控制器
 * </p>
 *
 * @author aek
 * @since 2017-12-14
 */
@RestController
@RequestMapping("/assets/assDiscard")
public class AssDiscardController extends BaseController {
	
private static final Logger logger = LoggerFactory.getLogger(AssDiscardController.class);
	
	@Autowired
	private AssDiscardService assDiscardService;
	
	
	
	/**
	 * 新建报损申请
	 */
	@PreAuthorize("hasAuthority('ASS_ASSETS_DISCARD_APPLY')")
	@PostMapping(value = "/add")
	@ApiOperation(value = "新建报损申请")
	@ApiResponse(code = 200, message = "OK", response = Result.class)
	public Result<Object> add(@RequestBody AssDiscardAddRequest request){
		logger.debug("<---------------------------------"+JSON.toJSONString(request));
		this.assDiscardService.save(request);
		return response();
	}
	
	/**
	 * 查看待审核报损单详情
	 */
	@PreAuthorize("hasAuthority('ASS_ASSETS_DISCARD_LIST')")
	@GetMapping(value = "/start/{id}")
	@ApiOperation(value = "查看待审核报损单详情")
	@ApiResponse(code = 200, message = "OK", response = Result.class)
	public Result<DiscardDetail> start(@PathVariable Long id) {
		logger.debug("<---------------------------------"+JSON.toJSONString(id));
		DiscardDetail discardDetail=assDiscardService.getAllById(id);
		return response(discardDetail);
		
	}
	
	/**
	 *查询审核后报损单详情
	 */
	@PreAuthorize("hasAuthority('ASS_ASSETS_DISCARD_LIST')")
	@GetMapping(value = "/end/{id}")
	@ApiOperation(value = "查询审核后报损单详情")
	@ApiResponse(code = 200, message = "OK", response = Result.class)
	public Result<DiscardDetail> end(@PathVariable Long id) {
		logger.debug("<---------------------------------"+JSON.toJSONString(id));
		DiscardDetail discardDetail=assDiscardService.getAllById(id);
		return response(discardDetail);
		
	}
	
	/**
	 * 查询报损列表
	 */
	@GetMapping(value = "/search")
	@ApiOperation(value = "查询报损列表")
	@ApiResponse(code = 200, message = "OK", response = Result.class)
	public Result<LiuHuiPage<AssetsDisResponse>> search(AssetsDisQuery query) {
		logger.debug("<---------------------------------"+JSON.toJSONString(query));
		LiuHuiPage<AssetsDisResponse> page = assDiscardService.search(query);
		return response(page);
	}
	
	/**
	 * 提交报损审核
	 */
	@PreAuthorize("hasAuthority('ASS_ASSETS_DISCARD_CHECK')")
	@PostMapping(value = "/verify")
	@ApiOperation(value = "提交报损审核")
	@ApiResponse(code = 200, message = "OK", response = Result.class)
	public Result<Object> update_verify(@RequestBody VerifyRequest request){
		logger.debug("<---------------------------------"+JSON.toJSONString(request));
		this.assDiscardService.update_verify(request);
		return response();
	}
	
	/**
	 * 撤销报损设备
	 */
	@PreAuthorize("hasAuthority('ASS_ASSETS_DISCARD_CHECK')")
	@PostMapping(value = "/cancel")
	@ApiOperation(value = "撤销报损设备")
	@ApiResponse(code = 200, message = "OK", response = Result.class)
	public Result<Object> update_cancel(@RequestBody CancelDiscardRequest request){
		logger.debug("<---------------------------------"+JSON.toJSONString(request));
		this.assDiscardService.update_cancel(request);
		return response();
	}
	
	
	/**
	 * 查看报损单列表
	 */
	@PreAuthorize("hasAuthority('ASS_ASSETS_DISCARD_LIST')")
	@GetMapping(value = "/searchApply")
	@ApiOperation(value = "查看报损单列表")
	@ApiResponse(code = 200, message = "OK", response = Result.class)
	public Result<LiuHuiPage<AssetsDisApplyResponse>> search(AssetsDisApplyQuery query) {
		logger.debug("<---------------------------------"+JSON.toJSONString(query));
		LiuHuiPage<AssetsDisApplyResponse> page = assDiscardService.searchApply(query);
		return response(page);
	}
	
	/**
	 * 查询报损报告单
	 */
	@GetMapping(value = "/{id}")
	@ApiOperation(value = "查询报损报告单")
	@ApiResponse(code = 200, message = "OK", response = Result.class)
	public Result<DiscardReportDetail> getReportById(@PathVariable Long id) {
		logger.debug("<---------------------------------"+JSON.toJSONString(id));
		DiscardReportDetail discardReportDetail=assDiscardService.getReportById(id);
		return response(discardReportDetail);
		
	}
	
	/**
	 * 根据本机构id统计待审核报损单数目
	 * @param tenantId
	 * @return
	 */
	@PreAuthorize("hasAuthority('ASS_ASSETS_DISCARD_CHECK')")
	@GetMapping(value = "/statsWaitAudit")
	@ApiOperation(value = "根据本机构id统计待审核报损单数目",httpMethod = "GET", produces = "application/json")
	@ApiImplicitParam(name = "tenantId", value = "本机构id")
	@ApiResponse(code = 0, message = "OK", response = Result.class)
	public Result<Integer> statsWaitAudit(@RequestParam("tenantId")Long tenantId){	
		return response(assDiscardService.statsWaitAudit(tenantId));
	}
	
	
}
