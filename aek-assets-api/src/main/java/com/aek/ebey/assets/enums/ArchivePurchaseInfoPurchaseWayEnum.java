package com.aek.ebey.assets.enums;

public enum ArchivePurchaseInfoPurchaseWayEnum {

	INTERNATIONAL_BIDDING(1,"国际招标"),
	GOVERNMENT_PROCUREMENT(2,"政府采购"),
	HOSPITAL_PURCHASE(3,"院内采购"),
	DECENTRALIZED_PURCHASING(4,"分散采购"),
	SELF_PURCHASE(5,"自行采购"),
	OTHER(6,"其他");
	
	private Integer number;
	private String desc;
	
	private ArchivePurchaseInfoPurchaseWayEnum(Integer number, String desc) {
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
