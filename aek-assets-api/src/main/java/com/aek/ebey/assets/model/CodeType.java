package com.aek.ebey.assets.model;

import com.aek.common.core.base.BaseModel;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 基本代码类别表
 * </p>
 *
 * @author aek
 * @since 2017-04-13
 */
@TableName("ass_code_type")
public class CodeType extends BaseModel {

    private static final long serialVersionUID = 1L;

	/**
	 * 基础数据分类主键ID
	 */
	private Long id;
	/**
	 * 区域id
	 */
	@TableField(value="area_id")
	private Integer areaId;
	/**
	 * 系统ID。用于区分不同医院
	 */
	@TableField(value="sys_id")
	private Long sysId;
	/**
	 * 基础数据分类关键字
	 */
	@TableField(value="type_key")
	private String typeKey;
	/**
	 * 分类描述/备注
	 */
	@TableField(value="type_desc")
	private String typeDesc;
	/**
	 * 添加人
	 */
	@TableField(value="create_by")
	private Long createBy;
	/**
	 * 添加时间
	 */
	@TableField(value="create_time")
	private Date createTime;
	/**
	 * 最后修改人
	 */
	@TableField(value="update_by")
	private Long updateBy;
	/**
	 * 最后修改时间
	 */
	@TableField(value="update_time")
	private Date updateTime;
	/**
	 * 作废标记。0为有效，1为无效
	 */
	@TableField(value="del_flag")
	private Boolean delFlag;


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

	public Long getSysId() {
		return sysId;
	}

	public void setSysId(Long sysId) {
		this.sysId = sysId;
	}

	public String getTypeKey() {
		return typeKey;
	}

	public void setTypeKey(String typeKey) {
		this.typeKey = typeKey;
	}

	public String getTypeDesc() {
		return typeDesc;
	}

	public void setTypeDesc(String typeDesc) {
		this.typeDesc = typeDesc;
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

}
