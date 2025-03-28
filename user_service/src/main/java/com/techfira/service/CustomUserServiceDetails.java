package com.techfira.service;

import com.techfira.entity.User;
import com.techfira.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserServiceDetails implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserServiceDetails(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User byUserName = userRepository.findByUserName(username);
        return org.springframework.security.core.userdetails.User
                .withUsername(byUserName.getUserName())
                .password(byUserName.getPassword())
                .roles(byUserName.getRole().toString())
                .build();
    }
}
