package org.sacc.interact.controller;

import org.sacc.interact.entity.Homework;
import org.sacc.interact.model.RestResult;
import org.sacc.interact.service.HomeworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * Created by 林夕
 * Date 2020/7/25 21:28
 */
@Controller
public class HomeworkController {

    @Autowired
    private HomeworkService homeworkService;

    @GetMapping("/homework/lesson")
    @ResponseBody
    public RestResult<Homework> ShowLessonHomework(@RequestParam("lessonId") Integer lessonId){
        if(lessonId!=null)
            return homeworkService.findByLessonId(lessonId);
        else
            return RestResult.error(-1,"未传入参数");
    }

    @GetMapping("/homework/group")
    @ResponseBody
    public RestResult<List<Homework>> ShowGroupHomework(@RequestParam("groupId") Integer groupId){
        if(groupId!=null)
            return homeworkService.findByGroupId(groupId);
        else
            return RestResult.error(-1,"未传入参数");
    }

    @PostMapping("/homework/publish")
    @ResponseBody
    public RestResult PublishHomework(@Valid @RequestBody Homework homework, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return RestResult.error(-1,Objects.requireNonNull(bindingResult.getFieldError()).getField()+
                    bindingResult.getFieldError().getDefaultMessage());
        }
        else{
            homework.setCreatedAt(new Date());
            homework.setUpdatedAt(new Date());
            return homeworkService.publish(homework);
        }
    }
    @PostMapping("/homework/update")
    @ResponseBody
    public RestResult update(@RequestBody Homework homework){
        homework.setUpdatedAt(new Date());
        return homeworkService.update(homework);
    }
}
