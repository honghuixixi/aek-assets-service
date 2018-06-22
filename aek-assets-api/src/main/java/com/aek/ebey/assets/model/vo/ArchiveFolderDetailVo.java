package com.aek.ebey.assets.model.vo;

import java.util.Date;
import java.util.List;

import com.aek.ebey.assets.model.AssArchiveFolderAttachment;

public class ArchiveFolderDetailVo {

	private Long id;
	private String folderName;
	private Date folderDate;
	List<AssArchiveFolderAttachment> attachment;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public List<AssArchiveFolderAttachment> getAttachment() {
		return attachment;
	}
	public void setAttachment(List<AssArchiveFolderAttachment> attachment) {
		this.attachment = attachment;
	}
	
	
}
