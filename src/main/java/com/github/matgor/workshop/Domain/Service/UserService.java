package com.github.matgor.workshop.Domain.Service;

import com.github.matgor.workshop.Domain.Model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User add(User user);
    Optional<User> get(Long id);
    List<User> getList();
    void edit(User user);
    void delete(Long id);
}
