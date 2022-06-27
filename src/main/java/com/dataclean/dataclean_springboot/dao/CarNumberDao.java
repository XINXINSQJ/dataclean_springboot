package com.dataclean.dataclean_springboot.dao;

import com.dataclean.dataclean_springboot.entity.Carnumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarNumberDao extends JpaRepository<Carnumber,Integer> {

    @Query(value="select * from carnumber limit ?1,?2",nativeQuery=true)
    List<Carnumber> getNumbers(Integer start, Integer count);

    @Query(value="select count(*) from carnumber where result='Y'",nativeQuery=true)
    Integer getRightCount();

}
