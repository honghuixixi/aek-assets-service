package com.aek.ebey.assets.service.feign;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aek.common.core.Result;
import com.aek.ebey.assets.model.vo.AssetsStats2Vo;
import com.aek.ebey.assets.model.vo.AssetsStatsVo;


/**
 * 远程调用维修服务
 * @author cyl
 *
 */
@FeignClient(value="${feign-data.serviceId}", fallback = DataClientHystrix.class)
public interface DataClientService {

	@RequestMapping(method = RequestMethod.POST, value = "/data/assetsData/addAssetsDataMonth")
	public Result<Object> addAssetsDataMonth(@RequestBody List<AssetsStats2Vo> request);
	
	@RequestMapping(method = RequestMethod.POST, value = "/data/assetsData/addAssetsData")
	public Result<Object> addAssetsData(@RequestBody List<AssetsStatsVo> request);
}
