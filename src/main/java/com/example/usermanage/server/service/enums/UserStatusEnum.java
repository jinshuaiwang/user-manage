package com.example.usermanage.server.service.enums;

/**
 * Author wangjinshuai
 * Date 2022/9/2 20:58
 **/
public enum UserStatusEnum {

    NORMAL(1, "正常用户"),
    DELETED(2, "已删除"),
    ;

    UserStatusEnum(Integer status, String desc) {
        this.status = status;
        this.desc = desc;
    }

    private Integer status;

    private String desc;

    public Integer getStatus() {
        return status;
    }

    public String getDesc() {
        return desc;
    }
}
