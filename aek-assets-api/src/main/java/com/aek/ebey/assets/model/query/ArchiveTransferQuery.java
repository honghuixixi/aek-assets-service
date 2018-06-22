package com.aek.ebey.assets.model.query;

import com.aek.common.core.base.page.PageHelp;
import com.aek.ebey.assets.model.vo.ArchiveTransferVo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class ArchiveTransferQuery extends PageHelp<ArchiveTransferVo>{

	@ApiModelProperty("设备id")
	private Long assetId;
	@ApiModelProperty("查询关键字")
	private String keyword;
	@ApiModelProperty("开始时间")
	private String startDate;
	@ApiModelProperty("结束时间")
	private String endDate;
	
	public Long getAssetId() {
		return assetId;
	}
	public void setAssetId(Long assetId) {
		this.assetId = assetId;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
}
