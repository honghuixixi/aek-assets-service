package com.aek.ebey.assets.web.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aek.common.core.Result;
import com.aek.common.core.base.BaseController;
import com.aek.ebey.assets.model.AssAssetsLog;
import com.aek.ebey.assets.model.AssetsLog;
import com.aek.ebey.assets.model.AssetsLogDetail;
import com.aek.ebey.assets.model.query.AssAssetsLogQuery;
import com.aek.ebey.assets.service.AssAssetsLogService;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.plugins.Page;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

/**
 * <p>
 * 资产台账操作记录日志  前端控制器
 * </p>
 *
 * @author cyl
 * @since 2017-12-25
 */
@RestController
@RequestMapping("/assets/assAssetsLog")
public class AssAssetsLogController extends BaseController {
	@Autowired
	private AssAssetsLogService assAssetsLogService;
	
	@PreAuthorize("hasAuthority('ASS_PREASSETS_DETAILED_VIEW')")
	@ApiOperation(value = "操作记录列表查询",httpMethod = "GET", produces = "application/json")
	@ApiImplicitParams({ 
		@ApiImplicitParam(name = "id", value = "设备id", paramType = "query"),
		@ApiImplicitParam(name = "modelType", value = " 0:全部 1：设备信息 2：采购信息 3：合同信息4：证件管理", paramType = "query"),
		@ApiImplicitParam(name = "startTime", value = "开始时间", paramType = "query"),
		@ApiImplicitParam(name = "endTime", value = "结束时间", paramType = "query"),
		@ApiImplicitParam(name = "page.current", value = "当前页", paramType = "query", required = true),
		@ApiImplicitParam(name = "page.size", value = "每页数量", paramType = "query", required = true) })
	@ApiResponse(code = 0, message = "OK", response = Result.class)
	@RequestMapping(value = "/getLogPage", method = RequestMethod.GET)
	public Result<Page<AssetsLog>> getLogPage(AssAssetsLogQuery query){
		logger.debug(JSON.toJSONString(query));
		Page<AssetsLog> logPage = assAssetsLogService.getLogPage(query);
		return response(logPage);
	}
	
	@PreAuthorize("hasAuthority('ASS_PREASSETS_DETAILED_VIEW')")
	@ApiOperation(value = "操作记录详情",httpMethod = "GET", produces = "application/json")
	@ApiImplicitParam(name = "id", value = "操作记录的id")
	@ApiResponse(code = 0, message = "OK", response = Result.class)
	@RequestMapping(value = "/getLogDetail", method = RequestMethod.GET)
	public Result<AssetsLogDetail> getLogDetail(@RequestParam("id")Long id){
		AssetsLogDetail logDetail = assAssetsLogService.getLogDetail(id);
		return response(logDetail);
	}
}
