package com.aek.ebey.assets.service.impl;

import com.aek.ebey.assets.mapper.AssArchiveCertificateInfoMapper;
import com.aek.ebey.assets.model.AssArchiveCertificateInfo;
import com.aek.ebey.assets.service.AssArchiveCertificateInfoService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.google.common.collect.Lists;
import com.aek.common.core.base.BaseServiceImpl;
import com.aek.common.core.exception.ExceptionFactory;
import com.aek.common.core.serurity.WebSecurityUtils;
import com.aek.common.core.serurity.model.AuthUser;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 资产档案证件信息表 服务实现类
 * </p>
 *
 * @author cyl
 * @since 2018-04-26
 */
@Service
@Transactional
public class AssArchiveCertificateInfoServiceImpl extends BaseServiceImpl<AssArchiveCertificateInfoMapper,AssArchiveCertificateInfo> implements AssArchiveCertificateInfoService {

	@Autowired
	private AssArchiveCertificateInfoMapper assArchiveCertificateInfoMapper;
	@Autowired
	private AssArchiveCertificateInfoService assArchiveCertificateInfoService;
	
	@Override
	public List<AssArchiveCertificateInfo> getCertificateInfo(Long archiveId, Long assetsId) {
		Wrapper<AssArchiveCertificateInfo> wrapper = new EntityWrapper<AssArchiveCertificateInfo>();
		wrapper.eq("del_flag", false).eq("archive_id", archiveId).eq("assets_id", assetsId);
		List<AssArchiveCertificateInfo> certificateListDb = assArchiveCertificateInfoMapper.selectList(wrapper);
		if(certificateListDb!=null&&certificateListDb.size()>0){
			return certificateListDb;
		}else {
			AuthUser currentUser = WebSecurityUtils.getCurrentUser();
			Long currentUserId = currentUser.getId();
			Date now = new Date();
			List<AssArchiveCertificateInfo> certificateList = Lists.newArrayList();		
			certificateList.add(new AssArchiveCertificateInfo(archiveId, assetsId, 1, "医疗器械生产企业许可证", false, currentUserId, now, currentUserId, now));
			certificateList.add(new AssArchiveCertificateInfo(archiveId, assetsId, 2, "医疗器械注册证", false, currentUserId, now, currentUserId, now));
			certificateList.add(new AssArchiveCertificateInfo(archiveId, assetsId, 3, "医疗器械经营企业许可证", false, currentUserId, now, currentUserId, now));
			certificateList.add(new AssArchiveCertificateInfo(archiveId, assetsId, 4, "产品合格证", false, currentUserId, now, currentUserId, now));
			//初始化档案证件表
			assArchiveCertificateInfoService.insertBatch(certificateList);	
			return certificateList;
		}
	}

	@Override
	public void insertOrUpdateCertificateInfo(AssArchiveCertificateInfo certificate) {
		Integer type = certificate.getCertificateType();
		AuthUser currentUser = WebSecurityUtils.getCurrentUser();
		Long currentUserId = currentUser.getId();
		Date now = new Date();
		certificate.setUpdateBy(currentUserId);
		certificate.setUpdateTime(now);
		//1=医疗器械生产企业许可证、2=医疗器械注册证、3=医疗器械经营企业许可证、4=产品合格证
		if(type!=5){
			AssArchiveCertificateInfo certificateDb = assArchiveCertificateInfoMapper.selectById(certificate.getId());
			if(certificateDb==null)return;		
			assArchiveCertificateInfoMapper.updateCertificate(certificate);
		}else {
			//5=自定义证件
			String name = certificate.getName();
			Long id = certificate.getId();
			AssArchiveCertificateInfo certificateCustomDb=new AssArchiveCertificateInfo();
			if(id != null){
				certificateCustomDb = assArchiveCertificateInfoMapper.selectById(id);
			}
			//固有证件名判重
			if("医疗器械生产企业许可证".equals(name) || "医疗器械注册证".equals(name) || "医疗器械经营企业许可证".equals(name) || "产品合格证".equals(name)){
				throw ExceptionFactory.create("AR_003");
			}
			//自定义证件之间名判重
			if(!name.equals(certificateCustomDb.getName())){
				Wrapper<AssArchiveCertificateInfo> wrapper = new EntityWrapper<AssArchiveCertificateInfo>();
				wrapper.eq("del_flag", false).eq("certificate_type", 5).eq("archive_id", certificate.getArchiveId()).eq("assets_id", certificate.getAssetsId()).eq("name", name);
				List<AssArchiveCertificateInfo> selectList = assArchiveCertificateInfoMapper.selectList(wrapper);
				if(selectList!=null&&selectList.size()>0){
					AssArchiveCertificateInfo certificateInfo = selectList.get(0);
					if(certificateInfo!=null){
						throw ExceptionFactory.create("AR_003");
					}
				}
			}
			//无更新记录便插入
			if(assArchiveCertificateInfoMapper.updateCertificate(certificate)<1){
				certificate.setCreateBy(currentUserId);
				certificate.setCreateTime(now);
				assArchiveCertificateInfoMapper.insert(certificate);
			}			
		}
	}

	@Override
	public void delete(Long id) {
		AssArchiveCertificateInfo certificateDb = assArchiveCertificateInfoMapper.selectById(id);
		if(certificateDb==null)throw ExceptionFactory.create("AR_008");
		Integer certificateType = certificateDb.getCertificateType();
		if(certificateType!=5)throw ExceptionFactory.create("AR_009");
		Date now = new Date();
		AuthUser currentUser = WebSecurityUtils.getCurrentUser();
		certificateDb.setDelFlag(true);
		certificateDb.setUpdateBy(currentUser.getId());
		certificateDb.setUpdateTime(now);
		assArchiveCertificateInfoMapper.updateById(certificateDb);
	}
	
}
