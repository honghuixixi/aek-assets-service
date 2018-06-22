package com.aek.ebey.assets.model.query;

import java.util.Date;

import com.aek.ebey.assets.model.AssetsLog;
import com.baomidou.mybatisplus.plugins.Page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "AssAssetsLogQuery", description = "资产日志列表请求")
public class AssAssetsLogQuery {

	@ApiModelProperty(value="设备id")
	private Long id;
	@ApiModelProperty(value="模块类别")
	private Integer modelType;
	@ApiModelProperty(value="开始时间")
	private String startTime;
	@ApiModelProperty(value="结束时间")
	private String endTime;;
	@ApiModelProperty(value="分页page")
	private Page<AssetsLog> page;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getModelType() {
		return modelType;
	}
	public void setModelType(Integer modelType) {
		this.modelType = modelType;
	}	
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public Page<AssetsLog> getPage() {
		return page;
	}
	public void setPage(Page<AssetsLog> page) {
		this.page = page;
	}

	
	
	
}
