package org.sacc.interact.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Business {
    USER_EXIST(1000,"用户已存在")
    ;
    private int code;
    private String message;
}
