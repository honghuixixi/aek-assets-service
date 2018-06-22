package com.aek.ebey.assets.model;

import com.aek.common.core.base.BaseModel;
import com.aek.ebey.assets.core.util.NoComparedField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 资产证件表
 * </p>
 *
 * @author aek
 * @since 2017-11-22
 */
@TableName("ass_assets_certificate")
@ApiModel
public class AssAssetsCertificate extends BaseModel {

    private static final long serialVersionUID = 1L;
     
	/**
	 * 证件编号
	 */
	@ApiModelProperty(value="证件编号")
	@TableField(value="certificate_num")
	private String certificateNum;
	
	/**
	 * 证件注册号
	 */
	@ApiModelProperty(value="证件注册号")
	@TableField(value="certificate_register_num")
	private String certificateRegisterNum;
	
	/**
	 * 证件类型：1=医疗器械生产企业许可证、2=医疗器械注册证、3=医疗器械经营企业许可证、4=产品合格证、5=自定义证件
	 */
	@ApiModelProperty(value="证件类型：1=医疗器械生产企业许可证、2=医疗器械注册证、3=医疗器械经营企业许可证、4=产品合格证、5=自定义证件")
	@TableField(value="certificate_type")
	@NoComparedField
	private Integer certificateType;
	/**
	 * 证件名称
	 */
	@NoComparedField
	@ApiModelProperty(value="证件名称")
	@TableField(value="name")
	private String name;
	/**
	 * 资产ID
	 */
	@NoComparedField
	@ApiModelProperty(value="资产ID")
	@TableField(value="assets_id")
	private Long assetsId;
	/**
	 * 有效期至
	 */
	@ApiModelProperty(value="有效期至")
	@TableField(value="valid_date")
	private Date validDate;
	
	/**
	 * 有效期
	 */
	@ApiModelProperty(value="有效期")
	@TableField(value="valid_date_str")
	private String validDateStr;
	
	/**
	 * 生产日期
	 */
	@ApiModelProperty(value="生产日期")
	@TableField(value="product_date")
	private Date productDate;
	/**
	 * 图片保存路径
	 */
	@NoComparedField
	@ApiModelProperty(value="图片保存路径")
	@TableField(value="image_url")
	private String imageUrl;
	/**
	 * 系统ID
	 */
	@NoComparedField
	@ApiModelProperty(value="系统ID")
	@TableField(value="sys_id")
	private Long sysId;
	/**
	 * 作废标识0启用1作废
	 */
	@ApiModelProperty(value="作废标识0启用1作废")
	@TableField(value="del_flag")
	@NoComparedField
	private Boolean delFlag;
	
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
	public String getValidDateStr() {
		return validDateStr;
	}
	public void setValidDateStr(String validDateStr) {
		this.validDateStr = validDateStr;
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
	public Long getSysId() {
		return sysId;
	}
	public void setSysId(Long sysId) {
		this.sysId = sysId;
	}
	public Boolean getDelFlag() {
		return delFlag;
	}
	public void setDelFlag(Boolean delFlag) {
		this.delFlag = delFlag;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((assetsId == null) ? 0 : assetsId.hashCode());
		result = prime * result + ((certificateNum == null) ? 0 : certificateNum.hashCode());
		result = prime * result + ((certificateRegisterNum == null) ? 0 : certificateRegisterNum.hashCode());
		result = prime * result + ((certificateType == null) ? 0 : certificateType.hashCode());
		result = prime * result + ((delFlag == null) ? 0 : delFlag.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((imageUrl == null) ? 0 : imageUrl.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((productDate == null) ? 0 : productDate.hashCode());
		result = prime * result + ((sysId == null) ? 0 : sysId.hashCode());
		result = prime * result + ((validDate == null) ? 0 : validDate.hashCode());
		result = prime * result + ((validDateStr == null) ? 0 : validDateStr.hashCode());
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
		AssAssetsCertificate other = (AssAssetsCertificate) obj;
		if (assetsId == null) {
			if (other.assetsId != null)
				return false;
		} else if (!assetsId.equals(other.assetsId))
			return false;
		if (certificateNum == null) {
			if (other.certificateNum != null)
				return false;
		} else if (!certificateNum.equals(other.certificateNum))
			return false;
		if (certificateRegisterNum == null) {
			if (other.certificateRegisterNum != null)
				return false;
		} else if (!certificateRegisterNum.equals(other.certificateRegisterNum))
			return false;
		if (certificateType == null) {
			if (other.certificateType != null)
				return false;
		} else if (!certificateType.equals(other.certificateType))
			return false;
		if (imageUrl == null) {
			if (other.imageUrl != null)
				return false;
		} else if (!imageUrl.equals(other.imageUrl))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (productDate == null) {
			if (other.productDate != null)
				return false;
		} else if (!productDate.equals(other.productDate))
			return false;
		if (sysId == null) {
			if (other.sysId != null)
				return false;
		} else if (!sysId.equals(other.sysId))
			return false;
		if (validDate == null) {
			if (other.validDate != null)
				return false;
		} else if (!validDate.equals(other.validDate))
			return false;
		if (validDateStr == null) {
			if (other.validDateStr != null)
				return false;
		} else if (!validDateStr.equals(other.validDateStr))
			return false;
		return true;
	}
	
	
	
	
	
	
	

	
}
