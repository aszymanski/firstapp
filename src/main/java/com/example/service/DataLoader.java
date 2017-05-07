package com.example.service;

import com.example.domain.Author;
import com.example.domain.Post;
import com.example.repository.AuthorRepository;
import com.example.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Date;

/**
 * Created by adria on 06.05.2017.
 */
@Service
public class DataLoader {
        private AuthorRepository authorRepository;
        private PostRepository postRepository;

        @Autowired
        public DataLoader(PostRepository postRepository, AuthorRepository authorRepository){
            this.postRepository = postRepository;
            this.authorRepository = authorRepository;
        }

        @PostConstruct
        private void loadData(){
            //create an author
            Author author = new Author("John","Snow");
            authorRepository.save(author);

            //Create a post
            Post post = new Post("Super spring data loading!");
            post.setBody("Body is here");
            post.setPostedOn(new Date());
            post.setAuthor(author);
            postRepository.save(post);

        }
}
