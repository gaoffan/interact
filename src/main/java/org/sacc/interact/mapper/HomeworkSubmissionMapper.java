package org.sacc.interact.mapper;

import org.sacc.interact.entity.HomeworkSubmission;
import org.springframework.stereotype.Repository;

@Repository
public interface HomeworkSubmissionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(HomeworkSubmission record);

    int insertSelective(HomeworkSubmission record);

    HomeworkSubmission selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HomeworkSubmission record);

    int updateByPrimaryKey(HomeworkSubmission record);

    HomeworkSubmission selectByUserId(Integer userId);

    HomeworkSubmission selectByUserIdAndHomeworkId(Integer userId,Integer homeworkId);
}
