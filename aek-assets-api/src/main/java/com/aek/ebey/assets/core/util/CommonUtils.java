package com.aek.ebey.assets.core.util;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import com.aek.ebey.assets.model.AssAssetsCertificate;
import com.aek.ebey.assets.model.AssAssetsLogDetail;
import com.aek.ebey.assets.model.AssAssetsTransfer;
import com.aek.ebey.assets.model.AssetsFundSources;
import com.aek.ebey.assets.model.bo.AttachmentsBO;
import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;

/** 
* 
*/
public class CommonUtils {
	
    //小数点位数
    private static final int digital = 2;

    /**
     * 分转换为元,并格式化输出
     */
    public static String fromX2Y(Long f){
    	NumberFormat format = NumberFormat.getCurrencyInstance(Locale.CHINA);
        if (f == null) {
            return null;
        }
        BigDecimal b = new BigDecimal(f);
    	BigDecimal c = new BigDecimal(Math.pow(10, digital));
    	b=b.divide(c).setScale(2);
        return format.format(b.doubleValue());
    }
    
    /**
     * 分转换为元
     */
    public static Double fromX2YD(Long f){
        if (f == null) {
            return null;
        }
        BigDecimal b = new BigDecimal(f);
    	BigDecimal c = new BigDecimal(Math.pow(10, digital));
    	Double d = b.divide(c).doubleValue();
        return d;
    }
      
    /**
     * 元转换为分
     */
    public static Long fromY2X(Double y) {
        if (y == null) {
            return null;
        }
        return fromY2X(String.valueOf(y));
    }

    /**
     * 元转换为分
     */
    public static Long fromY2X(String y) {
        if (StringUtils.isBlank(y)) {
            return null;
        }
        BigDecimal d1 = new BigDecimal(y);
        BigDecimal d2 = d1.multiply(new BigDecimal(Math.pow(10, digital)));
        return d2.longValue();
    }
    
    /**
     * 保留到分
     */
    public static Double setScale2X(Double y) {
        if (y == null) {
            return null;
        }
        BigDecimal b = new BigDecimal(y);
        Double d = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        return d;
    }
    
    /**
     * 格式化输出￥
     */
    public static String format(Double y) {
        NumberFormat format = NumberFormat.getCurrencyInstance(Locale.CHINA);
        if (y == null) {
            return null;
        }
        return format.format(y);
    }
      
    public static void main(String[] args) {
    	String test = format(55.3653543543543d);
		System.out.println(test);
	}
    
    /**
     * Map转对象
     * @param map
     * @param beanClass
     * @return
     * @throws Exception
     */
    public static Object mapToObject(Map<String, String> map, Class<?> beanClass){
    	try{
	        if (map == null)  
	            return null;    
	        Object obj = beanClass.newInstance();  
	        Field[] fields = obj.getClass().getDeclaredFields();   
	        for (Field field : fields) {    
	            int mod = field.getModifiers();    
	            if(Modifier.isStatic(mod) || Modifier.isFinal(mod)){    
	                continue;    
	            }    
	            field.setAccessible(true);    
	            field.set(obj, map.get(field.getName()));   
	        }
	        return obj;    
    	}catch(Exception e){
    		e.printStackTrace();
    	}
        return null;
    } 
    
    /**
     * Map转对象
     * @param map
     * @param beanClass
     * @return
     * @throws Exception
     */
    public static List<Object> mapToObject(List<Map<String, String>> maps, Class<?> beanClass){
    	try{
    		List<Object> list = new ArrayList<Object>();
	        if (maps == null)  
	            return null; 
	        Object obj = null;
	        for (Map<String, String> map : maps) {
	        	obj = beanClass.newInstance();
		        Field[] fields = obj.getClass().getDeclaredFields();   
		        for (Field field : fields) {    
		            int mod = field.getModifiers();    
		            if(Modifier.isStatic(mod) || Modifier.isFinal(mod)){    
		                continue;    
		            }    
		            field.setAccessible(true);    
		            field.set(obj, map.get(field.getName()));   
		        }
		        
			}
	        list.add(obj);
	        return list;    
    	}catch(Exception e){
    		e.printStackTrace();
    	}
        return null;
    }
    
    /*****************************集合合并、新增、减少通用方法***************************************/
    /**
     * 合并两个list
     * @param list1
     * @param list2
     * @return
     */
    public static <T> List<T> mergeListSup(List<T> list1,List<T> list2){
    	System.out.println(JSON.toJSONString(list1));
    	System.out.println(JSON.toJSONString(list2));
    	Set<T> set = new HashSet<T>();
    	set.addAll(list1);
    	set.addAll(list2);
    	List<T> list = new ArrayList<T>();
    	list.addAll(set);
    	return list;
    }
    
