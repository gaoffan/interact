package org.sacc.interact.service;

import org.sacc.interact.entity.Task;

import java.util.List;

public interface TaskService {
    boolean add(Task task);
    List<Task> getByGroupId(int groupId);
    boolean update(Task task);
    boolean delete(int id);
}
