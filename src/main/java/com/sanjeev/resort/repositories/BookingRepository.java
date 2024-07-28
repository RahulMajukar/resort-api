package com.sanjeev.resort.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sanjeev.resort.models.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    // You can define additional methods here if needed
}
