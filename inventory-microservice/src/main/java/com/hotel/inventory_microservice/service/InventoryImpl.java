package com.hotel.inventory_microservice.service;

import com.hotel.inventory_microservice.model.Inventory;
import com.hotel.inventory_microservice.repository.InventoryRepository;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryImpl implements InventoryService {
    @Autowired
    private InventoryRepository inventoryRepository;

    @Override
    public Inventory addInventory(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    @Override
    public List<Inventory> getAllInventories() {
        return inventoryRepository.findAll();
    }

    @Override
    public Optional<Inventory> getInventoryById(int id){
        return inventoryRepository.findById(id);
    }

//    @Override
//    public Inventory updateInventory(int id, Inventory updatedInventory){
//        Optional<Inventory> existingInventoryOpt = inventoryRepository.findById(id);
//        if(existingInventoryOpt.isPresent()){
//            Inventory existingInventory = existingInventoryOpt.get();
//            existingInventory.setInventoryName(updatedInventory.getInventoryName());
//            existingInventory.setInventoryDepartment(updatedInventory.getInventoryDepartment());
//            existingInventory.setInventoryQuantity(updatedInventory.getInventoryQuantity());
//            return inventoryRepository.save(existingInventory);
//        }
//        return null;
//    }

    @Override
    public Inventory updateInventory(int id,Inventory inventory){
        return inventoryRepository.findById(id).map(existingInventory -> {
            existingInventory.setInventoryName(inventory.getInventoryName());
            existingInventory.setInventoryDepartment(inventory.getInventoryDepartment());
            existingInventory.setInventoryQuantity(inventory.getInventoryQuantity());
            return inventoryRepository.save(existingInventory);
        }).orElseGet(null);
    }

    @Override
    public void deleteInventory(int id) {
        inventoryRepository.deleteById(id);
    }
}
