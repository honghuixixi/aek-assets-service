package com.aek.ebey.assets.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aek.common.core.BeanMapper;
import com.aek.common.core.Result;
import com.aek.common.core.base.BaseController;
import com.aek.common.core.exception.ExceptionFactory;
import com.aek.common.core.serurity.JwtTokenUtil;
import com.aek.common.core.serurity.WebSecurityUtils;
import com.aek.common.core.serurity.model.TokenInfo;
import com.aek.ebey.assets.constant.SysConstant;
import com.aek.ebey.assets.core.util.CommonUtils;
import com.aek.ebey.assets.model.AssAssetsInfoOperate;
import com.aek.ebey.assets.model.AssetsInfo;
import com.aek.ebey.assets.model.AssetsInfoExt;
import com.aek.ebey.assets.model.AssetsVerfyStatus;
import com.aek.ebey.assets.model.Contract;
import com.aek.ebey.assets.model.query.AssertQuery;
import com.aek.ebey.assets.model.request.EditAssetsInfoRequest;
import com.aek.ebey.assets.model.request.PreAssetsInfoRequest;
import com.aek.ebey.assets.service.AssAssetsInfoOperateService;
import com.aek.ebey.assets.service.AssetsInfoExtService;
import com.aek.ebey.assets.service.AssetsInfoService;
import com.aek.ebey.assets.web.request.AssetsInfoReponse;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;

/**
 * 
 * 预台账控制层
 */
@RestController
@Api(value = "PreAssetsInfoController", description = "预台账")
@RequestMapping("/assets/preAssetsInfo")
public class PreAssetsInfoController extends BaseController {

	@Autowired
	private AssetsInfoService assetsInfoService;
	
	@Autowired
	private AssetsInfoExtService assetsInfoExtService;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	private AssAssetsInfoOperateService assAssetsInfoOperateService;

	/**
	 * @return 根据tenantid统计资产数跟维修数
	 */
	@PreAuthorize("hasAuthority('ASS_PREASSETS_NEW')")
	@ApiOperation(value = "新建预台帐")
	@ApiResponse(code = 0, message = "OK", response = Result.class)
	@RequestMapping(value = "/addPreAssets", method = RequestMethod.POST)
	public Result<Object> addPreAssets(@RequestBody PreAssetsInfoRequest data) {
		logger.debug(JSON.toJSONString(data));
		if(data.getDeptId()==null){
			throw ExceptionFactory.create("A_015");
		}
		assetsInfoService.addPreAssetsInfo(data);
		return response();
	}

