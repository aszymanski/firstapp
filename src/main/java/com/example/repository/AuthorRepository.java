package com.example.repository;

import com.example.domain.Author;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by adria on 06.05.2017.
 */
public interface AuthorRepository extends CrudRepository<Author, Long>{
}
