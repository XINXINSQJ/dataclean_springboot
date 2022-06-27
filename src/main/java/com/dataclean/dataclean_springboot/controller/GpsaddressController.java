package com.dataclean.dataclean_springboot.controller;

import com.dataclean.dataclean_springboot.dao.GpsaddressDao;
import com.dataclean.dataclean_springboot.dao.GpsdataDao;
import com.dataclean.dataclean_springboot.entity.Gpsaddress;
import com.dataclean.dataclean_springboot.entity.Gpsdata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/dataclean/citybrain/gpsaddress")
public class GpsaddressController {
    @Autowired
    private GpsaddressDao gpsaddressDao;
    @GetMapping("/getCount")
    public long returnSensorCount(){
        return gpsaddressDao.count();
    }
    @GetMapping("/getGpssAddress")
    public List<Gpsaddress> returnGpsAddress(
            @RequestParam(value = "page")Integer page,
            @RequestParam(value = "pageSize")Integer pageSize){
        Integer start=(page-1)*pageSize;

        return gpsaddressDao.getGpsdatas(start,pageSize);
    }

    @GetMapping("getQuota")
    public Map<String,Integer> returnQuota(){
        Map<String,Integer> getQuote=new HashMap<String,Integer>();
        getQuote.put("sum",(int)gpsaddressDao.count());
        getQuote.put("right",gpsaddressDao.getRightCount());
        return getQuote;
    }

}
