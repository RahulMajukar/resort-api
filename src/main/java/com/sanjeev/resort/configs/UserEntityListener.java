package com.sanjeev.resort.configs;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.sanjeev.resort.models.User;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

import java.time.LocalDateTime;

public class UserEntityListener extends AuditingEntityListener {

    @PrePersist
    public void prePersist(User user) {
        LocalDateTime now = LocalDateTime.now();
        user.setCreatedAt(now);
        user.setUpdatedAt(now);
    }

    @PreUpdate
    public void preUpdate(User user) {
        user.setUpdatedAt(LocalDateTime.now());
    }
}

