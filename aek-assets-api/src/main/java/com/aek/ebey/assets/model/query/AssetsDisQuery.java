package com.aek.ebey.assets.model.query;

import com.aek.ebey.assets.core.util.LiuHuiFrontPage;
import com.aek.ebey.assets.model.request.AssetsDisResponse;

public class AssetsDisQuery extends LiuHuiFrontPage<AssetsDisResponse>{

	/**
	 * 设备名称/设备编号
	 */
	private String keyword;
	
	/**
	 * 报损类型（1，在用 2，在库 3，附件）
	 */
	private int status;
	
	/**
	 * 设备部门id
	 */
	private Long deptId;

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Long getDeptId() {
		return deptId;
	}

	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}

	
}
