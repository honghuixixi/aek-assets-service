package com.aek.ebey.assets.enums;

public enum ArchiveRetentionPeriodEnum {

	PERMANENTE(1,"永久"),
	LONG_TERM(2,"长期(16~50年)"),
	SHORT_TERM(3,"短期(15年以下)");
	
	private Integer number;
	private String desc;
	
	private ArchiveRetentionPeriodEnum(Integer number, String desc) {
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
