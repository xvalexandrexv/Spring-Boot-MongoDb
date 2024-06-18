package com.example.MongoDb_SB.Dto;

import com.example.MongoDb_SB.model.User;

import java.io.Serializable;

public class UserDto implements Serializable {

    // obj de tranferencia de dados como podemos ver aqui uma das vantagens
    // o User tem 4 atributos mas so vou fazer um DTO com 3 atributos a serem
    // apredentados, apesar de que la na base de dados estejam os 4 atributos
    // mas para o usuario so vou apresentar 3.

    private String id;
    private String name;
    private String email;


    public UserDto() {

    }

    public UserDto(User obj) {
        id = obj.getId();
        name = obj.getName();
        email = obj.getEmail();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
