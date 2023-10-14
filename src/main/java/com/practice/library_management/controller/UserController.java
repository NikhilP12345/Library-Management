package com.practice.library_management.controller;

import com.practice.library_management.models.dto.user.CreateUserDto;
import com.practice.library_management.models.dto.user.GetUserDto;
import com.practice.library_management.models.entity.User.dao.User;
import com.practice.library_management.services.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/user")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public String createUser(@RequestBody CreateUserDto createUserDto) throws Exception {
        this.userService.createUserAndSave(createUserDto);
        return "successfully created";
    }

    @GetMapping("/{username}")
    public User getUser(@PathVariable String username) throws Exception {
        return this.userService.getUserByUsername(GetUserDto.builder().username(username).build());
    }
}
