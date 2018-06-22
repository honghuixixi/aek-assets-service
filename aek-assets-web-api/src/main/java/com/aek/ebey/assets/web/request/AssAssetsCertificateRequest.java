package com.aek.ebey.assets.web.request;

import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "AssAssetsCertificateRequest", description = "资产证件请求")
public class AssAssetsCertificateRequest {

	@ApiModelProperty(value = "证件id")
	@NotEmpty
	private Long id;
	
	@ApiModelProperty(value = "证件名称")
	@NotEmpty
	private String name;
	
	@ApiModelProperty(value = "图片保存路径")
	@NotEmpty
	private String imageUrl;
	
	@ApiModelProperty(value = "证件编号")
	@NotEmpty
	private String certificateNum;
	
	@ApiModelProperty(value = "证件注册号")
	@NotEmpty
	private String certificateRegisterNum;
	
	@ApiModelProperty(value = "证件类型：1=医疗器械生产企业许可证、2=医疗器械注册证、3=医疗器械经营企业许可证、4=产品合格证、5=自定义证件")
	@NotEmpty
	private Integer certificateType;
	
	@ApiModelProperty(value = "资产ID")
	@NotEmpty
	private Long assetsId;
	
	@ApiModelProperty(value = "有效期至")
	@NotEmpty
	private Date validDate;
	
	@ApiModelProperty(value = "有效期")
	@NotEmpty
	private String validDateStr;
	
	@ApiModelProperty(value = "生产日期")
	@NotEmpty
	private Date productDate;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
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

	public Long getAssetsId() {
		return assetsId;
	}

	public void setAssetsId(Long assetsId) {
		this.assetsId = assetsId;
	}

	public Date getValidDate() {
		return validDate;
	}

	public void setValidDate(Date validDate) {
		this.validDate = validDate;
	}

	public Date getProductDate() {
		return productDate;
	}

	public void setProductDate(Date productDate) {
		this.productDate = productDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getValidDateStr() {
		return validDateStr;
	}

	public void setValidDateStr(String validDateStr) {
		this.validDateStr = validDateStr;
	}
	
	
}
