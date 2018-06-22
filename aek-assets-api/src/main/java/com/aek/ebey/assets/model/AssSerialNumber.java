package com.aek.ebey.assets.model;

import com.aek.common.core.base.BaseModel;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * <p>
 * 流水号表
 * </p>
 *
 * @author aek
 * @since 2017-07-06
 */
@TableName("ass_serial_number")
public class AssSerialNumber extends BaseModel {

    private static final long serialVersionUID = 1L;

	/**
	 * 租户id
	 */
	@TableField(value="tenant_id")
	private Long tenantId;
	/**
	 * 流水号
	 */
	private Long sn;
	/**
	 * 模块
	 */
	private Integer module;

	public Long getTenantId() {
		return tenantId;
	}
	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}
	public Long getSn() {
		return sn;
	}
	public void setSn(Long sn) {
		this.sn = sn;
	}
	public Integer getModule() {
		return module;
	}
	public void setModule(Integer module) {
		this.module = module;
	}



}
