package com.hotel.user_microservice.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password; //  (will hash it before saving)

    @Enumerated(EnumType.STRING) // ensures the role is stored as a readable string in the DB
    @Column(nullable = false)
    private Role role; // Enum (OWNER, MANAGER, RECEPTIONIST)
}
