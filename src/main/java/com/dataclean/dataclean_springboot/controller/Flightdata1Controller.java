package com.dataclean.dataclean_springboot.controller;

import com.dataclean.dataclean_springboot.dao.Flightdata1Dao;
import com.dataclean.dataclean_springboot.entity.Flightdata1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/dataclean/flight")
public class Flightdata1Controller {

    @Autowired
    private Flightdata1Dao flightdata1Dao;
    private List<Flightdata1> flightdata1List;

    @PostMapping("/save")
    public String save(@RequestBody Flightdata1 flightdata1){
        // System.out.println(flightdata1);
//        Flightdata1 result=flightdata1Dao.save(flightdata1);
//        System.out.println(result);
        System.out.println("123456");
        return "chenggon";
    }

}
