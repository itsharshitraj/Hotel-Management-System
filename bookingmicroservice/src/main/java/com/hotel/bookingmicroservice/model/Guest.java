package com.hotel.bookingmicroservice.model;

import lombok.*;

// This model is only used for data transfer, not for persistence (so no @Entity here).
// It is used to transfer data between the booking microservice and the guest microservice.
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Guest {
    private int guestId;
    private String guestName;
    private int guestAge;
    private long guestContactNo;
    private String guestEmailId;
    private String guestAddress;
}
