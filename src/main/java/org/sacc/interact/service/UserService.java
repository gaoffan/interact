package org.sacc.interact.service;

import org.apache.ibatis.annotations.Update;
import org.sacc.interact.model.UserRegisterParam;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserService {
    boolean register(UserRegisterParam userRegisterParam);
    boolean updateAvatar(String avatarPath,Integer userId);
    boolean changePassword(Integer id,String oldPassword,String newPassword);
    UserDetails getUserById(Integer userId);
    boolean changeEmail(Integer id,String oldEmail,String newEmail);
    boolean changeInfo(Integer id,String nickname,String name,String studentId,Integer groupId);
}
