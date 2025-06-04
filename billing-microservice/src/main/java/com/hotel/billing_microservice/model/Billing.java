package com.hotel.billing_microservice.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "billing")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Billing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int billingId;

    @Column(nullable = false)
    private int bookingId;

    @Column(nullable = false)
    private int paymentId;

    @Column(nullable = false)
    private double totalAmount;

    @Column(nullable = false)
    private String billingDate;

    @Column(nullable = false)
    private String billingStatus;

    @Transient
    private Booking booking;  // Will be populated by Feign client (not stored in DB)

    @Transient
    private Payment payment;
                               // persist this field to the database — it's for the API response only.
}
