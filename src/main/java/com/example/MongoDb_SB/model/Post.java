package com.example.MongoDb_SB.model;

import com.example.MongoDb_SB.Dto.AuthorDto;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Document // vai ser uma coleçao ou documento
public class Post implements Serializable {

    @Id
    private String id;
    private Date date;
    private String title;
    private String body;
    /* private User author; //  podia ter ficado o user so que nos nao queremos no construtor o User pois o user
    possui demasiados atributos logo criamos praticamente um Dto de User chamado
    AuthorDto onde apresentamos so os atributod que queremos neste caso so o nome */

    private AuthorDto author;

    public Post() {

    }

    public Post(String id, Date date, String title, String body, AuthorDto author) { //

        this.id = id;
        this.date = date;
        this.title = title;
        this.body = body;
        this.author = author;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public AuthorDto getAuthor() {
        return author;
    }

    public void setAuthor(AuthorDto author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Post post)) return false;
        return Objects.equals(id, post.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
