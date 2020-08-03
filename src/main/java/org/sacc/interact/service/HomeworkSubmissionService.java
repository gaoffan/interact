package org.sacc.interact.service;

import org.sacc.interact.entity.HomeworkSubmission;
import org.sacc.interact.model.RestResult;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Created by 林夕
 * Date 2020/7/30 10:35
 */
public interface HomeworkSubmissionService {
    RestResult<HomeworkSubmission> uploadZip(MultipartFile file, Integer homeworkId, Integer userId) throws IOException;

    RestResult<HomeworkSubmission> uploadText(String text, Integer homeworkId, Integer userId);
}
