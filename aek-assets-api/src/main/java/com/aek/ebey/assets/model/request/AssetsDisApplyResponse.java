package com.aek.ebey.assets.model.request;

import java.util.Date;
import java.util.List;
public class AssetsDisApplyResponse  {
	
	private Long id;
	private String num;
	private String name;
	private Date time;
	private String type;
	private String status;
	private List<AssetsDisResponse> list;
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<AssetsDisResponse> getList() {
		return list;
	}
	public void setList(List<AssetsDisResponse> list) {
		this.list = list;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	

}
