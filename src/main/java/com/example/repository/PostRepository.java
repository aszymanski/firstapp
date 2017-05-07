package com.example.repository;

import com.example.domain.Post;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by adria on 06.05.2017.
 */
public interface PostRepository extends CrudRepository<Post, Long>{
}
