package com.nageoffer.shortlink.admin.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.nageoffer.shortlink.admin.dao.entity.UserDO;
import com.nageoffer.shortlink.admin.dto.req.UserRegisterReqDTO;
import com.nageoffer.shortlink.admin.dto.resp.UserRespDTO;
import org.springframework.stereotype.Service;

/**
 *
 * 用户接口层
 **/
@Service
public interface UserService extends IService<UserDO> {

    /**
     * 根据用户名查询用户信息
     *
     * @param username 用户名
     * @return 用户返回实体
     **/

    UserRespDTO getUserByUsername(String username);

    /**
     * 查询用户名是否存在
     *
     * @param username 用户名
     * @return 存在返回true 不存在返回false
     **/

    Boolean hasUsername(String username);

    /**
     * 查询用户名是否存在
     *
     * @param registerParam 注册用户请求参数
     **/
    void register(UserRegisterReqDTO registerParam);


}
