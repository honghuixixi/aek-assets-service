package com.aek.ebey.assets.model;

import com.aek.common.core.base.BaseModel;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 资产转科明细表
 * </p>
 *
 * @author cyl
 * @since 2017-12-14
 */
@TableName("ass_assets_transfer_detail")
public class AssAssetsTransferDetail extends BaseModel {

    private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	private Long id;
	/**
	 * 转科单id
	 */
	@TableField(value="transfer_id")
	private Long transferId;
	/**
	 * 设备id
	 */
	@TableField(value="assets_id")
	private Long assetsId;
	/**
	 * 资产编号
	 */
	@TableField(value="assets_num")
	private String assetsNum;
	/**
	 * 院内编码
	 */
	@TableField(value="serial_num")
	private String serialNum;
	/**
	 * 资产名称
	 */
	@TableField(value="assets_name")
	private String assetsName;
	/**
	 * 资产规格
	 */
	@TableField(value="assets_spec")
	private String assetsSpec;
	/**
	 * 设备图片url
	 */
	@TableField(value="assets_img_url")
	private String assetsImgUrl;
	/**
	 * 厂家名称
	 */
	@TableField(value="factory_name")
	private String factoryName;
	/**
	 * 所在科室id
	 */
	@TableField(value="dept_id")
	private Long deptId;
	/**
	 * 所在科室名称
	 */
	@TableField(value="dept_name")
	private String deptName;
	/**
	 * 操作0=已撤销，1=撤销转科，2=审核通过,3=审核未通过
	 */
	private Integer operate;
	
	@TableField(value="unit_id")
	private Integer unitId;
	
	@TableField(value="unit_name")
	private String unitName;

	@TableField(value="del_flag")
	private Boolean delFlag;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTransferId() {
		return transferId;
	}

	public void setTransferId(Long transferId) {
		this.transferId = transferId;
	}

	public Long getAssetsId() {
		return assetsId;
	}

	public void setAssetsId(Long assetsId) {
		this.assetsId = assetsId;
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

	public String getAssetsName() {
		return assetsName;
	}

	public void setAssetsName(String assetsName) {
		this.assetsName = assetsName;
	}

	public String getAssetsSpec() {
		return assetsSpec;
	}

	public void setAssetsSpec(String assetsSpec) {
		this.assetsSpec = assetsSpec;
	}

	public String getAssetsImgUrl() {
		return assetsImgUrl;
	}

	public void setAssetsImgUrl(String assetsImgUrl) {
		this.assetsImgUrl = assetsImgUrl;
	}

	public String getFactoryName() {
		return factoryName;
	}

	public void setFactoryName(String factoryName) {
		this.factoryName = factoryName;
	}

	public Long getDeptId() {
		return deptId;
	}

	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public Integer getOperate() {
		return operate;
	}

	public void setOperate(Integer operate) {
		this.operate = operate;
	}

	
	public Integer getUnitId() {
		return unitId;
	}

	public void setUnitId(Integer unitId) {
		this.unitId = unitId;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public Boolean getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Boolean delFlag) {
		this.delFlag = delFlag;
	}

	

}
