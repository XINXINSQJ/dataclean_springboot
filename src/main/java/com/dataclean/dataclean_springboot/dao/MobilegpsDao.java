package com.dataclean.dataclean_springboot.dao;

import com.dataclean.dataclean_springboot.entity.Gpsdata;
import com.dataclean.dataclean_springboot.entity.Mobilegps;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MobilegpsDao extends JpaRepository<Mobilegps,Integer> {
    @Query(value="select * from mobilegps limit ?1,?2",nativeQuery=true)
    List<Mobilegps> getGpsdatas(Integer start, Integer count);

    @Query(value="select count(*) from mobilegps where (lng <> cleanlng or lat <> cleanlat)",nativeQuery=true)
    Integer getErrorCount();

    @Query(value="select count(*) from mobilegps where (lng <> cleanlng or lat <> cleanlat) and detectionresult=1",nativeQuery=true)
    Integer getDetectionCount();

    @Query(value="select count(*) from mobilegps where repairresult=1 or repairresult=2",nativeQuery=true)
    Integer getRepairCount();

    @Query(value="select count(*) from mobilegps where repairresult=1",nativeQuery=true)
    Integer getRepairRightCount();
}
