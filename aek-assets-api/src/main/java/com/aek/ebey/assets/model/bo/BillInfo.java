package com.aek.ebey.assets.model.bo;

import java.util.List;

public class BillInfo {

	private Long id;
	
	private String num;
	
	private String status;
	
	private List<OperateXX> results;

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

	public List<OperateXX> getResults() {
		return results;
	}

	public void setResults(List<OperateXX> results) {
		this.results = results;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	
	
	
	
}
