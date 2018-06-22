package com.aek.ebey.assets.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aek.common.core.Result;
import com.aek.common.core.base.BaseServiceImpl;
import com.aek.common.core.serurity.WebSecurityUtils;
import com.aek.common.core.serurity.model.AuthUser;
import com.aek.common.core.util.DateUtil;
import com.aek.ebey.assets.constant.SysConstant;
import com.aek.ebey.assets.core.util.CommonUtils;
import com.aek.ebey.assets.mapper.AssAssetsLogDetailMapper;
import com.aek.ebey.assets.mapper.AssAssetsLogMapper;
import com.aek.ebey.assets.model.AssAssetsLog;
import com.aek.ebey.assets.model.query.AssAssetsLogQuery;
import com.aek.ebey.assets.model.vo.OperateLog;
import com.aek.ebey.assets.model.AssAssetsLogDetail;
import com.aek.ebey.assets.model.AssetsLog;
import com.aek.ebey.assets.model.AssetsLogDetail;
import com.aek.ebey.assets.model.DeptNameAndUserName;
import com.aek.ebey.assets.service.AssAssetsLogDetailService;
import com.aek.ebey.assets.service.AssAssetsLogService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.google.common.collect.Lists;
import com.aek.ebey.assets.service.CodeInfoService;
import com.aek.ebey.assets.service.feign.UserClientService;

/**
 * <p>
 * 资产台账操作记录日志 服务实现类
 * </p>
 *
 * @author cyl
 * @since 2017-12-25
 */
@Service
@Transactional
public class AssAssetsLogServiceImpl extends BaseServiceImpl<AssAssetsLogMapper,AssAssetsLog> implements AssAssetsLogService {
	
	private static Logger logger = LoggerFactory.getLogger(AssAssetsLogServiceImpl.class);
	
	@Autowired
	private AssAssetsLogMapper assAssetsLogMapper;
	@Autowired
	private AssAssetsLogDetailMapper assAssetsLogDetailMapper;
	@Autowired
	private AssAssetsLogDetailService assAssetsLogDetailService;
	@Autowired
	private CodeInfoService codeInfoService;
	@Autowired
	private UserClientService userClientService;
	
	@Override
	public Page<AssetsLog> getLogPage(AssAssetsLogQuery query) {	
		Page<AssetsLog> page = query.getPage();
		List<AssetsLog> logPage = assAssetsLogMapper.getLogPage(page,query);
		if(logPage==null || logPage.size()==0){
			return page;
		}
		for (AssetsLog l : logPage) {
			if(l.getOperateType().intValue()==1){
				l.setOperateTypeStr("新增");
			}else {
				l.setOperateTypeStr("编辑");
			}
		}
		page.setRecords(logPage);
		return page;
	}
	
	@Override
	public AssetsLogDetail getLogDetail(Long id) {
		AssetsLogDetail log = assAssetsLogMapper.getLogDetail(id);
		if(log == null){
			return null;
		}
		List<OperateLog> operateList = Lists.newArrayList();
		Wrapper<AssAssetsLogDetail> wrapper = new EntityWrapper<AssAssetsLogDetail>();
		wrapper.eq("assets_log_id", id);
		List<AssAssetsLogDetail> list = assAssetsLogDetailMapper.selectList(wrapper);
		if(list !=null && list.size()>0){
			for (AssAssetsLogDetail item : list) {	
				if(item.getType()==1){//字段新增或修改
					OperateLog operateLog = new OperateLog();
					operateLog.setModel(1);
					operateLog.setFieldName(item.getFieldName());
					operateLog.setNewValue(item.getNewValue());
					operateLog.setOldValue(item.getOldValue());
					operateList.add(operateLog);
				}else if (item.getType() !=1 && item.getType() !=5) {//附件		
					String addValue = item.getNewValue();
					String delValue = item.getOldValue();
					String fieldName = item.getFieldName();
					if(delValue ==null && addValue !=null){//上传
						OperateLog operateAnnexAddLog = new OperateLog();
						operateAnnexAddLog.setOperateType(1);
						operateAnnexAddLog.setModel(2);
						operateAnnexAddLog.setFieldName(fieldName);
						operateAnnexAddLog.setAddValue(addValue);
						operateList.add(operateAnnexAddLog);
					}
					if(delValue !=null && addValue ==null){//删除
						OperateLog operateAnnexDelLog = new OperateLog();
						operateAnnexDelLog.setOperateType(2);
						operateAnnexDelLog.setModel(2);
						operateAnnexDelLog.setFieldName(fieldName);
						operateAnnexDelLog.setAddValue(delValue);//删除
						operateList.add(operateAnnexDelLog);
					}				
				}else if (item.getType() ==5) {
					OperateLog operateLogZJ = new OperateLog();
					operateLogZJ.setModel(1);
					operateLogZJ.setFieldName(item.getFieldName());
					operateLogZJ.setNewValue(item.getNewValue());
					operateLogZJ.setOldValue(item.getOldValue());
					operateList.add(operateLogZJ);
				}			
			}		
		}	
		log.setOperateList(operateList);
		return log;
	}
	
