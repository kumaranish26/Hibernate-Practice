package com.anish.sample.controller;

import com.anish.sample.entity.User;
import com.anish.sample.service.UserService;
import lombok.Getter;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class UserController
{
    private UserService userService;
    public UserController(UserService userService)
    {
        this.userService=userService;
    }
    @PostMapping("/users")
    public String addUser(@RequestBody User user)
    {
        userService.addUser(user);
        return "User Added Successfully";
    }

    @GetMapping("/users/{userId}/profile-city")
    public Map<String, String> getProfileCity(@PathVariable Long userId)
    {
       return Map.of("city", userService.getProfileCity(userId));
    }

    @GetMapping("/users/{profileId}/username")
    public Map<String, String> getUsername(@PathVariable Long profileId)
    {
        return Map.of("Username ",userService.getUsername(profileId));
    }
}
