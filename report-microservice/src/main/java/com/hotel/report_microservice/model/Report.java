package com.hotel.report_microservice.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "reports")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reportId;

    @Column(nullable = false)
    private String reportType;  // e.g., INCOME, STAFF_PAYMENT

    @Column(nullable = false)
    private String reportDate;

    @Column(nullable = false)
    private double reportAmount;

    @Column(nullable = false)
    private String generatedBy; // e.g., OWNER, SYSTEM

}
