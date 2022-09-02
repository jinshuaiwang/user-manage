package com.example.usermanage.geteway.param;

import com.example.usermanage.geteway.eunms.WebResultCodeEnum;

/**
 * Author wangjinshuai
 * Date 2022/9/2 23:02
 **/
public class WebResult {

    private boolean success; // 成功失败标示位，便于前端判断使用

    /**
     * @see WebResultCodeEnum
     */
    private int code; // 1 成功 2 失败 其他异常码持续补充

    private String message; // 失败原因

    public WebResult(boolean success, int code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }

    public static WebResult fail(int code, String message) {
        return new WebResult(false, code, message);
    }

    public static WebResult success() {
        return new WebResult(true, WebResultCodeEnum.SUCCESS.getCode(), null);
    }

    public boolean isSuccess() {
        return success;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
