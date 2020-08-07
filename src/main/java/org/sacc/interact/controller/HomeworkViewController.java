package org.sacc.interact.controller;

import com.github.pagehelper.PageInfo;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.sacc.interact.model.RestResult;
import org.sacc.interact.pojo.Homeworkview;
import org.sacc.interact.service.HomeworkViewService;
import org.sacc.interact.util.ToolUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;


@RestController
public class HomeworkViewController {
    @Autowired
    HomeworkViewService homeworkViewService;

    @GetMapping("/homeworkView/list")
    public RestResult<PageInfo> getSub(@RequestParam(value = "pageSize", defaultValue = "5") int pageSize,
                                           @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                                           @RequestParam("homeworkId") int homeworkId){
        PageInfo pageInfo=homeworkViewService.getHomeworkSubList(pageNum, pageSize, homeworkId);
        if(pageInfo==null){
            return RestResult.error("获取失败");
        }else {
            return RestResult.success(pageInfo);
        }
    }
    @GetMapping("/homeworkView/excellentWork")
    public RestResult<List> getExcellent(@RequestParam("homeworkId") int homeworkId){
        List list=homeworkViewService.getExcellentWork(homeworkId);
        if(list==null){
            return RestResult.error("获取失败");
        }else {
            return RestResult.success(list);
        }
    }
    @GetMapping("/homeworkView/menu")
    public RestResult<List> getHomeworkMeun(@RequestParam("submissionId")int submissionId) throws IOException {
        Homeworkview homeworkview=homeworkViewService.getHomeworkview(submissionId);
        byte[] bytes=homeworkview.getContent();
        List list= ToolUtils.getMenu(bytes);
        return RestResult.success(list);
    }
    @GetMapping("/homeworkView/fileView")
    public RestResult getFileView(@RequestParam("submissionId")int submissionId,
                              @RequestParam("fileName")String fileName,
                              HttpServletResponse response) throws IOException {
        Homeworkview homeworkview=homeworkViewService.getHomeworkview(submissionId);
        if (!ToolUtils.checkText(fileName)) {
            return RestResult.error("文件格式不可在线预览");
        }
        if(homeworkViewService.checkType(homeworkview)==1) {  //1是文本 2是zip
            return RestResult.success(new String(homeworkview.getContent()));
        }else {
            byte[] bytes = homeworkview.getContent();
            byte[] fileByte = ToolUtils.getFile(bytes, fileName);
                return RestResult.success(new String(fileByte));
        }
    }

    @GetMapping("/homeworkView/fileDownload")
    public void downloadFile(@RequestParam("submissionId")int submissionId,
                                  @RequestParam("fileName")String fileName,
                                  HttpServletResponse response) throws IOException {
        Homeworkview homeworkview=homeworkViewService.getHomeworkview(submissionId);
        byte[] bytes = homeworkview.getContent();
        byte[] fileByte =null;
        if(homeworkViewService.checkType(homeworkview)==1) {  //1是文本 2是zip
            fileByte=homeworkview.getContent();
        }else {
            fileByte=ToolUtils.getFile(bytes, fileName);
        }
        InputStream inputStream =  new ByteArrayInputStream(fileByte);
        OutputStream outputStream = response.getOutputStream();
        response.setContentType("application/octet-stream;charset=utf-8");
        response.addHeader("Content-Disposition", "attachment;filename="+fileName);
        IOUtils.copy(inputStream, outputStream);
        outputStream.flush();
    }

    @GetMapping("/homeworkView/zipDownload")
    public RestResult downloadZip(@RequestParam("submissionId")int submissionId,
                                          HttpServletResponse response) throws IOException {
        Homeworkview homeworkview=homeworkViewService.getHomeworkview(submissionId);
        if(homeworkViewService.checkType(homeworkview)==1){
            return RestResult.error("非zip文件");
        }
        InputStream inputStream =  new ByteArrayInputStream(homeworkview.getContent());
        OutputStream outputStream = response.getOutputStream();
        response.setContentType("application/octet-stream;charset=utf-8");
        response.addHeader("Content-Disposition", "attachment;filename="+homeworkview.getUserId()+".zip");
        IOUtils.copy(inputStream, outputStream);
        outputStream.flush();
        return RestResult.success("成功");
    }

}
