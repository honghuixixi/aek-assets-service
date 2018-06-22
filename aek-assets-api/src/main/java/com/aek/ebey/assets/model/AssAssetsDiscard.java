package com.aek.ebey.assets.model;

import java.util.Date;

import com.aek.common.core.base.BaseModel;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * <p>
 * 报损设备
 * </p>
 *
 * @author aek
 * @since 2017-12-14
 */
@TableName("ass_assets_discard_detail")
public class AssAssetsDiscard extends BaseModel {

    private static final long serialVersionUID = 1L;

	/**
	 * 关联报损单号
	 */
	@TableField(value="discard_id")
	private Long discardId;
	/**
	 * 
	 */
	@TableField(value="assets_id")
	private Long assetsId;
	/**
	 * 资产名称
	 */
	@TableField(value="assets_name")
	private String assetsName;
	/**
	 * 院内编码
	 */
	@TableField(value="serial_num")
	private String serialNum;
	/**
	 * 设备编号
	 */
	@TableField(value="assets_num")
	private String assetsNum;
	/**
	 * 生产商
	 */
	@TableField(value="factory_name")
	private String factoryName;
	
	/**
	 * 供应商
	 */
	@TableField(value="spl_name")
	private String splName;
	
	/**
	 * 设备型号
	 */
	@TableField(value="assets_spec")
	private String assetsSpec;
	/**
	 * 设备所在科室id
	 */
	@TableField(value="assets_dept_id")
	private Long assetsDeptId;
	/**
	 * 设备所在科室名称
	 */
	@TableField(value="assets_dept_name")
	private String assetsDeptName;
	/**
	 * 状态：1=在库、2=在用、3=预登、4=待报损、5=报损、6=退货
	 */
	private Integer status;
	
	/**
     * 启用日期
     */
    @TableField(value = "start_use_date")
    private Date startUseDate;
    
    /**
	 * 单位
	 */
	@TableField(value="unit_name")
	private String unitName;
	
	/**
	 * 设备图片
	 */
	@TableField(value="assets_img")
	private String assetsImg;
	/**
	 * 状态（1，未撤销 2，已撤销）
	 */
	private Integer type;
	/**
	 * 状态 1:待审核 2:审核通过 3:审核不通过
	 */
	@TableField(value="verify_status")
	private Integer verifyStatus;


	public Long getDiscardId() {
		return discardId;
	}

	public void setDiscardId(Long discardId) {
		this.discardId = discardId;
	}

	public Long getAssetsId() {
		return assetsId;
	}

	public void setAssetsId(Long assetsId) {
		this.assetsId = assetsId;
	}

	public String getAssetsName() {
		return assetsName;
	}

	public void setAssetsName(String assetsName) {
		this.assetsName = assetsName;
	}

	public String getAssetsNum() {
		return assetsNum;
	}

	public void setAssetsNum(String assetsNum) {
		this.assetsNum = assetsNum;
	}

	public String getSerialNum() {
		return serialNum;
	}

	public void setSerialNum(String serialNum) {
		this.serialNum = serialNum;
	}

	public String getFactoryName() {
		return factoryName;
	}

	public void setFactoryName(String factoryName) {
		this.factoryName = factoryName;
	}

	public String getAssetsSpec() {
		return assetsSpec;
	}

	public void setAssetsSpec(String assetsSpec) {
		this.assetsSpec = assetsSpec;
	}

	public Long getAssetsDeptId() {
		return assetsDeptId;
	}

	public void setAssetsDeptId(Long assetsDeptId) {
		this.assetsDeptId = assetsDeptId;
	}

	public String getAssetsDeptName() {
		return assetsDeptName;
	}

	public void setAssetsDeptName(String assetsDeptName) {
		this.assetsDeptName = assetsDeptName;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getVerifyStatus() {
		return verifyStatus;
	}

	public void setVerifyStatus(Integer verifyStatus) {
		this.verifyStatus = verifyStatus;
	}

	public String getSplName() {
		return splName;
	}

	public void setSplName(String splName) {
		this.splName = splName;
	}

	public Date getStartUseDate() {
		return startUseDate;
	}

	public void setStartUseDate(Date startUseDate) {
		this.startUseDate = startUseDate;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public String getAssetsImg() {
		return assetsImg;
	}

	public void setAssetsImg(String assetsImg) {
		this.assetsImg = assetsImg;
	}

}
