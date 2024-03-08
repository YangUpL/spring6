package com.yangRR.dao;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.Arrays;

@Repository
public class UserDao {

    @Value("hhh")
    String hobbies[];
    public void add(){
        System.out.println("dao...");
        System.out.println(Arrays.toString(hobbies));
    }
}
