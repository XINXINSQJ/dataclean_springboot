package com.dataclean.dataclean_springboot.controller;

import com.dataclean.dataclean_springboot.dao.GroupSensorDao;
import com.dataclean.dataclean_springboot.entity.GroupSensor;
import com.dataclean.dataclean_springboot.entity.TotalGroupSensor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/dataclean/groupdata/")
public class GroupSensorController {
    @Autowired
    private GroupSensorDao groupSensorDao;
    @GetMapping("/insertgroupsensor")
    public Integer insertGroupSensor(@RequestParam(value = "sensorNameList")String sensorNameList,
                                     @RequestParam(value = "groupId")Integer groupId){
        List<String> nameList= Arrays.asList(sensorNameList.split(","));
        try {
            for (int i = 0; i < nameList.size(); i++) {
                String name = nameList.get(i);
                groupSensorDao.insertGroupSensor(name, groupId);
            }
        } catch(Exception e){
            e.printStackTrace();
            System.out.println("插入错误");
            return -1;
        }
        return 1;
    }

    @GetMapping("/getsensor")
    public TotalGroupSensor getSensorList(@RequestParam(value = "page")Integer page,
                                          @RequestParam(value = "pageSize")Integer pageSize,
                                          @RequestParam(value = "groupId")Integer groupId){
        TotalGroupSensor totalGroupSensor=new TotalGroupSensor();
        Integer start=(page-1)*pageSize;
        totalGroupSensor.sensorList=groupSensorDao.getSensorList(groupId,start,pageSize);
        totalGroupSensor.total=groupSensorDao.getTotal(groupId);
        return totalGroupSensor;

    }

}
