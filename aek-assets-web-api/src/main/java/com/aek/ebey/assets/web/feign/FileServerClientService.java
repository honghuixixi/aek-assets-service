package com.aek.ebey.assets.web.feign;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.aek.common.core.Result;
import com.aek.ebey.assets.core.config.FeignMultipartSupportConfig;

/**
 * 用户远程调用接口
 */
@FeignClient(value="${feign-fileserver.serviceId}", fallback = FileServerClientHystrix.class,configuration = FeignMultipartSupportConfig.class)
public interface FileServerClientService {

	/**
	 * 文件上传接口
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/upload2", consumes=MediaType.MULTIPART_FORM_DATA_VALUE)
	public Result<List<Object>> upload(@RequestPart("files") MultipartFile files);

}