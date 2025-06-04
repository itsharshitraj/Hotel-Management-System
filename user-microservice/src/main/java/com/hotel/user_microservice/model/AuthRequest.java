package com.hotel.user_microservice.model;
import lombok.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

// used when the user logs in (username + password)
// represents the JSON login request
public class AuthRequest {
    private String username;
    private String password;
}
