package com.dataclean.dataclean_springboot.dao;

import com.dataclean.dataclean_springboot.entity.Gpsaddress;
import com.dataclean.dataclean_springboot.entity.Gpsdata;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GpsaddressDao extends JpaRepository<Gpsaddress,Integer> {
    @Query(value="select * from gpsaddress limit ?1,?2",nativeQuery=true)
    List<Gpsaddress> getGpsdatas(Integer start, Integer count);

    @Query(value="select count(*) from gpsaddress where result=1",nativeQuery=true)
    Integer getRightCount();
}
