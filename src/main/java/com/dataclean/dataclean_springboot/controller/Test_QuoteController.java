package com.dataclean.dataclean_springboot.controller;


import com.dataclean.dataclean_springboot.dao.Test_QuoteDao;
import com.dataclean.dataclean_springboot.entity.Test_Quote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/dataclean/test")
public class Test_QuoteController {
    @Autowired
    private Test_QuoteDao test_quoteDao;

    @GetMapping("/testquota")
    public Test_Quote returnQuote(){
        return test_quoteDao.findLastById();
    }

    @GetMapping("/typeTestQuote")
    public Map<String,Float> returnTypeTestQuote(@RequestParam(value = "sensorType")String sensorType,
                                                 @RequestParam(value = "startTime")Long startTime,
                                                 @RequestParam(value = "endTime")Long entTime){
        Map<String,Float> typeTestQuote=new HashMap<String,Float>();
        Map<String,Float> testQuote=new HashMap<String,Float>();
        if(sensorType.equals("all")){
            testQuote.put("typeDataCount",test_quoteDao.dataCount(startTime,entTime));
            testQuote.put("typeRepairSuccessDataCount",test_quoteDao.repairSuccessDataCount(startTime,entTime));
            testQuote.put("typeRightDetectionDataCount",test_quoteDao.rightDetectionDataCount(startTime,entTime));
            testQuote.put("typeDirtyDataCount",test_quoteDao.dirtyDataCount(startTime,entTime));

            return testQuote;
        }
        else{
            typeTestQuote.put("typeDataCount",test_quoteDao.typeDataCount(sensorType,startTime,entTime));
            typeTestQuote.put("typeRepairSuccessDataCount",test_quoteDao.typeRepairSuccessDataCount(sensorType,startTime,entTime));
            typeTestQuote.put("typeRightDetectionDataCount",test_quoteDao.typeRightDetectionDataCount(sensorType,startTime,entTime));
            typeTestQuote.put("typeDirtyDataCount",test_quoteDao.typeDirtyDataCount(sensorType,startTime,entTime));
            return typeTestQuote;
        }
    }

    @GetMapping("/sensorTestQuote")
    public Map<String,Float> returnSensorTestQuote(@RequestParam(value = "sensorType")String sensorType,
                                                 @RequestParam(value = "startTime")Long startTime,
                                                 @RequestParam(value = "endTime")Long entTime){
        Map<String,Float> typeTestQuote=new HashMap<String,Float>();
        typeTestQuote.put("typeDataCount",test_quoteDao.sensorDataCount(sensorType,startTime,entTime));
        typeTestQuote.put("typeRepairSuccessDataCount",test_quoteDao.sensorRepairSuccessDataCount(sensorType,startTime,entTime));
        typeTestQuote.put("typeRightDetectionDataCount",test_quoteDao.sensorRightDetectionDataCount(sensorType,startTime,entTime));
        typeTestQuote.put("typeDirtyDataCount",test_quoteDao.sensorDirtyDataCount(sensorType,startTime,entTime));
        return typeTestQuote;
    }
}
