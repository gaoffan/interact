package org.sacc.interact.controller;


import org.sacc.interact.entity.Lesson;
import org.sacc.interact.model.RestResult;
import org.sacc.interact.service.impl.LessonCreatedServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class LessonCreatedController {
    private LessonCreatedServiceImpl service;

    @Autowired
    public LessonCreatedController(LessonCreatedServiceImpl service){
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
            return  service.addLesson(lesson);
        }
    }

    @PostMapping("/lesson/update")
    public RestResult<List<Lesson>> update(@Valid @RequestBody Lesson lesson,BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return RestResult.error(400,bindingResult.getFieldError().getDefaultMessage());
        }
        else{
            service.updateLesson(lesson);
            return service.getByGroupId(lesson.getGroupId());
        }
    }

    @PostMapping("/lesson/delete")
    public RestResult delete(@RequestParam("id") int id){
        return service.deleteLesson(id);
    }
}
