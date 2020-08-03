package org.sacc.interact.service.impl;

import org.sacc.interact.entity.Homework;
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
    public RestResult<Homework> findByLessonId(Integer lessonId) {
        Homework homework = homeworkMapper.selectByLessonId(lessonId);
        if(homework!=null)
            return RestResult.success(homework);
        else
            return RestResult.error(-1,"该lesson_id不存在");
    }

    @Override
    public RestResult<List<Homework>> findByGroupId(Integer groupId) {
        List<Homework> homeworkList = homeworkMapper.selectByGroupId(groupId);
        if(homeworkList!=null)
            return RestResult.success(homeworkList);
        else
            return RestResult.error(-1,"该group_id不存在");
    }

    @Override
    public RestResult publish(Homework homework) {
        int i = homeworkMapper.insert(homework);
        if (i==1)
            return RestResult.success(200,"OK");
        else
            return RestResult.error(500,"服务器错误");
    }

    @Override
    public RestResult update(Homework homework) {
        int i = homeworkMapper.updateByPrimaryKeySelective(homework);
        if(i==1)
            return RestResult.success(200,"OK");
        else
            return RestResult.error(500,"服务器错误");
    }
}
