package com.dataclean.dataclean_springboot.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Device_PM_0001 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;
    private String name;
    private Long time;
    private Float cleandata;
    private Float dirtydata;
    private Integer detectionresult;
    private Float repairdata;
}
