package com.examly.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.examly.springapp.model.Warehouse;
import com.examly.springapp.service.WarehouseService;

@RestController
@RequestMapping("/api/warehouses")
public class WarehouseController {

    @Autowired
    private WarehouseService service;

    @PostMapping
    public ResponseEntity<Warehouse> addWarehouse(@RequestBody Warehouse warehouse) {
        return new ResponseEntity<>(service.addWarehouse(warehouse), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Warehouse>> getAllWarehouses() {
        List<Warehouse> l=service.getAllWarehouses();
        return new ResponseEntity<>(l,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Warehouse> getWarehouseById(@PathVariable Long id) {
        Warehouse w=service.getWarehouseById(id);
        return new ResponseEntity<>(w,HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Warehouse> updateWarehouse(
            @PathVariable Long id,
            @RequestBody Warehouse warehouse) {
        return ResponseEntity.ok(service.updateWarehouse(id, warehouse));
    }

     @GetMapping("/location/{location}")
    public ResponseEntity<?> getWarehouseByLocation(@PathVariable String location) {

    List<Warehouse> warehouses = service.findByLocation(location);
    return ResponseEntity.ok(warehouses);
    }

    @GetMapping("/location/{location}/name/{name}")
    public ResponseEntity<List<Warehouse>> getWarehouseByLocationAndName(
         @PathVariable String location,
        @PathVariable String name) {
    return ResponseEntity.ok(
            service.findByLocationAndName(location, name)
    );
    }

    
}

