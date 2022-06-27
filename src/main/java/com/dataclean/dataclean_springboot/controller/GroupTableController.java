package com.dataclean.dataclean_springboot.controller;


import com.dataclean.dataclean_springboot.dao.GroupTableDao;
import com.dataclean.dataclean_springboot.entity.GroupTable;
import com.dataclean.dataclean_springboot.entity.TotalGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/dataclean/groupdata/")
public class GroupTableController {
    @Autowired
    private GroupTableDao groupTableDao;
    @GetMapping("/setupgroup")
    public Integer insertGroup(@RequestParam(value = "groupName")String groupName,
                               @RequestParam(value = "setUpTime")String setUpTime){
        try {
            groupTableDao.insertGroup(groupName, setUpTime);
        }
        catch (Exception e){
            e.printStackTrace();
            return -1;
        }

        return groupTableDao.getGroupId(groupName, setUpTime);
    }

    @GetMapping("/getgroup")
    public TotalGroup groupTableList(@RequestParam(value = "page")Integer page,
                                           @RequestParam(value = "pageSize")Integer pageSize){

        TotalGroup totalGroup=new TotalGroup();
        Integer start=(page-1)*pageSize;
        totalGroup.groupList=groupTableDao.getGroupList(start,pageSize);
        totalGroup.total=groupTableDao.getTotal();
        return totalGroup;
    }

    @GetMapping("/deletegroup")
    public Integer deleteGroup(@RequestParam(value = "groupId")Integer groupId){
        return groupTableDao.deleteGroup(groupId);

    }

}
