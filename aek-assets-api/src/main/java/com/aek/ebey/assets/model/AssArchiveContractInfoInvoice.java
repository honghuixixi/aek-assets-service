package com.aek.ebey.assets.model;

import com.aek.common.core.base.BaseModel;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 资产档案合同信息发票表
 * </p>
 *
 * @author cyl
 * @since 2018-04-27
 */
@TableName("ass_archive_contract_info_invoice")
public class AssArchiveContractInfoInvoice extends BaseModel {

    private static final long serialVersionUID = 1L;

	/**
	 * 主键ID
	 */
	private Long id;
	/**
	 * 合同ID
	 */
	@TableField(value="contract_id")
	private Long contractId;
	/**
	 * 发票号
	 */
	@TableField(value="invoice_no")
	private String invoiceNo;
	/**
	 * 发票金额
	 */
	@TableField(value="invoice_money")
	private Double invoiceMoney;
	/**
	 * 发票日期
	 */
	@TableField(value="invoice_date")
	private Date invoiceDate;

	public AssArchiveContractInfoInvoice() {
	}
	
	public AssArchiveContractInfoInvoice(Long contractId, String invoiceNo) {
		super();
		this.contractId = contractId;
		this.invoiceNo = invoiceNo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getContractId() {
		return contractId;
	}

	public void setContractId(Long contractId) {
		this.contractId = contractId;
	}

	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public Double getInvoiceMoney() {
		return invoiceMoney;
	}

	public void setInvoiceMoney(Double invoiceMoney) {
		this.invoiceMoney = invoiceMoney;
	}

	public Date getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

}
