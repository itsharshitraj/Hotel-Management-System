package com.hotel.billing_microservice.service;

import com.hotel.billing_microservice.model.Billing;

import java.util.List;
import java.util.Optional;

public interface BillingService {
    Billing createBilling(Billing billing);
    List<Billing> getAllBillings();
    Billing getBillingById(int id);
    Billing updateBilling(int id, Billing billing);
    void deleteBilling(int id);
}
