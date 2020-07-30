package org.sacc.interact.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;

@Data
@ApiModel("用户注册参数")
public class UserRegisterParam {
    @ApiModelProperty("邮箱")
    @Email
    private String email;
    @ApiModelProperty("密码")
    @Length(min = 8, max=20)
    private String password;
    @ApiModelProperty("昵称")
    @Length(min = 3, max=255)
    private String nick;
}
