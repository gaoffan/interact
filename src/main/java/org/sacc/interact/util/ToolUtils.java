package org.sacc.interact.util;

import org.sacc.interact.pojo.Issue;
import org.sacc.interact.pojo.IssueReply;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ToolUtils {

    public static Issue setIssue(String content, boolean flag,int userId,int groupId){
        Issue issue=new Issue();
        issue.setContent(content);
        if(flag){
            userId=0;
        }
        issue.setGroupId(groupId);
        issue.setUserId(userId);
        issue.setCreateTime(LocalDateTime.now());
        issue.setUpdateTime(LocalDateTime.now());
        return issue;
    }
    public static IssueReply setIssueReply(String content, boolean flag,int userId,int issueId){
        IssueReply issueReply=new IssueReply();
        issueReply.setContent(content);
        issueReply.setIssueId(issueId);
        if(flag){
            userId=0;
        }
        issueReply.setUserId(userId);
        issueReply.setCreateTime(LocalDateTime.now());
        issueReply.setUpdateTime(LocalDateTime.now());
        return issueReply;
    }


}
