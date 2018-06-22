package com.aek.ebey.assets.model;

import com.aek.common.core.base.BaseModel;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 供应商医疗器械登记证信息表。
 * </p>
 *
 * @author aek
 * @since 2017-04-13
 */
@TableName("ass_goods_reg")
public class GoodsReg extends BaseModel {

    private static final long serialVersionUID = 1L;

	/**
	 * 物资注册证id，供应商医疗器械登记证信息表主键
	 */
	private Long id;
	/**
	 * 区域id
	 */
	@TableField(value="area_id")
	private Integer areaId;
	/**
	 * 系统id。base中没具体对象，赋供应商ID
	 */
	@TableField(value="sys_id")
	private Long sysId;
	/**
	 * 物资注册证guid
	 */
	@TableField(value="reg_guid")
	private String regGuid;
	/**
	 * 医疗器械注册证号
	 */
	@TableField(value="reg_no")
	private String regNo;
	/**
	 * 证件类型。0注册证  1备案证  2一类产品无注册证  3其他证件
	 */
	@TableField(value="reg_type")
	private Integer regType;
	/**
	 * 注册证英文名称
	 */
	@TableField(value="reg_name_en")
	private String regNameEn;
	/**
	 * 注册证简称，即reg,no。
	 */
	@TableField(value="reg_standard_no")
	private String regStandardNo;
	/**
	 * 注册物资名称
	 */
	@TableField(value="reg_goods_name")
	private String regGoodsName;
	/**
	 * 注册日期
	 */
	@TableField(value="reg_date")
	private Date regDate;
	/**
	 * 过期日期
	 */
	@TableField(value="reg_expired_date")
	private Date regExpiredDate;
	/**
	 * 延期标志
	 */
	@TableField(value="reg_defer_flag")
	private Integer regDeferFlag;
	/**
	 * 延期证号
	 */
	@TableField(value="reg_defer_no")
	private String regDeferNo;
	/**
	 * 延期到期日
	 */
	@TableField(value="reg_defer_to_date")
	private Date regDeferToDate;
	/**
	 * 产品标准
	 */
	@TableField(value="goods_standard")
	private String goodsStandard;
	/**
	 * 产品组成及性能
	 */
	@TableField(value="goods_assembly")
	private String goodsAssembly;
	/**
	 * 产品适用范围
	 */
	@TableField(value="goods_scope")
	private String goodsScope;
	/**
	 * 注册代理
	 */
	@TableField(value="reg_agent")
	private String regAgent;
	/**
	 * 售后服务机构
	 */
	@TableField(value="service_deptment")
	private String serviceDeptment;
	/**
	 * 审核机构
	 */
	@TableField(value="approve_deptment")
	private String approveDeptment;
	/**
	 * 备注
	 */
	private String remarks;
	/**
	 * 数据来源标记：0:新增；1:导入
	 */
	@TableField(value="source_flag")
	private Integer sourceFlag;
	/**
	 * 被换下的物资注册证guid
	 */
	@TableField(value="old_reg_guid")
	private String oldRegGuid;
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
	 * 作废标记：0:正常、1:作废
	 */
	@TableField(value="del_flag")
	private Boolean delFlag;
	/**
	 * 手工输入该注册证对应的规格信息，只做参考
	 */
	@TableField(value="goods_specs")
	private String goodsSpecs;
	/**
	 * 是否进口：1，进口
	 */
	@TableField(value="import_flag")
	private Integer importFlag;
	/**
	 * 变更日期
	 */
	@TableField(value="reg_edit_date")
	private Date regEditDate;
	/**
	 * 注册物资名称英文。
	 */
	@TableField(value="reg_goods_name_en")
	private String regGoodsNameEn;
	/**
	 * 生产国。
	 */
	@TableField(value="factory_country")
	private String factoryCountry;
	/**
	 * 生产企业，厂家表主键
	 */
	@TableField(value="factory_id")
	private Long factoryId;
	/**
	 * 生产企业英文名
	 */
	@TableField(value="factory_name_en")
	private String factoryNameEn;
	/**
	 * 生产地址
	 */
	@TableField(value="factory_addr")
	private String factoryAddr;
	/**
	 * 生产企业中文名。
	 */
	@TableField(value="factory_name")
	private String factoryName;
	/**
	 * 生产场所。
	 */
	@TableField(value="factory_place")
	private String factoryPlace;
	/**
	 * 生产地址邮编。
	 */
	@TableField(value="factory_postcode")
	private String factoryPostcode;
	/**
	 * 客服热线。
	 */
	@TableField(value="service_hotline")
	private String serviceHotline;
	/**
	 * 法定制造商。
	 */
	@TableField(value="legal_factory_name")
	private String legalFactoryName;
	/**
	 * 注册地址。
	 */
	@TableField(value="reg_addr")
	private String regAddr;
	/**
	 * 产品禁忌症。
	 */
	@TableField(value="goods_taboo")
	private String goodsTaboo;
	/**
	 * 售后服务地址。
	 */
	@TableField(value="service_addr")
	private String serviceAddr;
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

	public String getRegGuid() {
		return regGuid;
	}

	public void setRegGuid(String regGuid) {
		this.regGuid = regGuid;
	}

