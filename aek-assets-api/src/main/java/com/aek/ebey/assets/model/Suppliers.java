package com.aek.ebey.assets.model;

import com.aek.common.core.base.BaseModel;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 供应商信息表。
 * </p>
 *
 * @author aek
 * @since 2017-04-13
 */
@TableName("ass_suppliers")
public class Suppliers extends BaseModel {

    private static final long serialVersionUID = 1L;

	/**
	 * 供应商ID。
	 */
	private Long id;
	/**
	 * 区域id
	 */
	@TableField(value="area_id")
	private Integer areaId;
	/**
	 * 系统id。用于区分不同部署。
	 */
	@TableField(value="sys_id")
	private Long sysId;
	/**
	 * 商家角色类型字符串（0没有该角色，1有该角色），第一位代表供应商，第二位代表厂家，第三位代表安装服务商，第四位代表维修服务商，第五位代表PM服务商（例：1100000000代表既是维修服务商又是PM服务商）
	 */
	@TableField(value="org_type")
	private String orgType;
	/**
	 * 类型：0统包商 1供货商 2服务商
	 */
	@TableField(value="spl_type")
	private Integer splType;
	/**
	 * 供应商唯一标志GUID。
	 */
	@TableField(value="spl_guid")
	private String splGuid;
	/**
	 * 供应商注册证号。
	 */
	@TableField(value="spl_no")
	private String splNo;
	/**
	 * 供应商名称。
	 */
	@TableField(value="spl_name")
	private String splName;
	/**
	 * 供应商名称拼音码。
	 */
	@TableField(value="spl_name_py")
	private String splNamePy;
	/**
	 * 供应商名称五笔码。
	 */
	@TableField(value="spl_name_wb")
	private String splNameWb;
	/**
	 * 供应商简称。
	 */
	@TableField(value="spl_alias")
	private String splAlias;
	/**
	 * 税号。
	 */
	@TableField(value="spl_tax_no")
	private String splTaxNo;
	/**
	 * 法人。
	 */
	@TableField(value="spl_legal_person")
	private String splLegalPerson;
	/**
	 * 开户银行。
	 */
	@TableField(value="spl_bank_name")
	private String splBankName;
	/**
	 * 银行账号。
	 */
	@TableField(value="spl_bank_no")
	private String splBankNo;
	/**
	 * 付款方式
	 */
	@TableField(value="spl_pay_type")
	private Integer splPayType;
	/**
	 * 电话。
	 */
	@TableField(value="spl_tel")
	private String splTel;
	/**
	 * 邮编。
	 */
	@TableField(value="spl_postcode")
	private String splPostcode;
	/**
	 * 传真。
	 */
	@TableField(value="spl_fax")
	private String splFax;
	/**
	 * 电子邮件。
	 */
	@TableField(value="spl_email")
	private String splEmail;
	/**
	 * 所在省。
	 */
	@TableField(value="spl_addr_province")
	private String splAddrProvince;
	/**
	 * 所在地/市。
	 */
	@TableField(value="spl_addr_city")
	private String splAddrCity;
	/**
	 * 所在区/县。
	 */
	@TableField(value="spl_addr_country")
	private String splAddrCountry;
	/**
	 * 详细地址。
	 */
	@TableField(value="spl_addr_detail")
	private String splAddrDetail;
	/**
	 * 办公地址。
	 */
	@TableField(value="spl_office_addr")
	private String splOfficeAddr;
	/**
	 * 公司网址。
	 */
	@TableField(value="spl_url")
	private String splUrl;
	/**
	 * 公司简介。
	 */
	@TableField(value="spl_desc")
	private String splDesc;
	/**
	 * 供应商LOGO图片ID。
	 */
	@TableField(value="spl_logo_image_id")
	private Long splLogoImageId;
	/**
	 * 供应商付款方式，对应基本代码PAY_TYPE类型。
	 */
	@TableField(value="pay_type")
	private Integer payType;
	/**
	 * 供应商凭证编码。
	 */
	@TableField(value="voucher_code")
	private String voucherCode;
	/**
	 * 证件存放位置。
	 */
	@TableField(value="file_location")
	private String fileLocation;
	/**
	 * 联系人身份证。
	 */
	@TableField(value="conts_name_idcode")
	private String contsNameIdcode;
	/**
	 * 联系人姓名
	 */
	@TableField(value="conts_name")
	private String contsName;
	/**
	 * 移动电话。
	 */
	@TableField(value="conts_phone")
	private String contsPhone;
	/**
	 * 联系人QQ。
	 */
	@TableField(value="conts_qq")
	private Integer contsQq;
	/**
	 * 联系人邮箱
	 */
	@TableField(value="conts_email")
	private String contsEmail;
	/**
	 * 企业税率
	 */
	@TableField(value="tax_rate")
	private Long taxRate;
	/**
	 * 企业类型
	 */
	@TableField(value="type_id")
	private String typeId;
	/**
	 * 类型名称
	 */
	@TableField(value="type_name")
	private String typeName;
	/**
	 * excel模版上传ID。
	 */
	@TableField(value="exceltemplate_id")
	private Long exceltemplateId;
	/**
	 * 审核人id
	 */
	@TableField(value="approve_by")
	private Long approveBy;
	/**
	 * 审核时间
	 */
	@TableField(value="approve_time")
	private Date approveTime;
	/**
	 * 审核状态
	 */
	@TableField(value="approve_status")
	private Long approveStatus;
	/**
	 * 复核人id
	 */
	@TableField(value="review_by")
	private Long reviewBy;
	/**
	 * 复核时间
	 */
	@TableField(value="review_time")
	private Date reviewTime;
	/**
	 * 添加人ID。
	 */
	@TableField(value="create_by")
	private Long createBy;
	/**
	 * 添加时间。
	 */
	@TableField(value="create_time")
	private Date createTime;
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
	 * 是否已注册标记。0：未注册；1：已注册。
	 */
	@TableField(value="reg_flag")
	private Integer regFlag;
	/**
	 * 同步标志
	 */
	@TableField(value="sync_flag")
	private Integer syncFlag;
	/**
	 * 状态标志(0启用 1暂停 2禁用)
	 */
	@TableField(value="valid_flag")
	private Integer validFlag;
	/**
	 * 作废标记：0:正常、1:作废、2:停用。
	 */
	@TableField(value="del_flag")
	private Boolean delFlag;
	/**
	 * 图片文件id列表，以逗号隔开
	 */
	@TableField(value="flie_list")
	private String flieList;


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

