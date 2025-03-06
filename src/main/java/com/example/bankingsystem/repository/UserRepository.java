package com.example.bankingsystem.repository;

import com.example.bankingsystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    //Finds users by username for authentication.
    Optional<User> findByUsername(String username);
}
