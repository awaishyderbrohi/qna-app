package com.techfira.controller;

import com.techfira.dto.UserResDTO;
import com.techfira.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private UserService userService;


    @GetMapping("/users")
    public ResponseEntity<List<UserResDTO>> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }
}
