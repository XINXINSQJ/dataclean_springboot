package com.dataclean.dataclean_springboot.service;

import com.dataclean.dataclean_springboot.dao.UserDao;
import com.dataclean.dataclean_springboot.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class UserService {

    @Resource
    private UserDao userDao;

    public  void add(User user) {
        userDao.save(user);

    }

    public void update(User user){
        userDao.save(user);

    }

    public void del(Integer id){
        userDao.deleteById(id);
    }

    public User findById(Integer id){
        return userDao.findById(id).orElse(null);
    }

    public User findByName(String userName){
        return userDao.findName(userName);
    }

}
