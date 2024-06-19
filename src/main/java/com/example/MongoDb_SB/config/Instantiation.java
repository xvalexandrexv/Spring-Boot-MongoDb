package com.example.MongoDb_SB.config;

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

        userRepository.deleteAll(); // para primeiro deletar td que estiver la no mongodb
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com", "122");
        User alex = new User(null, "Alex Green", "alex@gmail.com", "121");
        User bob = new User(null, "Bob Grey", "bob@gmail.com", "123");
        User soja = new User(null, "soja Grey", "soja@gmail.com", "126");

        Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu Viagem", "Vou partir para São Paulo. Abraços!", maria);
        Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz!", maria);
        // assim criamos um post com uma copia do objeto maria la na base de dados 

        userRepository.saveAll(Arrays.asList(maria, alex, bob, soja));
        postRepository.saveAll(Arrays.asList(post1, post2));

    }
}
