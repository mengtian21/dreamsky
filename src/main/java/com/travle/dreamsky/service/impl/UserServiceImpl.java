package com.travle.dreamsky.service.impl;

import com.travle.dreamsky.dao.UserDAO;
import com.travle.dreamsky.domain.UserInfo;
import com.travle.dreamsky.mapper.UserMapper;
import com.travle.dreamsky.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired(required=false)
    private UserMapper userMapper;

    @Autowired
    private UserDAO userDAO;

    /**
     * 用户注册
     * @param paramsMap
     * @return
     */
    @Override
    public String register(Map<String, Object> paramsMap) {
        return null;
    }

    /**
     * 用户登录
     * @param paramsMap
     * @return
     */
    @Override
    public String login(Map<String, Object> paramsMap) {
        return null;
    }

    /**
     * 用户注销
     * @param paramsMap
     * @return
     */
    @Override
    public String destroy(Map<String, Object> paramsMap) {
        return null;
    }

    /**
     * 查询用户
     */
    public List<UserInfo> findAll() {
        return userMapper.findAll();
    }

    @Override
    public UserInfo findById(String userId) {
        UserInfo user = new UserInfo();
        user.setUserId(userId);
        return userMapper.findById(user);
    }

    @Override
    public List<UserInfo> findAllMongo() {
        return userDAO.findAllMongo();
    }
}
