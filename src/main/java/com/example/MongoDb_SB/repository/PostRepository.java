package com.example.MongoDb_SB.repository;

import com.example.MongoDb_SB.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, String> {
}
