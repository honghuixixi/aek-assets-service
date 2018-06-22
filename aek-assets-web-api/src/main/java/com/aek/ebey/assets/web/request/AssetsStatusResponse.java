package com.aek.ebey.assets.web.request;

import io.swagger.annotations.ApiModel;

/**
 * 资产状态返回实体类
 *	
 * @author HongHui
 * @date   2017年12月8日
 */
@ApiModel(value = "AssetsStatusResponse", description = "设备状态信息")
public class AssetsStatusResponse {
	/**
	 * 设备id
	 */
	private Long assetsId;
	/**
	 * 设备状态
	 */
	private Integer status;
	
	/**
	 * 设备名称
	 */
	private String statusName;

	public Long getAssetsId() {
		return assetsId;
	}

	public void setAssetsId(Long assetsId) {
		this.assetsId = assetsId;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	
	
}
