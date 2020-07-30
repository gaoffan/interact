package org.sacc.interact.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.sacc.interact.mapper.IssueMapper;
import org.sacc.interact.pojo.Issue;
import org.sacc.interact.pojo.IssueParam;
import org.sacc.interact.pojo.IssueReply;
import org.sacc.interact.pojo.IssueReplyParam;
import org.sacc.interact.service.IssueService;
import org.sacc.interact.util.ToolUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class IssueServiceImpl implements IssueService {

    @Autowired
    IssueMapper issueMapper;

    @Override
    public int issue(IssueParam issueParam) {
        return issueMapper.addIssue(ToolUtils.setIssue(issueParam));
    }

    @Override
    public int issueReply(IssueReplyParam issueReplyParam) {
        return issueMapper.addIssueReply(ToolUtils.setIssueReply(issueReplyParam));
    }

    @Override
    public PageInfo getIssueList(int pageNum, int pageSize, int groupId) {
        PageHelper.startPage(pageNum, pageSize);
        List<Issue> list = issueMapper.getIssueList(groupId);
        return new PageInfo<>(list);


    }

    @Override
    public PageInfo getIssueReplyList(int pageNum, int pageSize, int issueId) {
        PageHelper.startPage(pageNum, pageSize);
        List<IssueReply> list = issueMapper.getIssueReplyList(issueId);
        return new PageInfo<>(list);
    }

    @Override
    public int updateIssue(IssueParam issueParam) {
        Issue issue = new Issue();
        issue.setId(issueParam.getId());
        issue.setContent(issueParam.getContent());
        issue.setUpdateTime(LocalDateTime.now());
        return issueMapper.updateIssue(issue);

    }

    @Override
    public int updateIssueReply(IssueReplyParam issueReplyParam) {
        IssueReply issueReply = new IssueReply();
        issueReply.setId(issueReplyParam.getId());
        issueReply.setContent(issueReplyParam.getContent());
        issueReply.setUpdateTime(LocalDateTime.now());
        return issueMapper.updateIssueReply(issueReply);

    }

    @Override
    public int deleteIssue(int issueId) {
        int result=issueMapper.deleteIssue(issueId);
        issueMapper.deleteIssueReplyByIssueId(issueId);   //删除问题，相关回答也删除
        return result;
    }

    @Override
    public int deleteIssueReply(int issueReplyId) {
        return issueMapper.deleteIssueReply(issueReplyId);
    }
}
