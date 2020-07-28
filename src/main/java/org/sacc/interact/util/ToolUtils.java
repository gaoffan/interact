package org.sacc.interact.util;

import org.sacc.interact.pojo.Issue;
import org.sacc.interact.pojo.IssueParam;
import org.sacc.interact.pojo.IssueReply;
import org.sacc.interact.pojo.IssueReplyParam;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ToolUtils {

    public static Issue setIssue(IssueParam issueParam){
        LocalDateTime now=LocalDateTime.now();
        Issue issue=new Issue();
        issue.setGroupId(issueParam.getGroupId());
        issue.setContent(issueParam.getContent());
        issue.setUserId(issueParam.getUserId());
        if(issueParam.isAnonymous()){
            issue.setUserId(0);
        }
        issue.setCreateTime(now);
        issue.setUpdateTime(now);
        return issue;
    }
    public static IssueReply setIssueReply(IssueReplyParam issueReplyParam){
        LocalDateTime now=LocalDateTime.now();
        IssueReply issueReply=new IssueReply();
        issueReply.setContent(issueReplyParam.getContent());
        issueReply.setIssueId(issueReply.getIssueId());
        issueReply.setUserId(issueReply.getUserId());
        if(issueReplyParam.isAnonymous()){
            issueReply.setUserId(0);
        }
        issueReply.setCreateTime(now);
        issueReply.setUpdateTime(now);
        return issueReply;
    }


}
