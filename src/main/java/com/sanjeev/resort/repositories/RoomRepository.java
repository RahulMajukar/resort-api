package com.sanjeev.resort.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sanjeev.resort.models.Room;

public interface RoomRepository extends JpaRepository<Room, Long> {
    // You can define additional methods here if needed
}
