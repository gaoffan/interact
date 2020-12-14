package org.sacc.interact.service.impl;

import org.sacc.interact.entity.User;
import org.sacc.interact.exception.Business;
import org.sacc.interact.exception.BusinessException;
import org.sacc.interact.mapper.UserMapper;
import org.sacc.interact.model.UserInfo;
import org.sacc.interact.model.UserRegisterParam;
import org.sacc.interact.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService,UserDetailsService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userMapper.selectByEmail(s);
        if(user == null){
            throw new UsernameNotFoundException(s);
        }
        return new UserInfo(user);
    }

    @Override
    public boolean register(UserRegisterParam userRegisterParam) {
        if(userMapper.selectByEmail(userRegisterParam.getEmail()) != null){
            throw new BusinessException(Business.USER_EXIST);
        }
        userRegisterParam.setPassword(passwordEncoder.encode(userRegisterParam.getPassword()));
        userMapper.insert(userRegisterParam);
        return true;
    }

    @Override
    public boolean updateAvatar(String avatarPath, Integer userId) {
        return  userMapper.updateAvatar(avatarPath,userId);

    }

    @Override
    public boolean changePassword(Integer userId,String oldPassword,String newPassword) {
        newPassword=passwordEncoder.encode(newPassword);
        if(passwordEncoder.matches(oldPassword,userMapper.selectById(userId).getPassword())) {
            return userMapper.changePassword(userId, newPassword);
        }
        return false;
    }

    @Override
    public UserDetails getUserById(Integer userId) {
        User user = userMapper.selectById(userId);
        if(user == null) {
            throw new UsernameNotFoundException("");
        }
        return new UserInfo(user);
    }

    @Override
    public boolean changeEmail(Integer id, String oldEmail, String newEmail,String password) {
        if(password==null||!passwordEncoder.matches(password,userMapper.selectById(id).getPassword()))
            throw new BusinessException(Business.PASSWORD_ERROR);
        if(oldEmail.equals(userMapper.selectById(id).getEmail())){
            return userMapper.changeEmail(id,newEmail);
        }
        return false;
    }

    @Override
    public boolean changeInfo(Integer id, String nickname, String name, String studentId, Integer groupId) {
        if(nickname!=null)
            userMapper.changeNick(id,nickname);
        if(name!=null)
            userMapper.changeName(id,name);
        if(studentId!=null)
            userMapper.changeStudentId(id,studentId);
        if(groupId!=null)
            userMapper.changeGroupId(id,groupId);
        return nickname!=null || name!=null || studentId!=null || groupId != null;
    }
}
