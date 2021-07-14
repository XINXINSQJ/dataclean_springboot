package com.dataclean.dataclean_springboot.controller;

import com.dataclean.dataclean_springboot.dao.Device_PM_0001Dao;
import com.dataclean.dataclean_springboot.entity.Device_Distance_0001;
import com.dataclean.dataclean_springboot.entity.Device_PM_0001;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/dataclean/sensor/pm/pm0001")
public class Device_PM_0001Controller {
    @Autowired
    private Device_PM_0001Dao device_pm_0001Dao;

    @GetMapping("/pm10datas")
    public List<Device_PM_0001> returnPM10datas(@RequestParam(value = "starttime")Long starttime,
                                            @RequestParam(value = "endtime")Long endtime){
        return device_pm_0001Dao.findByStartDateBetweenPM10(starttime,endtime);

    }
    @GetMapping("/pm10data")
    public Device_PM_0001 returnPM10data(@RequestParam(value = "time")Long time){
        Device_PM_0001 temp;
        temp=device_pm_0001Dao.findByTimePM10(time);
        return temp;
    }

    @GetMapping("/pm25datas")
    public List<Device_PM_0001> returnPM25datas(@RequestParam(value = "starttime")Long starttime,
                                                @RequestParam(value = "endtime")Long endtime){
        return device_pm_0001Dao.findByStartDateBetweenPM25(starttime,endtime);

    }
    @GetMapping("/pm25data")
    public Device_PM_0001 returnPM25data(@RequestParam(value = "time")Long time){
        Device_PM_0001 temp;
        temp=device_pm_0001Dao.findByTimePM25(time);
        return temp;
    }
}
