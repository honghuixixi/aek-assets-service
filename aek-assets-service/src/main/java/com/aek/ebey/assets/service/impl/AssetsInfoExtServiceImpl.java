package com.aek.ebey.assets.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aek.common.core.base.BaseServiceImpl;
import com.aek.common.core.serurity.WebSecurityUtils;
import com.aek.common.core.serurity.model.AuthUser;
import com.aek.ebey.assets.constant.SysConstant;
import com.aek.ebey.assets.core.util.ReflectUtils;
import com.aek.ebey.assets.enums.AssetsLogModuleTypeEnum;
import com.aek.ebey.assets.enums.AssetsLogOperateTypeEnum;
import com.aek.ebey.assets.mapper.AssAssetsLogDetailMapper;
import com.aek.ebey.assets.mapper.AssAssetsLogMapper;
import com.aek.ebey.assets.mapper.AssetsInfoExtMapper;
import com.aek.ebey.assets.model.AssAssetsLog;
import com.aek.ebey.assets.model.AssAssetsLogDetail;
import com.aek.ebey.assets.model.AssetsInfo;
import com.aek.ebey.assets.model.AssetsInfoExt;
import com.aek.ebey.assets.service.AssetsInfoExtService;

/**
 * <p>
 * 资产信息表扩展表 服务实现类
 * </p>
 *
 * @author aek
 * @since 2017-04-13
 */
@Service
@Transactional
public class AssetsInfoExtServiceImpl extends BaseServiceImpl<AssetsInfoExtMapper, AssetsInfoExt> implements AssetsInfoExtService {

	// 预台账扩展信息
	@Autowired
	private AssetsInfoExtMapper assetsInfoExtMapper;
	@Autowired
	private AssAssetsLogMapper assAssetsLogMapper;
	@Autowired
	private AssAssetsLogDetailMapper assAssetsLogDetailMapper;
	
	@Override
	@Transactional
	public void updateFactoryName(Map<String, Object> map) {
		Long assetsId = Long.valueOf(String.valueOf(map.get("assetssId")));
		String factoryName = (String)map.get("factoryName");
		AssetsInfoExt oldAssetsInfoExt = assetsInfoExtMapper.getAssetByAssetId(assetsId);
		assetsInfoExtMapper.updateFactoryName(map);
		
		//记录更新生产商修改日志
		AuthUser currentUser = WebSecurityUtils.getCurrentUser();
		String tableName = ReflectUtils.getClazzTableName(AssetsInfoExt.class);
		if(null != oldAssetsInfoExt && !oldAssetsInfoExt.getFactoryName().equals(factoryName)){
			//日志主表信息
			AssAssetsLog assAssetsLog = new AssAssetsLog();
			assAssetsLog.setAssetsId(assetsId);
			//编辑的标签类别（1=设备信息，2=采购信息，3=合同信息，4=证件管理）
			assAssetsLog.setModuleType(AssetsLogModuleTypeEnum.ASSETS_INFO.getNumber());
			//编辑
			assAssetsLog.setOperateType(AssetsLogOperateTypeEnum.EDIT.getNumber());
			assAssetsLog.setOperateBy(currentUser.getId());
			assAssetsLog.setOperateByName(currentUser.getRealName());
			assAssetsLog.setOperateTime(new Date());
			assAssetsLog.setRemark(currentUser.getRealName()+"编辑了：生产商");
			assAssetsLogMapper.insert(assAssetsLog);
			AssAssetsLogDetail logDetail = new AssAssetsLogDetail();
			logDetail.setAssetsLogId(assAssetsLog.getId());
			logDetail.setCreateTime(new Date());
			logDetail.setTableName(tableName);
			logDetail.setField("factory_name");
			logDetail.setFieldName("生产商");
			logDetail.setType(AssetsLogModuleTypeEnum.ASSETS_INFO.getNumber());
			logDetail.setPropertyName("factoryName");
			logDetail.setNewValue(map.get("factoryName").toString());
			logDetail.setOldValue(oldAssetsInfoExt.getFactoryName());
			logDetail.setRemark("将"+(logDetail.getOldValue()==null?"无":logDetail.getOldValue())+"修改为"+logDetail.getNewValue());
			assAssetsLogDetailMapper.insert(logDetail);
		}
	}

	@Override
	public void updateAssetsPmPlanStatusByIds(List<Long> assetsIds) {
		assetsInfoExtMapper.updateAssetsPmPlanStatusByIds(assetsIds);
	}
	
}
