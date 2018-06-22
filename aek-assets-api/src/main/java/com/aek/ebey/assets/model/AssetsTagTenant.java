package com.aek.ebey.assets.model;

import java.util.Date;

import com.aek.common.core.base.BaseModel;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * 资产标签与机构关系实体类
 *	
 * @author HongHui
 * @date   2017年12月26日
 */
@TableName("ass_assets_tag_tenant")
public class AssetsTagTenant extends BaseModel{
	
	private static final long serialVersionUID = -2387741035427373550L;

	/**
	 * 资产标签ID
	 */
	@TableField(value="tag_id")
	private Long tagId;
	
	/**
	 * 机构ID
	 */
	@TableField(value="tenant_id")
	private Long tenantId;
	
	/**
	 * 资产标签创建时间
	 */
	@TableField(value="create_time")
	private Date createTime;

	public Long getTagId() {
		return tagId;
	}

	public void setTagId(Long tagId) {
		this.tagId = tagId;
	}

	public Long getTenantId() {
		return tenantId;
	}

	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
}
