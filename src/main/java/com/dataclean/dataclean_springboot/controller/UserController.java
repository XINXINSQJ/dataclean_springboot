package com.dataclean.dataclean_springboot.controller;

import com.dataclean.dataclean_springboot.common.Result;
import com.dataclean.dataclean_springboot.common.dto.ResponseDto;
import com.dataclean.dataclean_springboot.common.dto.UserDto;
import com.dataclean.dataclean_springboot.dao.UserDao;
import com.dataclean.dataclean_springboot.entity.User;
import com.dataclean.dataclean_springboot.service.UserService;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectSerializer;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/dataclean")
public class UserController {

    @Autowired
    private UserDao userDao;

    @Resource
    private UserService userService;


    @GetMapping("/login")
    public String login(@RequestParam(value = "username")String username,
                        @RequestParam(value = "password")String password){
        if(userDao.login(username).equals(password)){
            System.out.println("------1-------");
            return "登录成功";
        }
        else if(userDao.login(username)!="") {
            return "密码错误";
        }
        else{
            return "该账号未注册";
        }
    }

    @GetMapping("/find1")
    public User find1(){
        return userDao.findName("admin");
    }

//    @GetMapping("/test")
//    public ResponseDto test(){
//        UserDto data = new UserDto("root","123456");
//        return new ResponseDto(true,"",data);
//    }

    @GetMapping("/findAll")
    public List<User> findAll(){
        return userDao.findAll();
    }

    @PostMapping
    public Result add(@RequestBody User user){
        userService.add(user);
        return Result.success();
    }

    @PutMapping
    public Result update(@RequestBody User user){
        userService.add(user);
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result del(@RequestBody Integer id){
        userService.del(id);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result<User> findById(@RequestBody Integer id){
        return Result.success(userService.findById(id));
    }
}
