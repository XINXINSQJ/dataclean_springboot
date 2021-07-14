package com.dataclean.dataclean_springboot.common.dto;

public class UserDto {
    public String getUsername() {
        return username;
    }
    public UserDto(String username,String password) {
        this.username = username;
        this.password=password;
    }


    public String getPassword() {
        return password;
    }


    private String username;
    private String password;
}
