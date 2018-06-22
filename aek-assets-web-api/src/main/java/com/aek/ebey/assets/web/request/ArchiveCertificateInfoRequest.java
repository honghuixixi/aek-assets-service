package com.aek.ebey.assets.web.request;

import java.util.Date;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("档案证件请求类")
public class ArchiveCertificateInfoRequest {

	private Long id;
	/**
	 * 档案ID
	 */
	@ApiModelProperty(value="档案ID")
	private Long archiveId;
	/**
	 * 资产ID
	 */
	@ApiModelProperty(value="资产ID")
	private Long assetsId;
	/**
	 * 证件编号
	 */
	@ApiModelProperty(value="证件编号")
	private String certificateNum;
	/**
	 * 证件注册号
	 */
	@ApiModelProperty(value="证件注册号")
	private String certificateRegisterNum;
	/**
	 * 证件类型：1=医疗器械生产企业许可证、2=医疗器械注册证、3=医疗器械经营企业许可证、4=产品合格证、5=自定义证件
	 */
	@ApiModelProperty(value="证件类型：1=医疗器械生产企业许可证、2=医疗器械注册证、3=医疗器械经营企业许可证、4=产品合格证、5=自定义证件")
	private Integer certificateType;
	/**
	 * 证件名称
	 */
	@ApiModelProperty(value="证件名称")
	private String name;
	/**
	 * 有效期至
	 */
	@ApiModelProperty(value="有效期至")
	private Date validDate;
	/**
	 * 有效期(有效时间长度，如1年，24个月等)
	 */
	@ApiModelProperty(value="有效期(有效时间长度，如1年，24个月等)")
	private String expireTime;
	/**
	 * 生产日期
	 */
	@ApiModelProperty(value="生产日期")
	private Date productDate;
	/**
	 * 图片保存路径
	 */
	@ApiModelProperty(value="图片保存路径")
	private String imageUrl;
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
	
	
}
