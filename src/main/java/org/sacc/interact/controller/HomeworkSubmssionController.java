package org.sacc.interact.controller;

import io.swagger.annotations.ApiOperation;
import org.sacc.interact.model.RestResult;
import org.sacc.interact.model.UserInfo;
import org.sacc.interact.service.HomeworkSubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Created by 林夕
 * Date 2020/7/30 10:34
 */

@RestController
public class HomeworkSubmssionController {

    @Autowired
    private HomeworkSubmissionService homeworkSubmissionService;

    @ApiOperation("上传文本类型作业")
    @PostMapping("/homeworkSubmission/uploadText")
    public RestResult<Boolean> uploadText(@RequestParam("text") String text,
                                          @RequestParam("homeworkId") Integer homeworkId,
                                          Authentication authentication){
        UserInfo userInfo = (UserInfo)authentication.getPrincipal();
        return RestResult.success(homeworkSubmissionService.uploadText(text,homeworkId,userInfo.getId()));
    }

    @ApiOperation("上传压缩包类型作业")
    @PostMapping("/homeworkSubmission/uploadZip")
    public RestResult<Boolean> uploadZip(@RequestParam("file") MultipartFile multipartFile,
                                         @RequestParam("homeworkId") Integer homeworkId,
                                         Authentication authentication) throws IOException {
        UserInfo userInfo = (UserInfo)authentication.getPrincipal();
        return RestResult.success(homeworkSubmissionService.uploadZip(multipartFile,homeworkId,userInfo.getId()));
    }
}
