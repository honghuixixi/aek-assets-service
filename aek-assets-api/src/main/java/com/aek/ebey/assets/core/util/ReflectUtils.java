package com.aek.ebey.assets.core.util;


import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.aek.ebey.assets.constant.SysConstant;
import com.aek.ebey.assets.model.AssAssetsLogDetail;
import com.aek.ebey.assets.model.AssetsFundSources;
import com.aek.ebey.assets.model.AssetsInfo;
import com.aek.ebey.assets.service.utils.DateFormatUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * 反射 工具类
 *	
 * @author HongHui
 * @date   2017年12月14日
 */
@SuppressWarnings({"rawtypes","unchecked"})
public class ReflectUtils {
	
	/**
	 * 获取数据库实体类表名称
	 * @param clazz
	 * @return
	 */
	public static String getClazzTableName(Class clazz){
		//解析类上是否有注解
		boolean clazzAnno = clazz.isAnnotationPresent(TableName.class);
		if(clazzAnno){
			TableName tableNameClazz = (TableName) clazz.getAnnotation(TableName.class);
			String tableName = tableNameClazz.value();
			return tableName;
		}
		return null;
	}
	
	/**
	 * 获取数据库实体类属性名称与数据库字段名称
	 * @param clazz
	 * @return Map:key=数据库实体对象属性名称，value=数据库实体对象属性对应的数据库字段名称
	 */
	public static Map<String,String> getClazzFieldNameMap(Class clazz){
		Map<String,String> fieldNameMap = new HashMap<String,String>();
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			boolean fieldHasAnno = field.isAnnotationPresent(TableField.class);  
            if(fieldHasAnno){  
            	TableField fieldAnno = field.getAnnotation(TableField.class);
            	if(fieldAnno.exist()){
            		String dbFieldName = fieldAnno.value();
            		String fieldName = field.getName();
                    fieldNameMap.put(fieldName, dbFieldName);
            	}
            }  
		}
		return fieldNameMap;
	}
	
	/**
	 * 判断字段是否需要进行比较
	 * @param field
	 * @return
	 */
	public static boolean isNoComparedField(Field field){
		return field.isAnnotationPresent(NoComparedField.class);  
	}
	
	/**
	 * 比较两个对象同属性名不同的属性值
	 * 
	 * @param clazz1
	 * @param clazz2
	 * @return
	 */
	public static List<Map<String, String>> compareTwoClazz(Object oldClass1, Object newClass2) {
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		try{
			// 获取对象的class
			Class<?> clazz1 = oldClass1.getClass();
			Class<?> clazz2 = newClass2.getClass();
			// 获取对象的属性列表
			Field[] field1 = clazz1.getDeclaredFields();
			Field[] field2 = clazz2.getDeclaredFields();
			// 遍历属性列表field1
			for (int i = 0; i < field1.length; i++) {
				// 遍历属性列表field2
				for (int j = 0; j < field2.length; j++) {
					if(!field1[i].getType().isAssignableFrom(List.class) && !field2[j].getType().isAssignableFrom(List.class) &&
					   !field1[i].getType().isAssignableFrom(Map.class) && !field2[j].getType().isAssignableFrom(Map.class)   &&
					   !field1[i].getType().isAssignableFrom(Set.class) && !field2[j].getType().isAssignableFrom(Set.class)   &&
					   !field1[i].getType().isArray() && !field2[j].getType().isArray()){
						// 如果field1[i]属性名与field2[j]属性名内容相同
						if ( !isNoComparedField(field1[i]) && field1[i].getName().equals(field2[j].getName())) {
							if (field1[i].getName().equals(field2[j].getName())) {
								field1[i].setAccessible(true);
								field2[j].setAccessible(true);
								// 如果field1[i]属性值与field2[j]属性值内容不相同
								if (!compareTwo(field1[i].get(oldClass1), field2[j].get(newClass2))) {
									Map<String, String> map2 = new HashMap<String, String>();
									//属性名称
									map2.put("propertyName", field1[i].getName());
									//属性旧值
									if(field1[i].get(oldClass1) != null){
										map2.put("oldValue", field1[i].get(oldClass1).toString());
									}else {
										map2.put("oldValue", "无");
									}							
									//属性新值
									if(field2[j].get(newClass2) != null){
										map2.put("newValue", field2[j].get(newClass2).toString());
									}else {
										map2.put("newValue", "无");
									}								
									list.add(map2);
								}
								break;
							}
						}
					}
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 比较两个对象同属性名不同的属性值
	 * 
	 * @param clazz1
	 * @param clazz2
	 * @return
	 */
	public static List<AssAssetsLogDetail> compareTwoClazzToLogDetail(Object oldClass1, Object newClass2,Class clazz,Integer logType) {
		List<AssAssetsLogDetail> list = new ArrayList<AssAssetsLogDetail>();
		try{
			String tableName = ReflectUtils.getClazzTableName(clazz);
			Map<String,String> fieldNameMap = ReflectUtils.getClazzFieldNameMap(clazz);
			// 获取对象的class
			Class<?> clazz1 = oldClass1.getClass();
			Class<?> clazz2 = newClass2.getClass();
			// 获取对象的属性列表
			Field[] field1 = clazz1.getDeclaredFields();
			Field[] field2 = clazz2.getDeclaredFields();
			// 遍历属性列表field1
			for (int i = 0; i < field1.length; i++) {
				// 遍历属性列表field2
				for (int j = 0; j < field2.length; j++) {
					if(!field1[i].getType().isAssignableFrom(List.class) && !field2[j].getType().isAssignableFrom(List.class) &&
					   !field1[i].getType().isAssignableFrom(Map.class) && !field2[j].getType().isAssignableFrom(Map.class)   &&
					   !field1[i].getType().isAssignableFrom(Set.class) && !field2[j].getType().isAssignableFrom(Set.class)   &&
					   !field1[i].getType().isArray() && !field2[j].getType().isArray()){
						// 如果field1[i]属性名与field2[j]属性名内容相同
						if (field1[i].getName().equals(field2[j].getName())) {
							if (field1[i].getName().equals(field2[j].getName())) {
								field1[i].setAccessible(true);
								field2[j].setAccessible(true);
								// 如果field1[i]属性值与field2[j]属性值内容不相同							
								if (!isNoComparedField(field1[i]) && !compareTwo(field1[i].get(oldClass1), field2[j].get(newClass2))) {
									AssAssetsLogDetail assAssetsLogDetail = new AssAssetsLogDetail();
									//相关表名
									assAssetsLogDetail.setTableName(tableName);
									//数据库字段名称
									assAssetsLogDetail.setField(fieldNameMap.get(field1[i].getName()));
									//数据库字段中文名称
									assAssetsLogDetail.setFieldName(SysConstant.REPORT_DATA_MAP.get(assAssetsLogDetail.getField()));
									//Java对象属性名称
									assAssetsLogDetail.setPropertyName(field1[i].getName());
//									System.out.println(field2[j].getName()+"---老--"+field1[i].get(oldClass1));
//									System.out.println(field2[j].getName()+"-----"+field2[j].get(newClass2));
									//属性旧值
									if(field1[i].get(oldClass1) != null){
										if(field1[i].get(oldClass1) instanceof Date){
											Date date  = (Date)field1[i].get(oldClass1);
											assAssetsLogDetail.setOldValue(DateFormatUtils.getDateTime2(date.getTime()));
										}else {
											assAssetsLogDetail.setOldValue(field1[i].get(oldClass1).toString());	
										}															
									}						
									//属性新值
									if(field2[j].get(newClass2) != null){
										if(field2[j].get(newClass2) instanceof Date){
											Date date  = (Date)field2[j].get(newClass2);
											assAssetsLogDetail.setNewValue(DateFormatUtils.getDateTime2(date.getTime()));
										}else {
											assAssetsLogDetail.setNewValue(field2[j].get(newClass2).toString());	
										}									
									}
									//创建时间
									assAssetsLogDetail.setCreateTime(new Date());
									//类型(1=字段新增/修改，2=合同附件，3=招标附件，4=验收附件，5=证件管理)
									assAssetsLogDetail.setType(logType);
									list.add(assAssetsLogDetail);
								}
								break;
							}
						}
					}
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 比较两个对象是否相同
	 * 
	 * @param class1
	 * @param class2
	 * @return
	 */
	public static boolean compareTwo(Object class1, Object class2) {
		if (class1 == null && class2 == null) {
			return true;
		}
		if (class1 == null && class2 != null) {
			return false;
		}
		if (class1.equals(class2)) {
			return true;
		}
		return false;
	}
	
	
	public static void main(String[] args) {
		AssetsInfo assetsInfo1 = new AssetsInfo();
		assetsInfo1.setAssetsName("1");
		assetsInfo1.setAssetsNum("abc");
		List<AssetsFundSources> fundList1 = new ArrayList<AssetsFundSources>();
		AssetsFundSources assetsFundSources = new AssetsFundSources();
		assetsFundSources.setAssetsId(1l);
		fundList1.add(assetsFundSources);
		assetsInfo1.setFundList(fundList1);
		
		AssetsInfo assetsInfo2 = new AssetsInfo();
		List<AssetsFundSources> fundList2 = new ArrayList<AssetsFundSources>();
		AssetsFundSources assetsFundSources2 = new AssetsFundSources();
		assetsFundSources2.setAssetsId(2l);
		fundList2.add(assetsFundSources2);
		assetsInfo2.setAssetsName("2");
		assetsInfo2.setAssetsNum("abcdef");
		assetsInfo2.setFundList(fundList2);
		List<Map<String, String>> list = compareTwoClazz(assetsInfo1,assetsInfo2);
		for (Map<String, String> map : list) {
			System.out.println(map.toString());
		}
	}
}
