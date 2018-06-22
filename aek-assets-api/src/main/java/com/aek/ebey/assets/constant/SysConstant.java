package com.aek.ebey.assets.constant;

import java.util.HashMap;
import java.util.Map;

public class SysConstant {

	// 资产台账模块-导出
	public final static Map<String, String> REPORT_DATA_MAP = new HashMap<String, String>();
	static {
		REPORT_DATA_MAP.put("assets_num", "设备编号");
		REPORT_DATA_MAP.put("assets_name", "设备名称");
		REPORT_DATA_MAP.put("factory_name", "生产商");
		REPORT_DATA_MAP.put("assets_spec", "规格型号");
		REPORT_DATA_MAP.put("spl_name", "供应商");
		REPORT_DATA_MAP.put("reg_no", "注册证号");
		REPORT_DATA_MAP.put("factory_num", "出厂编号（SN）");
		REPORT_DATA_MAP.put("serial_num", "院内编码");
		REPORT_DATA_MAP.put("made_in", "国产/进口");
		REPORT_DATA_MAP.put("measure_flag", "计量设备");

		// REPORT_DATA_MAP.put("", "原平台资产编号");

		REPORT_DATA_MAP.put("assets_brand", "品牌");
		REPORT_DATA_MAP.put("prod_place", "产地");
		REPORT_DATA_MAP.put("unit_id", "单位");

		// REPORT_DATA_MAP.put("", "设备注册证名称");

		REPORT_DATA_MAP.put("manage_level", "管理级别");
		REPORT_DATA_MAP.put("measure_type", "计量类别");
		REPORT_DATA_MAP.put("three_level_code", "三级分类编码");
		REPORT_DATA_MAP.put("reg_name", "注册证名称");
		REPORT_DATA_MAP.put("free_tax", "免税设备");// 0否1是
		REPORT_DATA_MAP.put("commodity_flag", "商检设备");// 1启用0不启用
		REPORT_DATA_MAP.put("pm_flag", "PM标志");// 1启用0不启用
		REPORT_DATA_MAP.put("quality_flag", "质检设备");// 1启用0不启用
		REPORT_DATA_MAP.put("apply_dept_id", "申购部门");
		REPORT_DATA_MAP.put("dept_id", "所在部门");
		REPORT_DATA_MAP.put("manage_dept_id", "管理部门");
		REPORT_DATA_MAP.put("start_use_date", "启用日期");
		REPORT_DATA_MAP.put("start_date", "签订日期");
		REPORT_DATA_MAP.put("purpose", "用途");
		REPORT_DATA_MAP.put("warranty_date", "保修期至");
		REPORT_DATA_MAP.put("dep_type", "折旧方法");
		REPORT_DATA_MAP.put("purchase_type_id", "设备来源 ");
		//REPORT_DATA_MAP.put("purchase_date", "购入日期 ");
		REPORT_DATA_MAP.put("price1", "设备原值");
		REPORT_DATA_MAP.put("price2", "设备单价 ");
		REPORT_DATA_MAP.put("price", "设备单价 ");
		REPORT_DATA_MAP.put("zjnx", "折旧年限 ");
		REPORT_DATA_MAP.put("fund_sources_id", "资金来源 ");
		REPORT_DATA_MAP.put("assets_type_id", "账簿类型 ");
		REPORT_DATA_MAP.put("assets_class_id", "核算类别 ");

		// REPORT_DATA_MAP.put("", "财政资金额度");
		// REPORT_DATA_MAP.put("", "自筹资金额度");
		// REPORT_DATA_MAP.put("", "捐赠资金额度");
		// REPORT_DATA_MAP.put("", "其他资金额度");

		REPORT_DATA_MAP.put("arrival_date", "到货日期 ");
		REPORT_DATA_MAP.put("contract_no", "合同编号 ");
		REPORT_DATA_MAP.put("contract_name", "合同名称 ");
		REPORT_DATA_MAP.put("supplier_name", "乙方单位 ");
		REPORT_DATA_MAP.put("create_time", "签订日期 ");
		REPORT_DATA_MAP.put("contract_price", "合同金额 ");
		REPORT_DATA_MAP.put("end_date", "合同截止日期 ");
		REPORT_DATA_MAP.put("contract_contact_name", "乙方联系人 ");
		REPORT_DATA_MAP.put("contract_contact_phone", "乙方联系电话 ");
		REPORT_DATA_MAP.put("archives_code", "档案编号 ");
		REPORT_DATA_MAP.put("archives_manager", "档案管理员 ");
		REPORT_DATA_MAP.put("contract_content", "合同内容 ");
		REPORT_DATA_MAP.put("invoice_no", "发票号");
		
		
		//2017/11/21
		REPORT_DATA_MAP.put("apply_type", "购置类别 ");
		REPORT_DATA_MAP.put("apply_date", "申购日期 ");
		REPORT_DATA_MAP.put("proof_date", "论证日期 ");
		REPORT_DATA_MAP.put("expect_date", "预到日期 ");
		REPORT_DATA_MAP.put("apply_reason", "申购理由 ");
		REPORT_DATA_MAP.put("acceptance_person_name", "验收人员");
		REPORT_DATA_MAP.put("acceptance_dept_name", "验收部门 ");
		REPORT_DATA_MAP.put("acceptance_date", "验收日期");
		REPORT_DATA_MAP.put("purchase_way", "采购方式 ");
		REPORT_DATA_MAP.put("purchase_date", "购入日期 ");
		REPORT_DATA_MAP.put("tender_form", "招标形式 ");
		REPORT_DATA_MAP.put("single_budget", "单项预算 ");
		REPORT_DATA_MAP.put("win_tender_date", "中标日期 ");
		REPORT_DATA_MAP.put("approve_project_accord", "立项依据 ");
		REPORT_DATA_MAP.put("polling_flag", "巡检设备 ");
		
		//证件信息(用于日志记录)2018.1.5
		REPORT_DATA_MAP.put("certificate_num", "编号");
		REPORT_DATA_MAP.put("certificate_register_num", "注册号");
		REPORT_DATA_MAP.put("image_url", "图片");
		REPORT_DATA_MAP.put("name", "证件名称");
		REPORT_DATA_MAP.put("product_date", "生产日期");
		REPORT_DATA_MAP.put("valid_date", "有效期至");
		REPORT_DATA_MAP.put("valid_date_str", "有效期");
		
		//2018.1.19
		REPORT_DATA_MAP.put("status", "设备状态");
		REPORT_DATA_MAP.put("assets_source", "设备来源");
		REPORT_DATA_MAP.put("polling_flag", "巡检设备");

		REPORT_DATA_MAP.put("risk_level","风险程度分析");
	}
	
