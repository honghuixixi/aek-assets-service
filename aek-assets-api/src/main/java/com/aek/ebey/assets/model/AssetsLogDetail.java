package com.aek.ebey.assets.model;

import java.util.Date;
import java.util.List;

import com.aek.ebey.assets.model.vo.OperateLog;

public class AssetsLogDetail {

	private Long id;
	private Date operateTime;
	private Integer modelType;
	private String operateName;
	private List<OperateLog> operateList;
	
	public Long getId() {
		return id;
	}
	public void setiId(Long id) {
		this.id = id;
	}
	public Date getOperateTime() {
		return operateTime;
	}
	public void setOperateTime(Date operateTime) {
		this.operateTime = operateTime;
	}
	public Integer getModelType() {
		return modelType;
	}
	public void setModelType(Integer modelType) {
		this.modelType = modelType;
	}
	public String getOperateName() {
		return operateName;
	}
	public void setOperateName(String operateName) {
		this.operateName = operateName;
	}
	public List<OperateLog> getOperateList() {
		return operateList;
	}
	public void setOperateList(List<OperateLog> operateList) {
		this.operateList = operateList;
	}
	
	
}
