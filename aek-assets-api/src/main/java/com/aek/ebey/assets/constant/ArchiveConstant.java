package com.aek.ebey.assets.constant;

import java.util.HashMap;
import java.util.Map;

public class ArchiveConstant {

	//购置类别:1=新增、2=添置、3=报废更新
	public final static Map<Integer, String> PURCHASE_TYPE_MAP = new HashMap<Integer, String>();
	static {
		PURCHASE_TYPE_MAP.put(1, "新增");
		PURCHASE_TYPE_MAP.put(2, "添置");
		PURCHASE_TYPE_MAP.put(3, "报废更新");
	}
	
	//采购方式:1=国际招标、2=政府采购、3=院内采购、4=分散采购、5=自行采购、6=其他
	public final static Map<Integer, String> PURCHASE_MODE_MAP = new HashMap<Integer, String>();
	static {
		PURCHASE_MODE_MAP.put(1, "国际招标");
		PURCHASE_MODE_MAP.put(2, "政府采购");
		PURCHASE_MODE_MAP.put(3, "院内采购");
		PURCHASE_MODE_MAP.put(4, "分散采购");
		PURCHASE_MODE_MAP.put(5, "自行采购");
		PURCHASE_MODE_MAP.put(6, "其他");
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
	
	//保管期限(1=永久，2=长期(16~50年)，3=短期(15年以下))
	public final static Map<Integer, String> LIMIT_STORAGE_TIME_MAP = new HashMap<Integer, String>();
	static {
		LIMIT_STORAGE_TIME_MAP.put(1, "永久");
		LIMIT_STORAGE_TIME_MAP.put(2, "长期(16~50年)");
		LIMIT_STORAGE_TIME_MAP.put(3, "短期(15年以下)");
	}
	
	//保密级别(1=公开级,2=内部级,3=秘密级,4=机密级,5=绝密级)
	public final static Map<Integer, String> SECRET_LEVEL_MAP = new HashMap<Integer, String>();
	static {
		SECRET_LEVEL_MAP.put(1, "公开级");
		SECRET_LEVEL_MAP.put(2, "内部级");
		SECRET_LEVEL_MAP.put(3, "秘密级");
		SECRET_LEVEL_MAP.put(4, "机密级");
		SECRET_LEVEL_MAP.put(5, "绝密级");
	}
	
	//资金来源类型(1=财政资金,2=自筹资金,3=捐赠,4=混合(财政资金+自筹资金）,5=其他)
	public final static Map<Integer, String> FUND_SOURCES_MAP = new HashMap<Integer, String>();
	static {
		FUND_SOURCES_MAP.put(1, "财政资金");
		FUND_SOURCES_MAP.put(2, "自筹资金");
		FUND_SOURCES_MAP.put(3, "捐赠");
		FUND_SOURCES_MAP.put(4, "混合");
		FUND_SOURCES_MAP.put(5, "其他");
	}
	
	//报损类型（1，在用报损 2，在库报损 3，附件报损）
	public final static Map<Integer, String> DISCARD_TYPE_MAP = new HashMap<Integer, String>();
	static {
		DISCARD_TYPE_MAP.put(1, "在用报损");
		DISCARD_TYPE_MAP.put(2, "在库报损");
		DISCARD_TYPE_MAP.put(3, "附件报损");
	}
}
