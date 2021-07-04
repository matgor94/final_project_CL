package com.github.matgor.workshop.Domain.Repository;

import com.github.matgor.workshop.Domain.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByEmail(String email);
}
