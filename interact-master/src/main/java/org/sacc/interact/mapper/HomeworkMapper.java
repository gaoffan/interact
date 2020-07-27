package org.sacc.interact.mapper;

import org.sacc.interact.pojo.Homework;

import java.util.List;

public interface HomeworkMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Homework record);

    int insertSelective(Homework record);

    Homework selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Homework record);

    int updateByPrimaryKey(Homework record);

    Homework selectByLessonId(Integer lessonId);

    List<Homework> selectByGroupId(Integer groupId);
}
