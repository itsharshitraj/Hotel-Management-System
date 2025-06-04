package com.hotel.inventory_microservice.repository;

import com.hotel.inventory_microservice.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Integer> {
    // Custom query methods can be defined here if needed
}
