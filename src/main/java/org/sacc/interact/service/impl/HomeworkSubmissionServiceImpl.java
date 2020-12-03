package org.sacc.interact.service.impl;

import org.sacc.interact.entity.Homework;
import org.sacc.interact.entity.HomeworkSubmission;
import org.sacc.interact.exception.Business;
import org.sacc.interact.exception.BusinessException;
import org.sacc.interact.mapper.HomeworkMapper;
import org.sacc.interact.mapper.HomeworkSubmissionMapper;
import org.sacc.interact.service.HomeworkSubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;

/**
 * Created by 林夕
 * Date 2020/7/30 10:35
 */
@Service
public class HomeworkSubmissionServiceImpl implements HomeworkSubmissionService {

    @Autowired
    private HomeworkSubmissionMapper homeworkSubmissionMapper;

    @Autowired
    private HomeworkMapper homeworkMapper;

    @Override
    public boolean uploadZip(MultipartFile multipartFile, Integer homeworkId, Integer userId) throws IOException {
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
        if (isEffective(homeworkId)) {
            byte[] bytes = multipartFile.getBytes();
            String fileName=multipartFile.getOriginalFilename();
            if(upload(bytes, userId, homeworkId,fileName)) return true;
            else throw new BusinessException(Business.INTERNAL_SERVER_ERROR);
        }
        else
            throw new BusinessException(Business.NOT_EFFECTIVE);
    }

    @Override
    public boolean uploadText(String text, Integer homeworkId, Integer userId) {
        if (isEffective(homeworkId)) {
            byte[] bytes = text.getBytes();
            if(upload(bytes, userId, homeworkId)) return true;
            else throw new BusinessException(Business.INTERNAL_SERVER_ERROR);
        }
        else {
            throw new BusinessException(Business.NOT_EFFECTIVE);
            /*return RestResult.error(-1,"已过提交时间无法提交");*/
        }
    }

    /**
     * 判断是为上传还是更新
     * */
    private boolean upload(byte[] bytes,Integer userId,Integer homeworkId,String fileName){
        HomeworkSubmission homeworkSubmission = homeworkSubmissionMapper.selectByUserIdAndHomeworkId(userId,homeworkId);
        if(homeworkSubmission==null){
            HomeworkSubmission h = new HomeworkSubmission();
            h.setUserId(userId);
            h.setHomeworkId(homeworkId);
            h.setCreatedAt(LocalDateTime.now());
            h.setUpdateAt(LocalDateTime.now());
            h.setContent(bytes);
            h.setFileName(fileName);
            System.out.println("--------------------------------------------------------");
            System.out.println(h.getFileName());
            int i = homeworkSubmissionMapper.insertSelective(h);
            return i == 1;
        }
        else {
            homeworkSubmission.setUpdateAt(LocalDateTime.now());
            homeworkSubmission.setContent(bytes);
            int i = homeworkSubmissionMapper.updateByPrimaryKeySelective(homeworkSubmission);
            return i == 1;
        }
    }

    private boolean upload(byte[] bytes,Integer userId,Integer homeworkId){
        return upload(bytes,userId,homeworkId,null);
    }
    /**
     * 判段此次提交是否在提交时间范围内
     */
    private boolean isEffective(Integer homeworkId){
        Homework homework = homeworkMapper.selectByPrimaryKey(homeworkId);
        LocalDateTime localDateTime =LocalDateTime.now();
        return homework.getTime().isBefore(localDateTime) && homework.getDeadline().isAfter(localDateTime);
    }
}
