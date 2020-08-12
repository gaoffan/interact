package org.sacc.interact.controller;

import org.sacc.interact.entity.User;
import org.sacc.interact.model.RestResult;
import org.sacc.interact.service.UserInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserInformationController {
    @Autowired
    UserInformationService userInformationService;
    @GetMapping("/toUpdateI/{id}")
    public RestResult toUpdateInfomation(@PathVariable("id")Integer id){
        return RestResult.success(userInformationService.selectUserById(id));
    }

    @GetMapping("/toUpdateP/{id}")
    public RestResult toUpdatePassword(@PathVariable("id")Integer id){
        return RestResult.success(userInformationService.selectUserById(id));
    }

    @PostMapping("/updateInformation")
    public RestResult updateInformation(User user){
        userInformationService.updateInformation(user);
        return RestResult.success(200,"修改成功");
    }
    @PostMapping("/updatePassword")
    public RestResult updatePassoword(String formerPassword,String FirstIn,String SecondIn,@RequestParam("id")Integer id){
        if(!userInformationService.verify(formerPassword,id))
            return RestResult.error(400,"输入的原密码不正确");
        if(userInformationService.updatePassword(FirstIn,SecondIn))
            return RestResult.success(200,"修改密码成功");
        else
            return RestResult.error(400,"两次输入的新密码不一样");
    }
}
