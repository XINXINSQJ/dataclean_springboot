package com.dataclean.dataclean_springboot.dao;

import com.dataclean.dataclean_springboot.entity.Device_CO2_0001;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface Device_CO2_0001Dao extends JpaRepository<Device_CO2_0001,Integer> {
    @Query(value="select * from device_co2_0001 where time between ?1 and ?2",nativeQuery=true)
    List<Device_CO2_0001> findByStartDateBetween(Long starttime, Long endtime);

    @Query(value="select * from device_co2_0001 where time = ?1",nativeQuery=true)
    Device_CO2_0001 findByTime(Long time);
}