	//巡检标识1是0否(常量)
	public final static int POLLING_FLAG_0 = 0;//否
	public final static int POLLING_FLAG_1 = 1;//是

	// 设备状态名称
	public final static Map<Integer, String> STATUS_NAME_MAP = new HashMap<Integer, String>();
	static {//状态：1在库、2在用、3计量中、4维修中、5停用中、6已报废、7已报损 原来状态
			//状态：1=在库、2=在用、3=预登、4=待报损、5=报损、6=退货
		STATUS_NAME_MAP.put(1, "在库");
		STATUS_NAME_MAP.put(2, "在用");
		STATUS_NAME_MAP.put(3, "预登");
		STATUS_NAME_MAP.put(4, "待报损");
		STATUS_NAME_MAP.put(5, "报损");
		STATUS_NAME_MAP.put(6, "退货");
		STATUS_NAME_MAP.put(0, "全部状态");
	}	
	//设备状态名称
	public final static int STATUS_NAME_1 = 1;//在库
	public final static int STATUS_NAME_2 = 2;//在用
	public final static int STATUS_NAME_3 = 3;//预登
	public final static int STATUS_NAME_4 = 4;//待报损
	public final static int STATUS_NAME_5 = 5;//报损
	public final static int STATUS_NAME_6 = 6;//退货
	public final static int STATUS_NAME_0 = 0;//全部状态
	
