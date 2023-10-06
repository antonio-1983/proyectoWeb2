package com.web2.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web2.proyecto.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}

