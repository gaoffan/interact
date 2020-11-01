package org.sacc.interact.mapper;

import org.apache.ibatis.annotations.*;
import org.sacc.interact.entity.Ppt;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public interface PptMapper {
    @Select("SELECT * FROM ppt WHERE id=#{id}")
    @Results(id="ppt",value = {
            @Result(column = "lesson_id",property = "lessonId"),
            @Result(column = "file_name",property ="fileName"),
            @Result(column = "created_at",property = "createdTime"),
            @Result(column = "updated_at",property = "updatedTime")
    })
    Ppt getById(int id);//根据id查找并下载pdf

    @Select("SELECT id,lesson_id,file_name,created_at,updated_at FROM ppt")
    @ResultMap(value = "ppt")
    List<Ppt> getAll();//查找所有记录，不提供pdf预览

    @Insert("INSERT INTO ppt (lesson_id,content,file_name,created_at,updated_at) VALUES (#{lessonId},#{content},#{fileName},#{createdTime},#{updatedTime})")
    boolean insert(Ppt ppt);

    @Delete("DELETE FROM ppt WHERE id=#{id}")
    boolean delete(int id);

    @Update("UPDATE ppt SET lesson_id=#{lessonId},content=#{content},file_name=#{fileName},updated_at=#{updatedTime} WHERE id=#{id}")
    boolean update(Ppt ppt);
}
