package com.hotel.bookingmicroservice.controller;

import com.hotel.bookingmicroservice.model.Booking;
import com.hotel.bookingmicroservice.service.BookingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bookings")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @GetMapping
    public ResponseEntity<List<Booking>> getAllBookings(){  // response change
        List<Booking> bookings = bookingService.getAllBookings();
        return ResponseEntity.ok(bookings);
       //  return bookingService.getAllBookings();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Booking> getBookingById (@PathVariable int id){
        return bookingService.getBookingById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());


    }

    @PostMapping
    public ResponseEntity<Booking> createBooking(@RequestBody @Valid Booking booking){ // JSON request body into a java Booking object
        Booking savedBooking = bookingService.createBooking(booking);
        return ResponseEntity.ok(savedBooking);
    }
    @PutMapping("/{bookingId}")
    public ResponseEntity<Booking> updateBooking(@PathVariable int bookingId, @RequestBody @Valid Booking updatedBooking) {
        Booking booking = bookingService.updateBooking(bookingId, updatedBooking);
        return ResponseEntity.ok(booking);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBooking(@PathVariable int id){
        bookingService.deleteBooking(id);
        return ResponseEntity.noContent().build();
    }
}
