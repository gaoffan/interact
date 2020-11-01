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
    public boolean updateAvatar(String avatarPath, String userId) {
        return  userMapper.updateAvatar(avatarPath,userId);

    }
}
