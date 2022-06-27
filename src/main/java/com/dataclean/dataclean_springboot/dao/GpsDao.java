package com.dataclean.dataclean_springboot.dao;

import com.dataclean.dataclean_springboot.entity.Gps;
import com.dataclean.dataclean_springboot.entity.Gpsaddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GpsDao extends JpaRepository<Gps,Integer> {
    @Query(value="select * from gps order by id desc limit 10",nativeQuery=true)
    List<Gps> getGpsdatas();
}
