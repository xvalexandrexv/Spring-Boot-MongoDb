package com.example.MongoDb_SB.repository;

import com.example.MongoDb_SB.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.lang.annotation.Native;
import java.util.Date;
import java.util.List;

public interface PostRepository extends MongoRepository<Post, String> {
    // OBS importante: podemos fazer queries para buscar dados especificos no MongoDb
    // podemos consultar aqui os diversos queries no site https://docs.spring.io/spring-data/mongodb/reference/repositories/query-methods-details.html#repositories.collections-and-iterables



    List<Post> findByTitleContaining(String text); // tem que ser esse nome para que o spring saiba o que fazer

    @Query("{ 'title': { $regex: ?0, $options: 'i' } }")  // a procura vai ser pelo title o regex é ?0 porque a funçao so recebe 1 parametro o text na posiçao 0 como podemos ver, o options é i para ignorar minusculos e maiusculos, tem outros opstions no site e so ver o que cada um faz
    List<Post> searchTitle(String text); // este como tem a anotaçao @Query pode ter o nome que qisermos

    @Query("{ $and: [ { date: {$gte: ?1} }, { date: { $lte: ?2} } , { $or: [ { 'title': { $regex: ?0, $options: 'i' } }, { 'body': { $regex: ?0, $options: 'i' } }, { 'comments.text': { $regex: ?0, $options: 'i' } } ] } ] }")
    List<Post> fullSerach(String text, Date minDate, Date maxDate);

}
