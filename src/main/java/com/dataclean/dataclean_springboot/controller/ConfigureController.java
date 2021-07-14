package com.dataclean.dataclean_springboot.controller;

import com.dataclean.dataclean_springboot.dao.ConfigureDao;
import com.dataclean.dataclean_springboot.entity.Configure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/dataclean/sensorlist/")
public class ConfigureController {
    @Autowired
    private ConfigureDao configureDao;

    @GetMapping("/getsensor")
    public List<Configure> returnDistance(@RequestParam(value = "type")String type,
                                          @RequestParam(value = "page")Integer page,
                                          @RequestParam(value = "pageSize")Integer pageSize){
        Integer start=(page-1)*pageSize;

        return configureDao.findDistance(type,start,pageSize);
    }
    @GetMapping("/sensorcount")
    public Integer returnSensorCount(@RequestParam(value = "sensorType")String name){

        return configureDao.findSensorCount(name);
    }


}
