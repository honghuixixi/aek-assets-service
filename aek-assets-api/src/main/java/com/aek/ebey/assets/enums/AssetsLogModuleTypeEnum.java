package com.aek.ebey.assets.enums;

/**
 *  设备编辑日志操作类型枚举类
 *	
 * @author HongHui
 * @date   2017年11月3日
 */
public enum AssetsLogModuleTypeEnum {

	ASSETS_INFO(1,"设备信息"),
	PURCHASE_INFO(2,"采购信息"),
	CONTRACT_INFO(3,"合同信息"),
	CERTIFICATE_INFO(4,"证件管理");
	
	private Integer number;
	private String desc;
	
	private AssetsLogModuleTypeEnum(Integer number, String desc) {
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
