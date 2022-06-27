package com.dataclean.dataclean_springboot.controller;


import com.dataclean.dataclean_springboot.dao.CarNumberDao;
import com.dataclean.dataclean_springboot.entity.Carnumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/dataclean/citybrain/traffic")
public class CarNumberController {
    @Autowired
    private CarNumberDao carNumberDao;
    @GetMapping("/getCount")
    public long returnSensorCount(){

        return carNumberDao.count();
    }

    @GetMapping("/getNumbers")
    public List<Carnumber> returnCarNumbers(
                                          @RequestParam(value = "page")Integer page,
                                          @RequestParam(value = "pageSize")Integer pageSize){
        Integer start=(page-1)*pageSize;

        return carNumberDao.getNumbers(start,pageSize);
    }

    @GetMapping("getQuota")
    public Map<String,Integer> returnQuota(){
        Map<String,Integer> getQuote=new HashMap<String,Integer>();
        getQuote.put("sum",(int)carNumberDao.count());
        getQuote.put("right",carNumberDao.getRightCount());
        return getQuote;
    }

}
