package com.project.test.controller;

import com.project.test.dto.UserDto;
import com.project.test.entities.UserEntity;
import com.project.test.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public UserEntity register(@RequestBody UserDto userDto){
        return userService.createUser(userDto);
    }

    @PutMapping("/update")
    public UserEntity update(@RequestBody UserDto userDto){
        return userService.updateUser(userDto);
    }

    @GetMapping("/detail-by-username")
    public UserEntity findByUsername(@RequestParam String username){
        return userService.findByUsername(username);
    }

    @GetMapping("/detail-by-id")
    public UserEntity findById(@RequestParam UUID id){
        return userService.findById(id);
    }

    @DeleteMapping("/delete")
    public void deleteUser(@RequestParam UUID id){
        userService.deleteUser(id);
    }

}
