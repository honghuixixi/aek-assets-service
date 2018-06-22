package com.aek.ebey.assets.service.utils;

public class AssetsUtils {
	/**
	 * 
	 * @param code
	 * @param threecode
	 * @param time
	 * @param cw
	 * @param fund
	 * @param manger
	 * @param water
	 * @param flag
	 * @return得到30位流水号
	 */
	public static String getStringBysome(String code,Integer threecode, Integer time,Integer cw,Integer fund,Integer manger,Integer water,Integer flag){
		StringBuilder stringBuilder=new StringBuilder();
		if(code!=null&&threecode!=null&&time!=null&&cw!=null&&fund!=null&&manger!=null&&water!=null&&threecode!=flag){
			stringBuilder.append(String.format("%07d", Integer.parseInt(code))).append(String.format("%06d", threecode)).append(String.format("%06d", time)).append(String.format("%02d", cw)).append(String.format("%01d", fund)).append(String.format("%01d", manger)).append(String.format("%06d", water)).append(String.format("%01d", flag));
			 return stringBuilder.toString();
		}
		return null;
		
	}
	/*public static void main(String[] args) {
		
		System.out.println(getStringBysome("1",2,3,4,5,6,7,8));
	}*/
	/**
	 * 
	 * @param tenantCode 组织机构代码
	 * @param sn 序列号
	 * @param time 时间
	 * @return
	 */
	public static String getStringByTenantCodeAndSnAndTime(String tenantCode, String sn,String time) {
		StringBuilder stringBuilder=new StringBuilder();
		try {
			if (tenantCode != null && sn != null && time != null) {
				stringBuilder.append(String.format("%07d", Integer.parseInt(tenantCode))).append(time).append(String.format("%06d", Integer.parseInt(sn)));
				return stringBuilder.toString();
			} 
		} catch (Exception e) {
			return null;
		}
		return null;
	}

}
