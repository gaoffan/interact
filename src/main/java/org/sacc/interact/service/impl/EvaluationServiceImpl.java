package org.sacc.interact.service.impl;

import org.sacc.interact.entity.Anonymous;
import org.sacc.interact.entity.TeachingEvaluation;
import org.sacc.interact.exception.Business;
import org.sacc.interact.exception.BusinessException;
import org.sacc.interact.mapper.AnonymousMapper;
import org.sacc.interact.mapper.TeachingEvaluationMapper;
import org.sacc.interact.service.EvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by 林夕
 * Date 2020/8/10 9:46
 */
@Service
public class EvaluationServiceImpl implements EvaluationService {

    @Autowired
    private TeachingEvaluationMapper evaluationMapper;

    @Autowired
    private AnonymousMapper anonymousMapper;

    @Override
    public boolean evaluation(Integer lessonId, String remark, Integer userId) {
        System.out.println("--------------------------------------------------");
        TeachingEvaluation evaluation = new TeachingEvaluation(lessonId,remark);
        Anonymous anonymous = new Anonymous();

        anonymous.setLessonId(lessonId);
        anonymous.setUserId(userId);
        anonymous.setCreatedAt(new Date());
        int i = anonymousMapper.insert(anonymous);

        evaluation.setCreatedAt(new Date());
        evaluation.setUpdatedAt(new Date());
        int j = evaluationMapper.insert(evaluation);
        if(i==1&&j==1){
            return true;
        }
        else throw new BusinessException(Business.INTERNAL_SERVER_ERROR);
    }
}
