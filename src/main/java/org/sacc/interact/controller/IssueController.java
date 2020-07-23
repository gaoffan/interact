package org.sacc.interact.controller;


import com.github.pagehelper.PageInfo;
import org.sacc.interact.service.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("issue")
public class IssueController {

    @Autowired
    IssueService issueService;

    @RequestMapping("/addIssue")
    public String issue(@RequestParam("content") String content, @RequestParam("isAnonymous") boolean flag,
                        @RequestParam("userId") int userId,@RequestParam("groupId")int groupId) {

        if (content == null) {
            return "提问内容为空";
        }
        if (issueService.issue(content, flag, userId,groupId)) {
            return "提问成功";
        } else {
            return "提问失败";
        }
    }

    @RequestMapping("/updateIssue")
    public String updateIssue(@RequestParam("content") String content, @RequestParam("issueId") int issueId) {

        if (content == null) {
            return "内容为空";
        }
        if (issueService.updateIssue(content, issueId)) {
            return "修改成功";
        } else {
            return "修改失败";
        }
    }

    @RequestMapping("/updateIssueReply")
    public String updateIssueReply(@RequestParam("content") String content,@RequestParam("issueReplyId") int issueReplyId) {

        if (content == null) {
            return "内容为空";
        }
        if (issueService.updateIssueReply(content,issueReplyId)) {
            return "修改成功";
        } else {
            return "修改失败";
        }
    }

    @RequestMapping("/addIssueReply")
    public String issueReply(@RequestParam("content") String content, @RequestParam("isAnonymous") boolean flag,
                             @RequestParam("userId") int userId, @RequestParam("issueId") int issueId) {

        if (content == null) {
            return "回复内容为空";
        }
        if (issueService.issueReply(content, flag, userId, issueId)) {
            return "回复成功";
        } else {
            return "回复失败";
        }
    }

    @RequestMapping("/issueList")
    public Object getIssueList(@RequestParam(value = "pageSize", defaultValue = "5") int pageSize,
                               @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                               @RequestParam("groupId") int groupId) {
        if (issueService.getIssueList(pageNum, pageSize, groupId) == null) {
            return "获取失败";
        }
        return issueService.getIssueList(pageNum, pageSize, groupId);
    }

    @RequestMapping("/issueReplyList")
    public Object getIssueReplyList(@RequestParam(value = "pageSize", defaultValue = "5") int pageSize,
                                    @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                                    @RequestParam("issueId") int issueId) {
        if (issueService.getIssueReplyList(pageNum, pageSize, issueId) == null) {
            return "获取失败";
        }
        return issueService.getIssueList(pageNum, pageSize, issueId);

    }

    @RequestMapping("/deleteIssue")
    public String deleteIssue(@RequestParam("issueId")int issueId){
        if(issueService.deleteIssue(issueId)){
            return "删除成功";
        }
        return "删除失败";
    }

    @RequestMapping("/deleteIssueReply")
    public String deleteIssueReply(@RequestParam("issueReplyId")int issueReplyId){
        if(issueService.deleteIssueReply(issueReplyId)){
            return "删除成功";
        }
        return "删除失败";
    }



}
