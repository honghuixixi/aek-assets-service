package com.aek.ebey.assets.service.feign;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.aek.common.core.Result;
import com.aek.ebey.assets.model.vo.AssetsStats2Vo;
import com.aek.ebey.assets.model.vo.AssetsStatsVo;

@Component
public class DataClientHystrix implements DataClientService{

    private static final Logger logger = LogManager.getLogger(DataClientHystrix.class);
    
	@Override
	public Result<Object> addAssetsDataMonth(List<AssetsStats2Vo> request) {
	    logger.info("============data service is not connected!==============");
        return null;
	}

	@Override
	public Result<Object> addAssetsData(List<AssetsStatsVo> request) {
	    logger.info("============data service is not connected!==============");
        return null;
	}

}
