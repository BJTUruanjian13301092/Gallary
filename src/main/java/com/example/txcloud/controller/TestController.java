package com.example.txcloud.controller;

import com.example.txcloud.data.entity.UserEntity;
import com.example.txcloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/hello")
public class TestController {

    @Autowired
    UserService userService;

    @RequestMapping("/saveUser")
    public String saveUser(){
        userService.saveUser();
        return "Success";
    }

    @RequestMapping("/showUser")
    public List<UserEntity> showUser(){
        return userService.showUsers();
    }

    @RequestMapping("/index")
    public ModelAndView toIndex(){
        return new ModelAndView("index");
    }
}
