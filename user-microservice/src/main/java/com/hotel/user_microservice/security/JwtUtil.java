package com.hotel.user_microservice.security;

import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.*;

import java.security.Key;
import java.util.Date;

// helper class that handles everything related to JWT tokens - Think of it as your JWT toolbox.
/* Generating JWT tokens when a user logs in

Validating JWT tokens on every secured request

Extracting the username from a token */

@Component
public class JwtUtil {
    private final Key SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    // used to sign and verify the JWT.
    // Only your backend should know this
    //  ensures no one can fake your tokens

    private final long EXPIRATION_TIME = 86400000; // 1 day in milliseconds


    // Generate Token against username
    public String generateToken(String username){
        return Jwts.builder()
                .setSubject(username) // put username in token
                .setIssuedAt(new Date()) // when token was created
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SECRET_KEY) // sign it with secret
                .compact();  // generate token string
    }
    // Extract Username from Token - use to find who made the request
    public String extractUsername(String token) {
        return parseClaims(token).getSubject(); // get 'subject' which is our username
    }

    // Validate Token - token is really for this user
    // Check if the token is valid and not expired
    public boolean validateToken(String token,String username){
        final String extractedUsername = extractUsername(token);
        return (extractedUsername.equals(username) && !isTokenExpired(token));
    }

    // parseClaims() decodes the JWT token using your secret key
    private boolean isTokenExpired(String token) {
        return parseClaims(token).getExpiration().before(new Date());
    }

    // Internally decodes the JWT payload
    private Claims parseClaims(String token) {
       return Jwts.parser()
               .setSigningKey(SECRET_KEY)
               .build()
               .parseClaimsJws(token)
                .getBody();
    }

}
