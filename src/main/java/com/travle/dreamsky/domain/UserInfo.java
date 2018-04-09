package com.travle.dreamsky.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;
@Document
/**
 * @Description
 * @param
 * @return
 */
public class UserInfo implements Serializable{
    @Id
    private String userId;
    private String userName;
    private String passWord;
    private Date birthday;
    private String sex;
    private String phone;
    private String address;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "UserInfo{" + "userId='" + userId + '\'' + ", userName='" + userName + '\'' + ", passWord='" + passWord + '\'' + ", birthday=" + birthday + ", sex='" + sex + '\'' + ", phone='" + phone + '\'' + ", address='" + address + '\'' + '}';
    }
}
