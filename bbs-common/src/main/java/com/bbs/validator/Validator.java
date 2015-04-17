package com.bbs.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 类Validator.java的实现描述：TODO 类实现描述
 * 
 * @author jie.xu 2014年11月24日 下午10:27:13
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Validator {

	FieldValidator[] fieldsValidate();

	/**
	 * 返回的view视图
	 */
	String view() default "";
}
