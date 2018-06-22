package com.aek.ebey.assets.model;

import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableField;

public class AssetsLog {

	private Long id;
	
	private Date operateTime;
	
	private Integer modelType;
	
	private Integer operateType;
	
	private String operateDetail;
	
	/**
	 * 操作类型字符串(1=新增，2=编辑)
	 */
	private String operateTypeStr;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public Integer getOperateType() {
		return operateType;
	}

	public void setOperateType(Integer operateType) {
		this.operateType = operateType;
	}

	public String getOperateDetail() {
		return operateDetail;
	}

	public void setOperateDetail(String operateDetail) {
		this.operateDetail = operateDetail;
	}

	public String getOperateTypeStr() {
		return operateTypeStr;
	}

	public void setOperateTypeStr(String operateTypeStr) {
		this.operateTypeStr = operateTypeStr;
	}
	
	
}
