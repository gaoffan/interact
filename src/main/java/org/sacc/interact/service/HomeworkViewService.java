package org.sacc.interact.service;

import com.github.pagehelper.PageInfo;
import org.sacc.interact.pojo.Homeworkview;

public interface HomeworkViewService {
    public PageInfo getHomeworkSubList(int pageNum, int pageSize, int homeworkID);
    public Homeworkview getHomeworkview(int submissionId);
    public int checkType(Homeworkview homeworkview);
    }
