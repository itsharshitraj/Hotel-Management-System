package com.hotel.guest_microservice.controller;

import com.hotel.guest_microservice.model.Guest;
import com.hotel.guest_microservice.service.GuestService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/guests")
public class GuestController {
    @Autowired
    private GuestService guestService;

    @GetMapping
    public List<Guest> getAllGuest() {
        return guestService.getAllGuest();
    }
    @GetMapping("/{id}")
     public ResponseEntity<Guest> getGuestById(@PathVariable int id) {
        Optional <Guest> guest = guestService.getGuestById(id);
        return guest.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
    @PostMapping
    public ResponseEntity<Guest> createGuest(@RequestBody @Valid Guest guest) {
        Guest savedGuest = guestService.createGuest(guest);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedGuest);
    }

    @PutMapping("/{guestId}")
    public ResponseEntity<Guest> updateGuest(@PathVariable int guestId, @RequestBody @Valid Guest guest) {
        Guest updatedGuest = guestService.updateGuest(guestId, guest);
        return ResponseEntity.ok(updatedGuest);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGuest(@PathVariable int id){
        guestService.deleteGuestById(id);
        return ResponseEntity.noContent().build();
    }
}
