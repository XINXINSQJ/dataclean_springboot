package com.dataclean.dataclean_springboot.entity;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Test_Quote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;
    private Double times;
    private Integer alldata;
    private Integer detectiondata;
    private Integer misdetection;
    private Integer undetection;
    private Float detectiontime;
    private Float repairtime;
    private String repairquota;
    private String detectionquota;
}
