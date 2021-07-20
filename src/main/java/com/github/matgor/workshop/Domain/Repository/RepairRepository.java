package com.github.matgor.workshop.Domain.Repository;

import com.github.matgor.workshop.Domain.Model.Repair;
import com.github.matgor.workshop.Domain.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//TODO Nie oznaczamy też interfejsów tymi adnotacjami, bo interfejs nie może być komponentem
@Repository
public interface RepairRepository extends JpaRepository<Repair, Long> {

    //TODO Nie nadpisujemy istniejących metod, nie ma to sensu
    @Override
    Optional<Repair> findById(Long id);
}
