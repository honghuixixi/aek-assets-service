package com.aek.ebey.assets.enums;

public enum ArchiveSecrecyLevelEnum {

	OPEN_LEVEL(1,"公开级"),
	INNER_LEVEL(2,"内部级"),
	SECRET_LEVEL(3,"秘密级"),
	CONFIDENTIAL_LEVEL(4,"机密级"),
	TOP_SECRET_LEVEL(5,"绝密级");
	
	private Integer number;
	private String desc;
	
	private ArchiveSecrecyLevelEnum(Integer number, String desc) {
		this.number = number;
		this.desc = desc;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	
}
