package com.aek.ebey.assets.model.request;

import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "AssAssetsTransferRequest", description = "新建转科单请求")
public class AssAssetsTransferRequest {
	
	@ApiModelProperty(value = "选中设备id集合")
	@NotEmpty
	private List<Long> ids;
	
	@ApiModelProperty(value = "转入部门id")
	@NotEmpty
	private Long dept;
	
	@ApiModelProperty(value = "部门负责人")
	@NotEmpty
	private String director;	
	
	@ApiModelProperty(value = "申请说明")
	@NotEmpty
	private String illustration;

	public List<Long> getIds() {
		return ids;
	}

	public void setIds(List<Long> ids) {
		this.ids = ids;
	}

	
	public Long getDept() {
		return dept;
	}

	public void setDept(Long dept) {
		this.dept = dept;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getIllustration() {
		return illustration;
	}

	public void setIllustration(String illustration) {
		this.illustration = illustration;
	}

	

	
	
	
}
