package com.aek.ebey.assets.service.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatUtils {
	/**
	 * 
	 * @param date
	 * @return 得到年月
	 */
	public static String getDate(Date date){
		SimpleDateFormat format=new SimpleDateFormat("yyyyMM");
		return format.format(date);
		
		
	}
	/**
	 * 
	 * @param date
	 * @return 得到年月日
	 */
	public static String getDateTime(Date date){
		SimpleDateFormat format=new SimpleDateFormat("yyyyMMdd");
		return format.format(date);
		
		
	}	
	/**
	 * 
	 * @param date
	 * @return 得到年-月-日
	 */
	public static String getDateTime2(Long date){
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		return format.format(date);	
	}
	public static String getDateTime3(Long date){
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return format.format(date);	
	}
	
	public static Date getDateTime4(Long date) throws ParseException{
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		String s = format.format(date);
		return format.parse(s);	
	}
}
