package com.aek.ebey.assets.model;

import java.util.Date;

import com.aek.common.core.base.BaseModel;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * <p>
 * 设备报损单
 * </p>
 *
 * @author aek
 * @since 2017-12-14
 */
@TableName("ass_assets_discard")
public class AssDiscard extends BaseModel {

    private static final long serialVersionUID = 1L;

	/**
	 * 机构ID
	 */
	@TableField(value="tenant_id")
	private Long tenantId;
	/**
	 * 机构名称
	 */
	@TableField(value="tenant_name")
	private String tenantName;
	/**
	 * 报损单号
	 */
	@TableField(value="discard_no")
	private String discardNo;
	/**
	 * 创建时间
	 */
	@TableField(value="create_time")
	private Date createTime=new Date();
	/**
	 * 申请人id
	 */
	@TableField(value="apply_id")
	private Long applyId;
	/**
	 * 申请人姓名
	 */
	@TableField(value="apply_name")
	private String applyName;
	/**
	 * 审核人ID
	 */
	@TableField(value="verify_id")
	private Long verifyId;
	/**
	 * 审核人姓名
	 */
	@TableField(value="verify_name")
	private String verifyName;
	/**
	 * 审核时间
	 */
	@TableField(value="verify_time")
	private Date verifyTime;
	/**
	 * 报损类型（1，在库 2，在用 3，附件）
	 */
	private Integer type;
	/**
	 * 申请说明
	 */
	@TableField(value="apply_instruction")
	private String applyInstruction;
	/**
	 * 状态 1:待审核、2:审核通过 3:审核不通过
	 */
	private Integer status;
	/**
	 * 审核意见
	 */
	@TableField(value="verify_opinion")
	private String verifyOpinion;
	
	/**
	 * 审核备注
	 */
	private String remarks;


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

	public String getDiscardNo() {
		return discardNo;
	}

	public void setDiscardNo(String discardNo) {
		this.discardNo = discardNo;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Long getApplyId() {
		return applyId;
	}

	public void setApplyId(Long applyId) {
		this.applyId = applyId;
	}

	public String getApplyName() {
		return applyName;
	}

	public void setApplyName(String applyName) {
		this.applyName = applyName;
	}

	public Long getVerifyId() {
		return verifyId;
	}

	public void setVerifyId(Long verifyId) {
		this.verifyId = verifyId;
	}

	public String getVerifyName() {
		return verifyName;
	}

	public void setVerifyName(String verifyName) {
		this.verifyName = verifyName;
	}

	public Date getVerifyTime() {
		return verifyTime;
	}

	public void setVerifyTime(Date verifyTime) {
		this.verifyTime = verifyTime;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getApplyInstruction() {
		return applyInstruction;
	}

	public void setApplyInstruction(String applyInstruction) {
		this.applyInstruction = applyInstruction;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getVerifyOpinion() {
		return verifyOpinion;
	}

	public void setVerifyOpinion(String verifyOpinion) {
		this.verifyOpinion = verifyOpinion;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}
