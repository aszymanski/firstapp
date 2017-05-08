package com.example;

import com.example.domain.Author;
import com.example.domain.Post;
import com.example.repository.AuthorRepository;
import com.example.repository.PostRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Date;

/**
 * Created by aszymanski on 5/8/2017.
 */
@Service
public class DatabaseLoader {

    private static final Logger logger = LoggerFactory.getLogger(RestStarterApplication.class);
    private final PostRepository postRepository;
    private final AuthorRepository authorRepository;

    @Autowired
    public DatabaseLoader(PostRepository postRepository,AuthorRepository authorRepository){
        this.postRepository = postRepository;
        this.authorRepository = authorRepository;
    }

    @PostConstruct
    private void initDatabase(){

        authorRepository.deleteAll();

        Author dv = new Author();
        dv.setFirstName("John");
        dv.setLastName("Snow");
        dv.setEmail("pinktown@gmail.com");
        authorRepository.save( dv );

        postRepository.deleteAll();

        Post post = new Post();
        post.setTitle("Spring Data Rocks!");
        post.setSlug("spring-data-rocks");
        post.setTeaser("Post Teaser");
        post.setBody("Post Body");
        post.setPostedOn(new Date());
        post.setAuthor(dv);
        postRepository.save(post);

        dv.getPosts().add(post);
        authorRepository.save( dv );

    }
}
