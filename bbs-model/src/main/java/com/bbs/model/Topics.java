package com.bbs.model;

import com.bbs.core.Pagination;
import com.bbs.model.base.Basetopics;
import com.bbs.util.DateUtil;

/**
 * 类Topics.java的实现描述：TODO 类实现描述
 * 
 * @author jie.xu 2014年11月17日 下午10:27:17
 */
public class Topics extends Basetopics {

    private Pagination pagination;

    private String nickName;
    private String avatar;
    private String nodeName;

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public String getLastRepliedAtText() {
        return DateUtil.getDateText(getLastRepliedAt());
    }

    public String getCreateAtText() {
        return DateUtil.getDateText(getCreatedAt());
    }
}
