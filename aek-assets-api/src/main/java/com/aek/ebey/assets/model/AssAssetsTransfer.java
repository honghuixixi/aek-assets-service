package com.aek.ebey.assets.model;

import com.aek.common.core.base.BaseModel;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import io.swagger.annotations.ApiModel;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 资产转科表
 * </p>
 *
 * @author aek
 * @since 2017-12-11
 */
@TableName("ass_assets_transfer")
@ApiModel
public class AssAssetsTransfer extends BaseModel {

    private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	private Long id;
	/**
	 * 转科单号
	 */
	@TableField(value="transfer_num")
	private String transferNum;
	/**
	 * 单据所属机构id
	 */
	@TableField(value="tenant_id")
	private Long tenantId;
	/**
	 * 单据所属机构名称
	 */
	@TableField(value="tenant_name")
	private String tenantName;
	/**
	 * 转科单关联所有设备名称(用于转科单列表查询)
	 */
	@TableField(value="assets_names")
	private String assetsNames;
	/**
	 * 转入科室id
	 */
	@TableField(value="to_dept_id")
	private Long toDeptId;
	/**
	 * 转入科室名称
	 */
	@TableField(value="to_dept_name")
	private String toDeptName;
	/**
	 * 来源科室id
	 */
	@TableField(value="from_dept_id")
	private Long fromDeptId;
	/**
	 * 申请人id
	 */
	@TableField(value="applyer_id")
	private Long applyerId;
	/**
	 * 申请人姓名
	 */
	@TableField(value="applyer_name")
	private String applyerName;
	/**
	 * 审核人id
	 */
	@TableField(value="auditer_id")
	private Long auditerId;
	/**
	 * 审核人姓名
	 */
	@TableField(value="auditer_name")
	private String auditerName;
	/**
	 * 科室负责人姓名
	 */
	@TableField(value="dept_manage_name")
	private String deptManageName;
	/**
	 * 申请说明
	 */
	@TableField(value="apply_desc")
	private String applyDesc;
	/**
	 * 审核意见
	 */
	@TableField(value="audit_opinion")
	private String auditOpinion;
	/**
	 * 审核备注
	 */
	@TableField(value="audit_remark")
	private String auditRemark;
	/**
	 * 审核状态：1=审核通过、2=待审核、3=审核未通过
	 */
	private Integer status;
	/**
	 * 转科单创建时间
	 */
	@TableField(value="creat_time")
	private Date creatTime;
	/**
	 * 审核时间
	 */
	@TableField(value="audit_time")
	private Date auditTime;
	/**
	 * 删除状态（0=未删除、1=删除）
	 */
	@TableField(value="del_flag")
	private Boolean delFlag;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTransferNum() {
		return transferNum;
	}

	public void setTransferNum(String transferNum) {
		this.transferNum = transferNum;
	}

	public Long getTenantId() {
		return tenantId;
	}

	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}

	public String getTenantName() {
		return tenantName;
	}

	public void setTenantName(String tenantName) {
		this.tenantName = tenantName;
	}

	public Long getToDeptId() {
		return toDeptId;
	}

	public void setToDeptId(Long toDeptId) {
		this.toDeptId = toDeptId;
	}

	public String getToDeptName() {
		return toDeptName;
	}

	public void setToDeptName(String toDeptName) {
		this.toDeptName = toDeptName;
	}

	public Long getApplyerId() {
		return applyerId;
	}

	public void setApplyerId(Long applyerId) {
		this.applyerId = applyerId;
	}

	public String getApplyerName() {
		return applyerName;
	}

	public void setApplyerName(String applyerName) {
		this.applyerName = applyerName;
	}

	public Long getAuditerId() {
		return auditerId;
	}

	public void setAuditerId(Long auditerId) {
		this.auditerId = auditerId;
	}

	public String getAuditerName() {
		return auditerName;
	}

	public void setAuditerName(String auditerName) {
		this.auditerName = auditerName;
	}

	public String getDeptManageName() {
		return deptManageName;
	}

	public void setDeptManageName(String deptManageName) {
		this.deptManageName = deptManageName;
	}

	public String getApplyDesc() {
		return applyDesc;
	}

	public void setApplyDesc(String applyDesc) {
		this.applyDesc = applyDesc;
	}

	public String getAuditOpinion() {
		return auditOpinion;
	}

	public void setAuditOpinion(String auditOpinion) {
		this.auditOpinion = auditOpinion;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getCreatTime() {
		return creatTime;
	}

	public void setCreatTime(Date creatTime) {
		this.creatTime = creatTime;
	}

	public Date getAuditTime() {
		return auditTime;
	}

	public void setAuditTime(Date auditTime) {
		this.auditTime = auditTime;
	}

	public Boolean isDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Boolean delFlag) {
		this.delFlag = delFlag;
	}

	public String getAuditRemark() {
		return auditRemark;
	}

	public void setAuditRemark(String auditRemark) {
		this.auditRemark = auditRemark;
	}

	public String getAssetsNames() {
		return assetsNames;
	}

	public void setAssetsNames(String assetsNames) {
		this.assetsNames = assetsNames;
	}

	public Long getFromDeptId() {
		return fromDeptId;
	}

	public void setFromDeptId(Long fromDeptId) {
		this.fromDeptId = fromDeptId;
	}

}
