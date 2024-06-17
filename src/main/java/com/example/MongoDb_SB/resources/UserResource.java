package com.example.MongoDb_SB.resources;

import com.example.MongoDb_SB.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users") // caminho do endpoint no browser
public class UserResource {

    // OBS: endpoint é o caminho que vamos buscar site ex: localhost/8080/users

    @RequestMapping(method = RequestMethod.GET) //
    // este vai ser um metodo que pode/vai ser usado do endpoint users no browser
    // e o metodo rest a ser usado que vai ser usado é o GET
    public ResponseEntity<List<User>> findAll() {
        User maria = new User("1", "Maria Brown", "maria@gmail.com");
        User alex = new User("2", "Alex Green", "alex@gmail.com");
        List<User> users = new ArrayList<>();

        users.addAll(Arrays.asList(maria, alex));

        return ResponseEntity.ok().body(users);
    }

}
