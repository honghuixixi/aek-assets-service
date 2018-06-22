package com.aek.ebey.assets.model;

import com.aek.common.core.base.BaseModel;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 字典质量管理信息表
 * </p>
 *
 * @author aek
 * @since 2017-04-13
 */
@TableName("ass_goods_specs_quality")
public class GoodsSpecsQuality extends BaseModel {

    private static final long serialVersionUID = 1L;

	/**
	 * 
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
	 * 是否强检，1：是，0：否
	 */
	@TableField(value="force_flag")
	private Integer forceFlag;
	/**
	 * 是否启用保养， 0：不启用保养计划、1：启用保养计划
	 */
	@TableField(value="am_flag")
	private Integer amFlag;
	/**
	 * 巡检标识1启用0不启用
	 */
	@TableField(value="polling_flag")
	private Integer pollingFlag;
	/**
	 * 是否启用PM管理标识1启用0不启用
	 */
	@TableField(value="pm_flag")
	private Integer pmFlag;
	/**
	 * 是否计量，1：是，0：否
	 */
	@TableField(value="measure_flag")
	private Integer measureFlag;
	/**
	 * 质检标识1启用0不启用
	 */
	@TableField(value="quality_flag")
	private Integer qualityFlag;
	/**
	 * 维修标识1启用0不启用
	 */
	@TableField(value="repair_flag")
	private Integer repairFlag;
	/**
	 * 商检标志
	 */
	@TableField(value="commodity_flag")
	private Integer commodityFlag;
	/**
	 * 计量类别（计量管理类型）
	 */
	@TableField(value="measure_type")
	private Integer measureType;
	/**
	 * 预计净残值率
	 */
	@TableField(value="surplus_value")
	private Integer surplusValue;
	/**
	 * 折旧年限
	 */
	@TableField(value="depreciation_age")
	private Integer depreciationAge;
	/**
	 * 计提方式（折旧方法）：1不计提折旧2平均年限法3年限总和法4双倍余额递减法
	 */
	@TableField(value="depreciation_type")
	private Integer depreciationType;
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

	public Integer getForceFlag() {
		return forceFlag;
	}

	public void setForceFlag(Integer forceFlag) {
		this.forceFlag = forceFlag;
	}

	public Integer getAmFlag() {
		return amFlag;
	}

	public void setAmFlag(Integer amFlag) {
		this.amFlag = amFlag;
	}

	public Integer getPollingFlag() {
		return pollingFlag;
	}

	public void setPollingFlag(Integer pollingFlag) {
		this.pollingFlag = pollingFlag;
	}

	public Integer getPmFlag() {
		return pmFlag;
	}

	public void setPmFlag(Integer pmFlag) {
		this.pmFlag = pmFlag;
	}

	public Integer getMeasureFlag() {
		return measureFlag;
	}

	public void setMeasureFlag(Integer measureFlag) {
		this.measureFlag = measureFlag;
	}

	public Integer getQualityFlag() {
		return qualityFlag;
	}

	public void setQualityFlag(Integer qualityFlag) {
		this.qualityFlag = qualityFlag;
	}

	public Integer getRepairFlag() {
		return repairFlag;
	}

	public void setRepairFlag(Integer repairFlag) {
		this.repairFlag = repairFlag;
	}

	public Integer getCommodityFlag() {
		return commodityFlag;
	}

	public void setCommodityFlag(Integer commodityFlag) {
		this.commodityFlag = commodityFlag;
	}

	public Integer getMeasureType() {
		return measureType;
	}

	public void setMeasureType(Integer measureType) {
		this.measureType = measureType;
	}

	public Integer getSurplusValue() {
		return surplusValue;
	}

	public void setSurplusValue(Integer surplusValue) {
		this.surplusValue = surplusValue;
	}

	public Integer getDepreciationAge() {
		return depreciationAge;
	}

	public void setDepreciationAge(Integer depreciationAge) {
		this.depreciationAge = depreciationAge;
	}

	public Integer getDepreciationType() {
		return depreciationType;
	}

	public void setDepreciationType(Integer depreciationType) {
		this.depreciationType = depreciationType;
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
