package com.project.test.services;

import com.project.test.dto.UserDto;
import com.project.test.entities.UserEntity;
import com.project.test.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserEntity createUser(UserDto userDto){
        var encoder = new BCryptPasswordEncoder();
        var user = UserEntity.builder()
                .fullName(userDto.getFullName())
                .username(userDto.getUsername())
                .password(encoder.encode(userDto.getPassword()))
//                .password(userDto.getPassword())
                .build();
        return userRepository.save(user);
    }

    public UserEntity updateUser(UserDto userDto){
        var encoder = new BCryptPasswordEncoder();
        var user = userRepository.findById(userDto.getId()).get();
        user.setUsername(user.getUsername());
        user.setFullName(user.getFullName());
        user.setPassword(encoder.encode(userDto.getPassword()));
        return userRepository.save(user);
    }

    public UserEntity findById(UUID id){
        return userRepository.findById(id).get();
    }

    public UserEntity findByUsername(String username){
        return userRepository.findByUsername(username);
    }

    public void deleteUser(UUID id){
        userRepository.deleteById(id);
    }

}
