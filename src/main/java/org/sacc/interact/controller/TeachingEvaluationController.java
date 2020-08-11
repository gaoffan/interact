package org.sacc.interact.controller;

import org.sacc.interact.model.RestResult;
import org.sacc.interact.model.UserInfo;
import org.sacc.interact.service.EvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 林夕
 * Date 2020/8/10 9:44
 */
@RestController
public class TeachingEvaluationController {

    @Autowired
    private EvaluationService evaluationService;

    @PostMapping("/lesson/evaluate")
    public RestResult evaluate(@RequestParam("lessonId") Integer lessonId,
                               @RequestParam("remark") String remark,
                               Authentication authentication){
        UserInfo userInfo = (UserInfo)authentication.getPrincipal();
        return RestResult.success(evaluationService.evaluation(lessonId,remark,userInfo.getId()));
    }
}
