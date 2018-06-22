package com.aek.ebey.assets.model;

import com.aek.common.core.base.BaseModel;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 资产档案采购信息表
 * </p>
 *
 * @author cyl
 * @since 2018-04-28
 */
@TableName("ass_archive_purchase_info")
public class AssArchivePurchaseInfo extends BaseModel {

    private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	private Long id;
	/**
	 * 档案ID
	 */
	@TableField(value="archive_id")
	private Long archiveId;
	/**
	 * 设备ID
	 */
	@TableField(value="assets_id")
	private Long assetsId;
	/**
	 * 购置类别:1=新增、2=添置、3=报废更新
	 */
	@TableField(value="purchase_type")
	private Integer purchaseType;
	/**
	 * 申购日期
	 */
	@TableField(value="apply_date")
	private Date applyDate;
	/**
	 * 申购科室ID
	 */
	@TableField(value="apply_dept_id")
	private Integer applyDeptId;
	/**
	 * 论证日期
	 */
	@TableField(value="prove_date")
	private Date proveDate;
	/**
	 * 预到时间
	 */
	@TableField(value="preview_arrive_date")
	private Date previewArriveDate;
	/**
	 * 申购理由
	 */
	@TableField(value="apply_reason")
	private String applyReason;
	/**
	 * 验收人员
	 */
	private String acceptor;
	/**
	 * 验收部门
	 */
	@TableField(value="acceptor_dept_name")
	private String acceptorDeptName;
	/**
	 * 验收时间
	 */
	@TableField(value="acceptor_time")
	private Date acceptorTime;
	/**
	 * 采购方式:1=国际招标、2=政府采购、3=院内采购、4=分散采购、5=自行采购、6=其他
	 */
	@TableField(value="purchase_mode")
	private Integer purchaseMode;
	/**
	 * 招标形式:1=公开招标、2=邀请招标、3=竞争性谈判、4=单一来源采购、5=询价采购、6=其他
	 */
	@TableField(value="tender_form")
	private Integer tenderForm;
	/**
	 * 单项预算
	 */
	@TableField(value="single_budget")
	private Double singleBudget;
	/**
	 * 中标时间
	 */
	@TableField(value="tender_date")
	private Date tenderDate;
	/**
	 * 立项依据
	 */
	@TableField(value="build_item_basis")
	private String buildItemBasis;
	/**
	 * 到货时间
	 */
	@TableField(value="arrival_time")
	private Date arrivalTime;
	/**
	 * 创建人ID
	 */
	@TableField(value="create_by")
	private Long createBy;
	/**
	 * 创建日期
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

	public Integer getPurchaseType() {
		return purchaseType;
	}

	public void setPurchaseType(Integer purchaseType) {
		this.purchaseType = purchaseType;
	}

	public Date getApplyDate() {
		return applyDate;
	}

	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}

	public Integer getApplyDeptId() {
		return applyDeptId;
	}

	public void setApplyDeptId(Integer applyDeptId) {
		this.applyDeptId = applyDeptId;
	}

	public Date getProveDate() {
		return proveDate;
	}

	public void setProveDate(Date proveDate) {
		this.proveDate = proveDate;
	}

	public Date getPreviewArriveDate() {
		return previewArriveDate;
	}

	public void setPreviewArriveDate(Date previewArriveDate) {
		this.previewArriveDate = previewArriveDate;
	}

	public String getApplyReason() {
		return applyReason;
	}

	public void setApplyReason(String applyReason) {
		this.applyReason = applyReason;
	}

	public String getAcceptor() {
		return acceptor;
	}

	public void setAcceptor(String acceptor) {
		this.acceptor = acceptor;
	}

	public String getAcceptorDeptName() {
		return acceptorDeptName;
	}

	public void setAcceptorDeptName(String acceptorDeptName) {
		this.acceptorDeptName = acceptorDeptName;
	}

	public Date getAcceptorTime() {
		return acceptorTime;
	}

	public void setAcceptorTime(Date acceptorTime) {
		this.acceptorTime = acceptorTime;
	}

	public Integer getPurchaseMode() {
		return purchaseMode;
	}

	public void setPurchaseMode(Integer purchaseMode) {
		this.purchaseMode = purchaseMode;
	}

	public Integer getTenderForm() {
		return tenderForm;
	}

	public void setTenderForm(Integer tenderForm) {
		this.tenderForm = tenderForm;
	}

	public Double getSingleBudget() {
		return singleBudget;
	}

	public void setSingleBudget(Double singleBudget) {
		this.singleBudget = singleBudget;
	}

	public Date getTenderDate() {
		return tenderDate;
	}

	public void setTenderDate(Date tenderDate) {
		this.tenderDate = tenderDate;
	}

	public String getBuildItemBasis() {
		return buildItemBasis;
	}

	public void setBuildItemBasis(String buildItemBasis) {
		this.buildItemBasis = buildItemBasis;
	}

	public Date getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(Date arrivalTime) {
		this.arrivalTime = arrivalTime;
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
