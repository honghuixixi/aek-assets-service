package com.aek.ebey.assets.model.query;

import com.aek.ebey.assets.model.TransferPage;
import com.baomidou.mybatisplus.plugins.Page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "TransferQuery", description = "转科单列表请求")
public class TransferQuery {

	@ApiModelProperty(value="转科单号/设备名称-关键词")
	private String keyword;
	@ApiModelProperty(value="所在科室id")
	private Long deptId;
	@ApiModelProperty(value="转科单状态 取值：0:全部 1:审核通过 2:待审核 3:审核未通过")
	private Integer status;
	@ApiModelProperty(value="转科单范围 取值：1：全部 2：我的申请")
	private Integer scope;
	@ApiModelProperty(value="分页page")
	private Page<TransferPage> page;
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
	public Integer getScope() {
		return scope;
	}
	public void setScope(Integer scope) {
		this.scope = scope;
	}
	public Page<TransferPage> getPage() {
		return page;
	}
	public void setPage(Page<TransferPage> page) {
		this.page = page;
	}

}
