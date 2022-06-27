package com.dataclean.dataclean_springboot.entity;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Gpsaddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;
    private Float lng;
    private Float lat;
    private Integer result;
    private String conversiondata;
    private String realdata;
}
