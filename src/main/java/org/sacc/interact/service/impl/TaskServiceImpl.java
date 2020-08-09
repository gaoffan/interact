package org.sacc.interact.service.impl;

import org.sacc.interact.entity.Task;
import org.sacc.interact.mapper.TaskMapper;
import org.sacc.interact.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskMapper taskMapper;

    @Override
    public boolean add(Task task) {
        task.setCreatedTime(LocalDateTime.now());
        task.setUpdatedTime(LocalDateTime.now());
        if(taskMapper.insert(task)){
            return true;
        }
        return false;
    }

    @Override
    public List<Task> getByGroupId(int groupId) {
        return taskMapper.selectByGroupId(groupId);
    }

    @Override
    public boolean update(Task task) {
        task.setUpdatedTime(LocalDateTime.now());
        if(taskMapper.update(task)){
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        if(taskMapper.delete(id)){
            return true;
        }
        return false;
    }
}
