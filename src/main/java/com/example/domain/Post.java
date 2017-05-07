package com.example.domain;

import org.springframework.data.annotation.CreatedDate;
import javax.persistence.*;
import java.util.Date;

/**
 * Created by adria on 06.05.2017.
 */
@Entity
public class Post {

    @Id @GeneratedValue
    private Long id;
    private String title;

    @Column(columnDefinition = "TEXT")
    private String body;

    private Date postedOn;

    @ManyToOne
    private Author author;


    //private no arg constructor is needed by JPA
//    private Post(){
//
//    }

    public Post(){

    }

    public Post(String title){
        this.setTitle(title);
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

    public Date getPostedOn() {
        return postedOn;
    }

    public void setPostedOn(Date postedOn) {
        this.postedOn = postedOn;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Post{" +
                "title='" + title + '\'' +
                "body='" + body + '\'' +
                '}';
    }
}
