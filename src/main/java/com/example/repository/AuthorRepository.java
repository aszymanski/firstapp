package com.example.repository;

import com.example.domain.Author;
import org.springframework.data.repository.CrudRepository;

import java.math.BigInteger;

public interface AuthorRepository extends CrudRepository<Author, BigInteger>{
}
