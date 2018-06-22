package com.aek.ebey.assets.service.feign;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestHeader;

import com.aek.common.core.Result;
import com.aek.ebey.assets.service.feign.vo.MsAssets;

@Component
public class QcClientHystrix implements QcClientService{

    private static final Logger logger = LogManager.getLogger(QcClientHystrix.class);

	@Override
	public Result<Object> saveOrUpdate(MsAssets request) {
		logger.info("============Qc service is not connected!=============="+request);
		return null;
	}

    @Override
    public Result<Boolean> isExistMsAssets(Long assetsId,String token) {
        logger.info("============Qc service is not connected!=============="+assetsId+","+token);
        return null;
    }

	@Override
	public Result<List<Long>> getMdAssetsExist(String token) {
		return null;
	}
    
	

}
