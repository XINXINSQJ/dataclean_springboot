package com.dataclean.dataclean_springboot.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Gps {
    public void setId(Integer id) {
        this.id = id;
    }

    public void setLng(Double lng) {
        this.lon = lng;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;
    private Double lon;
    private Double lat;


    public void setTime(String time) {
        this.time = time;
    }

    private String time;
}
