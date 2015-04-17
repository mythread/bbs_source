package com.bbs.web.webuser;

import com.bbs.util.Argument;

/**
 * @author jie.xu 2014年12月1日 下午1:43:38
 */
public class WebUser {

    private static ThreadLocal<WebUser> userHolder = new ThreadLocal<WebUser>();

    public static void set(WebUser webUser) {
        userHolder.set(webUser);
    }

    public static WebUser get() {
        return userHolder.get();
    }

    private Integer id;
    private String nickname;
    private String avatar;// 头像
    private String email;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 
     * 功能描述: 是否有登入<br>
     * 〈功能详细描述〉
     * 
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public boolean isLogin() {
        return Argument.isPositive(id);
    }

}
