package com.aek.ebey.assets.enums;

public enum ArchivePurchaseInfoApplyTypeEnum {

	NEW(1,"新增"),
	ADD(2,"添置"),
	DISCARD_UPDATE(3,"报废更新");
	
	private Integer number;
	private String desc;
	
	private ArchivePurchaseInfoApplyTypeEnum(Integer number, String desc) {
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
