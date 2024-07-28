package com.sanjeev.resort.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sanjeev.resort.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Additional methods for custom queries if needed
}

