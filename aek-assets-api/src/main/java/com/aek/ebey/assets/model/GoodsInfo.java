package com.aek.ebey.assets.model;

import com.aek.common.core.base.BaseModel;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 物资基础数据表。
 * </p>
 *
 * @author aek
 * @since 2017-04-13
 */
@TableName("ass_goods_info")
public class GoodsInfo extends BaseModel {

    private static final long serialVersionUID = 1L;

	/**
	 * 物资ID
	 */
	private Long id;
	/**
	 * 物资类型ID
	 */
	@TableField(value="class_id")
	private Long classId;
	/**
	 * 行政区划
	 */
	@TableField(value="area_id")
	private Integer areaId;
	/**
	 * 系统ID，即医院ID
	 */
	@TableField(value="sys_id")
	private Long sysId;
	/**
	 * 物资guid
	 */
	@TableField(value="goods_guid")
	private String goodsGuid;
	/**
	 * 物资大类，0药品，1试剂，2耗材，3设备，4工具
	 */
	@TableField(value="goods_type")
	private Integer goodsType;
	/**
	 * 物资分类ID
	 */
	@TableField(value="type_id")
	private Long typeId;
	/**
	 * 标准分类ID，国家标准分类
	 */
	@TableField(value="goods_standard_type_id")
	private String goodsStandardTypeId;
	/**
	 * 分类文本
	 */
	@TableField(value="goods_standard_text")
	private String goodsStandardText;
	/**
	 * 国家标准分类等级
	 */
	@TableField(value="goods_standard_level")
	private String goodsStandardLevel;
	/**
	 * 物资编码（条码主码），多个以逗号分隔
	 */
	@TableField(value="goods_no")
	private String goodsNo;
	/**
	 * 物资名称
	 */
	@TableField(value="goods_name")
	private String goodsName;
	/**
	 * 物资名称拼音码
	 */
	@TableField(value="goods_name_py")
	private String goodsNamePy;
	/**
	 * 物资名称五笔码
	 */
	@TableField(value="goods_name_wb")
	private String goodsNameWb;
	/**
	 * 物资管理方式ID，对应GOODS_MANAGEMENT代码值
	 */
	@TableField(value="goods_management_id")
	private Long goodsManagementId;
	/**
	 * 物资属性其他
	 */
	@TableField(value="goods_other_flag")
	private Integer goodsOtherFlag;
	/**
	 * 物资图片ID
	 */
	@TableField(value="goods_image_id")
	private Long goodsImageId;
	/**
	 * 物资材料ID
	 */
	@TableField(value="goods_material_id")
	private Long goodsMaterialId;
	/**
	 * 物资材料名称
	 */
	@TableField(value="goods_material")
	private String goodsMaterial;
	/**
	 * 物资灭菌方式ID
	 */
	@TableField(value="goods_sterilize_id")
	private Long goodsSterilizeId;
	/**
	 * 灭菌方式
	 */
	@TableField(value="goods_sterilize")
	private String goodsSterilize;
	/**
	 * 医保标识，0不确定，1医保，2非医保
	 */
	@TableField(value="medicare_flag")
	private Integer medicareFlag;
	/**
	 * 来源标识，0新增，1导入
	 */
	@TableField(value="source_flag")
	private Integer sourceFlag;
	/**
	 * 厂家ID
	 */
	@TableField(value="fac_id")
	private Long facId;
	/**
	 * 厂家名称
	 */
	@TableField(value="fac_name")
	private String facName;
	/**
	 * 注册证号
	 */
	@TableField(value="reg_no")
	private String regNo;
	/**
	 * 注册证ID
	 */
	@TableField(value="reg_id")
	private Long regId;
	/**
	 * 平台同步中间ID
	 */
	@TableField(value="base_data_id")
	private Integer baseDataId;
	/**
	 * 同步标识
	 */
	@TableField(value="sync_flag")
	private Integer syncFlag;
	/**
	 * 账簿类型ID
	 */
	@TableField(value="assets_type_id")
	private Integer assetsTypeId;
	/**
	 * 账簿类型文字说明
	 */
	@TableField(value="assets_type_text")
	private String assetsTypeText;
	/**
	 * 核算类别ID
	 */
	@TableField(value="assets_class_id")
	private Integer assetsClassId;
	/**
	 * 核算类别文字说明
	 */
	@TableField(value="assets_class_text")
	private String assetsClassText;
	/**
	 * 
	 */
	@TableField(value="create_by")
	private Long createBy;
	/**
	 * 
	 */
	@TableField(value="create_time")
	private Date createTime;
	/**
	 * 
	 */
	@TableField(value="update_by")
	private Long updateBy;
	/**
	 * 
	 */
	@TableField(value="update_time")
	private Date updateTime;
	/**
	 * 0正常，1作废
	 */
	@TableField(value="del_flag")
	private Boolean delFlag;
	/**
	 * 图片文件id列表，以逗号隔开
	 */
	@TableField(value="file_list")
	private String fileList;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getClassId() {
		return classId;
	}