	public String getOrgType() {
		return orgType;
	}

	public void setOrgType(String orgType) {
		this.orgType = orgType;
	}

	public Integer getSplType() {
		return splType;
	}

	public void setSplType(Integer splType) {
		this.splType = splType;
	}

	public String getSplGuid() {
		return splGuid;
	}

	public void setSplGuid(String splGuid) {
		this.splGuid = splGuid;
	}

	public String getSplNo() {
		return splNo;
	}

	public void setSplNo(String splNo) {
		this.splNo = splNo;
	}

	public String getSplName() {
		return splName;
	}

	public void setSplName(String splName) {
		this.splName = splName;
	}

	public String getSplNamePy() {
		return splNamePy;
	}

	public void setSplNamePy(String splNamePy) {
		this.splNamePy = splNamePy;
	}

	public String getSplNameWb() {
		return splNameWb;
	}

	public void setSplNameWb(String splNameWb) {
		this.splNameWb = splNameWb;
	}

	public String getSplAlias() {
		return splAlias;
	}

	public void setSplAlias(String splAlias) {
		this.splAlias = splAlias;
	}

	public String getSplTaxNo() {
		return splTaxNo;
	}

	public void setSplTaxNo(String splTaxNo) {
		this.splTaxNo = splTaxNo;
	}

	public String getSplLegalPerson() {
		return splLegalPerson;
	}

	public void setSplLegalPerson(String splLegalPerson) {
		this.splLegalPerson = splLegalPerson;
	}

	public String getSplBankName() {
		return splBankName;
	}

	public void setSplBankName(String splBankName) {
		this.splBankName = splBankName;
	}

	public String getSplBankNo() {
		return splBankNo;
	}

	public void setSplBankNo(String splBankNo) {
		this.splBankNo = splBankNo;
	}

	public Integer getSplPayType() {
		return splPayType;
	}

	public void setSplPayType(Integer splPayType) {
		this.splPayType = splPayType;
	}

	public String getSplTel() {
		return splTel;
	}

	public void setSplTel(String splTel) {
		this.splTel = splTel;
	}

	public String getSplPostcode() {
		return splPostcode;
	}

	public void setSplPostcode(String splPostcode) {
		this.splPostcode = splPostcode;
	}

	public String getSplFax() {
		return splFax;
	}

	public void setSplFax(String splFax) {
		this.splFax = splFax;
	}

	public String getSplEmail() {
		return splEmail;
	}

	public void setSplEmail(String splEmail) {
		this.splEmail = splEmail;
	}

	public String getSplAddrProvince() {
		return splAddrProvince;
	}

