package com.aek.ebey.assets.enums;

public enum ArchivePurchaseInfoTenderFormEnum {
	
	OPEN_BIDDING(1,"公开招标"),
	INVITATION_BIDDING(2,"邀请招标");
	
	private Integer number;
	private String desc;
	
	private ArchivePurchaseInfoTenderFormEnum(Integer number, String desc) {
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
