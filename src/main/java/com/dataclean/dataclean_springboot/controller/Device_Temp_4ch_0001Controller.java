package com.dataclean.dataclean_springboot.controller;

import com.dataclean.dataclean_springboot.dao.Device_Temp_4ch_0001Dao;
import com.dataclean.dataclean_springboot.entity.Device_Temp_4ch_0001;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/dataclean/sensor/temp/temp0002")
public class Device_Temp_4ch_0001Controller {
    @Autowired
    private Device_Temp_4ch_0001Dao device_temp_4ch_0001Dao;

    @GetMapping("/ch1datas")
    public List<Device_Temp_4ch_0001> returnCH1(@RequestParam(value = "starttime")Long starttime,
                                                @RequestParam(value = "endtime")Long endtime){
        return device_temp_4ch_0001Dao.findByStartDateBetweenCH1(starttime,endtime);
    }
    @GetMapping("/ch1data")
    public Device_Temp_4ch_0001 returnOneCH1(@RequestParam(value = "time")Long time){
        Device_Temp_4ch_0001 temp;
        temp=device_temp_4ch_0001Dao.findByTimeCH1(time);
        return temp;
    }

    @GetMapping("/ch2datas")
    public List<Device_Temp_4ch_0001> returnCH2(@RequestParam(value = "starttime")Long starttime,
                                                @RequestParam(value = "endtime")Long endtime){
        return device_temp_4ch_0001Dao.findByStartDateBetweenCH2(starttime,endtime);
    }
    @GetMapping("/ch2data")
    public Device_Temp_4ch_0001 returnOneCH2(@RequestParam(value = "time")Long time){
        Device_Temp_4ch_0001 temp;
        temp=device_temp_4ch_0001Dao.findByTimeCH2(time);
        return temp;
    }

    @GetMapping("/ch3datas")
    public List<Device_Temp_4ch_0001> returnCH3(@RequestParam(value = "starttime")Long starttime,
                                                @RequestParam(value = "endtime")Long endtime){
        return device_temp_4ch_0001Dao.findByStartDateBetweenCH3(starttime,endtime);
    }
    @GetMapping("/ch3data")
    public Device_Temp_4ch_0001 returnOneCH3(@RequestParam(value = "time")Long time){
        Device_Temp_4ch_0001 temp;
        temp=device_temp_4ch_0001Dao.findByTimeCH3(time);
        return temp;
    }

    @GetMapping("/ch4datas")
    public List<Device_Temp_4ch_0001> returnCH4(@RequestParam(value = "starttime")Long starttime,
                                                @RequestParam(value = "endtime")Long endtime){
        return device_temp_4ch_0001Dao.findByStartDateBetweenCH4(starttime,endtime);
    }
    @GetMapping("/ch4data")
    public Device_Temp_4ch_0001 returnOneCH4(@RequestParam(value = "time")Long time){
        Device_Temp_4ch_0001 temp;
        temp=device_temp_4ch_0001Dao.findByTimeCH4(time);
        return temp;
    }

}
