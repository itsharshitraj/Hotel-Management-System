package com.hotel.billing_microservice.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Booking {
    private int bookingId;
    private int roomId;
    private int guestId;
    private int numberOfAdults;
    private int numberOfChildren;
    private String checkInDate;
    private String checkOutDate;
    private int numberOfNights;
    private String paymentStatus;
}
