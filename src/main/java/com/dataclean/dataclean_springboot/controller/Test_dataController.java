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

    @GetMapping("/datas")
    public List<Test_data> returnDataList(@RequestParam(value = "sensorType")String sensorType,
                                          @RequestParam(value = "startTime")Long startTime,
                                          @RequestParam(value = "endTime")Long entTime,
                                          @RequestParam(value = "page")Integer page,
                                          @RequestParam(value = "pageSize")Integer pageSize){
        if(sensorType.equals("all")){
            Integer start=(page-1)*pageSize;
            return test_dataDao.findAllData(startTime,entTime,start,pageSize);
        }
        else{
            return test_dataDao.findTypeData(sensorType, startTime, entTime, page,pageSize);
        }
    }

}
