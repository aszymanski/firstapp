package com.example.controller;
import com.example.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;


@Controller
@RequestMapping("/posts")
public class PostController {

    private PostService postService;

    @Autowired
    public PostController(PostService postService){
        this.postService = postService;
    }

    @RequestMapping("")
    public String listPosts(Model model){
        model.addAttribute("posts",postService.list());
        return "views/posts/list";
    }


    @RequestMapping("/view/{slug}")
    public String view(@PathVariable(value="slug") String slug, Model model){

        if(postService.getBySlug(slug)==null) {
            throw new ResourceNotFoundException();
        }
            model.addAttribute("post", postService.getBySlug(slug));
            return "views/posts/single";

    }

    @RequestMapping("/last")
    public String viewLast(Model model){
        model.addAttribute("posts",postService.list());
        model.addAttribute("post", postService.getLatestPost());
        return "views/single";
    }





}
