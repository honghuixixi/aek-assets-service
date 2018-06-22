package com.aek.ebey.assets.service.impl;

import com.aek.ebey.assets.core.util.CommonUtils;
import com.aek.ebey.assets.core.util.ReflectUtils;
import com.aek.ebey.assets.enums.AssetsLogDetailTypeEnum;
import com.aek.ebey.assets.enums.AssetsLogOperateTypeEnum;
import com.aek.ebey.assets.mapper.AssAssetsCertificateMapper;
import com.aek.ebey.assets.mapper.AssAssetsLogMapper;
import com.aek.ebey.assets.model.AssAssetsCertificate;
import com.aek.ebey.assets.model.AssAssetsLog;
import com.aek.ebey.assets.model.AssAssetsLogDetail;
import com.aek.ebey.assets.service.AssAssetsCertificateService;
import com.aek.ebey.assets.service.AssAssetsLogDetailService;
import com.aek.ebey.assets.service.utils.DateFormatUtils;
import com.google.common.collect.Lists;
import com.aek.common.core.BeanMapper;
import com.aek.common.core.base.BaseServiceImpl;
import com.aek.common.core.exception.ExceptionFactory;
import com.aek.common.core.serurity.WebSecurityUtils;
import com.aek.common.core.serurity.model.AuthUser;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 资产证件表 服务实现类
 * </p>
 *
 * @author aek
 * @since 2017-11-22
 */
@Service
@Transactional
public class AssAssetsCertificateServiceImpl extends BaseServiceImpl<AssAssetsCertificateMapper,AssAssetsCertificate> implements AssAssetsCertificateService {
	
	@Autowired
	private AssAssetsCertificateMapper assAssetsCertificateMapper;
	@Autowired
	private AssAssetsLogMapper assAssetsLogMapper;
	@Autowired
	private AssAssetsLogDetailService assAssetsLogDetailService;
	
