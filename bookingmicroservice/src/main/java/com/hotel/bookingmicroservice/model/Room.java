package com.hotel.bookingmicroservice.model;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Room {
    private int roomId;
    private String roomType;
    private int noOfBeds;
    private boolean roomStatus;
    private int roomRent;



}
