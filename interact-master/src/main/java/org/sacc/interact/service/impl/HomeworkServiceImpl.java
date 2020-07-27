package org.sacc.interact.service.impl;

import org.sacc.interact.mapper.HomeworkMapper;
import org.sacc.interact.pojo.Homework;
import org.sacc.interact.service.HomeworkService;
import org.sacc.interact.vo.ResponseVo;
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
    public ResponseVo<Homework> findByLessonId(Integer lessonId) {
        Homework homework = homeworkMapper.selectByLessonId(lessonId);
        if(homework!=null)
            return ResponseVo.success(homework);
        else
            return ResponseVo.error("该lesson_id不存在");
    }

    @Override
    public ResponseVo<List<Homework>> findByGroupId(Integer groupId) {
        List<Homework> homeworkList = homeworkMapper.selectByGroupId(groupId);
        if(homeworkList!=null)
            return ResponseVo.success(homeworkList);
        else
            return ResponseVo.error("该group_id不存在");
    }

    @Override
    public ResponseVo publish(Homework homework) {
        int i = homeworkMapper.insert(homework);
        if (i==1)
            return ResponseVo.success();
        else
            return ResponseVo.error();
    }

    @Override
    public ResponseVo update(Homework homework) {
        int i = homeworkMapper.updateByPrimaryKeySelective(homework);
        if(i==1)
            return ResponseVo.success();
        else
            return ResponseVo.error();
    }
}
