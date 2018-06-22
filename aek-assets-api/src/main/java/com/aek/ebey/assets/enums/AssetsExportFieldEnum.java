package com.aek.ebey.assets.enums;

/**
 *  设备导出字段枚举类
 *	
 * @author HongHui
 * @date   2017年11月3日
 */
public enum AssetsExportFieldEnum {

	//必填字段-分类 1=设备信息，2=采购信息，3=合同信息
	FIELD1("i.assets_num", "设备编号",true,1),
	FIELD2("i.assets_name", "设备名称",true,1),
	FIELD3("e.factory_name", "生产商",true,1),
	//非必填
	FIELD4("i.assets_spec", "规格型号",false,1),
	FIELD5("i.three_level_code", "三级分类编码",false,1),
	FIELD6("i.unit_id", "单位",false,1),
	FIELD7("i.assets_type_id", "账簿类型 ",false,1),
	FIELD8("i.assets_class_id", "核算类别 ",false,1),
	FIELD9("i.made_in", "国产/进口",false,1),
	//FIELD10("i.apply_dept_id", "申购部门",false,2),
	FIELD11("i.dept_id", "所在部门",false,1),
	FIELD12("i.manage_dept_id", "管理部门",false,1),
	FIELD13("i.spl_name", "供应商",false,1),
	FIELD14("i.price2", "设备单价 ",false,1),
	FIELD15("i.price1", "设备原值",false,1),
	//FIELD16("i.fund_sources_id", "资金来源 ",false,2),
	//FIELD17("e.arrival_date", "到货日期 ",false,2),
	FIELD18("i.apply_type", "购置类别 ",false,1),
	FIELD19("i.apply_date", "申购日期 ",false,1),
	FIELD20("i.proof_date", "论证日期 ",false,1),
	FIELD21("i.expect_date", "预到日期 ",false,1),
	FIELD22("i.apply_reason", "申购理由 ",false,1),
	FIELD23("i.acceptance_person_name", "验收人员 ",false,1),
	FIELD24("i.acceptance_dept_name", "验收部门",false,1),

		
	FIELD25("e.factory_num", "出厂编号（SN）",false,1),
	FIELD26("e.serial_num", "院内编码",false,1),
	FIELD27("e.reg_no", "注册证号",false,1),
	FIELD28("e.assets_brand", "品牌",false,1),
	FIELD29("e.prod_place", "产地",false,1),
	FIELD30("e.reg_name", "注册证名称",false,1),
	FIELD31("e.manage_level", "管理级别",false,1),
	FIELD32("e.measure_type", "计量类别",false,1),
	FIELD33("e.start_use_date", "启用日期",false,1),
	FIELD34("e.warranty_date", "保修期至",false,1),
	FIELD35("e.purpose", "用途",false,1),
	FIELD36("e.purchase_type_id", "设备来源 ",false,1),
	//FIELD37("e.purchase_date", "购入日期 ",false,2),
	//FIELD38("e.purchase_way", "采购方式 ",false,2),
	//FIELD39("e.tender_form", "招标形式 ",false,2), 
	//FIELD40("e.single_budget", "单项预算",false,2),
	//FIELD41("e.win_tender_date", "中标日期 ",false,2),
	//FIELD42("e.approve_project_accord", "立项依据 ",false,2),
	
	
	
	FIELD43("zjnx", "折旧年限 ",false,1),
	//FIELD44("c.contract_no", "合同编号 ",false,3),
	//FIELD45("c.contract_name", "合同名称 ",false,3),
	//FIELD46("c.supplier_name", "乙方单位 ",false,1),
	//FIELD47("c.start_date", "签订日期",false,3),
	//FIELD48("c.contract_price", "合同金额 ",false,3),
	//FIELD49("c.archives_code", "档案编号 ",false,3),
	//FIELD50("invoice_no", "发票号",false,3),
	//FIELD51("c.end_date", "合同截止日期 ",false,3),
	//FIELD52("c.archives_manager", "档案管理员 ",false,3),
	//FIELD53("c.contract_content", "合同内容 ",false,3),
	//FIELD54("i.acceptance_date", "验收日期 ",false,2),
	
	
	FIELD55("e.polling_flag", "巡检设备",false,1),
	FIELD56("e.measure_flag", "计量设备",false,1),
	FIELD57("i.risk_level","风险程度分析",false,1);

	

//	FIELD17("i.free_tax", "免税设备",false,1),// 0否1是
//	FIELD18("i.commodity_flag", "商检设备",false,1),// 1启用0不启用
//	FIELD19("i.pm_flag", "PM标志",false,1),// 1启用0不启用
//	FIELD20("i.quality_flag", "质检设备",false,1),// 1启用0不启用
//	FIELD28("i.dep_type", "折旧方法",false,1),
//	FIELD41("i.create_time", "签订日期 ",false,1),
//	,
//	FIELD44("i.contract_contact_name", "乙方联系人 ",false,1),
//	FIELD45("i.contract_contact_phone", "联系电话 ",false,1),
//	FIELD47("c.archives_manager", "档案管理员 ",false,3),
//	FIELD48("c.contract_content", "合同内容 ",false,3);
	
	
	
	private String fieldName;  //字段名称
 	private String fieldDesc;  //字段描述
 	private Boolean selected;  //是否默认选中
 	private Integer index;     //分类 1=设备信息，2=采购信息，3=合同信息
	
	private AssetsExportFieldEnum(String fieldName, String fieldDesc, Boolean selected, Integer index) {
		this.fieldName = fieldName;
		this.fieldDesc = fieldDesc;
		this.selected = selected;
		this.index = index;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getFieldDesc() {
		return fieldDesc;
	}

	public void setFieldDesc(String fieldDesc) {
		this.fieldDesc = fieldDesc;
	}

	public Boolean getSelected() {
		return selected;
	}

	public void setSelected(Boolean selected) {
		this.selected = selected;
	}

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

}
