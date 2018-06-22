package com.aek.ebey.assets.web.request;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 预台下拉账响应实体类
 * <承载各类ID查询返回的结果>
 * <存储一个ID  一个通用Name 统一使用>
 * @author zhousx
 * @version  1.0, 2017年4月17日
 *
 */

@ApiModel(value = "CodeInfo", description = "预台账下拉信息")
public class CodeInfoResponse {
	
	@ApiModelProperty
	private Long id;
	
	@ApiModelProperty
	private String codeText;

	@ApiModelProperty
    private String codeValue;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodeText() {
		return codeText;
	}

	public void setCodeText(String codeText) {
		this.codeText = codeText;
	}

	public String getCodeValue() {
		return codeValue;
	}

	public void setCodeValue(String codeValue) {
		this.codeValue = codeValue;
	}

	
}
