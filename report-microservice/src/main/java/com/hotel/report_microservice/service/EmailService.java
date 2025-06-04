package com.hotel.report_microservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender mailSender;

    public void sendReportNotification(String toEmail, String subject, String body) {
        // Create a simple email message
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("0111cs211059.harshit@gmail.com"); // Set the sender's email address
        message.setTo(toEmail);
        message.setSubject(subject);
        message.setText(body);

        // Send the email
        mailSender.send(message);
    }
}
