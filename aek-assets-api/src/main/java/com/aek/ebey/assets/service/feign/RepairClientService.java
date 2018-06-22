package com.aek.ebey.assets.service.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.aek.common.core.Result;

/**
 * 远程调用维修服务
 * @author cyl
 *
 */
@FeignClient(value="${feign-repair-new.serviceId}", fallback = RepairClientHystrix.class)
public interface RepairClientService {

	/**
	 * 转科、报损通过或不通过发消息
	 * 
	 * @param messageContent
	 * @param moduleId
	 * @param remarks
	 * @param userId
	 * @param status
	 * @param token
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value="/newrepair/repRepairMessage/save")
	public Result<Object> sendMsg(@RequestParam("messageContent") String messageContent,
			@RequestParam("moduleId") Long moduleId,
			@RequestParam("remarks") String remarks,
			@RequestParam("userId") Long userId,
			@RequestParam("status")Integer status,
			@RequestHeader("X-AEK56-Token") String token);

}
