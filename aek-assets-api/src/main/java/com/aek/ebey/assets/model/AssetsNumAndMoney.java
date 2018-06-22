package com.aek.ebey.assets.model;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class AssetsNumAndMoney implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 资产状态
	 */
	@ApiModelProperty(value="资产数量")
	private String num;
	
	/**
	 * 资产数量
	 */
	@ApiModelProperty(value="资产价值")
	private String sumPrice;

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getSumPrice() {
		return sumPrice;
	}

	public void setSumPrice(String sumPrice) {
		this.sumPrice = sumPrice;
	}

	public AssetsNumAndMoney(String num, String sumPrice) {
		super();
		this.num = num;
		this.sumPrice = sumPrice;
	}

	public AssetsNumAndMoney() {
		super();
	}
	
	

}
