package org.sacc.interact.service.impl;

import org.sacc.interact.mapper.HomeworkCheckMapper;
import org.sacc.interact.pojo.RemarkParam;
import org.sacc.interact.service.HomeworkCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomeworkCheckServiceImpl implements HomeworkCheckService {

    @Autowired
    HomeworkCheckMapper homeworkCheckMapper;

    @Override
    public int remarkHomework(RemarkParam remarkParam) {
        System.out.println(remarkParam);
        return homeworkCheckMapper.remarkHomework(remarkParam);
    }

    @Override
    public int setExcellentWork(int submissionId) {
        return homeworkCheckMapper.setExcellent(submissionId);
    }
}
