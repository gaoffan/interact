package org.sacc.interact.service.impl;

import org.sacc.interact.entity.Homework;
import org.sacc.interact.exception.Business;
import org.sacc.interact.exception.BusinessException;
import org.sacc.interact.mapper.HomeworkMapper;
import org.sacc.interact.model.RestResult;
import org.sacc.interact.service.HomeworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 林夕
 * Date 2020/7/27 14:56
 */
@Service
public class HomeworkServiceImpl implements HomeworkService {

    @Autowired
    private HomeworkMapper homeworkMapper;

    @Override
    public Homework findByLessonId(Integer lessonId) {
        Homework homework = homeworkMapper.selectByLessonId(lessonId);
        if(homework!=null)
            return homework;
        else
            throw new BusinessException(Business.LESSON_ID_NOT_EXIST);
    }

    @Override
    public List<Homework> findByGroupId(Integer groupId) {
        List<Homework> homeworkList = homeworkMapper.selectByGroupId(groupId);
        if(homeworkList!=null)
            return homeworkList;
        else
            throw new BusinessException(Business.GROUP_ID_NOT_EXIST);
    }

    @Override
    public boolean publish(Homework homework) {
        int i = homeworkMapper.insert(homework);
        if(i==1)
            return true;
        else
            throw new BusinessException(Business.INTERNAL_SERVER_ERROR);
    }

    @Override
    public boolean update(Homework homework) {
        int i = homeworkMapper.updateByPrimaryKeySelective(homework);
        if(i==1)
            return true;
        else
            throw new BusinessException(Business.INTERNAL_SERVER_ERROR);
    }
}
