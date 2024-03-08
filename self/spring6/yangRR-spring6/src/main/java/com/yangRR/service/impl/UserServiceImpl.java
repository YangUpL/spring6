package com.yangRR.service.impl;

import com.yangRR.anno.Bean;
import com.yangRR.anno.Di;
import com.yangRR.dao.UserDao;
import com.yangRR.service.UserService;

@Bean
public class UserServiceImpl implements UserService {

    @Di
    private UserDao userDao;
    @Override
    public void add() {
        System.out.println("service......");
        userDao.add();
    }
}
