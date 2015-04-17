package com.bbs.model.base;

import java.io.Serializable;
import java.util.Date;

public class Basecomments implements Serializable {
    private Integer id;

    private Date createdAt;

    private Date updatedAt;

    private String content;

    private Integer userId;

    private Integer oldCommentId;

    private Integer topicId;

    private String postingDevice;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getOldCommentId() {
        return oldCommentId;
    }

    public void setOldCommentId(Integer oldCommentId) {
        this.oldCommentId = oldCommentId;
    }

    public Integer getTopicId() {
        return topicId;
    }

    public void setTopicId(Integer topicId) {
        this.topicId = topicId;
    }

    public String getPostingDevice() {
        return postingDevice;
    }

    public void setPostingDevice(String postingDevice) {
        this.postingDevice = postingDevice == null ? null : postingDevice.trim();
    }
}