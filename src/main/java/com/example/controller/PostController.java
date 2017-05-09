package com.example.controller;
import com.example.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


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
        return "views/list";
    }

    @RequestMapping("/view/{slug}")
    public String view(@PathVariable(value="slug") String slug, Model model){
        model.addAttribute("post", postService.getBySlug(slug));
        return "views/single";
    }

    @RequestMapping("/last")
    public String viewLast(Model model){
        model.addAttribute("posts",postService.list());
        model.addAttribute("post", postService.getLatestPost());
        return "views/single";
    }



}
