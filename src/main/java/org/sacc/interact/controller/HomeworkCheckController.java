package org.sacc.interact.controller;

import org.sacc.interact.model.RestResult;
import org.sacc.interact.pojo.RemarkParam;
import org.sacc.interact.service.HomeworkCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("homeworkCheck")
public class HomeworkCheckController {
    @Autowired
    HomeworkCheckService homeworkCheckService;

    @PostMapping("/remark")
    public RestResult remarkHomework(@RequestBody RemarkParam remarkParam){
        if(homeworkCheckService.remarkHomework(remarkParam)==0){
            return RestResult.error("批改失败");
        }else {
            return RestResult.success("批改成功");
        }
    }
    @GetMapping("/setExcellent")
    public RestResult setExcellent(@RequestParam("submissionId")int submissionId){
        if(homeworkCheckService.setExcellentWork(submissionId)==0){
            return RestResult.error("设置优秀作业失败");
        }else {
            return RestResult.success("设置优秀作业成功");
        }
    }
}
