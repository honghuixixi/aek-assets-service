package com.aek.ebey.assets.model;

import com.aek.common.core.base.BaseModel;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 资产档案合同信息表
 * </p>
 *
 * @author cyl
 * @since 2018-04-27
 */
@TableName("ass_archive_contract_info")
public class AssArchiveContractInfo extends BaseModel {

    private static final long serialVersionUID = 1L;

	/**
	 * 合同ID
	 */
	private Long id;
	/**
	 * 档案ID
	 */
	@TableField(value="archive_id")
	private Long archiveId;
	/**
	 * 资产ID
	 */
	@TableField(value="assets_id")
	private Long assetsId;
	/**
	 * 合同编号
	 */
	@TableField(value="contract_num")
	private String contractNum;
	/**
	 * 合同名称
	 */
	@TableField(value="contract_name")
	private String contractName;
	/**
	 * 供应商单位名称
	 */
	@TableField(value="supplier_name")
	private String supplierName;
	/**
	 * 签订日期
	 */
	@TableField(value="sign_date")
	private Date signDate;
	/**
	 * 合同金额
	 */
	@TableField(value="contract_price")
	private Double contractPrice;
	/**
	 * 合同截止时间
	 */
	@TableField(value="end_date")
	private Date endDate;
	/**
	 * 乙方联系人
	 */
	@TableField(value="partyb_contact_person")
	private String partybContactPerson;
	/**
	 * 乙方联系电话
	 */
	@TableField(value="partyb_contact_phone")
	private String partybContactPhone;
	/**
	 * 档案编号
	 */
	@TableField(value="contract_archive_num")
	private String contractArchiveNum;
	/**
	 * 档案管理员
	 */
	@TableField(value="contract_archive_administrator")
	private String contractArchiveAdministrator;
	/**
	 * 合同内容
	 */
	@TableField(value="contract_content")
	private String contractContent;
	/**
	 * 创建人ID
	 */
	@TableField(value="create_by")
	private Long createBy;
	/**
	 * 创建时间
	 */
	@TableField(value="create_time")
	private Date createTime;
	/**
	 * 更新人ID
	 */
	@TableField(value="update_by")
	private Long updateBy;
	/**
	 * 更新时间
	 */
	@TableField(value="update_time")
	private Date updateTime;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getArchiveId() {
		return archiveId;
	}

	public void setArchiveId(Long archiveId) {
		this.archiveId = archiveId;
	}

	public Long getAssetsId() {
		return assetsId;
	}

	public void setAssetsId(Long assetsId) {
		this.assetsId = assetsId;
	}

	public String getContractNum() {
		return contractNum;
	}

	public void setContractNum(String contractNum) {
		this.contractNum = contractNum;
	}

	public String getContractName() {
		return contractName;
	}

	public void setContractName(String contractName) {
		this.contractName = contractName;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public Date getSignDate() {
		return signDate;
	}

	public void setSignDate(Date signDate) {
		this.signDate = signDate;
	}

	public Double getContractPrice() {
		return contractPrice;
	}

	public void setContractPrice(Double contractPrice) {
		this.contractPrice = contractPrice;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getPartybContactPerson() {
		return partybContactPerson;
	}

	public void setPartybContactPerson(String partybContactPerson) {
		this.partybContactPerson = partybContactPerson;
	}

	public String getPartybContactPhone() {
		return partybContactPhone;
	}

	public void setPartybContactPhone(String partybContactPhone) {
		this.partybContactPhone = partybContactPhone;
	}

	public String getContractArchiveNum() {
		return contractArchiveNum;
	}

	public void setContractArchiveNum(String contractArchiveNum) {
		this.contractArchiveNum = contractArchiveNum;
	}

	public String getContractArchiveAdministrator() {
		return contractArchiveAdministrator;
	}

	public void setContractArchiveAdministrator(String contractArchiveAdministrator) {
		this.contractArchiveAdministrator = contractArchiveAdministrator;
	}

	public String getContractContent() {
		return contractContent;
	}

	public void setContractContent(String contractContent) {
		this.contractContent = contractContent;
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

}
