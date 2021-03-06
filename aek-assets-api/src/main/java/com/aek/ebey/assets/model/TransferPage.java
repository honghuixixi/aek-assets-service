package com.aek.ebey.assets.model;

import java.util.Date;
import java.util.List;

import com.aek.ebey.assets.model.vo.AssetTransferPageVo;

public class TransferPage {

	private Long id;
	private String num;
	private String name;
	private Date time;
	private String status;
	private Integer statusInt;
	private String toDeptName;
	private List<AssetTransferPageVo> list;
	
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<AssetTransferPageVo> getList() {
		return list;
	}
	public void setList(List<AssetTransferPageVo> list) {
		this.list = list;
	}
	public Integer getStatusInt() {
		return statusInt;
	}
	public void setStatusInt(Integer statusInt) {
		this.statusInt = statusInt;
	}
	public String getToDeptName() {
		return toDeptName;
	}
	public void setToDeptName(String toDeptName) {
		this.toDeptName = toDeptName;
	}
	
}
