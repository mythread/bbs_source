package com.bbs.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 用来防止form表单重复提交
 * 
 * @author jiejie 2014年8月29日 上午10:31:46
 */
@Target({ ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface TokenPolicy {

    boolean saveToken() default false;

    boolean removeToken() default false;

}
