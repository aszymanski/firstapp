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

        Author dv2 = new Author();
        dv2.setFirstName("Mike");
        dv2.setLastName("Moore");
        dv2.setEmail("mmore@gmail.com");
        authorRepository.save( dv2 );

        postRepository.deleteAll();

        Post post = new Post();
        post.setTitle("Spring Data Rocks!");
        post.setSlug("spring-data-rocks");
        post.setTeaser(getPostTeaser());
        post.setBody(getPostBody());
        post.setPostedOn(new Date());
        post.setAuthor(dv);

        Post post2 = new Post();
        post2.setTitle("Spring Data Rocks! 2");
        post2.setSlug("spring-data-rocks2");
        post2.setTeaser(getPostTeaser());
        post2.setBody(getPostBody());
        post2.setPostedOn(new Date());
        post2.setAuthor(dv2);

        Post post3 = new Post();
        post3.setTitle("Spring Data Rocks! 3");
        post3.setSlug("spring-data-rocks3");
        post3.setTeaser(getPostTeaser());
        post3.setBody(getPostBody());
        post3.setPostedOn(new Date());
        post3.setAuthor(dv);


        postRepository.save(post);
        postRepository.save(post2);
        postRepository.save(post3);

        dv.getPosts().add(post);
        authorRepository.save( dv );

    }

    public String getPostBody(){

        String body = "<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. In ac finibus mi. Morbi porttitor urna dui, sed volutpat justo rutrum sit amet. Etiam elementum lacus eget malesuada egestas. Sed id lectus arcu. Pellentesque molestie dignissim diam non commodo. Nunc nec aliquet lectus. Ut a accumsan sapien. Pellentesque sit amet sem nisl. Nulla fringilla vulputate mauris, eleifend dapibus libero. Sed eu cursus orci. In hac habitasse platea dictumst. Vestibulum vel vulputate ex. Nam gravida blandit nisl, at luctus mi interdum ut. Pellentesque et pharetra mi. Proin id placerat diam. Ut porttitor risus in leo tincidunt, a iaculis velit maximus.</p>";
        body+= "<p>Nunc bibendum sollicitudin ex, vitae lobortis nunc malesuada eget. Maecenas aliquam aliquam elit, nec rutrum justo blandit sit amet. Cras pellentesque egestas nisi at egestas. Donec lacus ipsum, dignissim a accumsan quis, rutrum ac massa. Vivamus sed dolor nisl. Integer convallis, elit sed euismod molestie, purus velit ornare justo, ac maximus diam odio id felis. Maecenas auctor sed quam ac aliquet. Curabitur tempus sed purus sit amet blandit.</p>";
        return body;
    }

    public String getPostTeaser(){

        String teaser = "<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. In ac finibus mi. Morbi porttitor urna dui, sed volutpat justo rutrum sit amet. Etiam elementum lacus eget malesuada egestas. Sed id lectus arcu. Pellentesque molestie dignissim diam non commodo. Nunc nec aliquet lectus. Ut a accumsan sapien. Pellentesque sit amet sem nisl. Nulla fringilla vulputate mauris, eleifend dapibus libero. Sed eu cursus orci. In hac habitasse platea dictumst. Vestibulum vel vulputate ex. Nam gravida blandit nisl, at luctus mi interdum ut. Pellentesque et pharetra mi. Proin id placerat diam. Ut porttitor risus in leo tincidunt, a iaculis velit maximus.</p>";
        return teaser;
    }
}
