package com.aek.ebey.assets.model;

import com.aek.common.core.base.BaseModel;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 设备档案表
 * </p>
 *
 * @author cyl
 * @since 2018-04-25
 */
@TableName("ass_archive")
public class AssArchive extends BaseModel {

    private static final long serialVersionUID = 1L;

	/**
	 * 主键ID
	 */
	private Long id;
	/**
	 * 机构ID
	 */
	@TableField(value="tenant_id")
	private Long tenantId;
	/**
	 * 设备ID
	 */
	@TableField(value="assets_id")
	private Long assetsId;
	/**
	 * 档案名称
	 */
	@TableField(value="archive_name")
	private String archiveName;
	/**
	 * 档案编号
	 */
	@TableField(value="archive_num")
	private String archiveNum;
	/**
	 * 保管期限(1=永久，2=长期(16~50年)，3=短期(15年以下))
	 */
	@TableField(value="limit_storage_time")
	private Integer limitStorageTime;
	/**
	 * 保密级别(1=公开级,2=内部级,3=秘密级,4=机密级,5=绝密级)
	 */
	@TableField(value="secret_level")
	private Integer secretLevel;
	/**
	 * 立卷人
	 */
	@TableField(value="filing_user_name")
	private String filingUserName;
	/**
	 * 立卷时间
	 */
	@TableField(value="filing_time")
	private Date filingTime;
	/**
	 * 检查人
	 */
	@TableField(value="check_user_name")
	private String checkUserName;
	/**
	 * 检查日期
	 */
	@TableField(value="check_time")
	private Date checkTime;
	/**
	 * 起止开始时间
	 */
	@TableField(value="start_time")
	private Date startTime;
	/**
	 * 起止结束时间
	 */
	@TableField(value="end_time")
	private Date endTime;
	/**
	 * 立卷单位
	 */
	@TableField(value="filing_department")
	private String filingDepartment;
	/**
	 * 新建时间
	 */
	@TableField(value="create_time")
	private Date createTime;
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

	public Long getTenantId() {
		return tenantId;
	}

	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}

	public Long getAssetsId() {
		return assetsId;
	}

	public void setAssetsId(Long assetsId) {
		this.assetsId = assetsId;
	}

	public String getArchiveName() {
		return archiveName;
	}

	public void setArchiveName(String archiveName) {
		this.archiveName = archiveName;
	}

	public String getArchiveNum() {
		return archiveNum;
	}

	public void setArchiveNum(String archiveNum) {
		this.archiveNum = archiveNum;
	}

	public Integer getLimitStorageTime() {
		return limitStorageTime;
	}

	public void setLimitStorageTime(Integer limitStorageTime) {
		this.limitStorageTime = limitStorageTime;
	}

	public Integer getSecretLevel() {
		return secretLevel;
	}

	public void setSecretLevel(Integer secretLevel) {
		this.secretLevel = secretLevel;
	}

	public String getFilingUserName() {
		return filingUserName;
	}

	public void setFilingUserName(String filingUserName) {
		this.filingUserName = filingUserName;
	}

	public Date getFilingTime() {
		return filingTime;
	}

	public void setFilingTime(Date filingTime) {
		this.filingTime = filingTime;
	}

	public String getCheckUserName() {
		return checkUserName;
	}

	public void setCheckUserName(String checkUserName) {
		this.checkUserName = checkUserName;
	}

	public Date getCheckTime() {
		return checkTime;
	}

	public void setCheckTime(Date checkTime) {
		this.checkTime = checkTime;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getFilingDepartment() {
		return filingDepartment;
	}

	public void setFilingDepartment(String filingDepartment) {
		this.filingDepartment = filingDepartment;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

}
