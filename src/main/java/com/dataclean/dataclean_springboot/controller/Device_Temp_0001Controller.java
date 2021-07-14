package com.dataclean.dataclean_springboot.controller;


import com.dataclean.dataclean_springboot.dao.Device_Temp_0001Dao;
import com.dataclean.dataclean_springboot.entity.Device_Temp_0001;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/dataclean/sensor")
public class Device_Temp_0001Controller {

    @Autowired
    private Device_Temp_0001Dao device_temp_0001Dao;

    @GetMapping("/temperature")
    public List<Device_Temp_0001> returnTemperature(@RequestParam(value = "starttime")Long starttime,
                                                    @RequestParam(value = "endtime")Long endtime){
        return (List<Device_Temp_0001>) device_temp_0001Dao.findByStartDateBetween(starttime,endtime);

    }

    @GetMapping("/onetemperature")
    public  Device_Temp_0001 returnOneTemperature(@RequestParam(value = "time")Long time){
        Device_Temp_0001 temp;
        temp=device_temp_0001Dao.findByTime(time);
//        Long nowtime=time;
//        while(temp==null){
//            time=time-1000;
//            temp=device_temp_0001Dao.findByTime(time);
//            System.out.println("******");
//        }
//        temp.setTime(nowtime);
        return temp;
    }
}
