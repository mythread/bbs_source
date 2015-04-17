package com.bbs.cookie.parser;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bbs.cookie.CookieKeyEnum;
import com.bbs.cookie.CookieNameEnum;

/**
 * 类CookieParser.java的实现描述：TODO 类实现描述
 * 
 * @author jie.xu 2014年11月23日 下午8:53:47
 */
public class CookieParser {
	protected static final Logger logger = LoggerFactory
			.getLogger(CookieParser.class);

	/**
	 * <pre>
	 * 解析本次quest中的Cookie。将Cookie中的值转换为一个{@link CookieNameEnum}为Key,{@link CookieNameHelper}为Value的Map。
	 * 而{@link CookieNameHelper}中则保存了该{@link CookieNameEnum}下所有{@link CookieKeyEnum}的值。
	 * @return 如果Request Cookie中，该方法回返回emptyMap。
	 * </pre>
	 */
	public static Map<CookieNameEnum, CookieNameHelper> loadCookie(
			HttpServletRequest request) {
		// 结果Map
		Map<CookieNameEnum, CookieNameHelper> allValues = new HashMap<CookieNameEnum, CookieNameHelper>();
		// 所有Cookie的值
		Map<String, String> cookieKV = CookieUtils.arrayToMap(request
				.getCookies());
		// 取到所有的CookieName进行遍历
		for (CookieNameEnum cookieName : CookieNameEnum.values()) {
			// 取得CookieName的配置信息
			CookieNameConfig cookieNameConfig = CookieNamePolicyParser
					.getCookieNamePolicyMap().get(cookieName);
			boolean isCookieExisted = cookieKV.containsKey(cookieNameConfig
					.getCookieName());
			if (isCookieExisted) {
				String value = cookieKV.get(cookieName.getCookieName());
				CookieNameHelper cookieNameHelper = paserCookieValue(
						cookieNameConfig, value);
				// 如果值存在则保存
				if (cookieNameHelper != null) {
					allValues.put(cookieName, cookieNameHelper);
				}
			}

		}
		return allValues;
	}

	/**
	 * 通过一个CookieName的配置来解析一个Cookievalue. 对于那些不是该CookieName的CookieKey直接忽略掉
	 * 
	 * @return 如果解析失败则返回null
	 */
	static CookieNameHelper paserCookieValue(CookieNameConfig cookieNameConfig,
			String cookieValue) {
		String value = StringUtils.trimToNull(cookieValue);
		if (value == null || StringUtils.equalsIgnoreCase("null", value))
			return null;

		// 如果加密，先揭秘
		if (cookieNameConfig.isEncrypt()) {
			value = CookieUtils.decrypt(value);
		}
		CookieNameHelper cookieNameHelper = new CookieNameHelper(
				cookieNameConfig.getCookieName(), cookieNameConfig);
		// 对简单值进行处理。Key只能够配置一项,对于错误目前是记录日志
		if (cookieNameConfig.isSimpleValue()) {
			cookieNameHelper.parserValue(value);
		} else {
			// 复杂Value需要装换
			Map<CookieKeyEnum, String> kv = CookieUtils.strToKVMap(value,
					cookieNameConfig);
			// CookieNameHelper cookieNameHelper = null;
			if (kv != null && !kv.isEmpty())
				cookieNameHelper.parserAllValues(kv);
		}
		return cookieNameHelper;
	}

}
