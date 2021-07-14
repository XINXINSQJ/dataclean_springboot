package com.dataclean.dataclean_springboot.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Flightdata1 {
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTuple_id() {
        return tuple_id;
    }

    public void setTuple_id(Integer tuple_id) {
        this.tuple_id = tuple_id;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getFlight() {
        return flight;
    }

    public void setFlight(String flight) {
        this.flight = flight;
    }

    public String getSched_arr_time() {
        return sched_arr_time;
    }

    public void setSched_arr_time(String sched_arr_time) {
        this.sched_arr_time = sched_arr_time;
    }

    public String getSched_dep_time() {
        return sched_dep_time;
    }

    public void setSched_dep_time(String sched_dep_time) {
        this.sched_dep_time = sched_dep_time;
    }

    public String getAct_arr_time() {
        return act_arr_time;
    }

    public void setAct_arr_time(String act_arr_time) {
        this.act_arr_time = act_arr_time;
    }

    public String getAct_dep_time() {
        return act_dep_time;
    }

    public void setAct_dep_time(String act_dep_time) {
        this.act_dep_time = act_dep_time;
    }

    public String get是否正确数据() {
        return 是否正确数据;
    }

    public void set是否正确数据(String 是否正确数据) {
        this.是否正确数据 = 是否正确数据;
    }

    public String get错误字段是() {
        return 错误字段是;
    }

    public void set错误字段是(String 错误字段是) {
        this.错误字段是 = 错误字段是;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer tuple_id;
    private String src;
    private String flight;
    private String sched_arr_time;
    private String sched_dep_time;
    private String act_arr_time;
    private String act_dep_time;
    private String 是否正确数据;
    private String 错误字段是;
}
