package com.techfira.dto;

import com.techfira.entity.Roles;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

public class UserResDTO {

    private String userName;
    private String email;
    private LocalDate createdAt;

    public UserResDTO() {
    }

    public UserResDTO(String userName, String email, LocalDate createdAt) {
        this.userName = userName;
        this.email = email;
        this.createdAt = createdAt;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }
}
