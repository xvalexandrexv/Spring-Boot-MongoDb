package com.example.MongoDb_SB.web;

import com.example.MongoDb_SB.model.User;
import com.example.MongoDb_SB.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/users") // caminho do endpoint no browser
public class UserResource {     // OBS: endpoint é o caminho que vamos buscar site ex: localhost/8080/users


    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET) //este vai ser um metodo que pode/vai ser usado do endpoint users no browser  e o metodo rest a ser usado que vai ser usado é o GET
    public ResponseEntity<List<User>> findAll() {

        // OBS: isto funciona como e por camadas vou agora refracturar o codigo para que converse com o serviço
        //User maria = new User("1", "Maria Brown", "maria@gmail.com");
        //User alex = new User("2", "Alex Green", "alex@gmail.com");
        //List<User> users = new ArrayList<>();
        // users.addAll(Arrays.asList(maria, alex));

        List<User> users = userService.findAll();

        return ResponseEntity.ok().body(users);
    }

}