	public String getRegNo() {
		return regNo;
	}

	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}

	public Integer getRegType() {
		return regType;
	}

	public void setRegType(Integer regType) {
		this.regType = regType;
	}

	public String getRegNameEn() {
		return regNameEn;
	}

	public void setRegNameEn(String regNameEn) {
		this.regNameEn = regNameEn;
	}

	public String getRegStandardNo() {
		return regStandardNo;
	}

	public void setRegStandardNo(String regStandardNo) {
		this.regStandardNo = regStandardNo;
	}

	public String getRegGoodsName() {
		return regGoodsName;
	}

	public void setRegGoodsName(String regGoodsName) {
		this.regGoodsName = regGoodsName;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public Date getRegExpiredDate() {
		return regExpiredDate;
	}

	public void setRegExpiredDate(Date regExpiredDate) {
		this.regExpiredDate = regExpiredDate;
	}

	public Integer getRegDeferFlag() {
		return regDeferFlag;
	}

	public void setRegDeferFlag(Integer regDeferFlag) {
		this.regDeferFlag = regDeferFlag;
	}

	public String getRegDeferNo() {
		return regDeferNo;
	}

	public void setRegDeferNo(String regDeferNo) {
		this.regDeferNo = regDeferNo;
	}

	public Date getRegDeferToDate() {
		return regDeferToDate;
	}

	public void setRegDeferToDate(Date regDeferToDate) {
		this.regDeferToDate = regDeferToDate;
	}

	public String getGoodsStandard() {
		return goodsStandard;
	}

	public void setGoodsStandard(String goodsStandard) {
		this.goodsStandard = goodsStandard;
	}

	public String getGoodsAssembly() {
		return goodsAssembly;
	}

	public void setGoodsAssembly(String goodsAssembly) {
		this.goodsAssembly = goodsAssembly;
	}

	public String getGoodsScope() {
		return goodsScope;
	}

	public void setGoodsScope(String goodsScope) {
		this.goodsScope = goodsScope;
	}

	public String getRegAgent() {
		return regAgent;
	}

	public void setRegAgent(String regAgent) {
		this.regAgent = regAgent;
	}

	public String getServiceDeptment() {
		return serviceDeptment;
	}

	public void setServiceDeptment(String serviceDeptment) {
		this.serviceDeptment = serviceDeptment;
	}

	public String getApproveDeptment() {
		return approveDeptment;
	}

	public void setApproveDeptment(String approveDeptment) {
		this.approveDeptment = approveDeptment;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Integer getSourceFlag() {
		return sourceFlag;
	}

	public void setSourceFlag(Integer sourceFlag) {
		this.sourceFlag = sourceFlag;
	}

	public String getOldRegGuid() {
		return oldRegGuid;
	}

	public void setOldRegGuid(String oldRegGuid) {
		this.oldRegGuid = oldRegGuid;
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

	public String getGoodsSpecs() {
		return goodsSpecs;
	}

	public void setGoodsSpecs(String goodsSpecs) {
		this.goodsSpecs = goodsSpecs;
	}

	public Integer getImportFlag() {
		return importFlag;
	}

	public void setImportFlag(Integer importFlag) {
		this.importFlag = importFlag;
	}

	public Date getRegEditDate() {
		return regEditDate;
	}

	public void setRegEditDate(Date regEditDate) {
		this.regEditDate = regEditDate;
	}

	public String getRegGoodsNameEn() {
		return regGoodsNameEn;
	}

	public void setRegGoodsNameEn(String regGoodsNameEn) {
		this.regGoodsNameEn = regGoodsNameEn;
	}

	public String getFactoryCountry() {
		return factoryCountry;
	}

	public void setFactoryCountry(String factoryCountry) {
		this.factoryCountry = factoryCountry;
	}

	public Long getFactoryId() {
		return factoryId;
	}

	public void setFactoryId(Long factoryId) {
		this.factoryId = factoryId;
	}

	public String getFactoryNameEn() {
		return factoryNameEn;
	}

	public void setFactoryNameEn(String factoryNameEn) {
		this.factoryNameEn = factoryNameEn;
	}

	public String getFactoryAddr() {
		return factoryAddr;
	}

	public void setFactoryAddr(String factoryAddr) {
		this.factoryAddr = factoryAddr;
	}

	public String getFactoryName() {
		return factoryName;
	}

	public void setFactoryName(String factoryName) {
		this.factoryName = factoryName;
	}

	public String getFactoryPlace() {
		return factoryPlace;
	}

	public void setFactoryPlace(String factoryPlace) {
		this.factoryPlace = factoryPlace;
	}

	public String getFactoryPostcode() {
		return factoryPostcode;
	}

	public void setFactoryPostcode(String factoryPostcode) {
		this.factoryPostcode = factoryPostcode;
	}

	public String getServiceHotline() {
		return serviceHotline;
	}

	public void setServiceHotline(String serviceHotline) {
		this.serviceHotline = serviceHotline;
	}

	public String getLegalFactoryName() {
		return legalFactoryName;
	}

	public void setLegalFactoryName(String legalFactoryName) {
		this.legalFactoryName = legalFactoryName;
	}

	public String getRegAddr() {
		return regAddr;
	}

	public void setRegAddr(String regAddr) {
		this.regAddr = regAddr;
	}

	public String getGoodsTaboo() {
		return goodsTaboo;
	}

	public void setGoodsTaboo(String goodsTaboo) {
		this.goodsTaboo = goodsTaboo;
	}

	public String getServiceAddr() {
		return serviceAddr;
	}

	public void setServiceAddr(String serviceAddr) {
		this.serviceAddr = serviceAddr;
	}

	public String getFileList() {
		return fileList;
	}

	public void setFileList(String fileList) {
		this.fileList = fileList;
	}

}
