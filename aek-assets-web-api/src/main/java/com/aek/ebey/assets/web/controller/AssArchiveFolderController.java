package com.aek.ebey.assets.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aek.common.core.BeanMapper;
import com.aek.common.core.Result;
import com.aek.common.core.base.BaseController;
import com.aek.ebey.assets.model.AssArchiveFolder;
import com.aek.ebey.assets.model.AssArchiveFolderAttachment;
import com.aek.ebey.assets.model.vo.ArchiveFolderDetailVo;
import com.aek.ebey.assets.service.AssArchiveFolderService;
import com.aek.ebey.assets.web.request.AssArchiveFolderRequest;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

/**
 * <p>
 * 资产档案文件夹表  前端控制器
 * </p>
 *
 * @author cyl
 * @since 2018-04-27
 */
@RestController
@RequestMapping("/assets/assArchiveFolder")
public class AssArchiveFolderController extends BaseController {
	
	@Autowired
	private AssArchiveFolderService assArchiveFolderService;
	
	@PreAuthorize("hasAuthority('ARCHIVE_RECORD_VIEW')")
	@ApiOperation(value = "新增档案文件", httpMethod = "POST")
	@ApiResponse(code = 0, message = "OK", response = Result.class)
	@RequestMapping(value = "/addFolder", method = RequestMethod.POST)
	public Result<Object> addFolder(@RequestBody AssArchiveFolderRequest request) {
		AssArchiveFolder folder = BeanMapper.map(request, AssArchiveFolder.class);
		List<AssArchiveFolderAttachment> attachments = request.getAttachments();
		assArchiveFolderService.addFolder(folder,attachments);
		return response();
	}
	
	@PreAuthorize("hasAuthority('ARCHIVE_RECORD_VIEW')")
	@ApiOperation(value = "编辑档案文件", httpMethod = "POST")
	@ApiResponse(code = 0, message = "OK", response = Result.class)
	@RequestMapping(value = "/editFolder", method = RequestMethod.POST)
	public Result<Object> editFolder(@RequestBody AssArchiveFolderRequest request) {
		AssArchiveFolder folder = BeanMapper.map(request, AssArchiveFolder.class);
		List<AssArchiveFolderAttachment> attachments = request.getAttachments();
		assArchiveFolderService.editFolder(folder,attachments);
		return response();
	}
	
	@PreAuthorize("hasAuthority('ARCHIVE_RECORD_VIEW')")
	@ApiOperation(value = "删除档案文件", httpMethod = "GET")
	@ApiResponse(code = 0, message = "OK", response = Result.class)
	@RequestMapping(value = "/deleteFolder/{id}", method = RequestMethod.GET)
	public Result<Object> deleteFolder(@PathVariable Long id) {
		assArchiveFolderService.deleteFolder(id);
		return response();
	}
	
	@PreAuthorize("hasAuthority('ARCHIVE_RECORD_VIEW')")
	@ApiOperation(value = "获取档案文件详情", httpMethod = "GET")
	@ApiResponse(code = 0, message = "OK", response = Result.class)
	@RequestMapping(value = "/getFolderDetail", method = RequestMethod.GET)
	public Result<ArchiveFolderDetailVo> getFolderDetail(@RequestParam("id") Long id) {
		return response(assArchiveFolderService.getFolderDetail(id));
	}
	
	@PreAuthorize("hasAuthority('ARCHIVE_RECORD_VIEW')")
	@ApiOperation(value = "获取档案文件管理列表", httpMethod = "GET")
	@ApiResponse(code = 0, message = "OK", response = Result.class)
	@RequestMapping(value = "/getFolder", method = RequestMethod.GET)
	public Result<List<AssArchiveFolder>> getFolder(@RequestParam("archiveId")Long archiveId,
			@RequestParam("assetsId")Long assetsId) {
		return response(assArchiveFolderService.getFolder(archiveId, assetsId));
	}

}
