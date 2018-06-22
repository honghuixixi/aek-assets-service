package com.aek.ebey.assets.model;

import com.aek.common.core.base.BaseModel;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 资产档案采购信息资金来源表
 * </p>
 *
 * @author cyl
 * @since 2018-04-28
 */
@TableName("ass_archive_purchase_info_fund_sources")
public class AssArchivePurchaseInfoFundSources extends BaseModel {

    private static final long serialVersionUID = 1L;

	/**
	 * 主键ID
	 */
	private Long id;
	/**
	 * 采购信息ID
	 */
	@TableField(value="purchase_id")
	private Long purchaseId;
	/**
	 * 资金来源类型(1=财政资金,2=自筹资金,3=捐赠,4=混合(财政资金+自筹资金）,5=其他)
	 */
	private Integer type;
	/**
	 * 资金来源名称
	 */
	private String name;
	/**
	 * 资金来源金额
	 */
	private Double money;
	/**
	 * 资金来源金额输出
	 */
	@TableField(exist=false)
	private String moneyStr;
	/**
	 * 混合子分类(1=财政资金，2=自筹资金)
	 */
	@TableField(value="sub_type")
	private Integer subType;
	/**
	 * 混合子分类名称
	 */
	@TableField(value="sub_name")
	private String subName;
	/**
	 * 创建时间
	 */
	@TableField(value="create_time")
	private Date createTime;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPurchaseId() {
		return purchaseId;
	}

	public void setPurchaseId(Long purchaseId) {
		this.purchaseId = purchaseId;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public Integer getSubType() {
		return subType;
	}

	public String getSubName() {
		return subName;
	}

	public void setSubName(String subName) {
		this.subName = subName;
	}

	public void setSubType(Integer subType) {
		this.subType = subType;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getMoneyStr() {
		return moneyStr;
	}

	public void setMoneyStr(String moneyStr) {
		this.moneyStr = moneyStr;
	}

}
