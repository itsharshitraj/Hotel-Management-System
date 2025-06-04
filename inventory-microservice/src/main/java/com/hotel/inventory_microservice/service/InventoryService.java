package com.hotel.inventory_microservice.service;

import com.hotel.inventory_microservice.model.Inventory;
import java.util.List;
import java.util.Optional;


public interface InventoryService {
    Inventory addInventory(Inventory inventory);
    List<Inventory> getAllInventories();
    Optional<Inventory> getInventoryById(int id);
    Inventory updateInventory(int id, Inventory inventory);
    void deleteInventory(int id);

}
