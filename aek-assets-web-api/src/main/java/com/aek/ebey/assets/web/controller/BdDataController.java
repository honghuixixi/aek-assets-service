package com.aek.ebey.assets.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aek.common.core.BeanMapper;
import com.aek.common.core.Result;
import com.aek.common.core.base.BaseController;
import com.aek.ebey.assets.model.CodeInfo;
import com.aek.ebey.assets.service.CodeInfoService;
import com.aek.ebey.assets.web.request.CodeInfoResponse;
import com.alibaba.fastjson.JSON;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

/**
 * 
 * 基础数据Controller
 */
@RestController
@RequestMapping("/assets/data")
@Api(value = "DataController", description = "基础数据")
public class BdDataController extends BaseController {

	@Autowired
	private CodeInfoService codeInfoService;

	/**
	 * 根据parentType查基础数据列表
	 */
	@RequestMapping(value = "/baseConfig", method = RequestMethod.GET)
	@ApiOperation(value = "根据parentType查基础数据列表", httpMethod = "GET", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "key", value = "{ACCOUNT_BOOK:仓库类型,ACCOUNT_CATEGORY:核算类别,UNIT:单位,FUND_SOURCES:经费来源,MANAGE_LEVEL:管理级别,DEP_TYPE:折旧方法,PURCHASE_TYPE:设备来源,MEASURE_TYPE:计量类别,PURPOSE:用途}", paramType = "query", required = true) })
	@ApiResponse(code = 0, message = "OK", response = Result.class)
	public Result<List<CodeInfoResponse>> baseConfig(String key) {
		List<CodeInfo> list = codeInfoService.getCodeList(key);
		return response(BeanMapper.mapList(list, CodeInfoResponse.class));
	}

	/**
	 * 根据parentCode查询子的基础数据列表
	 */
	@RequestMapping(value = "/getChildCodeInfo", method = RequestMethod.GET)
	@ApiOperation(value = "根据parentCode查询基础数据列表", httpMethod = "GET", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "parentCodeId", value = "parentCodeId", paramType = "query", required = true) })
	@ApiResponse(code = 0, message = "OK", response = Result.class)
	public Result<List<CodeInfoResponse>> getChildCodeInfo(int parentCodeId) {
		List<CodeInfo> list = codeInfoService.getChildCodeInfo(parentCodeId);
		return response(BeanMapper.mapList(list, CodeInfoResponse.class));
	}

	/**
	 * 根据parentType查询基础数据列表
	 */
	@RequestMapping(value = "/geCodeInfoByType", method = RequestMethod.GET)
	@ApiOperation(value = "根据parentType查询基础数据列表", httpMethod = "GET")
	@ApiResponse(code = 0, message = "OK", response = Result.class)
	public Result<Map<String,List<CodeInfoResponse>>> geCodeInfoByType(String[] types) {
		logger.debug("types="+JSON.toJSONString(types));
		if(types==null||types.length<=0){
			return response(null);
		}
		Map<String,List<CodeInfoResponse>> map=new HashMap<String,List<CodeInfoResponse>>();
		for (String type : types) {
			List<CodeInfo> list = codeInfoService.getCodeList(type);
			map.put(type, BeanMapper.mapList(list, CodeInfoResponse.class));
		}
		return response(map);
	}

}
