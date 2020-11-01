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
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.List;

import static org.sacc.interact.utils.FileUtil.getFileHeader;

@Service
public class PptServiceImpl  implements PptService{
    @Autowired
    private PptMapper pptMapper;

    @Override
    public boolean addPpt(MultipartFile file,int lessonId) throws IOException {
        /*byte[] bytes=file.getBytes();
        Ppt ppt=new Ppt();
        String filetype=getFileHeader(file);
        System.out.println("-----------------------------------------------");
        System.out.println(filetype);
        if("25504446".equals(filetype)){
            ppt.setContent(bytes);
            ppt.setLessonId(lessonId);
            ppt.setCreatedTime(LocalDateTime.now());
            ppt.setUpdatedTime(LocalDateTime.now());
            pptMapper.insert(ppt);
            return true;
        }
        return false;*/
        Ppt ppt=new Ppt();
        String fileName = file.getOriginalFilename();
        assert fileName != null;
        String suffix = fileName.substring(fileName.lastIndexOf(".")+1);
        System.out.println("-----------------------------------------------");
        System.out.println(suffix);
        if(suffix.equals("ppt")||suffix.equals("pptx")||suffix.equals("pdf")){
            ppt.setContent(file.getBytes());
            ppt.setFileName(fileName);
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
            String fileName = ppt.getFileName();
            InputStream inputStream=new ByteArrayInputStream(ppt1);
            OutputStream outputStream=response.getOutputStream();
            response.setContentType("application/octet-stream;charset=utf-8");
            response.addHeader("Content-Disposition","attachment;filename="+ URLEncoder.encode(fileName, StandardCharsets.UTF_8));
            IOUtils.copy(inputStream,outputStream);
            outputStream.flush();
        }
    }

    @Override
    public List<Ppt> getAll() {
        return pptMapper.getAll();
    }

    @Override
    public boolean delete(int id) {
        return pptMapper.delete(id);
    }

    @Override
    public boolean update(MultipartFile file,int lessonId,int id) throws IOException {
        /*byte[] bytes=file.getBytes();
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
        }*/
        Ppt ppt=new Ppt();
        String fileName = file.getOriginalFilename();
        assert fileName != null;
        String suffix = fileName.substring(fileName.lastIndexOf(".")+1);
        System.out.println("-----------------------------------------------");
        System.out.println(suffix);
        if(suffix.equals("ppt")||suffix.equals("pptx")||suffix.equals("pdf")){
            ppt.setFileName(fileName);
            ppt.setContent(file.getBytes());
            ppt.setLessonId(lessonId);
            ppt.setId(id);
            ppt.setUpdatedTime(LocalDateTime.now());
            pptMapper.update(ppt);
            return true;
        }
        return false;
    }
}
