package com.aek.ebey.assets.web.request;

import java.util.Date;
import java.util.List;

import com.aek.ebey.assets.model.AssArchiveFolderAttachment;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("档案文件夹请求类")
public class AssArchiveFolderRequest {

	private Long id;
	@ApiModelProperty("档案id")
	private Long archiveId;
	@ApiModelProperty("资产ID")
	private Long assetsId;
	@ApiModelProperty("文件名称")
	private String folderName;
	@ApiModelProperty("文件日期")
	private Date folderDate;
	@ApiModelProperty("文件附件")
	private List<AssArchiveFolderAttachment> attachments;
	
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
	public Date getFolderDate() {
		return folderDate;
	}
	public void setFolderDate(Date folderDate) {
		this.folderDate = folderDate;
	}
	public List<AssArchiveFolderAttachment> getAttachments() {
		return attachments;
	}
	public void setAttachments(List<AssArchiveFolderAttachment> attachments) {
		this.attachments = attachments;
	}
	

}
