package org.sacc.interact.mapper;

import org.sacc.interact.entity.Anonymous;
import org.springframework.stereotype.Repository;

@Repository
public interface AnonymousMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Anonymous record);

    int insertSelective(Anonymous record);

    Anonymous selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Anonymous record);

    int updateByPrimaryKey(Anonymous record);
}
