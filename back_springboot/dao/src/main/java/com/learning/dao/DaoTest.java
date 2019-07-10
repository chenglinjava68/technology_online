package com.learning.dao;
import com.learning.entity.EntityTest;

public class DaoTest {
    public String showDao() {
        //创建EntityTest对象
        EntityTest entityTest = new EntityTest();
        return entityTest.showEntity()+"--> dao test";
    }
}
