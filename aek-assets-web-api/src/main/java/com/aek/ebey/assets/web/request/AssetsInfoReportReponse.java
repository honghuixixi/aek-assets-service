package com.aek.ebey.assets.web.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 资产导入返回实体
 */
@ApiModel(value = "AssetsInfoReport", description = "资产导入返回结果")
public class AssetsInfoReportReponse {
	@ApiModelProperty(value = "导入成功数量")
	private int successTotal;

	@ApiModelProperty(value = "导入失败数量")
	private int failTotal;

	public int getSuccessTotal() {
		return successTotal;
	}

	public void setSuccessTotal(int successTotal) {
		this.successTotal = successTotal;
	}

	public int getFailTotal() {
		return failTotal;
	}

	public void setFailTotal(int failTotal) {
		this.failTotal = failTotal;
	}

}
