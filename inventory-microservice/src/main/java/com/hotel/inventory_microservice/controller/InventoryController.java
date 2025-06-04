package com.hotel.inventory_microservice.controller;

import com.hotel.inventory_microservice.model.Inventory;
import com.hotel.inventory_microservice.service.InventoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/inventory")
public class InventoryController {
     @Autowired
    private InventoryService inventoryService;

     @PostMapping
    public ResponseEntity<Inventory> addInventory(@RequestBody @Valid Inventory inventory){
         Inventory saved = inventoryService.addInventory(inventory);
         return new ResponseEntity<>(saved, HttpStatus.CREATED);
     }

     @GetMapping
    public ResponseEntity<List<Inventory>> getAllInventories(){
         return ResponseEntity.ok(inventoryService.getAllInventories());
     }

     @GetMapping("/{id}")
    public ResponseEntity<Inventory> getInventoryById(@PathVariable int id){
         Optional <Inventory> inventory = inventoryService.getInventoryById(id);
         return inventory.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
     }

        @PutMapping("/{id}")
    public ResponseEntity<Inventory> updateInventory(@PathVariable int id, @RequestBody @Valid Inventory inventory){
         Inventory updated = inventoryService.updateInventory(id, inventory);
         if(updated != null){
             return ResponseEntity.ok(updated);
         }
             return ResponseEntity.notFound().build();
         }

         @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInventory(@PathVariable int id){
             inventoryService.deleteInventory(id);
             return ResponseEntity.noContent().build();
            }
}
