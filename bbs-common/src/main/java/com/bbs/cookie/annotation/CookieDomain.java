package com.bbs.cookie.annotation;

import org.apache.commons.lang.StringUtils;

/**
 * @author jie.xu 2014年11月23日 下午2:17:59
 */
public enum CookieDomain {

    /**
     * bbs domain
     */
    GBOTTLE_DOMAIN(".linhuaqian.com");

    private String domain;

    private CookieDomain(String cookieDomain) {
        this.domain = cookieDomain;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public static CookieDomain getEnum(String domain) {
        for (CookieDomain cookieDomain : values()) {
            if (StringUtils.equals(domain, cookieDomain.getDomain())) {
                return cookieDomain;
            }
        }
        return null;
    }
}
