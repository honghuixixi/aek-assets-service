package com.aek.ebey.assets.core.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 不需要进行比较的字段标识
 *	
 * @author HongHui
 * @date   2017年12月27日
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface NoComparedField {
}
