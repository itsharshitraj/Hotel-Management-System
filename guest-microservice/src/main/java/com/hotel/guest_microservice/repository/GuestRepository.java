package com.hotel.guest_microservice.repository;

import com.hotel.guest_microservice.model.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestRepository extends JpaRepository<Guest,Integer> {
}
