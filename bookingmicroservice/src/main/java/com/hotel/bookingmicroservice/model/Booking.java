package com.hotel.bookingmicroservice.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "bookings")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookingId;

    @Column(nullable = false)
    private int roomId;

    @Column(nullable = false)
    private int guestId;

    @Column(nullable = false)
    @Min(value = 1, message = "There must be at least 1 Adult")
    private int numberOfAdults;

    @Column(nullable = false)
    private int numberOfChildren;

    @Column(nullable = false)
    private LocalDate checkInDate;

    @Column(nullable = false)
    private LocalDate checkOutDate;

    @Column(nullable = false)
    private int numberOfNights;

    @Column(nullable = false)
    private String paymentStatus;

    @Transient
    private Room room;  // Will be populated by Feign client (not stored in DB)

    @Transient
    private Guest guest; // Update Booking model to include Guest object (non-persistent)
              // persist this field to the database — it's for the API response only.

    @Transient
    private Payment payment;



}
