package com.bbs.cookie.annotation;

/**
 * @author jie.xu 2014年11月23日 下午2:26:34
 */
public final class CookieMaxAge {
	/**
	 * 用于临时Cookie的MaxAge
	 */
	public static final int TEMP = -1;
	/**
	 * 用于永久Cookie的MaxAge
	 */
	public static final int FOREVER = Integer.MAX_VALUE;

	/**
	 * 用于删除Cookie
	 */
	public static final int OUT_OF_DATE = 0;
}
