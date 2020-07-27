package org.sacc.interact.service;

import org.sacc.interact.pojo.Homework;
import org.sacc.interact.vo.ResponseVo;

import java.util.List;

/**
 * Created by 林夕
 * Date 2020/7/27 14:56
 */

public interface HomeworkService {
    ResponseVo<Homework> findByLessonId(Integer lessonId);

    ResponseVo<List<Homework>> findByGroupId(Integer groupId);

    ResponseVo publish(Homework homework);

    ResponseVo update(Homework homework);
}
