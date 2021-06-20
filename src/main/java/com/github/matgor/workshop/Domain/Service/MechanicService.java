package com.github.matgor.workshop.Domain.Service;

import com.github.matgor.workshop.Domain.Model.Mechanic;
import com.github.matgor.workshop.Domain.Model.User;

import java.util.List;
import java.util.Optional;

public interface MechanicService {
    Mechanic add(Mechanic mechanic);
    Optional<Mechanic> get(Long id);
    List<Mechanic> getList();
    void edit(Mechanic mechanic);
    void delete(Long id);
}
