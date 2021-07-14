package com.dataclean.dataclean_springboot.dao;

import com.dataclean.dataclean_springboot.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @Test
    void findAll(){
        System.out.println(userDao.findAll());
    }

    @Test
    void save(){
        User user=new User();
        user.setName("test");
        user.setPassword("123456");
        user.setPower("admin");
        User user1 = userDao.save(user);
        System.out.println(user1);
    }

}
