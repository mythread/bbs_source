package com.bbs.cookie.manager;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 获取CookieManager
 * 
 * @author jie.xu 2014年11月23日 下午6:52:26
 */
public class CookieManagerLocator {

	private static final String key = "_cookiemanager_";
	private static final Lock LOCK = new ReentrantLock();

	public static CookieManager get(HttpServletRequest request,
			HttpServletResponse response) {

		CookieManager cookieManager = (CookieManager) request.getAttribute(key);
		if (cookieManager != null) {
			return cookieManager;
		}
		try {
			LOCK.lock();
			if (cookieManager == null) {
				cookieManager = new DefaultCookieManager(request, response);
				request.setAttribute(key, cookieManager);
			}
			return cookieManager;
		} finally {
			LOCK.unlock();
		}
	}
}
