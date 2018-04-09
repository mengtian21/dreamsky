package com.travle.dreamsky.service;

import com.travle.dreamsky.domain.UserInfo;

import java.util.List;
import java.util.Map;

public interface UserService {
    /**
     * 用户注册
     */
    public String register(Map<String, Object> paramsMap);

    /**
     * 用户登录
     */
    public String login(Map<String, Object> paramsMap);

    /**
     * 用户注销
     */
    public String destroy(Map<String, Object> paramsMap);

    /**
     * 用户查询
     */
    public List<UserInfo> findAll();

    /**
     * 用户查询
     */
    public UserInfo findById(String userId);

    /**
     * 查询mongodb
     */
    public List<UserInfo> findAllMongo();

}
