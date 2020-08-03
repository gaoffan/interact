package org.sacc.interact.controller;

import com.github.pagehelper.PageInfo;
import org.apache.commons.io.IOUtils;
import org.sacc.interact.model.RestResult;
import org.sacc.interact.pojo.Homeworkview;
import org.sacc.interact.service.HomeworkViewService;
import org.sacc.interact.util.ToolUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

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
    @GetMapping("/homeworkView/menu")
    public RestResult<List> getHomeworkMeun(@RequestParam("homeworkId")int homeworkId, @RequestParam("userId")int userId) throws IOException {
        Homeworkview homeworkview=homeworkViewService.getHomeworkview(homeworkId, userId);
        byte[] bytes=homeworkview.getContent();
        List list= ToolUtils.getMenu(bytes);
        return RestResult.success(list);
    }
    @GetMapping("/homeworkView/file")
    public RestResult getFile(@RequestParam("homeworkId")int homeworkId, @RequestParam("userId")int userId,
                              @RequestParam("fileName")String fileName,
                              HttpServletResponse response) throws IOException {
        Homeworkview homeworkview=homeworkViewService.getHomeworkview(homeworkId, userId);
        byte[] bytes=homeworkview.getContent();
        byte[] fileByte=ToolUtils.getFile(bytes, fileName);
        if(ToolUtils.checkText(fileName)){
            return RestResult.success(new String(fileByte));
        }
        InputStream inputStream =  new ByteArrayInputStream(fileByte);
        OutputStream outputStream = response.getOutputStream();
            response.setContentType("application/octet-stream;charset=utf-8");
            response.addHeader("Content-Disposition", "attachment;filename="+fileName);
            IOUtils.copy(inputStream, outputStream);
            outputStream.flush();
            return RestResult.success(null);
    }



}
