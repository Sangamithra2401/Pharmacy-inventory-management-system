package com.examly.springapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examly.springapp.model.Warehouse;

@Repository
public interface WarehouseRepo extends JpaRepository<Warehouse, Long> {
    List<Warehouse> findByLocation(String location);  
    List<Warehouse> findByLocationAndName(String location, String name);
}
