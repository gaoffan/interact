package org.sacc.interact.mapper;

import org.apache.ibatis.annotations.*;
import org.sacc.interact.pojo.Homeworkview;

import java.util.List;

@Mapper
public interface HomeworkViewMapper {

    @Select("SELECT (id,user_id,homework_id,is_show,remark,created_at,updated_at) FROM homework_submission WHERE homework_id=#{homeworkId} AND  ORDER BY updated_at DESC")
    @Results({
            @Result(column="id", property="id"),
            @Result(column="user_id", property="userId"),
            @Result(column="homework_id", property="homeworkId"),
            @Result(column="is_show",property="isShow"),
            @Result(column="remark",property="remark"),
            @Result(column="created_at", property="createTime"),
            @Result(column="updated_at", property="updateTime"),
    })
    List<Homeworkview> getHomeworkList(int homeworkId);

    @Select("SELECT * FROM homework_submission WHERE id=#{submissionId}")
    @Results({
            @Result(column="id", property="id"),
            @Result(column="user_id", property="userId"),
            @Result(column="content", property="content"),
            @Result(column="homework_id", property="homeworkId"),
            @Result(column="is_show",property="isShow"),
            @Result(column="remark",property="remark"),
            @Result(column="created_at", property="createTime"),
            @Result(column="updated_at", property="updateTime"),
    })
    Homeworkview getHomeworkView(@Param("submissionId") int submissionId);
}