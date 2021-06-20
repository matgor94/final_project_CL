package com.github.matgor.workshop.Domain.Service;

import com.github.matgor.workshop.Domain.Model.Customer;
import com.github.matgor.workshop.Domain.Model.User;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    Customer add(Customer customer);
    Optional<Customer> get(Long id);
    List<Customer> getList();
    void edit(Customer customer);
    void delete(Long id);
}
