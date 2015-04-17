/*
 * Copyright (C), 2014-2014, 上海澍勋电子商务有限公司
 * FileName: WebUserBuilderFilter.java
 * Author:   jie.xu
 * Date:     2014年12月11日 下午4:52:23
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.bbs.web.filter;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bbs.cookie.CookieKeyEnum;
import com.bbs.cookie.manager.CookieManager;
import com.bbs.cookie.manager.CookieManagerLocator;
import com.bbs.util.ConfigUtil;
import com.bbs.web.webuser.WebUser;

/**
 * 从cookie中创建webuser,并检查url访问权限 <br>
 * 〈功能详细描述〉
 * 
 * @author jie.xu
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class WebUserBuilderFilter implements Filter {

    private static final Logger LOG = LoggerFactory.getLogger(WebUserBuilderFilter.class);

    private static final String LOGIN_URL = "/users/sign_in.htm";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
            ServletException {
        LOG.info("----------builde webuser filter start -----------");
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        String checkUrl = ConfigUtil.getConfig().get("checkUrlList");
        String checkUrlLike = ConfigUtil.getConfig().get("checkUrlLikeList");
        String requestUrl = httpRequest.getRequestURI();

        LOG.info("-----requestUri:" + requestUrl + "---------");
        WebUser webUser = buildeWebUser(httpRequest, httpResponse);
        boolean checkLogin = checkLoginUrl(checkUrl, checkUrlLike, requestUrl);
        if (checkLogin) {
            // 用户需要登入
            if (!webUser.isLogin()) {
                httpResponse.sendRedirect(LOGIN_URL);
            }
        }
        chain.doFilter(httpRequest, httpResponse);

    }

    /**
     * 功能描述: 从cookie中创建webuser对象 <br>
     * 〈功能详细描述〉
     * 
     * @param httpRequest
     * @param httpResponse
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    private WebUser buildeWebUser(HttpServletRequest httpRequest, HttpServletResponse httpResponse) {
        CookieManager cookieManager = CookieManagerLocator.get(httpRequest, httpResponse);
        String uerId = cookieManager.get(CookieKeyEnum.user_id);
        String email = cookieManager.get(CookieKeyEnum.user_email);
        String nickName = cookieManager.get(CookieKeyEnum.user_nickname);
        String avatarUrl = cookieManager.get(CookieKeyEnum.user_avatar);
        WebUser webUser = new WebUser();
        Integer id = null;
        try {
            id = Integer.valueOf(uerId);
        } catch (Exception e) {
        }
        webUser.setId(id);
        webUser.setNickname(nickName);
        webUser.setEmail(email);
        webUser.setAvatar(avatarUrl);
        WebUser.set(webUser);
        return webUser;
    }

    /**
     * 
     * 功能描述: <br>
     * 〈功能详细描述〉
     * 
     * @param checkUrl
     * @param checkUrlLike
     * @param tarUrl
     *            用户访问的url
     * @return true:需要用户登入，false:不需要登入
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    private boolean checkLoginUrl(String checkUrl, String checkUrlLike, String tarUrl) {
        if (StringUtils.isEmpty(checkUrl) || StringUtils.isEmpty(checkUrlLike)) {
            return false;
        }
        String[] checkUrlList = checkUrl.split(",");
        String[] checkUrlLikeList = checkUrlLike.split(",");

        for (String url : checkUrlList) {
            if (url.equals(tarUrl)) {
                return true;
            }
        }
        for (String url : checkUrlLikeList) {
            Pattern p = Pattern.compile(url);
            if (p.matcher(tarUrl).find()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void destroy() {

    }

}
