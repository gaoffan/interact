package org.sacc.interact.controller;

import org.sacc.interact.entity.Task;
import org.sacc.interact.model.RestResult;
import org.sacc.interact.service.impl.TaskServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class TaskController {
    @Autowired
    private TaskServiceImpl taskServiceImpl;

    @PostMapping("/task/add")
    public RestResult add(@Valid @RequestBody Task task, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return RestResult.error(400,bindingResult.getFieldError().getDefaultMessage());
        }
        if(taskServiceImpl.add(task)){
            return RestResult.success(200,"添加成功");
        }
        return RestResult.error(400,"添加失败");
    }

    @PostMapping("/task/getByGroupId")
    public RestResult<List<Task>> getByGroupId(@RequestParam int groupId){
        List<Task> taskList=taskServiceImpl.getByGroupId(groupId);
        if(taskList==null||taskList.size()==0){
            return RestResult.error(400,"该组没有任务");
        }
        return RestResult.success(200,taskList);
    }

    @PostMapping("/task/updateById")
    public RestResult updateById(@Valid @RequestBody Task task,BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return RestResult.error(200,bindingResult.getFieldError().getDefaultMessage());
        }
        if(taskServiceImpl.update(task)){
            return RestResult.success(200,"更新成功");
        }
        return RestResult.error(400,"该记录不存在");
    }

    @PostMapping("/task/deleteById")
    public RestResult deleteById(@RequestParam int id){
        if(taskServiceImpl.delete(id)){
            return RestResult.success(200,"删除成功");
        }
        return RestResult.error(400,"该记录不存在");
    }
}
