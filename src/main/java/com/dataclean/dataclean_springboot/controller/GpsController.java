package com.dataclean.dataclean_springboot.controller;

import com.dataclean.dataclean_springboot.dao.GpsDao;
import com.dataclean.dataclean_springboot.entity.Gps;
import com.dataclean.dataclean_springboot.entity.Gpsaddress;
import com.dataclean.dataclean_springboot.entity.Structdata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("")
public class GpsController {
    @Autowired
    private GpsDao gpsDao;


    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
    @GetMapping("/gps")
    public Gps save(@RequestParam(value = "longitude")Double lon,
                       @RequestParam(value = "latitude")Double lat){
        Gps gps=new Gps();
        System.out.println(df.format(new Date()));
        gps.setTime(df.format(new Date()));
//        lat=lat+(float)(Math.random()/2000-0.0001);
//        lon=lon+(float)(Math.random()/2000-0.0001);
        gps.setLat(lat);
        gps.setLng(lon);
//        System.out.println(lon);
//        System.out.println(lat);
        Gps result=gpsDao.save(gps);
        if(result!=null){
            return gps;
        }
        return gps;
    }
//@RequestMapping("/gps")
//public String say(@RequestParam("longitude") double longitude,@RequestParam("latitude") double latitude){
//    System.out.println(longitude);
//    System.out.println(latitude);
//    return "经度:" + longitude + ", 纬度：" +latitude;
//}

    @GetMapping("dataclean/citybrain/gpsList")
    public List<Gps> getList() {
        return gpsDao.getGpsdatas();
    }
}
