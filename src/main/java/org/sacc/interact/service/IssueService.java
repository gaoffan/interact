package org.sacc.interact.service;

import com.github.pagehelper.PageInfo;
import org.sacc.interact.pojo.IssueParam;
import org.sacc.interact.pojo.IssueReplyParam;

public interface IssueService {

    public int issue(IssueParam issueParam);
    public int issueReply(IssueReplyParam issueReplyParam);
    public PageInfo getIssueList(int pageNum, int pageSize, int groupId);
    public PageInfo getIssueReplyList(int pageNum, int pageSize, int issueId);
    public int updateIssue(IssueParam issueParam);
    public int updateIssueReply(IssueReplyParam issueReplyParam);
    public int deleteIssue(int issueId);
    public int deleteIssueReply(int issueReplyId);

    }
