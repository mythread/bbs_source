package com.bbs.cookie;

import com.bbs.cookie.annotation.CookieKeyPolicy;

/**
 * 类CookieKeyEnum.java的实现描述：TODO 类实现描述
 * 
 * @author jie.xu 2014年11月23日 下午3:04:51
 */
public enum CookieKeyEnum {

	@CookieKeyPolicy(withinCooKieName = CookieNameEnum.bbs_cookie_forever)
	user_id("u_id"),

	@CookieKeyPolicy(withinCooKieName = CookieNameEnum.bbs_cookie_forever)
	user_nickname("u_name"),

	@CookieKeyPolicy(withinCooKieName = CookieNameEnum.bbs_cookie_forever)
	user_email("u_email"),

	@CookieKeyPolicy(withinCooKieName = CookieNameEnum.bbs_cookie_forever)
	user_avatar("u_avatar");

	private String key;

	private CookieKeyEnum(String cookieKey) {
		this.key = cookieKey;
	}

	public String getKey() {
		return key;
	}

	public static CookieKeyEnum getEnum(String key) {
		for (CookieKeyEnum cookieKey : values()) {
			if (cookieKey.getKey().equals(key)) {
				return cookieKey;
			}
		}
		return null;
	}

	public String toString() {
		return name();
	}

}
