package com.aek.ebey.assets.model;

import com.aek.common.core.base.BaseModel;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 资产档案采购信息附件表
 * </p>
 *
 * @author cyl
 * @since 2018-04-28
 */
@TableName("ass_archive_purchase_info_attachment")
public class AssArchivePurchaseInfoAttachment extends BaseModel {

    private static final long serialVersionUID = 1L;

	/**
	 * 主键ID
	 */
	private Long id;
	/**
	 * 采购信息id
	 */
	@TableField(value="purchase_id")
	private Long purchaseId;
	/**
	 * 类型1=招标、2=验收
	 */
	private Integer type;
	/**
	 * 采购信息附件文件名
	 */
	@TableField(value="file_name")
	private String fileName;
	/**
	 * 采购信息附件文件地址
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

	public Long getPurchaseId() {
		return purchaseId;
	}

	public void setPurchaseId(Long purchaseId) {
		this.purchaseId = purchaseId;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
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
