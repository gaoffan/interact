package org.sacc.interact.service;

import org.sacc.interact.entity.Ppt;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public interface PptService {
    boolean addPpt(MultipartFile file, int lessonId) throws IOException;
    void getById(int id, HttpServletResponse response) throws IOException;
    List<Ppt> getAll();
    boolean delete(int id);
    boolean update(MultipartFile file,int lessonId,int id) throws IOException;
}
