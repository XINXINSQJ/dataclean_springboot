package com.dataclean.dataclean_springboot.controller;

import com.dataclean.dataclean_springboot.dao.Device_Temp_0001Dao;
import com.dataclean.dataclean_springboot.entity.Device_Temp_0001;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class Device_Temp_0001ControllerTest {

    @Autowired
    private Device_Temp_0001Dao device_temp_0001Dao;

    @Test
    void findByStartDateBetween(){

        List<Device_Temp_0001> temps= device_temp_0001Dao.findByStartDateBetween(1620801827000L,1620801930000L);
        temps.forEach(temp->
        {
            System.out.println(temp);
        });
    }

}
