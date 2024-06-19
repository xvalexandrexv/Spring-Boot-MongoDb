package com.example.MongoDb_SB.config;

public class OBS {

    /*

   1 - Importante reter que fizemos o User ou AuthorDto(que é um dto do user)
    estar alinhado com os posts ou seja podemos ver que no Instantiation, no momento de
    instanciar os objetos de Post, os new post têm um authorDto dento, ou seja
    na base de dados vai criar uma copia do AuthorDto

   2 - Agora nos Post podiamos ter tambem so as referencias(ou seja os ids usuarios que comentaram)
   para o User em vez do objeto User completo(AuthorDto) com os atributos.

   No meu caso fiz o User possuir uma lista de refrencias da coleçao dos Post que ela mesmo publicou,
   ou seja o User conhece as publicaçoes que a mesma fez.


    */

}
