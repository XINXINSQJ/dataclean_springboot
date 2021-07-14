package com.dataclean.dataclean_springboot.controller;

import com.dataclean.dataclean_springboot.dao.StructdataDao;
import com.dataclean.dataclean_springboot.entity.Structdata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/dataclean/source/")
public class StructdataController {

    @Autowired
    private StructdataDao structdataDao;

    @GetMapping("/findAll")
    public List<Structdata> findAll(){
        return  structdataDao.findAll();
    }

    @PostMapping("/add")
    public String save(@RequestBody Structdata structdata){
        System.out.println(structdata.getAddress());
        Structdata result=structdataDao.save(structdata);
        if(result!=null){
            return "success";
        }
        return "error";
    }

    @GetMapping("/del")
    public void del(@RequestParam(value = "id")Integer id)
    {
        structdataDao.deleteById(id);
    }

}
