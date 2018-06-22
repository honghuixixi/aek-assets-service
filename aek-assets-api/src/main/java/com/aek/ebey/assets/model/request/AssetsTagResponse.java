package com.aek.ebey.assets.model.request;

import java.util.Map;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 资产标签实体类
 *	
 * @author HongHui
 * @date   2017年12月26日
 */
@ApiModel(value = "AssetsTagResponse", description = "资产标签打印内容")
public class AssetsTagResponse{

	/**
	 * 资产标签打印内容宽度
	 */
	@ApiModelProperty(value = "标签宽度，单位:px")
	private Float width;
	
	/**
	 * 资产标签打印内容高度
	 */
	@ApiModelProperty(value = "标签高度，单位:px")
	private Float height;
	
	/**
	 * 资产标签打印内容
	 */
	@ApiModelProperty(value = "资产标签打印HTML内容")
	private String content;
	
	/**
	 * 资产标签数据
	 */
	@ApiModelProperty(value = "资产标签数据")
	private Map<String,Object> assetsData;
	
	public Float getWidth() {
		return width;
	}

	public void setWidth(Float width) {
		this.width = width;
	}

	public Float getHeight() {
		return height;
	}

	public void setHeight(Float height) {
		this.height = height;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Map<String, Object> getAssetsData() {
		return assetsData;
	}

	public void setAssetsData(Map<String, Object> assetsData) {
		this.assetsData = assetsData;
	}
	
}
