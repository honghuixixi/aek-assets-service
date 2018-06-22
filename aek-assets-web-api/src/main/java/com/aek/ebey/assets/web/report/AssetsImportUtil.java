package com.aek.ebey.assets.web.report;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

import com.aek.common.core.util.DateUtil;
import com.aek.ebey.assets.core.util.CommonUtils;
import com.aek.ebey.assets.core.util.SpringContextUtil;
import com.aek.ebey.assets.model.CodeInfo;
import com.aek.ebey.assets.service.CodeInfoService;

public class AssetsImportUtil {

	public static String setFieldValue(Field field, Object obj, Object val) throws Exception{
		field.setAccessible(true);
		ExcelColumn annotation = field.getDeclaredAnnotation(ExcelColumn.class);
		if(annotation!=null){
			String[] enums = annotation.enums();
			if(enums!=null&&enums.length>0){
				if(val!=null&&StringUtils.isNotBlank(val.toString())){
					Integer value=null;
					for (int i = 0; i < enums.length; i+=2) {
						if(enums[i].equals(val)){
							value = Integer.valueOf(enums[++i]);
							break;
						}
					}
					if(value==null){
						return annotation.title()+":只能选择给定的数据.";
					}
					val = value;
				}
			}
			String baseDataType = annotation.baseDataType();
			if(StringUtils.isNotBlank(baseDataType)){
				if(val!=null&&StringUtils.isNotBlank(val.toString())){
					field.set(obj, val);
					CodeInfoService bean = SpringContextUtil.getBean(CodeInfoService.class);
					List<CodeInfo> codeList = bean.getCodeList(baseDataType);
					Map<String, String> map = new HashMap<String, String>();
					codeList.stream().forEach(e->{
						map.put(e.getCodeText(), e.getCodeValue());
					});
					if(map.get(val)==null){
						return annotation.title()+":只能选择给定的数据.";
					}
					Integer value = Integer.valueOf(map.get(val));
					if(StringUtils.isNotBlank(annotation.relField())){
						Field relField = obj.getClass().getDeclaredField(annotation.relField());
						relField.setAccessible(true);
						relField.set(obj, value);
					}
				}
			}
			if(annotation.required()){
				if(val==null){
					return annotation.title()+":不能为空.";
				}else if(val instanceof String){
					if(StringUtils.isBlank(val.toString())){
						return annotation.title()+":不能为空.";
					}
				}
			}
			if(StringUtils.isNotBlank(annotation.regex()) && field.getType()==String.class){
				if(val!=null&&StringUtils.isNotBlank(val.toString())){
					Pattern pattern = Pattern.compile(annotation.regex());
					Matcher matcher = pattern.matcher(val.toString());
					boolean matches = matcher.matches();
					field.set(obj, val);
					if(!matches){
						return annotation.title()+":"+annotation.msg();
					}
				}
			}
			Type type = field.getGenericType();
			if(type==Date.class){
				if(val==null){
					return null;
				}else if(val instanceof String){
					if(StringUtils.isBlank(val.toString())){
						return null;
					}
				}
			}
			if(annotation.relFieldType()==Date.class&&StringUtils.isNotBlank(annotation.relField())){
				try {
					if(val instanceof Date){
						val=DateUtil.TH_DATE_FORMAT.get().format(val);
					}
					if(val!=null&&StringUtils.isNotBlank(val.toString())){
						field.set(obj, val);
						Field relField = obj.getClass().getDeclaredField(annotation.relField());
						relField.setAccessible(true);
						Date date=null;
						date = DateUtil.TH_DATE_FORMAT.get().parse(val.toString());
						relField.set(obj, date);
					}
				} catch (ParseException e) {
					return annotation.title()+":日期格式错误.";
				}
			}
			if(annotation.relFieldType()==Long.class&&StringUtils.isNotBlank(annotation.relField())){
				try {
					if(val instanceof Long && val!=null){
						field.set(obj, val.toString());
						if(((Long)val)<0){
							return annotation.title()+":不能小于零.";
						}
						Field relField = obj.getClass().getDeclaredField(annotation.relField());
						relField.setAccessible(true);
						relField.set(obj, Long.valueOf(CommonUtils.fromY2X(val.toString())));
					}else if(val instanceof String && StringUtils.isNotBlank(val.toString())){
						field.set(obj, val);
						if(Double.valueOf(val.toString())<0){
							return annotation.title()+":不能小于零.";
						}
						Field relField = obj.getClass().getDeclaredField(annotation.relField());
						relField.setAccessible(true);
						relField.set(obj, Long.valueOf(CommonUtils.fromY2X(val.toString())));
					}
				} catch (Exception e) {
					return annotation.title()+":格式错误.";
				}
			}
			if(annotation.maxLength()!=0 && val!=null && field.getType()==String.class){
				field.set(obj, val);
				String s = val.toString().trim();
				if(StringUtils.isNotBlank(s)&&s.length()>annotation.maxLength()){
					return annotation.title()+":不能多于"+annotation.maxLength()+"个字符.";
				}
			}
			field.set(obj, val);
		}
		return null;
	}
}
