package com.aek.ebey.assets.model.vo;

import com.aek.ebey.assets.model.bo.ApplyInfo;
import com.aek.ebey.assets.model.bo.BillInfo;

public class TransferVo {

	private BillInfo billInfo;
	private ApplyInfo applyInfo;
	private Long id;
	
	public BillInfo getBillInfo() {
		return billInfo;
	}
	public void setBillInfo(BillInfo billInfo) {
		this.billInfo = billInfo;
	}
	public ApplyInfo getApplyInfo() {
		return applyInfo;
	}
	public void setApplyInfo(ApplyInfo applyInfo) {
		this.applyInfo = applyInfo;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
}
