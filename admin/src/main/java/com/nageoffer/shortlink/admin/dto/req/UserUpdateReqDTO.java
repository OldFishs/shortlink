package com.nageoffer.shortlink.admin.dto.req;


import lombok.Data;

/**
 * 用户修改请求参数
 */
@Data
public class UserUpdateReqDTO {

    /**
     * id
     */
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 电子邮箱
     */
    private String mail;
}