    /**
     * 比较list2比list1新增的元素
     * @param list1
     * @param list2
     * @return
     */
    public static <T> List<T> addNewsSup(List<T> list1,List<T> list2){
    	List<T> totalList = mergeListSup(list1, list2);
    	List<T> list3 = new ArrayList<T>();
    	list3.addAll(totalList);
    	list3.removeAll(list1);
    	return list3;
    }   
    /**
     * 比较list2比list1减少的元素
     * @param list1
     * @param list2
     * @return
     */
    public static <T> List<T> reduceSup(List<T> list1,List<T> list2){
    	List<T> totalList = mergeListSup(list1, list2);
    	List<T> list3 = new ArrayList<T>();
    	list3.addAll(totalList);
    	list3.removeAll(list2);
    	return list3;
    }  
    /**
     * 比较list2比list1新增或减少哪些元素
     * @param list1
     * @param list2
     * @return
     */
    public static <T> Map<String,List<T>> compareSup(List<T> list1,List<T> list2){
    	Map<String,List<T>> map = new HashMap<String,List<T>>();
    	List<T> totalList = mergeListSup(list1, list2);
    	List<T> list3 = new ArrayList<T>();
    	list3.addAll(totalList);
    	list3.removeAll(list1);
    	map.put("add",list3);
    	List<T> list4 = new ArrayList<T>();
    	list4.addAll(totalList);
    	list4.removeAll(list2);
    	map.put("reduce",list4);
    	return map;
    } 
        
//    public static void main(String[] args) throws Throwable {
//    	List<AssAssetsCertificate> list1 = Lists.newArrayList();
//    	List<AssAssetsCertificate> list2 = Lists.newArrayList();
//		AssAssetsCertificate demo1 = new AssAssetsCertificate();
//		AssAssetsCertificate demo2 = new AssAssetsCertificate();
//		Date now = new Date();
//		//Thread.sleep(2000);
//		demo1.setValidDate(now);
//		demo2.setValidDate(now);
//		demo1.setName("测试1");
//		demo2.setName("测试1");
//		list1.add(demo1);
//		list2.add(demo2);
//		Map<String, List<AssAssetsCertificate>> compareSup = compareSup(list1,list2);
//		List<AssAssetsCertificate> lista = compareSup.get("add");
//		List<AssAssetsCertificate> listb = compareSup.get("reduce");
//		System.out.println(compareSup.get("add"));
//		System.out.println(compareSup.get("reduce"));
//		System.out.println("==================================");
//		
//		
//		
//	}
    
    
    
    /***********************************end*********************************/
    
    
    /**
     * 合并两个list
     * @param list1
     * @param list2
     * @return
     */
    public static List<AttachmentsBO> mergeList(List<AttachmentsBO> list1,List<AttachmentsBO> list2){
    	Set<AttachmentsBO> set = new HashSet<AttachmentsBO>();
    	set.addAll(list1);
    	set.addAll(list2);
    	List<AttachmentsBO> list = new ArrayList<AttachmentsBO>();
    	list.addAll(set);
    	return list;
    }
    
    /**
     * 比较list2比list1新增的元素
     * @param list1
     * @param list2
     * @return
     */
    public static List<AttachmentsBO> addNews(List<AttachmentsBO> list1,List<AttachmentsBO> list2){
    	List<AttachmentsBO> totalList = mergeList(list1, list2);
    	List<AttachmentsBO> list3 = new ArrayList<AttachmentsBO>();
    	list3.addAll(totalList);
    	list3.removeAll(list1);
    	return list3;
    }
    
    /**
     * 比较list2比list1减少的元素
     * @param list1
     * @param list2
     * @return
     */
    public static List<AttachmentsBO> reduce(List<AttachmentsBO> list1,List<AttachmentsBO> list2){
    	List<AttachmentsBO> totalList = mergeList(list1, list2);
    	List<AttachmentsBO> list3 = new ArrayList<AttachmentsBO>();
    	list3.addAll(totalList);
    	list3.removeAll(list2);
    	return list3;
    }
       
