package com.aek.ebey.assets.mapper;

import com.aek.ebey.assets.model.AssArchive;
import com.aek.ebey.assets.model.bo.ArchiveAssetBo;
import com.aek.ebey.assets.model.query.ArchiveDiscardQuery;
import com.aek.ebey.assets.model.query.ArchivePageQuery;
import com.aek.ebey.assets.model.query.ArchiveTransferQuery;
import com.aek.ebey.assets.model.query.NewArchiveQuery;
import com.aek.ebey.assets.model.vo.ArchiveDiscardVo;
import com.aek.ebey.assets.model.vo.ArchivePageVo;
import com.aek.ebey.assets.model.vo.ArchiveTransferVo;
import com.aek.ebey.assets.model.vo.AssetArchiveVo;
import com.aek.ebey.assets.model.vo.PreEditArchiveVo;
import com.baomidou.mybatisplus.plugins.Page;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.aek.common.core.base.BaseMapper;
import com.aek.common.core.serurity.model.AuthUser;

/**
 * <p>
 * Mapper接口
 * </p>
 *
 * @author cyl
 * @since 2018-04-25
 */
public interface AssArchiveMapper extends BaseMapper<AssArchive> {
	
	PreEditArchiveVo preEditArchive(@Param("id")Long id);
	
	String getDiscardDetail(@Param("discardId")Long discardId,@Param("assetId")Long assetId);
	
	List<ArchiveDiscardVo> getArchiveDiscardPage(@Param("user") AuthUser authUser,@Param("q")ArchiveDiscardQuery query);
	
	String getTransferDetail(@Param("transferId")Long transferId,@Param("assetId")Long assetId);
	
	/**
	 * 获取档案管理转科记录
	 * @param page
	 * @param query
	 * @param authUser
	 * @return
	 */
	List<ArchiveTransferVo> getArchiveTransferPage(Page<ArchiveTransferVo> page,@Param("q") ArchiveTransferQuery query,@Param("user") AuthUser authUser);

	/**
	 * 获取未建档设备
	 * @param authUser
	 * @param query
	 * @return
	 */
	List<AssetArchiveVo> getNewArchiveAssetsList(Page<AssetArchiveVo> page,@Param("user") AuthUser authUser,@Param("query") NewArchiveQuery query);
	
	/**
	 * 档案列表分页查询
	 * @param authUser
	 * @param query
	 * @return
	 */
	List<ArchivePageVo> getArchivePage(Page<ArchivePageVo> page,@Param("user") AuthUser authUser,@Param("q") ArchivePageQuery query);
	
	ArchiveAssetBo getAssetBasicInfo(@Param("assetId")Long assetId,@Param("user") AuthUser authUser);
}