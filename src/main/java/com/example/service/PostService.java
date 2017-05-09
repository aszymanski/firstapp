package com.example.service;


import com.example.domain.Post;
import com.example.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {
    private PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository){
        this.postRepository = postRepository;
    }

    public Post getLatestPost(){
        return postRepository.findFirstByOrderByPostedOnDesc();
    }

    public List<Post> list() {
        return postRepository.findAllByOrderByPostedOnDesc();
    }

    public Post getBySlug(String slug) {
        return postRepository.findBySlug(slug);
    }

}