    /**
     * 比较list2比list1新增或减少哪些元素
     * @param list1
     * @param list2
     * @return
     */
    public static Map<String,List<AttachmentsBO>> compareTwoList(List<AttachmentsBO> list1,List<AttachmentsBO> list2){
    	Map<String,List<AttachmentsBO>> map = new HashMap<String,List<AttachmentsBO>>();
    	List<AttachmentsBO> totalList = mergeList(list1, list2);
    	List<AttachmentsBO> list3 = new ArrayList<AttachmentsBO>();
    	list3.addAll(totalList);
    	list3.removeAll(list1);
    	map.put("add",list3);
    	List<AttachmentsBO> list4 = new ArrayList<AttachmentsBO>();
    	list4.addAll(totalList);
    	list4.removeAll(list2);
    	map.put("reduce",list4);
    	return map;
    }
    
    /**
     * 比较list2比list1新增或减少哪些元素,返回修改日志对象集合
     * @param list1
     * @param list2
     * @return
     */
    public static List<AssAssetsLogDetail> compareTwoListToLogDetail(List<AttachmentsBO> list1,List<AttachmentsBO> list2,Integer type,String typeDesc){
    	List<AssAssetsLogDetail> logDetailList = new ArrayList<AssAssetsLogDetail>();
    	List<AttachmentsBO> totalList = mergeList(list1, list2);
    	List<AttachmentsBO> list3 = new ArrayList<AttachmentsBO>();
    	list3.addAll(totalList);
    	list3.removeAll(list1);
    	for (AttachmentsBO attachmentsBO : list3) {
    		AssAssetsLogDetail logDetail = new AssAssetsLogDetail();
			logDetail.setType(type);
			logDetail.setFieldName(typeDesc);
			logDetail.setCreateTime(new Date());
			logDetail.setNewValue(attachmentsBO.getFileName());
			logDetail.setRemark("上传了"+attachmentsBO.getFileName());
			logDetailList.add(logDetail);
		}
    	List<AttachmentsBO> list4 = new ArrayList<AttachmentsBO>();
    	list4.addAll(totalList);
    	list4.removeAll(list2);
    	for (AttachmentsBO attachmentsBO : list4) {
    		AssAssetsLogDetail logDetail = new AssAssetsLogDetail();
			logDetail.setType(type);
			logDetail.setFieldName(typeDesc);
			logDetail.setCreateTime(new Date());
			logDetail.setOldValue(attachmentsBO.getFileName());
			logDetail.setRemark("删除了"+attachmentsBO.getFileName());
			logDetailList.add(logDetail);
		}
    	return logDetailList;
    }
    
    public static void main1(String[] args) {
    	List<AttachmentsBO> list1 = new ArrayList<AttachmentsBO>();
    	AttachmentsBO a1 = new AttachmentsBO();
    	a1.setFileName("1.jpg");
    	a1.setUploadUrl("/2017/12/14/1.jpg");
    	AttachmentsBO a2 = new AttachmentsBO();
    	a2.setFileName("2.jpg");
    	a2.setUploadUrl("/2017/12/14/2.jpg");
    	list1.add(a2);
    	list1.add(a1);
    	
    	List<AttachmentsBO> list2 = new ArrayList<AttachmentsBO>();
    	AttachmentsBO a11 = new AttachmentsBO();
    	a11.setFileName("1.jpg");
    	a11.setUploadUrl("/2017/12/14/1.jpg");
    	AttachmentsBO a22 = new AttachmentsBO();
    	a22.setFileName("2.jpg");
    	a22.setUploadUrl("/2017/12/14/3.jpg");
    	list2.add(a22);
    	list2.add(a11);
    	
    	List<AttachmentsBO> addNews = addNews(list1,list2);
    	System.out.println("新增数据：");
    	for (AttachmentsBO attachmentsBO : addNews) {
    		System.out.println(attachmentsBO.toString());
		}
    	
    	List<AttachmentsBO> reduce = reduce(list1,list2);
    	System.out.println("减少数据：");
    	for (AttachmentsBO attachmentsBO : reduce) {
    		System.out.println(attachmentsBO.toString());
		}
    	System.out.println("===============");
    	List<AttachmentsBO> list = mergeList(list1, list2);
    	for (AttachmentsBO attachmentsBO : list) {
    		System.out.println(attachmentsBO.toString());
		}
    	List<AttachmentsBO> list3 = new ArrayList<AttachmentsBO>();
    	list3.addAll(list);
    	System.out.println("===============");
    	list3.removeAll(list1);
    	for (AttachmentsBO attachmentsBO : list3) {
    		System.out.println(attachmentsBO.toString());
		}
    	System.out.println("===============");
    	List<AttachmentsBO> list4 = new ArrayList<AttachmentsBO>();
    	list4.addAll(list);
    	list4.removeAll(list2);
    	for (AttachmentsBO attachmentsBO : list4) {
    		System.out.println(attachmentsBO.toString());
		}
	}
}
