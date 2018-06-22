package com.aek.ebey.assets.model;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * 只给前端提供台账导出可选字段
 * 
 * @author zhousixiong
 * @version 1.0, 2017年5月27日
 */
@ApiModel
public class Feilds implements Serializable {

	private static final long serialVersionUID = 1L;
	public static final boolean MUST = true;
	public static final byte PURCHASE = 2;// 2:采购 1：设备【默认】

	@ApiModelProperty(value = "名称")
	private String name;

	@ApiModelProperty(value = "字段")
	private String para;

	@ApiModelProperty(value = "是否必填【true为必填】")
	private Boolean select = false;

	@ApiModelProperty(value = "分类 1=设备信息，2=采购信息，3=合同信息")
	private Integer index = 1;

	public Feilds(String name, String para, Boolean select, Integer index) {
		this.name = name;
		this.para = para;
		this.select = select;
		this.index = index;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPara() {
		return para;
	}

	public void setPara(String para) {
		this.para = para;
	}

	public Boolean getSelect() {
		return select;
	}

	public void setSelect(Boolean select) {
		this.select = select;
	}

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

}
