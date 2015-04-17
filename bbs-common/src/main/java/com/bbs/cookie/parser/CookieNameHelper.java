package com.bbs.cookie.parser;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import com.bbs.cookie.CookieKeyEnum;
import com.bbs.cookie.annotation.CookieMaxAge;

/**
 * 类CookieNameHelper.java的实现描述：TODO 类实现描述
 * 
 * @author jie.xu 2014年11月23日 下午8:34:27
 */
public class CookieNameHelper {

    private CookieNameConfig config;

    private String cookieName;
    /**
     * 当前Cookie的值是否发生变化
     */
    private boolean isModified = false;
    /** 该CookieName所有Cookie值 */
    private Map<CookieKeyEnum, String> allCookieKeyValues = new HashMap<CookieKeyEnum, String>();

    private String simpleValue;

    public CookieNameHelper(String cookieName, CookieNameConfig config) {
        this.cookieName = cookieName;
        this.config = config;
    }

    /**
     * 对CookieKey进行保存设置新值，如果cookieKey目前不存在，则添加进来。
     */
    public void update(CookieKeyEnum cookieKey, String value) {
        if (config.isSimpleValue()) {
            throw new RuntimeException("对于简单CookieName请使用updateSimpleValue()方法更新");
        }
        allCookieKeyValues.put(cookieKey, value);
        isModified = true;
    }

    public void updateSimpleValue(String value) {
        if (!config.isSimpleValue()) {
            throw new RuntimeException("对于复杂CookieName请使用update(key,value)方法更新");
        }
        simpleValue = value;
        isModified = true;
    }

    public void clear() {
        if (!config.isSimpleValue()) {
            allCookieKeyValues.clear();
        } else {
            simpleValue = null;
        }
        this.isModified = true;
    }

    public Set<CookieKeyEnum> getAllKeys() {
        return allCookieKeyValues.keySet();
    }

    public String getValue() {
        if (!config.isSimpleValue()) {
            throw new RuntimeException("对于复杂CookieName请使用getValue(key)方法");
        }
        return simpleValue;
    }

    public String getValue(CookieKeyEnum cookieKeyEnum) {
        if (config.isSimpleValue()) {
            throw new RuntimeException("对于简单CookieName请使用getValue()方法");
        }
        return allCookieKeyValues.get(cookieKeyEnum);
    }

    public boolean isEmpty() {
        return (simpleValue == null) && allCookieKeyValues.isEmpty();
    }

    public String getCookieName() {
        return this.cookieName;
    }

    /**
     * 如果当前值发生变化将当前的CookieName保存到Response中
     * 
     * <pre>
     * 如果cookie的值被设置为<code>null</code>或者blank时，就会清空该Cookie项
     * </pre>
     */
    public void saveIfModified(HttpServletResponse response) {
        if (!isModified) {
            return;
        }
        String value = config.isSimpleValue() ? simpleValue : CookieUtils.mapToStr(allCookieKeyValues);
        if (config.isEncrypt()) {
            value = CookieUtils.encrypt(value);
        }
        Cookie cookie = new Cookie(cookieName, value);
        if (StringUtils.isBlank(value)) {
            cookie.setMaxAge(CookieMaxAge.OUT_OF_DATE);
        } else {
            cookie.setMaxAge(config.getMaxAge());
        }
        cookie.setDomain(config.getDomain().getDomain());
        cookie.setPath(config.getPath().getPath());
        response.addCookie(cookie);

        // 保存完成后重新置标志位
        this.isModified = false;
    }

    /**
     * 解析该CookieName所有的值,该方法不会标记Modified
     */
    void parserAllValues(Map<CookieKeyEnum, String> values) {
        if (config.isSimpleValue()) {
            throw new RuntimeException("对于简单CookieName请使用initValue(value)方法更新");
        }
        this.allCookieKeyValues.putAll(values);
    }

    /**
     * 解析简单Cookie的值
     */
    void parserValue(String value) {
        if (!config.isSimpleValue()) {
            throw new RuntimeException("对于复杂CookieName请使用initAllValues(value)方法更新");
        }
        this.simpleValue = value;
    }

}
