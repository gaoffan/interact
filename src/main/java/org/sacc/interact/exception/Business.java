package org.sacc.interact.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Business {
    USER_EXIST(1000,"用户已存在")
    ,
    INTERNAL_SERVER_ERROR(500,"服务器异常")
    ,
    NOT_EFFECTIVE(1001,"现在不在提交时间")
    ,
    GROUP_ID_NOT_EXIST(1002,"该group_id不存在")
    ,
    LESSON_ID_NOT_EXIST(1003,"该lesson_id不存在")
    ,
    PASSWORD_ERROR(1004,"密码错误");
    ;
    private int code;
    private String message;
}
