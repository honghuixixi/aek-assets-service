package com.aek.ebey.assets.core;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aek.ebey.assets.enums.AssetsLogOperateTypeEnum;
import com.aek.ebey.assets.model.AssAssetsLog;
import com.aek.ebey.assets.model.AssAssetsLogDetail;
import com.aek.ebey.assets.service.AssAssetsLogDetailService;
import com.aek.ebey.assets.service.AssAssetsLogService;

/**
 * 资产修改日志线程类
 *	
 * @author HongHui
 * @date   2017年12月26日
 */
public class AssetsLogThread implements Runnable{

	private static Logger logger = LoggerFactory.getLogger(AssetsLogThread.class);
	
	/**
	 * 日志修改日志实体类
	 */
	private AssAssetsLog assAssetsLog;
	/**
	 * 日志修改明细集合
	 */
	private List<AssAssetsLogDetail> assAssetsLogDetailList;
	/**
	 * 修改日志业务实现类
	 */
	private AssAssetsLogService assAssetsLogService;
	
	/**
	 * 操作描述 新增/编辑
	 */
	private String operateDesc;
	
	
	public AssetsLogThread(AssAssetsLog assAssetsLog, List<AssAssetsLogDetail> assAssetsLogDetailList,
			AssAssetsLogService assAssetsLogService,String operateDesc) {
		super();
		this.assAssetsLog = assAssetsLog;
		this.assAssetsLogDetailList = assAssetsLogDetailList;
		this.assAssetsLogService = assAssetsLogService;
		this.operateDesc = operateDesc;
	}
	
	@Override
	public void run() {
		logger.info(">>>>>>>>>保存资产修改日志任务执行<<<<<<<<<<<");
		//assAssetsLogService.saveAssAssetsLog(assAssetsLog, assAssetsLogDetailList,operateDesc);
	}
}
