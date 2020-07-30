package org.sacc.interact.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Result<T> {
    private Integer code;
    private String message;
    private T data;

    public Result(Integer code,String message){
        this.code=code;
        this.message=message;
    }

    public Result(Integer code,T data){
        this.code=code;
        this.data=data;
    }

    public T getData(){
        return data;
    }


    public static <T> Result<T> success(Integer code,T data){
        return new Result<>(code,data);
    }

    public static <T> Result<T> success(Integer code,String message){
        return new Result<>(code,message);
    }

    public static <T> Result<T> error(Integer code,String message){
        return new Result<>(code,message);
    }
}
