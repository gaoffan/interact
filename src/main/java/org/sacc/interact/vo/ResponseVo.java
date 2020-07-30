package org.sacc.interact.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * Created by 林夕
 * Date 2020/7/26 22:27
 */

@Data
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class ResponseVo<T> {

    private Integer status;

    private String msg;

    private T data;

    private ResponseVo(Integer status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    private ResponseVo(Integer status, T data) {
        this.status = status;
        this.data = data;
    }

    public static <T> ResponseVo<T> success(T data){
        return new ResponseVo<>(0,data);
    }

    public static <T> ResponseVo<T> success(){
        return new ResponseVo<>(0,"success");
    }

    public static <T>ResponseVo<T> error(){
        return new ResponseVo<>(-1,"error");
    }

    public static <T>ResponseVo<T> error(String msg){
        return new ResponseVo<T>(-1,msg);
    }
}
