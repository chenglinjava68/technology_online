package com.learning.service;
import com.learning.dao.UserDao;
import com.learning.model.User;
import com.learning.util.EncodeAndDecode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service("UserService")
public class UserService {
    @Autowired
    UserDao userDao;
    EncodeAndDecode encodeAndDecode;
    /*
        Service层介于controller和dao之间作为服务层进行一些逻辑处理，
        这里逻辑太简单所以知识单纯调用dao所以不做注释
     */
    public List<User> getAll(){
        return userDao.getAll();
    }
    public User getUserByName(String userName){
        return userDao.getUserByName(userName);
    }
    //检查用户名是否存在
    public int getUserNameCount(String userName){
        return userDao.getUserNameCount(userName);
    }
    //检查用户昵称是否存在
    public int getUserNickNameCount(String userNickName){
        return userDao.getUserNickNameCount(userNickName);
    }
    //检查用户名和密码是否匹配
    public User getUserByName(String userName,String password){
        password = encodeAndDecode.AESEncode(password);
        return userDao.getUserByName(userName,password);
    }
    //新增用户
    public void newUser(User user){
        user.setPassword(encodeAndDecode.AESEncode(user.getPassword()));
        userDao.newUser(user);
    }
}
