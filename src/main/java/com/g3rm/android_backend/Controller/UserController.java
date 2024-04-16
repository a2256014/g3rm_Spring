package com.g3rm.android_backend.Controller;

import com.g3rm.android_backend.Model.User;
import com.g3rm.android_backend.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/signup")
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable String id){
        return userService.getUserById(id);
    }

    @PostMapping("/signin")
    public String getUserByName(@RequestBody User user){
        return userService.getUserByName(user);
    }

//    @DeleteMapping("/{id}")
//    public void deleteUserById(@PathVariable String id){
//        userService.deleteUserById(id);
//    }
}