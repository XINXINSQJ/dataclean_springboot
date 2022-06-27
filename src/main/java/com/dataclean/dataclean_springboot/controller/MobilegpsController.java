package com.dataclean.dataclean_springboot.controller;

import com.dataclean.dataclean_springboot.dao.GpsdataDao;
import com.dataclean.dataclean_springboot.dao.MobilegpsDao;
import com.dataclean.dataclean_springboot.entity.Gpsdata;
import com.dataclean.dataclean_springboot.entity.Mobilegps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/dataclean/citybrain/mobilegps")
public class MobilegpsController {
    @Autowired
    private MobilegpsDao mobilegpsDao;
    @GetMapping("/getCount")
    public long returnSensorCount(){
        return mobilegpsDao.count();
    }

    @GetMapping("/getGpss")
    public List<Mobilegps> returnMobileNumbers(
            @RequestParam(value = "page")Integer page,
            @RequestParam(value = "pageSize")Integer pageSize){
        Integer start=(page-1)*pageSize;
        System.out.println(start);
        return mobilegpsDao.getGpsdatas(start,pageSize);
    }

    @GetMapping("getQuota")
    public Map<String,Integer> returnQuota(){
        Map<String,Integer> getQuote=new HashMap<String,Integer>();
        getQuote.put("typeDataCount",(int)mobilegpsDao.count());
        getQuote.put("typeDirtyDataCount",mobilegpsDao.getErrorCount());
        getQuote.put("typeRightDetectionDataCount",mobilegpsDao.getDetectionCount());
        getQuote.put("typeRepairSuccessDataCount",mobilegpsDao.getRepairRightCount());
        return getQuote;
    }
}
