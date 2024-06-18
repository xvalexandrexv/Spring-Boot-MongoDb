package com.example.MongoDb_SB.config;

import com.example.MongoDb_SB.model.User;
import com.example.MongoDb_SB.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll(); // para primeiro deletar td que estiver la no mongodb

        User maria = new User(null, "Maria Brown", "maria@gmail.com", "122");
        User alex = new User(null, "Alex Green", "alex@gmail.com", "121");
        User bob = new User(null, "Bob Grey", "bob@gmail.com", "123");
        User soja = new User(null, "soja Grey", "soja@gmail.com", "126");

        userRepository.saveAll(Arrays.asList(maria, alex, bob, soja));

    }
}
