package com.github.matgor.workshop.Domain.Repository;

import com.github.matgor.workshop.Domain.Model.Repair;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepairRepository extends JpaRepository<Repair, Long> {
}
