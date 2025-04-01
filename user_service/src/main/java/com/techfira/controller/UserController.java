package com.techfira.controller;


import com.techfira.dto.UserReqDTO;
import com.techfira.dto.UserResDTO;
import com.techfira.service.UserService;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/user/{username}")
    public ResponseEntity<UserResDTO> findByUserName(){
        String authUserName = SecurityContextHolder.getContext().getAuthentication().getName();
        UserResDTO userByUsername = userService.getUserByUsername(authUserName);
        return ResponseEntity.ok(userByUsername);
    }

}
