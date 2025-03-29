package com.techfira.controller;

import com.techfira.dto.UserReqDTO;
import com.techfira.dto.UserResDTO;
import com.techfira.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PublicController {
    @Autowired
    private final UserService userService;

    public PublicController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserResDTO> createUser(@Valid @RequestBody UserReqDTO userReqDTO){

        return ResponseEntity.ok(userService.save(userReqDTO));
    }

    @PostMapping("/login")
    public String login(@RequestBody UserReqDTO userReqDTO){
        return userService.verify(userReqDTO);

    }
}
