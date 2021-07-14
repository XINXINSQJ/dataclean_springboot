package com.dataclean.dataclean_springboot.dao;

import com.dataclean.dataclean_springboot.entity.Structdata;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StructdataDao extends JpaRepository<Structdata,Integer> {
}
