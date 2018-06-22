package com.aek.ebey.assets.model;

import com.aek.common.core.base.BaseModel;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 资产发票表
 * </p>
 *
 * @author aek
 * @since 2017-04-13
 */
@TableName("ass_assets_invoice")
public class AssetsInvoice extends BaseModel {

    private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	private Long id;
	/**
	 * 资产ID
	 */
	@TableField(value="assets_id")
	private Long assetsId;
	/**
	 * 发票号
	 */
	@TableField(value="invoice_no")
	private String invoiceNo;
	/**
	 * 发票金额
	 */
	@TableField(value="invoice_money")
	private Long invoiceMoney;
	/**
	 * 发票日期
	 */
	@TableField(value="invoice_date")
	private Date invoiceDate;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAssetsId() {
		return assetsId;
	}

	public void setAssetsId(Long assetsId) {
		this.assetsId = assetsId;
	}

	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public Long getInvoiceMoney() {
		return invoiceMoney;
	}

	public void setInvoiceMoney(Long invoiceMoney) {
		this.invoiceMoney = invoiceMoney;
	}

	public Date getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

}
