package com.example.usermanage.geteway.eunms;

/**
 * Author wangjinshuai
 * Date 2022/9/2 23:09
 **/
public enum WebResultCodeEnum {

    SUCCESS(1, "成功"),
    FAIL(2, "失败"),
    SERVER_INNER_ERROR(3, "服务端内部异常"),
    ;

    WebResultCodeEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    private Integer code;

    private String desc;

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
