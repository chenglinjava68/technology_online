package com.learning.controller;

import com.learning.model.ResponseBean;
import com.learning.model.User.User;
import com.learning.model.enums.ResponseEnums;
import com.learning.util.JwtToken;
import com.learning.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController("UserController")
@RequestMapping("/user")
@Api(tags = "用户相关接口", description = "提供用户相关的 RESTful APIs",value = "userController")
public class UserController {
    @Autowired
    UserService userService;

    @ApiOperation("用户注册接口")
    @PostMapping("/registerUser")
    @ApiResponses( value = {
            @ApiResponse( code = 200, message = "成功", response = ResponseBean.class, responseContainer = "json" ) } )
    @CrossOrigin
    public Object registerUser(@Validated User user) {
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            if (userService.getUserNameCount(user.getUserName()) != 0) {
                ResponseBean responseBean=new ResponseBean(false,ResponseEnums.USER_NAME_EXIST);
                return responseBean;
            } else if (userService.getUserNickNameCount(user.getUserNickName()) != 0) {
                ResponseBean responseBean=new ResponseBean(false,ResponseEnums.USER_NICKNAME_EXIST);
                return responseBean;
            } else {
                user.setUserStatus(true);
                userService.newUser(user);
                ResponseBean responseBean=new ResponseBean(false,ResponseEnums.SUCCESS);
                return responseBean;
            }
        } catch (Exception e) {
            return new ResponseBean<>(false, ResponseEnums.SEVER_ERROR);
        }
    }


    @ApiOperation("用户登陆接口")
    @PostMapping("/Login")
    @ApiResponses( value = {
            @ApiResponse( code = 200, message = "成功", response = ResponseBean.class, responseContainer = "json" ) } )
    @CrossOrigin
    public Object Login(User user) {
        Map<String, Object> result = new HashMap<String, Object>();
        try {
           String userName = user.getUserName();
           String password = user.getPassword();
           User userCheck = userService.getUserByName(userName, password);
           if (userCheck == null){
               return new ResponseBean<>(false, ResponseEnums.USER_FAIL);
           }else {
               String Usertoken = JwtToken.sign(userName,password);
               return new ResponseBean<>(true,Usertoken,ResponseEnums.SUCCESS);
           }
        } catch (Exception e) {
            return new ResponseBean<>(false, ResponseEnums.SEVER_ERROR);
        }
    }
}

