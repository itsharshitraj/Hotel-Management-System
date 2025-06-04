package com.hotel.bookingmicroservice.service;

import com.hotel.bookingmicroservice.model.Booking;

import java.util.List;
import java.util.Optional;


public interface BookingService {
    List<Booking> getAllBookings();
    Optional<Booking> getBookingById(int id);
    Booking createBooking(Booking booking);
    void deleteBooking(int id);
    Booking updateBooking(int bookingId, Booking updatedBooking);



}
