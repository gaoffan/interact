package org.sacc.interact.pojo;

import java.time.LocalDateTime;

public class IssueReplyParam {
    private boolean isAnonymous;
    private int id;
    private int userId;
    private int issueId;
    private String content;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getIssueId() {
        return issueId;
    }

    public void setIssueId(int issueId) {
        this.issueId = issueId;
    }

    public void setAnonymous(boolean anonymous) {
        isAnonymous = anonymous;
    }

    public boolean isAnonymous() {
        return isAnonymous;
    }
}
