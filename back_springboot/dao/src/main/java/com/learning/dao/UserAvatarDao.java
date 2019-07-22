package com.learning.dao;

import com.learning.model.UserAvatar;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository("UserAvatarDao")
public interface UserAvatarDao {
    /*
    根据ID查询
    {id} 要查询用户的 id
     */
    UserAvatar getUserAvatarByName(String userName);

    /*
     增加用户头像
     {user} 要新增的User实例
      */
    void newUserAvtar(int id);
}
