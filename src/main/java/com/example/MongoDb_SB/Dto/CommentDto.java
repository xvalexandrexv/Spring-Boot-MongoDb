package com.example.MongoDb_SB.Dto;

import java.util.Date;

public class CommentDto {
    private String text;
    private Date date;
    private AuthorDto authorDto;

    public CommentDto() {

    }
    public CommentDto(String text, Date date, AuthorDto authorDto) {
        this.text = text;
        this.date = date;
        this.authorDto = authorDto;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public AuthorDto getAuthorDto() {
        return authorDto;
    }

    public void setAuthorDto(AuthorDto authorDto) {
        this.authorDto = authorDto;
    }
}
