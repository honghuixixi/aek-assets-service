package com.aek.ebey.assets.model;

import com.aek.common.core.base.BaseModel;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 资产档案文件夹表
 * </p>
 *
 * @author cyl
 * @since 2018-04-27
 */
@TableName("ass_archive_folder")
public class AssArchiveFolder extends BaseModel {

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
	 * 资产ID
	 */
	@TableField(value="assets_id")
	private Long assetsId;
	/**
	 * 文件名称
	 */
	@TableField(value="folder_name")
	private String folderName;
	/**
	 * 文件个数
	 */
	@TableField(value="file_num")
	private Integer fileNum;
	/**
	 * 文件日期
	 */
	@TableField(value="folder_date")
	private Date folderDate;
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
	 * 编辑日期
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

	public String getFolderName() {
		return folderName;
	}

	public void setFolderName(String folderName) {
		this.folderName = folderName;
	}

	public Integer getFileNum() {
		return fileNum;
	}

	public void setFileNum(Integer fileNum) {
		this.fileNum = fileNum;
	}

	public Date getFolderDate() {
		return folderDate;
	}

	public void setFolderDate(Date folderDate) {
		this.folderDate = folderDate;
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
