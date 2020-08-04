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
    NOT_EFFECTIVE(405,"现在不在提交时间")
    ,
    GROUP_ID_NOT_EXIST(406,"该group_id不存在")
    ,
    LESSON_ID_NOT_EXIST(407,"该lesson_id不存在")
    ;
    private int code;
    private String message;
}
