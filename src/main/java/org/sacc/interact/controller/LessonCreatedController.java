package org.sacc.interact.controller;


import org.apache.ibatis.annotations.Param;
import org.sacc.interact.entity.Lesson;
import org.sacc.interact.service.LessonCreatedService;
import org.sacc.interact.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@RestController
public class LessonCreatedController {
    private LessonCreatedService service;

    @Autowired
    public LessonCreatedController(LessonCreatedService service){
        this.service=service;
    }

    @PostMapping("/lesson/getByGroupId")
    public Result<List<Lesson>> getByGroupId(@RequestParam("groupId") int groupId){
        return service.getByGroupId(groupId);
    }

    @PostMapping("/lesson/addLesson")
    public Result insert(@Valid @RequestBody Lesson lesson, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return Result.error(400, bindingResult.getFieldError().getDefaultMessage());
        }
        else{
            lesson.setCreatedTime(LocalDateTime.now());
            lesson.setUpdatedTime(LocalDateTime.now());
            return  service.addLesson(lesson);
        }
    }

    @PostMapping("/lesson/update")
    public Result<List<Lesson>> update(@Valid @RequestBody Lesson lesson,BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return Result.error(400,bindingResult.getFieldError().getDefaultMessage());
        }
        else{
            lesson.setUpdatedTime(LocalDateTime.now());
            service.updateLesson(lesson);
            return service.getByGroupId(lesson.getGroupId());
        }
    }

    @PostMapping("/lesson/delete")
    public Result delete(@RequestParam("id") int id){
        return service.deleteLesson(id);
    }
}