	@Override
	public void edit(List<AssAssetsCertificate> list) {
		AuthUser authUser = WebSecurityUtils.getCurrentUser();
		Long assetsId=null;
		if(list !=null && list.size() >0)assetsId=list.get(0).getAssetsId();
		List<AssAssetsCertificate> copyList = BeanMapper.mapList(list, AssAssetsCertificate.class);
		List<AssAssetsCertificate> newList = Lists.newArrayList();
		//newList.addAll(list);
		newList = BeanMapper.mapList(list, AssAssetsCertificate.class);
		List<AssAssetsCertificate> oldList = assAssetsCertificateMapper.getCertificate(assetsId, authUser);
		if(list !=null && list.size() >0){	
			for (AssAssetsCertificate item : list) {
				item.setSysId(authUser.getTenantId());
				assAssetsCertificateMapper.del(authUser,item.getAssetsId());
			}		
			this.insertBatch(list);
			
			List<AssAssetsLogDetail> logDetailList = Lists.newArrayList();
			Map<String, List<AssAssetsCertificate>> resultMap = CommonUtils.compareSup(oldList, newList);
			List<AssAssetsCertificate> addList = resultMap.get("add");
			List<AssAssetsCertificate> reduceList = resultMap.get("reduce");
			if((addList !=null && addList.size()>0) || (reduceList !=null && reduceList.size()>0)){
				for (AssAssetsCertificate cl : copyList) {
					if(cl.getId()==null){
						if(addList !=null && addList.size()>0){
							for (AssAssetsCertificate al : addList) {
								if(!al.getName().equals("医疗器械生产企业许可证")&&!al.getName().equals("医疗器械注册证")&&!al.getName().equals("医疗器械经营企业许可证")&&!al.getName().equals("产品合格证")&&al.getName().equals(cl.getName())){
									al.setId(null);//还原新增自定义证件id为null的条件
								}
							}
						}				
					}
				}
				
				//日志主表信息
				AssAssetsLog assAssetsLog = new AssAssetsLog();
				assAssetsLog.setAssetsId(assetsId);
				//编辑的标签类别（1=设备信息，2=采购信息，3=合同信息，4=证件管理）
				assAssetsLog.setModuleType(4);
				//编辑
				assAssetsLog.setOperateType(AssetsLogOperateTypeEnum.EDIT.getNumber());
				assAssetsLog.setOperateBy(authUser.getId());
				assAssetsLog.setOperateByName(authUser.getRealName());
				assAssetsLog.setOperateTime(new Date());
			
				assAssetsLogMapper.insert(assAssetsLog);
				
				if(addList !=null && addList.size()>0){
					for (AssAssetsCertificate add : addList) {
						if(reduceList.size()>0 && add.getName().equals("医疗器械生产企业许可证") && add.getCertificateType()==1){
							for (int i = 0; i < reduceList.size(); i++) {
								if(reduceList.get(i).getName().equals("医疗器械生产企业许可证") && reduceList.get(i).getCertificateType()==1){
									List<AssAssetsLogDetail> listA = ReflectUtils.compareTwoClazzToLogDetail(reduceList.get(i),add, AssAssetsCertificate.class, AssetsLogDetailTypeEnum.CERTIFICATE_ATTACHMENT.getNumber());
									if(listA !=null && listA.size()>0){
										for (AssAssetsLogDetail a : listA) {
											if(a.getFieldName().equals("编号")){
												a.setFieldName("医疗器械生产企业许可证—注册号");
												a.setRemark("医疗器械生产企业许可证");//备注补充证件名
											}
											if(a.getFieldName().equals("有效期至")){
												a.setFieldName("医疗器械生产企业许可证—有效期至");
												a.setRemark("医疗器械生产企业许可证");//备注补充证件名
											}
										}
									}
									logDetailList.addAll(listA);
								}							
							}
						}else if(reduceList.size()==0 && add.getName().equals("医疗器械生产企业许可证") && add.getCertificateType()==1){
							List<AssAssetsLogDetail> listA = ReflectUtils.compareTwoClazzToLogDetail(new AssAssetsCertificate(),add, AssAssetsCertificate.class, AssetsLogDetailTypeEnum.CERTIFICATE_ATTACHMENT.getNumber());
							if(listA !=null && listA.size()>0){
								for (AssAssetsLogDetail a : listA) {
									if(a.getFieldName().equals("编号")){
										a.setFieldName("医疗器械生产企业许可证—注册号");
										a.setRemark("医疗器械生产企业许可证");//备注补充证件名
									}
									if(a.getFieldName().equals("有效期至")){
										a.setFieldName("医疗器械生产企业许可证—有效期至");
										a.setRemark("医疗器械生产企业许可证");//备注补充证件名
									}
								}
							}
							logDetailList.addAll(listA);					
						}
						
						if(reduceList.size()>0 && add.getName().equals("医疗器械注册证") && add.getCertificateType()==2){
							for (int i = 0; i < reduceList.size(); i++) {
								if(reduceList.get(i).getName().equals("医疗器械注册证") && reduceList.get(i).getCertificateType()==2){
									List<AssAssetsLogDetail> listB = ReflectUtils.compareTwoClazzToLogDetail(reduceList.get(i), add, AssAssetsCertificate.class, AssetsLogDetailTypeEnum.CERTIFICATE_ATTACHMENT.getNumber());
									if(listB !=null && listB.size()>0){
										for (AssAssetsLogDetail b : listB) {
											if(b.getFieldName().equals("注册号")){
												b.setFieldName("医疗器械注册证—注册号");
												b.setRemark("医疗器械注册证");//备注补充证件名
											}
											if(b.getFieldName().equals("有效期至")){
												b.setFieldName("医疗器械注册证—有效期至");
												b.setRemark("医疗器械注册证");//备注补充证件名
											}
										}
									}
									logDetailList.addAll(listB);							
								}
							}
						}else if (reduceList.size()==0 && add.getName().equals("医疗器械注册证") && add.getCertificateType()==2) {
							List<AssAssetsLogDetail> listB = ReflectUtils.compareTwoClazzToLogDetail(new AssAssetsCertificate(),add, AssAssetsCertificate.class, AssetsLogDetailTypeEnum.CERTIFICATE_ATTACHMENT.getNumber());
							if(listB !=null && listB.size()>0){
								for (AssAssetsLogDetail b : listB) {
									if(b.getFieldName().equals("注册号")){
										b.setFieldName("医疗器械注册证—注册号");
										b.setRemark("医疗器械注册证");//备注补充证件名
									}
									if(b.getFieldName().equals("有效期至")){
										b.setFieldName("医疗器械注册证—有效期至");
										b.setRemark("医疗器械注册证");//备注补充证件名
									}
								}
							}
							logDetailList.addAll(listB);	
						}
						
						if(reduceList.size()>0 && add.getName().equals("医疗器械经营企业许可证") && add.getCertificateType()==3){
							for (int i = 0; i < reduceList.size(); i++) {
								if(reduceList.get(i).getName().equals("医疗器械经营企业许可证") && reduceList.get(i).getCertificateType()==3){
									List<AssAssetsLogDetail> listC = ReflectUtils.compareTwoClazzToLogDetail(reduceList.get(i), add, AssAssetsCertificate.class, AssetsLogDetailTypeEnum.CERTIFICATE_ATTACHMENT.getNumber());
									if(listC !=null && listC.size()>0){
										for (AssAssetsLogDetail c : listC) {									
											if(c.getFieldName().equals("编号")){
												c.setFieldName("医疗器械经营企业许可证—编号");
												c.setRemark("医疗器械经营企业许可证");//备注补充证件名
											}
											if(c.getFieldName().equals("有效期至")){
												c.setFieldName("医疗器械经营企业许可证—有效期至");
												c.setRemark("医疗器械经营企业许可证");//备注补充证件名
											}
										}
									}
									logDetailList.addAll(listC);							
								}
							}
						}else if (reduceList.size()==0 && add.getName().equals("医疗器械经营企业许可证") && add.getCertificateType()==3) {
							List<AssAssetsLogDetail> listC = ReflectUtils.compareTwoClazzToLogDetail(new AssAssetsCertificate(),add, AssAssetsCertificate.class, AssetsLogDetailTypeEnum.CERTIFICATE_ATTACHMENT.getNumber());
							if(listC !=null && listC.size()>0){
								for (AssAssetsLogDetail c : listC) {
									if(c.getFieldName().equals("编号")){
										c.setFieldName("医疗器械经营企业许可证—编号");
										c.setRemark("医疗器械经营企业许可证");//备注补充证件名
									}
									if(c.getFieldName().equals("有效期至")){
										c.setFieldName("医疗器械经营企业许可证—有效期至");
										c.setRemark("医疗器械经营企业许可证");//备注补充证件名
									}
								}
							}
							logDetailList.addAll(listC);
						} 
								
						if(reduceList.size()>0 && add.getName().equals("产品合格证") && add.getCertificateType()==4){
							for (int i = 0; i < reduceList.size(); i++) {
								if(reduceList.get(i).getName().equals("产品合格证") && reduceList.get(i).getCertificateType()==4){
									List<AssAssetsLogDetail> listD = ReflectUtils.compareTwoClazzToLogDetail(reduceList.get(i), add, AssAssetsCertificate.class, AssetsLogDetailTypeEnum.CERTIFICATE_ATTACHMENT.getNumber());
									if(listD !=null && listD.size()>0){
										for (AssAssetsLogDetail d : listD) {
											if(d.getFieldName().equals("生产日期")){
												d.setFieldName("产品合格证—生产日期");
												d.setRemark("产品合格证");//备注补充证件名
											}
											if(d.getFieldName().equals("有效期")){
												d.setFieldName("产品合格证—有效期");
												d.setRemark("产品合格证");//备注补充证件名
											}
										}
									}
									logDetailList.addAll(listD);							
								}
							}
						}else if (reduceList.size()==0 && add.getName().equals("产品合格证") && add.getCertificateType()==4) {
							List<AssAssetsLogDetail> listD = ReflectUtils.compareTwoClazzToLogDetail(new AssAssetsCertificate(),add, AssAssetsCertificate.class, AssetsLogDetailTypeEnum.CERTIFICATE_ATTACHMENT.getNumber());
							if(listD !=null && listD.size()>0){
								for (AssAssetsLogDetail d : listD) {
									if(d.getFieldName().equals("生产日期")){
										d.setFieldName("产品合格证—生产日期");
										d.setRemark("产品合格证");//备注补充证件名
									}
									if(d.getFieldName().equals("有效期")){
										d.setFieldName("产品合格证—有效期");
										d.setRemark("产品合格证");//备注补充证件名
									}
								}
							}
							logDetailList.addAll(listD);
						}
														
						if(reduceList.size()>0 && add.getId()!=null && add.getCertificateType()==5){
							for (int i = 0; i < reduceList.size(); i++) {
								if(add.getName().equals(reduceList.get(i).getName()) && reduceList.get(i).getCertificateType()==5){
									List<AssAssetsLogDetail> listE = ReflectUtils.compareTwoClazzToLogDetail(reduceList.get(i), add, AssAssetsCertificate.class, AssetsLogDetailTypeEnum.CERTIFICATE_ATTACHMENT.getNumber());
									if(listE !=null && listE.size()>0){
										for (AssAssetsLogDetail e : listE) {
											if(e.getFieldName().equals("编号")){
												e.setFieldName(reduceList.get(i).getName()+"(自定义证件)—编号");
											}
											if(e.getFieldName().equals("有效期至")){
												e.setFieldName(reduceList.get(i).getName()+"(自定义证件)—有效期至");
											}
											e.setRemark(reduceList.get(i).getName()+"(自定义证件)");//备注补充自定义证件名
										}
									}
									logDetailList.addAll(listE);
									reduceList.remove(reduceList.get(i));
									i--;
								}
							}
						}				
						if(add.getId()==null && add.getCertificateType()==5){
							AssAssetsLogDetail userDefineNum = new AssAssetsLogDetail();
							AssAssetsLogDetail userDefineDate = new AssAssetsLogDetail();
							
							if(StringUtils.isNotBlank(add.getCertificateNum())){
								userDefineNum.setCreateTime(new Date());
								userDefineNum.setTableName("ass_assets_certificate");
								userDefineNum.setType(AssetsLogDetailTypeEnum.CERTIFICATE_ATTACHMENT.getNumber());
								userDefineNum.setAssetsLogId(assAssetsLog.getId());
								userDefineNum.setRemark(add.getName()+"(自定义证件)");
								
								userDefineNum.setField("certificate_num");
								userDefineNum.setFieldName(add.getName()+"(自定义证件)—编号");
								userDefineNum.setPropertyName("certificateNum");
								userDefineNum.setNewValue(add.getCertificateNum());
							}
							if(add.getValidDate() != null){
								userDefineDate.setCreateTime(new Date());
								userDefineDate.setTableName("ass_assets_certificate");
								userDefineDate.setType(AssetsLogDetailTypeEnum.CERTIFICATE_ATTACHMENT.getNumber());
								userDefineDate.setAssetsLogId(assAssetsLog.getId());
								userDefineDate.setRemark(add.getName()+"(自定义证件)");
								
								userDefineDate.setField("valid_date");
								userDefineDate.setFieldName(add.getName()+"(自定义证件)—有效期至");
								userDefineDate.setPropertyName("validDate");
								userDefineDate.setNewValue(DateFormatUtils.getDateTime2(add.getValidDate().getTime()));
								
							}	
							logDetailList.add(userDefineNum);
							logDetailList.add(userDefineDate);
						}					
					}
					addList.clear();
				}
				
				if((reduceList !=null && reduceList.size()>0) && addList.size()==0){
					for (AssAssetsCertificate red : reduceList) {														
						if(red.getCertificateType()==5){
							List<AssAssetsLogDetail> listE = ReflectUtils.compareTwoClazzToLogDetail(red, new AssAssetsCertificate(), AssAssetsCertificate.class, AssetsLogDetailTypeEnum.CERTIFICATE_ATTACHMENT.getNumber());
							if(listE !=null && listE.size()>0){
								for (AssAssetsLogDetail e : listE) {
									if(e.getFieldName().equals("编号")){
										e.setFieldName(red.getName()+"(自定义证件)—编号");
									}
									if(e.getFieldName().equals("有效期至")){
										e.setFieldName(red.getName()+"(自定义证件)—有效期至");
									}
									e.setRemark(red.getName()+"(自定义证件)");//备注补充自定义证件名
								}
							}
							logDetailList.addAll(listE);	
						}								
					}
				}
				
				if(logDetailList !=null && logDetailList.size()>0){
					for (AssAssetsLogDetail item : logDetailList) {
						item.setAssetsLogId(assAssetsLog.getId());
					}
				}
				Set<String> set = new HashSet<String>();
				if(logDetailList !=null && logDetailList.size()>0){				
					for (AssAssetsLogDetail ld : logDetailList) {
						set.add(ld.getRemark());
					}
				}
				assAssetsLog.setRemark(authUser.getRealName()+"编辑了："+String.join(";", set));		
				if (logDetailList != null && logDetailList.size() > 0) {
					assAssetsLogMapper.updateById(assAssetsLog);
					assAssetsLogDetailService.insertBatch(logDetailList);
				}else {
					assAssetsLogMapper.deleteById(assAssetsLog.getId());
				}
			}		
		}
			
	}

