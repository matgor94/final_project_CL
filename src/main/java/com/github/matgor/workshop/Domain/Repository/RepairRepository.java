package com.github.matgor.workshop.Domain.Repository;

import com.github.matgor.workshop.Domain.Model.Repair;
import com.github.matgor.workshop.Domain.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RepairRepository extends JpaRepository<Repair, Long> {
    @Override
    Optional<Repair> findById(Long id);
}
