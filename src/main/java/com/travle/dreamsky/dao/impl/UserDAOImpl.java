package com.travle.dreamsky.dao.impl;

import com.travle.dreamsky.dao.UserDAO;
import com.travle.dreamsky.domain.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDAOImpl implements UserDAO{

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<UserInfo> findAllMongo() {

        UserInfo userInfo = new UserInfo();
        userInfo.setUserId("33333");
        userInfo.setUserName("haha2");
        userInfo.setPassWord("mima2");
        userInfo.setAddress("pafc2");
        mongoTemplate.save(userInfo);
        return mongoTemplate.findAll(UserInfo.class);
    }
}