	@Override
	public void add(AssAssetsCertificate assAssetsCertificate) {
		AuthUser authUser = WebSecurityUtils.getCurrentUser();
		assAssetsCertificate.setSysId(authUser.getTenantId());
		AssAssetsCertificate certificateByName = assAssetsCertificateMapper.getCertificateByName(assAssetsCertificate.getName(), assAssetsCertificate.getAssetsId(), authUser);
		if(certificateByName != null){
			throw ExceptionFactory.create("C_003");
		}
		if(assAssetsCertificate.getCertificateType().intValue() !=5){
			throw ExceptionFactory.create("C_004");
		}
		this.insert(assAssetsCertificate);
	}

	@Override
	public void delet(Long id) {
		AssAssetsCertificate certificateById = this.selectById(id);
		if(certificateById !=null){
			if(certificateById.getCertificateType() !=5){
				throw ExceptionFactory.create("D_001");
			}
		}
		certificateById.setDelFlag(true);
		this.updateById(certificateById);
		
	}

	@Override
	public void check(String name,Long assetsId,Long idFlag) {
		AuthUser authUser = WebSecurityUtils.getCurrentUser();
		//编辑
		if(idFlag != null){
			//原来的数据
			AssAssetsCertificate certificateByNameId = assAssetsCertificateMapper.getCertificateByNameId(name, assetsId, authUser, idFlag);
			if(certificateByNameId != null){
				//已修改名称
				if(!name.equals(certificateByNameId.getName())){
					AssAssetsCertificate certificateByName = assAssetsCertificateMapper.getCertificateByName(name, assetsId, authUser);
					if(certificateByName != null){
						throw ExceptionFactory.create("C_003");
					}	
				}
			}
		}else{
			AssAssetsCertificate certificateByName = assAssetsCertificateMapper.getCertificateByName(name, assetsId, authUser);
			if(certificateByName != null){
				throw ExceptionFactory.create("C_003");
			}
		}

		if (name.equals("医疗器械生产企业许可证")) {
			throw ExceptionFactory.create("C_003");
		}
		if (name.equals("医疗器械注册证")) {
			throw ExceptionFactory.create("C_003");
		}
		if (name.equals("医疗器械经营企业许可证")) {
			throw ExceptionFactory.create("C_003");
		}
		if (name.equals("产品合格证")) {
			throw ExceptionFactory.create("C_003");
		}
	}
	
}
