package com.aek.ebey.assets.model;

import com.aek.common.core.base.BaseModel;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 资产档案证件信息表
 * </p>
 *
 * @author cyl
 * @since 2018-04-26
 */
@TableName("ass_archive_certificate_info")
public class AssArchiveCertificateInfo extends BaseModel {

    private static final long serialVersionUID = 1L;

	/**
	 * 主键
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
	 * 证件编号
	 */
	@TableField(value="certificate_num")
	private String certificateNum;
	/**
	 * 证件注册号
	 */
	@TableField(value="certificate_register_num")
	private String certificateRegisterNum;
	/**
	 * 证件类型：1=医疗器械生产企业许可证、2=医疗器械注册证、3=医疗器械经营企业许可证、4=产品合格证、5=自定义证件
	 */
	@TableField(value="certificate_type")
	private Integer certificateType;
	/**
	 * 证件名称
	 */
	private String name;
	/**
	 * 有效期至
	 */
	@TableField(value="valid_date")
	private Date validDate;
	/**
	 * 有效期(有效时间长度，如1年，24个月等)
	 */
	@TableField(value="expire_time")
	private String expireTime;
	/**
	 * 生产日期
	 */
	@TableField(value="product_date")
	private Date productDate;
	/**
	 * 图片保存路径
	 */
	@TableField(value="image_url")
	private String imageUrl;
	/**
	 * 删除标识(0=未删除，1=已删除)
	 */
	@TableField(value="del_flag")
	private Boolean delFlag;
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
	 * 更新时间
	 */
	@TableField(value="update_time")
	private Date updateTime;
	
	public AssArchiveCertificateInfo() {
		
	}

	public AssArchiveCertificateInfo(Long archiveId, Long assetsId, Integer certificateType, String name,
			Boolean delFlag, Long createBy, Date createTime, Long updateBy, Date updateTime) {
		super();
		this.archiveId = archiveId;
		this.assetsId = assetsId;
		this.certificateType = certificateType;
		this.name = name;
		this.delFlag = delFlag;
		this.createBy = createBy;
		this.createTime = createTime;
		this.updateBy = updateBy;
		this.updateTime = updateTime;
	}

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

	public String getCertificateNum() {
		return certificateNum;
	}

	public void setCertificateNum(String certificateNum) {
		this.certificateNum = certificateNum;
	}

	public String getCertificateRegisterNum() {
		return certificateRegisterNum;
	}

	public void setCertificateRegisterNum(String certificateRegisterNum) {
		this.certificateRegisterNum = certificateRegisterNum;
	}

	public Integer getCertificateType() {
		return certificateType;
	}

	public void setCertificateType(Integer certificateType) {
		this.certificateType = certificateType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getValidDate() {
		return validDate;
	}

	public void setValidDate(Date validDate) {
		this.validDate = validDate;
	}

	public String getExpireTime() {
		return expireTime;
	}

	public void setExpireTime(String expireTime) {
		this.expireTime = expireTime;
	}

	public Date getProductDate() {
		return productDate;
	}

	public void setProductDate(Date productDate) {
		this.productDate = productDate;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Boolean isDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Boolean delFlag) {
		this.delFlag = delFlag;
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
