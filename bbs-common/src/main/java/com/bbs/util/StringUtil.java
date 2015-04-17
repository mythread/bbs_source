package com.bbs.util;

import javax.servlet.http.HttpServletRequest;

import com.google.common.base.Strings;

public class StringUtil {

    private static final String MOBILE_REGEX                  = "^[1][3,4,5,8][0-9]{9}$";                            // 手机号码
    private static final String AREA_CODE_AND_CELLPHONE_REGEX = "^[0][1-9]{2,3}-[0-9]{5,10}$";                       // 带区号的电话号码
    private static final String CELLPHONE_REGEX               = "^[0][1-9]{2,3}-[0-9]{5,10}$";                       // 没有区号的电话号码
    private static final String EMAIL_REGEX                   = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$"; // email

    private StringUtil() {
    }

    /**
     * 手机号验证
     * 
     * @param str
     * @return 验证通过返回true
     */
    public static Boolean isMobile(String str) {
        Boolean b = false;
        b = str.matches(MOBILE_REGEX);
        return b;
    }

    /**
     * 电话号码验证
     * 
     * @param str
     * @return 验证通过返回true
     */
    public static Boolean isPhone(String str) {
        Boolean b = false;
        if (str.length() > 9) {
            b = str.matches(AREA_CODE_AND_CELLPHONE_REGEX);
        } else {
            b = str.matches(CELLPHONE_REGEX);
        }
        return b;
    }

    /**
     * 电子邮箱地址验证
     * 
     * @param str
     * @return 验证通过返回true
     */
    public static Boolean isEmail(String str) {
        Boolean b = str.matches(EMAIL_REGEX);
        return b;
    }

    public static String mask(String s) {
        if ("线下用户".equals(s)) {
            return s;
        } else if (Strings.isNullOrEmpty(s) || s.length() <= 4) {
            return "****";
        } else {
            return String.format("%s**%s", s.substring(0, 1), s.substring(s.length() - 1));
        }
    }

    /**
     * 获取客户真实IP
     * @param request
     * @return
     */
	public static String getRemoteIpAddr(HttpServletRequest request) {
		if (request.getHeader("x-forwarded-for") == null) {
            return request.getRemoteAddr();
      }
      return request.getHeader("x-forwarded-for");
	}
}
