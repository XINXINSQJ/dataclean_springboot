package com.dataclean.dataclean_springboot.dao;

import com.dataclean.dataclean_springboot.entity.Device_Temp_4ch_0001;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Device_Temp_4ch_0001Dao extends JpaRepository<Device_Temp_4ch_0001,Integer> {
    @Query(value="select * from device_temp_4ch_0001 where name='CH1' and time between ?1 and ?2",nativeQuery=true)
    List<Device_Temp_4ch_0001> findByStartDateBetweenCH1(Long starttime, Long endtime);

    @Query(value="select * from device_temp_4ch_0001 where name='CH1' and time = ?1",nativeQuery=true)
    Device_Temp_4ch_0001 findByTimeCH1(Long time);

    @Query(value="select * from device_temp_4ch_0001 where name='CH2' and time between ?1 and ?2",nativeQuery=true)
    List<Device_Temp_4ch_0001> findByStartDateBetweenCH2(Long starttime, Long endtime);

    @Query(value="select * from device_temp_4ch_0001 where name='CH2' and time = ?1",nativeQuery=true)
    Device_Temp_4ch_0001 findByTimeCH2(Long time);

    @Query(value="select * from device_temp_4ch_0001 where name='CH3' and time between ?1 and ?2",nativeQuery=true)
    List<Device_Temp_4ch_0001> findByStartDateBetweenCH3(Long starttime, Long endtime);

    @Query(value="select * from device_temp_4ch_0001 where name='CH3' and time = ?1",nativeQuery=true)
    Device_Temp_4ch_0001 findByTimeCH3(Long time);

    @Query(value="select * from device_temp_4ch_0001 where name='CH4' and time between ?1 and ?2",nativeQuery=true)
    List<Device_Temp_4ch_0001> findByStartDateBetweenCH4(Long starttime, Long endtime);

    @Query(value="select * from device_temp_4ch_0001 where name='CH4' and time = ?1",nativeQuery=true)
    Device_Temp_4ch_0001 findByTimeCH4(Long time);

}
