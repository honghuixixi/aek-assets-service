package com.aek.ebey.assets.mapper;

import com.aek.ebey.assets.model.AssetsInvoice;
import com.aek.common.core.base.BaseMapper;

/**
 * <p>
  * 资产发票表 Mapper 接口
 * </p>
 *
 * @author aek
 * @since 2017-04-13
 */
public interface AssetsInvoiceMapper extends BaseMapper<AssetsInvoice> {

	void updateAssetsInvoice(AssetsInvoice assetsInvoice);

	String getInVoiceNum(Long assetId);
}