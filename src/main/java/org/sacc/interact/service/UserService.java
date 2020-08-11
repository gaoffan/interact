package org.sacc.interact.service;

import org.apache.ibatis.annotations.Update;
import org.sacc.interact.model.UserRegisterParam;

public interface UserService {
    boolean register(UserRegisterParam userRegisterParam);
    boolean updateavatar(String avatarpath,String username);
}
