package com.aek.ebey.assets.web.feign;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.aek.common.core.Result;

/**
 * 断路器
 */
@Component
public class FileServerClientHystrix implements FileServerClientService {
	
	private static final Logger logger = LoggerFactory.getLogger(FileServerClientHystrix.class);

	@Override
	public Result<List<Object>> upload(MultipartFile files) {
		logger.error("upload fail.");
		return null;
	}

}
