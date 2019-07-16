package com.learning.service;
import com.learning.dao.UserDao;
import com.learning.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserDao userDao;
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

    public void newUser(User p){
        userDao.newUser(p);
    }
}
