package com.hotel.user_microservice.repository;

import com.hotel.user_microservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository <User, Integer> {
    Optional<User> findByUsername(String username); // helps Spring Security fetch the user by their login username.

}
