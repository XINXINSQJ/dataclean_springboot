package com.dataclean.dataclean_springboot.controller;


import com.dataclean.dataclean_springboot.dao.Test_QuoteDao;
import com.dataclean.dataclean_springboot.dao.Test_dataDao;
import com.dataclean.dataclean_springboot.entity.Test_Quote;
import com.dataclean.dataclean_springboot.entity.Test_data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

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
            Float count=test_quoteDao.dataCount(startTime,entTime);
            testQuote.put("typeDataCount",count);
            testQuote.put("typeRepairSuccessDataCount",test_quoteDao.repairSuccessDataCount(startTime,entTime));
            testQuote.put("typeRightDetectionDataCount",test_quoteDao.rightDetectionDataCount(startTime,entTime));
            testQuote.put("typeDataDelay",test_quoteDao.dataDelay(startTime,entTime));
            testQuote.put("typeDirtyDataCount",test_quoteDao.dirtyDataCount(startTime,entTime));
            testQuote.put("typeConversion",(count-test_quoteDao.failConversion())/count*100);
            return testQuote;
        }
        else{
            Float count=test_quoteDao.typeDataCount(sensorType,startTime,entTime);
            typeTestQuote.put("typeDataCount",count);
            typeTestQuote.put("typeRepairSuccessDataCount",test_quoteDao.typeRepairSuccessDataCount(sensorType,startTime,entTime));
            typeTestQuote.put("typeRightDetectionDataCount",test_quoteDao.typeRightDetectionDataCount(sensorType,startTime,entTime));
            typeTestQuote.put("typeDataDelay",test_quoteDao.typeDataDelay(sensorType,startTime,entTime));
            typeTestQuote.put("typeDirtyDataCount",test_quoteDao.typeDirtyDataCount(sensorType,startTime,entTime));
            typeTestQuote.put("typeConversion",(count-test_quoteDao.failConversion())/count*100);
            return typeTestQuote;
        }
    }

    @GetMapping("/sensorTestQuote")
    public Map<String,Float> returnSensorTestQuote(@RequestParam(value = "sensorType")String sensorType,
                                                 @RequestParam(value = "startTime")Long startTime,
                                                 @RequestParam(value = "endTime")Long entTime){
        Map<String,Float> typeTestQuote=new HashMap<String,Float>();
        Float count=test_quoteDao.sensorDataCount(sensorType,startTime,entTime);
        typeTestQuote.put("typeDataCount",count);
        typeTestQuote.put("typeRepairSuccessDataCount",test_quoteDao.sensorRepairSuccessDataCount(sensorType,startTime,entTime));
        typeTestQuote.put("typeRightDetectionDataCount",test_quoteDao.sensorRightDetectionDataCount(sensorType,startTime,entTime));
        typeTestQuote.put("typeDataDelay",test_quoteDao.sensorDataDelay(sensorType,startTime,entTime));
        typeTestQuote.put("typeDirtyDataCount",test_quoteDao.sensorDirtyDataCount(sensorType,startTime,entTime));
        typeTestQuote.put("typeConversion",(count-test_quoteDao.failConversion())/count*100);
        return typeTestQuote;
    }

    //自定义传感器指标
    @GetMapping("/customsensorquote")
    public Map<String,Float> returnCustomSensorQuote(@RequestParam(value = "sensorList")String sensorListString,
                                                     @RequestParam(value = "startTime")Long startTime,
                                                     @RequestParam(value = "endTime")Long entTime){
        Map<String,Float> sensorListQuote=new HashMap<String,Float>();
        Double typeDataCount=0.0;
        Double typeRepairSuccessDataCount=0.0;
        Double typeRightDetectionDataCount=0.0;
        Double typeDataDelay=0.0;
        Double typeDirtyDataCount=0.0;
        List<String> sensorList= Arrays.asList(sensorListString.split(","));

        sensorListQuote.put("typeDataCount",test_quoteDao.sensorListCount(sensorList,startTime,entTime));
        sensorListQuote.put("typeRepairSuccessDataCount",test_quoteDao.sensorListRepairSuccessDataCount(sensorList,startTime,entTime));
        sensorListQuote.put("typeRightDetectionDataCount",test_quoteDao.sensorListRightDetectionDataCount(sensorList,startTime,entTime));
        sensorListQuote.put("typeDataDelay",test_quoteDao.sensorListDataDelay(sensorList,startTime,entTime));
        sensorListQuote.put("typeDirtyDataCount",test_quoteDao.sensorListDirtyDataCount(sensorList,startTime,entTime));

//        for (int i = 0; i < sensorList.size(); i++) {
//            String sensorName = sensorList.get(i);
//            typeDataCount+=test_quoteDao.sensorDataCount(sensorName,startTime,entTime);
//            typeRepairSuccessDataCount+=test_quoteDao.sensorRepairSuccessDataCount(sensorName,startTime,entTime);
//            typeRightDetectionDataCount+=test_quoteDao.sensorRightDetectionDataCount(sensorName,startTime,entTime);
//            typeDataDelay+=test_quoteDao.sensorDataDelay(sensorName,startTime,entTime);
//            typeDirtyDataCount+=test_quoteDao.sensorDirtyDataCount(sensorName,startTime,entTime);
//        }
//        sensorListQuote.put("typeDataCount",typeDataCount);
//        sensorListQuote.put("typeRepairSuccessDataCount",typeRepairSuccessDataCount);
//        sensorListQuote.put("typeRightDetectionDataCount",typeRightDetectionDataCount);
//        sensorListQuote.put("typeDataDelay",typeDataDelay);
//        sensorListQuote.put("typeDirtyDataCount",typeDirtyDataCount);
        return  sensorListQuote;
    }

}
