package com.github.matgor.workshop.Domain.Repository;

import com.github.matgor.workshop.Domain.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
