package com.dataclean.dataclean_springboot.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Test_data {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;
    private String sensorname;
    private String cmd;
    private Long repairtime;
    private Float cleandata;
    private Float dirtydata;
    private Integer detectionresult;
    private Float repairdata;
}
