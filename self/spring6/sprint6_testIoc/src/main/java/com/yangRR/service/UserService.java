package com.yangRR.service;

import com.yangRR.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserService {

    @Autowired
    private UserDao userDao;

    public void add(){
        System.out.println("service...");
        userDao.add();
    }
}
