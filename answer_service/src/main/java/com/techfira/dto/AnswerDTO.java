package com.techfira.dto;


import jakarta.validation.constraints.NotBlank;

public class AnswerDTO {

    private Long id;
    @NotBlank
    private String answer;
    @NotBlank
    private Long questionId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }
}
