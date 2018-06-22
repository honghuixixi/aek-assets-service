package com.aek.ebey.assets.service.feign;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.aek.common.core.Result;
import com.aek.ebey.assets.service.feign.vo.MsAssets;

/**
 * 用户远程调用接口value=${feign-qc.serviceId}
 */
@FeignClient(value="${feign-qc.serviceId}", fallback = QcClientHystrix.class)
public interface QcClientService {

	@RequestMapping(method = RequestMethod.POST, value = "/qc/msAssets/saveOrUpdate")
	public Result<Object> saveOrUpdate(@RequestBody MsAssets request);
	
	@RequestMapping(method = RequestMethod.GET, value = "/qc/msAssets/isExistMsAssets")
	public Result<Boolean> isExistMsAssets(@RequestParam(name = "assetsId",required = true) Long assetsId,@RequestHeader("X-AEK56-Token") String token);
	
	@RequestMapping(method = RequestMethod.GET, value = "/qc/mdReport/getMdAssetsExist")
	public Result<List<Long>> getMdAssetsExist(@RequestHeader("X-AEK56-Token") String token);
}