package com.aek.ebey.assets.enums;

/**
 *  设备编辑日志明细类型枚举类
 *	
 * @author HongHui
 * @date   2017年11月3日
 */
public enum AssetsLogDetailTypeEnum {

	FIELD_ADD_EDIT(1,"字段新增/修改"),
	CONTRACT_ATTACHMENT(2,"合同附件"),
	INVITE_ATTACHMENT(3,"招标附件"),
	CHECK_ATTACHMENT(4,"验收附件"),
	CERTIFICATE_ATTACHMENT(5,"证件管理");
	
	private Integer number;
	private String desc;
	
	private AssetsLogDetailTypeEnum(Integer number, String desc) {
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
