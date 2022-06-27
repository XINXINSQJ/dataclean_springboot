package com.dataclean.dataclean_springboot.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Mobilegps {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;
    private Integer mobileid;
    private String time;
    private Float cleanlng;
    private Float cleanlat;
    private Float lng;
    private Float lat;
    private Integer detectionresult;
    private Float repairlng;
    private Float repairlat;
    private Integer repairresult;
}
