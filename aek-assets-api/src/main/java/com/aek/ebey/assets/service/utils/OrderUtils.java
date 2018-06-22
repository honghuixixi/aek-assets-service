package com.aek.ebey.assets.service.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * 订单工具类
 *
 */
public class OrderUtils {
	/**
	 * 
	 * 生成订单号
	 */
	public static String getOrderNum() {

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");

		Date date = new Date();

		String str = simpleDateFormat.format(date);

		Random random = new Random();

		int rannum = (int) (random.nextDouble() * (99999 - 10000 + 1)) + 10000;// 获取5位随机数

		return "YS" + str + rannum;

	}
	
}
