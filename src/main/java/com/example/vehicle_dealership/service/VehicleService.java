package com.example.vehicle_dealership.service;

import com.example.vehicle_dealership.model.Vehicle;
import com.example.vehicle_dealership.repository.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {

    private final VehicleRepository repository;

    public VehicleService(VehicleRepository repository) {
        this.repository = repository;
    }

    public List<Vehicle> getAllVehicles() {
        return repository.findAll();
    }

    public Vehicle getVehicleById(int id) {
        return repository.findById(id).orElse(null);
    }

    public Vehicle addVehicle(Vehicle vehicle) {
        return repository.save(vehicle);
    }

    public void deleteVehicle(int id) {
        repository.deleteById(id);
    }
}
