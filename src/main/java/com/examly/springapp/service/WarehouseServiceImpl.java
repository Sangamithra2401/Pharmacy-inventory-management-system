package com.examly.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.Warehouse;
import com.examly.springapp.repository.WarehouseRepo;

@Service
public class WarehouseServiceImpl implements WarehouseService {

    @Autowired
    private WarehouseRepo repo;

    @Override
    public Warehouse addWarehouse(Warehouse warehouse) {
        return repo.save(warehouse);
    }

    @Override
    public List<Warehouse> getAllWarehouses() {
        return repo.findAll();
    }

    @Override
    public Warehouse getWarehouseById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Warehouse updateWarehouse(Long id, Warehouse warehouse) {
        Warehouse existing = repo.findById(id).orElse(null);
        if (existing != null) {
            existing.setName(warehouse.getName());
            existing.setLocation(warehouse.getLocation());
            return repo.save(existing);
        }
        return null;
    }

    @Override
    public List<Warehouse> findByLocation(String location) {
        return repo.findByLocation(location);
    }

     @Override
    public List<Warehouse> findByLocationAndName(String location, String name) {
        return repo.findByLocationAndName(location, name);
    }
}