	// 购置类别
	public final static Map<Integer, String> APPLY_TYPE_MAP = new HashMap<Integer, String>();
	static {//购置类别:1=新增、2=添置、3=报废更新
		APPLY_TYPE_MAP.put(1, "新增");
		APPLY_TYPE_MAP.put(2, "添置");
		APPLY_TYPE_MAP.put(3, "报废更新");
	}
	
	//是否国产
	public final static Map<Integer, String> MADE_IN_MAP = new HashMap<Integer, String>();
	static {//是否国产（1，国产 2，进口）
		MADE_IN_MAP.put(1, "国产");
		MADE_IN_MAP.put(2, "进口");
	}
	
	//采购方式:1=国际招标、2=政府采购、3=院内采购、4=分散采购、5=自行采购、6=其他
	public final static Map<Integer, String> PURCHASE_WAY_MAP = new HashMap<Integer, String>();
	static {
		PURCHASE_WAY_MAP.put(1, "国际招标");
		PURCHASE_WAY_MAP.put(2, "政府采购");
		PURCHASE_WAY_MAP.put(3, "院内采购");
		PURCHASE_WAY_MAP.put(4, "分散采购");
		PURCHASE_WAY_MAP.put(5, "自行采购");
		PURCHASE_WAY_MAP.put(6, "其他");
	}
	
	//招标形式:1=公开招标、2=邀请招标、3=竞争性谈判、4=单一来源采购、5=询价采购、6=其他
	public final static Map<Integer, String> TENDER_FORM_MAP = new HashMap<Integer, String>();
	static {
		TENDER_FORM_MAP.put(1, "公开招标");
		TENDER_FORM_MAP.put(2, "邀请招标");
		TENDER_FORM_MAP.put(3, "竞争性谈判");
		TENDER_FORM_MAP.put(4, "单一来源采购");
		TENDER_FORM_MAP.put(5, "询价采购");
		TENDER_FORM_MAP.put(6, "其他");
	}
		
	//巡检标识1是0否
	public final static Map<Integer, String> POLLING_FLAG_MAP = new HashMap<Integer, String>();
	static {
		POLLING_FLAG_MAP.put(0, "否");
		POLLING_FLAG_MAP.put(1, "是");
	}
	
	// 设备维修状态名称
	public final static Map<Integer, String> REPAIR_STATUS_NAME_MAP = new HashMap<Integer, String>();
	static {
		//维修状态：1=正常，2=维修中
		REPAIR_STATUS_NAME_MAP.put(1, "正常");
		REPAIR_STATUS_NAME_MAP.put(2, "维修中");
		REPAIR_STATUS_NAME_MAP.put(0, "全部状态");
	}
		
		
	public static enum AssetsSource{
		PUT_IN(0, "入库新增"),BATCH_IMPORT(1, "批量导入"),ACCEPTANCE_IN(2,"验收录入"),CHECK_In(3,"清查录入");
		//PUT_IN(0, "入库新增"),BATCH_IMPORT(1, "批量导入"),ACCEPTANCE_IN(2,"新建");
		private int val;
		private String text;
		AssetsSource(int val, String text){
			this.val = val;
			this.text = text;
		}

		public static String getText(Integer val) {
			String text = null;
			if(val!=null) {
				for (AssetsSource v : values()) {
					if (val.intValue() == v.val) {
						text = v.text;
						break;
					}
				} 
			}
			return text;
		}

		public int getVal() {
			return val;
		}

		public void setVal(int val) {
			this.val = val;
		}

		public String getText() {
			return text;
		}

		public void setText(String text) {
			this.text = text;
		}
	}

