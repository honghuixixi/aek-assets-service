package com.aek.ebey.assets.enums;

/**
 *  设备维修状态枚举类
 *	
 * @author HongHui
 * @date   2017年11月3日
 */
public enum AssetsStatusEnum {

	IN_STORE(1,"在库"),
	IN_USE(2,"在用"),
	PRE_REGISTRATION(3,"预登"),
	UN_REPORT_LOSS(4, "待报损"),
	REPORT_LOSS(5, "报损"),
	REFUND(6, "退货"),
	VERIFY(8,"验收通过");
	
	private Integer number;
	private String desc;
	
	private AssetsStatusEnum(Integer number, String desc) {
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
