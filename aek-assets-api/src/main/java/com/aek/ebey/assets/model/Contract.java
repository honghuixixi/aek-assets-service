package com.aek.ebey.assets.model;

import java.util.Date;

import com.aek.common.core.base.BaseModel;
import com.aek.ebey.assets.core.util.NoComparedField;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * <p>
 * 设备合同信息
 * </p>
 *
 * @author aek
 * @since 2017-04-13
 */
@TableName("ass_contract")
public class Contract extends BaseModel {

	private static final long serialVersionUID = 1L;

	/**
	 * 资产ID
	 */
	@TableField(exist = false)
	@NoComparedField
	private Long assetsId;

	/**
	 * 
	 */
	@TableField(value = "sys_id")
	@NoComparedField
	private Integer sysId;

	/**
	 * 
	 */
	@TableField(value = "area_id")
	@NoComparedField
	private Integer areaId;

	/**
	 * 合同类型ID
	 */
	@TableField(value = "contract_type_id")
	@NoComparedField
	private Integer contractTypeId;

	/**
	 * 合同类型文字说明
	 */
	@TableField(value = "contract_type_text")
	@NoComparedField
	private String contractTypeText;

	/**
	 * 内部合同编号
	 */
	@TableField(value = "inner_contract_no")
	@NoComparedField
	private String innerContractNo;

	/**
	 * 合同编号
	 */
	@TableField(value = "contract_no")
	private String contractNo;

	/**
	 * 合同名称
	 */
	@TableField(value = "contract_name")
	private String contractName;

	/**
	 * 合同价格
	 */
	@TableField(value = "contract_price")
	private Long contractPrice;

	/**
	 * 合同价格
	 */
	@TableField(exist = false)
	@NoComparedField
	private String contractPriceStr;

	public String getContractPriceStr() {
		return contractPriceStr;
	}

	public void setContractPriceStr(String contractPriceStr) {
		this.contractPriceStr = contractPriceStr;
	}

	/**
	 * 合同开始时间
	 */
	@TableField(value = "start_date")
	private Date startDate;

	/**
	 * 合同结束时间
	 */
	@TableField(value = "end_date")
	private Date endDate;

	/**
	 * 图片文件id列表，以逗号隔开
	 */
	@TableField(value = "file_list")
	@NoComparedField
	private String fileList;

	/**
	 * 供应商ID
	 */
	@TableField(value = "supplier_id")
	@NoComparedField
	private Long supplierId;

	/**
	 * 供应商单位名称
	 */
	@TableField(value = "supplier_name")
	@NoComparedField
	private String supplierName;

	/**
	 * 保修时长
	 */
	@TableField(value = "maintain_duration")
	@NoComparedField
	private Integer maintainDuration;

	/**
	 * 延保时长
	 */
	@TableField(value = "extend_maintain_duration")
	@NoComparedField
	private Integer extendMaintainDuration;

	/**
	 * 合同违约金
	 */
	@NoComparedField
	private Long forfeit;

	/**
	 * 验收时间
	 */
	@TableField(value = "acceptance_date")
	@NoComparedField
	private Date acceptanceDate;

	/**
	 * 乙方联系人
	 */
	@TableField(value = "contract_contact_name")
	private String contractContactName;

	/**
	 * 乙方联系电话
	 */
	@TableField(value = "contract_contact_phone")
	private String contractContactPhone;

	/**
	 * 档案编号
	 */
	@TableField(value = "archives_code")
	private String archivesCode;

	/**
	 * 档案管理员
	 */
	@TableField(value = "archives_manager")
	private String archivesManager;

	/**
	 * 合同内容
	 */
	@TableField(value = "contract_content")
	private String contractContent;

	@TableField(value = "del_flag")
	@NoComparedField
	private Boolean delFlag;

	@TableField(value = "create_by")
	@NoComparedField
	private Long createBy;

	@TableField(value = "create_time")
	@NoComparedField
	private Date createTime;

	@TableField(value = "update_by")
	@NoComparedField
	private Long updateBy;

	@TableField(value = "update_time")
	@NoComparedField
	private Date updateTime;

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public Integer getSysId() {
		return sysId;
	}

	public void setSysId(Integer sysId) {
		this.sysId = sysId;
	}

	public Integer getAreaId() {
		return areaId;
	}

	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

	public Integer getContractTypeId() {
		return contractTypeId;
	}

	public void setContractTypeId(Integer contractTypeId) {
		this.contractTypeId = contractTypeId;
	}

	public String getContractTypeText() {
		return contractTypeText;
	}

	public void setContractTypeText(String contractTypeText) {
		this.contractTypeText = contractTypeText;
	}

	public String getInnerContractNo() {
		return innerContractNo;
	}

	public void setInnerContractNo(String innerContractNo) {
		this.innerContractNo = innerContractNo;
	}

	public String getContractNo() {
		return contractNo;
	}

	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}

	public String getContractName() {
		return contractName;
	}

	public void setContractName(String contractName) {
		this.contractName = contractName;
	}

	public Long getContractPrice() {
		return contractPrice;
	}

	public void setContractPrice(Long contractPrice) {
		this.contractPrice = contractPrice;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getFileList() {
		return fileList;
	}

	public void setFileList(String fileList) {
		this.fileList = fileList;
	}

	public Long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public Integer getMaintainDuration() {
		return maintainDuration;
	}

	public void setMaintainDuration(Integer maintainDuration) {
		this.maintainDuration = maintainDuration;
	}

	public Integer getExtendMaintainDuration() {
		return extendMaintainDuration;
	}

	public void setExtendMaintainDuration(Integer extendMaintainDuration) {
		this.extendMaintainDuration = extendMaintainDuration;
	}

	public Long getForfeit() {
		return forfeit;
	}

	public void setForfeit(Long forfeit) {
		this.forfeit = forfeit;
	}

	public Date getAcceptanceDate() {
		return acceptanceDate;
	}

	public void setAcceptanceDate(Date acceptanceDate) {
		this.acceptanceDate = acceptanceDate;
	}

	public String getContractContactName() {
		return contractContactName;
	}

	public void setContractContactName(String contractContactName) {
		this.contractContactName = contractContactName;
	}

	public String getContractContactPhone() {
		return contractContactPhone;
	}

	public void setContractContactPhone(String contractContactPhone) {
		this.contractContactPhone = contractContactPhone;
	}

	public String getArchivesCode() {
		return archivesCode;
	}

	public void setArchivesCode(String archivesCode) {
		this.archivesCode = archivesCode;
	}

	public String getArchivesManager() {
		return archivesManager;
	}

	public void setArchivesManager(String archivesManager) {
		this.archivesManager = archivesManager;
	}

	public String getContractContent() {
		return contractContent;
	}

	public void setContractContent(String contractContent) {
		this.contractContent = contractContent;
	}

	public Long getAssetsId() {
		return assetsId;
	}

	public void setAssetsId(Long assetsId) {
		this.assetsId = assetsId;
	}

	public Boolean getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Boolean delFlag) {
		this.delFlag = delFlag;
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
