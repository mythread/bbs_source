package com.bbs.cookie.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author jie.xu 2014年11月23日 下午2:53:35
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CookieNamePolicy {
	CookieDomain domain();

	int maxAge() default CookieMaxAge.FOREVER;

	/**
	 * 是否对 cookie 加密
	 * 
	 * @return
	 */
	boolean isEncrypt() default true;

	CookiePath path() default CookiePath.ROOT;

	/**
	 * 是否是单一的值，没有kev-value对的。注意，如果是，一定要设置为true
	 */
	boolean isSimpleValue() default false;
}
