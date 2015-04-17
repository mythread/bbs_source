package com.bbs.cookie.annotation;

import org.apache.commons.lang.StringUtils;

/**
 * @author jie.xu 2014年11月23日 下午2:50:21
 */
public enum CookiePath {
	ROOT("/");

	private String path;

	private CookiePath(String path) {
		this.path = path;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public static CookiePath getEnum(String path) {
		for (CookiePath cp : values()) {
			if (StringUtils.equals(path, cp.getPath())) {
				return cp;
			}
		}
		return null;
	}
}
