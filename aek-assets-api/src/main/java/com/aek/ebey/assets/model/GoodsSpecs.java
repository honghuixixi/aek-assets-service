package com.aek.ebey.assets.model;

import java.math.BigDecimal;
import java.util.Date;

import com.aek.common.core.base.BaseModel;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * <p>
 * 物资规格表。
 * </p>
 *
 * @author aek
 * @since 2017-04-13
 */
@TableName("ass_goods_specs")
public class GoodsSpecs extends BaseModel {

    private static final long serialVersionUID = 1L;

	/**
	 * 物资规格ID，物资规格表主键。
	 */
	private Long id;
	/**
	 * 系统Id。0为平台
	 */
	@TableField(value="sys_id")
	private Long sysId;
	/**
	 * 区域id
	 */
	@TableField(value="area_id")
	private Integer areaId;
	/**
	 * 物资类型ID。
	 */
	@TableField(value="class_id")
	private Long classId;
	/**
	 * 
	 */
	@TableField(value="goods_name")
	private String goodsName;
	/**
	 * 物资ID，物资信息表主键。
	 */
	@TableField(value="goods_id")
	private Long goodsId;
	/**
	 * 物资大类id
	 */
	@TableField(value="goods_type")
	private Integer goodsType;
	/**
	 * 物资规格GUID。
	 */
	@TableField(value="spec_guid")
	private String specGuid;
	/**
	 * 规格编码。
	 */
	@TableField(value="spec_no")
	private String specNo;
	/**
	 * 规格条码主码。多个时用逗号分隔
	 */
	@TableField(value="spec_barcode")
	private String specBarcode;
	/**
	 * 条码类型。0无条码 1唯一码 2重复码
	 */
	@TableField(value="spec_barcode_type")
	private Integer specBarcodeType;
	/**
	 * 规格型号。
	 */
	@TableField(value="spec_model")
	private String specModel;
	/**
	 * 通用名称。
	 */
	@TableField(value="spec_common_name")
	private String specCommonName;
	/**
	 * 英文描述
	 */
	@TableField(value="spec_name_en")
	private String specNameEn;
	/**
	 * 英文描述
	 */
	@TableField(value="spec_name_cn")
	private String specNameCn;
	/**
	 * 包装方式。
	 */
	@TableField(value="spec_package")
	private String specPackage;
	/**
	 * 大包装单位
	 */
	@TableField(value="spec_bigpackstr")
	private String specBigpackstr;
	/**
	 * 基础包装单位
	 */
	@TableField(value="spec_basepackstr")
	private String specBasepackstr;
	/**
	 * 基础包装数量
	 */
	@TableField(value="spec_basepack_no")
	private Integer specBasepackNo;
	/**
	 * 基础包装数量
	 */
	@TableField(value="spec_basepack_note")
	private String specBasepackNote;
	/**
	 * 最小包装单位ID
	 */
	@TableField(value="spec_minipackstr_id")
	private Integer specMinipackstrId;
	/**
	 * 最小包装单位
	 */
	@TableField(value="spec_minipackstr")
	private String specMinipackstr;
	/**
	 * 最小包装数量
	 */
	@TableField(value="spec_miniunit")
	private BigDecimal specMiniunit;
	/**
	 * 剂型
	 */
	@TableField(value="spec_dosetype")
	private Integer specDosetype;
	/**
	 * 剂量数值
	 */
	@TableField(value="spec_dose")
	private Integer specDose;
	/**
	 * 剂量单位
	 */
	@TableField(value="spec_doseuintstr")
	private String specDoseuintstr;
	/**
	 * 用法：0口服,1煎服,2注射,3外用,4局部用药
	 */
	@TableField(value="spec_usagefunc")
	private Integer specUsagefunc;
	/**
	 * 用量
	 */
	@TableField(value="spec_usages")
	private String specUsages;
	/**
	 * 使用说明。
	 */
	private String instructions;
	/**
	 * 附件ID清单，多个附件用逗号隔开。
	 */
	@TableField(value="file_id_list")
	private String fileIdList;
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
	 * 灭菌方式ID
	 */
	@TableField(value="goods_sterilize_id")
	private Long goodsSterilizeId;
	/**
	 * 灭菌方式
	 */
	@TableField(value="goods_sterilize")
	private String goodsSterilize;
	/**
	 * 物资注册证ID，供应商医疗器械登记证信息表主键。
	 */
	@TableField(value="reg_id")
	private Long regId;
	/**
	 * 注册证号
	 */
	@TableField(value="reg_no")
	private String regNo;
	/**
	 * 生产厂家ID，关联基本代码。
	 */
	@TableField(value="fac_id")
	private Long facId;
	/**
	 * 厂家名称
	 */
	@TableField(value="fac_name")
	private String facName;
	/**
	 * 产地。
	 */
	@TableField(value="factory_addr")
	private String factoryAddr;
	/**
	 * 品牌。
	 */
	@TableField(value="spec_brand")
	private String specBrand;
	/**
	 * 物资单位ID。等于基本包装单位
	 */
	@TableField(value="goods_unit_id")
	private Long goodsUnitId;
	/**
	 * 是否收费。0:不确定；1:可收费；2:不可收费；
	 */
	@TableField(value="charge_flag")
	private Integer chargeFlag;
	/**
	 * 招标类型
	 */
	@TableField(value="bid_type")
	private Integer bidType;
	/**
	 * 招标日期
	 */
	@TableField(value="bid_date")
	private Date bidDate;
	/**
	 * 招标失效日期
	 */
	@TableField(value="bid_expired_date")
	private Date bidExpiredDate;
	/**
	 * 招标标志。0/1。
	 */
	@TableField(value="bid_flag")
	private Integer bidFlag;
	/**
	 * 省标编号
	 */
	@TableField(value="invite_no")
	private String inviteNo;
	/**
	 * 是否重复使用。0不重复  1重复
	 */
	@TableField(value="repeat_flag")
	private Integer repeatFlag;
	/**
	 * 重复次数
	 */
	@TableField(value="repeat_no")
	private Integer repeatNo;
	/**
	 * 分摊费用 元/次
	 */
	@TableField(value="repeat_pay")
	private Integer repeatPay;
	/**
	 * 添加人ID。
	 */
	@TableField(value="add_by")
	private Long addBy;
	/**
	 * 添加时间。
	 */
	@TableField(value="add_time")
	private Date addTime;
	/**
	 * 最后修改人ID。
	 */
	@TableField(value="update_by")
	private Long updateBy;
	/**
	 * 最后修改时间。
	 */
	@TableField(value="update_time")
	private Date updateTime;
	/**
	 * 来源标记。0:新增；1:导入。
	 */
	@TableField(value="source_flag")
	private Integer sourceFlag;
	/**
	 * 借用单价
	 */
	@TableField(value="lend_price")
	private Long lendPrice;
	/**
	 * 同步标志
	 */
	@TableField(value="sync_flag")
	private Integer syncFlag;
	/**
	 * 作废标记：0:正常、1:作废、2:暂停使用。
	 */
	@TableField(value="del_flag")
	private Boolean delFlag;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getSysId() {
		return sysId;
	}

