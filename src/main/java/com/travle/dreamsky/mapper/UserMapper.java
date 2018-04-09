package com.travle.dreamsky.mapper;

import com.travle.dreamsky.domain.UserInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    /**
     * 用户注册
     */
    public int register(UserInfo userInfo);

    /**
     * 用户登录
     */
    public String login(UserInfo userInfo);

    /**
     * 查询用户
     */
    public List<UserInfo> findAll();

    /**
     * 查询用户
     */
    public UserInfo findById(UserInfo userInfo);

    /**
     * 用户注销
     */
    public void destroy(UserInfo userInfo);
}
