package com.learning.model;

public class UserAvatar {
    private String userName;
    private String userPicUrl;
    private String userPicDelUrl;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userId) {
        this.userName = userName;
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
        return "UserAvatar{" +
                "userName=" + userName +
                ", userPicUrl='" + userPicUrl + '\'' +
                ", userPicDelUrl='" + userPicDelUrl + '\'' +
                '}';
    }
}
