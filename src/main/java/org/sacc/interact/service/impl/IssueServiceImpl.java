package org.sacc.interact.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.sacc.interact.mapper.IssueMapper;
import org.sacc.interact.pojo.Issue;
import org.sacc.interact.pojo.IssueReply;
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
    public boolean issue(String content, boolean flag,int userId,int groupId) {

        try {
            issueMapper.addIssue(ToolUtils.setIssue(content,flag,userId,groupId));
            return true;
        }catch (Exception e){
            System.out.println("sad");
            return false;
        }
    }

    @Override
    public boolean issueReply(String content,boolean flag,int userId,int issueId){

        try {
            issueMapper.addIssueReply(ToolUtils.setIssueReply(content, flag, userId,issueId));
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public PageInfo getIssueList(int pageNum,int pageSize,int groupId){
        try{
            PageHelper.startPage(pageNum, pageSize);
            List<Issue> list=issueMapper.getIssueList(groupId);
            return new PageInfo<>(list);
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public PageInfo getIssueReplyList(int pageNum, int pageSize, int issueId) {
        try{
            PageHelper.startPage(pageNum, pageSize);
            List<IssueReply> list=issueMapper.getIssueReplyList(issueId);
            return new PageInfo<>(list);
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public boolean updateIssue(String content,int issueId){
        Issue issue=new Issue();
        issue.setId(issueId);
        issue.setContent(content);
        issue.setUpdateTime(LocalDateTime.now());
        try {
            issueMapper.updateIssue(issue);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean updateIssueReply(String content,int issueReplyId){
        IssueReply issueReply=new IssueReply();
        issueReply.setId(issueReplyId);
        issueReply.setContent(content);
        issueReply.setUpdateTime(LocalDateTime.now());
        try {
            issueMapper.updateIssueReply(issueReply);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean deleteIssue(int issueId){
        try{
            issueMapper.deleteIssue(issueId);
            issueMapper.deleteIssueReplyByIssueId(issueId);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean deleteIssueReply(int issueReplyId){
        try{
            issueMapper.deleteIssueReply(issueReplyId);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
