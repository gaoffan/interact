package org.sacc.interact.controller;

import org.apache.commons.io.FilenameUtils;
import org.sacc.interact.entity.HomeworkSubmission;
import org.sacc.interact.mapper.HomeworkSubmissionMapper;
import org.sacc.interact.model.RestResult;
import org.sacc.interact.service.HomeworkSubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
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

@Controller
public class HomeworkSubmssionController {

    @Autowired
    private HomeworkSubmissionService homeworkSubmissionService;

    @GetMapping("/homeworkSubmission")
    public String hello(){
        return "hello";
    }

    @PostMapping("/homeworkSubmission/uploadText")
    @ResponseBody
    public RestResult<HomeworkSubmission> UploadText(@RequestParam("text") String text){
        System.out.println("-----------------------------------------");
        return homeworkSubmissionService.uploadText(text);
    }

    @PostMapping("/homeworkSubmission/uploadZip")
    @ResponseBody
    public RestResult<HomeworkSubmission> UploadZip(@RequestParam("file") MultipartFile multipartFile) throws IOException {
        System.out.println("-----------------------------------------");
        return homeworkSubmissionService.uploadZip(multipartFile);
    }
}
