package com.example.usermanage.server.service.exception;

/**
 * Author wangjinshuai
 * Date 2022/9/2 18:56
 **/
public class BizException extends RuntimeException {

    public BizException() {
        super();
    }

    public BizException(String message) {
        super(message);
    }

    public BizException(String message, Throwable cause) {
        super(message, cause);
    }
}
