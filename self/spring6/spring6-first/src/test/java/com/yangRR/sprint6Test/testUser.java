package com.yangRR.sprint6Test;

import com.yangRR.sprint6.User;

import org.junit.jupiter.api.Test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testUser {

    private Logger logger = LoggerFactory.getLogger(testUser.class);

    @Test
    public void testUerObject(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean.xml");

        User user = (User) context.getBean("user",User.class);

        System.out.println(user);

        user.add();
        user.print();

        logger.info("调用成功····");
    }


    //测试反射
    //spring创建对象的底层
    @Test
    public void testReflection() throws Exception {
        Class<?> aClass = Class.forName("com.yangRR.sprint6.User");
        User user = (User)aClass.getDeclaredConstructor().newInstance();
        System.out.println(user);

    }
}
