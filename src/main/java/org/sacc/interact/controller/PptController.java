package org.sacc.interact.controller;

import org.sacc.interact.entity.Ppt;
import org.sacc.interact.model.RestResult;
import org.sacc.interact.service.PptService;
import org.sacc.interact.service.impl.PptServiceImpl;
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


    @PostMapping("/ppt/downloadById")
    public void getById(@RequestParam("id")int id, HttpServletResponse response) throws IOException {
        pptServiceImpl.getById(id,response);
    }

    @PostMapping("/ppt/getAll")
    public RestResult<List<Ppt>> getAll(){
        List<Ppt> pptList=pptServiceImpl.getAll();
        if(pptList==null||pptList.size()==0){
            return RestResult.error("没有课件");
        }
        return RestResult.success(200,pptList);
    }

    @PostMapping("/ppt/upload")
    public RestResult insert(@RequestParam("file")MultipartFile file, @RequestParam("lessonId")int lessonId, HttpServletRequest request) throws IOException {
        if(pptServiceImpl.addPpt(file,lessonId)){
            return RestResult.success(200,"上传成功");
        }
            return RestResult.error(400,"文件类型错误");
    }

    @PostMapping("ppt/delete")
    public RestResult delete(@RequestParam("id")int id){
        if(pptServiceImpl.delete(id)){
            return RestResult.success(200,"删除成功");
        }
        return RestResult.error(400,"该记录不存在");
    }

    @PostMapping("ppt/update")
    public RestResult update(@RequestParam("file")MultipartFile file,@RequestParam("lessonId")int lessonId,@RequestParam("id")int id, HttpServletRequest request) throws IOException {

        if(pptServiceImpl.update(file,lessonId,id)){
            return RestResult.success(200,"更新成功");
        }
            return RestResult.error(400,"更新失败");
    }
}
