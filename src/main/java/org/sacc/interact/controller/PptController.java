package org.sacc.interact.controller;

import org.sacc.interact.entity.Ppt;
import org.sacc.interact.service.PptService;
import org.sacc.interact.service.impl.PptServiceImpl;
import org.sacc.interact.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.List;

import static org.sacc.interact.utils.FileUtil.getFileHeader;

@RestController
public class PptController {
    @Autowired
    private PptServiceImpl pptServiceImpl;

    @Autowired
    public PptController(PptServiceImpl pptServiceImpl){
        this.pptServiceImpl=pptServiceImpl;
    }

    @PostMapping("/ppt/downloadById")
    public Result getById(@RequestParam("id")int id, HttpServletResponse response) throws IOException {
        if(pptServiceImpl.getById(id,response)){
            return Result.success(200,"下载成功");
        }
        return Result.error(400,"该ppt不存在");
    }

    @PostMapping("/ppt/getAll")
    public Result<List<Ppt>> getAll(){
        return pptServiceImpl.getAll();
    }

    @PostMapping("/ppt/upload")
    public Result insert(@RequestParam("file")MultipartFile file, @RequestParam("lessonId")int lessonId, HttpServletRequest request) throws IOException {
        if(pptServiceImpl.addPpt(file,lessonId)){
            return Result.success(200,"上传成功");
        }
            return Result.error(400,"文件类型错误");
    }

    @PostMapping("ppt/delete")
    public Result delete(@RequestParam("id")int id){
        if(pptServiceImpl.delete(id)){
            return Result.success(200,"删除成功");
        }
        return Result.error(400,"该记录不存在");
    }

    @PostMapping("ppt/update")
    public Result update(@RequestParam("file")MultipartFile file,@RequestParam("lessonId")int lessonId,@RequestParam("id")int id, HttpServletRequest request) throws IOException {

        if(pptServiceImpl.update(file,lessonId,id)){
            return Result.success(200,"更新成功");
        }
            return Result.error(400,"更新失败");
    }
}
