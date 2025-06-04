package com.hotel.billing_microservice.service;

import com.hotel.billing_microservice.feign.BookingClient;
import com.hotel.billing_microservice.feign.PaymentClient;
import com.hotel.billing_microservice.model.Billing;
import com.hotel.billing_microservice.model.Booking;
import com.hotel.billing_microservice.model.Payment;
import com.hotel.billing_microservice.repository.BillingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BillingServiceImpl implements BillingService {
    @Autowired
    private BillingRepository billingRepository;

    @Autowired
    private PaymentClient paymentClient;

    @Autowired
    private BookingClient bookingClient;

    @Override
    public Billing createBilling(Billing billing) {
        return billingRepository.save(billing);
    }
    @Override
    public List<Billing> getAllBillings() {
        List<Billing> billings = billingRepository.findAll();
         for (Billing billing : billings){
             try {
                 billing.setBooking(bookingClient.getBookingById(billing.getBookingId()));
                 billing.setPayment(paymentClient.getPaymentById(billing.getPaymentId()));
             } catch (Exception e) {
                 System.out.println("Failed to fetch booking/payment info for billingId: " + billing.getBillingId());
             }
         }
        return billings;
    }

    @Override
    public Billing getBillingById(int id) {
        Billing billing =billingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Billing not found with ID: " + id));
        // Fetch booking and payment details using Feign clients

        Booking booking= bookingClient.getBookingById(billing.getBookingId());
        Payment payment= paymentClient.getPaymentById(billing.getPaymentId());

        // Set the booking and payment details in the billing object

        billing.setBooking(booking);
        billing.setPayment(payment);

        return billing;
    }
    @Override
    public Billing updateBilling(int id, Billing updatedBilling) {
        Optional<Billing> existingBillingOpt = billingRepository.findById(id);
        if (existingBillingOpt.isPresent()) {
            Billing existingBilling = existingBillingOpt.get();

            existingBilling.setBookingId(updatedBilling.getBookingId());
            existingBilling.setPaymentId(updatedBilling.getPaymentId());
            existingBilling.setTotalAmount(updatedBilling.getTotalAmount());
            existingBilling.setBillingDate(updatedBilling.getBillingDate());
            existingBilling.setBillingStatus(updatedBilling.getBillingStatus());
            return billingRepository.save(existingBilling);
        } else {
            throw new RuntimeException("Billing not found with ID: " + id);
        }
    }
    @Override
    public void deleteBilling(int id) {
        billingRepository.deleteById(id);
    }

}
