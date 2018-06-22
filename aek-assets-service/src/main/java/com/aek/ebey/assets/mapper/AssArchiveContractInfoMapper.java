package com.aek.ebey.assets.mapper;

import com.aek.ebey.assets.model.AssArchiveContractInfo;
import com.aek.ebey.assets.model.vo.ArchiveContractInfoVo;

import org.apache.ibatis.annotations.Param;

import com.aek.common.core.base.BaseMapper;

/**
 * <p>
 * Mapper接口
 * </p>
 *
 * @author cyl
 * @since 2018-04-27
 */
public interface AssArchiveContractInfoMapper extends BaseMapper<AssArchiveContractInfo> {

	ArchiveContractInfoVo getContract(@Param("archiveId")Long archiveId,@Param("assetsId") Long assetsId);
	
	void updateContract(@Param("contract")AssArchiveContractInfo contract);
}