package com.example.MongoDb_SB.repository;

import com.example.MongoDb_SB.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.lang.annotation.Native;
import java.util.Date;
import java.util.List;

public interface PostRepository extends MongoRepository<Post, String> {

    List<Post> findByTitleContaining(String text);

    @Query("{ 'title': { $regex: ?0, $options: 'i' } }")
    List<Post> searchTitle(String text);

    @Query("{ $and: [ { date: {$gte: ?1} }, { date: { $lte: ?2} } , { $or: [ { 'title': { $regex: ?0, $options: 'i' } }, { 'body': { $regex: ?0, $options: 'i' } }, { 'comments.text': { $regex: ?0, $options: 'i' } } ] } ] }")
    List<Post> fullSerach(String text, Date minDate, Date maxDate);

}
