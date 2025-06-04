package com.hotel.bookingmicroservice.model;
import lombok.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
    private int paymentId;
    private int bookingId;
    private String paymentStatus;
    private double amount;
    private String paymentMode;
}
