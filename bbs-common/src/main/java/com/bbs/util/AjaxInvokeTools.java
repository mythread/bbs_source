package com.bbs.util;

import javax.servlet.http.HttpServletRequest;

/**
 * 判断请求是否是ajax
 * 
 * @author jie.xu 2014年11月30日 上午11:31:17
 */
public class AjaxInvokeTools {

	public static final String INVOKE_TYPE = "x-requested-with";

	public static final String AJAX_TYPE = "XMLHttpRequest";

	/**
	 * 是否是ajax调用
	 */
	public static boolean isAjax(HttpServletRequest request) {
		String invokeType = request.getHeader(INVOKE_TYPE);
		if (invokeType == null) {
			// 同步调用
			return false;
		}
		return invokeType.toLowerCase().equals(AJAX_TYPE.toLowerCase());
	}
}
