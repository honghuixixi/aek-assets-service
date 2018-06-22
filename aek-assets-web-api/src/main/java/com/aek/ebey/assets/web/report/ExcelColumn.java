package com.aek.ebey.assets.web.report;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 定义Excel中的列
 */

@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ExcelColumn {

	int value();//index索引
	String title();//
	String comment() default "";//批注
	String[] enums() default {};
	String baseDataType() default "";//基础数据类型
	String relField() default "";//关联值字段
	Class<?> relFieldType() default void.class;//关联值字段类型
	boolean required() default false;
	String regex() default "";
	String format() default "";//写入excel时的格式enum:[money]
	int maxLength() default 0;
	String msg() default "";
}
