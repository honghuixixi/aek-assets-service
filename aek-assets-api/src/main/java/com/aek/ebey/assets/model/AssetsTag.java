package com.aek.ebey.assets.model;

import java.util.Date;

import com.aek.common.core.base.BaseModel;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 资产标签实体类
 *	
 * @author HongHui
 * @date   2017年12月26日
 */
@TableName("ass_assets_tag")
@ApiModel(value = "AssetsTag", description = "资产标签打印内容")
public class AssetsTag extends BaseModel{

	private static final long serialVersionUID = -3219241391816942430L;
	
	/**
	 * 资产标签打印内容宽度
	 */
	@ApiModelProperty(value = "标签宽度，单位:px")
	@TableField(value="width")
	private Float width;
	
	/**
	 * 资产标签打印内容高度
	 */
	@ApiModelProperty(value = "标签高度，单位:px")
	@TableField(value="height")
	private Float height;
	
	/**
	 * 资产标签打印内容
	 */
	@ApiModelProperty(value = "资产标签打印HTML内容")
	@TableField(value="content")
	private String content;
	
	/**
	 * 资产标签打印类型1=标准，2=自定义
	 */
	@ApiModelProperty(value = "标签类型(1=标准，2=自定义)")
	@TableField(value="type")
	private Integer type;
	
	/**
	 * 资产标签数据sql
	 */
	@ApiModelProperty(value = "资产标签数据sql")
	@TableField(value="assets_sql")
	private String assetsSql;
	
	/**
	 * 资产标签启用状态0=已禁用，1=启用
	 */
	@ApiModelProperty(value = "启用状态(0=禁用，1=启用)")
	@TableField(value="enable")
	private Boolean enable;
	
	/**
	 * 资产标签删除状态0=未删除，1=已删除
	 */
	@ApiModelProperty(value = "删除标记(0=未删除，1=已删除)")
	@TableField(value="del_flag")
	private Boolean delFlag;
	
	/**
	 * 资产标签创建时间
	 */
	@ApiModelProperty(value = "创建时间")
	@TableField(value="create_time")
	private Date createTime;
	
	/**
	 * 资产标签备注说明
	 */
	@ApiModelProperty(value = "备注说明")
	@TableField(value="remark")
	private String remark;

	public Float getWidth() {
		return width;
	}

	public void setWidth(Float width) {
		this.width = width;
	}

	public Float getHeight() {
		return height;
	}

	public void setHeight(Float height) {
		this.height = height;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Boolean getEnable() {
		return enable;
	}

	public void setEnable(Boolean enable) {
		this.enable = enable;
	}

	public Boolean getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Boolean delFlag) {
		this.delFlag = delFlag;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getAssetsSql() {
		return assetsSql;
	}

	public void setAssetsSql(String assetsSql) {
		this.assetsSql = assetsSql;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
