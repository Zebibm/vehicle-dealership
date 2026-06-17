package com.example.vehicle_dealership.repository;

import com.example.vehicle_dealership.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {
}
