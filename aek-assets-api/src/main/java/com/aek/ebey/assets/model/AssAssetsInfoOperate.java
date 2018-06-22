package com.aek.ebey.assets.model;

import com.aek.common.core.base.BaseModel;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 预台帐操作记录
 * </p>
 *
 * @author aek
 * @since 2017-08-23
 */
@TableName("ass_assets_info_operate")
@ApiModel
public class AssAssetsInfoOperate extends BaseModel {

    private static final long serialVersionUID = 1L;

	
	/**
	 * 关联资产ID
	 */
	@TableField(value="assets_id")
	private Long assetsId;
	/**
	 * 操作时间
	 */
	@ApiModelProperty(value="操作时间")
	@TableField(value="operate_time")
	private Date operateTime;
	/**
	 * 操作日期
	 */
	@ApiModelProperty(value="操作日期")
	@TableField(value="operate_date")
	private Date operateDate;
	/**
	 * 操作说明
	 */
	@ApiModelProperty(value="操作说明")
	@TableField(value="operate_remark")
	private String operateRemark;
	/**
	 * 操作人
	 */
	@TableField(value="operate_by")
	private Long operateBy;
	
	
	
	@ApiModelProperty(value="操作人")
	@TableField(exist=false)
	private String operateName;
	/**
	 * 操作状态(1，创建预台帐，2，提交申请，3，验收不通过，4，验收通过）
	 */
	@ApiModelProperty(value="操作状态(1，创建预台帐，2，提交申请，3，验收不通过，4，验收通过）")
	@TableField(value="operate_status")
	private Integer operateStatus;


	public Long getAssetsId() {
		return assetsId;
	}

	public void setAssetsId(Long assetsId) {
		this.assetsId = assetsId;
	}

	public Date getOperateTime() {
		return operateTime;
	}

	public void setOperateTime(Date operateTime) {
		this.operateTime = operateTime;
	}

	public Date getOperateDate() {
		return operateDate;
	}

	public void setOperateDate(Date operateDate) {
		this.operateDate = operateDate;
	}

	public String getOperateRemark() {
		return operateRemark;
	}

	public void setOperateRemark(String operateRemark) {
		this.operateRemark = operateRemark;
	}

	public Long getOperateBy() {
		return operateBy;
	}

	public void setOperateBy(Long operateBy) {
		this.operateBy = operateBy;
	}

	public Integer getOperateStatus() {
		return operateStatus;
	}

	public void setOperateStatus(Integer operateStatus) {
		this.operateStatus = operateStatus;
	}

	public String getOperateName() {
		return operateName;
	}

	public void setOperateName(String operateName) {
		this.operateName = operateName;
	}

}
