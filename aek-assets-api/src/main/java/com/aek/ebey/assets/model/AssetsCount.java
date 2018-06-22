package com.aek.ebey.assets.model;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel
public class AssetsCount implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 资产状态
	 */
	@ApiModelProperty(value="资产状态（1，设备资产数    4.维修设备数）")
	private String status;
	
	/**
	 * 资产数量
	 */
	@ApiModelProperty(value="资产数量")
	private Integer count;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}
	

}
