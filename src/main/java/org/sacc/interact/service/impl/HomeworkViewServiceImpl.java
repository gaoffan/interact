package org.sacc.interact.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.sacc.interact.mapper.HomeworkViewMapper;
import org.sacc.interact.pojo.Homeworkview;
import org.sacc.interact.service.HomeworkViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeworkViewServiceImpl implements HomeworkViewService {

    @Autowired
    HomeworkViewMapper homeworkViewMapper;
    @Override
    public PageInfo getHomeworkSubList(int pageNum,int pageSize,int homeworkID){
        PageHelper.startPage(pageNum, pageSize);
        List<Homeworkview> list=homeworkViewMapper.getHomeworkList(homeworkID);
        return new PageInfo<>(list);
    }

    @Override
    public Homeworkview getHomeworkview(int homeworkId,int userId){
        return homeworkViewMapper.getHomeworkView(homeworkId, userId);
    }
}
