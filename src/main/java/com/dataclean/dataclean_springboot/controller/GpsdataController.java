package com.dataclean.dataclean_springboot.controller;


import com.dataclean.dataclean_springboot.dao.GpsdataDao;
import com.dataclean.dataclean_springboot.entity.Carnumber;
import com.dataclean.dataclean_springboot.entity.Gpsdata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/dataclean/citybrain/gps")
public class GpsdataController {
    @Autowired
    private GpsdataDao gpsdataDao;
    @GetMapping("/getCount")
    public long returnSensorCount(){
        return gpsdataDao.count();
    }

    @GetMapping("/getGpss")
    public List<Gpsdata> returnCarNumbers(
            @RequestParam(value = "page")Integer page,
            @RequestParam(value = "pageSize")Integer pageSize){
        Integer start=(page-1)*pageSize;

        return gpsdataDao.getGpsdatas(start,pageSize);
    }

    @GetMapping("getQuota")
    public Map<String,Integer> returnQuota(){
        Map<String,Integer> getQuote=new HashMap<String,Integer>();
        getQuote.put("typeDataCount",(int)gpsdataDao.count());
        getQuote.put("typeDirtyDataCount",gpsdataDao.getErrorCount());
        getQuote.put("typeRightDetectionDataCount",gpsdataDao.getDetectionCount());
        getQuote.put("typeRepairSuccessDataCount",gpsdataDao.getRepairRightCount());
        return getQuote;
    }
}
