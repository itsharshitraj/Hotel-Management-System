package com.hotel.user_microservice.service;

import com.hotel.user_microservice.model.AuthRequest;
import com.hotel.user_microservice.model.User;
import com.hotel.user_microservice.repository.UserRepository;
import com.hotel.user_microservice.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String register(User user) {
        // Encode password before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "User registered successfully!";
    }
    public String authenticate(AuthRequest request) {
        // Authenticate credentials
//        authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
//        );

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
            );
        } catch (Exception e) {
            e.printStackTrace(); // 👉 print cause of 403
            throw new RuntimeException("Invalid username or password");
        }


        // If no exception, generate token
        UserDetails userDetails = userRepository.findByUsername(request.getUsername())
                .map(u -> org.springframework.security.core.userdetails.User
                        .withUsername(u.getUsername())
                        .password(u.getPassword())
                        .roles(u.getRole().name())
                        .build())
                .orElseThrow(() -> new RuntimeException("User not found"));

        return jwtUtil.generateToken(userDetails.getUsername());
    }
}
