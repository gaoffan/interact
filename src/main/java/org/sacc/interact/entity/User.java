package org.sacc.interact.entity;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private Integer id;
    private String name;
    private String nick;
    private String studentId;
    private String phoneNumber;
    private String email;
    private String qq;
    protected String password;
    private String avatar;
    //身份 （1root，2讲师，3助教，4部员
    private Integer role;
    private Integer groupId;
    private Date createdAt;
    private Date updatedAt;

}
