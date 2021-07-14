package com.dataclean.dataclean_springboot.dao;

import com.dataclean.dataclean_springboot.entity.Device_Temp_0001;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class Device_temp_0001DaoTest {

    @Autowired
    private Device_Temp_0001Dao device_temp_0001Dao;

    private List<Device_Temp_0001> temps;
    private Device_Temp_0001 temp;
    @Test
    void findAll(){
        temps=device_temp_0001Dao.findAll();
        temps.forEach(temp->
        {
            System.out.println(temp);
        });
    }
    @Test
    void findOne(){
        temp= (Device_Temp_0001) device_temp_0001Dao.findByTime(1620891600000L);
        System.out.println(temp);
    }

}
