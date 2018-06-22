package com.aek.ebey.assets.mapper;

import com.aek.ebey.assets.model.AssAssetsTransfer;
import com.aek.ebey.assets.model.TransferPage;
import com.aek.ebey.assets.model.query.TransferQuery;
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
 * @author aek
 * @since 2017-12-11
 */
public interface AssAssetsTransferMapper extends BaseMapper<AssAssetsTransfer> {

	public List<TransferPage> getTransferPage(@Param("page")Page<TransferPage> page,@Param("q")TransferQuery query,@Param("user") AuthUser currentUser);

	/**
	 * 统计本机构待审核的转科单数目
	 * @param tenantId
	 * @return
	 */
	public Integer statsWaitAudit(@Param("tenantId")Long tenantId);
}