	public void setSplAddrProvince(String splAddrProvince) {
		this.splAddrProvince = splAddrProvince;
	}

	public String getSplAddrCity() {
		return splAddrCity;
	}

	public void setSplAddrCity(String splAddrCity) {
		this.splAddrCity = splAddrCity;
	}

	public String getSplAddrCountry() {
		return splAddrCountry;
	}

	public void setSplAddrCountry(String splAddrCountry) {
		this.splAddrCountry = splAddrCountry;
	}

	public String getSplAddrDetail() {
		return splAddrDetail;
	}

	public void setSplAddrDetail(String splAddrDetail) {
		this.splAddrDetail = splAddrDetail;
	}

	public String getSplOfficeAddr() {
		return splOfficeAddr;
	}

	public void setSplOfficeAddr(String splOfficeAddr) {
		this.splOfficeAddr = splOfficeAddr;
	}

	public String getSplUrl() {
		return splUrl;
	}

	public void setSplUrl(String splUrl) {
		this.splUrl = splUrl;
	}

	public String getSplDesc() {
		return splDesc;
	}

	public void setSplDesc(String splDesc) {
		this.splDesc = splDesc;
	}

	public Long getSplLogoImageId() {
		return splLogoImageId;
	}

	public void setSplLogoImageId(Long splLogoImageId) {
		this.splLogoImageId = splLogoImageId;
	}

	public Integer getPayType() {
		return payType;
	}

	public void setPayType(Integer payType) {
		this.payType = payType;
	}

	public String getVoucherCode() {
		return voucherCode;
	}

	public void setVoucherCode(String voucherCode) {
		this.voucherCode = voucherCode;
	}

	public String getFileLocation() {
		return fileLocation;
	}

	public void setFileLocation(String fileLocation) {
		this.fileLocation = fileLocation;
	}

	public String getContsNameIdcode() {
		return contsNameIdcode;
	}

	public void setContsNameIdcode(String contsNameIdcode) {
		this.contsNameIdcode = contsNameIdcode;
	}

	public String getContsName() {
		return contsName;
	}

	public void setContsName(String contsName) {
		this.contsName = contsName;
	}

	public String getContsPhone() {
		return contsPhone;
	}

	public void setContsPhone(String contsPhone) {
		this.contsPhone = contsPhone;
	}

	public Integer getContsQq() {
		return contsQq;
	}

	public void setContsQq(Integer contsQq) {
		this.contsQq = contsQq;
	}

	public String getContsEmail() {
		return contsEmail;
	}

	public void setContsEmail(String contsEmail) {
		this.contsEmail = contsEmail;
	}

	public Long getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(Long taxRate) {
		this.taxRate = taxRate;
	}

	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public Long getExceltemplateId() {
		return exceltemplateId;
	}

	public void setExceltemplateId(Long exceltemplateId) {
		this.exceltemplateId = exceltemplateId;
	}

	public Long getApproveBy() {
		return approveBy;
	}

	public void setApproveBy(Long approveBy) {
		this.approveBy = approveBy;
	}

	public Date getApproveTime() {
		return approveTime;
	}

	public void setApproveTime(Date approveTime) {
		this.approveTime = approveTime;
	}

	public Long getApproveStatus() {
		return approveStatus;
	}

	public void setApproveStatus(Long approveStatus) {
		this.approveStatus = approveStatus;
	}

	public Long getReviewBy() {
		return reviewBy;
	}

	public void setReviewBy(Long reviewBy) {
		this.reviewBy = reviewBy;
	}

	public Date getReviewTime() {
		return reviewTime;
	}

	public void setReviewTime(Date reviewTime) {
		this.reviewTime = reviewTime;
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

	public Integer getSourceFlag() {
		return sourceFlag;
	}

	public void setSourceFlag(Integer sourceFlag) {
		this.sourceFlag = sourceFlag;
	}

	public Integer getRegFlag() {
		return regFlag;
	}

	public void setRegFlag(Integer regFlag) {
		this.regFlag = regFlag;
	}

	public Integer getSyncFlag() {
		return syncFlag;
	}

	public void setSyncFlag(Integer syncFlag) {
		this.syncFlag = syncFlag;
	}

	public Integer getValidFlag() {
		return validFlag;
	}

	public void setValidFlag(Integer validFlag) {
		this.validFlag = validFlag;
	}

	public Boolean isDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Boolean delFlag) {
		this.delFlag = delFlag;
	}

	public String getFlieList() {
		return flieList;
	}

	public void setFlieList(String flieList) {
		this.flieList = flieList;
	}

}
