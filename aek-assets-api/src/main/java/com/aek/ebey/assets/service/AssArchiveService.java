package com.aek.ebey.assets.service;

import com.aek.ebey.assets.model.AssArchive;
import com.aek.ebey.assets.model.query.ArchiveDiscardQuery;
import com.aek.ebey.assets.model.query.ArchivePageQuery;
import com.aek.ebey.assets.model.query.ArchiveTransferQuery;
import com.aek.ebey.assets.model.query.NewArchiveQuery;
import com.aek.ebey.assets.model.vo.ArchiveDiscardVo;
import com.aek.ebey.assets.model.vo.ArchivePageVo;
import com.aek.ebey.assets.model.vo.ArchiveTransferVo;
import com.aek.ebey.assets.model.vo.AssetArchiveDetailVo;
import com.aek.ebey.assets.model.vo.AssetArchiveVo;
import com.aek.ebey.assets.model.vo.AssetBasicInfoVo;
import com.aek.ebey.assets.model.vo.PreEditArchiveVo;
import com.baomidou.mybatisplus.plugins.Page;

import java.util.List;

import com.aek.common.core.base.BaseService;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author cyl
 * @since 2018-04-25
 */
public interface AssArchiveService extends BaseService<AssArchive> {
	
	PreEditArchiveVo preEditArchive(Long id);
	
	Page<ArchiveDiscardVo> getArchiveDiscardPage(ArchiveDiscardQuery query);
	
	/**
	 * 获取未建档设备
	 * @param query
	 * @return
	 */
	Page<AssetArchiveVo> getNewArchiveAssetsList(NewArchiveQuery query);
	
	void addArchive(AssArchive archive);
	
	void editArchive(AssArchive archive);
	
	/**
	 * 档案列表分页查询
	 * @param query
	 * @return
	 */
	Page<ArchivePageVo> getArchivePage(ArchivePageQuery query);
	
	AssetArchiveDetailVo getArchiveDetail(Long id);
	
	/**
	 * 查设备基本信息
	 */
	AssetBasicInfoVo getAssetBasicInfo(Long assetId);
	
	Page<ArchiveTransferVo> getArchiveTransferPage(ArchiveTransferQuery query);
}
