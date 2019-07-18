package com.learning.controller;

import com.learning.model.User;
import com.learning.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController("UserController")
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/registerUser")
    @CrossOrigin
    public Object registerUser(@Validated User user, BindingResult bindingResult) {
        Map<String, Object> result = new HashMap<String, Object>();
        if (bindingResult.hasErrors()) {
            String errorMsg = bindingResult.getFieldError().getDefaultMessage();
            result.put("success", false);
            result.put("message", errorMsg);
            return result;
        } else {
            try {
                if (userService.getUserByName(user.getUserName()) != 0) {
                    result.put("success", false);
                    result.put("message", "用户名已存在");
                    return result;
                } else if (userService.getUserByNickName(user.getUserNickName()) != 0) {
                    result.put("success", false);
                    result.put("message", "用户昵称已存在");
                    return result;
                } else {
                    user.setUserPower(1);
                    user.setUserStatus(true);
                    userService.newUser(user);
                    result.put("success", true);
                    result.put("message", "新增用户成功");
                    return result;
                }
            } catch (Exception e) {
                result.put("success", false);
                result.put("message", "用户新增异常，请稍后重试");
                return result;
            }
        }
    }

    @PostMapping("/Login")
    @CrossOrigin
    public Object Login(@Validated User user, BindingResult bindingResult) {

    }
}
