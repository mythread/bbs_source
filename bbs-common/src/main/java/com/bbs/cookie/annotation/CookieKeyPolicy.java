package com.bbs.cookie.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.bbs.cookie.CookieNameEnum;

/**
 * 类CookieKeyPolicy.java的实现描述：TODO 类实现描述
 * 
 * @author jie.xu 2014年11月23日 下午3:03:27
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CookieKeyPolicy {

	CookieNameEnum withinCooKieName();
}
