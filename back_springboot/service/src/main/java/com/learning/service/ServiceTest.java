package com.learning.service;
import com.learning.dao.DaoTest;

public class ServiceTest {
    public String showService() {
        //创建DaoTest对象
        DaoTest daoTest = new DaoTest();
        return daoTest.showDao() + "--> service test";
    }
}
