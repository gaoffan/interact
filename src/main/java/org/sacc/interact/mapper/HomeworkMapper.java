package org.sacc.interact.mapper;

import org.sacc.interact.entity.Homework;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
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
