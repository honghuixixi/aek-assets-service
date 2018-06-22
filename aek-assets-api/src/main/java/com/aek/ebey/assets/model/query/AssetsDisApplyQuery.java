package com.aek.ebey.assets.model.query;

import com.aek.ebey.assets.core.util.LiuHuiFrontPage;
import com.aek.ebey.assets.model.request.AssetsDisApplyResponse;

public class AssetsDisApplyQuery extends LiuHuiFrontPage<AssetsDisApplyResponse>{

	/**
	 * 报损单号/设备编号
	 */
	private String keyword;
	
	/**
	 * 设备部门id
	 */
	private Long deptId;
	
	/**
	 *报损单状态 取值：
	0:全部
	1:待审核
	2:审核通过
	3:审核未通过
	 */
	private Integer status;
	
	/**
	 * 报损单范围 取值：
	1：全部
	2：我的申请
	 */
	private int scope;
	
	/**
	 * 报损类型 取值：
	1:在用
	2:在库
	3:配件
	 */
	private int type;

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public Long getDeptId() {
		return deptId;
	}

	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public int getScope() {
		return scope;
	}

	public void setScope(int scope) {
		this.scope = scope;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	
}
