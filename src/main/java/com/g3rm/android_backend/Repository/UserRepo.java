package com.g3rm.android_backend.Repository;

import com.g3rm.android_backend.Model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends MongoRepository<User, String> {
    User findByUsername(String name);
}