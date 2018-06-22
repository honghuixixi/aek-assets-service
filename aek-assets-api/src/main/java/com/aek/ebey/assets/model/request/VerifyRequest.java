package com.aek.ebey.assets.model.request;

public class VerifyRequest {
	
	private Long id;
	
	/**
	 * 1:通过 2未通过
	 */
	private int status;
	
	private String remarks;

	private String suggestion;
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getSuggestion() {
		return suggestion;
	}

	public void setSuggestion(String suggestion) {
		this.suggestion = suggestion;
	}
	
	

}
