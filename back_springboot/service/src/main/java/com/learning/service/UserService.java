package com.learning.service;
import com.learning.dao.UserDao;
import com.learning.model.User;
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
    public User getUserByID(int id){
        return userDao.getUserByID(id);
    }
    //检查用户名是否存在
    public int getUserByName(String userName){
        return userDao.getUserByName(userName);
    }
    //检查用户昵称是否存在
    public int getUserByNickName(String userNickName){
        return userDao.getUserByNickName(userNickName);
    }
    //检查用户名和密码是否匹配
    public User checkUser(String userName,String password){
        password = encodeAndDecode.AESEncode(password);
        return userDao.checkUser(userName,password);
    }
    //新增用户
    public void newUser(User user){
        user.setPassword(encodeAndDecode.AESEncode(user.getPassword()));
        userDao.newUser(user);
    }
}
