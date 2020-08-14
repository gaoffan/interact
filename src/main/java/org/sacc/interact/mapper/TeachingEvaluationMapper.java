package org.sacc.interact.mapper;

import org.sacc.interact.entity.TeachingEvaluation;
import org.springframework.stereotype.Repository;

@Repository
public interface TeachingEvaluationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TeachingEvaluation record);

    int insertSelective(TeachingEvaluation record);

    TeachingEvaluation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TeachingEvaluation record);

    int updateByPrimaryKey(TeachingEvaluation record);
}
