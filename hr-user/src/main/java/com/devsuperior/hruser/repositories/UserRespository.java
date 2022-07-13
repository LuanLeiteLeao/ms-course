package com.devsuperior.hruser.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.hruser.entities.User;

public interface UserRespository extends JpaRepository<User,Long>{
   Optional<User> findByEmail(String email);
}
