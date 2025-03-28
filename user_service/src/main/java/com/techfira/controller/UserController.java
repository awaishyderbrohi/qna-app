package com.techfira.controller;


import com.techfira.dto.UserReqDTO;
import com.techfira.dto.UserResDTO;
import com.techfira.service.UserService;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<UserResDTO> findByUserName(String userName){
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        UserReqDTO userReqDTO = new UserReqDTO();
        userReqDTO.setUserName(name);
        UserResDTO userByUsername = userService.getUserByUsername(userReqDTO);
        return ResponseEntity.ok(userByUsername);
    }
}
