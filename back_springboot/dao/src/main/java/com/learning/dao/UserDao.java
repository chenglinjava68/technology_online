package com.learning.dao;
import com.learning.model.User;
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
    根据ID查询
    {id} 要查询用户的 id
     */
    User getUserByID(int id);
    /*
    删除
    {id} 要删除用户的 id
     */
    void delete(int id);

    /*
    更新
    {p} 要更新的User实例
     */
    void updateUser(User p);

    /*
    增加
    {p} 要新增的User实例
     */
    void newUser(User user);
}

