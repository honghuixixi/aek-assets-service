package com.aek.ebey.assets.model;

import com.aek.common.core.base.BaseModel;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 会计日历表
 * </p>
 *
 * @author aek
 * @since 2017-04-13
 */
@TableName("ass_fiscal_periods")
public class FiscalPeriods extends BaseModel {

    private static final long serialVersionUID = 1L;

	/**
	 * 会计期间id，会计日历表主键
	 */
	private Long id;
	/**
	 * 区域id
	 */
	@TableField(value="area_id")
	private Integer areaId;
	/**
	 * 系统id
	 */
	@TableField(value="sys_id")
	private Integer sysId;
	/**
	 * 会计期间所属年份
	 */
	@TableField(value="period_year")
	private Integer periodYear;
	/**
	 * 会计期间编码，如：201202
	 */
	@TableField(value="period_no")
	private Integer periodNo;
	/**
	 * 会计期间状态：0：未使用、1：使用中、2：已结转。
	 */
	@TableField(value="period_state")
	private Integer periodState;
	/**
	 * 会计期间开始日期
	 */
	@TableField(value="start_date")
	private Date startDate;
	/**
	 * 会计期间结束日期
	 */
	@TableField(value="end_date")
	private Date endDate;
	/**
	 * 添加人id
	 */
	@TableField(value="create_by")
	private Long createBy;
	/**
	 * 添加时间
	 */
	@TableField(value="create_time")
	private Date createTime;
	/**
	 * 最后修改人id
	 */
	@TableField(value="update_by")
	private Long updateBy;
	/**
	 * 最后修改时间
	 */
	@TableField(value="update_time")
	private Date updateTime;
	/**
	 * 作废标记：0有效，1无效。
	 */
	@TableField(value="del_flag")
	private Boolean delFlag;
	/**
	 * 会计期间月份
	 */
	@TableField(value="period_month")
	private Integer periodMonth;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getAreaId() {
		return areaId;
	}

	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

	public Integer getSysId() {
		return sysId;
	}

	public void setSysId(Integer sysId) {
		this.sysId = sysId;
	}

	public Integer getPeriodYear() {
		return periodYear;
	}

	public void setPeriodYear(Integer periodYear) {
		this.periodYear = periodYear;
	}

	public Integer getPeriodNo() {
		return periodNo;
	}

	public void setPeriodNo(Integer periodNo) {
		this.periodNo = periodNo;
	}

	public Integer getPeriodState() {
		return periodState;
	}

	public void setPeriodState(Integer periodState) {
		this.periodState = periodState;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Long getCreateBy() {
		return createBy;
	}

	public void setCreateBy(Long createBy) {
		this.createBy = createBy;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Long getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(Long updateBy) {
		this.updateBy = updateBy;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Boolean isDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Boolean delFlag) {
		this.delFlag = delFlag;
	}

	public Integer getPeriodMonth() {
		return periodMonth;
	}

	public void setPeriodMonth(Integer periodMonth) {
		this.periodMonth = periodMonth;
	}

}
