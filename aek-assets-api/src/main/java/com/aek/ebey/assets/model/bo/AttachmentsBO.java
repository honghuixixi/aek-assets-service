package com.aek.ebey.assets.model.bo;

public class AttachmentsBO {

	private String fileName;
	private String uploadUrl;
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getUploadUrl() {
		return uploadUrl;
	}
	public void setUploadUrl(String uploadUrl) {
		this.uploadUrl = uploadUrl;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fileName == null) ? 0 : fileName.hashCode());
		result = prime * result + ((uploadUrl == null) ? 0 : uploadUrl.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AttachmentsBO other = (AttachmentsBO) obj;
		if (fileName == null) {
			if (other.fileName != null)
				return false;
		} else if (!fileName.equals(other.fileName))
			return false;
		if (uploadUrl == null) {
			if (other.uploadUrl != null)
				return false;
		} else if (!uploadUrl.equals(other.uploadUrl))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "AttachmentsBO [fileName=" + fileName + ", uploadUrl=" + uploadUrl + "]";
	}
	
}
