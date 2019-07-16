package com.learning.controller;

import com.learning.model.User;
import com.learning.service.ServiceTest;
import com.learning.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/register")
    @CrossOrigin
    public Object submitUser(User user) {
        Map<String,Object> result = new HashMap<String, Object>();
        try {
            if(user.getId()==0) {
                userService.newUser(user);
                result.put("success", true);
            }else{
                result.put("false", false);
            }
            return result;
        }
        catch (Exception e){
            result.put("false", false);
            return result;
        }
    }
}
