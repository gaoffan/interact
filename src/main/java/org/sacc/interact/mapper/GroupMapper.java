package org.sacc.interact.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.sacc.interact.entity.Group;

import java.util.List;
@Mapper
public interface GroupMapper {
     @Select("SELECT * FROM `group` ")
     List<Group> checkgroup();
}
