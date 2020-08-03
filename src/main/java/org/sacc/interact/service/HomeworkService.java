package org.sacc.interact.service;

import org.sacc.interact.entity.Homework;
import org.sacc.interact.model.RestResult;

import java.util.List;

/**
 * Created by 林夕
 * Date 2020/7/27 14:56
 */

public interface HomeworkService {
    RestResult<Homework> findByLessonId(Integer lessonId);

    RestResult<List<Homework>> findByGroupId(Integer groupId);

    RestResult publish(Homework homework);

    RestResult update(Homework homework);
}
