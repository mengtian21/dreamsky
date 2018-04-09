package com.travle.dreamsky.web;

import com.alibaba.fastjson.JSONObject;
import com.travle.dreamsky.domain.UserInfo;
import com.travle.dreamsky.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")

public class UserController {

    @Autowired
    private UserService userService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/hello")
    public String sayHello() {
        return "hello world!！！";
    }

    @RequestMapping("/register")
    public String register(@RequestParam String requestJson){

        if(null == requestJson){
            return null;
        }

        logger.info("请求入参：" + requestJson);
        UserInfo userInfo = JSONObject.parseObject(requestJson,UserInfo.class);
        System.out.println(userInfo.toString());
        return userInfo.toString();
    }
    @RequestMapping("/find")
    public void findAll(){
        List<UserInfo> userInfoList = userService.findAll();
        for(UserInfo user: userInfoList){
            System.out.println(user.getUserName());
            System.out.println(user.getPassWord());
            System.out.println(user.getPhone());
        }
    }

    @RequestMapping("/find2")
    public void findById(){
        UserInfo userInfo = userService.findById("111");
        System.out.println(userInfo.getUserName());
        System.out.println(userInfo.getPassWord());
        System.out.println(userInfo.getPhone());
    }
    @RequestMapping("/findAllMongo")
    public void findAllMongo(){
        List<UserInfo> userInfoList = userService.findAllMongo();
        for(UserInfo user: userInfoList){
            System.out.println(user.getUserId());
            System.out.println(user.getUserName());
            System.out.println(user.getPassWord());
            System.out.println(user.getAddress());
            System.out.println(user.getPhone());
        }
    }
}
