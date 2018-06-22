package com.aek.ebey.assets.model;

import com.aek.common.core.base.BaseModel;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 资产资金分布统计范围表
 * </p>
 *
 * @author cyl
 * @since 2018-04-18
 */
@TableName("ass_distribution_capital_range")
public class AssDistributionCapitalRange extends BaseModel {

    private static final long serialVersionUID = 1L;

	/**
	 * 主键ID
	 */
	private Long id;
	/**
	 * 机构ID
	 */
	@TableField(value="tenant_id")
	private Long tenantId;
	/**
	 * 类型（1-系统默认，2-自定义）
	 */
	private Integer type;
	/**
	 * 最小资金(单位：万元）
	 */
	@TableField(value="min_capital")
	private Double minCapital;
	/**
	 * 最大资金（万元）
	 */
	@TableField(value="max_capital")
	private Double maxCapital;
	/**
	 * 排序1,2,3
	 */
	private Integer sort;
	/**
	 * 描述
	 */
	private String remarks;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTenantId() {
		return tenantId;
	}

	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Double getMinCapital() {
		return minCapital;
	}

	public void setMinCapital(Double minCapital) {
		this.minCapital = minCapital;
	}

	public Double getMaxCapital() {
		return maxCapital;
	}

	public void setMaxCapital(Double maxCapital) {
		this.maxCapital = maxCapital;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}
