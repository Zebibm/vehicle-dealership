package com.example.vehicle_dealership.controller;

import com.example.vehicle_dealership.model.Vehicle;
import com.example.vehicle_dealership.service.VehicleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    private final VehicleService service;

    public VehicleController(VehicleService service) {
        this.service = service;
    }

    // GET all vehicles
    @GetMapping
    public List<Vehicle> getAllVehicles() {
        return service.getAllVehicles();
    }

    // GET vehicle by ID
    @GetMapping("/{id}")
    public Vehicle getVehicleById(@PathVariable int id) {
        return service.getVehicleById(id);
    }

    // CREATE vehicle
    @PostMapping
    public Vehicle addVehicle(@RequestBody Vehicle vehicle) {
        return service.addVehicle(vehicle);
    }

    // DELETE vehicle
    @DeleteMapping("/{id}")
    public void deleteVehicle(@PathVariable int id) {
        service.deleteVehicle(id);
    }
}