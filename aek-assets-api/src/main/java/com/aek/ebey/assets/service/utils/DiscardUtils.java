package com.aek.ebey.assets.service.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class DiscardUtils {

	/**
	 * 
	 * 得到报损编码
	 */
	public static String discardNo() {

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");

		Date date = new Date();

		String str = simpleDateFormat.format(date);

		Random random = new Random();

		int rannum = (int) (random.nextDouble() * (9999 - 1000 + 1)) + 1000;// 获取4位随机数

		return "BS" + str + rannum;

	}

	/**
	 * 
	 * 得到报损类型
	 */
	public static String getType(Integer type) {
		String ret = "";
		switch (type) {
		default:
			break;
		case 1:
			ret = "在用报损";
			break;
		case 2:
			ret = "在库报损";
			break;
		case 3:
			ret = "附件报损";
			break;
		}
		return ret;
	}
	
	/**
	 * 
	 * 得到报损审核状态
	 */
	public static String getStatus(Integer status) {
		String ret = "";
		switch (status) {
		default:
			break;
		case 1:
			ret = "待审核";
			break;
		case 2:
			ret = "审核通过";
			break;
		case 3:
			ret = "审核未通过";
			break;
		}
		return ret;
	}

	public static String getStatus2(Integer status) {
		String ret = "";
		switch (status) {
		default:
			break;
		case 1:
			ret = "在库";
			break;
		case 2:
			ret = "在用";
			break;
		case 3:
			ret = "预登";
			break;
		}
		return ret;
	}

}
