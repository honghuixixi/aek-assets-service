package com.aek.ebey.assets.model;

import com.aek.common.core.base.BaseModel;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 资产台账操作记录日志明细
 * </p>
 *
 * @author cyl
 * @since 2017-12-25
 */
@TableName("ass_assets_log_detail")
public class AssAssetsLogDetail extends BaseModel {

    private static final long serialVersionUID = 1L;

	/**
	 * 主键ID
	 */
	private Long id;
	/**
	 * 资产日志主表ID
	 */
	@TableField(value="assets_log_id")
	private Long assetsLogId;
	/**
	 * 类型(1=字段新增/修改，2=合同附件，3=招标附件，4=验收附件，5=证件管理)
	 */
	private Integer type;
	/**
	 * 数据库表名称
	 */
	@TableField(value="table_name")
	private String tableName;
	/**
	 * 数据库字段名称
	 */
	private String field;
	/**
	 * 数据库字段中文名称
	 */
	@TableField(value="field_name")
	private String fieldName;
	/**
	 * Java对象属性名称
	 */
	@TableField(value="property_name")
	private String propertyName;
	/**
	 * 旧值
	 */
	@TableField(value="old_value")
	private String oldValue;
	/**
	 * 新值
	 */
	@TableField(value="new_value")
	private String newValue;
	/**
	 * 创建时间
	 */
	@TableField(value="create_time")
	private Date createTime;
	/**
	 * 日志明细描述
	 */
	private String remark;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAssetsLogId() {
		return assetsLogId;
	}

	public void setAssetsLogId(Long assetsLogId) {
		this.assetsLogId = assetsLogId;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public String getOldValue() {
		return oldValue;
	}

	public void setOldValue(String oldValue) {
		this.oldValue = oldValue;
	}

	public String getNewValue() {
		return newValue;
	}

	public void setNewValue(String newValue) {
		this.newValue = newValue;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