	public final static Map<Integer, String> VERFY_STATUS_MAP = new HashMap<Integer, String>();
	static {// 审核状态
		VERFY_STATUS_MAP.put(0, "暂存");
		VERFY_STATUS_MAP.put(1, "待验收");
		VERFY_STATUS_MAP.put(2, "验收已通过");
		VERFY_STATUS_MAP.put(3, "验收未通过");
	}
	
	//设备转科状态map
	public final static Map<Integer, String> TRANSFER_STATUS_MAP = new HashMap<Integer, String>();
	static {
		TRANSFER_STATUS_MAP.put(1, "申请中");
		TRANSFER_STATUS_MAP.put(2, "未申请");
	}
	//设备转科状态
	public final static int TRANSFER_STATUS_1 = 1;// 申请中
	public final static int TRANSFER_STATUS_2 = 2;// 未申请
	
	//设备转科单状态map
	public final static Map<Integer, String> TRANSFER_DOC_STATUS_MAP = new HashMap<Integer, String>();
	static {
		TRANSFER_DOC_STATUS_MAP.put(1, "审核通过");
		TRANSFER_DOC_STATUS_MAP.put(2, "待审核");	
		TRANSFER_DOC_STATUS_MAP.put(3, "审核未通过");
	}
	
	//设备转科单状态
	public final static int TRANSFER_DOC_STATUS_0 = 0;// 全部(此状态仅用于转科单列表查询)
	public final static int TRANSFER_DOC_STATUS_1 = 1;// 审核通过
	public final static int TRANSFER_DOC_STATUS_2 = 2;// 待审核
	public final static int TRANSFER_DOC_STATUS_3 = 3;// 审核未通过
	
	//设备转科单状态map
	public final static Map<Integer, String> TRANSFER_DOC_ASSET_STATUS_MAP = new HashMap<Integer, String>();
	static {
		TRANSFER_DOC_ASSET_STATUS_MAP.put(1, "撤销转科");
		TRANSFER_DOC_ASSET_STATUS_MAP.put(2, "已撤销");
	}
	
	//设备转科单内设备状态
	public final static int TRANSFER_DOC_ASSET_STATUS_1 = 1;// 未撤销
	public final static int TRANSFER_DOC_ASSET_STATUS_2 = 2;// 已撤销

	// 预台账审核状态
	public final static int VERFY_STATUS_0 = 0;// 暂存

	public final static int VERFY_STATUS_1 = 1;// 未审核

	public final static int VERFY_STATUS_2 = 2;// 通过

	public final static int VERFY_STATUS_3 = 3;// 不通过
	
	
	
	// 预台账审操作状态
	public final static int OPERATE_1 = 1;//创建预台帐

	public final static int OPERATE_2 = 2;//提交预台帐

	public final static int OPERATE_3 = 3;//验收不通过

	public final static int OPERATE_4 = 4;//验收通过

	public static final String ACCOUNT_CATEGORY = "ACCOUNT_CATEGORY";//核算类别
	public static final String ACCOUNT_BOOK = "ACCOUNT_BOOK";//账簿类型
	public static final String UNIT = "UNIT";//单位
	public static final String FUND_SOURCES = "FUND_SOURCES";//经费来源
	public static final String MANAGE_LEVEL = "MANAGE_LEVEL";//管理级别
	public static final String MEASURE_TYPE = "MEASURE_TYPE";//计量类别
	public static final String DEP_TYPE = "DEP_TYPE";//折旧方法
	public static final String PURCHASE_TYPE = "PURCHASE_TYPE";//设备来源
	public static final String PURPOSE = "PURPOSE";//用途
	//2017/11/21
	public static final String APPLY_TYPE = "APPLY_TYPE";//购置类别
	public static final String PURCHASE_WAY = "PURCHASE_WAY";//采购方式
	public static final String TENDER_FORM   = "TENDER_FORM";//招标形式
	

	/**
	 * 缓存中的key
	 */
	public static class CacheKey {
		public static final String ASSETS_IMPORT_PREFIX = "Assets:Import:";
	}
}
