package com.learning.dao;
import com.learning.model.User.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository("UserDao")
public interface UserDao {
    /*
   查所有
   return List<Person>
    */
    List<User> getAll();
    /*
    根据userName查询
    {userName} 要查询用户的 userName
     */
    User getUserByName(String userName);
    /*
    根据用户名和密码查询
    {userName} 要查询用户的名称
    {password} 要查询用户的密码
     */
    User getUserByName(String userName,String password);
    /*
    根据用户名查询数量
    {userName} 要查询用户的 userName
     */
    int getUserNameCount(String userName);
    /*
    根据用户昵称查询数量
    {userNickName} 要查询用户的 userNickName
     */
    int getUserNickNameCount(String userNickName);
    /*
    增加用户
    {user} 要新增的User实例
     */
    void newUser(User user);
    /*
    删除
    {id} 要删除用户的 id
     */
    void delete(int id);
    /*
    更新
    {user} 要更新的User实例
     */
    void updateUser(User user);

}

