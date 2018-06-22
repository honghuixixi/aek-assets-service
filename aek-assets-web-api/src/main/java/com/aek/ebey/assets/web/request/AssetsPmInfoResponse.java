package com.aek.ebey.assets.web.request;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;

/**
 * PM设备返回实体
 * 
 * @author HongHui
 * @date 2017年11月9日
 */
@ApiModel(value = "AssetsPmInfoResponse", description = "PM设备信息")
public class AssetsPmInfoResponse implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/**
	 * 设备id
	 */
	private Long id;
	/**
	 * 设备名称
	 */
	private String name;

	/**
	 * 设备所在科室id
	 */
	private Long departmentId;
	/**
	 * 设备所在科室名称
	 */
	private String departmentName;
	/**
	 * 设备型号
	 */
	private String model;
	
	/**
	 * 出厂编号
	 */
	private String serialNo;
	
	/**
	 * 设备编号
	 */
	private String no;
	
	/**
     * 购入日期
     */
    private Date buyDate;

	/**
	 * 设备状态:1=在库、2=在用、3=预登、4=待报损、5=报损、6=退货
	 */
	private Integer equipmentStatusType;
	
	/**
	 * 设备状态:1=在库、2=在用、3=预登、4=待报损、5=报损、6=退货
	 */
	private String equipmentStatusText;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public Date getBuyDate() {
		return buyDate;
	}

	public void setBuyDate(Date buyDate) {
		this.buyDate = buyDate;
	}

	public Integer getEquipmentStatusType() {
		return equipmentStatusType;
	}

	public void setEquipmentStatusType(Integer equipmentStatusType) {
		this.equipmentStatusType = equipmentStatusType;
	}

	public String getEquipmentStatusText() {
		return equipmentStatusText;
	}

	public void setEquipmentStatusText(String equipmentStatusText) {
		this.equipmentStatusText = equipmentStatusText;
	}

}
