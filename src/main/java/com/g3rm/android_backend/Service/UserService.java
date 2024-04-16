package com.g3rm.android_backend.Service;

import com.g3rm.android_backend.Model.User;
import com.g3rm.android_backend.Repository.UserRepo;
import com.g3rm.android_backend.Service.Implements.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserServiceImpl {
    private final UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo){
        this.userRepo = userRepo;
    }
    @Override
    public User createUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public User getUserById(String id) {
        return userRepo.findById(id).orElse(null);
    }

    @Override
    public String getUserByName(User user) {
        User existingUser = userRepo.findByUsername(user.getUsername());
        if (existingUser != null && existingUser.getPasswd().equals(user.getPasswd())) {
            return existingUser.getUsername();
        } else {
            return "Fail";
        }
    }

    @Override
    public void deleteUserById(String id) {
        userRepo.deleteById(id);
    }
}