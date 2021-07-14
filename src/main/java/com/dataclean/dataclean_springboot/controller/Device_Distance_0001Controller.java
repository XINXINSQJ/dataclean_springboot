package com.dataclean.dataclean_springboot.controller;


import com.dataclean.dataclean_springboot.dao.Device_Distance_0001Dao;
import com.dataclean.dataclean_springboot.entity.Device_Distance_0001;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/dataclean/sensor/distance/distance0001")
public class Device_Distance_0001Controller {
    @Autowired
    private Device_Distance_0001Dao device_distance_0001Dao;

    @GetMapping("/datas")
    public List<Device_Distance_0001> returndatas(@RequestParam(value = "starttime")Long starttime,
                                                  @RequestParam(value = "endtime")Long endtime){
        return device_distance_0001Dao.findByStartDateBetween(starttime,endtime);

    }
    @GetMapping("/data")
    public Device_Distance_0001 returndata(@RequestParam(value = "time")Long time){
        Device_Distance_0001 temp;
        temp=device_distance_0001Dao.findByTime(time);
//        Long nowtime=time;
//        while(temp==null){
//            time=time-1000;
//            temp=device_co2_0001Dao.findByTime(time);
//            System.out.println("******");
//        }
//        temp.setTime(nowtime);
        return temp;
    }
}
