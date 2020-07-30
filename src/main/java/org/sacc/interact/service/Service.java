package org.sacc.interact.service;

import org.sacc.interact.entity.Lesson;
import org.sacc.interact.model.RestResult;

import java.util.List;

public interface Service {
    RestResult addLesson(Lesson lesson);
    RestResult<List<Lesson>> getByGroupId(int groupId);
    RestResult updateLesson(Lesson lesson);
    RestResult deleteLesson(int id);
}
