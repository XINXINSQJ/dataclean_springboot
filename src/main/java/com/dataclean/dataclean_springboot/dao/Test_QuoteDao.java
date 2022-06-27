package com.dataclean.dataclean_springboot.dao;

import com.dataclean.dataclean_springboot.entity.Test_Quote;
import com.dataclean.dataclean_springboot.entity.Test_data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Test_QuoteDao extends JpaRepository<Test_Quote,Integer> {
    @Query(value="select * from test_quote order by id desc limit 0,1",nativeQuery=true)
    Test_Quote findLastById();

    //所有数据
    @Query(value="select count(*) from test_data where repairtime between ?1 and ?2",nativeQuery=true)
    Float dataCount(Long startTime,Long endTime);

    @Query(value="select count(*) from test_data where dirtydata!=cleandata and repairtime between ?1 and ?2",nativeQuery=true)
    Float dirtyDataCount(Long startTime,Long endTime);

    @Query(value="select count(*) from test_data where dirtydata!=cleandata and detectionresult=1 and repairtime between ?1 and ?2",nativeQuery=true)
    Float rightDetectionDataCount(Long startTime,Long endTime);

    @Query(value="select count(*) from test_data where repairresult=1 and dirtydata!=cleandata and detectionresult=1 and repairtime between ?1 and ?2",nativeQuery=true)
    Float repairSuccessDataCount(Long startTime,Long endTime);

    @Query(value="select sum(cleaningtime) from test_data where repairtime between ?1 and ?2",nativeQuery=true)
    Float  dataDelay(Long startTime,Long endTime);

    @Query(value="select count(*) from  test_data where conversionresult=0",nativeQuery=true)
    Float  failConversion();


    //按类型分的指标
    @Query(value="select count(*) from test_data where cmd=?1 and repairtime between ?2 and ?3",nativeQuery=true)
    Float typeDataCount(String sensorType,Long startTime,Long endTime);

    @Query(value="select count(*) from test_data where cmd=?1  and dirtydata!=cleandata and repairtime between ?2 and ?3",nativeQuery=true)
    Float typeDirtyDataCount(String sensorType,Long startTime,Long endTime);

    @Query(value="select count(*) from test_data where cmd=?1  and dirtydata!=cleandata and detectionresult=1 and repairtime between ?2 and ?3",nativeQuery=true)
    Float typeRightDetectionDataCount(String sensorType,Long startTime,Long endTime);

    @Query(value="select count(*) from test_data where cmd=?1  and repairresult=1 and dirtydata!=cleandata and detectionresult=1 and repairtime between ?2 and ?3",nativeQuery=true)
    Float typeRepairSuccessDataCount(String sensorType,Long startTime,Long endTime);

    @Query(value="select sum(cleaningtime) from test_data where cmd=?1 and repairtime between ?2 and ?3",nativeQuery=true)
    Float  typeDataDelay(String sensorType,Long startTime,Long endTime);

    //多个传感器指标
    @Query(value="select count(*) from test_data where sensorname in ?1  and repairtime between ?2 and ?3",nativeQuery=true)
    Float sensorListCount(List<String> sensorList,Long startTime,Long endTime);

    @Query(value="select count(*) from test_data where sensorname in ?1  and dirtydata!=cleandata and repairtime between ?2 and ?3",nativeQuery=true)
    Float sensorListDirtyDataCount(List<String> sensorList,Long startTime,Long endTime);

    @Query(value="select count(*) from test_data where sensorname in ?1  and dirtydata!=cleandata and detectionresult=1 and repairtime between ?2 and ?3",nativeQuery=true)
    Float sensorListRightDetectionDataCount(List<String> sensorList,Long startTime,Long endTime);

    @Query(value="select count(*) from test_data where sensorname in ?1  and repairresult=1 and dirtydata!=cleandata and detectionresult=1 and repairtime between ?2 and ?3",nativeQuery=true)
    Float sensorListRepairSuccessDataCount(List<String> sensorList,Long startTime,Long endTime);

    @Query(value="select sum(cleaningtime) from test_data where sensorname in ?1 and repairtime between ?2 and ?3",nativeQuery=true)
    Float  sensorListDataDelay(List<String> sensorList,Long startTime,Long endTime);


    //按传感器分的指标
    @Query(value="select count(*) from test_data where sensorname=?1 and repairtime between ?2 and ?3",nativeQuery=true)
    Float sensorDataCount(String sensorType,Long startTime,Long endTime);

    @Query(value="select count(*) from test_data where sensorname=?1  and dirtydata!=cleandata and repairtime between ?2 and ?3",nativeQuery=true)
    Float sensorDirtyDataCount(String sensorType,Long startTime,Long endTime);

    @Query(value="select count(*) from test_data where sensorname=?1  and dirtydata!=cleandata and detectionresult=1 and repairtime between ?2 and ?3",nativeQuery=true)
    Float sensorRightDetectionDataCount(String sensorType,Long startTime,Long endTime);

    @Query(value="select count(*) from test_data where sensorname=?1  and repairresult=1 and dirtydata!=cleandata and detectionresult=1 and repairtime between ?2 and ?3",nativeQuery=true)
    Float sensorRepairSuccessDataCount(String sensorType,Long startTime,Long endTime);

    //清洗延迟
    @Query(value="select sum(cleaningtime) from test_data where sensorname=?1 and repairtime between ?2 and ?3",nativeQuery=true)
    Float  sensorDataDelay(String sensorType,Long startTime,Long endTime);

}
