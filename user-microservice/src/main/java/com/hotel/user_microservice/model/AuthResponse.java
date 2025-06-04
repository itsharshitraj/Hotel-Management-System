package com.hotel.user_microservice.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
// After the user successfully logs in, we’ll generate a JWT token to response
public class AuthResponse {
    private String token;
}
