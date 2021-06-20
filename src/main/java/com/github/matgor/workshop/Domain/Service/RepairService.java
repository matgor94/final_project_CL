package com.github.matgor.workshop.Domain.Service;

import com.github.matgor.workshop.Domain.Model.Repair;
import com.github.matgor.workshop.Domain.Model.User;

import java.util.List;
import java.util.Optional;

public interface RepairService {
    Repair add(Repair repair);
    Optional<Repair> get(Long id);
    List<Repair> getList();
    void edit(Repair repair);
    void delete(Long id);
}
