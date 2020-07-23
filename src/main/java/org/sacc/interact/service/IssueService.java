package org.sacc.interact.service;

import com.github.pagehelper.PageInfo;

public interface IssueService {

    public boolean issue(String content,boolean flag,int user_id,int groupId);
    public boolean issueReply(String content,boolean flag,int userId,int issueId);
    public PageInfo getIssueList(int pageNum, int pageSize, int groupId);
    public PageInfo getIssueReplyList(int pageNum, int pageSize, int issueId);
    public boolean updateIssue(String content,int issueId);
    public boolean updateIssueReply(String content,int issueReplyId);
    public boolean deleteIssue(int issueId);
    public boolean deleteIssueReply(int issueReplyId);

    }
