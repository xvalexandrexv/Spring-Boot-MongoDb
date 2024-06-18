package com.example.MongoDb_SB.repository;

import com.example.MongoDb_SB.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

}
