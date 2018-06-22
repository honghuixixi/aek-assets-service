package com.aek.ebey.assets.model;

import com.aek.common.core.base.BaseModel;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 资产招标、验收附件表
 * </p>
 *
 * @author aek
 * @since 2017-11-22
 */
@TableName("ass_assets_annex")
@ApiModel
public class AssAssetsAnnex extends BaseModel {

    private static final long serialVersionUID = 1L;

	/**
	 * 资产ID
	 */
	@ApiModelProperty(value="资产ID")
	@TableField(value="assets_id")
	private Long assetsId;
	/**
	 * 合同id
	 */
	@ApiModelProperty(value="合同id")
	@TableField(value="contract_id")
	private Long contractId;
	/**
	 * 附件类型:1=招标、2=验收、3=合同
	 */
	@ApiModelProperty(value="附件类型:1=招标、2=验收、3=合同")
	@TableField(value="annex_type")
	private Integer annexType;
	/**
	 * 附件保存路径
	 */
	@ApiModelProperty(value="附件保存路径")
	@TableField(value="annex_url")
	private String annexUrl;
	/**
	 * 系统ID
	 */
	@ApiModelProperty(value="系统ID")
	@TableField(value="sys_id")
	private Long sysId;
	/**
	 * 作废标识0启用1作废
	 */
	@ApiModelProperty(value="作废标识0启用1作废")
	@TableField(value="del_flag")
	private Boolean delFlag;

	public Long getAssetsId() {
		return assetsId;
	}

	public void setAssetsId(Long assetsId) {
		this.assetsId = assetsId;
	}

	public Long getContractId() {
		return contractId;
	}

	public void setContractId(Long contractId) {
		this.contractId = contractId;
	}

	public Integer getAnnexType() {
		return annexType;
	}

	public void setAnnexType(Integer annexType) {
		this.annexType = annexType;
	}

	public String getAnnexUrl() {
		return annexUrl;
	}

	public void setAnnexUrl(String annexUrl) {
		this.annexUrl = annexUrl;
	}

	

	public Long getSysId() {
		return sysId;
	}

	public void setSysId(Long sysId) {
		this.sysId = sysId;
	}

	public Boolean isDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Boolean delFlag) {
		this.delFlag = delFlag;
	}

}
