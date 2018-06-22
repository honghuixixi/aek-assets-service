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
import com.aek.ebey.assets.model.AssAssetsCertificate;
import com.aek.ebey.assets.service.AssAssetsCertificateService;
import com.aek.ebey.assets.web.request.AssAssetsCertificateRequest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

/**
 * <p>
 * 资产证件表  前端控制器
 * </p>
 *
 * @author aek
 * @since 2017-11-22
 */
@RestController
@Api(value = "AssAssetsCertificateController", description = "资产证件表  前端控制器")
@RequestMapping("/assets/assAssetsCertificate")
public class AssAssetsCertificateController extends BaseController {
	
	@Autowired
	AssAssetsCertificateService assAssetsCertificateService;
	
	/**
	 * 资产证件编辑
	 */
	@PreAuthorize("isAuthenticated()")
	@ApiOperation(value = "资产证件编辑", httpMethod = "POST")
	@ApiResponse(code = 0, message = "OK", response = Result.class)
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public Result<Object> editCertificate(@RequestBody List<AssAssetsCertificateRequest> listRequest) {
		List<AssAssetsCertificate> list = BeanMapper.mapList(listRequest, AssAssetsCertificate.class);
		assAssetsCertificateService.edit(list);
		return response();
	}
	
	/**
	 * 自定义资产证件即时校验
	 */
	@PreAuthorize("isAuthenticated()")
	@ApiOperation(value = "自定义资产证件即时校验", httpMethod = "GET")
	@ApiResponse(code = 0, message = "OK", response = Result.class)
	@RequestMapping(value = "/check", method = RequestMethod.GET)
	public Result<Object> check(@RequestParam(value="name") String name,@RequestParam(value="assetsId") Long assetsId,@RequestParam(value="idFlag") Long idFlag) {
		assAssetsCertificateService.check(name,assetsId,idFlag);
		return response();
	}
	
	/**
	 * 自定义资产证件新增（未启用）
	 */
	@PreAuthorize("isAuthenticated()")
	@ApiOperation(value = "自定义资产证件新增", httpMethod = "POST")
	@ApiResponse(code = 0, message = "OK", response = Result.class)
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Result<Object> addCertificate(@RequestBody AssAssetsCertificateRequest request) {
		AssAssetsCertificate assAssetsCertificate = BeanMapper.map(request, AssAssetsCertificate.class);
		assAssetsCertificateService.add(assAssetsCertificate);
		return response();
	}
	
	/**
	 * 自定义资产证件删除（未启用）
	 */
	@PreAuthorize("isAuthenticated()")
	@ApiOperation(value = "自定义资产证件删除", httpMethod = "GET")
	@ApiImplicitParam(name = "id", value = "证件id")
	@ApiResponse(code = 0, message = "OK", response = Result.class)
	@RequestMapping(value = "/delet", method = RequestMethod.GET)
	public Result<Object> deletCertificate(@RequestParam(value="id")Long id) {
		assAssetsCertificateService.delet(id);
		return response();
	}
	
}
