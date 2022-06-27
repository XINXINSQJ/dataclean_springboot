package com.dataclean.dataclean_springboot.dao;


import com.dataclean.dataclean_springboot.entity.Gpsdata;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GpsdataDao extends JpaRepository<Gpsdata,Integer> {

    @Query(value="select * from gpsdata limit ?1,?2",nativeQuery=true)
    List<Gpsdata> getGpsdatas(Integer start, Integer count);

    @Query(value="select count(*) from gpsdata where (lng <> cleanlng or lat <> cleanlat)",nativeQuery=true)
    Integer getErrorCount();

    @Query(value="select count(*) from gpsdata where (lng <> cleanlng or lat <> cleanlat) and detectionresult=1",nativeQuery=true)
    Integer getDetectionCount();

    @Query(value="select count(*) from gpsdata where repairresult=1 or repairresult=2",nativeQuery=true)
    Integer getRepairCount();

    @Query(value="select count(*) from gpsdata where repairresult=1",nativeQuery=true)
    Integer getRepairRightCount();

}
