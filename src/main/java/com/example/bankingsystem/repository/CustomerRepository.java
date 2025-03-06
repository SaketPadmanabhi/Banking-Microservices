package com.example.bankingsystem.repository;

import com.example.bankingsystem.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    //Provides built-in CRUD methods (save(), findById(), delete(), etc.).

    Optional<Customer> findByEmail(String email);
    //Custom method to find customers by email.

}
