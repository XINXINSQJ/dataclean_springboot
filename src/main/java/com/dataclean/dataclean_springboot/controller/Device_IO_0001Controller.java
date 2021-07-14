package com.dataclean.dataclean_springboot.controller;


import com.dataclean.dataclean_springboot.dao.Device_IO_0001Dao;
import com.dataclean.dataclean_springboot.entity.Device_IO_0001;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/dataclean/sensor/io/io0001")
public class Device_IO_0001Controller {
    @Autowired
    private Device_IO_0001Dao device_io_0001Dao;

    @GetMapping("/iodata")
    public List<Device_IO_0001> returnIO(@RequestParam(value = "time")Long time){
        return device_io_0001Dao.findByTime(time);
    }
}
