package com.aek.ebey.assets.mapper;

import com.aek.ebey.assets.model.AssAssetsTransferDetail;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.aek.common.core.base.BaseMapper;

/**
 * <p>
 * Mapper接口
 * </p>
 *
 * @author cyl
 * @since 2017-12-14
 */
public interface AssAssetsTransferDetailMapper extends BaseMapper<AssAssetsTransferDetail> {

	List<AssAssetsTransferDetail> getTransferDetail(@Param("transferId")Long transferId);
	
	AssAssetsTransferDetail getTransferDetailByAssetsId(@Param("transferId")Long transferId,@Param("assetsId")Long assetsId);

	String getDeptNameByTransferId(@Param("transferId")Long transferId);
}