package com.aek.ebey.assets.core.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class ArchiveUtil {

	public static String ArchiveNo() {
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");

		Date date = new Date();

		String str = simpleDateFormat.format(date);

		Random random = new Random();

		int rannum = (int) (random.nextDouble() * (9999 - 1000 + 1)) + 1000;// 获取4位随机数

		return "DA" + str + rannum;
		
	}
	
	public static String ArchiveDateUtil(Date date){
		if(date==null)return null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String format = sdf.format(date);
		return format;
	}
	
	public static void main(String[] args) {
		String archiveNo = ArchiveUtil.ArchiveDateUtil(null);
		System.out.println(archiveNo);
	}
}
