package com.aek.ebey.assets.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aek.common.core.Result;
import com.aek.common.core.base.BaseController;
import com.aek.ebey.assets.model.AssAssetsTransfer;
import com.aek.ebey.assets.model.TransferPage;
import com.aek.ebey.assets.model.query.TransferQuery;
import com.aek.ebey.assets.model.request.AssAssetsTransferAuditRequest;
import com.aek.ebey.assets.model.request.AssAssetsTransferRequest;
import com.aek.ebey.assets.model.vo.TransferPrintVo;
import com.aek.ebey.assets.model.vo.TransferVo;
import com.aek.ebey.assets.service.AssAssetsTransferService;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.plugins.Page;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

/**
 * <p>
 * 资产转科表  前端控制器
 * </p>
 *
 * @author cyl
 * @since 2017-12-11
 */
@RestController
@Api(value = "AssAssetsTransferController", description = "转科管理")
@RequestMapping("/assets/assAssetsTransfer")
public class AssAssetsTransferController extends BaseController {
	@Autowired
	private AssAssetsTransferService assetsTransferService;
	
	@PreAuthorize("hasAuthority('ASS_ASSETS_ZK_APPLY')")
	@ApiOperation(value = "新建转科单",httpMethod = "POST", produces = "application/json")
	@ApiResponse(code = 0, message = "OK", response = Result.class)
	@RequestMapping(value = "/addTransfer", method = RequestMethod.POST)
	public Result<Object> addTransfer(@RequestBody AssAssetsTransferRequest req){
		logger.debug(JSON.toJSONString(req));
		assetsTransferService.addTransfer(req);
		return response(); 
	}
	
	@PreAuthorize("hasAuthority('ASS_ASSETS_ZK_LIST')")
	@ApiOperation(value = "查看转科单",httpMethod = "GET", produces = "application/json")
	@ApiResponse(code = 0, message = "OK", response = Result.class)
	@RequestMapping(value = "/getTransfer", method = RequestMethod.GET)
	public Result<TransferVo> addTransfer(@RequestParam(value="id")Long id,
			@RequestParam(value="status")Integer status){
		logger.debug(JSON.toJSONString(id+"-------------"+status));
		TransferVo transferVo = assetsTransferService.getTransfer(id,status);
		return response(transferVo); 
	}
	
	@PreAuthorize("hasAuthority('ASS_ASSETS_ZK_CHECK')")
	@ApiOperation(value = "审核设备",httpMethod = "GET", produces = "application/json")
	@ApiResponse(code = 0, message = "OK", response = Result.class)
	@RequestMapping(value = "/cancleAsset", method = RequestMethod.GET)
	public Result<Object> cancleAsset(@RequestParam(value="assetsId")Long assetsId,@RequestParam(value="id")Long id){
		logger.debug(JSON.toJSONString(id+"------------"+assetsId));
		assetsTransferService.cancleAsset(id,assetsId);
		return response(); 
	}
	
	@PreAuthorize("hasAuthority('ASS_ASSETS_ZK_CHECK')")
	@ApiOperation(value = "提交转科审核",httpMethod = "POST", produces = "application/json")
	@ApiResponse(code = 0, message = "OK", response = Result.class)
	@RequestMapping(value = "/auditTransfer", method = RequestMethod.POST)
	public Result<Object> auditTransfer(@RequestBody AssAssetsTransferAuditRequest req){
		assetsTransferService.auditTransfer(req);
		return response(); 
	}
	
	@PreAuthorize("hasAuthority('ASS_ASSETS_ZK_LIST')")
	@ApiOperation(value = "查询转科报告单",httpMethod = "GET", produces = "application/json")
	@ApiResponse(code = 0, message = "OK", response = Result.class)
	@RequestMapping(value = "/getTransferPrint", method = RequestMethod.GET)
	public Result<TransferPrintVo> getTransferPrint(@RequestParam(value="id")Long id){
		return response(assetsTransferService.getTransferPrint(id));
	}
	
	@PreAuthorize("hasAuthority('ASS_ASSETS_ZK_LIST')")
	@ApiOperation(value = "查看转科单列表",httpMethod = "GET", produces = "application/json")
	@ApiImplicitParams({ 
		@ApiImplicitParam(name = "scope", value = "转科单范围 (取值：1：全部2：我的申请)", paramType = "query"),
		@ApiImplicitParam(name = "status", value = "转科单状态 (取值：0:全部1:审核通过2:待审3:审核未通过)", paramType = "query"),
		@ApiImplicitParam(name = "deptId", value = "所在科室id", paramType = "query"),
		@ApiImplicitParam(name = "keyword", value = "关键字(转科单号/设备名称)", paramType = "query"),
		@ApiImplicitParam(name = "page.current", value = "当前页", paramType = "query", required = true),
		@ApiImplicitParam(name = "page.size", value = "每页数量", paramType = "query", required = true) })
	@ApiResponse(code = 0, message = "OK", response = Result.class)
	@RequestMapping(value = "/getTransferPageList", method = RequestMethod.GET)
	public Result<Page<TransferPage>> getTransferPage(TransferQuery query){
		logger.debug(JSON.toJSONString(query));
		Page<TransferPage> transferPage = assetsTransferService.getTransferPage(query);
		return response(transferPage);
	}

	/**
	 * 根据本机构id统计待审核转科单数目
	 * @param tenantId
	 * @return
	 */
	@PreAuthorize("hasAuthority('ASS_ASSETS_ZK_CHECK')")
	@ApiOperation(value = "根据本机构id统计待审核转科单数目",httpMethod = "GET", produces = "application/json")
	@ApiImplicitParam(name = "tenantId", value = "本机构id")
	@ApiResponse(code = 0, message = "OK", response = Result.class)
	@RequestMapping(value="/statsWaitAudit",method=RequestMethod.GET)
	public Result<Integer> statsWaitAudit(@RequestParam("tenantId")Long tenantId){
		return response(assetsTransferService.statsWaitAudit(tenantId));
	}
}
