package com.bbs.cookie;

import org.apache.commons.lang.StringUtils;

import com.bbs.cookie.annotation.CookieDomain;
import com.bbs.cookie.annotation.CookieNamePolicy;

/**
 * 类CookieNameEnum.java的实现描述：TODO 类实现描述
 * 
 * @author jie.xu 2014年11月23日 下午3:04:06
 */
public enum CookieNameEnum {
	@CookieNamePolicy(domain = CookieDomain.GBOTTLE_DOMAIN)
	bbs_cookie_forever("_bcf_");

	private String cookieName;

	private CookieNameEnum(String cookieName) {
		this.cookieName = cookieName;
	}

	public String getCookieName() {
		return cookieName;
	}

	public void setCookieName(String cookieName) {
		this.cookieName = cookieName;
	}

	public static CookieNameEnum getEnum(String name) {
		for (CookieNameEnum cookieNameEnum : values()) {
			if (StringUtils.equals(cookieNameEnum.getCookieName(), name)) {
				return cookieNameEnum;
			}
		}
		return null;
	}

}
