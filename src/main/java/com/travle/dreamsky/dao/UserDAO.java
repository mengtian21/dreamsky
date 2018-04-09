package com.travle.dreamsky.dao;

import com.travle.dreamsky.domain.UserInfo;

import java.util.List;

public interface UserDAO {
    public List<UserInfo> findAllMongo();
}
