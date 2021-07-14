package com.dataclean.dataclean_springboot.controller;

import com.dataclean.dataclean_springboot.dao.Test_dataDao;
import com.dataclean.dataclean_springboot.entity.Test_data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/dataclean/testdata/")
public class Test_dataController {
    @Autowired
    private Test_dataDao test_dataDao;

    @GetMapping("/datalist")
    public List<Test_data> getData(@RequestParam(value = "sensorname")String sensorname,
                                   @RequestParam(value = "starttime")Long starttime,
                                   @RequestParam(value = "endtime")Long enttime){

        return test_dataDao.findTestDataBetween(sensorname,starttime,enttime);

    }

}
