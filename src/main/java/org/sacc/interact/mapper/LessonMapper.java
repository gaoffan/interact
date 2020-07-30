package org.sacc.interact.mapper;

import org.apache.ibatis.annotations.*;
import org.sacc.interact.entity.Lesson;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

@Repository
public interface LessonMapper {
    @Select("SELECT * FROM lesson WHERE group_id=#{groupId}")
    @Results(id="lesson",value= {
            @Result(column = "group_id", property = "groupId"),
            @Result(column = "live_url", property = "liveUrl"),
            @Result(column = "created_at",property = "createdTime"),
            @Result(column = "updated_at",property = "updatedTime")
    })
    List<Lesson> getByGroupId(int groupId);

    //主键id设置自动递增
    @Insert({"INSERT INTO lesson (name,group_id,`desc`,time,location,type,live_url,created_at,updated_at) VALUES (#{name},#{groupId},#{desc},#{time},#{location},#{type},#{liveUrl},#{createdTime},#{updatedTime})"})
    boolean insert(Lesson lesson);

    @Update({"UPDATE lesson SET name=#{name},group_id=#{groupId},`desc`=#{desc},time=#{time},location=#{location},type=#{type},live_url=#{liveUrl},created_at=#{createdTime},updated_at=#{updatedTime} WHERE id=#{id}"})
    boolean update(Lesson lesson);

    @Delete("DELETE FROM lesson WHERE id=#{id}")
    boolean delete(int id);

}
