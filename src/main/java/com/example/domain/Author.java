package com.example.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by adria on 06.05.2017.
 */
@Document
public class Author {

    @Id
    private BigInteger id;
    private String firstName;
    private String lastName;
    private String email;

    @DBRef
    private List<Post> posts;


    public Author(){
        posts = new ArrayList<Post>();
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Author [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
    }
}
