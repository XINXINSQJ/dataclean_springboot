package com.dataclean.dataclean_springboot.dao;

import com.dataclean.dataclean_springboot.entity.GroupTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface GroupTableDao extends JpaRepository<GroupTable,Integer> {
    @Transactional
    @Modifying
    @Query(value="insert into grouptable (groupname,setuptime) values (?1,?2)",nativeQuery=true)
    Integer insertGroup(String groupName,String setupTime);

    @Query(value="select * from grouptable where groupname=?1 and setuptime=?2",nativeQuery=true)
    Integer getGroupId(String groupName,String setupTime);

    @Query(value="select * from grouptable limit ?1,?2",nativeQuery=true)
    List<GroupTable> getGroupList(Integer start, Integer pageSize);

    @Query(value="select count(*) from grouptable",nativeQuery=true)
    Integer getTotal();


    @Transactional
    @Modifying
    @Query(value="delete from grouptable where id=?1",nativeQuery=true)
    Integer deleteGroup(Integer groupId);

}
