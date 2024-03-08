package com.yangRR.controller;

import com.yangRR.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

@Controller("userController")
public class UserController {

    @Resource(name = "userService")
    private UserService userService;

    @Value("R")
    private String name;

    public void add(){
        System.out.println("controller..." + name);
        userService.add();
    }
}
