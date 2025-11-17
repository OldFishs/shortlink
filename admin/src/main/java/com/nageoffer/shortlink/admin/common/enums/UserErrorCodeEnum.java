package com.nageoffer.shortlink.admin.common.enums;

import com.nageoffer.shortlink.admin.common.convention.errorcode.IErrorCode;

public enum UserErrorCodeEnum implements IErrorCode {

    USER_NUll("B00200","用户记录不存在"),

    USER_NAME_EXIST("B00201","用户名已存在"),

    USER_EXIST("B00202","用户记录已存在"),

//    USER_SAVE_EXIST("B00203","用户记录新增失败"),

    USER_HAS_LOGIN("B20004","用户已登录"),

    USER_NOEXIST_NOLOGIN("B20005","用户Token不存在或用户未登录"),

    USER_TOKEN_FAIL("A000200","Token验证失败"),

    USER_SAVE_ERROR("B000203", "用户记录新增失败");

    private final String code;

    private final String message;

    UserErrorCodeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String code() {
        return code;
    }

    @Override
    public String message() {
        return message;
    }
}
