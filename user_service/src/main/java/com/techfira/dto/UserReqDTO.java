package com.techfira.dto;

import com.techfira.entity.Roles;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

public class UserReqDTO {

    @NotBlank(message = "Username is required!")
    @Size(max = 20)
    private String userName;
    @NotBlank
    @Email
    private String email;

    @NotBlank(message = "Password is required!")
    @Size(min = 6, max = 255, message = "size must be between 6 and 255")
    private String password;

    public UserReqDTO() {
    }

    public UserReqDTO(String userName, String email, String password) {
        this.userName = userName;
        this.email = email;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
