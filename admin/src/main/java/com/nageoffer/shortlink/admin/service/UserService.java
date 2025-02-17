package com.nageoffer.shortlink.admin.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.nageoffer.shortlink.admin.dao.entity.UserDO;
import com.nageoffer.shortlink.admin.dto.req.UserLoginReqDTO;
import com.nageoffer.shortlink.admin.dto.req.UserRegisterReqDTO;
import com.nageoffer.shortlink.admin.dto.req.UserUpdateReqDTO;
import com.nageoffer.shortlink.admin.dto.resp.UserLoginRespDTO;
import com.nageoffer.shortlink.admin.dto.resp.UserRespDTO;
import org.apache.ibatis.annotations.Param;
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
    void register(@Param("registerParam") UserRegisterReqDTO registerParam);

    /**
     * 根据用户名修改用户
     *
     * @param requestParam 修改用户请求参数
     **/
    void update(UserUpdateReqDTO requestParam);

    /**
     * 用户登录
     *
     * @return 用户登录返回参数 Token
     **/
    UserLoginRespDTO login(UserLoginReqDTO requestParam);

    /**
     * 检查用户是否登录
     *
     * @param username 用户名
     * @param token 用户登录token
     * @return 用户是否登录标识
     **/
    Boolean checkLogin(String username,String token);

    /**
     * 用户退出登录
     *
     * @param username 用户名
     * @param token 用户登录token
     **/
    void logout(String username, String token);
}
