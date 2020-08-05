package org.sacc.interact.pojo;

import com.alibaba.fastjson.JSONObject;
import org.sacc.interact.exception.Business;

public class Result {

    private Integer code;

    private String message;

    private Object data;

    public Result() {
    }

    public Result(ResultEnum resultEnum) {
        this.code = resultEnum.getResultCode();
        this.message = resultEnum.getResultMsg();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    /**
     * 成功
     * @param data
     */
    public static Result success(Object data) {
        Result result = new Result();
        result.setCode(ResultEnum.SUCCESS.getResultCode());
        result.setMessage(ResultEnum.SUCCESS.getResultMsg());
        result.setData(data);
        return result;
    }
    /**
     * 成功
     *
     */
    public static Result success(String message) {
        Result result = new Result();
        result.setCode(ResultEnum.SUCCESS.getResultCode());
        result.setMessage(message);
        result.setData(null);
        return result;
    }

    /**
     * 成功
     */
    public static Result success() {
        return  Result.success(null);
    }
    /**
     * 失败
     * @param resultEnum
     */
    public static Result error(ResultEnum resultEnum) {
        Result result = new Result();
        result.setCode(resultEnum.getResultCode());
        result.setMessage(resultEnum.getResultMsg());
        result.setData(null);
        return result;
    }
    /**
     * 失败
     * @param business
     */
    public static Result error(Business business) {
        Result result = new Result();
        result.setCode(business.getCode());
        result.setMessage(business.getMessage());
        result.setData(null);
        return result;
    }


    /**
     * 失败
     * @param code
     * @param message
     */
    public static Result error(Integer code, String message) {
        Result result = new Result();
        result.setCode(code);
        result.setMessage(message);
        result.setData(null);
        return result;
    }

    /**
     * 失败
     */
    public static Result error( String message) {
        Result result = new Result();
        result.setCode(0);
        result.setMessage(message);
        result.setData(null);
        return result;
    }

    /**
     * 失败或成功
     */
    public static Result state( String message) {
        Result result = new Result();
        result.setCode(1);
        result.setMessage(message);
        result.setData(null);
        return result;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}

