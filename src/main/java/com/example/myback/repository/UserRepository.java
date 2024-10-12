package com.example.myback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.myback.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> { 
    // Utilisation de Integer pour le type d'ID

    User findByUsername(String username);
    User findByEmail(String email); 
}
