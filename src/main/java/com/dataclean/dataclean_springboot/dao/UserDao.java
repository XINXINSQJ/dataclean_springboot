package com.dataclean.dataclean_springboot.dao;

import com.dataclean.dataclean_springboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {

    @Query(value="select * from user where username like %?1% ", nativeQuery=true)
    User findName(String username);

    @Query(value="select password from user where username = ?1 ", nativeQuery=true)
    String login(String username);
}
