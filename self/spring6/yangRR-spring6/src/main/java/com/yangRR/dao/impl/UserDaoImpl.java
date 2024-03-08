package com.yangRR.dao.impl;

import com.yangRR.anno.Bean;
import com.yangRR.dao.UserDao;

@Bean
public class UserDaoImpl implements UserDao {

    @Override
    public void add() {
        System.out.println("dao.......");
    }
}
