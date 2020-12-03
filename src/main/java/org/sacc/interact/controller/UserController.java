package org.sacc.interact.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.sacc.interact.entity.User;
import org.sacc.interact.model.RestResult;
import org.sacc.interact.model.UserInfo;
import org.sacc.interact.model.UserRegisterParam;
import org.sacc.interact.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author gaofan
 */
@RestController
@Api("用户")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation("用户注册")
    @PostMapping("/register")
    public RestResult<Boolean> register(@RequestBody @Validated UserRegisterParam userRegisterParam){
        return RestResult.success(userService.register(userRegisterParam));
    }

    @ApiOperation("用户信息")
    @GetMapping("/info")
    public RestResult<User> getUserInfo(Authentication authentication){
        UserInfo userInfo = (UserInfo)authentication.getPrincipal();
        // 隐藏密码等敏感信息
        userInfo.setPassword("n/a");
        userInfo.setPhoneNumber("n/a");
        return RestResult.success(userInfo);
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/test")
    public RestResult<Void> test(Authentication authentication){
        return RestResult.success(null);
    }


    @ApiOperation("头像上传")
    @PostMapping("/avatarUpload")
    public RestResult avatarUp(@RequestParam("avatar")MultipartFile file,Authentication authentication){
        if(file==null){
            return RestResult.error(404,"文件为空");
        }
        String filename=file.getOriginalFilename();
        String rootPath="";
        File avatar=new File(rootPath+filename);
        try {
            file.transferTo(avatar);
            UserInfo userInfo = (UserInfo)authentication.getPrincipal();
            Integer userId = userInfo.getId();
            userService.updateAvatar(avatar.toString(),userId);
            return RestResult.success(200,"上传成功");
        }catch (IOException e){
            e.printStackTrace();
        }
        return RestResult.error(404,"上传失败");
    }

    @PostMapping("/changePassword")
    public RestResult<Boolean> changePassword(@RequestParam("password") String password,
                                           Authentication authentication){
        UserInfo userInfo = (UserInfo)authentication.getPrincipal();
        return RestResult.success(userService.changePassword(userInfo.getId(),password));
    }
}
