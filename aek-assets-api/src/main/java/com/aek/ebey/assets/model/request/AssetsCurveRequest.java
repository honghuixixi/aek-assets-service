package com.aek.ebey.assets.model.request;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class AssetsCurveRequest {

	@ApiModelProperty(notes="状态.默认不传,维修时传入4", allowableValues=",4")
	private Integer status;
	@ApiModelProperty(notes="自定义时间段时,不需要传入该参数;0:上月;1:本月;2:本季度;3:本年",allowableValues=",0,1,2,3")
	private String dateLabel;
	@ApiModelProperty(notes="开始时间")
	private Date startDate;
	@ApiModelProperty(notes="截止时间")
	private Date endDate;

	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getDateLabel() {
		return dateLabel;
	}
	public void setDateLabel(String dateLabel) {
		this.dateLabel = dateLabel;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
}
