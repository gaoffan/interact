package org.sacc.interact.service;

import org.sacc.interact.entity.Lesson;
import org.sacc.interact.utils.Result;

import java.util.List;

public interface LessonService {
    Result addLesson(Lesson lesson);
    Result<List<Lesson>> getByGroupId(int groupId);
    Result updateLesson(Lesson lesson);
    Result deleteLesson(int id);
}
