package com.techfira.service;

import com.techfira.dto.UserReqDTO;
import com.techfira.dto.UserResDTO;
import com.techfira.entity.Roles;
import com.techfira.entity.User;
import com.techfira.exception.CustomException;
import com.techfira.mapper.UserMapper;
import com.techfira.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {


    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper mapper = UserMapper.INSTANCE;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserResDTO save(UserReqDTO userReqDTO){
        User byUsername = userRepository.findByUserName(userReqDTO.getUserName());
        User byEmail = userRepository.findByEmail(userReqDTO.getEmail());

//        Check Weather User OR Email Exists!
        if (byUsername != null){
            throw new CustomException("UserName already Exists!");
        }else if (byEmail != null){
            throw new CustomException("Email Already Exists!");
        }
//        Else Save
        else{
            User user = mapper.toEntity(userReqDTO);
//            Encoding Password
            user.setPassword(passwordEncoder.encode(user.getPassword()));
//            Set Roles Manually
            user.setRole(Roles.USER);
            User savedUser = userRepository.save(user);
            return mapper.toDTO(savedUser);
        }
    }


    public UserResDTO getUserByUsername(UserReqDTO userReqDTO){
        User byUsername = userRepository.findByUserName(userReqDTO.getUserName());
        return mapper.toDTO(byUsername);
    }

    public List<UserResDTO> getAllUsers(){
        List<User> allUsers = userRepository.findAll();
        return mapper.toDTOList(allUsers);
    }

    public UserResDTO update(String userName,UserReqDTO userReqDTO){
        User user = userRepository.findByUserName(userName);

        if (!userReqDTO.getUserName().isEmpty()){
            user.setUserName(userReqDTO.getUserName());
        }
        if (!userReqDTO.getEmail().isEmpty()){
            user.setEmail(userReqDTO.getEmail());
        }
        if (!userReqDTO.getPassword().isEmpty()) {
            user.setPassword(passwordEncoder.encode(userReqDTO.getPassword()));
        }

        User savedUser = userRepository.save(user);

        return mapper.toDTO(savedUser);
    }

    public void deleteUserByUserName(String userName){
        userRepository.deleteByUserName(userName);
    }


}
