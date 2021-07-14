package com.dataclean.dataclean_springboot.dao;

import com.dataclean.dataclean_springboot.entity.Device_PM_0001;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Device_PM_0001Dao extends JpaRepository<Device_PM_0001,Integer> {
    @Query(value="select * from device_pm_0001 where name='PM10' and time between ?1 and ?2",nativeQuery=true)
    List<Device_PM_0001> findByStartDateBetweenPM10(Long starttime, Long endtime);

    @Query(value="select * from device_pm_0001 where name='PM10' and time = ?1",nativeQuery=true)
    Device_PM_0001 findByTimePM10(Long time);

    @Query(value="select * from device_pm_0001 where name='PM2_5' and time between ?1 and ?2",nativeQuery=true)
    List<Device_PM_0001> findByStartDateBetweenPM25(Long starttime, Long endtime);

    @Query(value="select * from device_pm_0001 where name='PM2_5' and time = ?1",nativeQuery=true)
    Device_PM_0001 findByTimePM25(Long time);
}
