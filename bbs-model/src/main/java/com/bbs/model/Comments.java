package com.bbs.model;

import java.util.Date;

import org.apache.commons.lang.StringUtils;

import com.bbs.core.Pagination;
import com.bbs.model.base.Basecomments;
import com.bbs.util.DateUtil;

/**
 * 类Comments.java的实现描述：TODO 类实现描述
 * 
 * @author jie.xu 2014年11月17日 下午10:24:04
 */
public class Comments extends Basecomments {

    private Comments oldComment;// 回复的上一条评论

    private String nickname;
    private String avatar;

    private Pagination pagination;

    private String title;
    private Date topicCreatedAt;
    private Integer topicUserId;
    private String topicNickName;

    public Comments getOldComment() {
        return oldComment;
    }

    public void setOldComment(Comments oldComment) {
        this.oldComment = oldComment;
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

    public boolean hasOldComment() {
        return getOldCommentId() != null;
    }

    public String getCreateDateText() {
        return DateUtil.getDateText(getCreatedAt());
    }

    public String getTopicCreatedAtText() {
        return DateUtil.getDateText(topicCreatedAt);
    }

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    public Date getTopicCreatedAt() {
        return topicCreatedAt;
    }

    public void setTopicCreatedAt(Date topicCreatedAt) {
        this.topicCreatedAt = topicCreatedAt;
    }

    public Integer getTopicUserId() {
        return topicUserId;
    }

    public void setTopicUserId(Integer topicUserId) {
        this.topicUserId = topicUserId;
    }

    public String getTopicNickName() {
        return topicNickName;
    }

    public void setTopicNickName(String topicNickName) {
        this.topicNickName = topicNickName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean hasPostingDevice() {
        return StringUtils.isNotEmpty(getPostingDevice());
    }
}
