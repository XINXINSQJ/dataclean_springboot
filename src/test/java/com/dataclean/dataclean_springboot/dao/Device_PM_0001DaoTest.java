package com.dataclean.dataclean_springboot.dao;

import com.dataclean.dataclean_springboot.entity.Device_PM_0001;
import com.dataclean.dataclean_springboot.entity.Device_Temp_0001;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class Device_PM_0001DaoTest {
    @Autowired
    private Device_PM_0001Dao device_pm_0001Dao;

    private List<Device_PM_0001> temps;
    private Device_PM_0001 temp;
    @Test
    void findAll(){
        temps=device_pm_0001Dao.findByStartDateBetweenPM10(1620788836000L,1620789461000L);
        temps.forEach(temp->
        {
            System.out.println(temp);
        });
    }
    @Test
    void findOne(){
        temp= (Device_PM_0001) device_pm_0001Dao.findByTimePM10(1620788834000L);
        System.out.println(temp);
    }
}
