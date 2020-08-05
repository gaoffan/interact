package org.sacc.interact.service.impl;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.sacc.interact.entity.Ppt;
import org.sacc.interact.mapper.PptMapper;
import org.sacc.interact.service.PptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
    public void getById(int id, HttpServletResponse response) throws IOException {
        Ppt ppt=pptMapper.getById(id);
        if(ppt!=null){
            byte[] ppt1=ppt.getContent();
            InputStream inputStream=new ByteArrayInputStream(ppt1);
            OutputStream outputStream=response.getOutputStream();
            response.setContentType("application/octet-stream;charset=utf-8");
            response.addHeader("Content-Disposition","attachment;filename=kejian.pdf");
            IOUtils.copy(inputStream,outputStream);
            outputStream.flush();
        }
    }

    @Override
    public List<Ppt> getAll() {
        List<Ppt> pptList=pptMapper.getAll();
        return pptList;
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
