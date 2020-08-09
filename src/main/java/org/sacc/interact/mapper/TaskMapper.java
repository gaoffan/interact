package org.sacc.interact.mapper;

import org.apache.ibatis.annotations.*;
import org.sacc.interact.entity.Task;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskMapper {
    @Select("SELECT * FROM task WHERE group_id=#{groupId}")
    @Results(id = "task",value = {
            @Result(column = "group_id",property = "groupId"),
    @Result(column = "homework_id",property = "homeworkId"),
    @Result(column = "created_at",property = "createdTime"),
    @Result(column = "updated_at",property = "updatedTime")
    })
    List<Task> selectByGroupId(int groupId);

    @Insert("INSERT INTO task (group_id,content,homework_id,created_at,updated_at) VALUES (#{groupId},#{content},#{homeworkId},#{createdTime},#{updatedTime})")
    boolean insert(Task task);

    @Update("UPDATE task SET group_id=#{groupId},homework_id=#{homeworkId},content=#{content},updated_at=#{updatedTime} WHERE id=#{id}")
    boolean update(Task task);

    @Delete("DELETE FROM task WHERE id=#{id}")
    boolean delete(int id);
}
