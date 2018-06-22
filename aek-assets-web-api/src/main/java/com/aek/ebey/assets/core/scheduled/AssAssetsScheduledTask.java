package com.aek.ebey.assets.core.scheduled;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.aek.ebey.assets.model.vo.AssetsStats2Vo;
import com.aek.ebey.assets.model.vo.AssetsStatsVo;
import com.aek.ebey.assets.service.AssetsInfoService;
import com.aek.ebey.assets.service.feign.DataClientService;

@Component
public class AssAssetsScheduledTask {

	private static final Logger logger = LogManager.getLogger(AssAssetsScheduledTask.class);

	@Autowired
	private AssetsInfoService assetsInfoService;

	@Autowired
	private DataClientService dataClientService;

	/**
	 * 每天凌晨按需求统计资产相关参数
	 */
	@Scheduled(cron = "0 0 0 * * ?")
	//每隔1分钟
	//@Scheduled(cron="0/50 * * * * ?")
	public void executeAssetsStatsTimeTask(){
		logger.info("=================获取资产概览数据=================");
		List<AssetsStatsVo> overview = assetsInfoService.getAssetsData();
		if(overview != null && overview.size() > 0){
			dataClientService.addAssetsData(overview);
		}
	}

	@Scheduled(cron = "0 0 0 * * ?")
	//@Scheduled(cron="0/50 * * * * ?") 
	//每隔1分钟
	public void executeAssetsStats2TimeTask(){
		logger.info("=================获取资产月度数据=================");
		List<AssetsStats2Vo> list = assetsInfoService.addAssetsDataMonth();
		if(list != null && list.size() > 0){
			dataClientService.addAssetsDataMonth(list);
		}
	}
}
