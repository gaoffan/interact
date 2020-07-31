package org.sacc.interact.service;

import org.sacc.interact.entity.Lesson;
import org.sacc.interact.mapper.LessonMapper;
import org.sacc.interact.model.RestResult;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class LessonCreatedService implements Service{
    @Autowired
    private LessonMapper mapper;

    @Override
    public RestResult addLesson(Lesson lesson) {
        if(mapper.insert(lesson)){
            return RestResult.success(200,"添加成功");
        }
        else{
            return RestResult.error(400,"添加失败");
        }
    }

    @Override
    public RestResult<List<Lesson>> getByGroupId(int groupId) {
        List<Lesson> lessonList=mapper.getByGroupId(groupId);
        if(lessonList==null||lessonList.size()==0){
            return RestResult.error(400,"该组别不存在");
        }
        else{
            return RestResult.success(200,lessonList);
        }
    }

    @Override
    public RestResult updateLesson(Lesson lesson) {
        if(mapper.update(lesson)){
            return RestResult.success(200,"更新成功");
        }
        else{
            return RestResult.error(400,"更新失败");
        }
    }

    @Override
    public RestResult deleteLesson(int id) {
        if(mapper.delete(id)){
            return RestResult.success(200,"删除成功");
        }
        else{
            return RestResult.error(400,"删除失败");
        }
    }
}
