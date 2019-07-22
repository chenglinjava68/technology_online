package com.learning.model;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class User {
    /*
            {id} 自增主键
            {userName} 用户姓名
            {userNickName} 用户昵称
            {password} 用户密码
            {userMail} 用户邮箱
            {userPhone} 用户电话
            {userPower} 用户权限
            {userStatus} 用户状态
         */
    private int id;
    @NotNull(message = "用户名不能为空")
    @Length(min = 3, max = 15, message = "姓名必须在3到15位之间")
    @Pattern(regexp = "^[a-zA-Z0-9_]+$", message = "用户名存在非法的字符")
    private String userName;
    @NotNull(message = "用户昵称不能为空")
    @Length(min = 3, max = 30, message = "姓名必须在3到30位之间")
    @Pattern(regexp = "^[\u4e00-\u9fa5a-z0-9_]+$", message = "用户昵称存在非法的字符")
    private String userNickName;
    @NotNull(message = "密码不能为空")
    private String password;
    @NotNull(message = "邮箱不能为空")
    @Email(message = "邮箱格式不正确")
    private String userMail;
    @Pattern(regexp = "^1(3|4|5|6|7|8|9)\\d{9}$", message = "请输入正确的手机号")
    private String userPhone;
    private int userPower;
    private boolean userStatus;
    private String picName;
    private String userPicUrl;
    private String userPicDelUrl;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserNickName() {
        return userNickName;
    }

    public void setUserNickName(String userNickName) {
        this.userNickName = userNickName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public int getUserPower() {
        return userPower;
    }

    public void setUserPower(int userPower) {
        this.userPower = userPower;
    }

    public boolean isUserStatus() {
        return userStatus;
    }

    public void setUserStatus(boolean userStatus) {
        this.userStatus = userStatus;
    }

    public String getPicName() {
        return picName;
    }

    public void setPicName(String picName) {
        this.picName = picName;
    }

    public String getUserPicUrl() {
        return userPicUrl;
    }

    public void setUserPicUrl(String userPicUrl) {
        this.userPicUrl = userPicUrl;
    }

    public String getUserPicDelUrl() {
        return userPicDelUrl;
    }

    public void setUserPicDelUrl(String userPicDelUrl) {
        this.userPicDelUrl = userPicDelUrl;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userNickName='" + userNickName + '\'' +
                ", password='" + password + '\'' +
                ", userMail='" + userMail + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userPower=" + userPower +
                ", userStatus=" + userStatus +
                ", picName='" + picName + '\'' +
                ", userPicUrl='" + userPicUrl + '\'' +
                ", userPicDelUrl='" + userPicDelUrl + '\'' +
                '}';
    }
}
