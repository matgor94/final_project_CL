package com.github.matgor.workshop.Domain.Repository;

import com.github.matgor.workshop.Domain.Model.Mechanic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MechanicRepository extends JpaRepository<Mechanic, Long> {
}
