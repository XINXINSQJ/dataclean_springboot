package com.dataclean.dataclean_springboot.controller;


import com.dataclean.dataclean_springboot.dao.Device_CO2_0001Dao;
import com.dataclean.dataclean_springboot.entity.Device_CO2_0001;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/dataclean/sensor/co2/co20001")
public class Device_CO2_0001Controller {
    @Autowired
    private Device_CO2_0001Dao device_co2_0001Dao;

    @GetMapping("/co2")
    public List<Device_CO2_0001> returnCO2(@RequestParam(value = "starttime")Long starttime,
                                            @RequestParam(value = "endtime")Long endtime){
        return device_co2_0001Dao.findByStartDateBetween(starttime,endtime);

    }
    @GetMapping("/oneco2")
    public Device_CO2_0001 returnOneCO2(@RequestParam(value = "time")Long time){
        Device_CO2_0001 temp;
        temp=device_co2_0001Dao.findByTime(time);
        return temp;
    }
}
