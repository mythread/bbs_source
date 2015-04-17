package com.bbs.web.interceptor;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.alibaba.fastjson.JSONObject;
import com.bbs.cookie.manager.CookieManager;
import com.bbs.cookie.manager.CookieManagerLocator;
import com.bbs.core.JsonResult;
import com.bbs.service.constant.Constant;
import com.bbs.util.AjaxInvokeTools;
import com.bbs.validator.ParamsValidatorParser;
import com.bbs.validator.ParamsValidatorParser.ParamsParseResult;
import com.bbs.viewparse.VelocityViewPaser;
import com.bbs.web.webuser.WebUser;

/**
 * 
 * @author jie.xu 2014年11月24日 下午10:40:13
 */
public class CommonInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Method actionMethod = ((HandlerMethod) handler).getMethod();

        ParamsParseResult result = ParamsValidatorParser.validator(actionMethod, request);
        if (result != null) {
            if (!result.isSuccess()) {
                // 校验失败 处理
                boolean isAjax = AjaxInvokeTools.isAjax(request);
                if (isAjax) {
                    // 异步处理
                    String errMsg = result.getErrorMsg();
                    JsonResult jsonResult = new JsonResult(false, errMsg);
                    String jsonStr = JSONObject.toJSONString(jsonResult);
                    response.setContentType(Constant.AJAX_CONTENT_TYPE);
                    response.getWriter().write(jsonStr);
                } else {
                    // 同步处理
                    String view = result.getView();
                    String errMsg = result.getErrorMsg();
                    Map<String, Object> bodyMap = new HashMap<String, Object>();
                    bodyMap.put(Constant.ERROR_MSG, errMsg);
                    String bodyHtml = generateVelocityHtml(request, bodyMap, Constant.VIEW_PATH + view);
                    Map<String, Object> map = new HashMap<String, Object>();
                    map.put(Constant.SCREEN_CONTENT, bodyHtml);
                    String html = generateVelocityHtml(request, map, Constant.LAYOUT_VIEW);
                    response.getWriter().write(html);
                }
                return false;
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);

        CookieManager cookieManager = CookieManagerLocator.get(request, response);
        cookieManager.save();
        if (modelAndView != null) {
            modelAndView.addObject("webUser", WebUser.get());
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }

    @Override
    public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        super.afterConcurrentHandlingStarted(request, response, handler);
    }

    /**
     * 生成html
     * 
     * @param request
     * @param view
     *            :view/home.vm
     * @return
     */
    private String generateVelocityHtml(HttpServletRequest request, Map<String, Object> map, String view) {
        String webRootPath = request.getSession().getServletContext().getRealPath("/");
        String html = VelocityViewPaser.getInstance().viewToHtml(map, webRootPath + "WEB-INF/template/", view);
        return html;
    }
}
