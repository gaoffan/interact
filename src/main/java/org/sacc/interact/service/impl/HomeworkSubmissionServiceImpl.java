package org.sacc.interact.service.impl;

import org.apache.commons.io.FilenameUtils;
import org.sacc.interact.entity.HomeworkSubmission;
import org.sacc.interact.mapper.HomeworkSubmissionMapper;
import org.sacc.interact.model.RestResult;
import org.sacc.interact.service.HomeworkSubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * Created by 林夕
 * Date 2020/7/30 10:35
 */
@Service
public class HomeworkSubmissionServiceImpl implements HomeworkSubmissionService {

    @Autowired
    private HomeworkSubmissionMapper homeworkSubmissionMapper;

    @Override
    public RestResult<HomeworkSubmission> uploadZip(MultipartFile multipartFile) throws IOException {
        /*String extension = "." + FilenameUtils.getExtension(multipartFile.getOriginalFilename());
        long size = multipartFile.getSize();
        //生成新的文件名称
        String newFileName = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + UUID.randomUUID().toString().replace("-", "").substring(6) + extension;
        //获取文件大小
        String realPath = ResourceUtils.getURL("classpath:").getPath() + "/static/files";
        String format = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        String dateDirPath = realPath + "/" + format;
        File dataDir = new File(dateDirPath);
        if (!dataDir.exists()) {
            dataDir.mkdirs();
        }
        multipartFile.transferTo(new File(dateDirPath, newFileName));*/
        byte[] bytes = multipartFile.getBytes();
        return upload(bytes,1);
    }

    @Override
    public RestResult<HomeworkSubmission> uploadText(String text) {
        byte[] bytes = text.getBytes();
        return upload(bytes,2);
    }

    private RestResult<HomeworkSubmission> upload(byte[] bytes,Integer userId){
        HomeworkSubmission homeworkSubmission = homeworkSubmissionMapper.selectByUserId(userId);
        if(homeworkSubmission==null){
            HomeworkSubmission h = new HomeworkSubmission();
            h.setUserId(1);
            h.setHomeworkId(1);
            h.setCreatedAt(new Date());
            h.setUpdateAt(new Date());
            h.setContent(bytes);
            int i = homeworkSubmissionMapper.insertSelective(h);
            if (i == 1) {
                return RestResult.success(0, "success");
            } else
                return RestResult.error(-1, "服务器错误");
        }
        else {
            homeworkSubmission.setUpdateAt(new Date());
            homeworkSubmission.setContent(bytes);
            int i = homeworkSubmissionMapper.updateByPrimaryKeySelective(homeworkSubmission);
            if (i == 1) {
                return RestResult.success(0, "success");
            } else
                return RestResult.error(-1, "服务器错误");
        }
    }
}