	@PreAuthorize("hasAuthority('ASS_PREASSETS_EDIT')")
	@ApiOperation(value = "预台账确认", httpMethod = "GET")
	@ApiResponse(code = 0, message = "OK", response = Result.class)
	@RequestMapping(value = "/addConfirm", method = RequestMethod.GET)
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "台账id", paramType = "query", required = true) })
	public Result<Object> addConfirm(Long id) {
		assetsInfoService.addConfirm(id);
		return response();
	}

	/**
	 * 编辑预台账(暂存)
	 */
	@PreAuthorize("hasAuthority('ASS_PREASSETS_EDIT')")
	@ApiOperation(value = "编辑预台账(暂存)", httpMethod = "POST")
	@ApiResponse(code = 0, message = "OK", response = Result.class)
	@RequestMapping(value = "/editAssets", method = RequestMethod.POST)
	public Result<Object> editAssets(@RequestBody EditAssetsInfoRequest request) {
		logger.debug(JSON.toJSONString(request));
		AssetsInfo assetsInfo = BeanMapper.map(request, AssetsInfo.class);
		assetsInfo.setId(request.getAssetsId());
		assetsInfo.setPrice(CommonUtils.fromY2X(assetsInfo.getPriceStr()));
		AssetsInfoExt assetsInfoExt = BeanMapper.map(request, AssetsInfoExt.class);
		Contract contract = BeanMapper.map(request, Contract.class);
		contract.setContractPrice(CommonUtils.fromY2X(contract.getContractPriceStr()));
		assetsInfoService.editPreAssets(assetsInfo, assetsInfoExt,request,contract,null);
		return response();
	}
	/**
	 * 预台账编辑(编辑与提交)
	 */
	@PreAuthorize("hasAuthority('ASS_PREASSETS_EDIT')")
	@ApiOperation(value = "预台账编辑(编辑与提交)", httpMethod = "POST")
	@ApiResponse(code = 0, message = "OK", response = Result.class)
	@RequestMapping(value = "/submitEditAssets", method = RequestMethod.POST)
	public Result<Object> submitEditAssets(@RequestBody EditAssetsInfoRequest request) {
		logger.debug(JSON.toJSONString(request));
		AssetsInfo assetsInfo = BeanMapper.map(request, AssetsInfo.class);
		assetsInfo.setId(request.getAssetsId());
		assetsInfo.setPrice(CommonUtils.fromY2X(assetsInfo.getPriceStr()));
		AssetsInfoExt assetsInfoExt = BeanMapper.map(request, AssetsInfoExt.class);
		Contract contract = BeanMapper.map(request, Contract.class);
		contract.setContractPrice(CommonUtils.fromY2X(contract.getContractPriceStr()));
		assetsInfoService.editPreAssets(assetsInfo, assetsInfoExt,request,contract,"submit");
		return response();
	}
	
	@PreAuthorize("hasAuthority('ASS_PREASSETS_EDIT')")
	@ApiOperation(value = "提交验收预台账", httpMethod = "GET")
	@ApiResponse(code = 0, message = "OK", response = Result.class)
	@RequestMapping(value = "/submitAssets", method = RequestMethod.GET)
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "台账id", paramType = "query", required = true) })
	public Result<Object> submitAssets(Long id) {
		logger.debug(id);
		Wrapper<AssetsInfoExt> wrapper =new EntityWrapper<AssetsInfoExt>();
		wrapper.eq("assets_id", id);
		List<AssetsInfoExt> list=assetsInfoExtService.selectList(wrapper);
		if(list.size()>0){
			AssetsInfoExt assetsInfoExt=list.get(0);
			if(assetsInfoExt.getVerfyStatus()!=SysConstant.VERFY_STATUS_0){
				throw ExceptionFactory.create("A_010");
			}
			assetsInfoExt.setVerfyStatus(SysConstant.VERFY_STATUS_1);
			assetsInfoExtService.updateById(assetsInfoExt);
			return response();
		}else{
			throw ExceptionFactory.create("A_011");
		}
		
	}
	
	/**
	 * 
	 * @param request
	 * @return更新设备名称
	 */
	@ApiOperation(value = "更新设备名称{ 'assetssId': 1,'assetsName': 1}")
	@ApiResponse(code = 0, message = "OK", response = Result.class)
	@RequestMapping(value = "/updateAssetsName", method = RequestMethod.POST)
	public Result<Object> updateAssetsName(@RequestBody Map<String,Object> params) {
		logger.debug(JSON.toJSONString(params));
		assetsInfoService.updateAssetsName(params);
		return response();
	}
	
	/**
	 * 
	 * @param request
	 * @return 更新设备生产商
	 */
	@ApiOperation(value = "更新设备生产商{ 'assetssId': 1,'factoryName': 1}")
	@ApiResponse(code = 0, message = "OK", response = Result.class)
	@RequestMapping(value = "/updateFactoryName", method = RequestMethod.POST)
	public Result<Object> updateFactoryName(@RequestBody Map<String,Object> params) {
		logger.debug(JSON.toJSONString(params));
		assetsInfoExtService.updateFactoryName(params);
		return response();
	}
	/**
	 * 预台账列表查询
	 */
	@PreAuthorize("hasAuthority('ASS_PREASSETS_LIST_VIEW')")
	@RequestMapping(value = "/getAssetsPage", method = RequestMethod.GET)
	@ApiOperation(value = "预台账列表查询", httpMethod = "GET", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiImplicitParams({ @ApiImplicitParam(name = "status", value = "状态", paramType = "query"),
			@ApiImplicitParam(name = "deptId", value = "科室", paramType = "query"),
			@ApiImplicitParam(name = "page.current", value = "当前页", paramType = "query", required = true),
			@ApiImplicitParam(name = "page.size", value = "每页数量", paramType = "query", required = true),
			@ApiImplicitParam(name = "sort", value = "排序 1:默认排序 2：状态排序", paramType = "query"),
			@ApiImplicitParam(name = "keyword", value = "关键字", paramType = "query") })
	@ApiResponse(code = 0, message = "OK", response = Result.class)
	public Result<Page<AssetsInfoReponse>> getAssetsPage(@ApiParam(hidden = true) AssertQuery query) {
		logger.debug(JSON.toJSONString(query));
		String token = WebSecurityUtils.getCurrentToken();
		TokenInfo tokenInfo = jwtTokenUtil.getTokenInfo(token);
		query.setTenantId(tokenInfo.getTenantId());
		// 获取数据权限
		query.setDataScope(WebSecurityUtils.getCurrentUser().getDataScope());
		Page page = this.assetsInfoService.getAssetsPage(query.getPage(), query);
		List<AssetsInfoReponse> list = BeanMapper.mapList(page.getRecords(), AssetsInfoReponse.class);
		page.setRecords(list);
		return response(page);
	}

	/**
	 * 预台账验收（验收通过、验收不通过）
	 */
	@PreAuthorize("hasAuthority('ASS_PREASSETS_VERIFY')")
	@ApiOperation(value = "预台账验收", httpMethod = "GET")
	@ApiResponse(code = 0, message = "OK", response = Result.class)
	@RequestMapping(value = "/verify", method = RequestMethod.GET)
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "台账id", paramType = "query", required = true),
			@ApiImplicitParam(name = "verifyStatus", value = "状态 (2:通过 3:不通过)", paramType = "query", required = true),
			@ApiImplicitParam(name = "verifyDate", value = "验收日期", paramType = "query", required = true),
			@ApiImplicitParam(name = "verifyRemark", value = "验收说明", paramType = "query") })
	public Result<Object> verify(Long id, Long verifyDate, String verifyRemark, String verifyStatus) {
		if(verifyRemark.length()>300){
			throw ExceptionFactory.create("A_013");
		}
		assetsInfoService.verify(id, verifyDate, verifyRemark, verifyStatus);
		return response();
	}

	

	/**
	 * 预台账状态数量查询
	 */
	@PreAuthorize("isAuthenticated()")
	@ApiOperation(value = "验收状态数量查询", httpMethod = "GET")
	@ApiResponse(code = 0, message = "OK", response = Result.class)
	@RequestMapping(value = "/getStatusTotalNum", method = RequestMethod.GET)
	public Result<AssetsVerfyStatus> checkStatus() {
		String token = WebSecurityUtils.getCurrentToken();
		TokenInfo tokenInfo = jwtTokenUtil.getTokenInfo(token);
		AssetsVerfyStatus pm = assetsInfoService.getStatusNum(tokenInfo.getTenantId());
		return response(pm);
	}

	@PreAuthorize("hasAuthority('ASS_PREASSETS_EDIT')")
	@ApiOperation(value = "删除预台账", httpMethod = "GET")
	@ApiResponse(code = 0, message = "OK", response = Result.class)
	@RequestMapping(value = "/delAssets", method = RequestMethod.GET)
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "台账id", paramType = "query", required = true) })
	public Result<Object> delAssets(Long id) {
		assetsInfoService.delAssets(id);
		return response();
	}
	
	@PreAuthorize("hasAuthority('ASS_PREASSETS_EDIT')")
	@ApiOperation(value = "预台账重新编辑", httpMethod = "GET")
	@ApiResponse(code = 0, message = "OK", response = Result.class)
	@RequestMapping(value = "/reEdit", method = RequestMethod.GET)
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "台账id", paramType = "query", required = true) })
	public Result<Object> reEdit(Long id) {
		Map<String, Object> columnMap=new HashMap<>();
		columnMap.put("assets_id", id);
		List<AssetsInfoExt> list=assetsInfoExtService.selectByMap(columnMap);
		if(list!=null&&list.size()>0){
			AssetsInfoExt assetsInfoExt=list.get(0);
				if(assetsInfoExt.getVerfyStatus()==SysConstant.VERFY_STATUS_3){
					assetsInfoExt.setVerfyStatus(SysConstant.VERFY_STATUS_0);
					assetsInfoExtService.updateById(assetsInfoExt);
					return response();
				}else{
					throw ExceptionFactory.create("A_010");
				}
		}
		else{
			throw ExceptionFactory.create("A_011");
		}
		
	}
	
	@ApiOperation(value = "得到预台帐操作记录", httpMethod = "GET")
	@ApiResponse(code = 0, message = "OK", response = Result.class)
	@RequestMapping(value = "/getOperateByid", method = RequestMethod.GET)
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "台账id", paramType = "query", required = true) })
	public Result<List<AssAssetsInfoOperate>> getOperateByid(Long id) {
		logger.debug(id);
		Wrapper<AssAssetsInfoOperate> wrapper=new EntityWrapper<AssAssetsInfoOperate>();
		wrapper.eq("assets_id", id);
		List<AssAssetsInfoOperate>list=assAssetsInfoOperateService.selectList(wrapper);
		assetsInfoService.getList(list);
		return response(list);
	}
	
	
	
	@PreAuthorize("hasAuthority('ASS_PREASSETS_EDIT')")
	@ApiOperation(value = "预台账转化为台帐", httpMethod = "GET")
	@ApiResponse(code = 0, message = "OK", response = Result.class)
	@RequestMapping(value = "/toAssets", method = RequestMethod.GET)
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "预台账id", paramType = "query", required = true) })
	public Result<Object> toAssets(Long id) {
		AssetsInfo  assetsInfo=assetsInfoService.selectById(id);
		if(assetsInfo!=null){
			if(assetsInfo.getAssetsStatus().intValue()==2){
				assetsInfo.setAssetsStatus(1);
				assetsInfo.setAssetsSource(0);
				assetsInfo.setStatus(2);
				assetsInfoService.updateById(assetsInfo);
				return response();
			}else{
				throw ExceptionFactory.create("A_016");
			}
			
		}else{
			throw ExceptionFactory.create("A_011");
		}
	}
	
	
	
}
