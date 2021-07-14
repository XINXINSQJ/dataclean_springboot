package com.dataclean.dataclean_springboot.dao;

import com.dataclean.dataclean_springboot.entity.Configure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConfigureDao extends JpaRepository<Configure,Integer> {
    @Query(value="select * from configure where cmd = ?1 limit ?2,?3",nativeQuery=true)
    List<Configure> findDistance(String type,Integer start,Integer count);

    @Query(value="select count(*) from configure where cmd = ?1",nativeQuery=true)
    Integer findSensorCount(String name);
}
