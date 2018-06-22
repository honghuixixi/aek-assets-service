package com.aek.ebey.assets.enums;

/**
 *  设备编辑日志操作类型枚举类
 *	
 * @author HongHui
 * @date   2017年11月3日
 */
public enum AssetsLogOperateTypeEnum {

	ADD(1,"新增"),
	EDIT(2,"编辑");
	
	private Integer number;
	private String desc;
	
	private AssetsLogOperateTypeEnum(Integer number, String desc) {
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
