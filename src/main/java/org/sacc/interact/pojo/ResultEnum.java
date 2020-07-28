package org.sacc.interact.pojo;

public enum  ResultEnum {

    /**
     *枚举
     */
    SUCCESS(200, "成功!"),
    UNSUPPORTED_MEDIA_TYPE(415,"请求的数据格式不符!"),
    INTERNAL_SERVER_ERROR(500, "服务器内部错误!"),
    NULL_POINT(500,"空指针异常"),
    BAD_REQUEST(400,"错误请求");



    private Integer resultCode;
    private String resultMsg;
    ResultEnum(Integer resultCode, String resultMsg) {
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
    }
    public Integer getResultCode() {
        return resultCode;
    }
    public String getResultMsg() {
        return resultMsg;
    }
}
