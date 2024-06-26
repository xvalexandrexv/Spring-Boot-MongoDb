package com.example.MongoDb_SB.services;

import com.example.MongoDb_SB.model.Post;
import com.example.MongoDb_SB.model.User;
import com.example.MongoDb_SB.repository.PostRepository;
import com.example.MongoDb_SB.services.serviceException.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    PostRepository postRepository;

    public Post findById(String id) {

        Optional<Post> postOptional = postRepository.findById(id);
        if (postOptional.isPresent()) {
            return postOptional.get();
        } else {
            throw new ObjectNotFoundException("Obj not found");
        }
    }

    public List<Post> findByTitle(String text) {
        return postRepository.searchTitle(text);
    }

    public List<Post> fullSearch(String text, Date min, Date max) {
        max = new Date(max.getTime() + 24 * 60 * 60 * 1000);
        return postRepository.fullSerach(text, min, max);
    }


    public List<Post> findAll() {
        return postRepository.findAll();
    }




}
