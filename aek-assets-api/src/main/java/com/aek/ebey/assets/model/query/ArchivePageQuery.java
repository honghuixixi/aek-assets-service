package com.aek.ebey.assets.model.query;

import com.aek.common.core.base.page.PageHelp;
import com.aek.ebey.assets.model.vo.ArchivePageVo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class ArchivePageQuery extends PageHelp<ArchivePageVo>{

	@ApiModelProperty("查询关键字")
	private String keyword;
	@ApiModelProperty("保密级别")
	private Integer secretLevel;
	@ApiModelProperty("立卷时间起始")
	private String filingTimeStart;
	@ApiModelProperty("立卷时间结束")
	private String filingTimeEnd;
	
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public Integer getSecretLevel() {
		return secretLevel;
	}
	public void setSecretLevel(Integer secretLevel) {
		this.secretLevel = secretLevel;
	}
	public String getFilingTimeStart() {
		return filingTimeStart;
	}
	public void setFilingTimeStart(String filingTimeStart) {
		this.filingTimeStart = filingTimeStart;
	}
	public String getFilingTimeEnd() {
		return filingTimeEnd;
	}
	public void setFilingTimeEnd(String filingTimeEnd) {
		this.filingTimeEnd = filingTimeEnd;
	}
	
}
