package com.hotel.billing_microservice.model;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Payment {
    private int paymentId;
    private int bookingId;
    private String paymentStatus;
    private double amount;
    private String paymentMode;
}
