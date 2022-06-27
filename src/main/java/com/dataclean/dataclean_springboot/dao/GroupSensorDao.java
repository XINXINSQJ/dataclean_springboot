package com.dataclean.dataclean_springboot.dao;

import com.dataclean.dataclean_springboot.entity.GroupSensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface GroupSensorDao extends JpaRepository<GroupSensor,Integer> {
    @Transactional
    @Modifying
    @Query(value="insert into groupsensor (sensorname,groupid) values (?1,?2)",nativeQuery=true)
    Integer insertGroupSensor(String sensorName,Integer GroupId);

    @Query(value="select * from groupsensor where groupid=?1 limit ?2,?3",nativeQuery=true)
    List<GroupSensor> getSensorList(Integer groupId,Integer start, Integer pageSize);

    @Query(value="select count(*) from groupsensor where groupid=?1",nativeQuery=true)
    Integer getTotal(Integer groupId);



}
