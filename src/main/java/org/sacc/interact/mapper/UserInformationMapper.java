package org.sacc.interact.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.sacc.interact.entity.User;
import org.springframework.stereotype.Repository;

@Mapper
public interface UserInformationMapper {

    User selectUserById(Integer id);

    void updateUser(User user);

    void updateUserPassword(User user);

}
