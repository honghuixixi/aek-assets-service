package com.aek.ebey.assets.service.feign;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.aek.common.core.Result;

/**
 * 断路器
 */
@Component
public class RepairClientHystrix implements RepairClientService {

	private static final Logger logger = LoggerFactory.getLogger(RepairClientHystrix.class);
	
	@Override
	public Result<Object> sendMsg(String messageContent, Long moduleId, String remarks, Long userId, Integer status,String token) {
		logger.error("消息发送失败");
		return null;
	}

}
