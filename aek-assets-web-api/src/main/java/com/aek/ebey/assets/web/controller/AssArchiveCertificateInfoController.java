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
import com.aek.ebey.assets.model.AssArchiveCertificateInfo;
import com.aek.ebey.assets.service.AssArchiveCertificateInfoService;
import com.aek.ebey.assets.web.request.ArchiveCertificateInfoRequest;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

/**
 * <p>
 * 资产档案证件信息表  前端控制器
 * </p>
 *
 * @author cyl
 * @since 2018-04-26
 */
@RestController
@RequestMapping("/assets/assArchiveCertificateInfo")
public class AssArchiveCertificateInfoController extends BaseController {
	
	@Autowired
	private AssArchiveCertificateInfoService assArchiveCertificateInfoService;
	
	@PreAuthorize("hasAuthority('ARCHIVE_RECORD_VIEW')")
	@ApiOperation(value = "获取证件信息", httpMethod = "GET")
	@ApiResponse(code = 0, message = "OK", response = Result.class)
	@RequestMapping(value = "/getCertificateInfo", method = RequestMethod.GET)
	public Result<List<AssArchiveCertificateInfo>> getCertificateInfo(@RequestParam("archiveId")Long archiveId,
			@RequestParam("assetsId")Long assetsId) {
		return response(assArchiveCertificateInfoService.getCertificateInfo(archiveId,assetsId));
	}
	
	@PreAuthorize("hasAuthority('ARCHIVE_RECORD_VIEW')")
	@ApiOperation(value = "新增或编辑证件信息(仅支持单个固有证件和自定义证件操作)", httpMethod = "POST")
	@ApiResponse(code = 0, message = "OK", response = Result.class)
	@RequestMapping(value = "/insertOrUpdateCertificateInfo", method = RequestMethod.POST)
	public Result<Object> insertOrUpdateCertificateInfo(@RequestBody ArchiveCertificateInfoRequest request) {
		AssArchiveCertificateInfo certificate = BeanMapper.map(request, AssArchiveCertificateInfo.class);
		assArchiveCertificateInfoService.insertOrUpdateCertificateInfo(certificate);
		return response();
	}
	
	@PreAuthorize("hasAuthority('ARCHIVE_RECORD_VIEW')")
	@ApiOperation(value = "删除自定义证件", httpMethod = "GET")
	@ApiResponse(code = 0, message = "OK", response = Result.class)
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public Result<Object> delete(@PathVariable Long id) {
		assArchiveCertificateInfoService.delete(id);
		return response();
	}
}
