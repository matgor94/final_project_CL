package com.github.matgor.workshop.Domain.Repository;

import com.github.matgor.workshop.Domain.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
