package com.github.matgor.workshop.Domain.Repository;

import com.github.matgor.workshop.Domain.Model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
}
