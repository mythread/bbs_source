package com.bbs.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 请求参数验证注解
 * 
 * @author jie.xu 2014年11月24日 下午9:46:03
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FieldValidator {

	/**
	 * 字段
	 * 
	 * @return
	 */
	String field() default "";

	/**
	 * 参数是否必须，若为true，参数值不能为null
	 */
	boolean required() default true;

	/**
	 * 字符串最大长度
	 */
	int maxLength() default 100;

	/**
	 * 提示信息
	 * 
	 * @return
	 */
	String message() default "";

}