	@Override
	public void saveAssAssetsLog(AuthUser currentUser,String currentToken,AssAssetsLog assAssetsLog, List<AssAssetsLogDetail> assAssetsLogDetailList,String operateDesc) {
		if(null != assAssetsLog && null != assAssetsLogDetailList && assAssetsLogDetailList.size() > 0){
			//保存日志主体信息
			assAssetsLogMapper.insert(assAssetsLog);
			List<String> remarksFront = new ArrayList<String>();
			List<String> remarks = new ArrayList<String>();
			//保存日志明细信息
			for (AssAssetsLogDetail logDetail : assAssetsLogDetailList) {
				logDetail.setAssetsLogId(assAssetsLog.getId());
				if(StringUtils.isNotBlank(logDetail.getFieldName())){
					remarksFront.add(logDetail.getFieldName());
				}
				if(logDetail.getField() !=null){
					/*******************************info表翻译***********************************/
					//状态：1=在库、2=在用、3=预登、4=待报损、5=报损、6=退货
					if(logDetail.getField().equals("status")){
						logDetail.setNewValue(logDetail.getNewValue()==null?null:(SysConstant.STATUS_NAME_MAP.get(Integer.parseInt(logDetail.getNewValue()))));
						logDetail.setOldValue(logDetail.getOldValue()==null?null:(SysConstant.STATUS_NAME_MAP.get(Integer.parseInt(logDetail.getOldValue()))));
					}
					//购置类别:1=新增、2=添置、3=报废更新
					if(logDetail.getField().equals("apply_type")){
						logDetail.setNewValue(logDetail.getNewValue()==null?null:SysConstant.APPLY_TYPE_MAP.get((Integer.parseInt(logDetail.getNewValue()))));
						logDetail.setOldValue(logDetail.getOldValue()==null?null:SysConstant.APPLY_TYPE_MAP.get(Integer.parseInt(logDetail.getOldValue())));
					}
					//来源，0：入库新增，1：批量导入 2:验收录入 3：清查录入
					if(logDetail.getField().equals("assets_source")){
						logDetail.setNewValue(logDetail.getNewValue()==null?null:(SysConstant.AssetsSource.getText(Integer.parseInt(logDetail.getNewValue()))));
						logDetail.setOldValue(logDetail.getOldValue()==null?null:(SysConstant.AssetsSource.getText(Integer.parseInt(logDetail.getOldValue()))));
					}
					//是否国产（1，国产 2，进口）
					if(logDetail.getField().equals("made_in")){
						logDetail.setNewValue(logDetail.getNewValue()==null?null:SysConstant.MADE_IN_MAP.get(Integer.parseInt(logDetail.getNewValue())));
						logDetail.setOldValue(logDetail.getOldValue()==null?null:SysConstant.MADE_IN_MAP.get(Integer.parseInt(logDetail.getOldValue())));
					}
					//计数单位
					if(logDetail.getField().equals("unit_id")){
						logDetail.setNewValue(logDetail.getNewValue()==null?null:codeInfoService.getCodeInfoMap(SysConstant.UNIT).get(logDetail.getNewValue()));
						logDetail.setOldValue(logDetail.getOldValue()==null?null:codeInfoService.getCodeInfoMap(SysConstant.UNIT).get(logDetail.getOldValue()));
					}
					//核算类别
					if(logDetail.getField().equals("assets_class_id")){
						logDetail.setNewValue(codeInfoService.getCodeInfoMap(SysConstant.ACCOUNT_CATEGORY).get(logDetail.getNewValue()));
						logDetail.setOldValue(logDetail.getOldValue()==null?null:codeInfoService.getCodeInfoMap(SysConstant.ACCOUNT_CATEGORY).get(logDetail.getOldValue()));
					}
					//账簿类型
					if(logDetail.getField().equals("assets_type_id")){
						logDetail.setNewValue(codeInfoService.getCodeInfoMap(SysConstant.ACCOUNT_BOOK).get(logDetail.getNewValue()));
						logDetail.setOldValue(logDetail.getOldValue()==null?null:(codeInfoService.getCodeInfoMap(SysConstant.ACCOUNT_BOOK).get(logDetail.getOldValue())));
					}
					//管理科室
					if(logDetail.getField().equals("manage_dept_id")){
						Map<String, String> findDeptNameToMap = findDeptNameToMap(String.valueOf(logDetail.getNewValue()+","+String.valueOf(logDetail.getOldValue())),currentToken);
						logDetail.setNewValue(findDeptNameToMap.get(""+logDetail.getNewValue()));
						logDetail.setOldValue(logDetail.getOldValue()==null?null:findDeptNameToMap.get(""+logDetail.getOldValue()));
					}
					//申购科室
					if(logDetail.getField().equals("apply_dept_id")){
						Map<String, String> findDeptNameToMap = findDeptNameToMap(String.valueOf(logDetail.getNewValue()+","+String.valueOf(logDetail.getOldValue())),currentToken);
						logDetail.setNewValue(findDeptNameToMap.get(""+logDetail.getNewValue()));
						logDetail.setOldValue(logDetail.getOldValue()==null?null:findDeptNameToMap.get(""+logDetail.getOldValue()));
					}
					//所在科室
					if(logDetail.getField().equals("dept_id")){
						Map<String, String> findDeptNameToMap = findDeptNameToMap(String.valueOf(logDetail.getNewValue()+","+String.valueOf(logDetail.getOldValue())),currentToken);
						logDetail.setNewValue(findDeptNameToMap.get(""+logDetail.getNewValue()));
						logDetail.setOldValue(logDetail.getOldValue()==null?null:findDeptNameToMap.get(""+logDetail.getOldValue()));
					}
					//经费来源
//					if(logDetail.getField().equals("fund_sources_id")){
//						logDetail.setNewValue(codeInfoService.getCodeInfoMap(SysConstant.FUND_SOURCES).get(logDetail.getNewValue()));
//						logDetail.setOldValue(logDetail.getOldValue()==null?null:codeInfoService.getCodeInfoMap(SysConstant.FUND_SOURCES).get(logDetail.getOldValue()));
//					}
					/*******************************ext表翻译***********************************/
					//管理级别(1大型设备2生命支持及急救设备3其它)
					if(logDetail.getField().equals("manage_level")){
						logDetail.setNewValue(codeInfoService.getCodeInfoMap(SysConstant.MANAGE_LEVEL).get(logDetail.getNewValue()));
						logDetail.setOldValue(logDetail.getOldValue()==null?null:codeInfoService.getCodeInfoMap(SysConstant.MANAGE_LEVEL).get(logDetail.getOldValue()));
					}
					//计量类别
					if(logDetail.getField().equals("measure_type")){
						logDetail.setNewValue(codeInfoService.getCodeInfoMap(SysConstant.MEASURE_TYPE).get(logDetail.getNewValue()));
						logDetail.setOldValue(logDetail.getOldValue()==null?null:codeInfoService.getCodeInfoMap(SysConstant.MEASURE_TYPE).get(logDetail.getOldValue()));
					}
					//设备来源
					if(logDetail.getField().equals("purchase_type_id")){
						logDetail.setNewValue(codeInfoService.getCodeInfoMap(SysConstant.PURCHASE_TYPE).get(logDetail.getNewValue()));
						logDetail.setOldValue(logDetail.getOldValue()==null?null:codeInfoService.getCodeInfoMap(SysConstant.PURCHASE_TYPE).get(logDetail.getOldValue()));
					}
					//用途
					if(logDetail.getField().equals("purpose")){
						logDetail.setNewValue(codeInfoService.getCodeInfoMap(SysConstant.PURPOSE).get(logDetail.getNewValue()));
						logDetail.setOldValue(logDetail.getOldValue()==null?null:codeInfoService.getCodeInfoMap(SysConstant.PURPOSE).get(logDetail.getOldValue()));
					}
					//采购方式:1=国际招标、2=政府采购、3=院内采购、4=分散采购、5=自行采购、6=其他
					if(logDetail.getField().equals("purchase_way")){
						logDetail.setNewValue(logDetail.getNewValue()==null?null:SysConstant.PURCHASE_WAY_MAP.get(Integer.parseInt(logDetail.getNewValue())));
						logDetail.setOldValue(logDetail.getOldValue()==null?null:SysConstant.PURCHASE_WAY_MAP.get(Integer.parseInt(logDetail.getOldValue())));
					}
					//招标形式:1=公开招标、2=邀请招标、3=竞争性谈判、4=单一来源采购、5=询价采购、6=其他
					if(logDetail.getField().equals("tender_form")){
						logDetail.setNewValue(logDetail.getNewValue()==null?null:SysConstant.TENDER_FORM_MAP.get(Integer.parseInt(logDetail.getNewValue())));
						logDetail.setOldValue(logDetail.getOldValue()==null?null:SysConstant.TENDER_FORM_MAP.get(Integer.parseInt(logDetail.getOldValue())));
					}
					//巡检标识1启用0不启用
					if(logDetail.getField().equals("polling_flag")){
						logDetail.setNewValue(logDetail.getNewValue()==null?null:SysConstant.POLLING_FLAG_MAP.get(Integer.parseInt(logDetail.getNewValue())));
						logDetail.setOldValue(logDetail.getOldValue()==null?null:SysConstant.POLLING_FLAG_MAP.get(Integer.parseInt(logDetail.getOldValue())));
					}
					//所有价格格式化
					if(logDetail.getField().equals("price") || logDetail.getField().equals("single_budget") || logDetail.getField().equals("contract_price")){
						logDetail.setRemark("将"+(logDetail.getOldValue()==null?"无":CommonUtils.fromX2Y(Long.parseLong(logDetail.getOldValue())))+"修改为"+(logDetail.getNewValue()==null?"无":CommonUtils.fromX2Y(Long.parseLong(logDetail.getNewValue()))));						
						if(logDetail.getOldValue()==null || logDetail.getOldValue()==""){
							logDetail.setOldValue(null);
						}else {
							logDetail.setOldValue(CommonUtils.fromX2Y(Long.parseLong(logDetail.getOldValue())));
						}
						if(logDetail.getNewValue()==null || logDetail.getNewValue()==""){
							logDetail.setNewValue(null);
						}else {
							logDetail.setNewValue(CommonUtils.fromX2Y(Long.parseLong(logDetail.getNewValue())));
						}
					}else {
						logDetail.setRemark("将"+(logDetail.getOldValue()==null?null:logDetail.getOldValue())+"修改为"+logDetail.getNewValue());
					}				
				}
			}
			if(remarksFront !=null && remarksFront.size()>0){
				Set<String> set = new HashSet<String>(remarksFront);
				remarks.addAll(set);
			}
			if(!StringUtils.isNotBlank(assAssetsLog.getRemark())){
				String remark = currentUser==null ? "" : currentUser.getRealName()+operateDesc+"了："+String.join(";", remarks);
				assAssetsLog.setRemark(remark);
			}
			assAssetsLogMapper.updateById(assAssetsLog);
			assAssetsLogDetailService.insertBatch(assAssetsLogDetailList);
		}
	}
	
	/**
	 * 获取部门名称，存入map
	 * @param ids
	 * @return
	 */
	private Map<String, String> findDeptNameToMap(String ids,String currentToken) {
		Map<String, String> map = new HashMap<>();
		if (ids != null && !ids.equals(""))//获取部门名称，存入map
		{
			Result<List<DeptNameAndUserName>> deptName = userClientService.findByDeptIds(ids,currentToken);
			if (deptName != null && deptName.getData() != null && deptName.getData().size() != 0) {
				for (DeptNameAndUserName dname : deptName.getData()) {
					map.put("" + dname.getId(), dname.getName());//id为KEY，名称为value
				}
			}
		}
		return map;
	}

	
	
}
