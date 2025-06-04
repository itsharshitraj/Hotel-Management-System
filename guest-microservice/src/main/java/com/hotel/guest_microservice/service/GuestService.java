package com.hotel.guest_microservice.service;

import com.hotel.guest_microservice.model.Guest;
import com.hotel.guest_microservice.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GuestService {
    @Autowired
    private GuestRepository guestRepository;


    public List<Guest> getAllGuest() {
        return guestRepository.findAll();
    }

    public Optional<Guest> getGuestById(int id) {
        return guestRepository.findById(id);
    }

    public Guest createGuest(Guest guest) {
        return guestRepository.save(guest);
    }
    public Guest updateGuest(int guestId, Guest updatedGuest) {
        Guest existingGuest = guestRepository.findById(guestId)
                .orElseThrow(() -> new RuntimeException("Guest not found with id: " + guestId));

        existingGuest.setGuestName(updatedGuest.getGuestName());
        existingGuest.setGuestAge(updatedGuest.getGuestAge());
        existingGuest.setGuestContactNo(updatedGuest.getGuestContactNo());
        existingGuest.setGuestEmailId(updatedGuest.getGuestEmailId());
        existingGuest.setGuestAddress(updatedGuest.getGuestAddress());

        return guestRepository.save(existingGuest);
    }

    public void deleteGuestById(int id) {
        guestRepository.deleteById(id);
    }
}
