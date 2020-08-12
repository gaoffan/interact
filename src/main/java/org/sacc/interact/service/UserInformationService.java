package org.sacc.interact.service;

import org.sacc.interact.entity.User;

public interface UserInformationService {
    boolean updatePassword(String FirstIn,String SecondIn);
    User selectUserById(int id);
    void updateInformation(User user);
    boolean verify(String formerPassword,Integer id);
}
