package com.github.matgor.workshop.Domain.Service;

import com.github.matgor.workshop.Domain.Model.Vehicle;

import java.util.List;
import java.util.Optional;

public interface VehicleService {
    Vehicle add(Vehicle vehicle);
    Optional<Vehicle> get(Long id);
    List<Vehicle> getList();
    void edit(Vehicle vehicle);
    void delete(Long id);
}