	public void setSysId(Long sysId) {
		this.sysId = sysId;
	}

	public Integer getAreaId() {
		return areaId;
	}

	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

	public Long getClassId() {
		return classId;
	}

	public void setClassId(Long classId) {
		this.classId = classId;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public Long getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}

	public Integer getGoodsType() {
		return goodsType;
	}

	public void setGoodsType(Integer goodsType) {
		this.goodsType = goodsType;
	}

	public String getSpecGuid() {
		return specGuid;
	}

	public void setSpecGuid(String specGuid) {
		this.specGuid = specGuid;
	}

	public String getSpecNo() {
		return specNo;
	}

	public void setSpecNo(String specNo) {
		this.specNo = specNo;
	}

	public String getSpecBarcode() {
		return specBarcode;
	}

	public void setSpecBarcode(String specBarcode) {
		this.specBarcode = specBarcode;
	}

	public Integer getSpecBarcodeType() {
		return specBarcodeType;
	}

	public void setSpecBarcodeType(Integer specBarcodeType) {
		this.specBarcodeType = specBarcodeType;
	}

	public String getSpecModel() {
		return specModel;
	}

	public void setSpecModel(String specModel) {
		this.specModel = specModel;
	}

	public String getSpecCommonName() {
		return specCommonName;
	}

	public void setSpecCommonName(String specCommonName) {
		this.specCommonName = specCommonName;
	}

	public String getSpecNameEn() {
		return specNameEn;
	}

	public void setSpecNameEn(String specNameEn) {
		this.specNameEn = specNameEn;
	}

	public String getSpecNameCn() {
		return specNameCn;
	}

	public void setSpecNameCn(String specNameCn) {
		this.specNameCn = specNameCn;
	}

	public String getSpecPackage() {
		return specPackage;
	}

	public void setSpecPackage(String specPackage) {
		this.specPackage = specPackage;
	}

	public String getSpecBigpackstr() {
		return specBigpackstr;
	}

	public void setSpecBigpackstr(String specBigpackstr) {
		this.specBigpackstr = specBigpackstr;
	}

	public String getSpecBasepackstr() {
		return specBasepackstr;
	}

	public void setSpecBasepackstr(String specBasepackstr) {
		this.specBasepackstr = specBasepackstr;
	}

	public Integer getSpecBasepackNo() {
		return specBasepackNo;
	}

	public void setSpecBasepackNo(Integer specBasepackNo) {
		this.specBasepackNo = specBasepackNo;
	}

	public String getSpecBasepackNote() {
		return specBasepackNote;
	}

