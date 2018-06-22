package com.aek.ebey.assets.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aek.common.core.BeanMapper;
import com.aek.common.core.Result;
import com.aek.common.core.base.BaseController;
import com.aek.common.core.exception.ExceptionFactory;
import com.aek.ebey.assets.enums.AssetsRepairStatusEnum;
import com.aek.ebey.assets.enums.AssetsStatusEnum;
import com.aek.ebey.assets.model.Assets;
import com.aek.ebey.assets.model.AssetsInfo;
import com.aek.ebey.assets.model.AssetsQc;
import com.aek.ebey.assets.model.MtAssets;
import com.aek.ebey.assets.model.query.MtAssertQuery;
import com.aek.ebey.assets.model.vo.MdAssetsVO;
import com.aek.ebey.assets.service.AssetsInfoExtService;
import com.aek.ebey.assets.service.AssetsInfoService;
import com.aek.ebey.assets.web.request.AssetsInfoDetailReponse;
import com.aek.ebey.assets.web.request.AssetsQcInfoResponse;
import com.aek.ebey.assets.web.request.AssetsStatusResponse;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.plugins.Page;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

/**
 * REST API 服务间调用接口
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
@RestController
@Api(value = "restAPIController", description = "REST API")
@RequestMapping(value = "/assets/restAPI")
public class RestAPIController extends BaseController {
	@Autowired
	private AssetsInfoService assetsInfoService;
	@Autowired
	private AssetsInfoExtService assetsInfoExtService;

	@PreAuthorize("isAuthenticated()")
	@ApiOperation(value = "通过部门ID查询设备信息是否存在", httpMethod = "GET")
	@RequestMapping("deviceQuery")
	@ApiImplicitParam(name = "deptIds", value = "部门ID集合", required = true, paramType = "query")
	public Result<Boolean> deviceQuery(Long[] deptIds) {
		logger.debug("deptIds="+JSON.toJSONString(deptIds));
		return response(assetsInfoService.deviceQuery(deptIds));
	}

	/**
	 * 根据ID更新设备状态及维修状态为正常
	 */
	@ApiOperation(value = "根据ID更新设备状态及维修状态为正常", httpMethod = "GET")
	@ApiResponse(code = 0, message = "OK", response = Result.class)
	@RequestMapping(value = "/updateAssetsInfoById/{id}/{status}", method = RequestMethod.GET)
	public Result<Object> updateAssetsInfoById(@PathVariable("id")  Long id,@PathVariable("status")  Integer status, @RequestParam(value="repairId", required=false)Long repairId) {
		logger.debug("id="+id);
		logger.debug("status="+status);
		logger.debug("repairId="+repairId);
		AssetsInfo assetsInfo=assetsInfoService.selectById(id);
		if(assetsInfo!=null){
			//更新设备状态
			assetsInfo.setStatus(status);
			//更新设备维修状态为正常
			assetsInfo.setRepairStatus(AssetsRepairStatusEnum.NORMAL.getNumber());
			//清空维修单号
			assetsInfo.setRepairId(null);
			assetsInfoService.updateAfterSelect(assetsInfo);
			return response();
		}else{
			throw ExceptionFactory.create("A_006");
		}
	}
	
	/**
	 * 根据ID更新设备维修状态
	 */
	@ApiOperation(value = "根据ID更新设备维修状态", httpMethod = "GET")
	@ApiResponse(code = 0, message = "OK", response = Result.class)
	@RequestMapping(value = "/updateAssetsRepairStatusById/{id}/{repairStatus}", method = RequestMethod.GET)
	public Result<Object> updateAssetsRepairStatusById(@PathVariable("id")  Long id,@PathVariable("repairStatus")  Integer repairStatus, @RequestParam(value="repairId", required=false)Long repairId) {
		logger.debug("id="+id);
		logger.debug("repairStatus="+repairStatus);
		logger.debug("repairId="+repairId);
		AssetsInfo assetsInfo=assetsInfoService.selectById(id);
		if(assetsInfo!=null){
			if(!repairStatus.equals(assetsInfo.getRepairStatus())){
				//更新设备维修状态
				assetsInfo.setRepairStatus(repairStatus);
				if(AssetsRepairStatusEnum.REPAIRING.getNumber().equals(repairStatus)){//维修中
					assetsInfo.setRepairId(repairId);
				}else{
					assetsInfo.setRepairId(null);
				}
				assetsInfoService.updateAfterSelect(assetsInfo);
				return response();
			}else{
				throw ExceptionFactory.create("A_007");
			}
		}else{
			throw ExceptionFactory.create("A_006");
		}
	}
	
	/**
	 * 根据ID更新设备维修状态
	 */
	@ApiOperation(value = "根据ID更新设备维修状态", httpMethod = "GET")
	@ApiResponse(code = 0, message = "OK", response = Result.class)
	@RequestMapping(value = "/updateAssetsRepairStatusByIdNoToken/{id}/{repairStatus}", method = RequestMethod.GET)
	public Result<Object> updateAssetsRepairStatusByIdNoToken(@PathVariable("id")  Long id,@PathVariable("repairStatus")  Integer repairStatus, @RequestParam(value="repairId", required=false)Long repairId) {
		logger.debug("id="+id);
		logger.debug("repairStatus="+repairStatus);
		logger.debug("repairId="+repairId);
		AssetsInfo assetsInfo=assetsInfoService.selectById(id);
		if(assetsInfo!=null){
			if(!repairStatus.equals(assetsInfo.getRepairStatus())){
				//更新设备维修状态
				assetsInfo.setRepairStatus(repairStatus);
				if(AssetsRepairStatusEnum.REPAIRING.getNumber().equals(repairStatus)){//维修中
					assetsInfo.setRepairId(repairId);
				}else{
					assetsInfo.setRepairId(null);
				}
				assetsInfoService.updateAfterSelect(assetsInfo);
				return response();
			}else{
				throw ExceptionFactory.create("A_007");
			}
		}else{
			throw ExceptionFactory.create("A_006");
		}
	}
	
	@PreAuthorize("isAuthenticated()")
	@ApiOperation(value = "根据机构ID及部门ID集合查询巡检科室设备列表", httpMethod = "GET")
	@GetMapping("/getQcAssetsList")
	@ApiImplicitParams({
		@ApiImplicitParam(name="tenantId",value="机构ID",paramType="query",required=true),
		@ApiImplicitParam(name="deptIds",value="机构部门ID集合",paramType="query",required=true)}
	)
	public Result<List<AssetsQcInfoResponse>> getQcAssetsList(@RequestParam(value="tenantId", required=true)Long tenantId,@RequestParam(value="deptIds", required=true)Long[] deptIds) {
		logger.debug(">>>>>根据机构ID及部门ID集合查询巡检科室设备列表<<<<<<");
		logger.debug("查询参数：tenantId = " + tenantId + ",deptIds = " + deptIds.toString());
		List<AssetsQc> assetsQclist = assetsInfoService.getQcAssetsList(tenantId, deptIds);
		List<AssetsQcInfoResponse> list = BeanMapper.mapList(assetsQclist, AssetsQcInfoResponse.class);
		return response(list);
	}
	

	@PreAuthorize("isAuthenticated()")
	@ApiOperation(value = "根据机构ID及部门ID集合分页查询巡检科室设备列表", httpMethod = "POST")
	@PostMapping("/getQcAssetsPage")
	@ApiImplicitParams({
		@ApiImplicitParam(name="tenantId",value="机构ID",paramType="query",required=true),
		@ApiImplicitParam(name="deptIds",value="机构部门ID集合",paramType="query",required=true)}
	)
	public Result<Page<AssetsQcInfoResponse>> getQcAssetsPage(@RequestBody Page page,@RequestParam(value="tenantId", required=true)Long tenantId,@RequestParam(value="deptIds", required=true)Long[] deptIds) {
		logger.debug(">>>>>根据机构ID及部门ID集合查询巡检科室设备列表<<<<<<");
		logger.debug("查询参数：tenantId = " + tenantId + ",deptIds = " + deptIds.toString()+",page = " + page.toString());
		Page p = assetsInfoService.getQcAssetsPage(page, tenantId, deptIds);
		List<AssetsQcInfoResponse> list = BeanMapper.mapList(p.getRecords(), AssetsQcInfoResponse.class);
		p.setRecords(list);
		return response(p);
	}
	
	/**
	 * 根据ID集合更新设备是否在PM计划中状态
	 */
	@ApiOperation(value = "根据ID更新设备是否在PM计划中状态", httpMethod = "POST")
	@ApiResponse(code = 0, message = "OK", response = Result.class)
	@RequestMapping(value = "/updateAssetsPmPlanStatusByIds", method = RequestMethod.GET)
	public Result<Object> updateAssetsPmPlanStatusByIds(@RequestParam(value="assetsIds", required=true)List<Long> assetsIds) {
		logger.debug("assetsIds="+assetsIds);
		assetsInfoExtService.updateAssetsPmPlanStatusByIds(assetsIds);
		return response();
	}

	/**
	 * 根据ID获取设备状态
	 */
	@ApiOperation(value = "根据ID获取设备状态", httpMethod = "GET")
	@ApiResponse(code = 0, message = "OK", response = Result.class)
	@RequestMapping(value = "/getAssetsStatus", method = RequestMethod.GET)
	public Result<AssetsStatusResponse> getAssetsStatus(@RequestParam(value="assetsId", required=true)Long assetsId) {
		logger.debug("assetsId="+assetsId);
		AssetsInfo assetsInfo = assetsInfoService.selectById(assetsId);
		if(null != assetsInfo){
			AssetsStatusResponse assetsStatusResponse = new AssetsStatusResponse();
			AssetsStatusEnum[] assetsStatusEnums = AssetsStatusEnum.values();
			Integer status = assetsInfo.getStatus();
			for (AssetsStatusEnum assetsStatusEnum : assetsStatusEnums) {
				if(assetsStatusEnum.getNumber().equals(status)){
					assetsStatusResponse.setStatusName(assetsStatusEnum.getDesc());
					break;
				}
			}
			assetsStatusResponse.setAssetsId(assetsId);
			assetsStatusResponse.setStatus(status);
			return response(assetsStatusResponse);
		}else{
			throw ExceptionFactory.create("A_006");
		}
	}
	
	/**
	 * 根据资产ID获取资产详情信息 
	 */
	@ApiOperation(value = "根据资产ID获取资产详情信息 ", httpMethod = "GET")
	@ApiResponse(code = 0, message = "OK", response = Result.class)
	@RequestMapping(value = "/getAssetsDetail", method = RequestMethod.GET)
	public Result<AssetsInfoDetailReponse> getAssetsDetail(@RequestParam(value="assetsId", required=true)Long assetsId) {
		Assets assets = assetsInfoService.getAssetsDetail(assetsId);
		if(assets==null){
			return response(null);
		}
		return response(BeanMapper.map(assets, AssetsInfoDetailReponse.class));
	}

	@PreAuthorize("isAuthenticated()")
	@ApiOperation(value = "分页拉取本机构所有未加入保养计划的资产", httpMethod = "GET")
	@GetMapping("/getMtAssetsPage")
	@ApiImplicitParams({
		@ApiImplicitParam(name="pageNo",value="当前页",paramType="query",required=true),
		@ApiImplicitParam(name="pageSize",value="分页大小",paramType="query",required=true),
		@ApiImplicitParam(name="keyword",value="关键字（设备名称/设备编号）",paramType="query",required=true),
		@ApiImplicitParam(name="deptId",value="所在部门id",paramType="query",required=true)}
	)
	public Result<Page<MtAssets>> getMtAssetsPage(MtAssertQuery query) {
		return response(assetsInfoService.getMtAssetsPage(query));
	}
	
	@PreAuthorize("isAuthenticated()")
	@ApiOperation(value = "批量修改设备是否已经在保养计划", httpMethod = "GET")
	@RequestMapping(value = "/changeMtPlanFlag", method = RequestMethod.GET)
	public Result<Object> changeMtPlanFlag(@RequestParam(value="assetIds", required=true)List<Long> assetIds,@RequestParam(value="flag", required=true)Integer flag) {
		if(assetIds != null && assetIds.size() > 0){
			assetsInfoService.changeMtPlanFlag(assetIds,flag);		
		}else {
			throw ExceptionFactory.create("500");
		}
		return response();
	}
	
	
	@PreAuthorize("isAuthenticated()")
	@ApiOperation(value = "质控填报，模糊查询拉设备", httpMethod = "GET")
	@RequestMapping(value = "/getMdAssets", method = RequestMethod.GET)
	public Result<List<MdAssetsVO>> getMdAssets(@RequestParam(value="assetsName", required=false)String assetsName) {		
		return response(assetsInfoService.getMdAssets(assetsName));
	}
	
}
