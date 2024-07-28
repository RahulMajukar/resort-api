package com.sanjeev.resort.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sanjeev.resort.models.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    // You can define additional methods here if needed
}
