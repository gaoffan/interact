package org.sacc.interact.service.impl;

import org.sacc.interact.entity.Ppt;
import org.sacc.interact.mapper.PptMapper;
import org.sacc.interact.service.PptService;
import org.sacc.interact.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import static org.sacc.interact.utils.FileUtil.getFileHeader;

@Service
public class PptServiceImpl  implements PptService{
    @Autowired
    private PptMapper pptMapper;

    @Override
    public boolean addPpt(MultipartFile file,int lessonId) throws IOException {
        byte[] bytes=file.getBytes();
        Ppt ppt=new Ppt();
        String filetype=getFileHeader(file);
        if("25504446".equals(filetype)){
            ppt.setContent(bytes);
            ppt.setLessonId(lessonId);
            ppt.setCreatedTime(LocalDateTime.now());
            ppt.setUpdatedTime(LocalDateTime.now());
            pptMapper.insert(ppt);
            return true;
        }
        return false;
    }


    @Override
    public boolean getById(int id, HttpServletResponse response) throws IOException {
        Ppt ppt=pptMapper.getById(id);
        if(ppt!=null){
            byte[] ppt1=ppt.getContent();
            ServletOutputStream os=response.getOutputStream();
            os.write(ppt1);
            os.close();
            return true;
        }
        return false;
    }

    @Override
    public Result<List<Ppt>> getAll() {
        List<Ppt> pptList=pptMapper.getAll();
        if(pptList==null||pptList.size()==0){
            return Result.error(400,"没有课件");
        }
        else{
            return Result.success(200,pptList);
        }
    }

    @Override
    public boolean delete(int id) {
        if(pptMapper.delete(id)){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public boolean update(MultipartFile file,int lessonId,int id) throws IOException {
        byte[] bytes=file.getBytes();
        Ppt ppt=new Ppt();
        String filetype=getFileHeader(file);
        if("25504446".equals(filetype)){
            ppt.setContent(bytes);
            ppt.setLessonId(lessonId);
            ppt.setId(id);
            ppt.setUpdatedTime(LocalDateTime.now());
            pptMapper.update(ppt);
            return true;
        }
        else{
            return false;
        }
    }
}
