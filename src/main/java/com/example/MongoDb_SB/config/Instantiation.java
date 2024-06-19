package com.example.MongoDb_SB.config;

import com.example.MongoDb_SB.Dto.AuthorDto;
import com.example.MongoDb_SB.Dto.CommentDto;
import com.example.MongoDb_SB.model.Post;
import com.example.MongoDb_SB.model.User;
import com.example.MongoDb_SB.repository.PostRepository;
import com.example.MongoDb_SB.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Filomena", "maria@gmail.com", "122");
        User alex = new User(null, "Alex Pereira", "alex@gmail.com", "121");
        User bob = new User(null, "Joao Miguel", "bob@gmail.com", "123");
        User soja = new User(null, "Soja ya", "soja@gmail.com", "126");

        userRepository.saveAll(Arrays.asList(maria, alex, bob, soja));


        Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu Viagem", "Vou partir para São Paulo. Abraços!", new AuthorDto(maria));
        Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz!", new AuthorDto(maria));

        CommentDto c1 = new CommentDto("Boa viagem!", sdf.parse("21/10/2018"), new AuthorDto(alex));
        CommentDto c2 = new CommentDto("Aproveite!", sdf.parse("23/10/2018"), new AuthorDto(bob));
        CommentDto c3 = new CommentDto("Tenho um optimo dia", sdf.parse("24/10/2018"), new AuthorDto(alex));

        post1.getCommentDto().addAll(Arrays.asList(c1, c2));
        post2.getCommentDto().addAll(Arrays.asList(c3));


        postRepository.saveAll(Arrays.asList(post1, post2));

        maria.getPosts().addAll(Arrays.asList(post1, post2));

        userRepository.save(maria);

    }
}
