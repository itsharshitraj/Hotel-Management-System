package com.hotel.bookingmicroservice.service;

import com.hotel.bookingmicroservice.feign.GuestClient;
import com.hotel.bookingmicroservice.feign.PaymentClient;
import com.hotel.bookingmicroservice.feign.RoomClient;
import com.hotel.bookingmicroservice.model.Booking;
import com.hotel.bookingmicroservice.model.Guest;
import com.hotel.bookingmicroservice.model.Payment;
import com.hotel.bookingmicroservice.model.Room;
import com.hotel.bookingmicroservice.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService {
    @Autowired
    private BookingRepository bookingRepository;
@Autowired
private RoomClient roomClient;

@Autowired
private GuestClient guestClient;

    @Autowired
    private PaymentClient paymentClient;

    @Override
    public List<Booking> getAllBookings() {
      // return bookingRepository.findAll();
        List<Booking> bookings = bookingRepository.findAll();
        for (Booking booking : bookings) {
            try {
                Room room = roomClient.getRoomById(booking.getRoomId());
                booking.setRoom(room);
            } catch (Exception e) {
                System.out.println("Failed to fetch Room: " + e.getMessage());
            }

            try {
                Guest guest = guestClient.getGuestById(booking.getGuestId());
                booking.setGuest(guest);
            } catch (Exception e) {
                System.out.println("Failed to fetch Guest: " + e.getMessage());
            }

            try {
                Payment payment = paymentClient.getPaymentByBookingId(booking.getBookingId());
                booking.setPayment(payment);
            } catch (Exception e) {
                System.out.println("Failed to fetch Payment By Booking Id: " + e.getMessage());
            }
        }
        return bookings;



    }

    @Override
    public Optional<Booking> getBookingById(int id) {
       //  return bookingRepository.findById(id);
        Optional<Booking> booking = bookingRepository.findById(id);
        booking.ifPresent(b -> {
            try {
                Room room = roomClient.getRoomById(b.getRoomId());
                b.setRoom(room);
            } catch (Exception e) {
                System.out.println("Failed to fetch Room: " + e.getMessage());
            }

            try {
                Guest guest = guestClient.getGuestById(b.getGuestId());
                b.setGuest(guest);
            } catch (Exception e) {
                System.out.println("Failed to fetch Guest: " + e.getMessage());
            }

            try {
                Payment payment = paymentClient.getPaymentByBookingId(b.getBookingId());
                b.setPayment(payment);
            } catch (Exception e) {
                System.out.println("Failed to fetch Payment By Booking Id: " + e.getMessage());
            }
        });
        return booking;


    }

    @Override
    public Booking createBooking(Booking booking) {
      return bookingRepository.save(booking);


    }


    @Override
    public Booking updateBooking(int bookingId, Booking updatedBooking) {
        Booking existingBooking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found with id: " + bookingId));


        existingBooking.setRoomId(updatedBooking.getRoomId());
        existingBooking.setNumberOfChildren(updatedBooking.getNumberOfChildren());
        existingBooking.setNumberOfAdults(updatedBooking.getNumberOfAdults());
        existingBooking.setCheckInDate(updatedBooking.getCheckInDate());
        existingBooking.setCheckOutDate(updatedBooking.getCheckOutDate());
        existingBooking.setPaymentStatus(updatedBooking.getPaymentStatus());
        existingBooking.setNumberOfNights(updatedBooking.getNumberOfNights());

       return bookingRepository.save(existingBooking);


    }

    @Override
    public void deleteBooking(int id) {
      bookingRepository.deleteById(id);
    }
}
