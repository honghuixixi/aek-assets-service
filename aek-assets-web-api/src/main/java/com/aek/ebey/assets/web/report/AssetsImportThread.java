package com.aek.ebey.assets.web.report;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import com.aek.common.core.serurity.model.AuthUser;
import com.aek.ebey.assets.constant.SysConstant;
import com.aek.ebey.assets.core.util.SpringContextUtil;
import com.aek.ebey.assets.service.AssSerialNumberService;
import com.alibaba.fastjson.JSON;

public class AssetsImportThread implements Runnable{

	private static Logger logger = LoggerFactory.getLogger(AssetsImportThread.class);

	private Workbook book;
	private String uploadId;
	private String token;
	private AuthUser authUser;
	private RedisTemplate<String, String> redisTemplate;
	private AssSerialNumberService assSerialNumberService;

	public AssetsImportThread(Workbook book, String uploadId, String token, AuthUser authUser) {
		super();
		this.book = book;
		this.uploadId = uploadId;
		this.token = token;
		this.authUser = authUser;
		this.redisTemplate = SpringContextUtil.getBean(StringRedisTemplate.class);
		this.assSerialNumberService = SpringContextUtil.getBean(AssSerialNumberService.class);
	}

	@Override
	public void run() {
		importExcel();
	}

	private void importExcel(){
		int successCount=0;
		List<AssetsExcelVo> errorList = new ArrayList<>();
		List<AssetsExcelVo> list = new ArrayList<>();
		ExecutorService executorService = null;
		try {
			long start = System.currentTimeMillis();
			ValueOperations<String, String> opsForValue = redisTemplate.opsForValue();

			UploadResult uploadResult = new UploadResult();
			uploadResult.setProgress("0");
			opsForValue.set(SysConstant.CacheKey.ASSETS_IMPORT_PREFIX + uploadId, JSON.toJSONString(uploadResult));

			Sheet sheet = book.getSheetAt(0);
			int lastIndex = sheet.getLastRowNum();
			int dataRows = lastIndex + 1 - 2;
			logger.debug(lastIndex+"");
			Map<Integer, Field> columnType = ExcelUtil.mapExcelColumn(AssetsExcelVo.class);
			int threadCount = 1;
			/*if(dataRows>100){
				threadCount = 3;
			}
			*/
			int pageSize = dataRows/threadCount;
			if(pageSize==0){
				pageSize=dataRows;
			}
			executorService = Executors.newFixedThreadPool(threadCount);
			List<Future<Map<String, Object>>> futureList = new ArrayList<Future<Map<String, Object>>>();
			int startIndex=2;
			for(int i = 0; i < threadCount; i++){
				int endIndex = startIndex + pageSize;
				if(endIndex>lastIndex){
					endIndex=lastIndex;
				}
				Callable<Map<String, Object>> task = new AssetsImportTask(sheet, startIndex, endIndex, columnType, uploadId, token, authUser);
				Future<Map<String, Object>> future = executorService.submit(task);
				futureList.add(future);
				startIndex=endIndex+1;
			}
			for (Future<Map<String, Object>> future : futureList) {
				Map<String, Object> map = future.get();
				@SuppressWarnings("unchecked")
				List<AssetsExcelVo> errors = (List<AssetsExcelVo>) map.get("0");
				errorList.addAll(errors);
				successCount+=(Integer)map.get("1");
				List<AssetsExcelVo> all = (List<AssetsExcelVo>) map.get("2");
				list.addAll(all);
			}
			if(successCount>0){
				String key = "Assets:SerialNum:" + 1 + ":" + authUser.getTenantId();
				ValueOperations<String, String> valueOper = redisTemplate.opsForValue();
				Object obj = valueOper.get(key);
				if (obj != null) {
					Long num = 0L;
					if(obj instanceof Integer){
						num = Long.valueOf(((Integer)obj));
					}else if(obj instanceof Long){
						num = ((Long)obj);
					}
					if (num>0) {
						assSerialNumberService.insertOrUpdate(authUser.getTenantId(), 1, num);
					}
				}
			}
			if (!errorList.isEmpty()) {
				redisTemplate.opsForValue().set("Assets:ErrorFile:"+authUser.getMobile()+":" + uploadId, JSON.toJSONString(list), 1, TimeUnit.HOURS);
			}
			long end = System.currentTimeMillis();
			logger.debug("process excel cost="+(end-start)+"ms");
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		} finally {
			UploadResult uploadResult = new UploadResult();
			uploadResult.setProgress("100");
			uploadResult.setIsSuccess((successCount>0&&errorList.size()==0)?true:false);
			uploadResult.setSuccessCount(successCount);
			//uploadResult.setFailCount(errorList.size());
			redisTemplate.opsForValue().set(SysConstant.CacheKey.ASSETS_IMPORT_PREFIX + uploadId, JSON.toJSONString(uploadResult), 1, TimeUnit.MINUTES);
			if (executorService!=null) {
				executorService.shutdown();
			} 
		}
	}
}
