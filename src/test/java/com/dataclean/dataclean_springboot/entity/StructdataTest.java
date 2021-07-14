package com.dataclean.dataclean_springboot.entity;

import com.dataclean.dataclean_springboot.dao.StructdataDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StructdataTest {
    @Autowired
    StructdataDao structdataDao;

    @Test
    void save(){
        Structdata structdata=new Structdata();
        structdata.setAddress("123");
        //structdata.setId(1);
        structdataDao.save(structdata);
    }
}
