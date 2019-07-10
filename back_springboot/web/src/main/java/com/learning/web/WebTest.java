package com.learning.web;
import com.learning.service.ServiceTest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class WebTest {
    @RequestMapping("showAll")
    public String showAll(){
        //创建DaoTest对象
        ServiceTest serviceTest = new ServiceTest();
        return  serviceTest.showService() + "--> web test";
    }
}
