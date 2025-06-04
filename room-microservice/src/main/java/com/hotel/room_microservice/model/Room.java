package com.hotel.room_microservice.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "rooms")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roomId;

    @Column(nullable = false)
    @NotBlank(message = "Room type is mandatory")
    private String roomType;

    @Column(nullable = false)
    @Min(value = 1, message = "There must be at least 1 bed")
    private int noOfBeds;

    private boolean roomStatus;
    private int roomRent;

}