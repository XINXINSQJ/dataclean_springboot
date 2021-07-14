package com.dataclean.dataclean_springboot.dao;

import com.dataclean.dataclean_springboot.entity.Test_data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Test_dataDao extends JpaRepository<Test_data,Integer> {
    @Query(value="select * from test_data where sensorname=?1 and repairtime between ?2 and ?3",nativeQuery=true)
    List<Test_data> findTestDataBetween(String name,Long starttime,Long endtime);
}
