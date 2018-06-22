package com.aek.ebey.assets.model;

import com.aek.common.core.base.BaseModel;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author aek
 * @since 2017-04-13
 */
@TableName("ass_goods_class")
public class GoodsClass extends BaseModel {

    private static final long serialVersionUID = 1L;

	/**
	 * 物资类型ID。
	 */
	private Long id;
	/**
	 * 区域id
	 */
	@TableField(value="area_id")
	private Integer areaId;
	/**
	 * 系统ID。用于区分不同医院。
	 */
	@TableField(value="sys_id")
	private Long sysId;
	/**
	 * 
	 */
	@TableField(value="class_parent_id")
	private Long classParentId;
	/**
	 * 同级角色顺序。从0开始编号。
	 */
	@TableField(value="class_index")
	private Long classIndex;
	/**
	 * 分类层级
	 */
	@TableField(value="class_level")
	private Long classLevel;
	/**
	 * 物资类型名称。
	 */
	@TableField(value="class_name")
	private String className;
	/**
	 * 68码code。
	 */
	@TableField(value="class_68code")
	private String class68code;
	/**
	 * 科室名称拼音码，名称每个汉字的拼音第一个字母。
	 */
	@TableField(value="class_name_py")
	private String classNamePy;
	/**
	 * 科室名称五笔码，名称每个汉字的五笔第一个字母。
	 */
	@TableField(value="class_name_wb")
	private String classNameWb;
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
	@TableField(value="lupdate_time")
	private Date lupdateTime;
	/**
	 * 状态标记。0正常，1作废  2停用。
	 */
	@TableField(value="stauts_flag")
	private Integer stautsFlag;
	/**
	 * 作废标记。为0表示此笔数据有效，为1表示此笔数据无效。
	 */
	@TableField(value="del_flag")
	private Boolean delFlag;
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
	 * 计提方式（折旧方法）：1不计提折旧2平均年限法3年限总和法4双倍余额递减法
	 */
	@TableField(value="depreciation_type")
	private Integer depreciationType;
	/**
	 * 折旧年限
	 */
	@TableField(value="depreciation_age")
	private Integer depreciationAge;
	/**
	 * 分类代码
	 */
	@TableField(value="class_no")
	private String classNo;
	/**
	 * 核算类别代码
	 */
	@TableField(value="assets_class_no")
	private String assetsClassNo;


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

	public Long getClassParentId() {
		return classParentId;
	}

	public void setClassParentId(Long classParentId) {
		this.classParentId = classParentId;
	}

	public Long getClassIndex() {
		return classIndex;
	}

	public void setClassIndex(Long classIndex) {
		this.classIndex = classIndex;
	}

	public Long getClassLevel() {
		return classLevel;
	}

	public void setClassLevel(Long classLevel) {
		this.classLevel = classLevel;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getClass68code() {
		return class68code;
	}

	public void setClass68code(String class68code) {
		this.class68code = class68code;
	}

	public String getClassNamePy() {
		return classNamePy;
	}

	public void setClassNamePy(String classNamePy) {
		this.classNamePy = classNamePy;
	}

	public String getClassNameWb() {
		return classNameWb;
	}

	public void setClassNameWb(String classNameWb) {
		this.classNameWb = classNameWb;
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

	public Date getLupdateTime() {
		return lupdateTime;
	}

	public void setLupdateTime(Date lupdateTime) {
		this.lupdateTime = lupdateTime;
	}

	public Integer getStautsFlag() {
		return stautsFlag;
	}

	public void setStautsFlag(Integer stautsFlag) {
		this.stautsFlag = stautsFlag;
	}

	public Boolean isDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Boolean delFlag) {
		this.delFlag = delFlag;
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

	public Integer getDepreciationType() {
		return depreciationType;
	}

	public void setDepreciationType(Integer depreciationType) {
		this.depreciationType = depreciationType;
	}

	public Integer getDepreciationAge() {
		return depreciationAge;
	}

	public void setDepreciationAge(Integer depreciationAge) {
		this.depreciationAge = depreciationAge;
	}

	public String getClassNo() {
		return classNo;
	}

	public void setClassNo(String classNo) {
		this.classNo = classNo;
	}

	public String getAssetsClassNo() {
		return assetsClassNo;
	}

	public void setAssetsClassNo(String assetsClassNo) {
		this.assetsClassNo = assetsClassNo;
	}

}
