package com.aek.ebey.assets.model.request;

import java.util.Date;

public class OperateInfo {
	/**
	 * 操作人名称
	 */
	private String name;
	
	/**
	 * 操作名称
	 */
	private String operate;
	
	/**
	 * 操作时间
	 */
	private Date time;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOperate() {
		return operate;
	}

	public void setOperate(String operate) {
		this.operate = operate;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}
	

}
