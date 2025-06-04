package com.hotel.payment_microservice.service;

import com.hotel.payment_microservice.model.Payment;
import com.hotel.payment_microservice.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public Payment createPayment(Payment payment){
        return paymentRepository.save(payment);
    }

    @Override
   public List<Payment> getAllPayments(){
        return paymentRepository.findAll();
    }

    @Override
    public Optional<Payment> getPaymentById(int id){
        return paymentRepository.findById(id);
    }
    @Override
    public Payment updatePayment(int id, Payment updatedPayment){
        Optional<Payment>existing = paymentRepository.findById(id);
        if (existing.isPresent()){
            Payment payment = existing.get();

            payment.setBookingId(updatedPayment.getBookingId());
            payment.setAmount(updatedPayment.getAmount());
            payment.setPaymentStatus(updatedPayment.getPaymentStatus());
            payment.setPaymentMode(updatedPayment.getPaymentMode());
            return paymentRepository.save(payment);
        }
        return null;
    }
    public void deletePayment(int id){
        paymentRepository.deleteById(id);
    }
    @Override
    public Optional<Payment> getPaymentByBookingId(int bookingId){
        return paymentRepository.findByBookingId(bookingId);
    }
}
