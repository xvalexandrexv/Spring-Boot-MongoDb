package com.example.MongoDb_SB.web;

import com.example.MongoDb_SB.Dto.UserDto;
import com.example.MongoDb_SB.model.User;
import com.example.MongoDb_SB.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users") // caminho do endpoint no browser
public class UserResource {     // OBS: endpoint é o caminho que vamos buscar site ex: localhost/8080/users


    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    //este vai ser um metodo que pode/vai ser usado do endpoint users no browser  e o metodo rest a ser usado que vai ser usado é o GET
    public ResponseEntity<List<UserDto>> findAll() {

        // OBS: isto funciona como e por camadas vou agora refracturar o codigo para que converse com o serviço
        //User maria = new User("1", "Maria Brown", "maria@gmail.com");
        //User alex = new User("2", "Alex Green", "alex@gmail.com");
        //List<User> users = new ArrayList<>();
        // users.addAll(Arrays.asList(maria, alex));

        List<User> users = userService.findAll();
        //List<UserDto> usersDto = users.stream().map(x -> new UserDto(x)).collect(Collectors.toList());

        List<UserDto> usersDto = new ArrayList<>();

        for (User x : users) {
            usersDto.add(new UserDto(x));
        }
        return ResponseEntity.ok().body(usersDto);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<UserDto> findById(@PathVariable String id) {
        User obj = userService.findById(id);
        return ResponseEntity.ok().body(new UserDto(obj));
    }

    @RequestMapping(method = RequestMethod.POST) // @PostMapping
    public ResponseEntity<Void> insert(@RequestBody UserDto objDto) {
        User user = userService.fromDto(objDto); //1 - primeiro convertemos o dto para user
        user = userService.insert(user); // 2 - depois inserimos o user
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable String id) {
        userService.delete(id);
        return ResponseEntity.noContent().build(); // para retornar uma resposta 204
    }

}
