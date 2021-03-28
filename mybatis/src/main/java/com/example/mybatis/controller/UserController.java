package com.example.mybatis.controller;

import com.example.mybatis.bean.User;
import com.example.mybatis.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserMapper userMapper;
    @RequestMapping("/getOne")
    @ResponseBody
    public User getOne(){
        User one = userMapper.getOne();
        return one;
    }
}
