package com.hotel.billing_microservice.controller;

import com.hotel.billing_microservice.model.Billing;
import com.hotel.billing_microservice.service.BillingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/billings")
public class BillingController {
    @Autowired
    private BillingService billingService;

    @PostMapping
    public ResponseEntity<Billing> createBilling(@RequestBody @Valid Billing billing) {
        Billing saved = billingService.createBilling(billing);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<Billing>> getAllBillings() {
        return ResponseEntity.ok(billingService.getAllBillings());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Billing> getBillingById(@PathVariable int id) {
        Billing billing = billingService.getBillingById(id);
        return ResponseEntity.ok(billing);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Billing> updateBilling(@PathVariable int id, @RequestBody @Valid Billing billing) {
        Billing updated = billingService.updateBilling(id, billing);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBilling(@PathVariable int id) {
        billingService.deleteBilling(id);
        return ResponseEntity.noContent().build();
    }

}
