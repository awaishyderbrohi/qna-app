package com.techfira.dto;


import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class QuestionDTO {
    private Long id;
    @Size(min = 5, max = 300)
    private String title;

    private LocalDate createdAt;

    public QuestionDTO() {}

    public QuestionDTO(Long id, String title, LocalDate createdAt) {
        this.id = id;
        this.title = title;
        this.createdAt = createdAt;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }
}

