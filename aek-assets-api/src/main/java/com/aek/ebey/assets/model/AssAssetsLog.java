package com.aek.ebey.assets.model;

import com.aek.common.core.base.BaseModel;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import io.swagger.annotations.ApiModel;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 资产台账操作记录日志
 * </p>
 *
 * @author cyl
 * @since 2017-12-25
 */
@TableName("ass_assets_log")
public class AssAssetsLog extends BaseModel {

    private static final long serialVersionUID = 1L;

	/**
	 * 主键ID
	 */
	private Long id;
	/**
	 * 资产ID
	 */
	@TableField(value="assets_id")
	private Long assetsId;
	/**
	 * 模块类型(1=设备信息，2=采购信息，3=合同信息，4=证件管理)
	 */
	@TableField(value="module_type")
	private Integer moduleType;
	/**
	 * 操作类型(1=新增，2=编辑)
	 */
	@TableField(value="operate_type")
	private Integer operateType;
	/**
	 * 操作人ID
	 */
	@TableField(value="operate_by")
	private Long operateBy;
	/**
	 * 操作人名称
	 */
	@TableField(value="operate_by_name")
	private String operateByName;
	/**
	 * 操作日期
	 */
	@TableField(value="operate_time")
	private Date operateTime;
	/**
	 * 操作描述
	 */
	private String remark;


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

	public Integer getModuleType() {
		return moduleType;
	}

	public void setModuleType(Integer moduleType) {
		this.moduleType = moduleType;
	}

	public Integer getOperateType() {
		return operateType;
	}

	public void setOperateType(Integer operateType) {
		this.operateType = operateType;
	}

	public Long getOperateBy() {
		return operateBy;
	}

	public void setOperateBy(Long operateBy) {
		this.operateBy = operateBy;
	}

	public String getOperateByName() {
		return operateByName;
	}

	public void setOperateByName(String operateByName) {
		this.operateByName = operateByName;
	}

	public Date getOperateTime() {
		return operateTime;
	}

	public void setOperateTime(Date operateTime) {
		this.operateTime = operateTime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}


}
