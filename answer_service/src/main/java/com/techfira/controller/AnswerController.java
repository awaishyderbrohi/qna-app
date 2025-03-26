package com.techfira.controller;


import com.techfira.dto.AnswerDTO;
import com.techfira.service.AnswerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/answers")
public class AnswerController {

    @Autowired
    private  AnswerService answerService;

    @PostMapping
    public ResponseEntity<AnswerDTO> createAnswer(@RequestBody AnswerDTO answerDTO) {
        AnswerDTO createdAnswer = answerService.create(answerDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAnswer);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnswerDTO> getAnswerById(@PathVariable long id) {
        AnswerDTO answer = answerService.getAnswerById(id);
        return ResponseEntity.ok(answer);
    }


    @GetMapping
    public ResponseEntity<List<AnswerDTO>> getAllAnswers() {
        List<AnswerDTO> answers = answerService.getAllAnswers();
        return ResponseEntity.ok(answers);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AnswerDTO> updateAnswer(
            @PathVariable long id,
            @RequestBody AnswerDTO answerDTO) {
        AnswerDTO updatedAnswer = answerService.updateAnswer(id, answerDTO);
        return ResponseEntity.ok(updatedAnswer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnswer(@PathVariable long id) {
        answerService.deleteAnswer(id);
        return ResponseEntity.noContent().build();
    }
}