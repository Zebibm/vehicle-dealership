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

    // UPDATE vehicle
    @PutMapping("/{id}")
    public Vehicle updateVehicle(@PathVariable int id, @RequestBody Vehicle vehicle) {
        Vehicle existing = service.getVehicleById(id);

        if (existing == null) {
            throw new RuntimeException("Vehicle not found with id: " + id);
        }

        existing.setMake(vehicle.getMake());
        existing.setModel(vehicle.getModel());
        existing.setYear(vehicle.getYear());

        return service.addVehicle(existing);
    }
}