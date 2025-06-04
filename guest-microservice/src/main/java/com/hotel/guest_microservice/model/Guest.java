package com.hotel.guest_microservice.model;

import jakarta.persistence.*;
import lombok.*;
@Entity
@Table(name = "guests")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Guest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int guestId;

    @Column(nullable = false)
    private String guestName;

    @Column(nullable = false)
    private int guestAge;

    @Column(nullable = false, unique = true)
    private long guestContactNo;

    @Column(nullable = false, unique = true)
    private String guestEmailId;

    @Column(nullable = false)
    private String guestAddress;
}
