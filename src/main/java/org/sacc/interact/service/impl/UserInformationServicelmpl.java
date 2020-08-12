package org.sacc.interact.service.impl;

import org.sacc.interact.entity.DoPassword;
import org.sacc.interact.entity.User;
import org.sacc.interact.mapper.UserInformationMapper;
import org.sacc.interact.service.UserInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInformationServicelmpl implements UserInformationService {
    DoPassword password;
    Boolean aBoolean=false;
    @Autowired
    UserInformationMapper userInformationMapper;
    public boolean verify(String formerPassword,Integer id){
        password.setUser(userInformationMapper.selectUserById(id));
        if(password.getPassword().equals(formerPassword)) {
            aBoolean=true;
        }
        return aBoolean;
    }
    public boolean updatePassword(String FirstIn, String SecondIn) {
        if(FirstIn.equals(SecondIn)&&aBoolean){
            userInformationMapper.updateUserPassword(password.setPassword(FirstIn));
            aBoolean=false;
            return true;
        }
        else return false;
    }
    public void updateInformation(User user){
        userInformationMapper.updateUser(user);
    }
    public User selectUserById(int id){
        return userInformationMapper.selectUserById(id);
    }
}