	public void setClassId(Long classId) {
		this.classId = classId;
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

	public String getGoodsGuid() {
		return goodsGuid;
	}

	public void setGoodsGuid(String goodsGuid) {
		this.goodsGuid = goodsGuid;
	}

	public Integer getGoodsType() {
		return goodsType;
	}

	public void setGoodsType(Integer goodsType) {
		this.goodsType = goodsType;
	}

	public Long getTypeId() {
		return typeId;
	}

	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}

	public String getGoodsStandardTypeId() {
		return goodsStandardTypeId;
	}

	public void setGoodsStandardTypeId(String goodsStandardTypeId) {
		this.goodsStandardTypeId = goodsStandardTypeId;
	}

	public String getGoodsStandardText() {
		return goodsStandardText;
	}

	public void setGoodsStandardText(String goodsStandardText) {
		this.goodsStandardText = goodsStandardText;
	}

	public String getGoodsStandardLevel() {
		return goodsStandardLevel;
	}

	public void setGoodsStandardLevel(String goodsStandardLevel) {
		this.goodsStandardLevel = goodsStandardLevel;
	}

	public String getGoodsNo() {
		return goodsNo;
	}

	public void setGoodsNo(String goodsNo) {
		this.goodsNo = goodsNo;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getGoodsNamePy() {
		return goodsNamePy;
	}

	public void setGoodsNamePy(String goodsNamePy) {
		this.goodsNamePy = goodsNamePy;
	}

	public String getGoodsNameWb() {
		return goodsNameWb;
	}

	public void setGoodsNameWb(String goodsNameWb) {
		this.goodsNameWb = goodsNameWb;
	}

	public Long getGoodsManagementId() {
		return goodsManagementId;
	}

	public void setGoodsManagementId(Long goodsManagementId) {
		this.goodsManagementId = goodsManagementId;
	}

	public Integer getGoodsOtherFlag() {
		return goodsOtherFlag;
	}

	public void setGoodsOtherFlag(Integer goodsOtherFlag) {
		this.goodsOtherFlag = goodsOtherFlag;
	}

	public Long getGoodsImageId() {
		return goodsImageId;
	}

	public void setGoodsImageId(Long goodsImageId) {
		this.goodsImageId = goodsImageId;
	}

	public Long getGoodsMaterialId() {
		return goodsMaterialId;
	}

	public void setGoodsMaterialId(Long goodsMaterialId) {
		this.goodsMaterialId = goodsMaterialId;
	}

	public String getGoodsMaterial() {
		return goodsMaterial;
	}

	public void setGoodsMaterial(String goodsMaterial) {
		this.goodsMaterial = goodsMaterial;
	}

	public Long getGoodsSterilizeId() {
		return goodsSterilizeId;
	}

	public void setGoodsSterilizeId(Long goodsSterilizeId) {
		this.goodsSterilizeId = goodsSterilizeId;
	}

	public String getGoodsSterilize() {
		return goodsSterilize;
	}

	public void setGoodsSterilize(String goodsSterilize) {
		this.goodsSterilize = goodsSterilize;
	}

	public Integer getMedicareFlag() {
		return medicareFlag;
	}

	public void setMedicareFlag(Integer medicareFlag) {
		this.medicareFlag = medicareFlag;
	}

	public Integer getSourceFlag() {
		return sourceFlag;
	}

	public void setSourceFlag(Integer sourceFlag) {
		this.sourceFlag = sourceFlag;
	}

	public Long getFacId() {
		return facId;
	}

	public void setFacId(Long facId) {
		this.facId = facId;
	}

	public String getFacName() {
		return facName;
	}

	public void setFacName(String facName) {
		this.facName = facName;
	}

	public String getRegNo() {
		return regNo;
	}

	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}

	public Long getRegId() {
		return regId;
	}

	public void setRegId(Long regId) {
		this.regId = regId;
	}

	public Integer getBaseDataId() {
		return baseDataId;
	}

	public void setBaseDataId(Integer baseDataId) {
		this.baseDataId = baseDataId;
	}

	public Integer getSyncFlag() {
		return syncFlag;
	}

	public void setSyncFlag(Integer syncFlag) {
		this.syncFlag = syncFlag;
	}

	public Integer getAssetsTypeId() {
		return assetsTypeId;
	}

	public void setAssetsTypeId(Integer assetsTypeId) {
		this.assetsTypeId = assetsTypeId;
	}

	public String getAssetsTypeText() {
		return assetsTypeText;
	}

	public void setAssetsTypeText(String assetsTypeText) {
		this.assetsTypeText = assetsTypeText;
	}

	public Integer getAssetsClassId() {
		return assetsClassId;
	}

	public void setAssetsClassId(Integer assetsClassId) {
		this.assetsClassId = assetsClassId;
	}

	public String getAssetsClassText() {
		return assetsClassText;
	}

	public void setAssetsClassText(String assetsClassText) {
		this.assetsClassText = assetsClassText;
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

	public String getFileList() {
		return fileList;
	}

	public void setFileList(String fileList) {
		this.fileList = fileList;
	}

}
