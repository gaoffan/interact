package org.sacc.interact.controller;


import org.sacc.interact.entity.Lesson;
import org.sacc.interact.service.LessonCreatedService;
import org.sacc.interact.model.RestResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@RestController
public class LessonCreatedController {
    private LessonCreatedService service;

    @Autowired
    public LessonCreatedController(LessonCreatedService service){
        this.service=service;
    }

    @PostMapping("/lesson/getByGroupId")
    public RestResult<List<Lesson>> getByGroupId(@RequestParam("groupId") int groupId){
        return service.getByGroupId(groupId);
    }

    @PostMapping("/lesson/addLesson")
    public RestResult insert(@Valid @RequestBody Lesson lesson, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return RestResult.error(400, bindingResult.getFieldError().getDefaultMessage());
        }
        else{
            lesson.setCreatedTime(LocalDateTime.now());
            lesson.setUpdatedTime(LocalDateTime.now());
            return  service.addLesson(lesson);
        }
    }

    @PostMapping("/lesson/update")
    public RestResult<List<Lesson>> update(@Valid @RequestBody Lesson lesson, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return RestResult.error(400,bindingResult.getFieldError().getDefaultMessage());
        }
        else{
            lesson.setUpdatedTime(LocalDateTime.now());
            service.updateLesson(lesson);
            return service.getByGroupId(lesson.getGroupId());
        }
    }

    @PostMapping("/lesson/delete")
    public RestResult delete(@RequestParam("id") int id){
        return service.deleteLesson(id);
    }
}