	public void setSpecBasepackNote(String specBasepackNote) {
		this.specBasepackNote = specBasepackNote;
	}

	public Integer getSpecMinipackstrId() {
		return specMinipackstrId;
	}

	public void setSpecMinipackstrId(Integer specMinipackstrId) {
		this.specMinipackstrId = specMinipackstrId;
	}

	public String getSpecMinipackstr() {
		return specMinipackstr;
	}

	public void setSpecMinipackstr(String specMinipackstr) {
		this.specMinipackstr = specMinipackstr;
	}

	public BigDecimal getSpecMiniunit() {
		return specMiniunit;
	}

	public void setSpecMiniunit(BigDecimal specMiniunit) {
		this.specMiniunit = specMiniunit;
	}

	public Integer getSpecDosetype() {
		return specDosetype;
	}

	public void setSpecDosetype(Integer specDosetype) {
		this.specDosetype = specDosetype;
	}

	public Integer getSpecDose() {
		return specDose;
	}

	public void setSpecDose(Integer specDose) {
		this.specDose = specDose;
	}

	public String getSpecDoseuintstr() {
		return specDoseuintstr;
	}

	public void setSpecDoseuintstr(String specDoseuintstr) {
		this.specDoseuintstr = specDoseuintstr;
	}

	public Integer getSpecUsagefunc() {
		return specUsagefunc;
	}

	public void setSpecUsagefunc(Integer specUsagefunc) {
		this.specUsagefunc = specUsagefunc;
	}

	public String getSpecUsages() {
		return specUsages;
	}

	public void setSpecUsages(String specUsages) {
		this.specUsages = specUsages;
	}

	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}

	public String getFileIdList() {
		return fileIdList;
	}

	public void setFileIdList(String fileIdList) {
		this.fileIdList = fileIdList;
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

	public Long getRegId() {
		return regId;
	}

	public void setRegId(Long regId) {
		this.regId = regId;
	}

	public String getRegNo() {
		return regNo;
	}

	public void setRegNo(String regNo) {
		this.regNo = regNo;
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

	public String getFactoryAddr() {
		return factoryAddr;
	}

	public void setFactoryAddr(String factoryAddr) {
		this.factoryAddr = factoryAddr;
	}

	public String getSpecBrand() {
		return specBrand;
	}

	public void setSpecBrand(String specBrand) {
		this.specBrand = specBrand;
	}

	public Long getGoodsUnitId() {
		return goodsUnitId;
	}

	public void setGoodsUnitId(Long goodsUnitId) {
		this.goodsUnitId = goodsUnitId;
	}

	public Integer getChargeFlag() {
		return chargeFlag;
	}

	public void setChargeFlag(Integer chargeFlag) {
		this.chargeFlag = chargeFlag;
	}

	public Integer getBidType() {
		return bidType;
	}

	public void setBidType(Integer bidType) {
		this.bidType = bidType;
	}

	public Date getBidDate() {
		return bidDate;
	}

	public void setBidDate(Date bidDate) {
		this.bidDate = bidDate;
	}

	public Date getBidExpiredDate() {
		return bidExpiredDate;
	}

	public void setBidExpiredDate(Date bidExpiredDate) {
		this.bidExpiredDate = bidExpiredDate;
	}

	public Integer getBidFlag() {
		return bidFlag;
	}

	public void setBidFlag(Integer bidFlag) {
		this.bidFlag = bidFlag;
	}

	public String getInviteNo() {
		return inviteNo;
	}

	public void setInviteNo(String inviteNo) {
		this.inviteNo = inviteNo;
	}

	public Integer getRepeatFlag() {
		return repeatFlag;
	}

	public void setRepeatFlag(Integer repeatFlag) {
		this.repeatFlag = repeatFlag;
	}

	public Integer getRepeatNo() {
		return repeatNo;
	}

	public void setRepeatNo(Integer repeatNo) {
		this.repeatNo = repeatNo;
	}

	public Integer getRepeatPay() {
		return repeatPay;
	}

	public void setRepeatPay(Integer repeatPay) {
		this.repeatPay = repeatPay;
	}

	public Long getAddBy() {
		return addBy;
	}

	public void setAddBy(Long addBy) {
		this.addBy = addBy;
	}

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
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

	public Integer getSourceFlag() {
		return sourceFlag;
	}

	public void setSourceFlag(Integer sourceFlag) {
		this.sourceFlag = sourceFlag;
	}

	public Long getLendPrice() {
		return lendPrice;
	}

	public void setLendPrice(Long lendPrice) {
		this.lendPrice = lendPrice;
	}

	public Integer getSyncFlag() {
		return syncFlag;
	}

	public void setSyncFlag(Integer syncFlag) {
		this.syncFlag = syncFlag;
	}

	public Boolean isDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Boolean delFlag) {
		this.delFlag = delFlag;
	}

}
