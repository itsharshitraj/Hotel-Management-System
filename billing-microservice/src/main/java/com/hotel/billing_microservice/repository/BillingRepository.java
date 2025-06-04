package com.hotel.billing_microservice.repository;

import com.hotel.billing_microservice.model.Billing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillingRepository extends JpaRepository<Billing,Integer> {
}
