package com.aek.ebey.assets.model;

import com.aek.common.core.base.BaseModel;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 资产档案文件夹附件表
 * </p>
 *
 * @author cyl
 * @since 2018-04-27
 */
@TableName("ass_archive_folder_attachment")
public class AssArchiveFolderAttachment extends BaseModel {

    private static final long serialVersionUID = 1L;

	/**
	 * 主键ID
	 */
	private Long id;
	/**
	 * 文件夹id
	 */
	@TableField(value="folder_id")
	private Long folderId;
	/**
	 * 文件夹附件名称
	 */
	@TableField(value="file_name")
	private String fileName;
	/**
	 * 文件夹附件地址
	 */
	@TableField(value="file_url")
	private String fileUrl;
	/**
	 * 创建时间
	 */
	@TableField(value="create_time")
	private Date createTime;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getFolderId() {
		return folderId;
	}

	public void setFolderId(Long folderId) {
		this.folderId = folderId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileUrl() {
		return fileUrl;
	}

	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
