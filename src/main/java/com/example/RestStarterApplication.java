package com.example;

import com.example.domain.Post;
import com.example.repository.PostRepository;
import com.example.service.DataLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;


@EnableAutoConfiguration
@SpringBootApplication
public class RestStarterApplication {

	private static final Logger logger = LoggerFactory.getLogger(RestStarterApplication.class);
	//Post repository
	@Autowired
	PostRepository postRepository;

	@Autowired
	DataLoader dataLoader;

	public static void main(String[] args) {
		SpringApplication.run(RestStarterApplication.class, args);
	}

	//Post Construct
	@PostConstruct
	void seePosts(){
		logger.info("seePosts: method results");
		for(Post post : postRepository.findAll()){
			logger.info(post.toString());
		}

	}
}
