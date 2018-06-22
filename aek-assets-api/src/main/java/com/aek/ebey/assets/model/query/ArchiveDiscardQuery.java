package com.aek.ebey.assets.model.query;

import com.aek.common.core.base.page.PageHelp;
import com.aek.ebey.assets.model.vo.ArchiveDiscardVo;

public class ArchiveDiscardQuery extends PageHelp<ArchiveDiscardVo>{
	
	private Long assetId;

	public Long getAssetId() {
		return assetId;
	}

	public void setAssetId(Long assetId) {
		this.assetId = assetId;
	}
	
}
