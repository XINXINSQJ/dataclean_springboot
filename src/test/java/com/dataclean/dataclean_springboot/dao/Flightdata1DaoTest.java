package com.dataclean.dataclean_springboot.dao;

import com.dataclean.dataclean_springboot.entity.Flightdata1;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class Flightdata1DaoTest {

    @Autowired
    private Flightdata1Dao flightdata1Dao;

    @Test
    void save(){
        Flightdata1 flightdata1=new Flightdata1();
        flightdata1.setTuple_id(1);
        flightdata1.setSrc("aa");
        flightdata1.setSched_arr_time("asd");
        flightdata1.setSched_dep_time("asd");
        flightdata1.setAct_arr_time("asd");
        flightdata1.setAct_dep_time("asd");
        flightdata1.set是否正确数据("asd");
        flightdata1.set错误字段是("asd");
        Flightdata1 flightdata11=flightdata1Dao.save(flightdata1);
        System.out.println(flightdata11);

    }

}
