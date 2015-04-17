package com.bbs.util;

import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * 
 * @author jie.xu 2014年11月26日 下午10:34:32
 */
public class EncodeUtils {
	public static final String ENCODE = "utf-8";

	public static String decode(String s) {
		try {
			return URLDecoder.decode(s, ENCODE);
		} catch (Exception e) {
			return s;
		}
	}

	public static String encode(String s) {
		try {
			return URLEncoder.encode(s, ENCODE);
		} catch (Exception e) {
			return s;
		}
	}
}
