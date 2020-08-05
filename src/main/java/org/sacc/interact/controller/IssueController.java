package org.sacc.interact.controller;


import com.github.pagehelper.PageInfo;
import org.sacc.interact.model.RestResult;
import org.sacc.interact.pojo.IssueParam;
import org.sacc.interact.pojo.IssueReplyParam;
import org.sacc.interact.pojo.Result;
import org.sacc.interact.service.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("issue")
public class IssueController {

    @Autowired
    IssueService issueService;

    @PostMapping("/addIssue")
    public Result issue(@RequestBody IssueParam issueParam) {

        if(issueService.issue(issueParam)!=0) {
            return Result.success("提问成功");
        }else {
            return Result.error("提问失败");
        }

    }

    @PostMapping("/updateIssue")
    public Result updateIssue(@RequestBody IssueParam issueParam) {
        if(issueService.updateIssue(issueParam)!=0) {
            return Result.success("修改成功");
        }else {
            return Result.error("修改失败");
        }

    }

    @PostMapping("/updateIssueReply")
    public Result updateIssueReply(@RequestBody IssueReplyParam issueReplyParam) {
        if(issueService.updateIssueReply(issueReplyParam)!=0) {
            return Result.success("修改成功");
        } else {
            return Result.error("修改失败");
        }
    }

    @PostMapping("/addIssueReply")
    public Result issueReply(@RequestBody IssueReplyParam issueReplyParam) {
        if(issueService.issueReply(issueReplyParam)!=0) {
            return Result.success("回复成功");
        }else {
            return Result.error("回复失败");
        }
    }

    @GetMapping("/issueList")
    public RestResult getIssueList(@RequestParam(value = "pageSize", defaultValue = "5") int pageSize,
                                   @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                                   @RequestParam("groupId") int groupId) {
        PageInfo pageInfo=issueService.getIssueList(pageNum, pageSize, groupId);
        if (pageInfo == null) {
            return RestResult.error("获取失败");
        }
        return RestResult.success(pageInfo);
    }

    @GetMapping("/issueReplyList")
    public RestResult getIssueReplyList(@RequestParam(value = "pageSize", defaultValue = "5") int pageSize,
                                    @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                                    @RequestParam("issueId") int issueId) {
        PageInfo pageInfo=issueService.getIssueReplyList(pageNum, pageSize, issueId);
        if (pageInfo == null) {
            return RestResult.error("获取失败");
        }
        return RestResult.success(pageInfo);
    }

    @GetMapping("/deleteIssue")
    public RestResult deleteIssue(@RequestParam("issueId")int issueId){
        if(issueService.deleteIssue(issueId)!=0) {
            return RestResult.success("删除成功");
        }else {
            return RestResult.error("删除失败");
        }
    }

    @GetMapping("/deleteIssueReply")
    public RestResult deleteIssueReply(@RequestParam("issueReplyId")int issueReplyId){
        if(issueService.deleteIssueReply(issueReplyId)!=0) {
            return RestResult.success("删除成功");
        }else {
            return RestResult.error("删除失败");
        }
    }



}
