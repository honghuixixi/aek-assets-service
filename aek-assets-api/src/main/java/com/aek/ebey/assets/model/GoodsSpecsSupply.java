package com.aek.ebey.assets.model;

import com.aek.common.core.base.BaseModel;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 字典供货信息表
 * </p>
 *
 * @author aek
 * @since 2017-04-13
 */
@TableName("ass_goods_specs_supply")
public class GoodsSpecsSupply extends BaseModel {

    private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	private Long id;
	/**
	 * 物资注册证id，供应商医疗器械登记证信息表主键
	 */
	@TableField(value="reg_id")
	private Long regId;
	/**
	 * 物资注册证id，供应商医疗器械登记证信息表主键
	 */
	@TableField(value="goods_id")
	private Long goodsId;
	/**
	 * 规格编码
	 */
	@TableField(value="spec_no")
	private String specNo;
	/**
	 * 物资规格ID，物资规格表主键。
	 */
	@TableField(value="spec_id")
	private Long specId;
	/**
	 * 行政区划
	 */
	@TableField(value="area_id")
	private Integer areaId;
	/**
	 * 系统ID，即 医院ID
	 */
	@TableField(value="sys_id")
	private Long sysId;
	/**
	 * 供应商ID，供应商标主键
	 */
	@TableField(value="spl_id")
	private Long splId;
	/**
	 * 供应商名称
	 */
	@TableField(value="spl_name")
	private String splName;
	/**
	 * 单价，
	 */
	private Long price;
	/**
	 * 税点
	 */
	@TableField(value="taxing_point")
	private Integer taxingPoint;
	/**
	 * 是否默认，1：默认，0：非默认
	 */
	@TableField(value="defaul_flag")
	private Integer defaulFlag;
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
	 * 作废标记：0:正常、1:作废、2:暂停使用
	 */
	@TableField(value="del_flag")
	private Boolean delFlag;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getRegId() {
		return regId;
	}

	public void setRegId(Long regId) {
		this.regId = regId;
	}

	public Long getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}

	public String getSpecNo() {
		return specNo;
	}

	public void setSpecNo(String specNo) {
		this.specNo = specNo;
	}

	public Long getSpecId() {
		return specId;
	}

	public void setSpecId(Long specId) {
		this.specId = specId;
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

	public Long getSplId() {
		return splId;
	}

	public void setSplId(Long splId) {
		this.splId = splId;
	}

	public String getSplName() {
		return splName;
	}

	public void setSplName(String splName) {
		this.splName = splName;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public Integer getTaxingPoint() {
		return taxingPoint;
	}

	public void setTaxingPoint(Integer taxingPoint) {
		this.taxingPoint = taxingPoint;
	}

	public Integer getDefaulFlag() {
		return defaulFlag;
	}

	public void setDefaulFlag(Integer defaulFlag) {
		this.defaulFlag = defaulFlag;
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
