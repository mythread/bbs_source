package com.bbs.cookie.manager;

import com.bbs.cookie.CookieKeyEnum;
import com.bbs.cookie.CookieNameEnum;

/**
 * @author jie.xu 2014年11月23日 下午2:16:08
 */
public interface CookieManager {

	void set(CookieNameEnum cookieNameEnum, String value);

	String get(CookieNameEnum cookieNameEnum);

	void set(CookieKeyEnum cookieKeyEnum, String value);

	String get(CookieKeyEnum cookieKeyEnum);

	/**
	 * 将本次Cookie的修改保存的reponse中去
	 */
	void save();
}
