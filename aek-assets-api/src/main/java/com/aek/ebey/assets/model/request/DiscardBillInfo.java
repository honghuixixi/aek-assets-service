package com.aek.ebey.assets.model.request;

import java.util.List;

public class DiscardBillInfo {
	/**
	 * 报损单id
	 */
	private Long id;
	
	/**
	 * 报损单号
	 */
	private String num;
	
	/**
	 * 报损单审核信息
	 */
	private List<OperateInfo> results;
	
	
	private String status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public List<OperateInfo> getResults() {
		return results;
	}

	public void setResults(List<OperateInfo> results) {
		this.results = results;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	

}
