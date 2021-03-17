package org.sacc.interact.model;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

/**
 * Created by 林夕
 * Date 2020/12/14 21:46
 */
@Data
public class ChangePasswordAndEmailForm {
    private String oldPassword;

    @Length(min = 8,max = 20)
    private String newPassword;

    private String password;

    private String oldEmail;

    private String newEmail;
}
