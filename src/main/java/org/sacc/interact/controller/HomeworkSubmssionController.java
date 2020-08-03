package org.sacc.interact.controller;

import io.swagger.annotations.ApiOperation;
import org.apache.commons.io.FilenameUtils;
import org.sacc.interact.entity.HomeworkSubmission;
import org.sacc.interact.mapper.HomeworkSubmissionMapper;
import org.sacc.interact.model.RestResult;
import org.sacc.interact.model.UserInfo;
import org.sacc.interact.service.HomeworkSubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

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
    public RestResult<HomeworkSubmission> UploadText(@RequestParam("text") String text,
                                                     @RequestParam("homeworkId") Integer homeworkId,
                                                     Authentication authentication){
        UserInfo userInfo = (UserInfo)authentication.getPrincipal();
        return homeworkSubmissionService.uploadText(text,homeworkId,userInfo.getId());
    }

    @ApiOperation("上传压缩包类型作业")
    @PostMapping("/homeworkSubmission/uploadZip")
    public RestResult<HomeworkSubmission> UploadZip(@RequestParam("file") MultipartFile multipartFile,
                                                    @RequestParam("homeworkId") Integer homeworkId,
                                                    Authentication authentication) throws IOException {
        UserInfo userInfo = (UserInfo)authentication.getPrincipal();
        return homeworkSubmissionService.uploadZip(multipartFile,homeworkId,userInfo.getId());
    }
}
