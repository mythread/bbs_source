package com.bbs.model.base;

import java.io.Serializable;
import java.util.Date;

public class Basetopics implements Serializable {
    private Integer id;

    private Date createdAt;

    private Date updatedAt;

    private Integer nodeId;

    private Integer userId;

    private String title;

    private Integer commentsCount;

    private Byte commentsClosed;

    private Integer browseNum;

    private String lastRepliedBy;

    private Date lastRepliedAt;

    private String content;

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

    public Integer getNodeId() {
        return nodeId;
    }

    public void setNodeId(Integer nodeId) {
        this.nodeId = nodeId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getCommentsCount() {
        return commentsCount;
    }

    public void setCommentsCount(Integer commentsCount) {
        this.commentsCount = commentsCount;
    }

    public Byte getCommentsClosed() {
        return commentsClosed;
    }

    public void setCommentsClosed(Byte commentsClosed) {
        this.commentsClosed = commentsClosed;
    }

    public Integer getBrowseNum() {
        return browseNum;
    }

    public void setBrowseNum(Integer browseNum) {
        this.browseNum = browseNum;
    }

    public String getLastRepliedBy() {
        return lastRepliedBy;
    }

    public void setLastRepliedBy(String lastRepliedBy) {
        this.lastRepliedBy = lastRepliedBy == null ? null : lastRepliedBy.trim();
    }

    public Date getLastRepliedAt() {
        return lastRepliedAt;
    }

    public void setLastRepliedAt(Date lastRepliedAt) {
        this.lastRepliedAt = lastRepliedAt;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}