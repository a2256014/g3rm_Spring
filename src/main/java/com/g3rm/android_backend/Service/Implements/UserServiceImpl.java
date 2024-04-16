package com.g3rm.android_backend.Service.Implements;

import com.g3rm.android_backend.Model.User;
import java.util.List;

public interface UserServiceImpl {
    User createUser(User user);
    List<User> getAllUsers();
    User getUserById(String id);

    String getUserByName(User user);

    void deleteUserById(String id);
}