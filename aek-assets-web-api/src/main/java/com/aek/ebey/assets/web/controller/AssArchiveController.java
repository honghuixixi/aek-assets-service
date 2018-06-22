package com.aek.ebey.assets.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
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
import com.aek.ebey.assets.constant.ArchiveConstant;
import com.aek.ebey.assets.model.AssArchive;
import com.aek.ebey.assets.model.query.ArchiveDiscardQuery;
import com.aek.ebey.assets.model.query.ArchivePageQuery;
import com.aek.ebey.assets.model.query.ArchiveTransferQuery;
import com.aek.ebey.assets.model.query.NewArchiveQuery;
import com.aek.ebey.assets.model.vo.ArchiveDiscardVo;
import com.aek.ebey.assets.model.vo.ArchivePageVo;
import com.aek.ebey.assets.model.vo.ArchiveTransferVo;
import com.aek.ebey.assets.model.vo.AssetArchiveDetailVo;
import com.aek.ebey.assets.model.vo.AssetArchiveVo;
import com.aek.ebey.assets.model.vo.AssetBasicInfoVo;
import com.aek.ebey.assets.model.vo.PreEditArchiveVo;
import com.aek.ebey.assets.service.AssArchiveService;
import com.aek.ebey.assets.web.request.AssArchiveRequest;
import com.baomidou.mybatisplus.plugins.Page;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

/**
 * <p>
 * 设备档案表  前端控制器
 * </p>
 *
 * @author cyl
 * @since 2018-04-25
 */
@RestController
@RequestMapping("/assets/assArchive")
public class AssArchiveController extends BaseController {
	
	@Autowired
	private AssArchiveService assArchiveService;
	
	@SuppressWarnings("rawtypes")
	@PreAuthorize("isAuthenticated()")
	@ApiOperation(value = "获取档案管理所需常量", httpMethod = "GET")
	@ApiResponse(code = 0, message = "OK", response = Result.class)
	@RequestMapping(value = "/getArchiveConstantMap", method = RequestMethod.GET)
	public Result<Map> getArchiveConstantMap() {
		Map<String, Map> map = new HashMap<>();
		map.put("PURCHASE_TYPE", ArchiveConstant.PURCHASE_TYPE_MAP);
		map.put("PURCHASE_MODE", ArchiveConstant.PURCHASE_MODE_MAP);
		map.put("TENDER_FORM", ArchiveConstant.TENDER_FORM_MAP);
		map.put("LIMIT_STORAGE_TIME", ArchiveConstant.LIMIT_STORAGE_TIME_MAP);
		map.put("SECRET_LEVEL", ArchiveConstant.SECRET_LEVEL_MAP);		
		map.put("FUND_SOURCES", ArchiveConstant.FUND_SOURCES_MAP);	
		return response(map);
	}
	
	@PreAuthorize("isAuthenticated()")
	@ApiOperation(value = "分页获取未新建档案的设备", httpMethod = "GET")
	@GetMapping("/getNewArchiveAssetsList")
	@ApiImplicitParams({
		@ApiImplicitParam(name="keyword",value="关键字（设备名称/设备编号）",paramType="query",required=true),
		@ApiImplicitParam(name="deptId",value="所在部门id",paramType="query",required=true)}
	)
	public Result<Page<AssetArchiveVo>> getNewArchiveAssetsList(NewArchiveQuery query){
		return response(assArchiveService.getNewArchiveAssetsList(query));
	}
	
	@PreAuthorize("hasAuthority('ARCHIVE_NEW_EDIT')")
	@ApiOperation(value = "新建设备档案", httpMethod = "POST")
	@PostMapping("/addArchive")
	public Result<Object> addArchive(@RequestBody AssArchiveRequest request){
		AssArchive archive = BeanMapper.map(request, AssArchive.class);
		assArchiveService.addArchive(archive);
		return response();
	}
	
	@PreAuthorize("hasAuthority('ARCHIVE_NEW_EDIT')")
	@ApiOperation(value = "编辑设备档案", httpMethod = "POST")
	@PostMapping("/editArchive")
	public Result<Object> editArchive(@RequestBody AssArchiveRequest request){
		Long id = request.getId();
		AssArchive archiveDb = assArchiveService.selectById(id);
		if(archiveDb==null){
			throw ExceptionFactory.create("AR_001");
		}
		AssArchive archive = BeanMapper.map(request, AssArchive.class);
		assArchiveService.editArchive(archive);
		return response();
	}
	
	@PreAuthorize("isAuthenticated()")
	@ApiOperation(value = "编辑前提供设备档案", httpMethod = "GET")
	@GetMapping("/preEditArchive")
	public Result<PreEditArchiveVo> preEditArchive(@RequestParam("id") Long id){
		return response(assArchiveService.preEditArchive(id));
	}
	
	@PreAuthorize("isAuthenticated()")
	@ApiOperation(value = "分页查设备档案", httpMethod = "GET")
	@GetMapping("/getArchivePage")
	public Result<Page<ArchivePageVo>> getArchivePage(ArchivePageQuery query){
		return response(assArchiveService.getArchivePage(query));
	}
	
	@PreAuthorize("hasAuthority('ARCHIVE_RECORD_VIEW')")
	@ApiOperation(value = "获取设备档案详情", httpMethod = "GET")
	@GetMapping("/getArchiveDetail")
	public Result<AssetArchiveDetailVo> getArchiveDetail(@RequestParam("id") Long id){
		return response(assArchiveService.getArchiveDetail(id));
	}
	
	@PreAuthorize("hasAuthority('ARCHIVE_RECORD_VIEW')")
	@ApiOperation(value = "获取设备基本信息", httpMethod = "GET")
	@GetMapping("/getAssetBasicInfo")
	public Result<AssetBasicInfoVo> getAssetBasicInfo(@RequestParam("assetId") Long assetId){
		return response(assArchiveService.getAssetBasicInfo(assetId));
	}
	
	@PreAuthorize("hasAuthority('ARCHIVE_RECORD_VIEW')")
	@ApiOperation(value = "获取档案管理转科记录", httpMethod = "GET")
	@GetMapping("/getArchiveTransferPage")
	public Result<Page<ArchiveTransferVo>> getArchiveTransferPage(ArchiveTransferQuery query){
		return response(assArchiveService.getArchiveTransferPage(query));
	}
	
	@PreAuthorize("hasAuthority('ARCHIVE_RECORD_VIEW')")
	@ApiOperation(value = "获取档案管理报损记录", httpMethod = "GET")
	@GetMapping("/getArchiveDiscardPage")
	public Result<Page<ArchiveDiscardVo>> getArchiveDiscardPage(ArchiveDiscardQuery query){
		return response(assArchiveService.getArchiveDiscardPage(query));
	}
}
